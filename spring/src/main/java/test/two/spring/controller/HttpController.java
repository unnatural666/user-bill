package test.two.spring.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.two.spring.service.RegisterService;
import test.two.spring.util.ErrorCode;
import test.two.spring.util.GetMessage;

import static test.two.spring.util.GetMessage.getResult;

@RestController

public class HttpController {

    private RegisterService registerService;
    @Autowired
    public HttpController(RegisterService registerService){
        this.registerService=registerService;
    }

    @PostMapping(value = "/login",produces = "application/json",consumes = "application/json")

    public String getMsg(@RequestBody String tel) {
        JSONObject jsonObject = JSON.parseObject(tel);
        String telephone= (String) jsonObject.get("tel");
        //getResult(telephone);
        return registerService.reg1(telephone);
        //System.out.println(telephone);
        //return null;
    }

    @PostMapping(value = "/register",produces = "application/json",consumes = "application/json")
    public String register( @RequestBody String code){
        JSONObject jsonObject = JSON.parseObject(code);
        String coding= (String) jsonObject.get("level");
        String telephone= (String) jsonObject.get("tel");
        //GetMessage getMessage=new GetMessage();
       /* System.out.println(coding);
        System.out.println(telephone);*/
        //System.out.println(getMessage.randNum);
       return registerService.reg2(coding,telephone);

       // System.out.println(coding);
       // return null;
    }

}
