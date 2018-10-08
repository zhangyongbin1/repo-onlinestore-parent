package com.zhangyongbin.onlinestore.config;

import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SolrConfig {

    @Value("${spring.data.solr.zk-host}")
    private String zkhost;
    @Bean(name = "solrServer")
    public CloudSolrServer getSolrClient(){
        return  new CloudSolrServer(zkhost);
    }
}
