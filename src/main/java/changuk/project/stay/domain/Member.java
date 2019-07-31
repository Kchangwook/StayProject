package changuk.project.stay.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "member")
/** 회원 데이터를 저장하는 클래스 **/
public class Member {

	@Id
	@Column(name = "memberemail", nullable = false)
	private String email;

	@Column(name = "memberpassword", nullable = false)
	private String password;

	@Column(name = "membername", nullable = false)
	private String name;

	@Column(name = "memberphone", nullable = false)
	private String phone;

	@Column(name = "memberimage", nullable = true)
	private String image;

	@Builder
	public Member(String email, String password, String name, String phone, String image) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.image = image;
	}

}// end of Member
