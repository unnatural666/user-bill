package test.two.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.two.spring.bean.money;
import test.two.spring.mapper.MoneyMapper;

@Service
public class MoneyService {
    @Autowired
    private MoneyMapper moneyMapper;

    public int addInfo(String account){
        int money=moneyMapper.addMoneyInfo(account);
        return money;
    }

    public money showMoneyInfo(String account){
        money myMoney=moneyMapper.findMoneyByAccount(account);
        return myMoney;
    }
}
