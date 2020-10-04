package hello.core.order;

import org.junit.jupiter.api.Test;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemoryMemberRepository;

class OrderServiceImplTest {

	@Test
	void createOrder() {
		// 이렇게 수정자 주입(setter 주입)으로 쓰면 누락되어도 컴파일 오류가 발생하지 않아,
		// 생성자 주입이 더 좋다.
//		OrderServiceImpl orderService = new OrderServiceImpl();

		// 테스트 시 이렇게 빈 대신 넣어줄 수도 있다.(Mock 써서 빈 생성하기도 좋다)
		OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
		orderService.createOrder(1L, "itemA", 10000);
	}
}
