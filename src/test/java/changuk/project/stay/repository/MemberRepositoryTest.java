package changuk.project.stay.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import changuk.project.stay.domain.Member;
import changuk.project.stay.repository.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
/** MemberRepository를 작동 테스트 **/
public class MemberRepositoryTest {

	@Autowired
	private MemberRepository repository;
	private Member m1;
	private Member m2;
	private Member m3;

	@Before
	public void setUp() {

		m1 = Member.builder().email("kchangwook@naver.com").password("1234").name("김창욱").phone("010-2684-1451").build();
		m2 = Member.builder().email("ckddnr@naver.com").password("1234").name("창욱").phone("010-2684-1451").build();
		m3 = Member.builder().email("rlackddnr@naver.com").password("1234").name("김창욱").phone("010-2684-1451").build();
		
	}// end of setUp

	/** 데이터 삽입 확인 **/
	@Test
	public void insert() {

		repository.save(m1);
		repository.save(m2);
		repository.save(m3);
		
		assertThat(repository.count(), is(3L));
		
	}// end of insert
	
	/** 데이터 가져오기 확인 **/
	@Test
	public void get() {
		
		Member temp = repository.findByEmail(m1.getEmail());
		
		assertThat(temp.getEmail(), is(m1.getEmail()));
		assertThat(temp.getPassword(), is(m1.getPassword()));
		
		assertThat(repository.countByEmail(m1.getEmail()), is(1));
		
	}//end of get
	
	/** 데이터 수정 **/
	@Test
	public void update() {
		
		int ran = (int)(Math.random() * 1000);
		m2.setPassword(ran + "");
		
		repository.save(m2);
		
		Member temp = repository.findByEmail(m2.getEmail());
		
		assertThat(temp.getPassword(), is(m2.getPassword()));
		
	}//end of update

}// end of MemberRepositoryTest
