package com.dhn.tools;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 阿里easyExcel
 * @author: Dong HuaNan
 * @date: 2020/4/13 17:45
 */
public class EasyExcelTest {
    public static void main(String[] args) {
        String fileName = "temp/" + "test" + Clock.systemDefaultZone().millis() + ".xlsx";
        EasyExcel.write(fileName)
                .head(head())
                .sheet("模板")
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .doWrite(dataList());
    }

    private static List<List<Object>> dataList() {
        List<List<Object>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Object> data = new ArrayList<>();
            data.add("点赞+"+i);
            data.add(new Date());
            data.add(0.56);
            list.add(data);
        }
        return list;
    }

    private static List<List<String>> head() {
        List<List<String>> list = new ArrayList<>();
        List<String> head0 = new ArrayList<>();
        head0.add("第一列");
        head0.add("第一列第二行");
        List<String> head1 = new ArrayList<>();
        head1.add("第一列");
        head1.add("第二列第二行");
        List<String> head2 = new ArrayList<>();
        head2.add("第一列");
        head2.add("第三列第二行");

        list.add(head0);
        list.add(head1);
        list.add(head2);
        return list;

    }
}
