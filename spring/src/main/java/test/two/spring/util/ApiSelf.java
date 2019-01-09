package test.two.spring.util;

import com.baidu.aip.util.Util;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class ApiSelf {
    /*public static void main(String[] args) {

        String filePath = "F:\\billimage\\03l.jpg";

        System.out.println(custom(filePath));

    }*/
    public JSONObject custom (String file) {
        HashMap<String,String> options = new HashMap<>(6);
        String templateSign = "3ed761aef026cf782ffa8ea4f190f115"; //通用模板的 编号

        AIPOcrJava aipOcrJava = new AIPOcrJava();
        // JSONObject jsonObject = aipOcrJava.basicAccurateGeneral(file, options);  或者是传url
        byte[] bytes = new byte[0];
        try {
            bytes = Util.readFileByBytes(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = aipOcrJava.custom(bytes,templateSign,options);
        return jsonObject;
    }
}
