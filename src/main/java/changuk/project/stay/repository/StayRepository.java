package changuk.project.stay.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import changuk.project.stay.domain.Stay;

/** 데이터베이스와 숙소 데이터로 통신하는 Repository **/ 
@Repository
public interface StayRepository extends JpaRepository<Stay, String>{

	Stay findByAddress(String address);		// 주소를 이용해 숙소 찾기
	List<Stay> findByEmailOrderByCode(String email);	// 이메일과 일치하는 호스팅 목록 가져오기
	@Procedure(procedureName="findReserve")
	List<Stay> findCanReserve(@Param("checkIn")Date checkIn, @Param("checkOut")Date checkOut
			, @Param("address") String address, @Param("people")Integer people);
	
}// end of StayRepository
