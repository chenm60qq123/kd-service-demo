package com.kd.servicedemo.service.Impl;

import com.github.pagehelper.PageHelper;
import com.kd.servicedemo.entity.PageBean;
import com.kd.servicedemo.entity.TemplateEntity;
import com.kd.servicedemo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo.service.Impl
 * @ClassName: BaseServiceImpl
 * @Description: java类作用描述
 * @Author: Mr.c
 * @CreateDate: 2019/1/24 10:09
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/24 10:09
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class BaseServiceImpl<T>  implements BaseService<T,String> {

    @Autowired
    private Mapper<T> mapper;

    @Override
    public int add(T t) {
        return mapper.insert(t);
    }

    @Override
    public int delete(T t) {
        return mapper.deleteByPrimaryKey(t);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public T selectOne(T t) {
        return null;
    }

    @Override
    public int update(T t) {
        return mapper.updateByPrimaryKey(t);
    }

    @Override
    public PageBean<T> selectByPage( int pageSize,int pageNum){
        PageHelper.startPage(pageNum,pageSize);
        List<T> list=mapper.selectAll();
        PageBean<T> pageData=new PageBean<T>();
        pageData.setItems(list);
        return pageData;
    }

    @Override
    public int deleteIn(List<String> keys,String keyName,Class c) {
        Example example = new Example(c);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn(keyName ,keys);
        return mapper.deleteByExample(example);
    }

}
