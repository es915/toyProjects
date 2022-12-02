package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    // value type은 값을 변경해서는 안됨
    // 처음 생성할때만 값이 설정되게만 해야됨
    protected Address() { // jpa에서 사용하기위한 기본생성자를 만들어줌, 사람들이 사용하는걸 방지하기 위한 protected로 생성
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
