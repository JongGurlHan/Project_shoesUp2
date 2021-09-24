package project.shoesUp2.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.shoesUp2.beans.UserBean;
import project.shoesUp2.dao.UserDao;

import javax.annotation.Resource;


@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    //로그인 한 사용자의 정보를 담는다.
    @Resource(name = "loginUserBean")
    private UserBean loginUserBean;

    public boolean checkUserIdExist(String user_id){
        String user_name = userDao.checkUserIdExist(user_id);
      //아이디에 해당하는 유저명이 없으면 true, 있으면 false
        if(user_name == null){
            return true;
        }else {
            return false;
        }
    }

    public void addUserInfo(UserBean userBean){
        userDao.addUserInfo(userBean);
    }

    public void getLoginUserInfo(UserBean tempLoginUserBean){
        UserBean tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean);

        //회원정보가 있다면 loginUserBean에 회원 정보를 넣어준다.
        if(tempLoginUserBean2 != null){
            loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
            loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
            loginUserBean.setUserLogin(true);
        }

    }

    public void getModifyUserInfo(UserBean modifyUserBean){
        UserBean tempModifyUserBean = userDao.getModifyUserInfo(loginUserBean.getUser_idx());

        modifyUserBean.setUser_id(tempModifyUserBean.getUser_id());
        modifyUserBean.setUser_name(tempModifyUserBean.getUser_name());
        modifyUserBean.setUser_idx(tempModifyUserBean.getUser_idx());

    }


    public void modifyUserInfo(UserBean modifyUserBean){
        modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
        userDao.modifyUserInfo(modifyUserBean);
    }




}
