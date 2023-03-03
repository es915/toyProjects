package com.example.board.dto;

import com.example.board.entity.BoardEntity;
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

    public static BoardDTO toBoardDTO(BoardEntity boardEntity) {
        return new BoardDTO(
            boardEntity.getId(),
            boardEntity.getBoardWriter(),
            boardEntity.getBoardPass(),
            boardEntity.getBoardTitle(),
            boardEntity.getBoardContents(),
            boardEntity.getBoardHits(),
            boardEntity.getCreatedTime(),
            boardEntity.getUpdatedTime()
        );
    }

}
