package com.zhangyongbin.onlinestore.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.zhangyongbin.onlinestore.pojo.Item;
import com.zhangyongbin.onlinestore.pojo.TbItem;
import com.zhangyongbin.onlinestore.pojo.TbItemDesc;
import com.zhangyongbin.onlinestore.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemDetailsController {
    @Reference(version = "1.0.0")
    private ItemService itemService;

    @RequestMapping("/item/{itemId}.html")
    public String showItem(@PathVariable long itemId, Model model){
        //根据商品Id查询商品
        TbItem tbItem = itemService.getItemById(itemId);
        Item item = new Item(tbItem);
        //获取商品详情
        TbItemDesc itemDesc =(TbItemDesc) itemService.getItemDescById(itemId).getData();
        model.addAttribute("item",item);
        model.addAttribute("itemDesc",itemDesc);
        //返回逻辑视图
        return "item";
    }
}
