package hello.core.order;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;

//	@Autowired
//	public void setMemberRepository(MemberRepository memberRepository) {
//		this.memberRepository = memberRepository;
//	}
//
//	@Autowired
//	public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//		this.discountPolicy = discountPolicy;
//	}

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
