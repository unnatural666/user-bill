package test.two.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.two.spring.bean.money;
import test.two.spring.service.MoneyService;
import test.two.spring.service.UserService;

@RestController
public class MoneyController {

    @Autowired
    MoneyService moneyService;
    @Autowired
    CurrentUserController currentUserController;
    @Autowired
    UserService userService;

    @PostMapping("/showmoney")
    public money showMoney(){
        return moneyService.showMoneyInfo(currentUserController.account);
    }

    @PostMapping("/charge")
    public int charge(@RequestBody money m){
        return moneyService.ChargeMoney(m.getMoney());
    }

}
