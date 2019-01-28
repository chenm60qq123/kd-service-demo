package com.kd.servicedemo.service;

import com.kd.servicedemo.entity.DataBaseEntity;
import com.kd.servicedemo.entity.PageBean;

import java.io.Serializable;
import java.util.List;

/**
  *  
  * @ClassName:      BaseService
  * @Description:    java类作用描述
  * @Author:         Mr.c
  * @CreateDate:     2018/12/19 17:03
  * @UpdateUser:     更新者
  * @UpdateDate:     2018/12/19 17:03
  * @UpdateRemark:   更新内容
  * @Version:        1.0
  */
public interface BaseService<T,PK extends Serializable> {
    
    /**
     * @Method add
     * @Author Mr.c
     * @Version  1.0
     * @Description 新增方法
     * @Return int
     * @Date 2018/12/19 17:06
     */
    public int add(T t);

    /**
     * @Method deleteById
     * @Author Mr.c
     * @Version  1.0
     * @Description 删除方法
     * @Return int
     * @Date 2018/12/19 17:11
     */
    public int delete(T t);

    /**
     * @Method selectAll
     * @Author Mr.c
     * @Version  1.0
     * @Description 查询所有数据
     * @Return T
     * @Date 2018/12/19 17:15
     */
    public List<T> selectAll();

    /**
     * @Method selectOne
     * @Author Mr.c
     * @Version  1.0
     * @Description 根据主键查询，可以是联合主键
     * @Return  T
     * @Date 2018/12/19 17:17
     */
    public T selectOne(T t);


    /**
     * @Method update
     * @Author Mr.c
     * @Version  1.0
     * @Description 数据更新方法
     * @Return int
     * @Exception
     * @Date 2018/12/19 17:13
     */
    public int update(T t);

    /**
     * @Method selectByPage
     * @Author Mr.c
     * @Version  1.0
     * @Description 分页查询
     * @Return PageBean<T>
     * @Exception
     * @Date 2018/12/19 17:22c
     */
    public PageBean<T> selectByPage(int pageNum, int pageSize);


    public int deleteIn(List<String> list,PK k,Class c);

    public int deleteAll(List<T> list);
}
