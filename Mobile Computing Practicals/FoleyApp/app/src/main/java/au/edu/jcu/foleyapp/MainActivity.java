package au.edu.jcu.foleyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonPressed(View view){
        Button currentButton = (Button) view;
        Intent intent = new Intent(this, FoleyActivity.class);
        String text_label = currentButton.getText().toString();
        intent.putExtra("Text_label", text_label);
        startActivity(intent);
    }

}
