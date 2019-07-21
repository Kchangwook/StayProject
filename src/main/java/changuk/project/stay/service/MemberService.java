package changuk.project.stay.service;

import javax.transaction.Transactional;

import changuk.project.stay.domain.Member;

/** Member 데이터 관련 Service **/
@Transactional
public interface MemberService {

	Member findByEmail(String email);	// 이메일을 이용해 Member 데이터 탐색
	Member add(Member member);			// 회원가입
	boolean check(String email);		// 이메일을 통한 데이터 중복 여부 체크
	
}//end of MemberService
