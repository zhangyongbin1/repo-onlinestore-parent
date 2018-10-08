package com.zhangyongbin.onlinestore.service;

import com.zhangyongbin.onlinestore.common.pojo.SearchResult;

/**
 * 实现搜索功能的service
 */
public interface SearchService {
    SearchResult search(String queryString, int page, int rows);
}
