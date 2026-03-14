package com.blueair.bluetooth.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"},
   d2 = {"Lcom/blueair/bluetooth/service/ProvisionConfig;", "", "apiUrl", "", "authUrl", "brokerUrl", "region", "randomText", "secureRandom", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApiUrl", "()Ljava/lang/String;", "getAuthUrl", "getBrokerUrl", "getRegion", "getRandomText", "getSecureRandom", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "bluetooth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ProvisionConfig {
   private final String apiUrl;
   private final String authUrl;
   private final String brokerUrl;
   private final String randomText;
   private final String region;
   private final String secureRandom;

   public ProvisionConfig(String var1, String var2, String var3, String var4, String var5, String var6) {
      Intrinsics.checkNotNullParameter(var1, "apiUrl");
      Intrinsics.checkNotNullParameter(var2, "authUrl");
      Intrinsics.checkNotNullParameter(var3, "brokerUrl");
      Intrinsics.checkNotNullParameter(var4, "region");
      Intrinsics.checkNotNullParameter(var5, "randomText");
      Intrinsics.checkNotNullParameter(var6, "secureRandom");
      super();
      this.apiUrl = var1;
      this.authUrl = var2;
      this.brokerUrl = var3;
      this.region = var4;
      this.randomText = var5;
      this.secureRandom = var6;
   }

   // $FF: synthetic method
   public static ProvisionConfig copy$default(ProvisionConfig var0, String var1, String var2, String var3, String var4, String var5, String var6, int var7, Object var8) {
      if ((var7 & 1) != 0) {
         var1 = var0.apiUrl;
      }

      if ((var7 & 2) != 0) {
         var2 = var0.authUrl;
      }

      if ((var7 & 4) != 0) {
         var3 = var0.brokerUrl;
      }

      if ((var7 & 8) != 0) {
         var4 = var0.region;
      }

      if ((var7 & 16) != 0) {
         var5 = var0.randomText;
      }

      if ((var7 & 32) != 0) {
         var6 = var0.secureRandom;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6);
   }

   public final String component1() {
      return this.apiUrl;
   }

   public final String component2() {
      return this.authUrl;
   }

   public final String component3() {
      return this.brokerUrl;
   }

   public final String component4() {
      return this.region;
   }

   public final String component5() {
      return this.randomText;
   }

   public final String component6() {
      return this.secureRandom;
   }

   public final ProvisionConfig copy(String var1, String var2, String var3, String var4, String var5, String var6) {
      Intrinsics.checkNotNullParameter(var1, "apiUrl");
      Intrinsics.checkNotNullParameter(var2, "authUrl");
      Intrinsics.checkNotNullParameter(var3, "brokerUrl");
      Intrinsics.checkNotNullParameter(var4, "region");
      Intrinsics.checkNotNullParameter(var5, "randomText");
      Intrinsics.checkNotNullParameter(var6, "secureRandom");
      return new ProvisionConfig(var1, var2, var3, var4, var5, var6);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof ProvisionConfig)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.apiUrl, var1.apiUrl)) {
            return false;
         } else if (!Intrinsics.areEqual(this.authUrl, var1.authUrl)) {
            return false;
         } else if (!Intrinsics.areEqual(this.brokerUrl, var1.brokerUrl)) {
            return false;
         } else if (!Intrinsics.areEqual(this.region, var1.region)) {
            return false;
         } else if (!Intrinsics.areEqual(this.randomText, var1.randomText)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.secureRandom, var1.secureRandom);
         }
      }
   }

   public final String getApiUrl() {
      return this.apiUrl;
   }

   public final String getAuthUrl() {
      return this.authUrl;
   }

   public final String getBrokerUrl() {
      return this.brokerUrl;
   }

   public final String getRandomText() {
      return this.randomText;
   }

   public final String getRegion() {
      return this.region;
   }

   public final String getSecureRandom() {
      return this.secureRandom;
   }

   public int hashCode() {
      return ((((this.apiUrl.hashCode() * 31 + this.authUrl.hashCode()) * 31 + this.brokerUrl.hashCode()) * 31 + this.region.hashCode()) * 31 + this.randomText.hashCode()) * 31 + this.secureRandom.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("ProvisionConfig(apiUrl=");
      var1.append(this.apiUrl);
      var1.append(", authUrl=");
      var1.append(this.authUrl);
      var1.append(", brokerUrl=");
      var1.append(this.brokerUrl);
      var1.append(", region=");
      var1.append(this.region);
      var1.append(", randomText=");
      var1.append(this.randomText);
      var1.append(", secureRandom=");
      var1.append(this.secureRandom);
      var1.append(')');
      return var1.toString();
   }
}
