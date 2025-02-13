package com.inflearn.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given
        // 1. 멤버를 생성.
        Member member = new Member(1L, "memberA", Grade.VIP);
        // when
        // 2. 멤버를 저장.
        memberService.join(member);
        // 3. 저장한 멤버를 조회.
        Member findMember = memberService.findMember(1L);

        // then
        // 4. 저장한 멤버와 조회한 멤버가 같은지 확인.
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
