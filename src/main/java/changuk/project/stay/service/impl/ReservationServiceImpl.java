package changuk.project.stay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import changuk.project.stay.domain.Reservation;
import changuk.project.stay.repository.ReservationRepository;
import changuk.project.stay.service.ReservationService;

/** Reservation 데이터 관련 Service 구현 **/
@Service
public class ReservationServiceImpl implements ReservationService {

	/* 변수 */
	@Autowired private ReservationRepository reservationRepository;
	
	/* 함수 */
	/** 예약 추가 **/
	@Override
	public Reservation add(Reservation reservation) {
		return reservationRepository.save(reservation);
	}// end of add

	/** 이메일에 해당하는 예약 목록 가져오기 **/
	@Override
	public List<Reservation> getMine(String email) {
		return reservationRepository.findByEmailOrderByCodeAsc(email);
	}//end of getMine

}//end of ReservationServiceImpl
