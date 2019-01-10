package test.two.spring.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.two.spring.bean.billInfo;
import test.two.spring.bean.userInfo;
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

    @PostMapping("/update")
    public int updateUserInfo(@RequestBody userInfo user){
        return userService.addInfo(user.getEename(),user.getLgname(),user.getEmail(),user.getAddress(),user.getIdcard(),currentUserController.account);
    }

    @RequestMapping("/showmybill")
    public billInfo showMyBill(){
        return userService.showMyBill(currentUserController.account);
    }
}
