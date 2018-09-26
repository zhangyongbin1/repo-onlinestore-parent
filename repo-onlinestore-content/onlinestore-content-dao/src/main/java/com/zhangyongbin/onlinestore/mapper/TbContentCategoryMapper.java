package com.zhangyongbin.onlinestore.mapper;

import com.zhangyongbin.onlinestore.pojo.TbContentCategory;
import com.zhangyongbin.onlinestore.pojo.TbContentCategoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "tbContentCategoryMapper")
public interface TbContentCategoryMapper {
    int countByExample(TbContentCategoryExample example);

    int deleteByExample(TbContentCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbContentCategory record);

    int insertSelective(TbContentCategory record);

    List<TbContentCategory> selectByExample(TbContentCategoryExample example);

    TbContentCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbContentCategory record, @Param("example") TbContentCategoryExample example);

    int updateByExample(@Param("record") TbContentCategory record, @Param("example") TbContentCategoryExample example);

    int updateByPrimaryKeySelective(TbContentCategory record);

    int updateByPrimaryKey(TbContentCategory record);
}