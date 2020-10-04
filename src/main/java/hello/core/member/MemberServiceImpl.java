package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;

	// 생성자 주입을 사용하면 final 키워드를 넣을 수 있다.
	@Autowired  // 생성자가 딱 1개만 있으면 @Autowired 생략 가능
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}

	// 테스트 용도
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}
