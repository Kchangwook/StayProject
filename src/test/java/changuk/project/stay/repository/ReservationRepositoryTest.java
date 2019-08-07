package changuk.project.stay.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import changuk.project.stay.domain.Reservation;

/** Reservation Repository 테스트 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationRepositoryTest {
	
	/* 변수 */
	private @Autowired ReservationRepository repository;
	private Reservation r1;
	private Reservation r2;
	private Reservation r3;
	private LocalDate today = LocalDate.now();
	private LocalDate t1 = LocalDate.now().plusDays(1L);
	private LocalDate t2 = LocalDate.now().plusDays(2L);
	private LocalDate t3 = LocalDate.now().plusDays(3L);
	
	@Before
	public void setUp() {
		
		r1 = Reservation.builder().code(1).email("ckddnr@naver.com").stayCode(1).people(1).price(1)
				.checkIn(today).checkOut(t1).stayName("123").build();
		
		r2 = Reservation.builder().code(2).email("ckddnr@naver.com").stayCode(2).people(4).price(4444)
				.checkIn(today).checkOut(t2).stayName("창욱집").build();
		
		r3 = Reservation.builder().code(3).email("ckddnr@naver.com").stayCode(2).people(4).price(4444)
				.checkIn(today).checkOut(t3).stayName("창욱집").build();
		
	}//end of setUP
	
	/** 기본 저장 테스트 **/
	@Test
	public void basic() {
		
		repository.save(r1);
		repository.save(r2);
		repository.save(r3);
		
		assertThat(repository.count(), is(3L));
		
	}//end of save
	
	/** 이메일에 해당하는 목록 가져오기 테스트 **/
	@Test
	public void findByEmail() {
		
		List<Reservation> list = repository.findByEmailOrderByCodeAsc(r1.getEmail());
		
		assertThat(list.size(), is(3));
		
		assertThat(list.get(0).getCode(), is(r1.getCode()));
		assertThat(list.get(1).getCode(), is(r2.getCode()));
		assertThat(list.get(2).getCode(), is(r3.getCode()));
		
	}//end of findByEmail

}//end of ReservationTest
