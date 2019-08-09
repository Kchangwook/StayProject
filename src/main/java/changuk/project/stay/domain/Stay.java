package changuk.project.stay.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "stay")
/** 숙소 데이터를 저장하는 클래스 **/
public class Stay {

	/* 변수 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staycode")
	private Integer code;

	@Column(name = "memberemail", nullable = false)
	private String email;

	@Column(name = "stayname", nullable = false)
	private String name;

	@Column(name = "staypeople", nullable = false)
	private Integer people;

	@Column(name = "stayaddress")
	private String address;

	@Column(name = "stayphone")
	private String phone;

	@Column(name = "staydomain")
	private String domain;

	@Column(name = "stayrooms", nullable = false)
	private Integer rooms;

	@Column(name = "stayintro")
	private String intro;

	@Column(name = "stayimage")
	private String image;

	@Column(name = "stayprice", nullable = false)
	private Integer price;

	@Builder
	public Stay(Integer code, String email, String name, Integer people, String address, String phone, String domain,
			Integer rooms, String intro, String image, Integer price) {
		super();
		this.code = code;
		this.email = email;
		this.name = name;
		this.people = people;
		this.address = address;
		this.phone = phone;
		this.domain = domain;
		this.rooms = rooms;
		this.intro = intro;
		this.image = image;
		this.price = price;
	}

}// end of Stay
