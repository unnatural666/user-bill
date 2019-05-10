package test.two.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import test.two.spring.bean.money;
import test.two.spring.service.MoneyService;

@RestController
public class MoneyController {

    @Autowired
    MoneyService moneyService;
    @Autowired
    CurrentUserController currentUserController;

    @PostMapping("/showmoney")
    public money showMoney(){
        money mymoney=moneyService.showMoneyInfo(currentUserController.account);
        return mymoney;
    }

}
