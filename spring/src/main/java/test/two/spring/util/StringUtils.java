package test.two.spring.util;

public class StringUtils {
    public static boolean isEmpty(String value){
        if(null == value)
            return true;
        return value.isEmpty();
    }
}
