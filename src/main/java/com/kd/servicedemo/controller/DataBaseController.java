package com.kd.servicedemo.controller;

import com.kd.servicedemo.entity.DataBaseEntity;
import com.kd.servicedemo.entity.Message;
import com.kd.servicedemo.entity.PageBean;
import com.kd.servicedemo.service.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("database")
public class DataBaseController {
    @Autowired
    DataBaseService dataBaseService;

    @RequestMapping("getAll")
    @ResponseBody
    public Message getAll(){
        List<DataBaseEntity> list=dataBaseService.selectAll();
        Message m= Message.success(list);
        return  m;
    }

    @ResponseBody
    @RequestMapping("update")
    public Message update(@RequestBody DataBaseEntity dataBaseEntity){
        try {
            int num=dataBaseService.update(dataBaseEntity);
            return  Message.success("200","修改成功",num);
        }catch (Exception e){
            e.printStackTrace();
            return  Message.success("500","修改失败",e);
        }
    }

    @ResponseBody
    @RequestMapping("add")
    public Message add(@RequestBody DataBaseEntity dataBaseEntity){
        try {
            int num=dataBaseService.add(dataBaseEntity);
            return Message.success("200","新增成功",num);
        }catch (Exception e){
            e.printStackTrace();
            return Message.fails("500","新增失败",e);
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public Message delete(@RequestBody DataBaseEntity dataBaseEntity){
        try {
            int num=dataBaseService.delete(dataBaseEntity);
            return Message.success("200","删除成功",num);
        }catch (Exception e){
            e.printStackTrace();
            return Message.fails("500","删除失败",e);
        }
    }

    @RequestMapping("deleteIn")
    @ResponseBody
    public Message deleteIn(@RequestBody List<DataBaseEntity> list){
        try {
            int num=dataBaseService.deleteIn(list);
            return Message.success("200","删除成功",num);
        }catch (Exception e){
            e.printStackTrace();
            return Message.fails("500","删除失败",e);
        }
    }

    @RequestMapping("selectByPage")
    @ResponseBody
    public Message selectByPage(int pageSize,int pageNum){
        PageBean<DataBaseEntity> page=dataBaseService.selectByPage(pageSize,pageNum);
        return Message.success(page);
    }
}
