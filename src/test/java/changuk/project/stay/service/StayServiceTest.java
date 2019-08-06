package changuk.project.stay.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import changuk.project.stay.domain.Reservation;
import changuk.project.stay.domain.Stay;

/** Stay Service 테스트 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class StayServiceTest {

	/* 변수 */
	@Autowired private StayService service;
	
	/* 함수 */
	@Test
	public void findReserve() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		
		LocalDate today = LocalDate.now();
		LocalDate t = LocalDate.now().plusDays(1L);
		
		Reservation r = Reservation.builder().checkIn(today).checkOut(t).people(0).build();
		
		List<Stay> list = service.findReserve(r, "%서울%");
		
		assertThat(list.size(), is(1));
		
		System.out.println(list);
		
	}//end of findReserve
	
}//end of StayServiceTest
