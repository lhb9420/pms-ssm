package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeGenerate {


    public static void main(String[] args) {
        System.out.println(getday());
        System.out.println(gethour());
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
}
