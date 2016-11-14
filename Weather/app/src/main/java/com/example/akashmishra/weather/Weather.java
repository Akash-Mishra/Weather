// Weather.java
// Maintain's one days weather information

package com.example.akashmishra.weather;

/**
 * Created by akash.mishra on 14/11/16.
 */

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Weather {
    public final String dayOfWeek;
    public final String minTemp;
    public final String maxTemp;
    public final String humidity;
    public final String description;
    public final String iconURL;

    // constructor
    public Weather(long timeStamp, double minTemp, double maxTemp, double humidity, String description, String iconName) {
        // NumberFormat to format double temperatures round to integers
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(0);

        this.dayOfWeek = convertTimeStampToDay(timeStamp);
        this.minTemp = numberFormat.format(minTemp) + "\u00B0F";
        this.maxTemp = numberFormat.format(maxTemp) + "\u00B0F";
        this.humidity = NumberFormat.getPercentInstance().format(humidity / 100.0);
        this.description = description;
        this.iconURL = "http://openweathermap.org/img/w/" + iconName + ".png";
    }


    // convert timestamp to a day's name( e.g., )
    private String convertTimeStampToDay(long timeStamp) {
        Calendar calendar =  Calendar.getInstance();   // create Calendar
        calendar.setTimeInMillis(timeStamp*1000);   // set Time
        TimeZone tz =  TimeZone.getDefault();    // get device's time zone

        // adjust time for device's time zone
        calendar.add(calendar.MILLISECOND, tz.getOffset(calendar.getTimeInMillis()));

        // SimpleDateFormat that returns the day's name
        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE");
        return dateFormatter.format(calendar.getTime());
    }
}
