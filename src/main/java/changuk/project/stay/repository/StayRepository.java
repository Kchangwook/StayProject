package changuk.project.stay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import changuk.project.stay.domain.Stay;

/** 데이터베이스와 숙소 데이터로 통신하는 Repository **/ 
@Repository
public interface StayRepository extends JpaRepository<Stay, String>{

	Stay findByAddress(String address);		// 주소를 이용해 숙소 찾기
	
}//end of StayRepository
