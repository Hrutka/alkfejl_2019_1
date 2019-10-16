package hu.elte.issuetracker.utilities;

import java.util.List;

// TODO: ennek service-nek kéne lennie
public class SolveManager {

    public static String millisToReadable(int time) {
        /* TODO: idő ezredmásodpercekben -> HH:MM:SS.mmm alakra hozni
            pl.:0 -> "0.000"
                1000 -> "1.000"
                2512 -> "2.512"
                12999 -> "12.999"
                61000 -> "1:01.000"
                120000 -> "2:00.000"
            Ha találsz pont ilyet akkor használd, ha nem akkor csináld meg.
        */
        return "";
    }

    public static int readableToMillis(String time) {
        // TODO: HH:MM:SS.mmm -> ezredmásodpercekre
        return -1;
    }

    public static int avg(List<Integer> times) {
        int sum = 0;
        for (int time: times) {
            sum += time;
        }
        return Math.round((float)sum / (float)times.size());
    }

    // Legjobb és legrosszabb idők kivételével átlagolás
    public static int bo(List<Integer> times) {
        //TODO: tesztelni, hogy jó-e
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

        return Math.round((float)sum / times.size()-2.0f);
    }
}
