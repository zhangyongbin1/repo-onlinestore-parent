package com.zhangyongbin.onlinestore.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zhangyongbin.onlinestore.common.pojo.OnlinStoreResult;
import com.zhangyongbin.onlinestore.common.pojo.SearchItem;
import com.zhangyongbin.onlinestore.mapper.SearchItemMapper;
import com.zhangyongbin.onlinestore.service.SearchItemService;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


import java.util.List;

@Service(version = "1.0.0",timeout = 300000)
public class SearchItemServiceImpl implements SearchItemService {

    @Autowired
    private SearchItemMapper searchItemMapper;
    @Autowired
    private CloudSolrServer solrServer;
    @Value("${spring.data.solr.defaultCollection}")
    private String defaultCollection;
    @Override//根据sql语句查询出来的所有的结果放入到索引库中
    public OnlinStoreResult importItemIntoIndex() {
        try {
            List<SearchItem> itemList = searchItemMapper.getItemList();
            for(SearchItem searchItem : itemList){
                SolrInputDocument solrDocument = new SolrInputDocument();
                solrDocument.addField("id", searchItem.getId());
                solrDocument.addField("item_title", searchItem.getTitle());
                solrDocument.addField("item_sell_point",searchItem.getSell_point());
                solrDocument.addField("item_price",searchItem.getPrice());
                solrDocument.addField("item_image",searchItem.getImage());
                solrDocument.addField("item_category_name",searchItem.getCategory_name());
                solrDocument.addField("item_desc",searchItem.getItem_desc());
                solrServer.setDefaultCollection(defaultCollection);
                solrServer.add(solrDocument);
            }
            solrServer.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return OnlinStoreResult.build(500,"导入索引库失败!");
        }
        return OnlinStoreResult.ok();
    }
}
