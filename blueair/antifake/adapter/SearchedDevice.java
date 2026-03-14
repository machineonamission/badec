package com.blueair.antifake.adapter;

import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"},
   d2 = {"Lcom/blueair/antifake/adapter/SearchedDevice;", "", "device", "Lcom/blueair/core/model/Device;", "bluetoothDevice", "Lcom/blueair/core/model/BluetoothDevice;", "<init>", "(Lcom/blueair/core/model/Device;Lcom/blueair/core/model/BluetoothDevice;)V", "getDevice", "()Lcom/blueair/core/model/Device;", "getBluetoothDevice", "()Lcom/blueair/core/model/BluetoothDevice;", "isOnboarded", "", "()Z", "isOnline", "bluetoothAvailable", "getBluetoothAvailable", "wifiMac", "", "getWifiMac", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SearchedDevice {
   private final BluetoothDevice bluetoothDevice;
   private final Device device;

   public SearchedDevice() {
      this((Device)null, (BluetoothDevice)null, 3, (DefaultConstructorMarker)null);
   }

   public SearchedDevice(Device var1, BluetoothDevice var2) {
      this.device = var1;
      this.bluetoothDevice = var2;
   }

   // $FF: synthetic method
   public SearchedDevice(Device var1, BluetoothDevice var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 1) != 0) {
         var1 = null;
      }

      if ((var3 & 2) != 0) {
         var2 = null;
      }

      this(var1, var2);
   }

   // $FF: synthetic method
   public static SearchedDevice copy$default(SearchedDevice var0, Device var1, BluetoothDevice var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.device;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.bluetoothDevice;
      }

      return var0.copy(var1, var2);
   }

   public final Device component1() {
      return this.device;
   }

   public final BluetoothDevice component2() {
      return this.bluetoothDevice;
   }

   public final SearchedDevice copy(Device var1, BluetoothDevice var2) {
      return new SearchedDevice(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof SearchedDevice)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.device, var1.device)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.bluetoothDevice, var1.bluetoothDevice);
         }
      }
   }

   public final boolean getBluetoothAvailable() {
      return this.bluetoothDevice != null;
   }

   public final BluetoothDevice getBluetoothDevice() {
      return this.bluetoothDevice;
   }

   public final Device getDevice() {
      return this.device;
   }

   public final String getWifiMac() {
      Device var1 = this.device;
      if (var1 != null) {
         String var2 = var1.getMac();
         if (var2 != null) {
            return var2;
         }
      }

      BluetoothDevice var3 = this.bluetoothDevice;
      if (var3 != null) {
         String var4 = var3.getWifiMac();
         if (var4 != null) {
            var4 = var4.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(var4, "toLowerCase(...)");
            return var4;
         }
      }

      return "";
   }

   public int hashCode() {
      Device var3 = this.device;
      int var2 = 0;
      int var1;
      if (var3 == null) {
         var1 = 0;
      } else {
         var1 = var3.hashCode();
      }

      BluetoothDevice var4 = this.bluetoothDevice;
      if (var4 != null) {
         var2 = var4.hashCode();
      }

      return var1 * 31 + var2;
   }

   public final boolean isOnboarded() {
      return this.device != null;
   }

   public final boolean isOnline() {
      Device var1 = this.device;
      ConnectivityStatus var2;
      if (var1 != null) {
         var2 = var1.getConnectivityStatus();
      } else {
         var2 = null;
      }

      return var2 == ConnectivityStatus.ONLINE;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("SearchedDevice(device=");
      var1.append(this.device);
      var1.append(", bluetoothDevice=");
      var1.append(this.bluetoothDevice);
      var1.append(')');
      return var1.toString();
   }
}
