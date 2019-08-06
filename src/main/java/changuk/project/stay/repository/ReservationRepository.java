package changuk.project.stay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import changuk.project.stay.domain.Reservation;

/** Reservation 데이터를 DB와 통신하는 인터페이스 **/
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String>{

	
	
}//end of ReservationRepository
