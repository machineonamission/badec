package com.blueair.api.restapi;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"},
   d2 = {"Lcom/blueair/api/restapi/SetTimezoneReq;", "", "deviceids", "", "", "timezone", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getDeviceids", "()Ljava/util/List;", "getTimezone", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SetTimezoneReq {
   private final List deviceids;
   private final String timezone;

   public SetTimezoneReq(List var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "deviceids");
      Intrinsics.checkNotNullParameter(var2, "timezone");
      super();
      this.deviceids = var1;
      this.timezone = var2;
   }

   // $FF: synthetic method
   public static SetTimezoneReq copy$default(SetTimezoneReq var0, List var1, String var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.deviceids;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.timezone;
      }

      return var0.copy(var1, var2);
   }

   public final List component1() {
      return this.deviceids;
   }

   public final String component2() {
      return this.timezone;
   }

   public final SetTimezoneReq copy(List var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "deviceids");
      Intrinsics.checkNotNullParameter(var2, "timezone");
      return new SetTimezoneReq(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof SetTimezoneReq)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.deviceids, var1.deviceids)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.timezone, var1.timezone);
         }
      }
   }

   public final List getDeviceids() {
      return this.deviceids;
   }

   public final String getTimezone() {
      return this.timezone;
   }

   public int hashCode() {
      return this.deviceids.hashCode() * 31 + this.timezone.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("SetTimezoneReq(deviceids=");
      var1.append(this.deviceids);
      var1.append(", timezone=");
      var1.append(this.timezone);
      var1.append(')');
      return var1.toString();
   }
}
