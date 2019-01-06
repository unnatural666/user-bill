package test.two.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.test.context.junit4.SpringRunner;
import test.two.spring.cache.RedisRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    RedisRepository redisRepo;
    @Autowired
    RedisConnectionFactory factory;

    @Test
    public void testRedis1(){
        redisRepo.add("test", "123", 1L);
        String val = redisRepo.get("test");
        assertEquals(val, "123");
        System.out.println(val);
        val = redisRepo.get("321");
        System.out.println(val);
        assertNull(val);
    }
    @Test
    public void testRedis(){
        //得到一个连接
        RedisConnection conn = factory.getConnection();
        conn.set("hello".getBytes(), "world".getBytes());
        System.out.println(new String(conn.get("hello".getBytes())));
    }
}
