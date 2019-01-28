package com.kd.servicedemo.service;

import com.kd.servicedemo.vo.TableVo;

import java.util.List;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo.service
 * @ClassName: SchemaTableService
 * @Description: java类作用描述
 * @Author: Mr.c
 * @CreateDate: 2019/1/28 10:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/28 10:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface SchemaTableService extends BaseService<TableVo,String>{

    public List<TableVo> getSchemaTable();

    List<TableVo> getTables(String schemaId);
}
