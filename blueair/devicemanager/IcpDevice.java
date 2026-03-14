package com.blueair.devicemanager;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"},
   d2 = {"Lcom/blueair/devicemanager/IcpDevice;", "", "macAddress", "", "name", "uuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMacAddress", "()Ljava/lang/String;", "getName", "getUuid", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "devicemanager_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class IcpDevice {
   private final String macAddress;
   private final String name;
   private final String uuid;

   public IcpDevice(String var1, String var2, String var3) {
      Intrinsics.checkNotNullParameter(var1, "macAddress");
      super();
      this.macAddress = var1;
      this.name = var2;
      this.uuid = var3;
   }

   // $FF: synthetic method
   public static IcpDevice copy$default(IcpDevice var0, String var1, String var2, String var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.macAddress;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.name;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.uuid;
      }

      return var0.copy(var1, var2, var3);
   }

   public final String component1() {
      return this.macAddress;
   }

   public final String component2() {
      return this.name;
   }

   public final String component3() {
      return this.uuid;
   }

   public final IcpDevice copy(String var1, String var2, String var3) {
      Intrinsics.checkNotNullParameter(var1, "macAddress");
      return new IcpDevice(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof IcpDevice)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.macAddress, var1.macAddress)) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.uuid, var1.uuid);
         }
      }
   }

   public final String getMacAddress() {
      return this.macAddress;
   }

   public final String getName() {
      return this.name;
   }

   public final String getUuid() {
      return this.uuid;
   }

   public int hashCode() {
      int var3 = this.macAddress.hashCode();
      String var4 = this.name;
      int var2 = 0;
      int var1;
      if (var4 == null) {
         var1 = 0;
      } else {
         var1 = var4.hashCode();
      }

      var4 = this.uuid;
      if (var4 != null) {
         var2 = var4.hashCode();
      }

      return (var3 * 31 + var1) * 31 + var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("IcpDevice(macAddress=");
      var1.append(this.macAddress);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", uuid=");
      var1.append(this.uuid);
      var1.append(')');
      return var1.toString();
   }
}
