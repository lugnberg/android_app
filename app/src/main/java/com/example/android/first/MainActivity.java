package com.example.android.first;

import android.content.Intent;
import android.content.res.Resources;
import android.os.UserHandle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;

import static android.net.wifi.WifiConfiguration.Status.strings;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    boolean pausePlay;
    Pauser p;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(getApplicationContext(), R.raw.zen);
        mp.start();
        mp.setLooping(true);
        pausePlay = false;
        p = new Pauser(pausePlay);
        Log.i("Pauser", "Pauser object created");
        pause();
        Log.i("onCreate", "onCreate finished successfully");


    }
    protected void pause() {
        while(true) {
            Log.i("while loop", "entered");
            pausePlay = p.getPauseFlag();
            
            if (pausePlay && mp.isPlaying()) {
                mp.pause();
            }
            if (!pausePlay && !mp.isPlaying()) {
                mp.start();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void togglePauseFlag(View w) {
        p.toggleFlag();
    }
}
