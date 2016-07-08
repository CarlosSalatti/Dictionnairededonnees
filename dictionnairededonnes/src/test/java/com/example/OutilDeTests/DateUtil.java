package com.example.OutilDeTests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by eleves on 16-05-26.
 */
public class DateUtil {
    /**
     *
     * Display a given date as a string
     *
     * @param date the given date
     *
     * @return The string representation of it
     */

    private static String dateformat = "yyyy-MM-dd HH:mm:ss";

    public static String dateToString (Date input){
        String value = "";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateformat);
        value = simpleDateFormat.format(input);


        return value;
    }

    /**
     * Convert a String into a date
     * @param input String to be converted
     * @return a date
     */

    public static Date stringToDate (String input) throws ParseException {
        Date value = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateformat);
        value = simpleDateFormat.parse(input);

        return value;
    }

}
