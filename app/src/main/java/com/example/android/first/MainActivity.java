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
    /** Private attributes */
    private MediaPlayer mp;
    private boolean pausePlay;

    /** Default onCreate with added mediaplayer start, looping and log print to command line. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(getApplicationContext(), R.raw.zen);
        mp.start();
        mp.setLooping(true);
        pausePlay = false;
        Log.i("Pauser", "Pauser object created");
        Log.i("onCreate", "onCreate finished successfully");
    }
    /**
     * Method to toggle the pause flag, call 'mediaPause' to evaluate state and make the
     * media player to switch between pause and play.
     * The method is called from 'activity_main.xml' when the imageViews' onClick is triggered.
     */
    public void pause(View w) {
        pausePlay = pausePlay ?  false : true;
        if(mediaPause(pausePlay)){
            mp.pause();
            Log.i("PAUSE METHOD", "Media was paused");
        } else {
            mp.start();
            Log.i("PAUSE METHOD", "Media was restarted");
        }
    }

    /** Evaluates the mediaplayers' state and makes it switch between pause and play. Play is the
     *  new state if the player is paused and reversed.
     */
    protected boolean mediaPause(boolean flag) {
        Log.i("Media pauser", "executed");
        if (flag && mp.isPlaying()) {
            mp.pause();
        }
        if (!flag && !mp.isPlaying()) {
            mp.start();
        }
        return flag;
    }
}
