package hu.elte.issuetracker.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

// TODO: ennek service-nek kéne lennie
public class SolveManager {

    public static String millisToReadable(int time) {
        Date date = new Date(time);
        DateFormat formatter = new SimpleDateFormat("H:mm:ss.SSS");

        if(time < 60000)
            formatter = new SimpleDateFormat("s.SSS");
        if(time >= 60000 && time < 3600000)
            formatter = new SimpleDateFormat("m:ss.SSS");

        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return formatter.format(date);
    }

    public static int readableToMillis(String time) {
        String[] sepByPoint = time.split("\\.");

        int millis = Integer.parseInt(sepByPoint[1].toString());

        String[] sepByColon = sepByPoint[0].split(":");

        int hmsInMillis=0;
        switch (sepByColon.length){
            case 0:
                break;
            case 1:
                hmsInMillis = Integer.parseInt(sepByColon[0])*1000;
                break;
            case 2:
                hmsInMillis += Integer.parseInt(sepByColon[1])*1000;
                hmsInMillis += Integer.parseInt(sepByColon[0])*60000;
                break;
            case 3:
                hmsInMillis += Integer.parseInt(sepByColon[2])*1000;
                hmsInMillis += Integer.parseInt(sepByColon[1])*60000;
                hmsInMillis += Integer.parseInt(sepByColon[0])*3600000;
                break;
        }
        return millis+hmsInMillis;
    }

    public static int avg(List<Integer> times) {
        int sum = 0;
        for (int time: times) {
            sum += time;
        }
        return Math.round((float)sum / (float)times.size());
    }

    // Legjobb és legrosszabb idők kivételével átlagolás
    public static int officialAvg(List<Integer> times) {
        //Legalább 3 idő szükséges
        if (times.size() < 3) {
            return -1;
        }

        int sum = 0;
        int min = times.get(0), max = times.get(0);
        for (int time: times) {
            sum += time;
            if (time < min) min = time;
            if (time > max) max = time;
        }
        sum -= max;
        sum -= min;

        return Math.round((float)sum / (times.size()-2.0f));
    }
}
