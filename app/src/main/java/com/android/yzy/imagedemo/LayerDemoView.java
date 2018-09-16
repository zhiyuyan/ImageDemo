package com.android.yzy.imagedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import static android.graphics.Canvas.ALL_SAVE_FLAG;

/**
 * Created by yzy on 2018/9/16.
 */

public class LayerDemoView extends View {

    public LayerDemoView(Context context) {
        super(context);
    }

    public LayerDemoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LayerDemoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();

        canvas.drawColor(Color.WHITE);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(150, 150, 100, paint);

        canvas.saveLayerAlpha(0, 0, 400, 400, 127, ALL_SAVE_FLAG);
        paint.setColor(Color.RED);
        canvas.drawCircle(200, 200, 100, paint);
        canvas.restore();

    }
}
