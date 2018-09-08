package com.android.yzy.imagedemo;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class MediaPlayerActivity extends AppCompatActivity implements SurfaceHolder.Callback {

    private SurfaceView mSurfaceView;
    private MediaPlayer mMediaPlayer;
    private String URL = "http://fairee.vicp.net:83/2016rm/0116/baishi160116.mp4";

    private int mPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        mMediaPlayer = new MediaPlayer();
        mSurfaceView = findViewById(R.id.surface_view);
        mSurfaceView.getHolder().setKeepScreenOn(true);
        mSurfaceView.getHolder().addCallback(this);
    }

    public void start(View view) {
        play();
    }

    public void pause(View view) {
        pause();
    }

    public void pause() {
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
            mPosition = mMediaPlayer.getCurrentPosition();
        }
    }

    public void goOn(View view) {
        mMediaPlayer.seekTo(mPosition);
        mMediaPlayer.start();
    }

    public void stop(View view) {
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
        }
    }

    public void play() {
        try {
            mMediaPlayer.reset();
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.setDisplay(mSurfaceView.getHolder());
            mMediaPlayer.setDataSource(URL);

            mMediaPlayer.prepare();
            mMediaPlayer.start();

        } catch (IOException e) {
            Toast.makeText(this, "路径错误", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mPosition = mMediaPlayer.getCurrentPosition();
            mMediaPlayer.stop();
        }
    }
}
