package com.corporation.appollo.reggaenight;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private ImageView reggae_off;
    private ImageView reggae_on;

    private boolean reggaeIsOn = false;

    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reggae_off = (ImageView) findViewById(R.id.reggae_off);
        reggae_on = (ImageView) findViewById(R.id.reggae_on);

        // Invisible button
        Button button = (Button) findViewById(R.id.trigger_button);
        button.setVisibility(View.VISIBLE);
        button.setBackgroundColor(Color.TRANSPARENT);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                triggerReggae();
            }
        });

        mPlayer = MediaPlayer.create(this, R.raw.reggae_night);
    }

    private void playReggae() {
        mPlayer.seekTo(0);
        mPlayer.start();
    }

    private void stopReggae(){
        mPlayer.pause();
    }
    public void onDestroy() {
        mPlayer.stop();
        super.onDestroy();
    }

    /**
     * Triggers the reggae vibes
     */
    private void triggerReggae() {
        if (reggaeIsOn) {
            reggae_off.setVisibility(View.VISIBLE);
            reggae_on.setVisibility(View.GONE);
            reggaeIsOn = false;
            stopReggae();
        } else {
            reggae_off.setVisibility(View.GONE);
            reggae_on.setVisibility(View.VISIBLE);
            reggaeIsOn = true;
            playReggae();
        }
    }


}
