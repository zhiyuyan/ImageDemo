package com.android.yzy.imagedemo;

/**
 * Created by yzy on 2018/9/8.
 */

public class Bolls {

    private float mCx;
    private float mCy;
    private float mRadius;
    private int mAddx;
    private int mAddy;
    private int mAddRadius;

    BollsSurfaceView mView;

    public Bolls(BollsSurfaceView view) {
        this.mView = view;
        mCx = (float) (Math.random() * 1000);
        mCy = (float) (Math.random() * 1000);
        mRadius = (float) (Math.random() * 30);
        mAddx = (int) (Math.random() * 10);
        mAddy = (int) (Math.random() * 10);
        mAddRadius = (int) (Math.random() * 10);
    }

    public float getCx() {
        return mCx;
    }

    public void setCx(float cx) {
        this.mCx = cx;
    }

    public float getCy() {
        return mCy;
    }

    public void setCy(float cy) {
        this.mCy = cy;
    }

    public float getRadius() {
        return mRadius;
    }

    public void setRadius(float radius) {
        this.mRadius = radius;
    }

    public void draw() {
        mCx += mAddx;
        mCy += mAddy;
        mRadius += mAddRadius;
        if (mCx < mRadius) {
            mAddx = Math.abs(mAddx);
        }
        if (mCx > mView.getWidth() - mRadius) {
            mAddx = -Math.abs(mAddx);
        }
        if (mCy < mRadius) {
            mAddy = Math.abs(mAddy);
        }
        if (mCy > mView.getHeight() - mRadius) {
            mAddy = -Math.abs(mAddy);
        }
    }
}
