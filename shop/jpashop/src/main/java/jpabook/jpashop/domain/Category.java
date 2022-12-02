package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany // 다 대 다 일경우 중간 테이블을 만들어줘야함, JoinColumn이 아닌 JoinTable 어노테이션 사용
    @JoinTable(name="category_item",
        joinColumns = @JoinColumn(name="category_id"), // 다 대 다 중간 테아블 넣기에서 각 테이블의 pk를 가져와 외래키로 사용
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    // 셀프 양방향 관계
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }


}


