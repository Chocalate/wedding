package com.lingnan.wedding.core.util;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 */
public class DateUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy-MM-dd");

    private static SimpleDateFormat dateSdf1 = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 获取当前时间
     *
     * @return 返回本地化的当前时间
     */
    public static String getNowTime() {
        return sdf.format(new Date());
    }

    public static String getNowDate() {
        return dateSdf.format(new Date());
    }

    public static String after(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, day);
        return sdf.format(calendar.getTime());
    }


    public static int dayDiff(String start, String end) {
        try {
            Date pre = sdf.parse(start);
            Date post = sdf.parse(end);
            long from = pre.getTime();
            long to = post.getTime();
            return (int) ((to - from) / (1000 * 60 * 60 * 24));
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 日期转字符串
     */
    public static String stringDate(Date date){
        return sdf.format(date);
    }

    /**
     * 日期转字符串
     */
    public static String dateToString(Date date){
        return dateSdf1.format(date);
    }

}
