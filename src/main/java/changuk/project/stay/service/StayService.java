package changuk.project.stay.service;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.web.multipart.MultipartFile;

import changuk.project.stay.domain.Stay;

/** Stay 데이터 관련 Service **/
@Transactional
public interface StayService {

	boolean add(Stay s, MultipartFile file) throws IllegalStateException, IOException ;	//숙소 등록
	
}//end of StayService
