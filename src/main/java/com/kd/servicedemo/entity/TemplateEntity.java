package com.kd.servicedemo.entity;

import com.kd.servicedemo.utils.UUIdGenId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;


@NameStyle(Style.uppercase)
@Table(name = "MYBATIS.TEMPLATE")
@Data
@NoArgsConstructor
public class TemplateEntity {
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;
    @NonNull
    private String template_name;
    @NonNull
    private String template_describe;

}
