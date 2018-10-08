package com.zhangyongbin.onlinestore.listener;

import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
/**
 * 接收商品删除的消息
 */
@Component
public class ItemDeleteMessageListener {
    @Autowired
    private CloudSolrServer solrServer;
    @Value("${spring.data.solr.defaultCollection}")
    private String defaultCollection;
    @JmsListener(destination = "itemDeleteTopic")
    public void onMessage(String message) {
        try {

            long itemId = Long.parseLong(message);
            //根据id将索引库中的document删除
            solrServer.setDefaultCollection(defaultCollection);
            solrServer.deleteById(Long.toString(itemId));
            solrServer.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
