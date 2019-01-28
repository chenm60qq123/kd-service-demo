package com.kd.servicedemo.entity;

import com.kd.servicedemo.utils.UUIdGenId;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo.entity
 * @ClassName: TemplateFileEntity
 * @Description: java类作用描述
 * @Author: Mr.c
 * @CreateDate: 2019/1/22 14:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/22 14:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@Table(name = "MYBATIS.TEMPLATE_FILE")
@NameStyle(Style.uppercase)
public class TemplateFileEntity {

    @Id
    private String file_id;
    private String file_name;
    private String file_content;
}
