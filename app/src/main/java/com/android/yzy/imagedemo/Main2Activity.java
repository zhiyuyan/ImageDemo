package com.android.yzy.imagedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void gotoSurfaceView(View view) {
        Intent intent = new Intent(this, SurfaceViewActivity.class);
        startActivity(intent);
    }

    public void gotoBollsSurfaceView(View view) {
        Intent intent = new Intent(this, BollsActivity.class);
        startActivity(intent);
    }

    public void gotoMediaPlayerActivity(View view) {
        Intent intent = new Intent(this, MediaPlayerActivity.class);
        startActivity(intent);
    }

    public void gotoCanvasDemoActivity(View view) {
        Intent intent = new Intent(this, CanvasDemoActivity.class);
        startActivity(intent);
    }

    public void gotoPaintDemoActivity(View view) {
        Intent intent = new Intent(this, PaintDemoActivity.class);
        startActivity(intent);
    }

    public void gotoXmlDrawableActivity(View view) {
        Intent intent = new Intent(this, XmlDrawableDemoActivity.class);
        startActivity(intent);
    }
}
