package project.shoesUp2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import project.shoesUp2.beans.UserBean;

//프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration
public class WebConfig {

    //세션스코프: 브라우저가 최초의 요청시키는 시점, 최초 요청 발생할때 주입
    @Bean("loginUserBean")
    @SessionScope
    public UserBean loginUserBean(){
        return new UserBean();
    }
}
