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
@Table(name="stay")
/** 숙소 데이터를 저장하는 클래스 **/
public class Stay {

	/* 변수 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stay_code")
	private Integer code;
	
	@Column(name="member_email", nullable=false)
	private String email;
	
	@Column(name="stay_name", nullable=false)
	private String name;
	
	@Column(name="stay_people", nullable=false)
	private Integer people;
	
	@Column(name="stay_address")
	private String address;
	
	@Column(name="stay_phone")
	private String phone;
	
	@Column(name="stay_domain")
	private String domain;
	
	@Column(name="stay_rooms", nullable=false)
	private Integer rooms;
	
	@Column(name="stay_intro")
	private String intro;
	
	@Column(name="stay_image")
	private String image;
	
	@Column(name="stay_price", nullable=false)
	private Integer price;
	
	@Builder
	public Stay(String email, String name, Integer people, String address, String phone, String domain, Integer rooms,
			String intro, String image, Integer price) {
		super();
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
	
}//end of Stay
