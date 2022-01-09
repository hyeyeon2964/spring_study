package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    //주문을 위해 필요한 정보: 멤버, 할인 정보

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member =  memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인에 대한건 discountPolicy에서 알아서 하게끔해서 단일책임의 원칙을 지킴

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
