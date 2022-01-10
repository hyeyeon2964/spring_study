package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){ //멤버서비스 역할
        return new MemberServiceImpl(memberRepository()); //memberServiceImpl 사용
    }

    private MemberRepository memberRepository() { //멤버레파지토리 역할
        return new MemoryMemberRepository(); // 메모리로 사용
    }

    public OrderService orderService(){ //오더서비스 역할
        return new OrderServiceImpl(memberRepository(), new FixDiscountPolicy());
    }
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy(); //현재 할인 정책은 정액 할인정책
    }
}
