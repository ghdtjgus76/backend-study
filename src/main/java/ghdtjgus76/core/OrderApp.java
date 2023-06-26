package ghdtjgus76.core;

import ghdtjgus76.core.member.Grade;
import ghdtjgus76.core.member.Member;
import ghdtjgus76.core.member.MemberService;
import ghdtjgus76.core.member.MemberServiceImpl;
import ghdtjgus76.core.order.Order;
import ghdtjgus76.core.order.OrderService;
import ghdtjgus76.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}