package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@DiscriminatorValue("B") // Item 클래스의 dtype이 B일때 해당 엔티티 가져옴
public class Book extends Item{

    private String author;
    private String isbn;

}
