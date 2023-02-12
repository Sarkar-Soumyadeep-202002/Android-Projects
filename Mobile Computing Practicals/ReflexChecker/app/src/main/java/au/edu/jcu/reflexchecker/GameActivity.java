package au.edu.jcu.reflexchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private final Random random = new Random();

    private static final int[] drawables = {R.drawable.baseline_card_giftcard_black_48,
                                            R.drawable.baseline_currency_exchange_black_48,
                                            R.drawable.baseline_data_exploration_black_48,
                                            R.drawable.baseline_done_all_black_48,
                                            R.drawable.baseline_pets_black_48,
                                            R.drawable.baseline_school_black_48};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        setupDescription(R.id.task1, R.array.task_1_description);
        setupDescription(R.id.task2, R.array.task_2_description);

        for(int i = 1; i <= 5; i++) {
            addRandomImage();
            addRandomCheckBoxes(R.array.Fruits);
        }

    }

    private void setupDescription(int taskID, int arrayID){
        TextView task = findViewById(taskID);
        String[] descriptions = getResources().getStringArray(arrayID);

        int i = random.nextInt(descriptions.length);
        task.setText(descriptions[i]);
    }

    private void addRandomImage(){
        ViewGroup gameRows = findViewById(R.id.game_rows);
        getLayoutInflater().inflate(R.layout.image, gameRows);

        View lastChild =  gameRows.getChildAt(gameRows.getChildCount() - 1);
        ImageView image = (ImageView) lastChild;

        int index = random.nextInt(drawables.length);
        image.setImageDrawable(getResources().getDrawableForDensity(drawables[index],0));
    }

    private void addRandomCheckBoxes(int arrayID){
        ViewGroup gameRows = findViewById(R.id.game_rows);
        getLayoutInflater().inflate(R.layout.checkboxes, gameRows);
    }

    public void clickDone(View view){
        long time_taken = System.nanoTime();
        time_taken /= 1000000000;
        String message = "That took you" + " " + Long.toString(time_taken) + " seconds";
        TextView textView = findViewById(R.id.time_display);
        textView.setText(message);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
