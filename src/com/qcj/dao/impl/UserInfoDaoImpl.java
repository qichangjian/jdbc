package com.qcj.dao.impl;

import com.qcj.dao.UserInfoDao;
import com.qcj.entiry.UserInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**      3
 *    加入dao层代码，在dao层实现增删改查
 */
public class UserInfoDaoImpl implements UserInfoDao {
    @Override
    public List<UserInfo> findAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        List<UserInfo> userInfoList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql:///bd1807?useSSL=true",
                    "root", "274039"
            );
            String sql = "select * from userinfos";
            ps = conn.prepareStatement(sql);//预编译（语法语义检查）
            result = ps.executeQuery();
            while(result.next()) {
                UserInfo userInfo = new UserInfo();
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
            try {
                if (result != null) {
                    result.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userInfoList;
    }

    @Override
    public int insert(UserInfo info) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql:///bd1807?useSSL=true",
                    "root", "274039"
            );
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
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rows;
    }

    @Override
    public int update(UserInfo info) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql:///bd1807?useSSL=true",
                    "root", "274039"
            );
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
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rows;
    }

    @Override
    public int delete(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql:///bd1807?useSSL=true",
                    "root", "274039"
            );
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
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rows;
    }
}
