package hello.core.discount;

import org.springframework.stereotype.Component;

import hello.core.member.Grade;
import hello.core.member.Member;

@Component  // 이렇게 되면 DiscountPolicy 타입이 2개여서 @Autowired 시 오류난다
public class FixDiscountPolicy implements DiscountPolicy {

	private int discountFixAmount = 1000;  // 1000원 할인

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		} else {
			return 0;
		}
	}
}
