package com.inflearn.core;

import com.inflearn.core.member.Grade;
import com.inflearn.core.member.Member;
import com.inflearn.core.member.MemberService;
import com.inflearn.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        // 0. 멤버 서비스 생성 및 호출
        MemberService memberService = new MemberServiceImpl();

        // 1. 멤버 생성 후 저장
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // 2. 멤버 조회
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
