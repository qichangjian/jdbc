package com.qcj.jdbcDemo.jdbc_crud_dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *   演示properties的用法
 *     ctrl + alt + v :给语句分配一个新的对象
 */
public class TestDemo4_properties {
    public static void main(String[] args) throws IOException {
        //map的实现类 key/value
        Properties properties = new Properties();
        //默认读取的位置classpath(默认) 根目录 或者config文件(跟src同级)下
          //src (Scource folder)
        InputStream is = TestDemo4_properties.class.getClassLoader().getResourceAsStream("jdbc.properties");//类加载器，读取文件为流
        //加载properties文件(读取流)
        properties.load(is);
        //获取
        properties.getProperty("driver");//获取
        System.out.println(properties.getProperty("driver"));
        //properties.setProperty("","");//设置

    }
}
