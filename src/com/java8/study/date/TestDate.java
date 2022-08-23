package com.java8.study.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * @ClassName TestDate
 * @Author kider
 * @Date 2022/8/23 23:40
 * @Version 1.0
 **/
public class TestDate {


    public static void main(String[] args) {

        //newFormat();

        //strToDate();

        //pushWeek();

        getDayNew();

    }


    public static void newFormat() {
        //format yyyy-MM-dd
        LocalDate date = LocalDate.now();
        System.out.println(String.format("date format : %s", date));

        //format HH:mm:ss
        LocalTime time = LocalTime.now().withNano(0);
        System.out.println(String.format("time format : %s", time));

        //format yyyy-MM-dd HH:mm:ss
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTimeStr = dateTime.format(dateTimeFormatter);
        System.out.println(String.format("dateTime format : %s", dateTimeStr));
    }

    public static void strToDate() {

        LocalDate date = LocalDate.of(2021, 1, 26);
        System.out.println(date.toString());
        date = LocalDate.parse("2021-01-26");
        System.out.println(date.toString());

        LocalDateTime dateTime = LocalDateTime.of(2021, 1, 26, 12, 12, 22);
        System.out.println(dateTime.toString());
        dateTime = LocalDateTime.parse("2021-01-26T12:12:22");
        System.out.println(dateTime.toString());

        LocalTime time = LocalTime.of(12, 12, 22);
        System.out.println(time.toString());
        time = LocalTime.parse("12:12:22");
        System.out.println(time.toString());
    }


    public static void pushWeek() {
        //一周后的日期
        LocalDate localDate = LocalDate.now();

        //方法1
        LocalDate after = localDate.plus(1, ChronoUnit.WEEKS);
        //方法2
        LocalDate after2 = localDate.plusWeeks(1);

        System.out.println("一周后日期：" + after);

        //算两个日期间隔多少天，计算间隔多少年，多少月
        LocalDate date1 = LocalDate.parse("2021-02-26");
        LocalDate date2 = LocalDate.parse("2021-12-23");
        Period period = Period.between(date1, date2);
        System.out.println("date1 到 date2 相隔："
                + period.getYears() + "年"
                + period.getMonths() + "月"
                + period.getDays() + "天");
        //打印结果是 “date1 到 date2 相隔：0年9月27天”
        //这里period.getDays()得到的天是抛去年月以外的天数，并不是总天数

        //如果要获取纯粹的总天数应该用下面的方法
        long day = date2.toEpochDay() - date1.toEpochDay();

        System.out.println(date2 + "和" + date2 + "相差" + day + "天");
        //打印结果：2021-12-23和2021-12-23相差300天
    }


    public static void getDayNew() {
        LocalDate today = LocalDate.now();
        //获取当前月第一天：
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfThisMonth.toString());

        // 取本月最后一天
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayOfThisMonth.toString());

        //取下一天：
        LocalDate nextDay = lastDayOfThisMonth.plusDays(1);
        System.out.println(nextDay.toString());

        //当年最后一天
        LocalDate lastday = today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println(lastday.toString());

        //2021年最后一个周日，如果用Calendar是不得烦死。
        LocalDate lastMondayOf2021 = LocalDate.parse("2022-12-31").with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));

        System.out.println(lastMondayOf2021.toString());
    }
}
