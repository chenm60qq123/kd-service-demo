package com.kd.servicedemo.mapper;

import com.kd.servicedemo.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM SYSDBA.USERS")
    List<UserEntity> findAll();

    @Select("SELECT * FROM SYSDBA.USERS WHERE ID = #{id}")
    UserEntity findById(String id);


    @Insert("INSERT INTO users(ID,NAME) VALUES(#{id}, #{name})")
    int add(UserEntity user);

    @Delete("DELETE FROM SYSDBA.USERS WHERE ID = #{id}")
    int deleteById(String id);

    @Update("UPDATE SYSDBA.USERS SET ID=#{id},NAME=#{name} WHERE ID =#{id}")
    int update(UserEntity user);

    @Insert(
            "<script>"+
            "INSERT INTO SYSDBA.USERS (ID,NAME) VALUES "+
            "<foreach collection='testLists' item='item' index='index' separator=','>"+
            "(#{item.id}, #{item.name})"+
            "</foreach>"+
            "</script>"
    )
    int insertCollectList(@Param(value="testLists") List<UserEntity> testLists);

}
