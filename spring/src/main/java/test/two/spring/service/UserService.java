package test.two.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.two.spring.bean.billInfo;
import test.two.spring.bean.userInfo;
import test.two.spring.mapper.BillMapper;
import test.two.spring.mapper.UserMapper;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BillMapper billMapper;

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

    public int addInfo(String eename,String lgname,String email,String address,String idcard,String account){
        int user=userMapper.addInfo(eename,lgname,email,address,idcard,account);
        return user;
    }

    public int findId(String account){
        return userMapper.findUserId(account);
    }

    public billInfo showMyBill(String account){
        return billMapper.showMyBill(account);
    }
}
