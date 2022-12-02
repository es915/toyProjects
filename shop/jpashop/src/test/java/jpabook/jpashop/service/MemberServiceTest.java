package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
//    @Autowired EntityManager em;

    @Test
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("hwang");

        // when
        Long saveId = memberService.join(member);

        // then
//        em.flush(); // Transactional 떄문에 롤백이 되어 DB에 insert가 되지 않는 쿼리를 볼수 있게 해준다
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("hwang");
        Member member2 = new Member();
        member2.setName("hwang");

        // when
        memberService.join(member1);
        memberService.join(member2); // 예외가 발생해야 하고 해당 메소드를 탈출해야함

        // then
        Assert.fail("예외가 발생해야 한다."); // 예외 지점을 지나쳐 fail을 건드리면 오류 발생


    }

}