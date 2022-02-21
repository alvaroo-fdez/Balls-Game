package org.izv.aff.balls.HardDiff;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import org.izv.aff.balls.Ball;

import java.util.Random;

public class HardBouncing extends View {
    private Ball[] balls = new Ball[13];

    /*even new Ball can be added as variable e.g. ballcount passed as new Ball[ballcount] */

    public HardBouncing(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HardBouncing(Context context) {
        super(context);
        init();
    }

    private void init(){
        //Add a new ball to the view
        for (int i =1; i < 13 ; i++) {
            Random random = new Random();
            int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
            balls[i] = (new Ball(100, 100,i*3,50, color));
        }

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Draw the balls

        for (int i =1; i <13 ; i++) {
            balls[i].move(canvas);
            //Draw them
            canvas.drawOval(balls[i].oval,balls[i].paint);
        }
        invalidate(); // See note
    }
}

