package test.two.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.two.spring.bean.userInfo;
import test.two.spring.result.Result;
import test.two.spring.result.ResultCode;
import test.two.spring.service.UserService;
import test.two.spring.util.UserUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class CurrentUserController {

    public static String account;

    @Autowired
    private UserService userService;

    @GetMapping
    public Result listUsers(){
        List<userInfo> users = userService.findAll();

        return Result.success(users);
    }

    @GetMapping("/currentUser")
    public Result getCurrentUser(HttpServletRequest request){

        Result r = new Result();

        userInfo currentUser = UserUtils.getCurrentUser();

        r.setResultCode(ResultCode.SUCCESS);
        r.setData(currentUser);
        account=currentUser.getAccount();
        return r;
    }

}
