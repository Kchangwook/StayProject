package changuk.project.stay.mvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import changuk.project.stay.controller.StayController;
import changuk.project.stay.domain.Member;
import changuk.project.stay.domain.Stay;
import changuk.project.stay.service.StayService;
import changuk.project.stay.util.MapperUtil;

/** StayController 테스트 **/
@RunWith(SpringRunner.class)
@WebMvcTest(StayController.class)
public class StayTest {

	/* 변수 */
	@MockBean StayService stayService;
	@Autowired private MockMvc mvc;
	
	// MockMultipartFile을 이용한 테스트용 파일
	private MockMultipartFile file;
	private Stay s1;
	private Stay s2;
	private Stay s3;
	private Member m1;
	
	/* 변수 */
	/** 사전 설정 **/
	@Before
	public void setUp() {
		
		s1 = Stay.builder().email("kchangwook@naver.com").address("서울 동작구 대방동 391-311").domain("www.naver.com")
				.image("/img/basic/stay.jpg").intro("안녕").name("123").people(1).rooms(1).phone("010-2684-1451")
				.price(100).build();
		
		s2 = Stay.builder().email("kchangwook@naver.com").address("서울 동작구 대방동 391-312").domain("www.naver.com")
				.image("/img/basic/stay.jpg").intro("안녕").name("234").people(2).rooms(2).phone("010-2684-1451")
				.price(200).build();
		
		s3 = Stay.builder().email("kchangwook@naver.com").address("서울 동작구 대방동 391-313").domain("www.naver.com")
				.image("/img/basic/stay.jpg").intro("안녕").name("345").people(3).rooms(3).phone("010-2684-1451")
				.price(300).build();
		
		file = new MockMultipartFile("stay-img", "dummy.csv",
	            "text/plain", "Some dataset...".getBytes());
		
		m1 = Member.builder().email("kchangwook@naver.com").password("1234").name("김창욱").phone("010-2684-1451").build();
		
	}//end of setUp
	
	/** add URL 테스트 
	 * @throws Exception **/
	@Test
	public void add() throws Exception {
		
		when(stayService.add(s1, file)).thenReturn(true);
		
		mvc.perform(multipart("/stay").file(file).sessionAttr("member", m1).params(MapperUtil.changeStringMap(s1)))
		.andExpect(status().is3xxRedirection())
		.andExpect(header().string("Location","/"));
				
				
	}//end of add
	
}//end of StayTest
