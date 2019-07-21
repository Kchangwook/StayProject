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
	@Column(name = "member_email", nullable = false)
	private String email;

	@Column(name = "member_password", nullable = false)
	private String password;

	@Column(name = "member_name", nullable = false)
	private String name;

	@Column(name = "member_phone", nullable = false)
	private String phone;

	@Column(name = "member_image", nullable = true)
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
