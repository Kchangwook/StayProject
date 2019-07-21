package changuk.project.stay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import changuk.project.stay.domain.Member;
import changuk.project.stay.service.MemberService;

/** Member 데이터 관련 Controller **/
@Controller
@RequestMapping("member")
public class MemberController {

	/* 변수 */
	private @Autowired MemberService memberService;
	
	/* 함수 */
	/** 회원 가입을 하는 함수 **/
	@PostMapping("")
	public String post(@ModelAttribute Member member, Model model) {

		Member temp = memberService.add(member);
		
		if(temp != null) model.addAttribute("msg", "회원가입에 성공하셨습니다.");
		else model.addAttribute("msg", "회원가입에 실패했습니다.");
		
		return "home";
		
	}//end of post
	
}//end of MemberController
