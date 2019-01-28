package com.kd.servicedemo.vo;

import com.kd.servicedemo.entity.BuildTableEntity;
import com.kd.servicedemo.entity.DataBaseEntity;
import com.kd.servicedemo.entity.TemplateEntity;
import com.kd.servicedemo.utils.UUIdGenId;
import freemarker.template.Template;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.util.List;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo
 * @ClassName: ProjectVo
 * @Description: java类作用描述
 * @Author: Mr.c
 * @CreateDate: 2019/1/23 17:39
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/23 17:39
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Data
public class ProjectVo {
    private String project_id;
    private String database_name;
    private String template_name;
    private String project_name;
    private String project_describe;
    private List<BuildTableEntity> tables;
}
