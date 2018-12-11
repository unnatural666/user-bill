package test.two.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.two.spring.bean.userInfo;
import test.two.spring.service.LoginService;
import test.two.spring.util.CookieUtil;
import test.two.spring.util.ErrorCode;
import test.two.spring.util.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login",produces = "application/json",consumes = "application/json")
    public String login(@RequestBody userInfo user, HttpServletRequest request, HttpServletResponse response, HttpSession session){
        if(loginService.login(user.getTel(),user.getPassword())){
            SessionUtil.saveUserSession(session,user);
            CookieUtil.addCookie(response,"tel",user.getTel(),86400);
            return ErrorCode.SUCCESS;
        }else {
            return ErrorCode.WRONG_PWD;
        }
        //return null;
    }


}
