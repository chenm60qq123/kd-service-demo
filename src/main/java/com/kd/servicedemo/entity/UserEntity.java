package com.kd.servicedemo.entity;


import com.kd.servicedemo.utils.UUIdGenId;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;
import javax.persistence.Id;
import javax.persistence.Table;


@NameStyle(Style.uppercase)
@Table(name = "SYSDBA.USERS")
public class UserEntity {

    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
