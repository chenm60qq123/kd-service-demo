package com.kd.servicedemo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo.entity
 * @ClassName: BuildTableEntity
 * @Description: java类作用描述
 * @Author: Mr.c
 * @CreateDate: 2019/1/28 16:54
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/28 16:54
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Data
@Table(name="MYBATIS.BUILD_TABLES")
@NoArgsConstructor
@NameStyle(Style.uppercase)
public class BuildTableEntity {

    @Id
    private String table_id;
    private String table_name;
    private String table_schema;
    private String key_name;
    private String project_id;
}
