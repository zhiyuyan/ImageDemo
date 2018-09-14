package com.android.yzy.imagedemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioManager;
import android.view.View;

/**
 * Created by yzy on 2018/9/12.
 */

public class DrawBitmapMeshView extends View {

    private static int HEIGHT = 100;
    private static int WIDTH = 200;

    private float mK;

    private Bitmap mBitmapSrc;
    private float[] mOrig;
    private float[] mVerts;

    public DrawBitmapMeshView(Context context) {
        super(context);
        mOrig = new float[(WIDTH + 1) * (HEIGHT + 1) * 2 + 10000];
        mVerts = new float[(WIDTH + 1) * (HEIGHT + 1) * 2 + 10000];
        mBitmapSrc = BitmapFactory.decodeResource(getResources(), R.drawable.flag);

        float bitmapWidth = mBitmapSrc.getWidth();
        float bitmapHeight = mBitmapSrc.getHeight();
        int index = 0;
        for (int y = 0; y <= HEIGHT; y++) {
            float fy = bitmapHeight * y / HEIGHT;
            for (int x = 0; x <= WIDTH; x++) {
                float fx = bitmapWidth * x / WIDTH;
                mOrig[index * 2 + 0] = mVerts[index * 2 + 0] = fx;
                mOrig[index * 2 + 1] = mVerts[index * 2 + 1] = fy + 300;
                index += 1;
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {

        flagWave();
        mK += 0.1f;
        canvas.drawBitmapMesh(mBitmapSrc, WIDTH, HEIGHT, mVerts, 10000, null, 0, null);
        invalidate();
    }

    private void flagWave() {
        for (int y = 0; y <= HEIGHT; y++) {
            for (int x = 0; x <= WIDTH; x++) {
                mVerts[(y * (WIDTH + 1) + x) * 2 + 0] += 0;
                float offsetY = (float) Math.sin((float) x / WIDTH * 2 * Math.PI + Math.PI * mK);
                mVerts[(y * (WIDTH + 1) + x) * 2 + 1] = mOrig[(y * WIDTH + 1) * 2 + 1] + offsetY * 20;
            }
        }
    }
}
