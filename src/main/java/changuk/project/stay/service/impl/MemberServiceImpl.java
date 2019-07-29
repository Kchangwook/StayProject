package changuk.project.stay.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import changuk.project.stay.domain.Member;
import changuk.project.stay.repository.MemberRepository;
import changuk.project.stay.service.MemberService;
import changuk.project.stay.util.MultipartUtil;

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

	@Override
	/** 회원 정보 수정 **/
	public Member update(Member before, Member after, MultipartFile file) throws IllegalStateException, IOException {
		
		// 패스워드 변경 안 할때
		if(after.getPassword().isEmpty()) after.setPassword(before.getPassword());
		// 이름 변경 안 할때
		if(after.getName().isEmpty()) after.setName(before.getName());
		// 연락처 변경 안 할때
		if(after.getPhone().isEmpty()) after.setPhone(before.getPhone());
		// 이미지 변경 시
		if(!file.isEmpty()) after.setImage(MultipartUtil.upload(file, "mem-prof", after.getEmail().split("@")[0]));
		else after.setImage(before.getImage());
		
		memberRepository.save(after);
		
		return after;
		
	}//end of update
	
}//end of MemberServiceImpl
