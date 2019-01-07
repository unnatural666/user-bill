package test.two.spring.bean;

import lombok.Data;

import java.util.Date;

@Data
public class billInfo {

    private int id;
    private String billname;
    private String eename;
    private String money;
    private String billtime;
    private String flaw;
    private String want;
    private String endorse;
    private String path;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillname() {
        return billname;
    }

    public void setBillname(String billname) {
        this.billname = billname;
    }

    public String getEename() {
        return eename;
    }

    public void setEename(String eename) {
        this.eename = eename;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getBilltime() {
        return billtime;
    }

    public void setBilltime(String billtime) {
        this.billtime = billtime;
    }

    public String getFlaw() {
        return flaw;
    }

    public void setFlaw(String flaw) {
        this.flaw = flaw;
    }

    public String getWant() {
        return want;
    }

    public void setWant(String want) {
        this.want = want;
    }

    public String getEndorse() {
        return endorse;
    }

    public void setEndorse(String endorse) {
        this.endorse = endorse;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
