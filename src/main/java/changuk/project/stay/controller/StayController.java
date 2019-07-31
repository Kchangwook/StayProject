package changuk.project.stay.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import changuk.project.stay.domain.Member;
import changuk.project.stay.domain.Stay;
import changuk.project.stay.service.StayService;

/** Stay 데이터 관련 Controller **/
@Controller
@RequestMapping("stay")
public class StayController {

	/* 변수 */
	@Autowired private StayService stayService;
	
	/* 함수 */
	/** 숙소 등록 페이지로 이동 **/
	@GetMapping("")
	public String get() {
		return "stay/regist";
	}//end of get
	
	/** 호스팅 현황 페이지로 이동 **/
	@GetMapping("hosting")
	public String hosting(Model model, @SessionAttribute("member") Member member) {
		model.addAttribute("list",stayService.getList(member.getEmail()));
		return "stay/main";
	}//end of hosting
	
	/** 숙소 등록하기 
	 * @throws IOException 
	 * @throws IllegalStateException **/
	@PostMapping("")
	public String post(@ModelAttribute Stay stay, @RequestParam("stay-img") MultipartFile file
			,@SessionAttribute Member member) throws IllegalStateException, IOException {
		
		stay.setEmail(member.getEmail());
		stayService.add(stay, file);
		
		return "redirect:/";
		
	}//end of post
	
}//end of StayController
