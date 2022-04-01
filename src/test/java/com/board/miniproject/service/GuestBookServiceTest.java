package com.board.miniproject.service;

import com.board.miniproject.domain.GuestBook;
import com.board.miniproject.dto.GuestBookDto;
import com.board.miniproject.dto.PageRequestDto;
import com.board.miniproject.dto.PageResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.lang.model.SourceVersion;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuestBookServiceTest {

    @Autowired
    private GuestBookService guestBookService;

    @Test
    @Rollback(value = false)
    public void testRegister() {
        GuestBookDto guestBookDto = GuestBookDto.builder()
                .title("Sample Title")
                .content("Sample Content")
                .writer("user0")
                .build();

        System.out.println(guestBookService.register(guestBookDto));
    }

    @Test
    public void testList() {
        PageRequestDto pageRequestDto = PageRequestDto.builder()
                .page(1)
                .size(10)
                .build();

        PageResponseDto<GuestBookDto, GuestBook> resultDto = guestBookService.getList(pageRequestDto);

        for (GuestBookDto guestBookDto : resultDto.getDtoList()) {

            System.out.println("guestBookDto = " + guestBookDto);
        }
    }

    @Test
    public void testPage() {
        PageRequestDto pageRequestDto = PageRequestDto.builder().page(1).size(10).build();

        PageResponseDto<GuestBookDto, GuestBook> resultDto = guestBookService.getList(pageRequestDto);

        System.out.println("PREV" + resultDto.isPrev());
        System.out.println("NEXT" + resultDto.isNext());
        System.out.println("TOTAL" + resultDto.getTotalPage());

        System.out.println("----------------------------");
        for (GuestBookDto guestBookDto : resultDto.getDtoList()) {
            System.out.println("guestBookDto = " + guestBookDto);
        }

        System.out.println("============================");
        resultDto.getPageList().forEach(i -> System.out.println("i = " + i));

    }
}