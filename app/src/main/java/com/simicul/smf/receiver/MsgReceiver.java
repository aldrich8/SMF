package com.simicul.smf.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import com.simicul.smf.model.Analysis;

public class MsgReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        StringBuilder msgContent = this.getMessageContent(intent);

        Analysis analysis = new Analysis();
        analysis.isFraudulent(msgContent); // 识别诈骗的内容

        Toast.makeText(context, "发现一个骚扰短信,请注意", Toast.LENGTH_LONG).show();
    }

    private StringBuilder getMessageContent(Intent intent){
        StringBuilder content = new StringBuilder();
        String sender = "";

        Bundle bundle = intent.getExtras();
//        String format = intent.getStringExtra("format");

        if(bundle != null) {
            Object[] pdus = (Object[]) bundle.get("pdus");

            for (Object object: pdus) {
                SmsMessage message = SmsMessage.createFromPdu((byte[])object);
                sender = message.getOriginatingAddress();
                content.append(message.getMessageBody());
            }
        }

        return  content;
    }
}