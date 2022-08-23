package com.template.alarmmanagerproject;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlertReceiver extends BroadcastReceiver {

    /**
     * Этот метод будет вызван, когда сработает будильник
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper notificationHelper = new NotificationHelper(context);
        Notification.Builder nb = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(1, nb.build());
    }
}
