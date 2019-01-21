package com.kd.servicedemo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import javax.validation.constraints.NegativeOrZero;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo.entity
 * @ClassName: TemplateListEntity
 * @Description: java类作用描述
 * @Author: Mr.c
 * @CreateDate: 2019/1/21 17:56
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/21 17:56
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Data
@Table(name = "MYSBATIS.TEMPLATE_LIST")
@NoArgsConstructor
@NameStyle(Style.uppercase)
public class TemplateListEntity {
    private String list_id;
    private String list_fid;
    private String list_name;
}
