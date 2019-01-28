package com.kd.servicedemo.controller;

import com.kd.servicedemo.entity.Message;
import com.kd.servicedemo.service.SchemaTableService;
import com.kd.servicedemo.vo.TableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo.controller
 * @ClassName: SchemaTableController
 * @Description: java类作用描述
 * @Author: Mr.c
 * @CreateDate: 2019/1/28 9:43
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/28 9:43
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@RestController
@RequestMapping("table")
public class SchemaTableController {

    @Autowired
    private SchemaTableService schemaTableService;


    @RequestMapping("getSchemaTable")
    public Message getShemaTable(){
      List<TableVo>  list=schemaTableService.getSchemaTable();
      return  Message.success(list);
    }

    @RequestMapping("getTables")
    public Message getTables(String schemaId){
        List<TableVo>  list=schemaTableService.getTables(schemaId);
        return  Message.success(list);
    }


}
