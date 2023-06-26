package ghdtjgus76.core;

import ghdtjgus76.core.discount.DiscountPolicy;
import ghdtjgus76.core.discount.FixDiscountPolicy;
import ghdtjgus76.core.discount.RateDiscountPolicy;
import ghdtjgus76.core.member.MemberRepository;
import ghdtjgus76.core.member.MemberService;
import ghdtjgus76.core.member.MemberServiceImpl;
import ghdtjgus76.core.member.MemoryMemberRepository;
import ghdtjgus76.core.order.OrderService;
import ghdtjgus76.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}