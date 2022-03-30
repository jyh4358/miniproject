package com.board.miniproject.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@ToString
public class GuestBookDto {
    private Long gno;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate, modDate;

    @Builder
    public GuestBookDto(Long gno, String title, String content, String writer, LocalDateTime regDate, LocalDateTime modDate) {
        this.gno = gno;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.regDate = regDate;
        this.modDate = modDate;
    }
}
