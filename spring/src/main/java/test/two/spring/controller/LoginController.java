package test.two.spring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import test.two.spring.bean.userInfo;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(userInfo user){
        return null;
    }


}
