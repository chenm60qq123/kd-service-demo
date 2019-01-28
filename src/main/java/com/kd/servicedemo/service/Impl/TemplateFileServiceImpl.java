package com.kd.servicedemo.service.Impl;

import com.kd.servicedemo.entity.PageBean;
import com.kd.servicedemo.entity.TemplateFileEntity;
import com.kd.servicedemo.dao.mapper.TemplateFileMapper;
import com.kd.servicedemo.service.TemplateFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo.service.Impl
 * @ClassName: TemplateFileServiceImpl
 * @Description: java类作用描述
 * @Author: Mr.c
 * @CreateDate: 2019/1/22 14:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/22 14:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class TemplateFileServiceImpl extends BaseServiceImpl<TemplateFileEntity> implements TemplateFileService {

    @Autowired
    TemplateFileMapper templateFileMapper;


    @Override
    public TemplateFileEntity getFileByListId(String listId) {
        Example example=new Example(TemplateFileEntity.class);
        Example.Criteria criteria= example.createCriteria();
        criteria.andEqualTo("file_id",listId);
        return templateFileMapper.selectOneByExample(example);
    }

    @Override
    public int deleteAll(List<TemplateFileEntity> list) {
        return 0;
    }
}
