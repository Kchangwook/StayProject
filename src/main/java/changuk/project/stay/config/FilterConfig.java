package changuk.project.stay.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

/** 각종 필터 빈을 생성하는 클래스 **/
@Configuration
public class FilterConfig {

	/** PUT, DELETE Method를 사용하기 위한 빈 **/
	@Bean
	public FilterRegistrationBean<HiddenHttpMethodFilter> httpHidden() {
		
		FilterRegistrationBean<HiddenHttpMethodFilter> bean = new FilterRegistrationBean<>();
		bean.setFilter(new HiddenHttpMethodFilter());
		
		return bean;
		
	}//end of httpHidden
	
}//end of FilterConfig
