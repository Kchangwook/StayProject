package changuk.project.stay.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import changuk.project.stay.domain.Stay;

/** Stay와 DB를 통신하는 클래스 **/
@Mapper
public interface StayMapper {

	List<Stay> findReserve(Map<String, String> map);	// 예약 가능한 숙소 목록 가져오기
	List<Stay> find();	// 모든 숙소 목록 가져오기 
	
}//end of StayMapper
