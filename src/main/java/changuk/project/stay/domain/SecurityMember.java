package changuk.project.stay.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class SecurityMember extends User{

	public SecurityMember(Member m) {
		super(m.getEmail(), m.getPassword(), makeGrantedAuthority("ROLE_ADMIN"));
	}
	
	private static List<GrantedAuthority> makeGrantedAuthority(String s){
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority(s));
		return list;
	}

}//end of SecurityMember
