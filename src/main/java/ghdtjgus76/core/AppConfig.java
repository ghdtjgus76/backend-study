package ghdtjgus76.core;

import ghdtjgus76.core.discount.FixDiscountPolicy;
import ghdtjgus76.core.member.MemberService;
import ghdtjgus76.core.member.MemberServiceImpl;
import ghdtjgus76.core.member.MemoryMemberRepository;
import ghdtjgus76.core.order.OrderService;
import ghdtjgus76.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}