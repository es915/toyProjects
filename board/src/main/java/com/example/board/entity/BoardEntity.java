package com.example.board.entity;

import com.example.board.dto.BoardDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// DB의 테이블 역할을 하는 클래스
@Entity
@Getter
@Table(name="board_table")
@NoArgsConstructor
public class BoardEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String boardWriter;

    @Column(nullable = false)
    private String boardPass;

    @Column(nullable = false)
    private String boardTitle;

    @Column(nullable = false, length = 500)
    private String boardContents;

    @Column(nullable = false)
    private int boardHits;

    public static BoardEntity toSaveEntity(BoardDTO boardDTO) {
        return new BoardEntity(
                boardDTO.getBoardWriter(),
                boardDTO.getBoardPass(),
                boardDTO.getBoardTitle(),
                boardDTO.getBoardContents()
        );
    }

    private BoardEntity(String boardWriter, String boardPass, String boardTitle, String boardContents) {
        this.boardWriter = boardWriter;
        this.boardPass = boardPass;
        this.boardTitle = boardTitle;
        this.boardContents = boardContents;
        this.boardHits = 0; // 디폴트 값
    }

}
