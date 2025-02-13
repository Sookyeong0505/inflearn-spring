package com.inflearn.core.order;

import com.inflearn.core.discount.DiscountPolicy;
import com.inflearn.core.discount.FixDiscountPolicy;
import com.inflearn.core.member.Member;
import com.inflearn.core.member.MemberRepository;
import com.inflearn.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    // 주문 서비스를 제공하기 위해서는 멤버 서비스와 할인정책 서비스가 필요하다.

    // 멤버 서비스
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 할인정책 서비스
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 1. 회원을 조회.
        Member member = memberRepository.findById(memberId);
        // 2. 조회한 회원에 등급에 따라 할인정책을 적용.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
