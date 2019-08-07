package changuk.project.stay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import changuk.project.stay.domain.Reservation;

/** Reservation 데이터를 DB와 통신하는 인터페이스 **/
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String>{

	List<Reservation> findByEmailOrderByCodeAsc(String email);
	
}//end of ReservationRepository
