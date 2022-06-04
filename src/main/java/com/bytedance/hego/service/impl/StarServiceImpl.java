package com.bytedance.hego.service.impl;

import com.bytedance.hego.bean.Star;
import com.bytedance.hego.mapper.StarMapper;
import com.bytedance.hego.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarServiceImpl implements StarService {

    @Autowired
    private StarMapper customerMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return customerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Star record) {
        return customerMapper.insert(record);
    }

    @Override
    public int insertSelective(Star record) {
        return customerMapper.insertSelective(record);
    }

    @Override
    public Star selectByPrimaryKey(Long id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Star record) {
        return customerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Star record) {
        return customerMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Star> list() {
        return customerMapper.list();
    }
}
