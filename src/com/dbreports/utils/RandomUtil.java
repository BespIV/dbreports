package com.dbreports.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class RandomUtil {
    final private Random random = new Random();

    public String getRandomString(int length){
        String alphabet="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();
        while(length>0){
            result.append(alphabet.charAt(random.nextInt(alphabet.length())));
            length--;
        }
        return result.toString().trim();
    }

    public int getRandomInteger(int length){
        StringBuilder result = new StringBuilder();
        while (length > 0) {
            result.append(random.nextInt(8)+1);
            length--;
        }
        return Integer.valueOf(result.toString());
    }

    public String getRandomDate(int year){
        Calendar calendar = new GregorianCalendar();
        calendar.set(calendar.YEAR, year);
        calendar.set(calendar.MONTH, random.nextInt(11));
        calendar.set(calendar.DAY_OF_MONTH,random.nextInt(20));
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        format.setTimeZone(calendar.getTimeZone());

        return format.format(calendar.getTime());
    }
}
