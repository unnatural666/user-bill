package test.two.spring.interceptor;

import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import test.two.spring.cache.RedisManager;
import test.two.spring.oauth.OAuthSessionManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * session超时，让前端删除Token
 */
public class ClearTokenInteceptor extends HandlerInterceptorAdapter {
    private static final String SESSION_TIME_OUT_K = "SESSION_TIME_OUT";
    private static final String SESSION_TIME_OUT_V = "timeout";

    @Autowired
    private RedisManager redisManager;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String token = request.getHeader(OAuthSessionManager.OAUTH_TOKEN);

        if(null != token){
            Session s = redisManager.get(token, Session.class);

            if(null == s || null == s.getId()){
                response.setHeader(SESSION_TIME_OUT_K, SESSION_TIME_OUT_V);
            }
        }

        return super.preHandle(request, response, handler);
    }
}
