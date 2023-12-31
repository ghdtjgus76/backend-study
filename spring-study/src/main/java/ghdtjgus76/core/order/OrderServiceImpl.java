package ghdtjgus76.core.order;

import ghdtjgus76.core.annotation.MainDiscountPolicy;
import ghdtjgus76.core.discount.DiscountPolicy;
import ghdtjgus76.core.discount.FixDiscountPolicy;
import ghdtjgus76.core.discount.RateDiscountPolicy;
import ghdtjgus76.core.member.Member;
import ghdtjgus76.core.member.MemberRepository;
import ghdtjgus76.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}