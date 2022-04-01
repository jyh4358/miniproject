package com.board.miniproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Getter @Setter
@ToString
public class PageRequestDto {

    private int page;
    private int size;
    private String type;
    private String keyword;


    public PageRequestDto() {
        this.page = 1;
        this.size = 10;
    }

    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page - 1, size, sort);
    }

    @Builder

    public PageRequestDto(int page, int size, String type, String keyword) {
        this.page = page;
        this.size = size;
        this.type = type;
        this.keyword = keyword;
    }
}
