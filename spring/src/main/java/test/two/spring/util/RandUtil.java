package test.two.spring.util;

import java.util.Random;

public class RandUtil {
    public static String getRandNum(){
        String randNum=new Random().nextInt(1000000)+"";
        if(randNum.length()!=6){
            return getRandNum();
        }
        return randNum;
    }
}
