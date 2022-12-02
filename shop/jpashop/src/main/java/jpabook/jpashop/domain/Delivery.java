package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // default 값을 쓰지않고 STRING으로 써야함
    private DeliveryStatus status; // READY, COMP
    // default값인 ordinal로 쓰면 숫자로 매칭이됨 -> 중간 값에 값이 생기면 숫자가 재정렬되어 1과 매핑되던 얘가 뒤로 밀려 2로 매핑이되는 문제 발생
}
