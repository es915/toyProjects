package com.example.board.dto;

import lombok.*;

import java.time.LocalDateTime;

// DTO (Data Transfer Object) 데이터를 전송할 때 사용하는 객체
@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits;
    private LocalDateTime boardCreatedTime;
    private LocalDateTime boardUpdatedTime;

}
