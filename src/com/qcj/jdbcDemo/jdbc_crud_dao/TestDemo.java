package com.qcj.jdbcDemo.jdbc_crud_dao;

import com.qcj.dao.impl.UserInfoDaoImpl;
import com.qcj.entiry.UserInfo;
import java.util.List;

/**      3
 *    加入dao层代码，在dao层实现增删改查
 */
public class TestDemo {
    public static void main(String[] args) {
        UserInfoDaoImpl demo = new UserInfoDaoImpl();

        UserInfo userInfo = new UserInfo("demo2","123");
        demo.insert(userInfo);

        List<UserInfo> userInfos = demo.findAll();
        userInfos.forEach(System.out::println);

        UserInfo userInfo2 = new UserInfo(2,"demo22","123");
        demo.update(userInfo2);

        demo.delete(2);

        List<UserInfo> userInfos2 = demo.findAll();
        userInfos2.forEach(System.out::println);
    }
}
