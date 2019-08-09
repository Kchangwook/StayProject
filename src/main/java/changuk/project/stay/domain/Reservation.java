package changuk.project.stay.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Reservation 데이터를 담는 클래스 **/
@Data
@NoArgsConstructor
@Entity
@Table(name="reservation")
public class Reservation {

	/* 변수 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reservationcode", nullable=false)
	private Integer code;
	
	@Column(name="memberemail", nullable=false)
	private String email;
	
	@Column(name="staycode", nullable=false)
	private Integer stayCode;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="reservationcheckin", nullable=false)
	private LocalDate checkIn;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="reservationcheckout", nullable=false)
	private LocalDate checkOut;
	
	@Column(name="reservationpeople", nullable=false)
	private Integer people;
	
	@Column(name="reservationprice", nullable=false)
	private Integer price;
	
	@Column(name="stayname", nullable=false)
	private String stayName;

	@Builder
	public Reservation(Integer code, String email, Integer stayCode, LocalDate checkIn, LocalDate checkOut, Integer people,
			Integer price, String stayName) {
		super();
		this.code = code;
		this.email = email;
		this.stayCode = stayCode;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.people = people;
		this.price = price;
		this.stayName = stayName;
	}
	
}//end of Reservation
