package com.blueair.adddevice.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"},
   d2 = {"Lcom/blueair/adddevice/model/BluetoothConnectingInfo;", "", "deviceMac", "", "connectionState", "Lcom/blueair/adddevice/model/BluetoothConnectingState;", "<init>", "(Ljava/lang/String;Lcom/blueair/adddevice/model/BluetoothConnectingState;)V", "getDeviceMac", "()Ljava/lang/String;", "getConnectionState", "()Lcom/blueair/adddevice/model/BluetoothConnectingState;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BluetoothConnectingInfo {
   private final BluetoothConnectingState connectionState;
   private final String deviceMac;

   public BluetoothConnectingInfo(String var1, BluetoothConnectingState var2) {
      Intrinsics.checkNotNullParameter(var1, "deviceMac");
      Intrinsics.checkNotNullParameter(var2, "connectionState");
      super();
      this.deviceMac = var1;
      this.connectionState = var2;
   }

   // $FF: synthetic method
   public static BluetoothConnectingInfo copy$default(BluetoothConnectingInfo var0, String var1, BluetoothConnectingState var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.deviceMac;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.connectionState;
      }

      return var0.copy(var1, var2);
   }

   public final String component1() {
      return this.deviceMac;
   }

   public final BluetoothConnectingState component2() {
      return this.connectionState;
   }

   public final BluetoothConnectingInfo copy(String var1, BluetoothConnectingState var2) {
      Intrinsics.checkNotNullParameter(var1, "deviceMac");
      Intrinsics.checkNotNullParameter(var2, "connectionState");
      return new BluetoothConnectingInfo(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof BluetoothConnectingInfo)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.deviceMac, var1.deviceMac)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.connectionState, var1.connectionState);
         }
      }
   }

   public final BluetoothConnectingState getConnectionState() {
      return this.connectionState;
   }

   public final String getDeviceMac() {
      return this.deviceMac;
   }

   public int hashCode() {
      return this.deviceMac.hashCode() * 31 + this.connectionState.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("BluetoothConnectingInfo(deviceMac=");
      var1.append(this.deviceMac);
      var1.append(", connectionState=");
      var1.append(this.connectionState);
      var1.append(')');
      return var1.toString();
   }
}
