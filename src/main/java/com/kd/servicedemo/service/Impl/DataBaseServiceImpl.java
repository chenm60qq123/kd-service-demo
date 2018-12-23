package com.kd.servicedemo.service.Impl;

import com.github.pagehelper.PageHelper;
import com.kd.servicedemo.entity.DataBaseEntity;
import com.kd.servicedemo.entity.PageBean;
import com.kd.servicedemo.entity.UserEntity;
import com.kd.servicedemo.mapper.DataBaseMapper;
import com.kd.servicedemo.service.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataBaseServiceImpl implements DataBaseService {

    @Autowired
    DataBaseMapper dataBaseMapper;

    @Override
    public int add(DataBaseEntity dataBaseEntity) {
        return dataBaseMapper.insert(dataBaseEntity);
    }

    @Override
    public int delete(DataBaseEntity dataBaseEntity) {
        return dataBaseMapper.deleteByPrimaryKey(dataBaseEntity);
    }

    @Override
    public List<DataBaseEntity> selectAll() {
        return dataBaseMapper.selectAll();
    }

    @Override
    public DataBaseEntity selectOne(DataBaseEntity dataBaseEntity) {
        return null;
    }

    @Override
    public int update(DataBaseEntity dataBaseEntity) {
        return dataBaseMapper.updateByPrimaryKey(dataBaseEntity);
    }

    @Override
    public PageBean<DataBaseEntity> selectByPage( int pageSize,int pageNum ) {
        PageHelper.startPage(pageNum,pageSize);
        List<DataBaseEntity> list=dataBaseMapper.selectAll();
        PageBean<DataBaseEntity> pageData = new PageBean<DataBaseEntity>(pageNum, pageSize, dataBaseMapper.selectCount(new DataBaseEntity()));
        pageData.setItems(list);
        return pageData;
    }

    @Override
    public int deleteIn(List<DataBaseEntity> list) {
        List<String> ids=new ArrayList<String>();
        for (DataBaseEntity d:list) {
            ids.add(d.getId());
        }
        Example example = new Example(DataBaseEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",list);
        return dataBaseMapper.deleteByExample(example);
    }
}
