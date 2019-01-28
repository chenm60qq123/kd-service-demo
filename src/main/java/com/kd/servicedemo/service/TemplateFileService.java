package com.kd.servicedemo.service;

import com.kd.servicedemo.entity.TemplateFileEntity;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo.service
 * @ClassName: TemplateFileService
 * @Description: java类作用描述
 * @Author: Mr.c
 * @CreateDate: 2019/1/22 14:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/22 14:26
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface TemplateFileService extends BaseService<TemplateFileEntity,String> {

    public TemplateFileEntity getFileByListId(String listId);
}
