package changuk.project.stay.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import changuk.project.stay.domain.Stay;

/** 데이터베이스와 숙소 데이터로 통신하는 Repository **/
@Repository
public interface StayRepository extends JpaRepository<Stay, String> {

	Stay findByAddress(String address); // 주소를 이용해 숙소 찾기
	List<Stay> findByEmailOrderByCode(String email); // 이메일과 일치하는 호스팅 목록 가져오기
	Stay findByCode(Integer code); // 숙소 코드를 이용해 숙소 찾기
	
	@Transactional
	Integer deleteByCode(Integer code);	// 숙소 코드를 이용해 호스팅 취소

	// 예약 가능한 숙소 목록 가져오기
	@Query(nativeQuery = true, value = "call findReserve(:checkIn, :checkOut, :address, :people, :email)")
	List<Stay> findReserve(@Param("checkIn") LocalDate checkIn, @Param("checkOut") LocalDate checkOut,
			@Param("address") String address, @Param("people") Integer people, @Param("email") String email);

}// end of StayRepository
