package com.blueair.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J>\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006 "},
   d2 = {"Lcom/blueair/auth/GigyaAccountData;", "", "address", "Lcom/blueair/auth/GigyaAccountAddress;", "accountstatus", "", "appRegion", "china_privacy_version", "", "<init>", "(Lcom/blueair/auth/GigyaAccountAddress;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAddress", "()Lcom/blueair/auth/GigyaAccountAddress;", "getAccountstatus", "()Ljava/lang/String;", "getAppRegion", "getChina_privacy_version", "()Ljava/lang/Integer;", "setChina_privacy_version", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Lcom/blueair/auth/GigyaAccountAddress;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/blueair/auth/GigyaAccountData;", "equals", "", "other", "hashCode", "toString", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GigyaAccountData {
   private final String accountstatus;
   private final GigyaAccountAddress address;
   private final String appRegion;
   private Integer china_privacy_version;

   public GigyaAccountData(GigyaAccountAddress var1, String var2, String var3, Integer var4) {
      this.address = var1;
      this.accountstatus = var2;
      this.appRegion = var3;
      this.china_privacy_version = var4;
   }

   // $FF: synthetic method
   public static GigyaAccountData copy$default(GigyaAccountData var0, GigyaAccountAddress var1, String var2, String var3, Integer var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.address;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.accountstatus;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.appRegion;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.china_privacy_version;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   public final GigyaAccountAddress component1() {
      return this.address;
   }

   public final String component2() {
      return this.accountstatus;
   }

   public final String component3() {
      return this.appRegion;
   }

   public final Integer component4() {
      return this.china_privacy_version;
   }

   public final GigyaAccountData copy(GigyaAccountAddress var1, String var2, String var3, Integer var4) {
      return new GigyaAccountData(var1, var2, var3, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof GigyaAccountData)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.address, var1.address)) {
            return false;
         } else if (!Intrinsics.areEqual(this.accountstatus, var1.accountstatus)) {
            return false;
         } else if (!Intrinsics.areEqual(this.appRegion, var1.appRegion)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.china_privacy_version, var1.china_privacy_version);
         }
      }
   }

   public final String getAccountstatus() {
      return this.accountstatus;
   }

   public final GigyaAccountAddress getAddress() {
      return this.address;
   }

   public final String getAppRegion() {
      return this.appRegion;
   }

   public final Integer getChina_privacy_version() {
      return this.china_privacy_version;
   }

   public int hashCode() {
      GigyaAccountAddress var5 = this.address;
      int var4 = 0;
      int var1;
      if (var5 == null) {
         var1 = 0;
      } else {
         var1 = var5.hashCode();
      }

      String var6 = this.accountstatus;
      int var2;
      if (var6 == null) {
         var2 = 0;
      } else {
         var2 = var6.hashCode();
      }

      var6 = this.appRegion;
      int var3;
      if (var6 == null) {
         var3 = 0;
      } else {
         var3 = var6.hashCode();
      }

      Integer var8 = this.china_privacy_version;
      if (var8 != null) {
         var4 = var8.hashCode();
      }

      return ((var1 * 31 + var2) * 31 + var3) * 31 + var4;
   }

   public final void setChina_privacy_version(Integer var1) {
      this.china_privacy_version = var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("GigyaAccountData(address=");
      var1.append(this.address);
      var1.append(", accountstatus=");
      var1.append(this.accountstatus);
      var1.append(", appRegion=");
      var1.append(this.appRegion);
      var1.append(", china_privacy_version=");
      var1.append(this.china_privacy_version);
      var1.append(')');
      return var1.toString();
   }
}
