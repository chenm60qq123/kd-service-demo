package com.kd.servicedemo.service.Impl;

import com.github.pagehelper.PageHelper;
import com.kd.servicedemo.entity.TemplateEntity;
import com.kd.servicedemo.entity.PageBean;
import com.kd.servicedemo.entity.TemplateListEntity;
import com.kd.servicedemo.dao.mapper.TemplateListMapper;
import com.kd.servicedemo.dao.mapper.TemplateMapper;
import com.kd.servicedemo.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemplateServiceImpl extends BaseServiceImpl<TemplateEntity> implements TemplateService {

    @Autowired
    TemplateMapper templateMapper;
    @Autowired
    TemplateListMapper templateListMapper;

    @Override
    @Transactional
    public int add(TemplateEntity templateEntity) {
            int i=templateMapper.insert(templateEntity);
            TemplateListEntity templateListEntity=new TemplateListEntity();
            templateListEntity.setTemplate_id(templateEntity.getId());
            templateListEntity.setList_name(templateEntity.getTemplate_name());
            //目录根id为0
            templateListEntity.setList_id("0");
            templateListEntity.setList_type(".folder");
            templateListMapper.insert(templateListEntity);
            return i;
    }

    @Override
    public int deleteAll(List<TemplateEntity> list) {
        List<String> keys=new ArrayList<String>();
        for (TemplateEntity templateEntity:list) {
            keys.add(templateEntity.getId());
        }
        return super.deleteIn(keys,"id",TemplateEntity.class);
    }

}
