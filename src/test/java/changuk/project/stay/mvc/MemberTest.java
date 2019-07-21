package changuk.project.stay.mvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import changuk.project.stay.controller.MemberController;
import changuk.project.stay.domain.Member;
import changuk.project.stay.service.MemberService;

/** MemberController 테스트 **/
@RunWith(SpringRunner.class)
@WebMvcTest(MemberController.class)
public class MemberTest {

	private @MockBean MemberService memberService;
	private @Autowired MockMvc mvc;
	
	private Member m1;
	private Member m2;
	private Member m3;

	@Before
	public void setUp() {

		m1 = Member.builder().email("kchangwook@naver.com").password("1234").name("김창욱").phone("010-2684-1451").build();
		m2 = Member.builder().email("ckddnr@naver.com").password("1234").name("창욱").phone("010-2684-1451").build();
		m3 = Member.builder().email("rlackddnr@naver.com").password("1234").name("김창욱").phone("010-2684-1451").build();
		
	}// end of setUp
	
	@Test
	/** 회원 가입 테스트 **/
	public void join() throws Exception {
		
		when(memberService.add(m1)).thenReturn(m1);
		when(memberService.add(m2)).thenReturn(null);
		
		mvc.perform(post("/member").param("email",m1.getEmail()).param("password", m1.getPassword())
				.param("name", m1.getName()).param("phone", m1.getPhone()))
		.andExpect(status().isOk())
		.andExpect(view().name("home"))
		.andExpect(request().attribute("msg", "회원가입에 성공하셨습니다."));
		
		mvc.perform(post("/member").param("email",m2.getEmail()).param("password", m2.getPassword())
				.param("name", m2.getName()).param("phone", m2.getPhone()))
		.andExpect(status().isOk())
		.andExpect(view().name("home"))
		.andExpect(request().attribute("msg", "회원가입에 실패했습니다."));
		
	}//end of join
	
}//end of MemberTest
