package com.kd.servicedemo;

import com.github.pagehelper.PageHelper;
import com.kd.servicedemo.build.MainController;
import com.kd.servicedemo.entity.PageBean;
import com.kd.servicedemo.entity.UserEntity;
import com.kd.servicedemo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.spring.annotation.MapperScan;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceDemoApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    MainController mainController;


    @Test
    public  void doBuild() throws SQLException, ClassNotFoundException {
        mainController.doBuild();
    }

    @Test
    public void findAll() {
        List<UserEntity> list=userMapper.findAll();
        for (UserEntity u:list) {
            System.out.println(u.getName());
        }


    }

    @Test
    public void findById() {
        UserEntity userEntity=userMapper.findById("1");
        System.out.println(userEntity.getName());
    }

    @Test
    public void add() {
        UserEntity userEntity=new UserEntity();
        userEntity.setId("4");
        userEntity.setName("che23");
        int i=userMapper.add(userEntity);
        System.out.println(userEntity.getName()+""+i);
    }

    @Test
    public void deleteById() {
        int i=userMapper.deleteById("0");
        System.out.println("删除数据："+i+"条");
    }

    @Test
    public void updateById() {
        UserEntity userEntity=new UserEntity();
        userEntity.setId("1");
        userEntity.setName("che");
        int i=userMapper.update(userEntity);
        System.out.println("修改数据："+i+"条");
    }

    @Test
    public void findByPage() {
        PageHelper.startPage(1,2);
        List<UserEntity> list=userMapper.selectAll();
        //int countNums = userMapper.countItem();总记录数
        PageBean<UserEntity> pageData = new PageBean<>(1, 2, 4);
        pageData.setItems(list);
        List<UserEntity> listPage=pageData.getItems();
        for (UserEntity u:listPage) {
            System.out.println(u.getName());
        }
    }

    @Test
    public void adds() {
        List<UserEntity> list=new ArrayList<UserEntity>();
        UserEntity userEntity=new UserEntity();
        userEntity.setId("a");
        userEntity.setName("che233");
        UserEntity userEntity1=new UserEntity();
        userEntity1.setId("b");
        userEntity1.setName("che2322");
        list.add(userEntity);
        list.add(userEntity1);
        int i=userMapper.insertCollectList(list);
        System.out.println("新增"+i+"条");
    }

    @Test
    public void selectAll() {
        List<UserEntity> list=userMapper.selectAll();
        for (UserEntity u:list) {
            System.out.println(u.getName());
        }
    }

    @Test
    public void selectByPrimaryKey() {
        UserEntity u=new UserEntity();
        u.setId("0");
        UserEntity us=userMapper.selectByPrimaryKey(u);
        System.out.println(us.getName());

    }

    @Test
    public void update() {
        UserEntity userEntity=new UserEntity();
        userEntity.setId("1");
        userEntity.setName("che233");
        int i=userMapper.update(userEntity);
        System.out.println("修改数据："+i+"条");

    }

    @Test
    public void deleteByIdM() {
        int i=userMapper.deleteById("2");
        System.out.println("删除："+i+"条");

    }

    @Test
    public void addM() {
        UserEntity userEntity=new UserEntity();
        userEntity.setName("che233");
        int i=userMapper.insert(userEntity);
        System.out.println("增加："+i+"条");

    }

    @Test
    public void count() {
        UserEntity userEntity=new UserEntity();
        int i=userMapper.selectCount(userEntity);
        System.out.println("增加："+i+"条");

    }


}

