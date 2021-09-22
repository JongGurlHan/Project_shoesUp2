package project.shoesUp2.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import project.shoesUp2.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TopMenuInterceptor implements HandlerInterceptor {

    private UserBean loginUserBean;

    public TopMenuInterceptor(UserBean loginUserBean) {
        this.loginUserBean = loginUserBean;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("loginUserBean", loginUserBean);
        return true;
        }
}
