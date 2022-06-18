package com.simicul.smf.model;

import android.content.BroadcastReceiver;
import android.widget.Toast;

public class Notify implements BaseNotify {
    public boolean notifyMessage(BroadcastReceiver ctx, String message) {
//        Toast.makeText(this, "", Toast.LENGTH_LONG).show();
        return false;
    }

    public boolean getNotifyStatus(String message_id) {
        return true;
    }

    public boolean cancelNotify(String message_id) {
        return false;
    }

    public void registerChanelMessage() {

    }
}
