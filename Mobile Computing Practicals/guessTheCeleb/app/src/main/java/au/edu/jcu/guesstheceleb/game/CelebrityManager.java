package au.edu.jcu.guesstheceleb.game;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

public class CelebrityManager {

    private String assetpath;
    private String[] imageNames;
    private AssetManager assetManager;

    CelebrityManager(AssetManager assetManager, String assetpath) {

        this.assetpath = assetpath;
        this.assetManager = assetManager;

        try {
            imageNames = assetManager.list(assetpath);
        } catch (IOException e) {
            imageNames = null;
        }

    }

    Bitmap get(int i) {

        try {

            InputStream stream = assetManager.open("celebs/" + imageNames[i]);
            Bitmap bitmap = BitmapFactory.decodeStream(stream);
            stream.close();
            return bitmap;

        }
        catch (IOException e) {
            return null;
        }

    }

    public String getName(int i){

        return imageNames[i];

    }

    public int count(){

        return imageNames.length;

    }

}
