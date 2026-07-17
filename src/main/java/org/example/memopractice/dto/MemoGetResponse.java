package org.example.memopractice.dto;

import lombok.Getter;

@Getter
public class MemoGetResponse {
    private final Long id;
    private final String content;

    public MemoGetResponse(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
