package com.kd.servicedemo.service.Impl;

import com.kd.servicedemo.entity.PageBean;
import com.kd.servicedemo.entity.TemplateFileEntity;
import com.kd.servicedemo.entity.TemplateListEntity;
import com.kd.servicedemo.dao.mapper.TemplateFileMapper;
import com.kd.servicedemo.dao.mapper.TemplateListMapper;
import com.kd.servicedemo.service.TemplateListService;
import com.kd.servicedemo.utils.TreeUtilCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.persistence.Transient;
import java.util.List;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo.service.Impl
 * @ClassName: TemplateListImpl
 * @Description: java类作用描述
 * @Author: Mr.c
 * @CreateDate: 2019/1/21 18:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/21 18:00
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Service
public class TemplateListServiceImpl extends BaseServiceImpl<TemplateListEntity> implements TemplateListService {

    @Autowired
    private TemplateListMapper templateListMapper;

    @Autowired
    private TemplateFileMapper templateFileMapper;


    @Override
    @Transient
    public int add(TemplateListEntity templateListEntity) {
        String fileType=templateListEntity.getList_type();
        //判断是否是新增文件，如果后期还有其他文件夹格式需要修改此判断
        int i=templateListMapper.insert(templateListEntity);
        if(!".folder".equals(fileType)){
            TemplateFileEntity templateFileEntity=new TemplateFileEntity();
            templateFileEntity.setFile_name(templateListEntity.getList_name());
            templateFileEntity.setFile_id(templateListEntity.getList_id());
            templateFileMapper.insert(templateFileEntity);
        }
        return i;
    }

    @Override
    public int deleteAll(List<TemplateListEntity> list) {
        return 0;
    }


    public List<TemplateListEntity> selectById(String templateId) throws Exception {
        Example example=new Example(TemplateListEntity.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("template_id",templateId);
        List<TemplateListEntity> list=templateListMapper.selectByExample(example);
        list=TreeUtilCommon.buildTree(list,"com.kd.servicedemo.entity.TemplateListEntity","list_id","list_fid","children");
        return list;
    }

}