package changuk.project.stay.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import changuk.project.stay.domain.Stay;

@RunWith(SpringRunner.class)
@SpringBootTest
/** StayRepository를 작동 테스트 **/
public class StayRepositoryTest {

	/* 변수 */
	@Autowired private StayRepository repository;
	private Stay s1;
	private Stay s2;
	private Stay s3;
	private List<Stay> list;
	
	@Before
	public void setUp() {
		
		s1 = Stay.builder().code(1).email("kchangwook@naver.com").address("서울 동작구 대방동 391-311").domain("www.naver.com")
				.image("/img/basic/stay.jpg").intro("안녕").name("123").people(1).rooms(1).phone("010-2684-1451")
				.price(100).build();
		
		s2 = Stay.builder().code(2).email("kchangwook@naver.com").address("서울 동작구 대방동 391-312").domain("www.naver.com")
				.image("/img/basic/stay.jpg").intro("안녕").name("234").people(2).rooms(2).phone("010-2684-1451")
				.price(200).build();
		
		s3 = Stay.builder().code(3).email("kchangwook@naver.com").address("서울 동작구 대방동 391-313").domain("www.naver.com")
				.image("/img/basic/stay.jpg").intro("안녕").name("345").people(3).rooms(3).phone("010-2684-1451")
				.price(300).build();
		
		list = new ArrayList<>();
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		
	}//end of setUp
	
	/** DB와 연동 테스트 **/
	@Test
	public void save() {
		
		repository.save(s1);
		
		Stay temp = repository.findByAddress(s1.getAddress());
		
		assertThat(temp.getName(), is(s1.getName()));
		assertThat(temp.getPrice(), is(s1.getPrice()));
		
	}//end of save
	
	/** 이메일과 일치하는 리스트 가져오기 **/
	@Test
	public void findByEmail() {	
		
		List<Stay> page = repository.findByEmailOrderByCode("kchangwook@naver.com");
		
	}//end of findByEmail
	
	/** 숙소 코드와 일치하는 숙소 가져오기 **/
	@Test
	public void findByCode() {
		
		Stay temp = repository.findByCode(1);
		
		assertThat(s1.getName(), is(temp.getName()));
		assertThat(s1.getDomain(), is(temp.getDomain()));
		assertThat(s1.getImage(), is(temp.getImage()));
		assertThat(s1.getAddress(), is(temp.getAddress()));
		
	}//end of findByCode
	
	/** 예약 가능한 숙소 찾는 프로시저 호출 **/
	@Test
	public void findReserve() {
		
		LocalDate today = LocalDate.now();
		LocalDate t1 = LocalDate.now().plusDays(4L);
		String address = "%서울%";
		
		List<Stay> list = repository.findReserve(today, t1, address, 2, "kchangwook@naver.com");
		
		assertThat(list.size(), is(0));
		
		System.out.println(list);
		
	}//end of findReserve
	
}//end of StayRepositoryTest
