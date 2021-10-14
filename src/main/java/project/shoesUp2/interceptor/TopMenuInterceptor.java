package project.shoesUp2.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import project.shoesUp2.beans.BoardInfoBean;
import project.shoesUp2.beans.UserBean;
import project.shoesUp2.service.TopMenuService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class TopMenuInterceptor implements HandlerInterceptor {

    private TopMenuService topMenuService;
    private UserBean loginUserBean;

    public TopMenuInterceptor(TopMenuService topMenuService, UserBean loginUserBean) {
        this.topMenuService = topMenuService;
        this.loginUserBean = loginUserBean;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
        request.setAttribute("topMenuList", topMenuList);
        request.setAttribute("loginUserBean", loginUserBean);
        return true;
        }
}
