package com.inflearn.core.discount;

import com.inflearn.core.member.Member;

public interface DiscountPolicy {
    /**
     * @return 멤버의 등급에 따라 할인된 가격을 반환한다.
     */
    int discount(Member member, int price);
}
