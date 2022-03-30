package com.board.miniproject.service;

import com.board.miniproject.domain.GuestBook;
import com.board.miniproject.dto.GuestBookDto;
import com.board.miniproject.dto.PageRequestDto;
import com.board.miniproject.dto.PageResponseDto;
import com.board.miniproject.repository.GuestBookRepository;
import com.board.miniproject.service.converter.GuestBookConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@Slf4j
@RequiredArgsConstructor
public class GuestBookService {

    private final GuestBookConverter guestBookConverter;
    private final GuestBookRepository guestBookRepository;

    public Long register(GuestBookDto dto) {

        log.info("DTO--------------------------");
        log.info("{}", dto);

        GuestBook entity = guestBookConverter.convertToEntity(dto);

        log.info("entity={}", entity);

        guestBookRepository.save(entity);

        return entity.getGno();
    }

    public PageResponseDto<GuestBookDto, GuestBook> getList(PageRequestDto requestDto) {
        Pageable pageable = requestDto.getPageable(Sort.by("gno").descending());
        Page<GuestBook> result = guestBookRepository.findAll(pageable);

        Function<GuestBook, GuestBookDto> fn = (entity -> guestBookConverter.convertToListDto(entity));

        return new PageResponseDto<>(result, fn);

    }


}
