package com.example.board.controller;

import com.example.board.dto.BoardDTO;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board") // 아래 매핑주소 앞에 붙는 주소
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/save") // RequestMapping 덕에 /board/save 주소가 됨
    public String saveForm() {
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) {
        boardService.save(boardDTO);
        return "index";
    }

    @GetMapping("/")
    public String findAll(Model model) { // 데이터를 가져올땐 Model 객체를 사용한다
        // DB에서 전체 게시글 데이터를 가져와서 list.html에 보여준다
        List<BoardDTO> boardDTOList= boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "list";
    }


}
