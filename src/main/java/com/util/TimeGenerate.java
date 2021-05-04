package com.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeGenerate {


    public static void main(String[] args) {
    }
    public static String getday(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
    public static String gethour(){
        SimpleDateFormat formatter= new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
    public static int timesort(){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date now,begin,end;
        try {
            now=df.parse(df.format(new Date()));
            if (time_range(now,df.parse("8:00"),df.parse("9:00"))){
                return 1;
            }
            else if (time_range(now,df.parse("12:00"),df.parse("13:00"))){
                return 2;
            }
            else if (time_range(now,df.parse("13:00"),df.parse("14:00"))){
                return 3;
            }
            else if (time_range(now,df.parse("18:00"),df.parse("19:00"))){
                return 4;
            }
            else if (time_range(now,df.parse("19:00"),df.parse("20:00"))){
                return 5;
            }
            else if (time_range(now,df.parse("22:00"),df.parse("23:00"))){
                return 6;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    public static boolean time_range(Date nowtime,Date begintime,Date endtime){
        //设置现在时间
        Calendar date=Calendar.getInstance();
        date.setTime(nowtime);
        //设置开始时间
        Calendar begin=Calendar.getInstance();
        begin.setTime(begintime);
        //设置结束时间
        Calendar end=Calendar.getInstance();
        end.setTime(endtime);
        if (date.after(begin)&&date.before(end)){
            return true;
        }else {
            return false;
        }
    }

}
