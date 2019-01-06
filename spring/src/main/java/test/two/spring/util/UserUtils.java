package test.two.spring.util;

import org.apache.shiro.SecurityUtils;
import test.two.spring.bean.userInfo;
import test.two.spring.result.Code;

public class UserUtils {
    public static userInfo getCurrentUser(){
        userInfo user = (userInfo) SecurityUtils.getSubject().getSession().getAttribute(Code.CURRENT_USER);
        return user;
    }
}
