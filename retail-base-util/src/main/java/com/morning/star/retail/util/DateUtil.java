package com.morning.star.retail.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

public class DateUtil {

    public static final int DATE = 1;
    public static final int TIME = 2;
    public static final int DATE_TIME = 3;

    /**
     * 得到两个日期相差的天数
     */
    public static int getBetweenDay(Date date1, Date date2) {
        Calendar d1 = new GregorianCalendar();
        d1.setTime(date1);
        Calendar d2 = new GregorianCalendar();
        d2.setTime(date2);
        int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
        int y2 = d2.get(Calendar.YEAR);
        if (d1.get(Calendar.YEAR) != y2) {
            do {
                days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
                d1.add(Calendar.YEAR, 1);
            } while (d1.get(Calendar.YEAR) != y2);
        }
        return Math.abs(days);
    }

    /**
     * 简要说明：评论发表时间格式化 详细说明：
     * <p>
     * 发表时间，1小时以内用分钟显示，1天内用小时计，10天内以天计，10天以上用日期
     * <p>
     * 参数说明：
     *
     * @param date
     * @return
     */
    public static String getTimeLengthMinute(Date date) {
        return getTimeLengthMinute(date, "yyyy-MM-dd");
    }

    public static String getTimeLengthMinute(Date date, String fmt) {
        if (date == null) {
            return "";
        }
        Long nowtime = System.currentTimeMillis();
        Long tmptime = date.getTime();
        Long timelen = nowtime - tmptime;
        // 小于1分钟
        if (timelen <= 60000) {
            return timelen / 6000 + "秒前";
        }
        // 小于1小时
        else if (timelen <= 3600000) {
            return timelen / 60000 + "分钟前";
        }
        // 少于1天
        else if (timelen <= 86400000) {
            return timelen / 3600000 + "小时前";
        }
        // 少于10天
        else if (timelen <= 2592000000l) {
            return timelen / 86400000 + "天前";
        }
        // 少于60天
        else if (timelen <= 5184000000l) {
            return "1个月前";// timelen / 5184000000l + "天前";
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat(fmt);
            return formatter.format(date);
        }
    }

    public static Date todayDate() {
        return parse(nowDate(), "yyyy-MM-dd");
    }

