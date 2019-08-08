package changuk.project.stay.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import changuk.project.stay.domain.Reservation;

/** Reservation 데이터를 DB와 통신하는 인터페이스 **/
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String>{

	List<Reservation> findByEmailOrderByCodeAsc(String email);	// 이메일과 일치하는 예약 목록 가져오기
	@Transactional
	Integer deleteByCode(Integer code);		// 예약 취소
	
}//end of ReservationRepository
