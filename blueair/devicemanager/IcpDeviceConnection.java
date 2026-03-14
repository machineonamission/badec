package com.blueair.devicemanager;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"},
   d2 = {"Lcom/blueair/devicemanager/IcpDeviceConnection;", "", "connectionState", "Lcom/blueair/devicemanager/IcpDeviceManager$IcpDeviceConnectionState;", "device", "Lcom/blueair/devicemanager/IcpDevice;", "<init>", "(Lcom/blueair/devicemanager/IcpDeviceManager$IcpDeviceConnectionState;Lcom/blueair/devicemanager/IcpDevice;)V", "getConnectionState", "()Lcom/blueair/devicemanager/IcpDeviceManager$IcpDeviceConnectionState;", "getDevice", "()Lcom/blueair/devicemanager/IcpDevice;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "devicemanager_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class IcpDeviceConnection {
   private final IcpDeviceManager.IcpDeviceConnectionState connectionState;
   private final IcpDevice device;

   public IcpDeviceConnection(IcpDeviceManager.IcpDeviceConnectionState var1, IcpDevice var2) {
      Intrinsics.checkNotNullParameter(var1, "connectionState");
      super();
      this.connectionState = var1;
      this.device = var2;
   }

   // $FF: synthetic method
   public static IcpDeviceConnection copy$default(IcpDeviceConnection var0, IcpDeviceManager.IcpDeviceConnectionState var1, IcpDevice var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.connectionState;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.device;
      }

      return var0.copy(var1, var2);
   }

   public final IcpDeviceManager.IcpDeviceConnectionState component1() {
      return this.connectionState;
   }

   public final IcpDevice component2() {
      return this.device;
   }

   public final IcpDeviceConnection copy(IcpDeviceManager.IcpDeviceConnectionState var1, IcpDevice var2) {
      Intrinsics.checkNotNullParameter(var1, "connectionState");
      return new IcpDeviceConnection(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof IcpDeviceConnection)) {
         return false;
      } else {
         var1 = var1;
         if (this.connectionState != var1.connectionState) {
            return false;
         } else {
            return Intrinsics.areEqual(this.device, var1.device);
         }
      }
   }

   public final IcpDeviceManager.IcpDeviceConnectionState getConnectionState() {
      return this.connectionState;
   }

   public final IcpDevice getDevice() {
      return this.device;
   }

   public int hashCode() {
      int var2 = this.connectionState.hashCode();
      IcpDevice var3 = this.device;
      int var1;
      if (var3 == null) {
         var1 = 0;
      } else {
         var1 = var3.hashCode();
      }

      return var2 * 31 + var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("IcpDeviceConnection(connectionState=");
      var1.append(this.connectionState);
      var1.append(", device=");
      var1.append(this.device);
      var1.append(')');
      return var1.toString();
   }
}
