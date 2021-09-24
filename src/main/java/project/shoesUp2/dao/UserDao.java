package project.shoesUp2.dao;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.shoesUp2.beans.UserBean;
import project.shoesUp2.mapper.UserMapper;


@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public String checkUserIdExist(String user_id){
        return userMapper.checkUserIdExist(user_id);
    }

    public void addUserInfo(UserBean userBean){
        userMapper.addUserInfo(userBean);
    }

    public UserBean getLoginUserInfo(UserBean tempLoginUserBean){
        return userMapper.getLoginUserInfo(tempLoginUserBean);
    }

    public UserBean getModifyUserInfo(int user_idx){
        return userMapper.getModifyUserInfo(user_idx);
    }

    public void modifyUserInfo(UserBean modifyUserBean){
        userMapper.modifyUserInfo(modifyUserBean);
    }

}
