package changuk.project.stay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import changuk.project.stay.service.MemberService;

/** Member 데이터 관련 RestController **/
@RestController
@RequestMapping("member")
public class MemberRestController {

	/* 변수 */
	private @Autowired MemberService memberService;
	
	/* 함수 */
	/** 이메일을 통한 데이터 중복을 확인 **/
	@GetMapping("check/{email}")
	public boolean check(@PathVariable String email) {
		
		return memberService.check(email);
		
	}//end of check
	
	
}//end of MemberRestController
