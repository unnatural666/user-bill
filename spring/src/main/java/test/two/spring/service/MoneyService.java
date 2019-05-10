package test.two.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.two.spring.bean.money;
import test.two.spring.controller.CurrentUserController;
import test.two.spring.mapper.MoneyMapper;

@Service
public class MoneyService {
    @Autowired
    private MoneyMapper moneyMapper;
    @Autowired
    CurrentUserController currentUserController;

    public int addInfo(String account,String eename){
        int money=moneyMapper.addMoneyInfo(account,eename);
        return money;
    }

    public money showMoneyInfo(String account){
        money myMoney=moneyMapper.findMoneyByAccount(account);
        return myMoney;
    }

    public String ChargeMoney(String money){
        String mon=moneyMapper.findMymoneyByAccount(currentUserController.account);
        int myTime=moneyMapper.findTimeByAccount(currentUserController.account);
        String myMoney=money+mon;
        int time=myTime+1;
        return moneyMapper.charge(myMoney,time,currentUserController.account);
    }
}
