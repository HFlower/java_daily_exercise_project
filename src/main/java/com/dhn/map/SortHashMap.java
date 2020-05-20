package com.dhn.map;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @description: 已知一个HashMap<Integer,User>集合，user有name(String)和age(int)属性，写一个方法实现对HashMap的排序功能，该方法接收HashMap<Integer,User>为形参，返回类型为HashMap<Integer,User>，要求对HashMap中的User的age倒序进行排序。排序时key=value键值对不得拆散。
 * @author: Dong HuaNan
 * @date: 2020/3/9 14:19
 */
public class SortHashMap {

    public static HashMap<Integer,User> sort(HashMap<Integer,User> userHashMap){
        LinkedHashMap<Integer,User> result = new LinkedHashMap<>();
        //map键值对集合
        Set<Map.Entry<Integer,User>> userEntry = userHashMap.entrySet();
        //set转成list
        List<Map.Entry<Integer,User>> list = new ArrayList<>(userEntry);
        //使用Collections集合工具类对list进行排序，排序规则重写匿名内部类来实现
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge()-o1.getValue().getAge();
            }
        });

        //将已排好序的list存到有序的LinkedHashMap集合
        for (Map.Entry<Integer,User> entry : list){
            result.put(entry.getKey(),entry.getValue());
        }

        return result;
    }

    public static void main(String[] args) {

//        HashMap<Integer,User> userHashMap = new HashMap<>();
//        userHashMap.put(1,new User("aa",19));
//        userHashMap.put(2,new User("bb",24));
//        userHashMap.put(3,new User("cc",21));
//        userHashMap.put(4,new User("dd",23));
//        userHashMap.put(5,new User("ee",20));
//
//
//        System.out.println("未排序的："+userHashMap);
//
//        HashMap<Integer,User> sort = SortHashMap.sort(userHashMap);
//        System.out.println("已排序的："+sort);

        SortedSet<String> createTime = new TreeSet<>();
        createTime.add("2020_05_01");
        createTime.add("2020_11_10");
        createTime.add("2021_06_01");
        createTime.add("2020_06_03");
        createTime.add("2020_01_30");
        String latest = createTime.last();
        System.out.println(latest);
    }
}

class User{
    private String name;
    private int age;

    public User(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}