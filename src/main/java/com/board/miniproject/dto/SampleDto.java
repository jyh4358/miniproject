package com.board.miniproject.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SampleDto {
    private Long sno;
    private String first;
    private String last;
    private LocalDateTime regTime;

    @Builder
    public SampleDto(Long sno, String first, String last, LocalDateTime regTime) {
        this.sno = sno;
        this.first = first;
        this.last = last;
        this.regTime = regTime;
    }
}
