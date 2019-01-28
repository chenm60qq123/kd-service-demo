package com.kd.servicedemo.service.Impl;

import com.github.pagehelper.PageHelper;
import com.kd.servicedemo.entity.PageBean;
import com.kd.servicedemo.entity.UserEntity;
import com.kd.servicedemo.dao.mapper.UserMapper;
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
public class UserServiceImpl extends BaseServiceImpl<UserEntity> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int deleteAll(List<UserEntity> list) {
        return 0;
    }
}
