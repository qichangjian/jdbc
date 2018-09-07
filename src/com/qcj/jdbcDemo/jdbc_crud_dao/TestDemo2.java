package com.qcj.jdbcDemo.jdbc_crud_dao;

import com.qcj.dao.impl.UserInfoDaoImpl1;
import com.qcj.entiry.UserInfo;
import java.util.List;

/**
 *    4
 *   把dao层增删改查中相同部分代码抽离出来。
 */
public class TestDemo2 {
    public static void main(String[] args) {
        UserInfoDaoImpl1 demo = new UserInfoDaoImpl1();// 实例化userinfo

        UserInfo userInfo = new UserInfo("demo2","123");
        demo.insert(userInfo);//插入

        UserInfo userInfo2 = new UserInfo(2,"demo22","123");
        demo.update(userInfo2);//修改

        demo.delete(2);//删除

        List<UserInfo> userInfos = demo.findAll();
        userInfos.forEach(System.out::println);//查询
    }
}
