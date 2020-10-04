package hello.core.scan;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AutoAppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.order.OrderServiceImpl;

public class AutoAppConfigTest {
	@Test
	void basicScan() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		MemberService memberService = ac.getBean(MemberService.class);
		assertThat(memberService).isInstanceOf(MemberService.class);

		// OrderServiceImpl 에서 @RequiredArgsConstructor 할 경우 DiscountPolicy 타입이 2개여서, 오류 발생.
		// OrderServiceImpl 내 private final DiscountPolicy rateDiscountPolicy 로 변경 시 타입 매칭 -> 필드 명, 파라미터 명으로 빈 이름 매칭하여 성공한다.
		OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
		MemberRepository memberRepository = bean.getMemberRepository();
		System.out.println("memberRepository = " + memberRepository);

	}
}
