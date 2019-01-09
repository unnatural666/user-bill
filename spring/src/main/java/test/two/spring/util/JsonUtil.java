package test.two.spring.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;

public class JsonUtil {
    public String json(String json){

        JSONObject jsonObject = (JSONObject) JSONObject.parseObject(json).getJSONObject("data");
        JSONArray jsonArray = (JSONArray)jsonObject.getJSONArray("ret");
        JSONObject jsons=new JSONObject();
        List<HashMap> list = JSON.parseArray(jsonArray.toString(), HashMap.class);
        for(int i=0;i<list.size();i++){
            String x= (String) list.get(i).get("word");
            if (i==0){
                jsons.put("eename",x);
            }else if(i==1){
                jsons.put("billtime",x);
            }else if(i==2){
                jsons.put("flaw",x);
            }else if(i==3){
                jsons.put("money",x);
            }else if(i==4){
                jsons.put("billname",x);
            }
        }
        return String.valueOf(jsons);
    }
}
