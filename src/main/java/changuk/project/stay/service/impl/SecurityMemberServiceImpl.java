package changuk.project.stay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import changuk.project.stay.domain.Member;
import changuk.project.stay.domain.SecurityMember;
import changuk.project.stay.repository.MemberRepository;

/** 인증을 위한 서비스 클래스 **/
@Service
public class SecurityMemberServiceImpl implements UserDetailsService{

	/* 변수 */
	@Autowired private MemberRepository memberRepository;
	
	/* 함수 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member m = memberRepository.findByEmail(username);
		return new SecurityMember(m);
	}
	
}//end of SecurityMemberServiceImpl
