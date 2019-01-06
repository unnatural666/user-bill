package test.two.spring.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.two.spring.bean.userInfo;
import test.two.spring.oauth.OAuthSessionManager;
import test.two.spring.result.Code;
import test.two.spring.result.Result;
import test.two.spring.result.ResultCode;
import test.two.spring.service.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login",produces = "application/json",consumes = "application/json")
    public Result login(@RequestBody userInfo user){
       Result r=new Result();
        executeLogin(user.getAccount(), user.getPassword(), r);
        return r;
    }

    protected void executeLogin(String account, String password, Result r){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(account,password);
        try {
            subject.login(token);

            userInfo currentUser=userService.getUserByTel(account);
            subject.getSession().setAttribute(Code.CURRENT_USER,currentUser);

            r.setResultCode(ResultCode.SUCCESS);
            r.simple().put(OAuthSessionManager.OAUTH_TOKEN,subject.getSession().getId());
        }catch (UnknownAccountException e){
            r.setResultCode(ResultCode.USER_NOT_EXIST);
        }catch (LockedAccountException e) {
            r.setResultCode(ResultCode.USER_ACCOUNT_FORBIDDEN);
        } catch (AuthenticationException e) {
            r.setResultCode(ResultCode.USER_LOGIN_ERROR);
        } catch (Exception e) {
            r.setResultCode(ResultCode.ERROR);
        }

    }
    @RequestMapping(value = "/handleLogin")
    public Result handleLogin(HttpServletRequest request) {
        String id = request.getHeader(OAuthSessionManager.OAUTH_TOKEN);
        System.out.println("超时登录。。。:" + id);
        return Result.error(ResultCode.SESSION_TIME_OUT);
    }

    @GetMapping("/logout")
    public Result logout() {

        Result r = new Result();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        r.setResultCode(ResultCode.SUCCESS);
        return r;
    }
}
