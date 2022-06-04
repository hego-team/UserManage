package com.bytedance.hego.mapper;

import com.bytedance.hego.bean.Star;

import java.util.List;

public interface StarMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Star record);

    int insertSelective(Star record);

    Star selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Star record);

    int updateByPrimaryKey(Star record);

    List<Star> list();
}
