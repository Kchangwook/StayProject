package changuk.project.stay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import changuk.project.stay.domain.Member;
import changuk.project.stay.domain.Reservation;
import changuk.project.stay.service.ReservationService;

/** Reservation 데이터 관련 Controller **/
@Controller
@RequestMapping("reservation")
public class ReservationController {

	/* 변수 */
	private @Autowired ReservationService reservationService;
	
	/* 함수 */
	/** 예약을 추가**/
	@PostMapping("")
	public String post(@ModelAttribute Reservation reservation, @SessionAttribute("member") Member member) {
		
		reservation.setEmail(member.getEmail());
		reservationService.add(reservation);
		
		return "redirect:/reservation";
		
	}//end of post
	
	/** 내가 예약 진행 중인 목록 가져오기 **/
	@GetMapping("")
	public String get(@SessionAttribute("member") Member member, Model model) {
		
		model.addAttribute("list", reservationService.getMine(member.getEmail()));
		
		return "reservation/current";
		
	}//end of get
	
}//end of ReservationController
