package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011JF\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"},
   d2 = {"Lcom/blueair/api/restapi/AntiFakeResetReq;", "", "antifakecode", "", "devicesku", "deviceid", "mac", "usage", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAntifakecode", "()Ljava/lang/String;", "getDevicesku", "getDeviceid", "getMac", "getUsage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/blueair/api/restapi/AntiFakeResetReq;", "equals", "", "other", "hashCode", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AntiFakeResetReq {
   private final String antifakecode;
   private final String deviceid;
   private final String devicesku;
   private final String mac;
   private final Integer usage;

   public AntiFakeResetReq(String var1, String var2, String var3, String var4, Integer var5) {
      Intrinsics.checkNotNullParameter(var1, "antifakecode");
      Intrinsics.checkNotNullParameter(var2, "devicesku");
      super();
      this.antifakecode = var1;
      this.devicesku = var2;
      this.deviceid = var3;
      this.mac = var4;
      this.usage = var5;
   }

   // $FF: synthetic method
   public AntiFakeResetReq(String var1, String var2, String var3, String var4, Integer var5, int var6, DefaultConstructorMarker var7) {
      if ((var6 & 4) != 0) {
         var3 = null;
      }

      if ((var6 & 8) != 0) {
         var4 = null;
      }

      if ((var6 & 16) != 0) {
         var5 = null;
      }

      this(var1, var2, var3, var4, var5);
   }

   // $FF: synthetic method
   public static AntiFakeResetReq copy$default(AntiFakeResetReq var0, String var1, String var2, String var3, String var4, Integer var5, int var6, Object var7) {
      if ((var6 & 1) != 0) {
         var1 = var0.antifakecode;
      }

      if ((var6 & 2) != 0) {
         var2 = var0.devicesku;
      }

      if ((var6 & 4) != 0) {
         var3 = var0.deviceid;
      }

      if ((var6 & 8) != 0) {
         var4 = var0.mac;
      }

      if ((var6 & 16) != 0) {
         var5 = var0.usage;
      }

      return var0.copy(var1, var2, var3, var4, var5);
   }

   public final String component1() {
      return this.antifakecode;
   }

   public final String component2() {
      return this.devicesku;
   }

   public final String component3() {
      return this.deviceid;
   }

   public final String component4() {
      return this.mac;
   }

   public final Integer component5() {
      return this.usage;
   }

   public final AntiFakeResetReq copy(String var1, String var2, String var3, String var4, Integer var5) {
      Intrinsics.checkNotNullParameter(var1, "antifakecode");
      Intrinsics.checkNotNullParameter(var2, "devicesku");
      return new AntiFakeResetReq(var1, var2, var3, var4, var5);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof AntiFakeResetReq)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.antifakecode, var1.antifakecode)) {
            return false;
         } else if (!Intrinsics.areEqual(this.devicesku, var1.devicesku)) {
            return false;
         } else if (!Intrinsics.areEqual(this.deviceid, var1.deviceid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.mac, var1.mac)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.usage, var1.usage);
         }
      }
   }

   public final String getAntifakecode() {
      return this.antifakecode;
   }

   public final String getDeviceid() {
      return this.deviceid;
   }

   public final String getDevicesku() {
      return this.devicesku;
   }

   public final String getMac() {
      return this.mac;
   }

   public final Integer getUsage() {
      return this.usage;
   }

   public int hashCode() {
      int var4 = this.antifakecode.hashCode();
      int var5 = this.devicesku.hashCode();
      String var6 = this.deviceid;
      int var3 = 0;
      int var1;
      if (var6 == null) {
         var1 = 0;
      } else {
         var1 = var6.hashCode();
      }

      var6 = this.mac;
      int var2;
      if (var6 == null) {
         var2 = 0;
      } else {
         var2 = var6.hashCode();
      }

      Integer var8 = this.usage;
      if (var8 != null) {
         var3 = var8.hashCode();
      }

      return (((var4 * 31 + var5) * 31 + var1) * 31 + var2) * 31 + var3;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("AntiFakeResetReq(antifakecode=");
      var1.append(this.antifakecode);
      var1.append(", devicesku=");
      var1.append(this.devicesku);
      var1.append(", deviceid=");
      var1.append(this.deviceid);
      var1.append(", mac=");
      var1.append(this.mac);
      var1.append(", usage=");
      var1.append(this.usage);
      var1.append(')');
      return var1.toString();
   }
}
