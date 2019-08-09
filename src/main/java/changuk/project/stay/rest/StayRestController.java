package changuk.project.stay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import changuk.project.stay.service.StayService;

/** Stay 데이터 관련 RestController **/
@RestController
@RequestMapping("stay")
public class StayRestController {

	/* 변수 */
	@Autowired private StayService stayService;
	
	/* 함수 */
	/** 호스팅 취소 **/
	@DeleteMapping("{code}")
	public boolean delete(@PathVariable("code") Integer code) {
		return stayService.delete(code);
	}//end of delete
	
}//end of StayRestController
