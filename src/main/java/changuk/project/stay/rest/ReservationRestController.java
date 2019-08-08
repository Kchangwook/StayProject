package changuk.project.stay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}//end of ReservationRestController
