package com.kd.servicedemo.entity;

import com.kd.servicedemo.utils.UUIdGenId;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo.entity
 * @ClassName: ProjectEntity
 * @Description: java类作用描述
 * @Author: Mr.c
 * @CreateDate: 2019/1/23 10:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/23 10:00
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Data
@NameStyle(Style.uppercase)
@NoArgsConstructor
@Table(name = "MYBATIS.PROJECT")
public class ProjectEntity {

    @Id
    @KeySql(genId = UUIdGenId.class)
    @Getter
    private String project_id;
    private String database_id;
    private String template_id;
    private String project_name;
    private String project_describe;
}
