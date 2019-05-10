package test.two.spring.bean;

import lombok.Data;

@Data
public class money {
    private int id;
    String account;
    String money;
    String time;
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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getExpend() {
        return expend;
    }

    public void setExpend(String expend) {
        this.expend = expend;
    }
}
