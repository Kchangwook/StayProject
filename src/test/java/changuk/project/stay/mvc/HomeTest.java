package changuk.project.stay.mvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import changuk.project.stay.controller.HomeController;
import changuk.project.stay.domain.Member;
import changuk.project.stay.service.MemberService;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
/** HomeController Test **/
public class HomeTest {

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
	/** 로그인 테스트 **/
	public void login() throws Exception {
		
		when(memberService.findByEmail(m1.getEmail())).thenReturn(m1);
		when(memberService.findByEmail(m2.getEmail())).thenReturn(null);
		
		mvc.perform(post("/").param("email", m1.getEmail()).param("password", m1.getPassword()))
		.andExpect(status().isOk()).andExpect(view().name("home"))
		.andExpect(request().sessionAttribute("member", m1));
		
		mvc.perform(post("/").param("email", m2.getEmail()).param("password", m2.getPassword()))
		.andExpect(status().isOk()).andExpect(view().name("home"))
		.andExpect(request().attribute("msg", "로그인에 실패했습니다."));
		
	}//end of login
	
}//end of HomeTest
