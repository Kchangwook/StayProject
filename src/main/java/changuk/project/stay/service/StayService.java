package changuk.project.stay.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.multipart.MultipartFile;

import changuk.project.stay.domain.Stay;

/** Stay 데이터 관련 Service **/
@Transactional
public interface StayService {

	boolean add(Stay s, MultipartFile file) throws IllegalStateException, IOException ;	//숙소 등록
	List<Stay> getList(String email);	// 이메일로 호스팅하는 숙소 목록 가져오기
	
}//end of StayService
