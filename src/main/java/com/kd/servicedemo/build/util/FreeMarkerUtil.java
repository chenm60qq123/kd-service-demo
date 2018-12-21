package com.kd.servicedemo.build.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.util.Map;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo.build.util
 * @ClassName: FreeMarkerUtil
 * @Description: FreeMark工具类
 * @Author: Mr.c
 * @CreateDate: 2018/12/21 10:39
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/12/21 10:39
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class FreeMarkerUtil {

    public   String getFileString(String ftlFile, String templatePath, Map<String, Object> datas){
        Configuration cfg=new Configuration();
        try{
            cfg.setClassForTemplateLoading(this.getClass(),"/template/");
//            cfg.setClassForTemplateLoading(this.getClass(),"/com/kd/servicedemo/build/template/");
            Template t=cfg.getTemplate(ftlFile);
            t.setEncoding("UTF-8");
            StringWriter out=new StringWriter();
            t.process(datas,out);
            out.flush();
            out.close();
            return  out.getBuffer().toString();
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}

