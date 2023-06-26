package ghdtjgus76.core.discount;

import ghdtjgus76.core.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}