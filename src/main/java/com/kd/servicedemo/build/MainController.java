package com.kd.servicedemo.build;

import com.kd.servicedemo.build.bean.DmDataBaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.*;

@Controller
public class MainController {

    public void doBuild() throws ClassNotFoundException, SQLException {
       Class c= Class.forName("dm.jdbc.driver.DmDriver");
       Connection connection=DriverManager.getConnection("jdbc:dm://localhost/PSIDP","SYSDBA","SYSDBA");
       Statement statement= connection.createStatement();
       ResultSet resultSet= statement.executeQuery("select  * from SYSDBA.USERS");
       while(resultSet.next()){
           resultSet.getRow();
       }
    }
}
