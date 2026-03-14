package com.blueair.api.restapi;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"},
   d2 = {"Lcom/blueair/api/restapi/Configuration;", "", "id", "", "deviceInfo", "Lcom/blueair/api/restapi/ConfigurationDeviceInfo;", "da", "Lcom/blueair/api/restapi/Da;", "<init>", "(Ljava/lang/String;Lcom/blueair/api/restapi/ConfigurationDeviceInfo;Lcom/blueair/api/restapi/Da;)V", "getId", "()Ljava/lang/String;", "getDeviceInfo", "()Lcom/blueair/api/restapi/ConfigurationDeviceInfo;", "getDa", "()Lcom/blueair/api/restapi/Da;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class Configuration {
   private final Da da;
   private final ConfigurationDeviceInfo deviceInfo;
   private final String id;

   public Configuration(String var1, @Json(name = "di") ConfigurationDeviceInfo var2, Da var3) {
      this.id = var1;
      this.deviceInfo = var2;
      this.da = var3;
   }

   // $FF: synthetic method
   public static Configuration copy$default(Configuration var0, String var1, ConfigurationDeviceInfo var2, Da var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.deviceInfo;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.da;
      }

      return var0.copy(var1, var2, var3);
   }

   public final String component1() {
      return this.id;
   }

   public final ConfigurationDeviceInfo component2() {
      return this.deviceInfo;
   }

   public final Da component3() {
      return this.da;
   }

   public final Configuration copy(String var1, @Json(name = "di") ConfigurationDeviceInfo var2, Da var3) {
      return new Configuration(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof Configuration)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.id, var1.id)) {
            return false;
         } else if (!Intrinsics.areEqual(this.deviceInfo, var1.deviceInfo)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.da, var1.da);
         }
      }
   }

   public final Da getDa() {
      return this.da;
   }

   public final ConfigurationDeviceInfo getDeviceInfo() {
      return this.deviceInfo;
   }

   public final String getId() {
      return this.id;
   }

   public int hashCode() {
      String var4 = this.id;
      int var3 = 0;
      int var1;
      if (var4 == null) {
         var1 = 0;
      } else {
         var1 = var4.hashCode();
      }

      ConfigurationDeviceInfo var5 = this.deviceInfo;
      int var2;
      if (var5 == null) {
         var2 = 0;
      } else {
         var2 = var5.hashCode();
      }

      Da var6 = this.da;
      if (var6 != null) {
         var3 = var6.hashCode();
      }

      return (var1 * 31 + var2) * 31 + var3;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("Configuration(id=");
      var1.append(this.id);
      var1.append(", deviceInfo=");
      var1.append(this.deviceInfo);
      var1.append(", da=");
      var1.append(this.da);
      var1.append(')');
      return var1.toString();
   }
}
