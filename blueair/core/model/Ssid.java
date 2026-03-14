package com.blueair.core.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Json(
   name = "network"
)
@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"},
   d2 = {"Lcom/blueair/core/model/Ssid;", "", "ssid", "", "bssid", "rssi", "", "auth", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getSsid", "()Ljava/lang/String;", "getBssid", "getRssi", "()I", "getAuth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class Ssid {
   private final String auth;
   private final String bssid;
   private final int rssi;
   private final String ssid;

   public Ssid(String var1, String var2, int var3, String var4) {
      this.ssid = var1;
      this.bssid = var2;
      this.rssi = var3;
      this.auth = var4;
   }

   // $FF: synthetic method
   public static Ssid copy$default(Ssid var0, String var1, String var2, int var3, String var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.ssid;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.bssid;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.rssi;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.auth;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   public final String component1() {
      return this.ssid;
   }

   public final String component2() {
      return this.bssid;
   }

   public final int component3() {
      return this.rssi;
   }

   public final String component4() {
      return this.auth;
   }

   public final Ssid copy(String var1, String var2, int var3, String var4) {
      return new Ssid(var1, var2, var3, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof Ssid)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.ssid, var1.ssid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.bssid, var1.bssid)) {
            return false;
         } else if (this.rssi != var1.rssi) {
            return false;
         } else {
            return Intrinsics.areEqual(this.auth, var1.auth);
         }
      }
   }

   public final String getAuth() {
      return this.auth;
   }

   public final String getBssid() {
      return this.bssid;
   }

   public final int getRssi() {
      return this.rssi;
   }

   public final String getSsid() {
      return this.ssid;
   }

   public int hashCode() {
      String var5 = this.ssid;
      int var3 = 0;
      int var1;
      if (var5 == null) {
         var1 = 0;
      } else {
         var1 = var5.hashCode();
      }

      var5 = this.bssid;
      int var2;
      if (var5 == null) {
         var2 = 0;
      } else {
         var2 = var5.hashCode();
      }

      int var4 = this.rssi;
      var5 = this.auth;
      if (var5 != null) {
         var3 = var5.hashCode();
      }

      return ((var1 * 31 + var2) * 31 + var4) * 31 + var3;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("Ssid(ssid=");
      var1.append(this.ssid);
      var1.append(", bssid=");
      var1.append(this.bssid);
      var1.append(", rssi=");
      var1.append(this.rssi);
      var1.append(", auth=");
      var1.append(this.auth);
      var1.append(')');
      return var1.toString();
   }
}
