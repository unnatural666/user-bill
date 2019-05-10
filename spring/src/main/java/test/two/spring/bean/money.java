package test.two.spring.bean;

import lombok.Data;

@Data
public class money {
    private int id;
    String account;
    String eename;
    int money;
    int time;
    String expend;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEename() {
        return eename;
    }

    public void setEename(String eename) {
        this.eename = eename;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getExpend() {
        return expend;
    }

    public void setExpend(String expend) {
        this.expend = expend;
    }
}
