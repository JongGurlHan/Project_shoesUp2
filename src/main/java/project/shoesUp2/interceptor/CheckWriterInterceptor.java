package project.shoesUp2.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import project.shoesUp2.beans.ContentBean;
import project.shoesUp2.beans.UserBean;
import project.shoesUp2.service.BoardService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//아무나 수정 및 삭제 못하게하는 인터셉터 , modify와 delete에만 반응할 수 있게 세팅
public class CheckWriterInterceptor implements HandlerInterceptor {

    //로그인한 유저 정보 가져오기
    private UserBean loginUserBean;

    private BoardService boardService;

    //인터셉터는 빈을 주입 받을 수 없기에 생성자로
    public CheckWriterInterceptor(UserBean loginUserBean, BoardService boardService) {
        this.loginUserBean = loginUserBean;
        this.boardService = boardService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String str1 = request.getParameter("content_idx");
        int content_idx = Integer.parseInt(str1);

        ContentBean currentContentBean = boardService.getContentInfo(content_idx);

        //현재 게시글 정보 가져오기
        if(currentContentBean.getContent_writer_idx() != loginUserBean.getUser_idx()) {
            String contextPath = request.getContextPath();
            response.sendRedirect( contextPath+"/board/not_writer");
            return false;
        }

        return true;
    }
}



