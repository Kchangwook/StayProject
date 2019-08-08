package changuk.project.stay.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import changuk.project.stay.domain.Member;
import changuk.project.stay.domain.Reservation;
import changuk.project.stay.service.ReservationService;

/** Reservation 데이터 관련 RestController **/
@RestController
@RequestMapping("reservation")
public class ReservationRestController {

	/* 변수 */
	private @Autowired ReservationService reservationService;
	
	/* 함수 */
	
	/** 예약을 취소하는 함수 **/
	@DeleteMapping("{code}")
	public boolean delete(@PathVariable("code") Integer code) {
		
		return reservationService.delete(code);
		
	}//end of delete
	
	/** 내 숙소에 등록된 예약 목록 가져오기 **/
	@GetMapping("hosting")
	public Map<String, List<Reservation>> hosting(@SessionAttribute("member") Member member){
		
		Map<String, List<Reservation>> map = new HashMap<>();
		map.put("data", reservationService.getHosting(member.getEmail()));
		return map;
		
	}//end of hosting
	
}//end of ReservationRestController
