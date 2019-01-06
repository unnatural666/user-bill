package test.two.spring.oauth;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.springframework.beans.factory.InitializingBean;
import test.two.spring.cache.RedisManager;

import java.io.Serializable;

/**
 * 将session保存到redis
 */
public class OAuthSessionDAO extends CachingSessionDAO implements InitializingBean {

    private RedisManager redisManager;
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        redisManager.set(sessionId.toString(), session, RedisManager.DEFAULT_EXPIRE);
        return sessionId;
    }


    @Override
    protected void doUpdate(Session session) {
        if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
            return; //如果会话过期/停止 没必要再更新了
        }
        redisManager.set(session.getId().toString(), session, RedisManager.DEFAULT_EXPIRE);
    }

    @Override
    protected void doDelete(Session session) {
        redisManager.delete(session.getId().toString());
    }



    @Override
    protected Session doReadSession(Serializable sessionId) {
        return redisManager.get(sessionId.toString(), Session.class);
    }



    public RedisManager getRedisManager() {
        return redisManager;
    }

    public void setRedisManager(RedisManager redisManager) {
        this.redisManager = redisManager;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(null == this.redisManager){
        }

    }
}
