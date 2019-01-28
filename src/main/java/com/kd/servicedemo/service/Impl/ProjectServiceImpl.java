package com.kd.servicedemo.service.Impl;

import com.github.pagehelper.PageHelper;
import com.kd.servicedemo.dao.mapper.ProjectMapper;
import com.kd.servicedemo.entity.PageBean;
import com.kd.servicedemo.entity.ProjectEntity;
import com.kd.servicedemo.service.ProjectService;
import com.kd.servicedemo.vo.ProjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl extends BaseServiceImpl<ProjectEntity> implements ProjectService {


    @Autowired
    private  ProjectMapper projectMapper;

    @Override
    public int deleteAll(List<ProjectEntity> list) {
        List<String> keys=new ArrayList<String>();
        for (ProjectEntity projectEntity:list) {
            keys.add(projectEntity.getProject_id());
        }
        return super.deleteIn(keys,"project_id",ProjectEntity.class);
    }


    @Override
    public PageBean<ProjectVo> selectByPageVo(int pageSize, int pageNum){
        PageHelper.startPage(pageNum,pageSize);
        List<ProjectVo> list=projectMapper.getAll();
        PageBean<ProjectVo> pageData=new PageBean<ProjectVo>(list);
        pageData.setItems(list);
        return pageData;
    }
}
