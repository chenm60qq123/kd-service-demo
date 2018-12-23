package com.kd.servicedemo.entity;

import com.kd.servicedemo.utils.UUIdGenId;
import com.sun.org.apache.xml.internal.utils.StringVector;
import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


@NameStyle(Style.uppercase)
@Table(name = "MYBATIS.DATABASECONFIG")
@Data
@NoArgsConstructor
public class DataBaseEntity {
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String drivername;
    @NonNull
    private String url;
    @NonNull
    private String username;
    @NonNull
    private String password;



}
