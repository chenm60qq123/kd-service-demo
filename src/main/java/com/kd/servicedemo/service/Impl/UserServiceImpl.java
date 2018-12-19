package com.kd.servicedemo.service.Impl;

import com.github.pagehelper.PageHelper;
import com.kd.servicedemo.entity.PageBean;
import com.kd.servicedemo.entity.UserEntity;
import com.kd.servicedemo.mapper.UserMapper;
import com.kd.servicedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo.service
 * @ClassName: UserService
 * @Description: 用户服务
 * @Author: Mr.c
 * @CreateDate: 2018/12/19 17:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/12/19 17:26
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int add(UserEntity userEntity) {
        return userMapper.insert(userEntity);
    }

    @Override
    public int deleteById(String id) {
        return userMapper.deleteById(id);
    }

    @Override
    public List<UserEntity> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public UserEntity selectOne(UserEntity userEntity) {
        return userMapper.selectOne(userEntity);
    }

    @Override
    public int update(UserEntity userEntity) {
        return userMapper.update(userEntity);
    }

    @Override
    public PageBean<UserEntity> selectByPage(UserEntity userEntity,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        userMapper.selectAll();
        PageBean<UserEntity> pageData = new PageBean<>(pageNum, pageSize, userMapper.selectCount(userEntity));
        return pageData;
    }
}
