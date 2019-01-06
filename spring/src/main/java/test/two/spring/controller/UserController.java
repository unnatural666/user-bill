package test.two.spring.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import test.two.spring.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    CurrentUserController currentUserController;

    @PostMapping("getuserinfo")
    public String getUserInfo(){
        JSONObject jsonObject=new JSONObject();
        return jsonObject.toJSONString(userService.getUserByTel(currentUserController.account));
    }
}
