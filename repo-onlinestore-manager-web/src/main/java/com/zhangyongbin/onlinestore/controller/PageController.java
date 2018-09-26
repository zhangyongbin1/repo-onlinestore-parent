package com.zhangyongbin.onlinestore.controller;
/*用于展示后台管理系统的jsp页面*/

import com.alibaba.dubbo.config.annotation.Reference;
import com.zhangyongbin.onlinestore.common.utils.JsonUtils;
import com.zhangyongbin.onlinestore.service.ItemCatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {
    @Reference(version = "1.0.0")
    private ItemCatService itemCatService;
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("/{page}")//因为请求url与jsp页面的名字相同,所以请求那个页面就直接返回就行
    public String showPage(@PathVariable String page){
        return page;
    }
    /*@RequestMapping("/demo")
    public String ItemCatServiceController(){
        List list = itemCatService.getItemCatList(0);
        String json = JsonUtils.objectToJson(list);
        System.out.println("test ItemCatService: "+json);
        return "index";
    }*/
}