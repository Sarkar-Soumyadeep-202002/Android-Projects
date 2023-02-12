package au.edu.jcu.stopwatchapp;

import androidx.annotation.NonNull;
import java.util.Locale;

public class StopWatch {
    private int hours,minutes, seconds;

    StopWatch(){
        hours = minutes = seconds = 0;
    }

    public StopWatch(String value){
        hours = Integer.parseInt(value.substring(0,2));
        minutes = Integer.parseInt(value.substring(3,5));
        seconds = Integer.parseInt(value.substring(6));
    }

    void tick(){
            seconds += 1;
            if (seconds == 60) {
                seconds = 0;
                minutes += 1;
            }
            if (minutes == 60) {
                minutes = 0;
                hours += 1;
            }
            if(hours == 100)
                hours = 0;

    }

    public String convertToString(){
        return String.format(Locale.getDefault(),"%02d:%02d:%02d", hours, minutes, seconds);
    }
}
