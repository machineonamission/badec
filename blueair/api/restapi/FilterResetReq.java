package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"},
   d2 = {"Lcom/blueair/api/restapi/FilterResetReq;", "", "deviceid", "", "ctype", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDeviceid", "()Ljava/lang/String;", "getCtype", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class FilterResetReq {
   private final String ctype;
   private final String deviceid;

   public FilterResetReq(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "deviceid");
      Intrinsics.checkNotNullParameter(var2, "ctype");
      super();
      this.deviceid = var1;
      this.ctype = var2;
   }

   // $FF: synthetic method
   public static FilterResetReq copy$default(FilterResetReq var0, String var1, String var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.deviceid;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.ctype;
      }

      return var0.copy(var1, var2);
   }

   public final String component1() {
      return this.deviceid;
   }

   public final String component2() {
      return this.ctype;
   }

   public final FilterResetReq copy(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "deviceid");
      Intrinsics.checkNotNullParameter(var2, "ctype");
      return new FilterResetReq(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof FilterResetReq)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.deviceid, var1.deviceid)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.ctype, var1.ctype);
         }
      }
   }

   public final String getCtype() {
      return this.ctype;
   }

   public final String getDeviceid() {
      return this.deviceid;
   }

   public int hashCode() {
      return this.deviceid.hashCode() * 31 + this.ctype.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("FilterResetReq(deviceid=");
      var1.append(this.deviceid);
      var1.append(", ctype=");
      var1.append(this.ctype);
      var1.append(')');
      return var1.toString();
   }
}
