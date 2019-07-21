package changuk.project.stay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import changuk.project.stay.domain.Member;
import changuk.project.stay.repository.MemberRepository;
import changuk.project.stay.service.MemberService;

/** Member 데이터 관련 Service 구현 **/
@Service
public class MemberServiceImpl implements MemberService {

	/* 변수 */
	@Autowired private MemberRepository memberRepository;
	
	@Override
	/** Email을 이용해 Member 데이터 탐색 **/
	public Member findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}//end of findByEmail

	@Override
	/** 회원 가입을 하는 함수 **/
	public Member add(Member member) {
		member.setImage("/img/basic/profile.png");
		return memberRepository.save(member);
	}//end of add

	@Override
	/** 이메일을 통한 데이터 중복 여부 체크 **/
	public boolean check(String email) {
		return memberRepository.countByEmail(email) > 0;
	}//end of check
	
}//end of MemberServiceImpl
