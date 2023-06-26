package ghdtjgus76.core.order;

import ghdtjgus76.core.discount.DiscountPolicy;
import ghdtjgus76.core.discount.FixDiscountPolicy;
import ghdtjgus76.core.member.Member;
import ghdtjgus76.core.member.MemberRepository;
import ghdtjgus76.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}