package test.two.spring.bean;

import lombok.Data;

@Data
public class money {
    private int id;
    String account;
    String eemane;
    String money;
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
    public String getEemane() {
        return eemane;
    }

    public void setEemane(String eemane) {
        this.eemane = eemane;
    }
    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
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
