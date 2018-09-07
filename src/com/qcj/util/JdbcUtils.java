package com.qcj.util;

import java.sql.*;

/**
 *   5
 *   工具类
 *    所有连接和释放资源
 *    数据库连接改变后，适应于所有数据库，硬编码，
 *    所以要配置文件
 */
public class JdbcUtils {
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        //Class.forName("com.mysql.jdbc.Driver");//加载启动，只加载一次就行了
        return DriverManager.getConnection(  //硬编码，只能连接特定数据库
                "jdbc:mysql:///bd1807?useSSL=true",
                "root", "274039"
        );
    }

    public static void closeRes(Connection conn, PreparedStatement ps, ResultSet result) {
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
