package com.kd.servicedemo.build;

import com.kd.servicedemo.build.bean.DmDataBaseBean;
import com.kd.servicedemo.build.util.FreeMarkerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.ContextLoader;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    DmDataBaseBean dmDataBaseBean;

    public void doBuild() throws ClassNotFoundException, SQLException {
       Class c= Class.forName(dmDataBaseBean.getDriverClassName());
       Connection connection=DriverManager.getConnection(dmDataBaseBean.getUrl(),dmDataBaseBean.getUsername(),dmDataBaseBean.getPassword());
       Statement statement= connection.createStatement();
       ResultSet resultSet= statement.executeQuery("select  * from SYSDBA.USERS");
       ResultSetMetaData data= resultSet.getMetaData();
        for (int i = 0; i <data.getColumnCount() ; i++) {
            System.out.println(data.getColumnName(i+1));
        }
        Map<String,Object> ma=new HashMap<>();
        ma.put("ms","Hallo Word");
        FreeMarkerUtil f=new FreeMarkerUtil();
        String context=  f.getFileString("demoBean.ftl","classpath:/com/kd/servicedemo/build/template",ma);
        System.out.println(context);
    }
}
