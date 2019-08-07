package changuk.project.stay.service;

import java.util.List;

import javax.transaction.Transactional;

import changuk.project.stay.domain.Reservation;

/** Reservation 데이터 관련 Service **/
@Transactional
public interface ReservationService {

	Reservation add(Reservation reservation);	// 예약 추가
	List<Reservation> getMine(String email);	// 이메일에 해당하는 예약 가져오기
	
}//end of ReservationService
