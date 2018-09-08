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

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private Paint mPaint = new Paint();

    private Timer mTimer;

    private TimerTask mTask;

    // 图形的坐标
    private float mX = 0;
    private float mY = 0;
    private float mSpeedx = 50;
    private float mSpeedy = 50;

    // 坐标移动的变化量
    private float mAddx = 2;
    private float mAddy = 2;

    public MySurfaceView(Context context) {
        super(context);
        mPaint.setColor(Color.RED);
        getHolder().addCallback(this);
    }

    public void draw() {
        Canvas canvas = getHolder().lockCanvas();

        canvas.drawRect(mX, mY, mSpeedx + mX, mSpeedy + mY, mPaint);
        mX += mAddx;
        mY += mAddy;

        if (mX < 0) {
            mAddx = Math.abs(mAddx);
        }

        if (mX > getWidth() - mSpeedx) {
            mAddx = -Math.abs(mAddx);
        }

        if (mY < 0) {
            mAddy = Math.abs(mAddy);
        }

        if (mY > getHeight() - mSpeedy) {
            mAddy = - Math.abs(mAddy);
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
        mTimer.schedule(mTask, 100, 100);
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
