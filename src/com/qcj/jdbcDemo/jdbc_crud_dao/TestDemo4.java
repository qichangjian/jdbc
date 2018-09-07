package com.qcj.jdbcDemo.jdbc_crud_dao;

import com.qcj.dao.impl.UserInfoDaoImpl2;
import com.qcj.dao.impl.UserInfoDaoImpl4;
import com.qcj.entiry.UserInfo;

import java.util.List;

/**
 *   6
 *   使用properties 工具类
 *   软编码
 */
public class TestDemo4 {
    public static void main(String[] args) {
        UserInfoDaoImpl4 demo = new UserInfoDaoImpl4();// 实例化userinfo

        UserInfo userInfo = new UserInfo("demo2","123");
        demo.insert(userInfo);//插入

        UserInfo userInfo2 = new UserInfo(2,"demo22","123");
        demo.update(userInfo2);//修改

        demo.delete(2);//删除

        List<UserInfo> userInfos = demo.findAll();
        userInfos.forEach(System.out::println);//查询
    }
}
