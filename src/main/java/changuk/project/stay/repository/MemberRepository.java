package changuk.project.stay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import changuk.project.stay.domain.Member;

/** 데이터베이스와 멤버 데이터로 통신하는 Repository **/ 
@Repository
public interface MemberRepository extends JpaRepository<Member, String>{

	Member findByEmail(String email);	// email을 이용해 Member 데이터 찾기
	int countByEmail(String email);		// email을 이용해 데이터 중복 찾기
	
}//end of MemberRepository
