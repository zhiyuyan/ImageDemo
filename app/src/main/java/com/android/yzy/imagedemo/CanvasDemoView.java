package com.android.yzy.imagedemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yzy on 2018/9/12.
 */

public class CanvasDemoView extends View {


    public CanvasDemoView(Context context) {
        super(context);
    }

    public CanvasDemoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasDemoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(6);
//        canvas.drawLine(10,10,100,100, paint);
//
//        RectF rect = new RectF(100,10,300,110);
//        canvas.drawArc(rect,10,90,true,paint);
//
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
//        canvas.drawBitmap(bitmap,0,200,paint);
//
//        canvas.drawCircle(400, 400, 100, paint);

        paint = new Paint();
        paint.setTextSize(36);
        canvas.drawPosText("Hello", new float[] {50, 50, 90, 90, 130, 130, 170, 170, 210, 210}, paint);

        Path path = new Path();
        path.moveTo(100, 100);
        path.lineTo(400,400);
        canvas.drawTextOnPath("Hello", path,100,100, paint);

        RectF rectF = new RectF(300,10, 500, 100);
        canvas.drawRoundRect(rectF, 20, 40, paint);

        canvas.drawTextRun("asdfghjklzxcvbnm", 0,10,0,10,400,400, false, paint);
    }
}
