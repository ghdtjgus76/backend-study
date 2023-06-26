package ghdtjgus76.core;

import ghdtjgus76.core.discount.DiscountPolicy;
import ghdtjgus76.core.discount.FixDiscountPolicy;
import ghdtjgus76.core.member.MemberRepository;
import ghdtjgus76.core.member.MemberService;
import ghdtjgus76.core.member.MemberServiceImpl;
import ghdtjgus76.core.member.MemoryMemberRepository;
import ghdtjgus76.core.order.OrderService;
import ghdtjgus76.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}