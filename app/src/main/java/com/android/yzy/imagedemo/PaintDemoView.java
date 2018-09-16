package com.android.yzy.imagedemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Created by yzy on 2018/9/14.
 */

public class PaintDemoView extends View {

    public PaintDemoView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        int number = paint.breakText("abcdfadfadf".toCharArray(), 0, 10, 300, null);
        Log.d("yzy", "" + number);

        paint.setTextSize(96);

//        paint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.SOLID));
//        paint.setShadowLayer(10f, 10f, 10f, Color.GRAY);
//        paint.setStrikeThruText(true);
        paint.setTextSkewX(1);
        paint.setUnderlineText(true);
        canvas.drawText("aaaaaaa", 100,100,paint);

//        paint.setStrokeCap(Paint.Cap.BUTT);
////        canvas.drawText("BUTT", 10, 50, paint);
//        paint.setStrokeWidth(36);
//        paint.setStrokeMiter(90);
//        canvas.drawLine(100, 50, 300, 50, paint);
    }
}
