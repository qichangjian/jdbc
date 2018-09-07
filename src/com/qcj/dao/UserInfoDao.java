package com.qcj.dao;

import com.qcj.entiry.UserInfo;

import java.util.List;

/**
 *  对userinfo表增删改查的规范
 */
public interface UserInfoDao {
    //查询所有
    List<UserInfo> findAll();

    //插入
    int insert(UserInfo userInfo);

    //修改
    int update(UserInfo userInfo);

    //删除
    int delete(int id);

}
