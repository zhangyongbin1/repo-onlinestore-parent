package com.zhangyongbin.onlinestore.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.zhangyongbin.onlinestore.common.pojo.OnlinStoreResult;
import com.zhangyongbin.onlinestore.service.SearchItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexManagerController {

    @Reference(version = "1.0.0")
    private SearchItemService searchItemService;
    @RequestMapping("/index/import")
    @ResponseBody
    public OnlinStoreResult importIndex(){
        return searchItemService.importItemIntoIndex();
    }
}
