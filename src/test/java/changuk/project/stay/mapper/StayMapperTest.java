package changuk.project.stay.mapper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import changuk.project.stay.domain.Stay;

/** Stay Mapper Test **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class StayMapperTest {

	/* 변수 */
	@Autowired private StayMapper mapper;
	
	/* 함수 */
	/** 예약 할 수 있는 숙소 목록 가져오기 **/
	@Test
	public void findCanReserve() {
		
		Date today = new Date();
		Date t1 = new Date(today.getTime() + (1000*60*60*24*+4));
		String address = "%서울%";
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("checkIn", today.toString());
		map.put("checkOut", t1.toString());
		map.put("address", "%" + address + "%");
		map.put("people","2");
		
		List<Stay> list = mapper.findReserve(map);
		
		assertThat(list.size(), is(1));
		
	}//end of findCanReserve
	
	@Test
	public void basic() {
		
		List<Stay> list = mapper.find();
		
		assertThat(list.size(), is(2));
		
	}//end of basic
	
}//end of StayTest
