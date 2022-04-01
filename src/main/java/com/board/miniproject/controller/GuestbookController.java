package com.board.miniproject.controller;

import com.board.miniproject.dto.GuestBookDto;
import com.board.miniproject.dto.PageRequestDto;
import com.board.miniproject.service.GuestBookService;
import com.board.miniproject.service.converter.GuestBookConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/guestbook")
@RequiredArgsConstructor
@Slf4j
public class GuestbookController {
    private final GuestBookService service;

    @GetMapping("/")
    public String index() {
        return "redirect:/guestbook/list";
    }

    @GetMapping("/list")
    public void list(PageRequestDto pageRequestDto, Model model) {
        log.info("list...................." + pageRequestDto);
        model.addAttribute("result", service.getList(pageRequestDto));
    }

    @GetMapping("/register")
    public void registerPost() {
        log.info("register get...");
    }

    @PostMapping("/register")
    public String registerPost(GuestBookDto dto, RedirectAttributes redirectAttributes) {
        log.info("dto={}", dto);
        Long gno = service.register(dto);

        redirectAttributes.addFlashAttribute("msg", gno);
        return "redirect:/guestbook/list";
    }

    @GetMapping("/read")
    public void read(long gno, @ModelAttribute("requestDTO") PageRequestDto requestDTO, Model model) {
        log.info("gno={}", gno );


        System.out.println("gno = " + gno);
        System.out.println(requestDTO);

        GuestBookDto dto = service.read(gno);
        System.out.println("dto = " + dto);

        model.addAttribute("dto", dto);
    }
}
