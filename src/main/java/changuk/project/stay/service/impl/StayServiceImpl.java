package changuk.project.stay.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import changuk.project.stay.domain.Stay;
import changuk.project.stay.repository.StayRepository;
import changuk.project.stay.service.StayService;
import changuk.project.stay.util.MultipartUtil;

/** Stay 데이터 관련 Service 구현 **/
@Service
public class StayServiceImpl implements StayService {

	/* 변수 */
	@Autowired private StayRepository stayRepository;
	
	/* 함수 */
	/** 숙소 등록 
	 * @throws IOException 
	 * @throws IllegalStateException **/
	@Override
	public boolean add(Stay s, MultipartFile file) throws IllegalStateException, IOException {
		
		if(!file.isEmpty()) s.setImage(MultipartUtil.upload(file, "stay-prof", s.getAddress().hashCode() + ""));
		else s.setImage("/img/basic/stay.jpg");
		
		return stayRepository.save(s) != null;
	}//end of add

	/** 호스팅하는 숙소 목록 가져오기 **/
	@Override
	public List<Stay> getList(String email) {
		return stayRepository.findByEmailOrderByCode(email);
	}//end of getList

}//end of StayServiceImpl
