package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded // 내장타입이라는것을 명시
    private Address address;

    // 한 회원이 여러개의 상품을 주문 / 일 대 다 관계
    @OneToMany(mappedBy = "member") // mappedBy는 연관관계의 주인을 설정하는 것, 해당 값은 Order에 있는 member 값이 변할때 변경됨을 알림
    private List<Order> orders = new ArrayList<>(); // 여기 값이 변해도 order 테이블에 아무 영향이 없다는 뜻


}
