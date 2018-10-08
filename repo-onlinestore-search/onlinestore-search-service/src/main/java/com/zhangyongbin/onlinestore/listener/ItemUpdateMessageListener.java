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
 * 接收商品修改的消息
 */
@Component
public class ItemUpdateMessageListener {
    @Autowired
    private SearchItemMapper searchItemMapper;
    @Autowired
    private CloudSolrServer solrServer;
    @Value("${spring.data.solr.defaultCollection}")
    private String defaultCollection;
    @JmsListener(destination = "itemUpdateTopic")
    public void onMessage(String message) {
        try {

            long itemId = Long.parseLong(message);
            //根据商品Id进行索引的对应商品的更新操作
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
