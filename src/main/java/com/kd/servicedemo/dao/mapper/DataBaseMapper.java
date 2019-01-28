package com.kd.servicedemo.dao.mapper;

import com.kd.servicedemo.entity.DataBaseEntity;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import javax.xml.crypto.Data;


public interface DataBaseMapper extends Mapper<DataBaseEntity> {


    @Select("select * from MYBATIS.DATABASECONFIG where id=#{id}")
    public DataBaseEntity getById(String id);

}
