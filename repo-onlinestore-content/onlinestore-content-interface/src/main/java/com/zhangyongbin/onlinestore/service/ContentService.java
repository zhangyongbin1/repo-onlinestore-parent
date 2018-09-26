package com.zhangyongbin.onlinestore.service;

import com.zhangyongbin.onlinestore.common.pojo.EasyUIDataGridResult;
import com.zhangyongbin.onlinestore.common.pojo.OnlinStoreResult;
import com.zhangyongbin.onlinestore.pojo.TbContent;

import java.util.List;

public interface ContentService {

    EasyUIDataGridResult getContentList(Long categoryId, Integer page, Integer rows);
    OnlinStoreResult addContent(TbContent tbContent);
    OnlinStoreResult editContent(TbContent tbContent);
    OnlinStoreResult deleteContent(Long ids);
    List<TbContent> getAdContentByCid(Long cid);

}
