package com.kd.servicedemo.controller;

import com.kd.servicedemo.entity.ProjectEntity;
import com.kd.servicedemo.entity.Message;
import com.kd.servicedemo.entity.PageBean;
import com.kd.servicedemo.service.ProjectService;
import com.kd.servicedemo.vo.ProjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @RequestMapping("getAll")
    @ResponseBody
    public Message getAll(){
        List<ProjectEntity> list=projectService.selectAll();
        Message m= Message.success(list);
        return  m;
    }

    @ResponseBody
    @RequestMapping("update")
    public Message update(@RequestBody ProjectEntity projectEntity){
        try {
            int num=projectService.update(projectEntity);
            return  Message.success("200","修改成功",num);
        }catch (Exception e){
            e.printStackTrace();
            return  Message.success("500","修改失败",e);
        }
    }

    @ResponseBody
    @RequestMapping("add")
    public Message add(@RequestBody ProjectEntity projectEntity){
        try {
            int num=projectService.add(projectEntity);
            return Message.success("200","新增成功",num);
        }catch (Exception e){
            e.printStackTrace();
            return Message.fails("500","新增失败",e);
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public Message delete(@RequestBody ProjectEntity projectEntity){
        try {
            int num=projectService.delete(projectEntity);
            return Message.success("200","删除成功",num);
        }catch (Exception e){
            e.printStackTrace();
            return Message.fails("500","删除失败",e);
        }
    }

    @RequestMapping("deleteIn")
    @ResponseBody
    public Message deleteIn(@RequestBody List<ProjectEntity> list){
        try {
            int num=projectService.deleteAll(list);
            return Message.success("200","删除成功",num);
        }catch (Exception e){
            e.printStackTrace();
            return Message.fails("500","删除失败",e);
        }
    }


    @RequestMapping("selectByPage")
    @ResponseBody
    public Message selectByPage(int pageSize,int pageNum){
        PageBean<ProjectVo> page= projectService.selectByPageVo(pageSize,pageNum);
        return Message.success(page);
    }
}
