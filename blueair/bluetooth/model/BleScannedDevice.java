package com.blueair.bluetooth.model;

import android.bluetooth.BluetoothDevice;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"},
   d2 = {"Lcom/blueair/bluetooth/model/BleScannedDevice;", "", "device", "Landroid/bluetooth/BluetoothDevice;", "serviceUuid", "", "connectable", "", "<init>", "(Landroid/bluetooth/BluetoothDevice;Ljava/lang/String;Z)V", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "getServiceUuid", "()Ljava/lang/String;", "getConnectable", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "bluetooth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BleScannedDevice {
   private final boolean connectable;
   private final BluetoothDevice device;
   private final String serviceUuid;

   public BleScannedDevice(BluetoothDevice var1, String var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "serviceUuid");
      super();
      this.device = var1;
      this.serviceUuid = var2;
      this.connectable = var3;
   }

   // $FF: synthetic method
   public static BleScannedDevice copy$default(BleScannedDevice var0, BluetoothDevice var1, String var2, boolean var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.device;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.serviceUuid;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.connectable;
      }

      return var0.copy(var1, var2, var3);
   }

   public final BluetoothDevice component1() {
      return this.device;
   }

   public final String component2() {
      return this.serviceUuid;
   }

   public final boolean component3() {
      return this.connectable;
   }

   public final BleScannedDevice copy(BluetoothDevice var1, String var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "serviceUuid");
      return new BleScannedDevice(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof BleScannedDevice)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.device, var1.device)) {
            return false;
         } else if (!Intrinsics.areEqual(this.serviceUuid, var1.serviceUuid)) {
            return false;
         } else {
            return this.connectable == var1.connectable;
         }
      }
   }

   public final boolean getConnectable() {
      return this.connectable;
   }

   public final BluetoothDevice getDevice() {
      return this.device;
   }

   public final String getServiceUuid() {
      return this.serviceUuid;
   }

   public int hashCode() {
      return (this.device.hashCode() * 31 + this.serviceUuid.hashCode()) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.connectable);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("BleScannedDevice(device=");
      var1.append(this.device);
      var1.append(", serviceUuid=");
      var1.append(this.serviceUuid);
      var1.append(", connectable=");
      var1.append(this.connectable);
      var1.append(')');
      return var1.toString();
   }
}
