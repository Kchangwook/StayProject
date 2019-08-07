package changuk.project.stay.mvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.lang.reflect.InvocationTargetException;
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

import changuk.project.stay.controller.ReservationController;
import changuk.project.stay.domain.Member;
import changuk.project.stay.domain.Reservation;
import changuk.project.stay.service.ReservationService;
import changuk.project.stay.util.MapperUtil;

/** ReservationController 테스트 **/
@RunWith(SpringRunner.class)
@WebMvcTest(ReservationController.class)
public class ReservationTest {

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
	
	/** 예약 추가 함수 테스트 
	 * @throws Exception 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException **/
	@Test
	public void add() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, Exception {
		
		when(service.add(r1)).thenReturn(r1);
		
		mvc.perform(post("/reservation").params(MapperUtil.changeStringMap(r1)))
		.andExpect(status().is3xxRedirection())
		.andExpect(header().string("Location", "/reservation"));
		
	}//end of add
	
	/** 내가 예약한 목록 가져오는기 테스트 
	 * @throws Exception **/
	@Test
	public void getMine() throws Exception {
		
		when(service.getMine(r1.getEmail())).thenReturn(list);
		
		mvc.perform(get("/reservation").sessionAttr("member", m2))
		.andExpect(status().isOk())
		.andExpect(view().name("reservation/current"))
		.andExpect(model().attribute("list", list));
		
	}//end of getMine
	
}//end of ReservationTest
