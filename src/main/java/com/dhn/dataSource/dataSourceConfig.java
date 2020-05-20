package com.dhn.dataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/5/14 16:54
 */
public class dataSourceConfig {

    @Value("${dataSource}")
    private List<Map<String,String>> dataSource;
    @Value("${test}")
    private String test;

    public void connectDB(){

        for (Map<String,String> map : dataSource){
            String url = map.get("url");
            String user = map.get("username");
            String password = map.get("password");
            String driver = map.get("type");
            Connection conn= null;
            try {
                Class.forName(driver);
                conn= DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(conn);
        }
    }

    public void print(){
        System.out.println(test);
    }

    public static void main(String[] args) {
        dataSourceConfig d = new dataSourceConfig();
//        d.connectDB();
       d.print();
}
}
