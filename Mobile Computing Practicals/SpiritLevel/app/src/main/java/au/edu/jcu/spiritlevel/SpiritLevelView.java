package au.edu.jcu.spiritlevel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class SpiritLevelView extends View {

    private PointF center;
    private int width, height;
    private PointF bubble;
    private Paint paint;

    public SpiritLevelView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        super.onSizeChanged(w, h, oldw, oldh);
        paint = new Paint();
        center = new PointF();
        center.x = w/2;
        center.y = h/2;
        bubble = new PointF(center.x, center.y);
        width = w;
        height = h;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int BUBBLE_SIZE = 50;
        canvas.drawCircle(bubble.x, bubble.y, BUBBLE_SIZE, paint);
    }

    public void setBubble(float x, float y){
        bubble.x = center.x + x * 50;
        bubble.y = center.y + y * 50;
        Log.i("SpiritLevelView", bubble.toString());

        invalidate();
    }

}
