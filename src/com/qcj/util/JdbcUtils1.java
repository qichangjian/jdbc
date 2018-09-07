package com.qcj.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 *   6  jdbc.properties
 *   软编码适应连接所有数据库
 *   数据库连接改变后，适应于所有数据库，硬编码
 */
public class JdbcUtils1 {
    static String url = null;
    static String username= null;
    static String password=null;

    static{
        Properties properties = new Properties();
        InputStream is = JdbcUtils1.class.getClassLoader().getResourceAsStream("jdbc.properties");//创建一个局部变量
        try {
            properties.load(is);
            is.close();
            Class.forName(properties.getProperty("driver"));
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                url, username, password
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
