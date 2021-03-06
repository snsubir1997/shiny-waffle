package com.subir.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1;
    Intent intent;

    private static final String CHANNEL_ID = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.showNotif);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotificationChannel();
                showNotification();
            }
        });
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "MyNotif";
            String description = "SomeDescription";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
    }



    private void showNotification() {

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);


        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("SomeNotification")
                .setContentText("Hello your imposrtant mesage is XYZ")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("I don't know why am I learning these things that I can always look up on " +
                                "the developer site and with practice can learn it automatically." +
                                "Much longer shit that cannot fit one line..." +
                                "FuckThis I am done with life"))
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .addAction(R.drawable.ic_launcher_foreground, "Show", pendingIntent)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(123, notificationBuilder.build());
    }
}
