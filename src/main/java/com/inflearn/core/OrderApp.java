package com.inflearn.core;

import com.inflearn.core.member.Grade;
import com.inflearn.core.member.Member;
import com.inflearn.core.member.MemberService;
import com.inflearn.core.member.MemberServiceImpl;
import com.inflearn.core.order.Order;
import com.inflearn.core.order.OrderService;
import com.inflearn.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        // 멤버 서비스와 주문 서비스 객체 생성 및 할당
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        // 멤버 생성 후 저장
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // 주문 생성
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);

    }
}
