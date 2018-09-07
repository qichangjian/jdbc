package com.qcj.jdbcDemo.jdbc_crud;

import com.qcj.entiry.UserInfo;

/**
 *  2
 *  增删改查
 *  防止sql注入
 */
import java.sql.*;

public class jdbc_crud_demo {
    public static void main(String[] args) {
        UserInfo info = new UserInfo("ww","1243");
        //insert(info);

        UserInfo info2 = new UserInfo("www","1243");
        //update(info2,1);

        //delete(1);

        //select();

        //login(info);

        //sql注入例子
        UserInfo info3 = new UserInfo(" ' or 1 = 1 or '","");
        //login(info3);

        //防止sql注入PreparedStatement
        login2(info3);//因为已经预编译了，所以sql注入就不管用了。


    }

    public static void insert(UserInfo info){
        Connection connection = null;
        Statement statement = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1807?useSSL=true","root","274039");
            //发送sql
            String sql = "insert into userinfos(uname,password) values('"+info.getUname()+"','"+info.getPassword()+"')";
            statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            System.out.println("插入：" + rows);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void update(UserInfo info,int id){
        Connection connection = null;
        Statement statement = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1807?useSSL=true","root","274039");
            //发送sql
            String sql = "update userinfos set uname = '"+info.getUname()+"', password = '"+info.getPassword()+"' where uid=" + id;
            statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            System.out.println("修改：" + rows);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete(int id){
        Connection connection = null;
        Statement statement = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd1807?useSSL=true","root","274039");
            //发送sql
            String sql = "delete from userinfos where uid=" + id;
            statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            System.out.println("删除：" + rows);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void select(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.建立连接:客户端程序与数据库服务进行连接，与数据库的交互都需要依赖此连接
            conn = DriverManager.getConnection("jdbc:mysql:///bd1807?useSSL=true", "root", "274039");//如果是localhost：3306可以省略
            //3.发送sql给数据库服务
            String sql = "select * from userinfos";
            stmt = conn.createStatement();
            result = stmt.executeQuery(sql); //接受返回的结果
            UserInfo userInfo = new UserInfo();
            //4.处理相应的结果
            while(result.next()) {
                userInfo.setUid(result.getInt("uid"));
                userInfo.setUname(result.getString("uname"));
                userInfo.setPassword(result.getString("password"));
                System.out.println(userInfo.toString());
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

    public static void login(UserInfo info){
        Connection conn = null;
        Statement stmt = null;
        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///bd1807?useSSL=true", "root", "274039");//如果是localhost：3306可以省略
            String sql = "select * from userinfos where uname = '"+ info.getUname() +"' and password = '" + info.getPassword() +"'";
            //System.out.println(sql);
            stmt = conn.createStatement();
            result = stmt.executeQuery(sql);
            if(result.next()){
                System.out.println("登录成功");
            }else{
                System.out.println("登录失败");
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

    public static void login2(UserInfo info){
        Connection conn = null;
        PreparedStatement ps = null; //Statement 子接口 PreparedStatement 防止sql注入，采用预编译的方式
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql:///bd1807?useSSL=true",
                    "root","274039"
            );
            String sql = "select * from userinfos where uname = ? and password = ?";
            ps = conn.prepareStatement(sql);//预编译（语法语义检查）
            //赋值
            ps.setString(1,info.getUname());
            ps.setString(2,info.getPassword());

            rs = ps.executeQuery();

            if(rs.next()){
                System.out.println("登录成功");
            }else{
                System.out.println("登录失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //5.关闭
            try {
                if (rs != null) {
                    rs.close();
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
    }
}
