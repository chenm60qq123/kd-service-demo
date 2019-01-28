package com.kd.servicedemo.dao.mapper;

import com.kd.servicedemo.entity.ProjectEntity;
import com.kd.servicedemo.vo.ProjectVo;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo.dao.mapper
 * @ClassName: ProjectMapper
 * @Description: java类作用描述
 * @Author: Mr.c
 * @CreateDate: 2019/1/23 10:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/23 10:05
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ProjectMapper  extends Mapper<ProjectEntity> {

    //此方法重复调用关联查询
   /* @Select("select * from MYBATIS.PROJECT")
    @Results({
            @Result(property = "dataBaseEntity",
            column = "DATABASE_ID",
            one = @One(select = "com.kd.servicedemo.dao.mapper.DataBaseMapper.getById"))})
    public List<ProjectVo> getAll();*/


    @Select("select \n" +
            "PROJECT_ID,TEMPLATE_ID,PROJECT_NAME,PROJECT_DESCRIBE,b.NAME DATABASE_NAME,TEMPLATE_NAME " +
            "from \n" +
            "\"PSIDP\".\"MYBATIS\".\"PROJECT\" a \n" +
            "left join \n" +
            "\"PSIDP\".\"MYBATIS\".\"DATABASECONFIG\" b \n" +
            "on \n" +
            "a.database_id=b.id \n" +
            "left join \n" +
            "\"PSIDP\".\"MYBATIS\".\"TEMPLATE\" c \n" +
            "on \n" +
            "a.template_id=c.id ")
    @Results({
            @Result(column = "PROJECT_ID", property = "tables",
                    many =@Many(select = "com.kd.servicedemo.dao.mapper.BuildTableMapper.getTablesByProId"))
    })
    public  List<ProjectVo> getAll();

}
