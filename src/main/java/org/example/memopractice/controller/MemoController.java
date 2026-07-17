package org.example.memopractice.controller;

import lombok.RequiredArgsConstructor;
import org.example.memopractice.dto.*;
import org.example.memopractice.service.MemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/memos")
    public ResponseEntity<MemoCreateResponse> create(
            @RequestBody MemoCreateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memoService.create(request));
    }

    @GetMapping("/memos")
    public ResponseEntity<List<MemoGetResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body((memoService.getAll()));
    }

    @GetMapping("/memos/{memoId}")
    public ResponseEntity<MemoGetResponse> getOne(
            @PathVariable Long memoId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(memoService.getOne(memoId));
    }

    @PutMapping("/memos/{memoId}")
    public ResponseEntity<MemoUpdateResponse> update(
            @PathVariable Long memoId,
            @RequestBody MemoUpdateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(memoService.update(memoId, request));
    }

    @DeleteMapping("/memos/{memoId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long memoId
    ) {
        memoService.delete(memoId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
