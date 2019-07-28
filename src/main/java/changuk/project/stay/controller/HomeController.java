package changuk.project.stay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import changuk.project.stay.domain.Member;
import changuk.project.stay.service.MemberService;

/** 메인 컨트롤러 **/
@Controller
public class HomeController {

	/* 변수 */
	private @Autowired MemberService memberService;
	
	/* 함수 */
	/** 메인 페이지로 이동 **/
	@GetMapping("")
	public String get() {
		return "home";
	}//end of get
	
	/** 로그인 **/
	@PostMapping("")
	public String post(@ModelAttribute Member member, HttpServletRequest request) {
		
		Member temp = memberService.findByEmail(member.getEmail());
		
		if(temp != null) {
			
			if(temp.getPassword().equals(member.getPassword())) request.getSession().setAttribute("member", temp);
			else request.setAttribute("msg", "로그인에 실패했습니다.");
			
		}else request.setAttribute("msg", "로그인에 실패했습니다.");
		
		return "home";
		
	}//end of post
	
	/** 로그아웃 **/
	@GetMapping("logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "home";
		
	}//end of logout
	
}//end of HomeController
