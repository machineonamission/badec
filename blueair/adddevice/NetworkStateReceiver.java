package com.blueair.adddevice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import io.flatcircle.connectivityhelper.NetUtil;
import timber.log.Timber;

public class NetworkStateReceiver extends BroadcastReceiver {
   public static void registerReceiver(Context var0, NetworkStateReceiver var1) {
      IntentFilter var2 = new IntentFilter();
      var2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      var0.registerReceiver(var1, var2);
   }

   public static void unregisterReceiver(Context var0, NetworkStateReceiver var1) {
      var0.unregisterReceiver(var1);
   }

   protected void connected(Context var1, Intent var2, boolean var3) {
      Timber.d("connected %s", new Object[]{var3});
   }

   public void onReceive(Context var1, Intent var2) {
      if (NetUtil.INSTANCE.isProbablyOnline(var1)) {
         this.connected(var1, var2, true);
      } else {
         this.connected(var1, var2, false);
      }
   }
}
