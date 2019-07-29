package changuk.project.stay.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

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
	
	/** 마이페이지로 이동하는 함수 **/
	@GetMapping("")
	public String get() {
		
		return "my-page";
		
	}//end of get
	
	/** 정보 수정 함수 **/
	@PutMapping("")
	public String put(@SessionAttribute("member") Member before, @ModelAttribute Member after,
			HttpServletRequest request, @RequestParam("member_img") MultipartFile file) {
		
		System.out.println("before: " + before);
		System.out.println("after: " + after);
		
		Member member = memberService.update(before, after, file);
		request.getSession().setAttribute("member", member);
		request.setAttribute("msg", "회원 정보 수정이 되셨습니다.");
		
		return "home";
		
	}//end of put
	
}//end of MemberController
