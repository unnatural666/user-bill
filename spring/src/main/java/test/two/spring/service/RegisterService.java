package test.two.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.two.spring.bean.userInfo;
import test.two.spring.mapper.RegisterMapper;
import test.two.spring.result.Code;
import test.two.spring.util.PasswordHelper;

import java.util.Random;

@Service
public class RegisterService {

    @Autowired
    private RegisterMapper registerMapper;
    @Autowired
    public RegisterService(RegisterMapper registerMapper) {
        this.registerMapper = registerMapper;
    }

    public String reg1(String account){
         String telephone=registerMapper.SelectTel(account);
        if(telephone!=null){
            return Code.WRONG_NAME;
        }else {
            //getResult(tel);
            return Code.SUCCESS;
        }
    }
    public int reg2(userInfo user) {
        String x="344826";
        if(user.getAuth().equals(x)){
            PasswordHelper.encryptPassword(user);
       // GetMessage getMessage=new GetMessage();

            return registerMapper.addUserinfo(user.getAccount(),user.getPassword(),user.getSalt());
        }else
            return -1;
    }
}
