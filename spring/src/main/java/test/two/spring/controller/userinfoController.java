package test.two.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import test.two.spring.bean.userInfo;
import test.two.spring.mapper.userInfoMapper;

@RestController
public class userinfoController {
    @Autowired
    userInfoMapper userInfoMapper;

    @GetMapping("/user/{id}")
    public userInfo getUser(@PathVariable("id") Integer id){
        return userInfoMapper.getUserById(id);
    }
}
