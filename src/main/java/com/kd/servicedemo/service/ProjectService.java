package com.kd.servicedemo.service;

import com.kd.servicedemo.entity.PageBean;
import com.kd.servicedemo.entity.ProjectEntity;
import com.kd.servicedemo.vo.ProjectVo;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo.service
 * @ClassName: DataBaseService
 * @Description: java类作用描述
 * @Author: Mr.c
 * @CreateDate: 2018/12/19 17:24
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/12/19 17:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ProjectService extends BaseService<ProjectEntity,String> {

    public PageBean<ProjectVo> selectByPageVo(int pageSize, int pageNum);
}
