package com.qcj.dao.impl;

import com.qcj.dao.UserInfoDao;
import com.qcj.entiry.UserInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**   4
 *  抽取相同的部分
 *  选中相同代码：ctrl + alt + M
 */
public class UserInfoDaoImpl1 implements UserInfoDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet result = null;

    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> userInfoList = new ArrayList<>();
        try {
            conn = getConnection();
            String sql = "select * from userinfos";
            ps = conn.prepareStatement(sql);//预编译（语法语义检查）
            result = ps.executeQuery();
            UserInfo userInfo = new UserInfo();
            while(result.next()) {
                userInfo.setUid(result.getInt("uid"));
                userInfo.setUname(result.getString("uname"));
                userInfo.setPassword(result.getString("password"));
                userInfoList.add(userInfo);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭
            closeRes();
        }
        return userInfoList;
    }

    @Override
    public int insert(UserInfo info) {
        int rows = 0;
        try {
            conn = getConnection();
            String sql = "insert into userinfos(uname,password) values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,info.getUname());
            ps.setString(2,info.getPassword());
            rows = ps.executeUpdate();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭
            closeRes();
        }
        return rows;
    }

    @Override
    public int update(UserInfo info) {
        int rows = 0;
        try {
            conn = getConnection();
            String sql = "update userinfos set uname = ?, password = ? where uid=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,info.getUname());
            ps.setString(2,info.getPassword());
            ps.setInt(3,info.getUid());
            rows = ps.executeUpdate();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭
            closeRes();
        }
        return rows;
    }

    @Override
    public int delete(int id) {
        int rows = 0;
        try {
            conn = getConnection();
            String sql = "delete from userinfos where uid=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rows = ps.executeUpdate();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭
            closeRes();
        }
        return rows;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql:///bd1807?useSSL=true",
                "root", "274039"
        );
    }

    public void closeRes() {
        if (result != null) {
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
