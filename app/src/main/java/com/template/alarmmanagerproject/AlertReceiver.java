package com.template.alarmmanagerproject;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlertReceiver extends BroadcastReceiver {

    /**
     * Этот метод будет вызван, когда сработает будильник
     *
     * @param context С помощью контекста мы можем создавать интенты и другие действия
     * @param intent Этот интент можно проверять, прежде чем выполнять обработку
     *               события: например, из него можно вытащить строку и обработать
     *               её дальше
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("alarm")) {
            NotificationHelper notificationHelper = new NotificationHelper(context);
            Notification.Builder nb = notificationHelper.getChannelNotification();
            notificationHelper.getManager().notify(1, nb.build());

            String name = intent.getStringExtra("name");

            Intent myIntent = new Intent(context, AlarmActivity.class);
            myIntent.putExtra("name", name);

            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(myIntent);
        }
    }
}
