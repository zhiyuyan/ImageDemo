package com.android.yzy.imagedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yzy on 2018/9/16.
 */

public class DashBoardView extends View {

    public DashBoardView(Context context) {
        super(context);
    }

    public DashBoardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DashBoardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int width = getWidth();
        int height = getHeight();

        Paint paintCircle = new Paint();
        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setAntiAlias(true);
        paintCircle.setStrokeWidth(5);
        canvas.drawCircle(width / 2, height / 2, width / 2, paintCircle);

        Paint paintDegree = new Paint();
        paintDegree.setStrokeWidth(3);
        for (int i = 0; i < 24; i++) {
            if (i == 0 || i == 6 || i == 12 || i == 18) {
                paintDegree.setStrokeWidth(5);
                paintDegree.setTextSize(30);
                canvas.drawLine(width / 2, height / 2 - width / 2, width / 2, height / 2 - width / 2 + 60, paintDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree,
                        width / 2 - paintDegree.measureText(degree) / 2,
                        height / 2 - width / 2 + 90,
                        paintDegree);
            } else {
                paintDegree.setStrokeWidth(3);
                paintDegree.setTextSize(15);
                canvas.drawLine(width / 2, height / 2 - width / 2,
                        width / 2, height / 2 - width / 2 + 30,
                        paintDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree, width / 2 - paintDegree.measureText(degree) / 2,
                        height / 2 - width / 2 + 60,
                        paintDegree);
            }

            // 通过旋转画布简化坐标运算
            canvas.rotate(15, width / 2, height / 2);
        }

        // 画指针
        Paint paintHour = new Paint();
        paintHour.setStrokeWidth(20);
        Paint paintMinute = new Paint();
        paintMinute.setStrokeWidth(10);
        canvas.save();
        canvas.translate(width / 2, height / 2);
        canvas.drawLine(0, 0, 100, 100, paintHour);
        canvas.drawLine(0, 0, 100, 200, paintMinute);
        canvas.restore();
    }
}
