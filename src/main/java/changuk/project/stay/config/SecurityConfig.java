package changuk.project.stay.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import changuk.project.stay.handler.LoginSuccessHandler;
import changuk.project.stay.service.impl.SecurityMemberServiceImpl;

/** Spring Security Config - Spring Security 관련 설정 **/
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private @Autowired SecurityMemberServiceImpl service;
	private @Autowired PasswordEncoder encoder;
	private @Autowired LoginSuccessHandler handler;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception
	{
		web.ignoring().antMatchers("/css/**", "/img/**", "/data/**", "/scss/**", "/vendor/**"
				,"/js/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/stay", "/member/check/**", "/stay/add", "/member", "/stay/search").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/").loginProcessingUrl("/login")
		.defaultSuccessUrl("/")
		.successHandler(handler)
		.failureUrl("/")
		.usernameParameter("email")
		.passwordParameter("password")
		.permitAll()
		.and().logout().logoutUrl("/logout").permitAll()
		.and().csrf().disable();
		
	}//end of configure

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(encoder);
	}
	
	
	
}//end of SecurityConfig
