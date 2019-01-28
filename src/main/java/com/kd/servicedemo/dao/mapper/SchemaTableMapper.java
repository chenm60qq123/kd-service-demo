package com.kd.servicedemo.dao.mapper;

import com.kd.servicedemo.vo.TableVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo.dao.mapper
 * @ClassName: SchemaTableMapper
 * @Description: java类作用描述
 * @Author: Mr.c
 * @CreateDate: 2019/1/28 10:09
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/28 10:09
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface SchemaTableMapper extends Mapper<TableVo> {

    @Select("select SCHID ID,NAME,false LEAF from \"PSIDP\".\"SYSDBA\".\"SYSSCHEMAS\";")
    public List<TableVo> getShemaTable();

    @Select("select ID ID,NAME,true LEAF from \"PSIDP\".\"SYSDBA\".\"SYSTABLES\" where SCHID=#{schemaId}")
    List<TableVo> getTables(@Param("schemaId") String schemaId);


}
