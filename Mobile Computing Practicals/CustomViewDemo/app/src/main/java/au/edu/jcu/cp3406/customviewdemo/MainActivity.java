package au.edu.jcu.cp3406.customviewdemo;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Handler mainHandler;
    private Runnable redraw;
    private boolean isRedrawing;
    private Button add, remove;
    private OuterspaceView outerspaceView;
    private List<Duck> ducks;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager = new AudioManager(this);
        ducks = new ArrayList<>();
        add = findViewById(R.id.add);
        remove = findViewById(R.id.remove);

        // setup redrawing
        mainHandler = new Handler();
        outerspaceView = findViewById(R.id.outerspaceView);
        outerspaceView.setDucks(ducks);
        redraw = () -> {
            if (isRedrawing) {
                moveDucks();
                outerspaceView.invalidate();
                mainHandler.postDelayed(redraw, 24);
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        isRedrawing = true;
        mainHandler.post(redraw);
        audioManager.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isRedrawing = false;
        audioManager.pause();
    }

    public void handleButtonClick(View view) {
        Random random = new Random();

        if (view == add) {
            if (ducks.size() < 100) {
                int width = outerspaceView.getWidth();
                int height = outerspaceView.getHeight();
                float scale = 0.25f + random.nextFloat() * (1 - 0.25f);
                ducks.add(new Duck(createBitmap(scale), width, height));
            }

        } else if (view == remove) {
            if (ducks.size() > 0) {
                int randomIndex = random.nextInt(ducks.size());
                ducks.remove(randomIndex);
            }
        }
    }

    private void moveDucks() {
        for (Duck duck : ducks) {
            boolean bounced = duck.move();
            if (bounced) {
                Random random = new Random();
                float speed = 0.5f + random.nextFloat() * (2 - 0.5f); // range: [0.5,2)
                float volume = 0.5f + random.nextFloat() * (1 - 0.5f); // [0.5, 1)
                audioManager.playSound(speed, volume);
            }
        }
    }

    private Bitmap createBitmap(float scale) {
        Point size = Utilities.computeSizeInDP(getWindowManager(), 0.5f);
        Bitmap bitmap = Utilities.decodeBitmap(getResources(), R.drawable.duckie, size);
        int width = Math.round(bitmap.getWidth() * scale);
        int height = Math.round(bitmap.getHeight() * scale);
        return Bitmap.createScaledBitmap(bitmap, width, height, true);
    }
}
