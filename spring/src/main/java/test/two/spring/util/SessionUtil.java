package test.two.spring.util;

import test.two.spring.bean.userInfo;

import javax.servlet.http.HttpSession;

public class SessionUtil {

    public static void saveUserSession(HttpSession session, userInfo user){

        session.setAttribute("LoginUser",user);
    }

    public static userInfo getUserSession(HttpSession session){
        Object attribute=session.getAttribute("LoginUser");
        if(attribute==null){
            return null;
        }else {
            return (userInfo) attribute;
        }
    }

    public static void deleteUserSession(HttpSession session) {
        session.removeAttribute("LoginUser");
    }
}
