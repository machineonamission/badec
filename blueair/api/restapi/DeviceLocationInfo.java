package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"},
   d2 = {"Lcom/blueair/api/restapi/DeviceLocationInfo;", "", "device_id", "", "location_id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDevice_id", "()Ljava/lang/String;", "getLocation_id", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceLocationInfo {
   private final String device_id;
   private final String location_id;

   public DeviceLocationInfo(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "device_id");
      super();
      this.device_id = var1;
      this.location_id = var2;
   }

   // $FF: synthetic method
   public static DeviceLocationInfo copy$default(DeviceLocationInfo var0, String var1, String var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.device_id;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.location_id;
      }

      return var0.copy(var1, var2);
   }

   public final String component1() {
      return this.device_id;
   }

   public final String component2() {
      return this.location_id;
   }

   public final DeviceLocationInfo copy(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "device_id");
      return new DeviceLocationInfo(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceLocationInfo)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.device_id, var1.device_id)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.location_id, var1.location_id);
         }
      }
   }

   public final String getDevice_id() {
      return this.device_id;
   }

   public final String getLocation_id() {
      return this.location_id;
   }

   public int hashCode() {
      int var2 = this.device_id.hashCode();
      String var3 = this.location_id;
      int var1;
      if (var3 == null) {
         var1 = 0;
      } else {
         var1 = var3.hashCode();
      }

      return var2 * 31 + var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceLocationInfo(device_id=");
      var1.append(this.device_id);
      var1.append(", location_id=");
      var1.append(this.location_id);
      var1.append(')');
      return var1.toString();
   }
}
