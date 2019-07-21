package changuk.project.stay.mvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import changuk.project.stay.domain.Member;
import changuk.project.stay.service.MemberService;

/** MemberRestController Test **/
@RunWith(SpringRunner.class)
@WebMvcTest
public class MemberRestTest {

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
	
	/** 이메일을 이용한 중복 확인 
	 * @throws Exception **/
	@Test
	public void check() throws Exception {
		
		when(memberService.check(m1.getEmail())).thenReturn(true);
		when(memberService.check(m2.getEmail())).thenReturn(false);
		
		mvc.perform(get("/member/check/"+m1.getEmail()))
		.andExpect(status().isOk())
		.andExpect(content().string(true + ""));
		
		mvc.perform(get("/member/check/"+m2.getEmail()))
		.andExpect(status().isOk())
		.andExpect(content().string(false + ""));
		
	}//end of check
	
}//end of MemberRestTest
