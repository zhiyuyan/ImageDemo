package com.android.yzy.imagedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yzy on 2018/9/8.
 */

public class BollsSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private Paint mPaint = new Paint();

    private Timer mTimer;

    private TimerTask mTask;

    private Bolls mBolls;

    public BollsSurfaceView(Context context) {
        super(context);
        mPaint.setColor(Color.RED);
        getHolder().addCallback(this);
    }

    public void draw() {
        Canvas canvas = getHolder().lockCanvas();

        canvas.drawColor(Color.WHITE);

        for (int i = 0; i < 20; i++) {
            mBolls = new Bolls(this);
            canvas.drawCircle(mBolls.getCx(), mBolls.getCy(), mBolls.getRadius(), mPaint);
            mBolls.draw();
        }

        getHolder().unlockCanvasAndPost(canvas);
    }

    public void startTimer() {
        mTimer = new Timer();
        mTask = new TimerTask() {
            @Override
            public void run() {
                draw();
            }
        };
        mTimer.schedule(mTask, 100, 1000);
    }

    public void stopTimer() {
        mTimer.cancel();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        startTimer();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        stopTimer();
    }
}
