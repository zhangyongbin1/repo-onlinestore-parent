package com.zhangyongbin.onlinestore;

import com.zhangyongbin.onlinestore.common.pojo.SearchItem;
import com.zhangyongbin.onlinestore.mapper.SearchItemMapper;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlinestoreSearchServiceApplication.class)
public class OnlinestoreSearchServiceApplicationTests {
    @Autowired
    private SearchItemMapper searchItemMapper;
    @Autowired
    private CloudSolrServer solrServer;
    @Value("${spring.data.solr.defaultCollection}")
    private String defaultCollection;
	@Test
	public void contextLoads() {
        try {

            SolrInputDocument solrDocument = new SolrInputDocument();
                solrDocument.addField("id", "1111111111111111");
                solrDocument.addField("item_title", "1111111111111111");
                solrDocument.addField("item_sell_point","1111111111111111");
                solrDocument.addField("item_price",Long.valueOf(1111111));
                solrDocument.addField("item_image","1111111111111111");
                solrDocument.addField("item_category_name","1111111111111111");
                solrDocument.addField("item_desc","1111111111111111");
                solrServer.setDefaultCollection(defaultCollection);
                solrServer.add(solrDocument);
                solrServer.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
