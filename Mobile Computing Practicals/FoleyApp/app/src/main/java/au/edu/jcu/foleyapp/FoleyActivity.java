package au.edu.jcu.foleyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class FoleyActivity extends AppCompatActivity {

    private String text_label;
    private AudioManager audioManager;
    private Context context;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foley);
        Intent intent = getIntent();
        Bundle text = intent.getExtras();
//        audioManager = new AudioManager(context);
        if(text != null)
            text_label = text.getString("Text_label");
        imageView = findViewById(R.id.Images);
        loadImage();
    }

    protected void loadImage(){
        /* References for images:
        *                         Photo by <a href="https://unsplash.com/@sita2?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Andrew S</a> on <a href="https://unsplash.com/s/photos/cats-and-dogs?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
        *                         Photo by <a href="https://unsplash.com/@robbie36?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Robert Collins</a> on <a href="https://unsplash.com/s/photos/children?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
        *                         Photo by <a href="https://unsplash.com/@cristianofirmani?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Cristiano Firmani</a> on <a href="https://unsplash.com/s/photos/technology?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>
        *                         Photo by <a href="https://unsplash.com/@timswaanphotography?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Tim Swaan</a> on <a href="https://unsplash.com/images/nature?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>*/

        if(text_label.equals("nature"))
            imageView.setImageResource(R.drawable.nature_image);
        else if(text_label.equals("animal"))
            imageView.setImageResource(R.drawable.animal_image);
        else if(text_label.equals("human"))
            imageView.setImageResource(R.drawable.human_image);
        else
            imageView.setImageResource(R.drawable.technology_image);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event){
//
//        if(event.getAction() == MotionEvent.ACTION_DOWN) {
//            if(text_label.equals("nature"))
//                audioManager.play(SoundCategory.nature, Position.TOP_LEFT);
//            else if(text_label.equals("animal"))
//                audioManager.play(SoundCategory.animal, Position.TOP_RIGHT);
//            else if(text_label.equals("human"))
//                audioManager.play(SoundCategory.human, Position.BOTTOM_LEFT);
//            else
//                audioManager.play(SoundCategory.technology, Position.BOTTOM_RIGHT);
//        }
//        return true;
//    }
//
}
