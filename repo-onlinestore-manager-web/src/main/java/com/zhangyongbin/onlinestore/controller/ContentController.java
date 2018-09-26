package com.zhangyongbin.onlinestore.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zhangyongbin.onlinestore.common.pojo.EasyUIDataGridResult;
import com.zhangyongbin.onlinestore.common.pojo.OnlinStoreResult;
import com.zhangyongbin.onlinestore.pojo.TbContent;
import com.zhangyongbin.onlinestore.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 内容管理controller
 */
@Controller
public class ContentController {
    @Reference(version = "1.0.0")
    private ContentService contentService;
    @RequestMapping("/content/query/list")
    @ResponseBody//根据分类Id进行查询
    public EasyUIDataGridResult getContentList(Long categoryId, Integer page, Integer rows){
        return contentService.getContentList(categoryId,page,rows);
    }

    @RequestMapping("/content/save")
    @ResponseBody
    public OnlinStoreResult addContent(TbContent tbContent){
        return contentService.addContent(tbContent);
    }

    @RequestMapping("/content/edit")
    @ResponseBody
    public OnlinStoreResult editContent(TbContent tbContent){
        return contentService.editContent(tbContent);
    }
    @RequestMapping("/content/delete")
    @ResponseBody
    public OnlinStoreResult deleteContent(Long ids){
        return contentService.deleteContent(ids);
    }
}
