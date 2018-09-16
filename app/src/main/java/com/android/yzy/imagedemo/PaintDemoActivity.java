package com.android.yzy.imagedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PaintDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new PaintDemoView(this));
    }
}
