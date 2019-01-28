package com.kd.servicedemo.service.Impl;

import com.github.pagehelper.PageHelper;
import com.kd.servicedemo.entity.DataBaseEntity;
import com.kd.servicedemo.entity.PageBean;
import com.kd.servicedemo.dao.mapper.DataBaseMapper;
import com.kd.servicedemo.service.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataBaseServiceImpl  extends BaseServiceImpl<DataBaseEntity> implements DataBaseService {


    @Override
    public int deleteAll(List<DataBaseEntity> list) {
        List<String> keys=new ArrayList<String>();
        for (DataBaseEntity dataBaseEntity:list) {
            keys.add(dataBaseEntity.getId());
        }
        super.deleteIn(keys,"id",DataBaseEntity.class);
        return 0;
    }


}
