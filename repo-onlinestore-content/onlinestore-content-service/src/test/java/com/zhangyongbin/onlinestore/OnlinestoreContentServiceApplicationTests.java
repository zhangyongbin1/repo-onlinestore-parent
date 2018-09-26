package com.zhangyongbin.onlinestore;

import com.zhangyongbin.onlinestore.jedis.JedisClientCluster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlinestoreContentServiceApplication.class)
public class OnlinestoreContentServiceApplicationTests {
    @Autowired
    private JedisClientCluster jedisClientCluster;
    @Value("${ITEM_INFO}")
    private String ITEM_INFO;
    @Value("${EXPIRED_TIME}")
    private Integer EXPIRED_TIME;
    @Value("${spring.redis.cluster.nodes}")
    private String jedisClusterNodes;
    @Value("${spring.redis.timeout}")
    private String timeout;
    @Test
    public void testJedisClientCluster() {
        String num = jedisClientCluster.set("jedistest", "1234567890");
        assertEquals("OK", num);
//        System.out.println("jedis set status: "+ num);
        String value = jedisClientCluster.get("jedistest");
//        System.out.println("jedis get value by key: "+ value);
        assertEquals("1234567890", value);
    }

    @Test
    public void testGetValueFromApplicationProperties() {
        assertEquals("ITEM_INFO",ITEM_INFO);
        assertEquals(Integer.valueOf(86400),EXPIRED_TIME);
        assertEquals("192.168.26.130:7001,192.168.26.130:7002,192.168.26.130:7003,192.168.26.130:7004,192.168.26.130:7005,192.168.26.130:7006",jedisClusterNodes);
        assertEquals("500000",timeout);
    }

}
