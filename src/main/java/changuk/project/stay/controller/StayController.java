package changuk.project.stay.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import changuk.project.stay.domain.Member;
import changuk.project.stay.domain.Reservation;
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
	
	/** 숙소 검색하기 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException **/
	@PostMapping("search")
	public String search(@ModelAttribute Reservation reservation, 
			@RequestParam("address") String address, Model model,
			HttpServletResponse response, HttpServletRequest request) {
		
		String email = "";
		
		if(request.getSession().getAttribute("member") != null)
			email = ((Member)request.getSession().getAttribute("member")).getEmail();
		
		model.addAttribute("list", stayService.findReserve(reservation, address, email));
		response = addCookie(response, reservation, address);
		
		return "stay/search";
		
	}//end of search
	
	/** 숙소 코드와 일치하는 숙소 정보 가져오기 **/
	@GetMapping("{code}")
	public String getStay(Model model, @PathVariable Integer code) {
		
		model.addAttribute("stay", stayService.getStay(code));
		
		return "stay/detail";
		
	}//end of getStay
	
	/** 쿠키에 검색 내용 추가하는 함수 **/
	private HttpServletResponse addCookie(HttpServletResponse response, Reservation r, String a) {
		
		for(int i = 0; i < 4; i++) {
			
			Cookie temp = null;
			
			if(i == 0) temp = new Cookie("checkIn", String.valueOf(r.getCheckIn()));
			if(i == 1) temp = new Cookie("checkOut", String.valueOf(r.getCheckOut()));
			if(i == 2) temp = new Cookie("people",String.valueOf(r.getPeople()));
			if(i == 3) temp = new Cookie("address", a);
			
			temp.setPath("/");
			response.addCookie(temp);
			
		}
		
		return response;
		
	}//end of addCookie
	
}//end of StayController
