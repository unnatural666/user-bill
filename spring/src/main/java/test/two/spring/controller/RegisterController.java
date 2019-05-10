package test.two.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.two.spring.bean.userInfo;
import test.two.spring.result.Result;
import test.two.spring.result.ResultCode;
import test.two.spring.service.MoneyService;
import test.two.spring.service.RegisterService;
import test.two.spring.service.UserService;

@RestController

public class RegisterController {

    @Autowired
    private UserService userService;
    @Autowired
    private RegisterService registerService;
    @Autowired
    private MoneyService moneyService;
    @Autowired
    private LoginController loginController;
    @Autowired
    private CurrentUserController userController;
    @Autowired
    public RegisterController(RegisterService registerService){
        this.registerService=registerService;
    }

    @PostMapping(value = "/gettel",produces = "application/json",consumes = "application/json")
    public String getMsg(@RequestBody userInfo user) {
        String telephone=user.getAccount();
        return registerService.reg1(telephone);
    }

    @PostMapping(value = "/register",produces = "application/json",consumes = "application/json")
    public Result register(@RequestBody userInfo user){
        Result r=new Result();
        System.out.println(user.toString());
        if(userService.info(user.getAccount())){
            r.setResultCode(ResultCode.USER_HAS_EXISTED);
            return r;
        }
        String account = user.getAccount();
        String password = user.getPassword();
        int userId=registerService.reg2(user);
        if(userId > 0){
           loginController.executeLogin(account, password, r);
        }else{
            r.setResultCode(ResultCode.USER_Register_ERROR);
        }
        return r;
    }

    @PostMapping(value = "/addinfo",produces = "application/json",consumes = "application/json")
    public Result addInfo(@RequestBody userInfo user){
        Result r=new Result();
        userService.addInfo(user.getEename(),user.getLgname(),user.getEmail(),user.getAddress(),user.getIdcard(),userController.account);
        moneyService.addInfo(userController.account,user.getEename());
        r.setResultCode(ResultCode.SUCCESS);
        return r;
    }


}
