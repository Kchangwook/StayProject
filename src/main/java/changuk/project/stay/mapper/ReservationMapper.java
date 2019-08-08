package changuk.project.stay.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import changuk.project.stay.domain.Reservation;

/** IBatis를 이용해 DB와 통신하는 인터페이스 **/
@Mapper
public interface ReservationMapper {

	List<Reservation> getHosting(String email);	// 이메일을 이용해 호스팅 중인 숙소들의 예약을 가져오기
	
}//end of ReservationMapepr
