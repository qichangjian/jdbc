package com.qcj.jdbcDemo.jdbc;

import java.sql.*;

/**
 *    1
 *   mysql上课的第一个例子
 */
public class jdbcDemo1 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet result = null;
        try {
            //1.注册驱动，DriverManager管理具体的驱动程序，实现对底层屏蔽，对开发人员提供统一访问
            //java.sql.Driver：jdbc的Driver接口
            //com.mysql.jdbc.Driver：mysql对jdbc的Driver接口实现类
            //DriverManager.registerDriver(new Driver());//方法一：注册驱动 本质方法（对象被创建注册了两次，）
            Class.forName("com.mysql.jdbc.Driver");    //方法二： 动态加载注册mysql驱动   Driver静态块中实现了 DriverManager.registerDriver

            //2.建立连接:客户端程序与数据库服务进行连接，与数据库的交互都需要依赖此连接
            conn = DriverManager.getConnection("jdbc:mysql:///bd1807?useSSL=true", "root", "274039");//如果是localhost：3306可以省略
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1807?useSSL=true", "root", "274039");
            //System.out.println(conn);
            //元数据
            /*DatabaseMetaData md = conn.getMetaData();//元数据 解释数据的数据 可以获取连接的一些具体信息
            md.getDatabaseProductName();//数据库产品的名字
            md.getDriverName();         //使用的是谁的驱动
            md.getURL();                //连接的url
            md.getUserName();           //连接的用户名*/

            //3.发送sql给数据库服务
            String sql = "select * from userinfo";
            //statement对象：实现sql发送
            stmt = conn.createStatement(); //创建发送的sql的statement对象
            //底层维护是游标，next()移动游标获取每一行数据
            result = stmt.executeQuery(sql); //接受返回的结果

            /*
            //获取结果集的元数据
            ResultSetMetaData md = result.getMetaData();
            //拿到每行每列就能循环了
            int count = md.getColumnCount();//获取列
            String name = md.getColumnName(count);//每个字段知道名字，知道的名字好处是能实现反射
            */

            //4.处理相应的结果
            while(result.next()) {
                //result.getInt("id")
                System.out.println(result.getInt(1)+"_"+result.getString(2)+"_"+result.getInt(3)+"_"+result.getDate(4));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            //5.关闭
            try {
                if (result != null) {
                    result.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
