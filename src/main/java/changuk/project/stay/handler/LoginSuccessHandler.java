package changuk.project.stay.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import changuk.project.stay.domain.Member;
import changuk.project.stay.repository.MemberRepository;

/** 로그인 성공 후 작업을 위한 핸들러 **/
@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	
	private @Autowired MemberRepository repository;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		Member member = repository.findByEmail(authentication.getName());
		request.getSession().setAttribute("member", member);
		
		getRedirectStrategy().sendRedirect(request, response, "/");
		
	}
	
}//end of LoginSuccessHandler
