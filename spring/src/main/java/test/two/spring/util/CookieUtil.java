package test.two.spring.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    public static String getCookie(HttpServletRequest request,String tel){
        Cookie[] cookies=request.getCookies();
        if (cookies!=null){
          for (Cookie cookie:cookies){
              if (tel.equals(cookie.getName())){
                  return cookie.getValue();
              }
          }
        }
        return null;
    }

    public static void addCookie(HttpServletResponse response, String tel, String value, int maxAge){
        Cookie cookie=new Cookie(tel,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    public static void removeCookie(HttpServletResponse response,String tel){
        addCookie(response,tel,null,0);
    }
}
