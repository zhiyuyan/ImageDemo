package com.android.yzy.imagedemo;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class XmlDrawableDemoActivity extends AppCompatActivity {

    private ImageView mIvImage;
    private int mIndex;
    private TransitionDrawable mTransitionDrawable;
    private boolean mTransition;
    private int mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_drawable_demo);
        mIvImage = findViewById(R.id.iv_image_level);
        mIvImage.setImageDrawable(getDrawable(R.drawable.ic_level_demo));

        ImageView imageView = findViewById(R.id.iv_image_transition);
        mTransitionDrawable = (TransitionDrawable) imageView.getDrawable();
    }

    public void next(View view) {
        mIndex = (mIndex + 1) % 3;
        mIvImage.setImageLevel(mIndex);
    }

    public void nextTransition(View view) {
        mTransition = !mTransition;
        if (mTransition) {
            mTransitionDrawable.startTransition(1000);
        } else {
            mTransitionDrawable.reverseTransition(1000);
        }
    }

    private void startClip() {
        ImageView imageView = findViewById(R.id.iv_image_clip);
        final ClipDrawable drawable = (ClipDrawable) imageView.getDrawable();
        mProgress += 10;
        drawable.setLevel(drawable.getLevel() + mProgress * 100);
    }

    public void start(View view) {
        mProgress = 0;
        startClip();
    }
}
