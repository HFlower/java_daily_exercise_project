package com.dhn.java8;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2019/10/17 16:40
 */
public class Java8Test4 {
    public static void main(String[] args) {

        Java8Test4 test = new Java8Test4();
        //本地DateTime API
//        test.testLocalDateTime();
        //ChronoUnit枚举
//        test.testChronoUnits();

        //Period - 处理有关基于时间的日期数量。 Duration - 处理有关基于时间的时间量。
//        test.testPeriod();
//        test.testDuration();

        //时间调节器
        test.testAdjusters();
    }



    private void testLocalDateTime() {
        //当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current DateTime:" + currentTime);

        //当前日期
        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);

        //当前月份
        Month month = currentTime.getMonth();
        //当前日
        int day = currentTime.getDayOfMonth();
        //当前秒
        int seconds = currentTime.getSecond();
        System.out.println("Month: " + month
                +"  day: " + day
                +"  seconds: " + seconds
        );

        //2019-10-10T16:52:43.732
        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2019);
        System.out.println("date2: " + date2);
        //2018-12-12
        LocalDate date3 = LocalDate.of(2018,Month.DECEMBER,12);
        System.out.println("date3: " + date3);
        //22:15
        LocalTime date4 = LocalTime.of(22,15);
        System.out.println("date4: " + date4);
        //20:15:30
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
    }

    private void testChronoUnits() {

        LocalDate today = LocalDate.now();
        System.out.println("today: " + today);

        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Next Week: " + nextWeek);

        LocalDate nextMonth = today.plus(1,ChronoUnit.MONTHS);
        System.out.println("Next Month: " + nextMonth);

        LocalDate nextYear = today.plus(1,ChronoUnit.YEARS);
        System.out.println("Next Year: " + nextYear);

        LocalDate nextDecade = today.plus(1,ChronoUnit.DECADES);
        System.out.println("Date after ten year: " + nextDecade);

    }

    private void testPeriod() {

        LocalDate date1 = LocalDate.now();
        System.out.println("Current Date:" + date1);

        LocalDate date2 = date1.plus(1,ChronoUnit.MONTHS);
        System.out.println("Next Month: " + date2);

        Period period = Period.between(date2,date1);
        System.out.println("Period: " + period);
    }

    private void testDuration() {

        LocalTime time1 = LocalTime.now();
        Duration twoHours = Duration.ofHours(2);

        LocalTime time2 = time1.plus(twoHours);

        Duration duration = Duration.between(time1,time2);
        System.out.println("Duration：" + duration);
    }

    private void testAdjusters() {

        LocalDate date1 = LocalDate.now();
        System.out.println("Current date: " + date1);

        LocalDate nextTuesday = date1.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println("Next Tuesday on : " + nextTuesday);

        LocalDate firstInYear = LocalDate.of(date1.getYear(),date1.getMonth(),1);

        LocalDate secondSaturday = firstInYear.with(
                TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)
        ).with(
                TemporalAdjusters.next(DayOfWeek.SATURDAY)
        );
        System.out.println("Second saturday on : " + secondSaturday);
    }
}
