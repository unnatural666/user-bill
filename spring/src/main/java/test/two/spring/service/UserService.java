package test.two.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.two.spring.bean.userInfo;
import test.two.spring.mapper.UserMapper;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<userInfo> findAll(){
        List<userInfo> users=userMapper.findAll();
        return users;
    }

    public Boolean info(String account){
        String user = userMapper.findUserByTel(account);
        if(user!=null){
            return true;
        }else {
            return false;
        }
    }

    public userInfo getUserByTel(String account){
        userInfo user = userMapper.findUserByAccount(account);
        return user;
    }

    /*public userInfo findName(String account){
        userInfo user=userMapper.findUserName(account);
        return user;
    }*/

    public int addInfo(String eename,String lgname,String email,String address,String idcard,String account){
        int user=userMapper.addInfo(eename,lgname,email,address,idcard,account);
        return user;
    }
}
