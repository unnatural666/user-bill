package test.two.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
        money mymoney=moneyService.showMoneyInfo(currentUserController.account);
        return mymoney;
    }

    @PostMapping("/charge")
    public String charge(String money){
        return moneyService.ChargeMoney(money);
    }

}
