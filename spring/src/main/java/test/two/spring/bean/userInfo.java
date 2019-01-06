package test.two.spring.bean;

import lombok.Data;
import test.two.spring.entity.BaseEntity;

@Data
public class userInfo extends BaseEntity<Integer> {

    private static final long serialVersionUID = -4454737765850239378L;

        public userInfo(){
            super();
        }
    private String account;
    private String eename;
    private String lgname;
    private String password;
    private String email;
    private String address;
    private String idcard;

    //验证码
    private String auth;
    //盐
    private String salt;

    /**
     * 是否是管理员
     */
    private Boolean admin = false;
/*
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

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

    public String getLgname() {
        return lgname;
    }

    public void setLgname(String lgname) {
        this.lgname = lgname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "userInfo{" + "account='" + account + '\'' + ", eename='" + eename + '\'' + ", lgname='" + lgname + '\'' + ", password='" + password + '\'' + ", email='" + email + '\'' + ", address='" + address + '\'' + ", idcard='" + idcard + '\'' + ", auth='" + auth + '\'' + ", salt='" + salt + '\'' + ", admin=" + admin + '}';
    }
}
