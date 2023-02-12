package au.edu.jcu.stopwatchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StopWatchActivity extends AppCompatActivity {

    private StopWatch stopWatch;
    private Handler handler;
    private boolean isRunning;
    private TextView display;
    private TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.toggle);
        isRunning = false;
        if (savedInstanceState == null)
            stopWatch = new StopWatch();

        else {
            stopWatch = new StopWatch(savedInstanceState.getString("value"));
            boolean running = savedInstanceState.getBoolean("running");
            if (running)
                enableStopWatch();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("value", stopWatch.convertToString());
        outState.putBoolean("running", isRunning);
    }

    private void enableStopWatch() {
        timer = findViewById(R.id.Timer);
        isRunning = true;
        handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (isRunning) {
                    stopWatch.tick();
                    timer.setText(stopWatch.convertToString());
                    handler.postDelayed(this, 1000);
                }
            }
        });
    }

    private void disableStopWatch() {
        isRunning = false;
        display.setText("Start");
        timer.setText("00:00:00");
        stopWatch = new StopWatch();
    }

    public void buttonClicked(View view) {
        Button toggle = (Button) view;
        if (!isRunning) {
            display.setText("Stop");
            enableStopWatch();
        } else
            disableStopWatch();


    }
}
