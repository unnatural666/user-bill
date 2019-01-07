package test.two.spring.bean;

import lombok.Data;

import java.util.Date;

@Data
public class billInfo {

    private int id;
    private String billname;
    private String eename;
    private String money;
    private Date billtime;
    private String flaw;
    private String want;
    private String endorse;
    private String path;
}
