package com.blueair.bluetooth.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"},
   d2 = {"Lcom/blueair/bluetooth/service/BleDeviceError;", "", "stateOccurred", "Lcom/blueair/bluetooth/service/BleDeviceState;", "message", "", "<init>", "(Lcom/blueair/bluetooth/service/BleDeviceState;Ljava/lang/String;)V", "getStateOccurred", "()Lcom/blueair/bluetooth/service/BleDeviceState;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bluetooth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BleDeviceError {
   private final String message;
   private final BleDeviceState stateOccurred;

   public BleDeviceError(BleDeviceState var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "stateOccurred");
      super();
      this.stateOccurred = var1;
      this.message = var2;
   }

   // $FF: synthetic method
   public static BleDeviceError copy$default(BleDeviceError var0, BleDeviceState var1, String var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.stateOccurred;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.message;
      }

      return var0.copy(var1, var2);
   }

   public final BleDeviceState component1() {
      return this.stateOccurred;
   }

   public final String component2() {
      return this.message;
   }

   public final BleDeviceError copy(BleDeviceState var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "stateOccurred");
      return new BleDeviceError(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof BleDeviceError)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.stateOccurred, var1.stateOccurred)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.message, var1.message);
         }
      }
   }

   public final String getMessage() {
      return this.message;
   }

   public final BleDeviceState getStateOccurred() {
      return this.stateOccurred;
   }

   public int hashCode() {
      int var2 = this.stateOccurred.hashCode();
      String var3 = this.message;
      int var1;
      if (var3 == null) {
         var1 = 0;
      } else {
         var1 = var3.hashCode();
      }

      return var2 * 31 + var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("BleDeviceError(stateOccurred=");
      var1.append(this.stateOccurred);
      var1.append(", message=");
      var1.append(this.message);
      var1.append(')');
      return var1.toString();
   }
}
