package com.blueair.api.restapi;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"},
   d2 = {"Lcom/blueair/api/restapi/SetupDeviceLocationReq;", "", "location_id", "", "device_ids", "", "reset_device_ids", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getLocation_id", "()Ljava/lang/String;", "getDevice_ids", "()Ljava/util/List;", "getReset_device_ids", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SetupDeviceLocationReq {
   private final List device_ids;
   private final String location_id;
   private final List reset_device_ids;

   public SetupDeviceLocationReq(String var1, List var2, List var3) {
      Intrinsics.checkNotNullParameter(var1, "location_id");
      Intrinsics.checkNotNullParameter(var2, "device_ids");
      Intrinsics.checkNotNullParameter(var3, "reset_device_ids");
      super();
      this.location_id = var1;
      this.device_ids = var2;
      this.reset_device_ids = var3;
   }

   // $FF: synthetic method
   public static SetupDeviceLocationReq copy$default(SetupDeviceLocationReq var0, String var1, List var2, List var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.location_id;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.device_ids;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.reset_device_ids;
      }

      return var0.copy(var1, var2, var3);
   }

   public final String component1() {
      return this.location_id;
   }

   public final List component2() {
      return this.device_ids;
   }

   public final List component3() {
      return this.reset_device_ids;
   }

   public final SetupDeviceLocationReq copy(String var1, List var2, List var3) {
      Intrinsics.checkNotNullParameter(var1, "location_id");
      Intrinsics.checkNotNullParameter(var2, "device_ids");
      Intrinsics.checkNotNullParameter(var3, "reset_device_ids");
      return new SetupDeviceLocationReq(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof SetupDeviceLocationReq)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.location_id, var1.location_id)) {
            return false;
         } else if (!Intrinsics.areEqual(this.device_ids, var1.device_ids)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.reset_device_ids, var1.reset_device_ids);
         }
      }
   }

   public final List getDevice_ids() {
      return this.device_ids;
   }

   public final String getLocation_id() {
      return this.location_id;
   }

   public final List getReset_device_ids() {
      return this.reset_device_ids;
   }

   public int hashCode() {
      return (this.location_id.hashCode() * 31 + this.device_ids.hashCode()) * 31 + this.reset_device_ids.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("SetupDeviceLocationReq(location_id=");
      var1.append(this.location_id);
      var1.append(", device_ids=");
      var1.append(this.device_ids);
      var1.append(", reset_device_ids=");
      var1.append(this.reset_device_ids);
      var1.append(')');
      return var1.toString();
   }
}
