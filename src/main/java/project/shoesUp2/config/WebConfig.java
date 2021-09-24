package project.shoesUp2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import project.shoesUp2.beans.UserBean;
import project.shoesUp2.interceptor.TopMenuInterceptor;

import javax.annotation.Resource;

//프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource(name="loginUserBean")
    private UserBean loginUserBean;

    //세션스코프: 브라우저가 최초의 요청시키는 시점, 최초 요청 발생할때 주입
    @Bean("loginUserBean")
    @SessionScope
    public UserBean loginUserBean(){
        return new UserBean();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TopMenuInterceptor(loginUserBean))
                .order(1)
                .addPathPatterns("/**");
    }


}