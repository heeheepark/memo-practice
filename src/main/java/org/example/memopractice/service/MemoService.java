package org.example.memopractice.service;

import lombok.RequiredArgsConstructor;
import org.example.memopractice.MemoPracticeApplication;
import org.example.memopractice.dto.*;
import org.example.memopractice.entity.Memo;
import org.example.memopractice.repository.MemoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional
    public MemoCreateResponse create(MemoCreateRequest request) {
        Memo memo = new Memo(request.getContent());
        return new MemoCreateResponse(memo.getId(), memo.getContent());
    }

    @Transactional
    public List<MemoGetResponse> getAll() {
        List<Memo> memos = memoRepository.findAll();
        List<MemoGetResponse> dtos = new ArrayList<>();

        for (Memo memo : memos) {
            dtos.add(new MemoGetResponse(memo.getId(), memo.getContent()));
        }

        return dtos;
    }

    @Transactional
    public MemoGetResponse getOne(Long memoId) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalArgumentException("해당 메모가 없습니다.")
        );

        return new MemoGetResponse(memo.getId(), memo.getContent());
    }

    @Transactional
    public MemoUpdateResponse update(Long memoId, MemoUpdateRequest request) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalArgumentException("해당 메모가 없습니다.")
        );

        memo.update(request.getContent());
        return new MemoUpdateResponse(memo.getId(), memo.getContent());
    }

    public void delete(Long memoId) {
        boolean existence = memoRepository.existsById(memoId);
        if (!existence) {
            throw new IllegalArgumentException("해당 메모가 없습니다.");
        }

        memoRepository.deleteById(memoId);
    }
}
