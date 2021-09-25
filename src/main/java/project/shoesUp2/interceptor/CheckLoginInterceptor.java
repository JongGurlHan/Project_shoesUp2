package project.shoesUp2.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import project.shoesUp2.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckLoginInterceptor implements HandlerInterceptor {

    private UserBean loginUserBean;

    public CheckLoginInterceptor(UserBean loginUserBean) {
        this.loginUserBean = loginUserBean;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //로그인 안했다면
        if(loginUserBean.isUserLogin() == false){
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/user/not_login");
            return false;
        }
        //로그인 했다면 다음단계(컨트롤러)로 진행
        return true;
    }
}
