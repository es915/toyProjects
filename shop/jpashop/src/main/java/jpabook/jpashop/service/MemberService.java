package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // RequiredArgsConstructor 어노테이션으로 final이 붙은 객체만 따로 생성자를 만들어줌
//    @Autowired
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    // 회원 가입
    @Transactional
    public Long join(Member member) {

        validateDuplicateMember(member); // 중복 회원 검증

        memberRepository.save(member);

        return member.getId();
    }


    // 중복 예외 처리
    private void validateDuplicateMember(Member member) {
        // EXCEPTION - 예외 처리
        List<Member> finMembers = memberRepository.findByName(member.getName());
        if (!finMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회 - 읽어 오는 데이터는 readOnly를 넣어줘야 성능 최적화가 됨
    @Transactional(readOnly = true)
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 회원 하나 조회
    @Transactional(readOnly = true)
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }


}
