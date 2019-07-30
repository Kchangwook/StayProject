package changuk.project.stay.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
		
	}//end of setUp
	
	/** DB와 연동 테스트 **/
	@Test
	public void save() {
		
		repository.save(s1);
		
		Stay temp = repository.findByAddress(s1.getAddress());
		
		assertThat(temp.getName(), is(s1.getName()));
		assertThat(temp.getPrice(), is(s1.getPrice()));
		
	}//end of save
	
}//end of StayRepositoryTest
