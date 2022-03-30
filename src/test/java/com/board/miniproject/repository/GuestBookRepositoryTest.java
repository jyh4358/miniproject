package com.board.miniproject.repository;

import com.board.miniproject.domain.GuestBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuestBookRepositoryTest {

    @Autowired
    private GuestBookRepository guestBookRepository;

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 300).forEach(i -> {
            GuestBook guestBook = GuestBook.builder()
                    .title("Title...." + i)
                    .content("Content...." + i)
                    .writer("user" + (i % 10))
                    .build();
            System.out.println(guestBookRepository.save(guestBook));
        });
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void updateTest() {
        Optional<GuestBook> result = guestBookRepository.findById(300L);

        if (result.isPresent()) {
            GuestBook guestBook = result.get();

            guestBook.changeTitle("Changed Title....");
            guestBook.changeContent("Changed Content");

        }
    }

}