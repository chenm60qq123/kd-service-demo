package com.kd.servicedemo.dao.mapper;


import com.kd.servicedemo.entity.BuildTableEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo.entity
 * @ClassName: BuildTableMapper
 * @Description: java类作用描述
 * @Author: Mr.c
 * @CreateDate: 2019/1/28 17:01
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/28 17:01
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface BuildTableMapper extends Mapper<BuildTableEntity>{

    @Select("select * from \"PSIDP\".\"MYBATIS\".\"BUILD_TABLES\" where project_id=#{project_id}")
    public List<BuildTableEntity> getTablesByProId(@Param("project_id") String project_id);
}
