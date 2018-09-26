package com.zhangyongbin.onlinestore.service;

import com.zhangyongbin.onlinestore.common.pojo.EasyUITreeNode;
import com.zhangyongbin.onlinestore.common.pojo.OnlinStoreResult;

import java.util.List;

public interface ContentCategoryService {

	List<EasyUITreeNode> getContentCategoryList(Long parentId);
	OnlinStoreResult addContentCategory(Long parentId, String name);
	OnlinStoreResult updateContentCategory(Long id, String name);
	OnlinStoreResult deleteContentCategory(Long id);
}
