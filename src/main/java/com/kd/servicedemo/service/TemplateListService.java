package com.kd.servicedemo.service;

import com.kd.servicedemo.entity.TemplateListEntity;

import java.util.List;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo.service
 * @ClassName: TemplateListService
 * @Description: java类作用描述
 * @Author: Mr.c
 * @CreateDate: 2019/1/21 18:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/21 18:00
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface TemplateListService extends  BaseService<TemplateListEntity,String>{
    public List<TemplateListEntity> selectById(String templateId) throws Exception;
}
