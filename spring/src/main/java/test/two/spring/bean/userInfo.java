package test.two.spring.bean;

import lombok.Data;

@Data
public class userInfo {
        public userInfo(){
            super();
        }
    private Integer id;
    private String tel;
    private String username;
    private String password;
    private String email;
    private String address;

    public Integer getId() {
        return id;
    }

    public String getTel() {
        return tel;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
