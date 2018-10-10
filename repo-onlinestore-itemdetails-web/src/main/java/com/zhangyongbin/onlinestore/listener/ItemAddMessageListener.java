package com.zhangyongbin.onlinestore.listener;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zhangyongbin.onlinestore.pojo.Item;
import com.zhangyongbin.onlinestore.pojo.TbItem;
import com.zhangyongbin.onlinestore.pojo.TbItemDesc;
import com.zhangyongbin.onlinestore.service.ItemService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 接收商品添加时发送的消息，然后使用freemarker进行静态页面的生成
 */
@Component
public class ItemAddMessageListener {
   @Reference(version = "1.0.0")
   private ItemService itemService;
   @Autowired
   private FreeMarkerConfigurer freeMarkerConfigurer;
   @Value("${HTML_OUT_PATH}")
   private String HTML_OUT_PATH;
    @JmsListener(destination = "itemAddTopic")
    public void onMessage(String message) {
        try {
            long itemId = Long.parseLong(message);
            //等待事务提交
            Thread.sleep(1000);
            //根据商品Id查询商品数据
            TbItem tbItem = itemService.getItemById(itemId);
            Item item = new Item(tbItem);
            TbItemDesc tbItemDesc = (TbItemDesc) itemService.getItemDescById(itemId).getData();
            Configuration configuration = freeMarkerConfigurer.getConfiguration();
            configuration.setDefaultEncoding("utf-8");
            Template template = configuration.getTemplate("ftl/item.ftl");
            Map data = new HashMap();
            data.put("item",item);
            data.put("itemDesc",tbItemDesc);
            //注意中文乱码问题
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(HTML_OUT_PATH+message+".html"),"utf-8"));
            template.process(data,out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
