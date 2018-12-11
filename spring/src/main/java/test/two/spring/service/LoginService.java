package test.two.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.two.spring.bean.userInfo;
import test.two.spring.mapper.LoginMapper;

@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    public Boolean login(String tel,String password){

        userInfo user = loginMapper.findUserByNamePassWord(tel,password);
        if(user!=null){
            //System.out.println(tel);
            return true;
        }else {
            return false;
            //System.out.println(password);
        }
        //return null;
    }
}
