package com.board.miniproject.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter @Setter
public class PageResponseDto<Dto, EN> {

    private List<Dto> dtoList;

    public PageResponseDto(Page<EN> result, Function<EN, Dto> fn) {
        dtoList = result.stream().map(fn).collect(Collectors.toList());
    }
}
