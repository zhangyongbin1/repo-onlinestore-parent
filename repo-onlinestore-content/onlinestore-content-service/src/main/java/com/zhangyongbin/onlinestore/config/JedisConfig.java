package com.zhangyongbin.onlinestore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class JedisConfig {
    @Value("${spring.redis.cluster.nodes}")
    private String jedisClusterNodes;

    @Value("${spring.redis.timeout}")
    private String timeOut;
    //    @Bean(name = "jedisPool")
//    public JedisPool getJedisPool(){
//
//        JedisPool jedisPool = new JedisPool(jedisPoolNode,jedisPoolPort);
//        return jedisPool;
//    }
    @Bean(name = "jedisCluster")
    public JedisCluster getJedisCluster(){
        Set<HostAndPort> allNodes = new HashSet<>();
        String[] nodes = jedisClusterNodes.split(",");
        //分割出集群ip和port
        for(String node : nodes){
            String[] hp = node.split(":");
            allNodes.add(new HostAndPort(hp[0],Integer.parseInt(hp[1])));
        }
        JedisCluster jedisCluster = new JedisCluster(allNodes,Integer.parseInt(timeOut));
        return jedisCluster;
    }

    public String getJedisClusterNodes() {
        return jedisClusterNodes;
    }

    public void setJedisClusterNodes(String jedisClusterNodes) {
        this.jedisClusterNodes = jedisClusterNodes;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }
}
