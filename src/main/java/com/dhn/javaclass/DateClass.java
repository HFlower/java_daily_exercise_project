package com.dhn.javaclass;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 * @description: java日期类
 * @author: Dong HuaNan
 * @date: 2020/2/29 15:38
 */
public class DateClass {

    /**
     * java8中的日期时间类不可变，都是线程安全的
     * @param args
     */

    public static void main(String[] args) {

        System.out.println("************************获取年月日时分秒************************");
        //1、获取年月日时分秒（两种方式）
        Calendar cal = Calendar.getInstance();
        System.out.println("Calendar:" + cal.get(Calendar.YEAR) + "年" +
                        //month:0~11
                cal.get(Calendar.MONTH) + "月" +
                cal.get(Calendar.DATE) + "日" +
                cal.get(Calendar.HOUR_OF_DAY) + "时" +
                cal.get(Calendar.MINUTE) + "分" +
                cal.get(Calendar.SECOND) + "秒"
                );

        //Java 8
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("LocalDateTime:" + ldt.getYear() + "年"
                //month:1~12
                + ldt.getMonthValue()+"月"
                + ldt.getDayOfMonth() + "日"
                + ldt.getHour()+ "时"
                + ldt.getMinute()+ "分"
                + ldt.getSecond()+ "秒"

        );
        System.out.println("************************2、获取时间戳************************");

        //获取时间戳（三种方式）
        System.out.println(System.currentTimeMillis());
        System.out.println(Calendar.getInstance().getTimeInMillis());
        //java 8
        System.out.println(Clock.systemDefaultZone().millis());

        System.out.println("***********************3、获取某月最后一天************************");
        //获取某月最后一天(2种方式)
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //获取当前月第一天
        cal.add(Calendar.MONTH,0);
        //设置为1号
        cal.set(Calendar.DAY_OF_MONTH,1);
        String first = format.format(cal.getTime());
        //最后一天
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = format.format(cal.getTime());
        System.out.println("Calendar----first:" + first +"   last:"+last);

        //java 8
        LocalDate today = LocalDate.now();
        LocalDate firstDay = LocalDate.of(today.getYear(),today.getMonth(),1);
        LocalDate lastDay = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("LocalDate----first:" + firstDay +"   last:"+lastDay);

        System.out.println("***********************4、格式化日期************************");
        //1.Java.text.DataFormat的子类SimpleDateFormat
        //2.java.time.format.DateTimeFormatter
        Date date = new Date();
        System.out.println("SimpleDateFormat----:" + format.format(date));

        //java 8
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("DateTimeFormatter----:" + ldt.format(dtf));

        System.out.println("***********************5、获取昨日的当前时刻************************");
        cal.add(Calendar.DATE,-1);
        System.out.println("Calendar----Yesterday:" + format.format(cal.getTime()));
        //java 8
        LocalDateTime ldt2 = ldt.minusDays(1);
        System.out.println("LocalDateTime----Yesterday:" +ldt2.format(dtf));


    }

}
