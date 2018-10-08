package com.zhangyongbin.onlinestore.listener;

import com.zhangyongbin.onlinestore.common.pojo.SearchItem;
import com.zhangyongbin.onlinestore.mapper.SearchItemMapper;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


/**
 * 接收activeMq的topic生产者生产的消息，然后进行索引库的同步
 */
@Component
public class ItemAddMessageListener {
    @Autowired
    private SearchItemMapper searchItemMapper;
    @Autowired
    private CloudSolrServer solrServer;
    @Value("${spring.data.solr.defaultCollection}")
    private String defaultCollection;
    @JmsListener(destination = "itemAddTopic")
    public void onMessage(String message) {
        try {
            //从消息中取出商品ID
            long itemId = Long.parseLong(message);
            //根据商品ID去item数据表中将数据取出然后同步到索引库中
            //等待事务提交
            Thread.sleep(1000);
            SearchItem searchItem = searchItemMapper.getItemById(itemId);
            //将searchItem同步到索引库中
            SolrInputDocument document = new SolrInputDocument();
            document.addField("id",searchItem.getId());
            document.addField("item_title",searchItem.getTitle());
            document.addField("item_sell_point",searchItem.getSell_point());
            document.addField("item_price",searchItem.getPrice());
            document.addField("item_image",searchItem.getImage());
            document.addField("item_category_name",searchItem.getCategory_name());
            document.addField("item_desc",searchItem.getItem_desc());
            solrServer.setDefaultCollection(defaultCollection);
            solrServer.add(document);
            //提交
            solrServer.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
