package test.two.spring.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    public static String getCookie(HttpServletRequest request,String username){
        Cookie[] cookies=request.getCookies();
        if (cookies!=null){
          for (Cookie cookie:cookies){
              if (username.equals(cookie.getName())){
                  return cookie.getValue();
              }
          }
        }
        return null;
    }

    public static void addCookie(HttpServletResponse response, String username, String value, int maxAge){
        Cookie cookie=new Cookie(username,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    public static void removeCokkie(HttpServletResponse response,String username){
        addCookie(response,username,null,0);
    }
}
