package project.shoesUp2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import project.shoesUp2.beans.UserBean;
import project.shoesUp2.interceptor.CheckLoginInterceptor;
import project.shoesUp2.interceptor.CheckWriterInterceptor;
import project.shoesUp2.interceptor.TopMenuInterceptor;
import project.shoesUp2.service.BoardService;
import project.shoesUp2.service.TopMenuService;

import javax.annotation.Resource;

//프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TopMenuService topMenuService;

    @Resource(name="loginUserBean")
    private UserBean loginUserBean;

    @Autowired
    private BoardService boardService;

    //세션스코프: 브라우저가 최초의 요청시키는 시점, 최초 요청 발생할때 주입
    @Bean("loginUserBean")
    @SessionScope
    public UserBean loginUserBean(){
        return new UserBean();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new TopMenuInterceptor(topMenuService, loginUserBean))
                .order(1)
                .addPathPatterns("/**");

        registry.addInterceptor(new CheckLoginInterceptor(loginUserBean))
                .order(2)
                .addPathPatterns("/user/modify", "/user/logout", "/board/*")
                .excludePathPatterns("/items/items", "items/items_nike");

        registry.addInterceptor(new CheckWriterInterceptor(loginUserBean, boardService))
                .order(3)
                .addPathPatterns("/board/modify", "/board/delete");


    }

    @Bean
    public StandardServletMultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }


}
