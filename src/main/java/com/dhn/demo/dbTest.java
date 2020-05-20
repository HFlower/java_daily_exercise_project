package com.dhn.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/5/14 11:48
 */
public class dbTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String URL="jdbc:mysql://localhost:3306/bde?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
        String USER="root";
        String PASSWORD="root";
        //1.加载驱动程序
        Class.forName("com.alibaba.druid.pool.DruidDataSource");
        //2.获得数据库链接
        Connection conn= DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from acct_type");

        List<Map<String,Object>> list = new ArrayList<>();
        //4.处理数据库的返回结果(使用ResultSet类)
        while(rs.next()){
            System.out.println(rs.getString("code"));
//            Map<String,Object> map = new HashMap<>();
//            map.put("code",rs.getString("code"));
//            map.put("name",rs.getString("name"));
//            list.add(map);
        }

        //关闭资源
        rs.close();
        st.close();
        conn.close();
    }
}
