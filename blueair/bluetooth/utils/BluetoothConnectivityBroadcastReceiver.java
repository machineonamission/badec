package com.blueair.bluetooth.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"},
   d2 = {"Lcom/blueair/bluetooth/utils/BluetoothConnectivityBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "connSink", "Lcom/blueair/bluetooth/utils/BluetoothConnectivitySink;", "<init>", "(Lcom/blueair/bluetooth/utils/BluetoothConnectivitySink;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "bluetooth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BluetoothConnectivityBroadcastReceiver extends BroadcastReceiver {
   private final BluetoothConnectivitySink connSink;

   public BluetoothConnectivityBroadcastReceiver(BluetoothConnectivitySink var1) {
      Intrinsics.checkNotNullParameter(var1, "connSink");
      super();
      this.connSink = var1;
   }

   public void onReceive(Context var1, Intent var2) {
      if (var2 != null && Intrinsics.areEqual(var2.getAction(), "android.bluetooth.adapter.action.STATE_CHANGED")) {
         switch (var2.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE)) {
            case 10:
               this.connSink.updateBluetoothConnectivityState(false);
               break;
            case 11:
               this.connSink.updateBluetoothConnectivityState(true);
               return;
            case 12:
               this.connSink.updateBluetoothConnectivityState(true);
               return;
            case 13:
               this.connSink.updateBluetoothConnectivityState(false);
               return;
         }
      }

   }
}
