package com.example.board.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {
    @CreationTimestamp // 만들때 타임을 찍는 어노테이션
    @Column(updatable = false) // 업데이트를 할땐 관여하지 않게
    private LocalDateTime createdTime;

    @UpdateTimestamp // 수정할때 타임을 찍는 어노테이션
    @Column(insertable = false) // 인설트 (만들어질때) 관여하지 않게
    private LocalDateTime updatedTime;

}
