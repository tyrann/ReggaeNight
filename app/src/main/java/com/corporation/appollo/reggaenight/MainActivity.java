package com.corporation.appollo.reggaenight;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer mPlayer = MediaPlayer.create(this,R.raw.reggae_night);
    }
    private void playReggae() {
        mPlayer.start();
    }

    private void stopReggae(){
        mPlayer.stop();
    }
    public void onDestroy() {

        mPlayer.stop();
        super.onDestroy();

    }
}
