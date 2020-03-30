package com.dhn.javabasis.collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @description: list特殊的迭代方法
 * @author: Dong HuaNan
 * @date: 2020/3/29 17:39
 */
public class ListIteratorTest {
    public static void main(String[] args) {
        String[] books = {
                "疯狂java讲义",
                "疯狂iOS讲义",
                "轻量级Java EE企业应用实战"
        };
        List<String> bookList = new ArrayList<>();
        for (int i = 0; i < books.length; i++) {
            bookList.add(books[i]);
        }
        ListIterator lit = bookList.listIterator();
        while (lit.hasNext()){
            System.out.println(lit.next());
            lit.add("---------分隔符------------");
        }
        System.out.println("============反向迭代==============");
        while (lit.hasPrevious()){
            System.out.println(lit.previous());
        }
    }
}
