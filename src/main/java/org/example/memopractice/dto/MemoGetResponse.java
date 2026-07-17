package org.example.memopractice.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemoGetResponse {
    private final Long id;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public MemoGetResponse(Long id, String content, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
