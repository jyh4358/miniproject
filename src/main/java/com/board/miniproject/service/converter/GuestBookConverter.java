package com.board.miniproject.service.converter;

import com.board.miniproject.domain.GuestBook;
import com.board.miniproject.dto.GuestBookDto;
import org.springframework.stereotype.Component;

@Component
public class GuestBookConverter {

    public GuestBook convertToEntity(GuestBookDto dto) {
        return GuestBook.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
    }

    public GuestBookDto convertToListDto(GuestBook entity) {
        return GuestBookDto.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getMoDate())
                .build();


    }


}
