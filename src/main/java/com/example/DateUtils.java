package com.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * A certain date date increase count A natural month
     * @param date A certain date (yyyy-MM-dd Format )
     * @param count Added months
     * @return
     * @throws ParseException
     */
    public static String addMonth(String date, int count) throws ParseException {
        int year = Integer.parseInt(date.split("-")[0]);
        int month = Integer.parseInt(date.split("-")[1]);
        int day = Integer.parseInt(date.split("-")[2]);
        int addY=count/12;
        int addM=count%12;
        if (addM + month > 12) {
            year = year+addY+1;
            month =(month+addM)%12;
        } else {
            year+=addY;
            month += addM;
        }
        if (day >=28) {
            if(day>=getDayByMonth(year + "-" + Integer.parseInt(date.split("-")[1]))) { // Is the end of the month or greater
                day=getDayByMonth(year + "-" + month); // The date changes to the corresponding month end
            }
        }
        return sdf.format(sdf.parse(year + "-" + month + "-" + day));
    }
    /**
     * Get the number of days in the current month
     *
     * @param date
     * @return
     */
    public static int getDayByMonth(String date) {
        int year = Integer.parseInt(date.split("-")[0]);
        int month = Integer.parseInt(date.split("-")[1]);
        int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (2 == month && 0 == (year % 4) && (0 != (year % 100) || 0 == (year % 400))) {
            days[1] = 29;
        }
        return Integer.valueOf(days[month - 1]);
    }

    public static void main(String[] args) throws ParseException {
        String date="2020-02-29";
        Integer i=1;
        System.out.println(" get "+date+" Add "+i+" Natural month time ："+addMonth(date,i));
    }
}
