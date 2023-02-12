package au.edu.jcu.guesstheceleb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssetManager manager = getAssets();
        try{
            String[] names = manager.list("celebs");
            System.out.println(Arrays.toString(names));

//            ImageView imageView = findViewById(R.id.image);
//
//            InputStream stream = manager.open("celebs/" + names[0]);
//            Bitmap bitmap = BitmapFactory.decodeStream(stream);
//
//            imageView.setImageBitmap(bitmap);

//            ImageManager imageManager = new ImageManager(this.getAssets(), "celebs");
//            ImageView imageView = findViewById(R.id.image);
//            imageView.setImageBitmap(imageManager.get(0));

        }
        catch (IOException e){
            System.out.println("failed to get names");
        }
    }
}