    public static String now(String pattern) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    public static String day(String pattern, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, num);
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(calendar.getTime());
    }

    public static Date day(int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, num);
        return calendar.getTime();
    }

    public static Date day(Date date, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, num);
        return calendar.getTime();
    }

    public static String dayOnMonth(String pattern, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, month);
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(calendar.getTime());
    }

    public static Date dayOnMonth(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    public static String day(Date date, String pattern, int num) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.DAY_OF_YEAR, num);
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(calendar.getTime());
    }

    public static String day(String date, String pattern, int num) {

        Date dayDate = parse(date, "yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dayDate);

        calendar.add(Calendar.DAY_OF_YEAR, num);
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(calendar.getTime());
    }

    public static String month(String date, String pattern, int num) {

        Date dayDate = parse(date, "yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dayDate);
        calendar.add(Calendar.MONTH, num);
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(calendar.getTime());
    }

    public static String prevHourStart() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -1);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(calendar.getTime());
    }

    public static String prevHourEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -1);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(calendar.getTime());
    }

    public static String nowDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public static String nowDateTime() {
        return nowDateTime("yyyy-MM-dd HH:mm:ss");
    }

    public static String nowDateTime(String pattern) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    public static Date parse(String dateString) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date parse(String dateString, String pattern) {
        DateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String toString(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    public static String toString(Date date) {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    public static String toDate() {
        return toDate(new Date());
    }

    public static String toDate(Date date, int day) {
        return toDate(day(date, day));
    }

    public static String toDate(Date date) {
        return toString(date, "yyyy-MM-dd");
    }

    public static String toDateTime(Date date) {
        return toString(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String toDateTime() {
        return toString(new Date());
    }

    public static String toTime(Date date) {
        return toString(date, "HH:mm:ss");
    }

    public static Date isoStringToDate(String text, int type) {

        Calendar c = Calendar.getInstance();

        if (type != DATE_TIME)
            c.setTime(new Date(0));

        if ((type & DATE) != 0) {
            c.set(Calendar.YEAR, Integer.parseInt(text.substring(0, 4)));
            c.set(Calendar.MONTH, Integer.parseInt(text.substring(5, 7)) - 1 + Calendar.JANUARY);
            c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(text.substring(8, 10)));

            if (type == DATE_TIME)
                text = text.substring(11);
        }

        if ((type & TIME) == 0)
            return c.getTime();

        c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(text.substring(0, 2))); // -11
        c.set(Calendar.MINUTE, Integer.parseInt(text.substring(3, 5)));
        c.set(Calendar.SECOND, Integer.parseInt(text.substring(6, 8)));

        int pos = 8;
        if (pos < text.length() && text.charAt(pos) == '.') {
            int ms = 0;
            int f = 100;
            while (true) {
                char d = text.charAt(++pos);
                if (d < '0' || d > '9')
                    break;
                ms += (d - '0') * f;
                f /= 10;
            }
            c.set(Calendar.MILLISECOND, ms);
        } else
            c.set(Calendar.MILLISECOND, 0);

        if (pos < text.length()) {

            if (text.charAt(pos) == '+' || text.charAt(pos) == '-')

                c.setTimeZone(TimeZone.getTimeZone("GMT" + text.substring(pos)));

                /*
                 * return new Date (c.getTime ().getTime () + (Integer.parseInt
                 * (text.substring (pos+1, pos+3)) * 60 + Integer.parseInt
                 * (text.substring (pos+4, pos+6))) (text.charAt (pos) == '-' ?
                 * -60000 : 60000));
                 */

            else if (text.charAt(pos) == 'Z')
                c.setTimeZone(TimeZone.getTimeZone("GMT"));
            else
                throw new RuntimeException("illegal time format!");
        }

        return c.getTime();
    }

    public static Long getDaysBetween(Date startDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);

        return (toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24);
    }

    public static String getWeekFirstDay(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            cal.add(Calendar.WEEK_OF_YEAR, -1);
        }
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        return sdf.format(cal.getTime());
    }

    public static String getWeekFirstDay() {

        return getWeekFirstDay(Calendar.getInstance().getTime());
    }

    public static int getDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }

    public static int getHour() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public static String getMonthFirstDay() {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        return sdf.format(cal.getTime());
    }

    public static String getMonthFirstDay(String parent) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);

        DateFormat sdf = new SimpleDateFormat(parent);
        return sdf.format(cal.getTime());
    }

    public static String getPreMonthLastDay(String parent) {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);
        DateFormat sdf = new SimpleDateFormat(parent);
        return sdf.format(cale.getTime());
    }

    public static String getPreMonthFirstDay(String parent) {
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, -1);
        cale.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        DateFormat sdf = new SimpleDateFormat(parent);
        return sdf.format(cale.getTime());
    }

    @SuppressWarnings("deprecation")
    public static int DateMutDate(Date d1, Date d2) {
        int y1 = d1.getYear();
        int y2 = d2.getYear();
        int m1 = d1.getMonth();
        int m2 = d2.getMonth();
        int dd1 = d1.getDate();
        int dd2 = d2.getDate();
        int m = 0, y = 0;
        if (dd1 < dd2) {
            m = 1;
        }
        if (m1 - m < m2) {
            y = 1;
        }
        return y1 - y - y2;
    }

    public static boolean equals(Date d1, Date d2) {
        if (d1 == null || d2 == null)
            return false;
        return toDate(d1).equals(toDate(d2));
    }

    // 获得本星期
    public static String getWeekStr() {
        return getWeekStr(0);
    }

    public static String getWeekStr(int week) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR, week);
        return getWeekStr(calendar.getTime());
    }

    public static String getWeekStr(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int w = calendar.get(Calendar.WEEK_OF_YEAR);
        if (calendar.get(Calendar.DAY_OF_WEEK) == 1 && w == 1) {// 最后一个月的星期天
            w = 52;
        } else if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {// 普通的星期天
            w -= 1;
        }
        int m = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        if (m == 12 && w == 1) {// 最后一个月的星期一
            year += 1;
        }
        String y = year + "";
        String ws = w + "";
        if (ws.length() == 1) {
            ws = "0" + ws;
        }
        return y + ws;
    }

    public static String getWeekStr(String date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse(date, "yyyy-MM-dd"));
        int w = calendar.get(Calendar.WEEK_OF_YEAR);
        if (calendar.get(Calendar.DAY_OF_WEEK) == 1 && w == 1) {// 最后一个月的星期天
            w = 52;
        } else if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {// 普通的星期天
            w -= 1;
        }
        int m = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        if (m == 12 && w == 1) {// 最后一个月的星期一
            year += 1;
        }
        String y = year + "";
        String ws = w + "";
        if (ws.length() == 1) {
            ws = "0" + ws;
        }
        return y + ws;
    }

    public static long getPeriod(String date, int num) {
        Date time = DateUtil.parse(date, "yyyy-MM-dd");
        Date finaltime = day(time, num);
        Long result = Long.parseLong(DateUtil.toString(finaltime, "yyyyMMddHHmm"));
        return result;
    }

    public static long getYMD() {
        Long result = Long.parseLong(DateUtil.toString(new Date(), "yyyyMMdd"));
        return result;
    }

    /**
     * 字符串的日期格式的计算
     */
    public static int daysBetween(String smdate, String bdate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(smdate));
            long time1 = cal.getTimeInMillis();
            cal.setTime(sdf.parse(bdate));
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            return Integer.parseInt(String.valueOf(between_days));
        } catch (ParseException e) {
            return 0;
        }
    }

    /**
     * @param date1
     * @param date2
     * @return true=date1>date2
     * @Title: CompareDate
     * @Description: TODO(比较两个日期大小)
     */
    public static boolean CompareDate(Date date1, Date date2) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(date1);
            long time1 = cal.getTimeInMillis();
            cal.setTime(date2);
            long time2 = cal.getTimeInMillis();
            if (time1 > time2) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static long NowTime() {
        return Calendar.getInstance().getTime().getTime();
    }

    public static Date addMinute(Date date, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, amount);
        return c.getTime();
    }

    public static Date addDay(Date date, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, amount);
        return c.getTime();
    }

    public static Date addMonth(Date date, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, amount);
        return c.getTime();
    }

    public static Date addYear(Date date, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, amount);
        return c.getTime();
    }

    public static Date addHous(Date date, long amount) {
        Long l = date.getTime() + 60 * 60 * 1000 * amount;
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(l);
        return c.getTime();
    }

    public static int minusDate(Date d1, Date d2) {
        return Long.valueOf((d1.getTime() - d2.getTime()) / (24 * 60 * 60 * 1000)).intValue();
    }

    public static int getMinteBetween(Date d1, Date d2) {
        return Long.valueOf((d1.getTime() - d2.getTime()) / (60 * 1000)).intValue();
    }

    public static int getSecondBetween(Date d1, Date d2) {
        return Long.valueOf((d1.getTime() - d2.getTime()) / (1000)).intValue();
    }

    public static int getSecondBetween(long d1, long d2) {
        return Long.valueOf((d1 - d2) / (1000)).intValue();
    }

    public static void main(String[] args) {
        // System.out.println(getTimeLengthMinute(parse("2013-05-27 00:00:00",
        // "yyyy-MM-dd HH:mm:ss")));
        // System.out.println(toString(isoStringToDate("2013-09-18T03:26:47.829Z",3),
        // "yyyy-MM-dd HH:mm:ss"));
        // System.out.println(getDaysBetween(new Date(),parse("2014-6-15
        // 23:59:59")));
        // System.out.println(DateMutDate(DateUtil.parse("2013-11-27","yyyy-MM-dd"),
        // DateUtil.parse("2011-10-28","yyyy-MM-dd")));
        // Date d1 = parse("2014-6-25","yyyy-MM-dd");
        // Date d2 = new Date();
        // SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        // System.out.println(CompareDate(parse("2013-05-27 00:01:00",
        // "yyyy-MM-dd HH:mm:ss"),parse("2013-05-27 00:01:01", "yyyy-MM-dd
        // HH:mm:ss")));
        // System.out.println(getMonthFirstDay());
        System.out.println("------------");
        String s = getNextMonth();
        System.out.println(s.toString());
        System.out.println(getSecondBetween(parse("2015-03-19 00:08:00", "yyyy-MM-dd HH:mm:ss"),
                parse("2015-03-19 00:08:03", "yyyy-MM-dd HH:mm:ss")));
        // TODO 测试比较当前时间是不是在两个时间之间
        System.out.println(
                "今天六月十八日是不是五月一日到七月一日之间：" + isBetweenTwoDateNow(5, 1, 7, 1, new Date(System.currentTimeMillis())));
        System.out.println(
                "今天六月十八日是不是六月一日到七月一日之间：" + isBetweenTwoDateNow(6, 1, 7, 1, new Date(System.currentTimeMillis())));

        System.out.println(
                "今天六月十八日是不是五月一日到六月一日之间：" + isBetweenTwoDateNow(5, 1, 6, 1, new Date(System.currentTimeMillis())));
        System.out.println(
                "今天六月十八日是不是六月一日到六月十八日之间：" + isBetweenTwoDateNow(6, 1, 6, 18, new Date(System.currentTimeMillis())));
        System.out.println("今天是" + new Date(System.currentTimeMillis()).toString());
        System.out.println(
                "今天是不是六月十九日到六月二十九日之间" + isBetweenTwoDateNow(6, 19, 6, 29, new Date(System.currentTimeMillis())));
        System.out.println("------------");
        System.out.println("下个月是" + getNextMonth());
    }

    /**
     * 比较当前时间是不是在两个时间之间 TODO
     */
    public static boolean isBetweenTwoDateNow(int beginMonth, int beginDay, int endMonth, int endDay, Date nowTime) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(nowTime);
            int nowMonth = cal.get(Calendar.MONTH) + 1;
            System.out.println("nowMonth =" + nowMonth);
            int nowDay = cal.get(Calendar.DAY_OF_MONTH);
            if (beginMonth < nowMonth && nowMonth < endMonth) {
                return true;
            } else if (beginMonth == nowMonth && nowMonth < endMonth) {
                if (beginDay < nowDay || beginDay == nowDay) {
                    return true;
                }
            } else if (beginMonth < nowMonth && nowMonth == endMonth) {
                if (nowDay < endDay || nowDay == endDay) {
                    return true;
                }
            } else if (beginMonth == nowMonth && nowMonth == endMonth) {
                if (beginDay < nowDay || beginDay == nowDay && nowDay < endDay || nowDay == endDay) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * TODO 获得下一个月的年月
     */
    public static String getNextMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(System.currentTimeMillis()));
        String year = cal.get(Calendar.YEAR) + "";
        String nextMonth = cal.get(Calendar.MONTH) + 2 + "";
        System.out.println(year);
        String nextMonthString = year + "0" + nextMonth;
        return nextMonthString;
    }

    /**
     * 获取当天 开始时间
     *
     * @return
     */
    public static Date startOfToday() {
        return startOfDay(new Date());
    }

    /**
     * 获取当天 结束时间
     *
     * @return
     */
    public static Date endOfToday() {
        return endOfDay(new Date());
    }

    /**
     * 获取开始时间
     *
     * @return
     */
    public static Date startOfDay(Date start) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取结束时间
     *
     * @return
     */
    public static Date endOfDay(Date end) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(end);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static String getTimeDes(Date time) {
        String viewtime = "";
        Date now = new Date();
        long ny = 1000l * 24 * 60 * 60 * 365;// 一年的毫秒数
        long nmon = 1000l * 24 * 60 * 60 * 30;// 一月的毫秒数
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long nm = 1000 * 60;// 一分钟的毫秒数
        long df = now.getTime() - time.getTime();
        if (df < nm) {
            viewtime = "刚刚";
        } else if (nm <= df && df < nh) {
            viewtime = (df / nm + "分钟前");
        } else if (df >= nh && df < nd) {
            viewtime = (df / nh + "小时前");
        } else if (df >= nd && df < nmon) {
            viewtime = (df / nd + "天前");
        } else if (df >= nmon && df < ny) {
            viewtime = (df / nmon + "月前");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
            String dateStr = sdf.format(time);
            viewtime = dateStr;
        }
        return viewtime;
    }

    /**
     * 根据日期获取一个月的第一天
     *
     * @param date
     * @return
     */
    private static Date getMonthStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int index = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, (1 - index));
        return calendar.getTime();
    }

    /**
     * 根据日期获取一个月的最后一天
     *
     * @param date
     * @return
     */
    private static Date getMonthEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        int index = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, (-index));
        return calendar.getTime();
    }

    /**
     * 根据月份获取一个月的第一天
     *
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        if (year > 1970) {
            //设置年份
            cal.set(Calendar.YEAR, year);
        }
        if (month > 0) {
            //设置月份
            cal.set(Calendar.MONTH, month - 1);
        }
        //设置日历中月份的第1天
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        //格式化日期
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String firstDayOfMonth = sdf.format(cal.getTime());

        return cal.getTime();
    }

    /**
     * 根据月份获取一个月的最后一天
     *
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        if (year > 1970) {
            //设置年份
            cal.set(Calendar.YEAR, year);
        }
        //设置月份
        cal.set(Calendar.MONTH, month);
        //设置日历中月份的最后一天
        cal.set(Calendar.DAY_OF_MONTH, 0);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    private static Date getNextDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    //根据传入的日期获取所在月份所有日期
    public static List<String> getAllDaysMonthByDate(int year, int month, String pattern) {
        List<String> lst = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date firstDate = DateUtil.getFirstDayOfMonth(year, month);
        Date lastDate = DateUtil.getLastDayOfMonth(year, month);
        while (!firstDate.after(lastDate)) {
            lst.add(sdf.format(firstDate));
            firstDate = getNextDate(firstDate);
        }
        return lst;
    }
}
