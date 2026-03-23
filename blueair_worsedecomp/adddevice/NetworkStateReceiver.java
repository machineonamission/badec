package com.blueair.adddevice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import io.flatcircle.connectivityhelper.NetUtil;
import timber.log.Timber;

public class NetworkStateReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (NetUtil.INSTANCE.isProbablyOnline(context)) {
            connected(context, intent, true);
        } else {
            connected(context, intent, false);
        }
    }

    /* access modifiers changed from: protected */
    public void connected(Context context, Intent intent, boolean z) {
        Timber.d("connected %s", Boolean.valueOf(z));
    }

    public static void unregisterReceiver(Context context, NetworkStateReceiver networkStateReceiver) {
        context.unregisterReceiver(networkStateReceiver);
    }

    public static void registerReceiver(Context context, NetworkStateReceiver networkStateReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(networkStateReceiver, intentFilter);
    }
}
