package changuk.project.stay.mapper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import changuk.project.stay.domain.Reservation;

/** ReservationMapper 테스트 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationMapperTest {

	/*변수 */
	private @Autowired ReservationMapper mapper;
	
	/* 함수 */
	/** getHosting Test **/
	@Test
	public void getHosting() {
		
		List<Reservation> list = mapper.getHosting("kchangwook@naver.com");
		
		assertThat(list.size(),is(1));
		assertThat(list.get(0).getPeople(), is(3));
		
	}//end of getHosting
	
	
}//end of ReservationMapperTest
