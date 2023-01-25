package be.jonasboon.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;

import static java.lang.String.format;

public class TimeUtils {

    public static String getMonthYearName(){
        String month = LocalDate.now().getMonth().toString();
        String year = Year.now().toString();
        return format("%s_%s", month, year);
    }

    public static String formattedTimeStamp(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String time = timeFormatter.format(now);
        String date = dateTimeFormatter.format(now);

        return format("| Date: %s \n| Time: %s",date,time);
    }
}
