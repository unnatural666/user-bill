package test.two.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.two.spring.bean.userInfo;
import test.two.spring.mapper.RegisterMapper;
import test.two.spring.util.ErrorCode;
import test.two.spring.util.GetMessage;

@Service
public class RegisterService {

    private RegisterMapper registerMapper;
    @Autowired
    public RegisterService(RegisterMapper registerMapper) {
        this.registerMapper = registerMapper;
    }

    public String reg1(String tel){
        //String telephone=registerMapper.SelectTel(tel);
         String telephone=registerMapper.SelectTel(tel);
        if(telephone!=null){
            return ErrorCode.WRONG_NAME;
        }else {
            return ErrorCode.SUCCESS;
        }
    }
    public String reg2(String code,String tel) {
        //GetMessage getMessage=new GetMessage();
        String x="344826";
        if(code.equals(x)){
           registerMapper.addUserinfo(tel);
            /*if(num!=0){
                System.out.println("xxxx");

            }*/
            return ErrorCode.SUCCESS;
        }else {
            System.out.println("yyyyy");
            return ErrorCode.WRONG_NAME;
        }
        //return x;
    }
}
