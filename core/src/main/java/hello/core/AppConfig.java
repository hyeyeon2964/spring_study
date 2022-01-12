package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){ //멤버서비스 역할
        return new MemberServiceImpl(memberRepository()); //memberServiceImpl 사용
    }
    @Bean
    public  MemberRepository memberRepository() { //멤버레파지토리 역할
        return new MemoryMemberRepository(); // 메모리로 사용
    }
    @Bean
    public OrderService orderService(){ //오더서비스 역할
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
