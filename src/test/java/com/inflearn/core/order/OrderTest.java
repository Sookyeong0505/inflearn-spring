package com.inflearn.core.order;

import com.inflearn.core.member.Grade;
import com.inflearn.core.member.Member;
import com.inflearn.core.member.MemberService;
import com.inflearn.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class OrderTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();


    @Test
    void createOrder() {
        // given
        // 1. 멤버 생성 후 저장
        long memberId = 1L;
        Member newMember = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(newMember);

        // when
        // 2. 주문 생성
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // then
        // 3. 주문 생성 후 할인된 가격이 맞는지 확인
        Assertions.assertThat(order.calculatePrice()).isEqualTo(1000);

    }

}