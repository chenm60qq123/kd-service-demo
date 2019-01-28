package com.kd.servicedemo.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ProjectName: kd-service-demo
 * @Package: com.kd.servicedemo.vo
 * @ClassName: TableVo
 * @Description: java类作用描述
 * @Author: Mr.c
 * @CreateDate: 2019/1/28 9:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/1/28 9:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
public class TableVo {
    @Id
    private String id;
    private String name;
    private boolean leaf;
}
