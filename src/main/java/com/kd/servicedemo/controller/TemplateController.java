package com.kd.servicedemo.controller;

import com.kd.servicedemo.entity.*;
import com.kd.servicedemo.service.TemplateFileService;
import com.kd.servicedemo.service.TemplateListService;
import com.kd.servicedemo.service.TemplateService;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("template")
public class TemplateController {
    @Autowired
    TemplateService templateService;
    @Autowired
    TemplateListService templateListService;
    @Autowired
    TemplateFileService templateFileService;

    @RequestMapping("getAll")
    @ResponseBody
    public Message getAll(){
        List<TemplateEntity> list=templateService.selectAll();
        Message m= Message.success(list);
        return  m;
    }

    @ResponseBody
    @RequestMapping("update")
    public Message update(@RequestBody TemplateEntity TemplateEntity){
        try {
            int num=templateService.update(TemplateEntity);
            return  Message.success("200","修改成功",num);
        }catch (Exception e){
            e.printStackTrace();
            return  Message.success("500","修改失败",e);
        }
    }

    @ResponseBody
    @RequestMapping("add")
    public Message add(@RequestBody TemplateEntity TemplateEntity){
        try {
            int num=templateService.add(TemplateEntity);
            return Message.success("200","新增成功",num);
        }catch (Exception e){
            e.printStackTrace();
            return Message.fails("500","新增失败",e);
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public Message delete(@RequestBody TemplateEntity TemplateEntity){
        try {
            int num=templateService.delete(TemplateEntity);
            return Message.success("200","删除成功",num);
        }catch (Exception e){
            e.printStackTrace();
            return Message.fails("500","删除失败",e);
        }
    }

    @RequestMapping("deleteIn")
    @ResponseBody
    public Message deleteIn(@RequestBody List<TemplateEntity> list){
        try {
            int num=templateService.deleteAll(list);
            return Message.success("200","删除成功",num);
        }catch (Exception e){
            e.printStackTrace();
            return Message.fails("500","删除失败",e);
        }
    }

    @RequestMapping("selectByPage")
    @ResponseBody
    public Message selectByPage(int pageSize,int pageNum){
        PageBean<TemplateEntity> page=templateService.selectByPage(pageSize,pageNum);
        return Message.success(page);
    }

    @RequestMapping("treeAdd")
    @ResponseBody
    public Message treeAdd(TemplateListEntity templateListEntity)  {
        try {
            int num =templateListService.add(templateListEntity);
            return Message.success("200","新增成功",num);
        }catch (Exception e){
            return  Message.fails("500","新增失败",e.getMessage());
        }

    }

    @RequestMapping("treeInit")
    @ResponseBody
    public Message selectByPage(String templateId) throws Exception {
        List<TemplateListEntity> list=templateListService.selectById(templateId);
        Message m= Message.success(list);
        return  m;
    }

    @RequestMapping("treeUpdate")
    @ResponseBody
    public Message treeUpdate(TemplateListEntity templateListEntity){
        try {
            int num=templateListService.update(templateListEntity);
            return  Message.success("200","修改成功",num);
        }catch (Exception e){
            e.printStackTrace();
            return  Message.success("500","修改失败",e);
        }

    }

    @RequestMapping("treeDel")
    @ResponseBody
    public Message treeDel( TemplateListEntity templateListEntity){
        try {
            int num=templateListService.delete(templateListEntity);
            return Message.success("200","删除成功",num);
        }catch (Exception e){
            e.printStackTrace();
            return Message.fails("500","删除失败",e);
        }
    }

    @RequestMapping("getFileByListId")
    @ResponseBody
    public Message getFileByListId(String listId){
        TemplateFileEntity t=templateFileService.getFileByListId(listId);
        return Message.success(t);
    }

    @RequestMapping("updateFile")
    @ResponseBody
    public Message updateFile(TemplateFileEntity templateFileEntity){
        try {
            int num=templateFileService.update(templateFileEntity);
            return Message.success("200","文件修改成功！",num);
        }catch (Exception e){
            return Message.fails("500","文件修改失败！",e);
        }
    }
}
