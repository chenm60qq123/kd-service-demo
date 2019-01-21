package com.kd.servicedemo.service.Impl;

import com.github.pagehelper.PageHelper;
import com.kd.servicedemo.entity.TemplateEntity;
import com.kd.servicedemo.entity.PageBean;
import com.kd.servicedemo.mapper.TemplateMapper;
import com.kd.servicedemo.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    TemplateMapper templateMapper;

    @Override
    public int add(TemplateEntity templateEntity) {
        return templateMapper.insert(templateEntity);
    }

    @Override
    public int delete(TemplateEntity templateEntity) {
        return templateMapper.deleteByPrimaryKey(templateEntity);
    }

    @Override
    public List<TemplateEntity> selectAll() {
        return templateMapper.selectAll();
    }

    @Override
    public TemplateEntity selectOne(TemplateEntity templateEntity) {
        return null;
    }

    @Override
    public int update(TemplateEntity templateEntity) {
        return templateMapper.updateByPrimaryKey(templateEntity);
    }

    @Override
    public PageBean<TemplateEntity> selectByPage( int pageSize,int pageNum ) {
        PageHelper.startPage(pageNum,pageSize);
        List<TemplateEntity> list=templateMapper.selectAll();
        PageBean<TemplateEntity> pageData = new PageBean<TemplateEntity>(pageNum, pageSize, templateMapper.selectCount(new TemplateEntity()));
        pageData.setItems(list);
        return pageData;
    }

    @Override
    public int deleteIn(List<TemplateEntity> list) {
        List<String> ids=new ArrayList<String>();
        for (TemplateEntity d:list) {
            ids.add(d.getId());
        }
        Example example = new Example(TemplateEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return templateMapper.deleteByExample(example);
    }
}
