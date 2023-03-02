package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board") // 아래 매핑주소 앞에 붙는 주소
public class BoardController {
    @GetMapping("/save") // RequestMapping 덕에 /board/save 주소가 됨
    public String saveForm() {
        return "save";
    }
}
