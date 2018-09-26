package com.zhangyongbin.onlinestore.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zhangyongbin.onlinestore.common.pojo.EasyUITreeNode;
import com.zhangyongbin.onlinestore.common.pojo.OnlinStoreResult;
import com.zhangyongbin.onlinestore.service.ContentCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/content/category")
@Controller
public class ContentCategoryController {

    @Reference(version = "1.0.0")
    private ContentCategoryService contentCategoryService;
    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCatList(@RequestParam(value = "id",defaultValue = "0") long parentId){
            return contentCategoryService.getContentCategoryList(parentId);
    }

    @RequestMapping("/create")
    @ResponseBody
    public OnlinStoreResult createContentCategory(Long parentId, String name){
        return contentCategoryService.addContentCategory(parentId,name);
    }

    @RequestMapping("/update")
    @ResponseBody
    public OnlinStoreResult updateContentCategory(Long id, String name){
        return contentCategoryService.updateContentCategory(id,name);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public OnlinStoreResult deleteContentCategory(Long id){
        return contentCategoryService.deleteContentCategory(id);
    }
}
