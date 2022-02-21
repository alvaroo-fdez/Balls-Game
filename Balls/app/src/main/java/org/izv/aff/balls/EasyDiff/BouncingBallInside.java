package org.izv.aff.balls.EasyDiff;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import org.izv.aff.balls.Ball;

import java.util.Random;

public class BouncingBallInside extends View {
    private Ball[] balls = new Ball[5];

    /*even new Ball can be added as variable e.g. ballcount passed as new Ball[ballcount] */

    public BouncingBallInside(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public BouncingBallInside(Context context) {
        super(context);
        init();
    }
    private void init(){
        //Add a new ball to the view
        for (int i =1; i <5 ; i++) {
            Random random = new Random();

            int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
            balls[i] = (new Ball(100, 100,i*10,50, color));
            //balls.add(new Ball(i*4,i*3,i*2, i*3,Color.GREEN));

        }
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Draw the balls

        for (int i =1; i <5 ; i++) {
            balls[i].move(canvas);
            //Draw them
            canvas.drawOval(balls[i].oval,balls[i].paint);
        }
        invalidate(); // See note
    }
}
