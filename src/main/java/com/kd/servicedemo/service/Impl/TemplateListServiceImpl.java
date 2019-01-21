package com.kd.servicedemo.service.Impl;

import com.kd.servicedemo.entity.PageBean;
import com.kd.servicedemo.entity.TemplateEntity;
import com.kd.servicedemo.entity.TemplateListEntity;
import com.kd.servicedemo.mapper.TemplateListMapper;
import com.kd.servicedemo.mapper.TemplateMapper;
import com.kd.servicedemo.service.TemplateListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
public class TemplateListServiceImpl implements TemplateListService {

    @Autowired
    private TemplateListMapper templateListMapper;


    @Override
    public int add(TemplateListEntity templateListEntity) {
        return 0;
    }

    @Override
    public int delete(TemplateListEntity templateListEntity) {
        return 0;
    }

    @Override
    public List<TemplateListEntity> selectAll() {
        return null;
    }

    @Override
    public TemplateListEntity selectOne(TemplateListEntity templateListEntity) {
        return null;
    }

    @Override
    public int update(TemplateListEntity templateListEntity) {
        return 0;
    }

    @Override
    public PageBean<TemplateListEntity> selectByPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public int deleteIn(List<TemplateListEntity> list) {
        return 0;
    }

    public List<TemplateListEntity> selectById(String templateId){
        Example example=new Example(TemplateListEntity.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("TEMPLATE_ID",templateId);
        List<TemplateListEntity> list=templateListMapper.selectByExample(example);
    }}
