package com.kd.servicedemo.service.Impl;

import com.kd.servicedemo.dao.mapper.SchemaTableMapper;
import com.kd.servicedemo.entity.PageBean;
import com.kd.servicedemo.service.SchemaTableService;
import com.kd.servicedemo.vo.TableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo.service.Impl
 * @ClassName: SchemaTableServiceImpl
 * @Description: java类作用描述
 * @Author: Mr.c
 * @CreateDate: 2019/1/28 10:04
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/28 10:04
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class SchemaTableServiceImpl extends BaseServiceImpl<TableVo> implements SchemaTableService {

    @Autowired
    private SchemaTableMapper schemaTableMapper;

    @Override
    public int deleteAll(List<TableVo> list) {
        return 0;
    }

    public List<TableVo> getSchemaTable(){
        return schemaTableMapper.getShemaTable();
    }

    @Override
    public List<TableVo> getTables(String schemaId) {
        return schemaTableMapper.getTables(schemaId);
    }
}
