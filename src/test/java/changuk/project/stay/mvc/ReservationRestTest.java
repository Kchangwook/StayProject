package changuk.project.stay.mvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import changuk.project.stay.domain.Member;
import changuk.project.stay.domain.Reservation;
import changuk.project.stay.rest.ReservationRestController;
import changuk.project.stay.service.ReservationService;

/** ReservationRestController Test **/
@RunWith(SpringRunner.class)
@WebMvcTest(ReservationRestController.class)
public class ReservationRestTest {

	/* 변수 */
	private @MockBean ReservationService service;
	private @Autowired MockMvc mvc;
	private Reservation r1;
	private Reservation r2;
	private Reservation r3;
	private Member m2;
	private LocalDate today = LocalDate.now();
	private LocalDate t1 = LocalDate.now().plusDays(1L);
	private LocalDate t2 = LocalDate.now().plusDays(2L);
	private LocalDate t3 = LocalDate.now().plusDays(3L);
	private List<Reservation> list;
	
	@Before
	public void setUp() {
		
		r1 = Reservation.builder().code(1).email("ckddnr@naver.com").stayCode(1).people(1).price(1)
				.checkIn(today).checkOut(t1).stayName("123").build();
		
		r2 = Reservation.builder().code(2).email("ckddnr@naver.com").stayCode(2).people(4).price(4444)
				.checkIn(today).checkOut(t2).stayName("창욱집").build();
		
		r3 = Reservation.builder().code(3).email("ckddnr@naver.com").stayCode(2).people(4).price(4444)
				.checkIn(today).checkOut(t3).stayName("창욱집").build();
		
		m2 = Member.builder().email("ckddnr@naver.com").password("1234").name("창욱").phone("010-2684-1451").build();
		
		list = new ArrayList<>();
		
		list.add(r1);
		list.add(r2);
		list.add(r3);
		
	}//end of setUP
	
	/** 예약 취소 테스트 
	 * @throws Exception **/
	@Test
	public void deleteTest() throws Exception {
		
		when(service.delete(r1.getCode())).thenReturn(true);
		when(service.delete(r2.getCode())).thenReturn(false);
		
		mvc.perform(delete("/reservation/" + r1.getCode()))
		.andExpect(status().isOk())
		.andExpect(content().string("true"));
		
		mvc.perform(delete("/reservation/" + r2.getCode()))
		.andExpect(status().isOk())
		.andExpect(content().string("false"));
		
	}//end of delete
	
}//end of ReservationRestTest
