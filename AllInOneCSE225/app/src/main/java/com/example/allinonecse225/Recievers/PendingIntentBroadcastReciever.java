package com.example.allinonecse225.Recievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

import com.example.allinonecse225.R;

public class PendingIntentBroadcastReciever extends BroadcastReceiver {

    MediaPlayer mediaPlayer;

    @Override
    public void onReceive(Context context, Intent intent) {

        mediaPlayer = MediaPlayer.create(context,R.raw.alarm);
        mediaPlayer.start();
        Toast.makeText(context,"Alarm...", Toast.LENGTH_SHORT).show();
    }
}
