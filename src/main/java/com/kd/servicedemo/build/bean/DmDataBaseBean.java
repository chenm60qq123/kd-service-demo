package com.kd.servicedemo.build.bean;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DmDataBaseBean {

    @Value("${spring.datasource.driver-class-name:dm.jdbc.driver.DmDriver}")
    private String driverClassName;
    @Value("${spring.datasource.url:jdbc:dm://localhost/PSIDP}")
    private String url;
    @Value("${spring.datasource.username:SYSDBA}")
    private String username;
    @Value("${spring.datasource.password:SYSDBA}")
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
