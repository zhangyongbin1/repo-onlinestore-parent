package com.zhangyongbin.onlinestore.mapper;

import com.zhangyongbin.onlinestore.common.pojo.SearchItem;
import org.springframework.stereotype.Component;

import java.util.List;
@Component(value = "searchItemMapper")
public interface SearchItemMapper {

	List<SearchItem> getItemList();
	SearchItem getItemById(long itemId);
}
