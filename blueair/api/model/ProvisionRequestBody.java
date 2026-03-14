package com.blueair.api.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003Jc\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006("},
   d2 = {"Lcom/blueair/api/model/ProvisionRequestBody;", "", "ssid", "", "bssid", "password", "api", "auth", "broker", "region", "text", "rand", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSsid", "()Ljava/lang/String;", "getBssid", "getPassword", "getApi", "getAuth", "getBroker", "getRegion", "getText", "getRand", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ProvisionRequestBody {
   private final String api;
   private final String auth;
   private final String broker;
   private final String bssid;
   private final String password;
   private final String rand;
   private final String region;
   private final String ssid;
   private final String text;

   public ProvisionRequestBody(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9) {
      Intrinsics.checkNotNullParameter(var1, "ssid");
      Intrinsics.checkNotNullParameter(var2, "bssid");
      Intrinsics.checkNotNullParameter(var3, "password");
      Intrinsics.checkNotNullParameter(var4, "api");
      Intrinsics.checkNotNullParameter(var5, "auth");
      Intrinsics.checkNotNullParameter(var6, "broker");
      Intrinsics.checkNotNullParameter(var7, "region");
      Intrinsics.checkNotNullParameter(var8, "text");
      Intrinsics.checkNotNullParameter(var9, "rand");
      super();
      this.ssid = var1;
      this.bssid = var2;
      this.password = var3;
      this.api = var4;
      this.auth = var5;
      this.broker = var6;
      this.region = var7;
      this.text = var8;
      this.rand = var9;
   }

   // $FF: synthetic method
   public ProvisionRequestBody(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, int var10, DefaultConstructorMarker var11) {
      if ((var10 & 8) != 0) {
         var4 = "https://de-fr.api.blueair.io";
      }

      if ((var10 & 32) != 0) {
         var6 = "https://de-fr.broker.blueair.io";
      }

      if ((var10 & 64) != 0) {
         var7 = "EU-SE";
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   // $FF: synthetic method
   public static ProvisionRequestBody copy$default(ProvisionRequestBody var0, String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, int var10, Object var11) {
      if ((var10 & 1) != 0) {
         var1 = var0.ssid;
      }

      if ((var10 & 2) != 0) {
         var2 = var0.bssid;
      }

      if ((var10 & 4) != 0) {
         var3 = var0.password;
      }

      if ((var10 & 8) != 0) {
         var4 = var0.api;
      }

      if ((var10 & 16) != 0) {
         var5 = var0.auth;
      }

      if ((var10 & 32) != 0) {
         var6 = var0.broker;
      }

      if ((var10 & 64) != 0) {
         var7 = var0.region;
      }

      if ((var10 & 128) != 0) {
         var8 = var0.text;
      }

      if ((var10 & 256) != 0) {
         var9 = var0.rand;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public final String component1() {
      return this.ssid;
   }

   public final String component2() {
      return this.bssid;
   }

   public final String component3() {
      return this.password;
   }

   public final String component4() {
      return this.api;
   }

   public final String component5() {
      return this.auth;
   }

   public final String component6() {
      return this.broker;
   }

   public final String component7() {
      return this.region;
   }

   public final String component8() {
      return this.text;
   }

   public final String component9() {
      return this.rand;
   }

   public final ProvisionRequestBody copy(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9) {
      Intrinsics.checkNotNullParameter(var1, "ssid");
      Intrinsics.checkNotNullParameter(var2, "bssid");
      Intrinsics.checkNotNullParameter(var3, "password");
      Intrinsics.checkNotNullParameter(var4, "api");
      Intrinsics.checkNotNullParameter(var5, "auth");
      Intrinsics.checkNotNullParameter(var6, "broker");
      Intrinsics.checkNotNullParameter(var7, "region");
      Intrinsics.checkNotNullParameter(var8, "text");
      Intrinsics.checkNotNullParameter(var9, "rand");
      return new ProvisionRequestBody(var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof ProvisionRequestBody)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.ssid, var1.ssid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.bssid, var1.bssid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.password, var1.password)) {
            return false;
         } else if (!Intrinsics.areEqual(this.api, var1.api)) {
            return false;
         } else if (!Intrinsics.areEqual(this.auth, var1.auth)) {
            return false;
         } else if (!Intrinsics.areEqual(this.broker, var1.broker)) {
            return false;
         } else if (!Intrinsics.areEqual(this.region, var1.region)) {
            return false;
         } else if (!Intrinsics.areEqual(this.text, var1.text)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.rand, var1.rand);
         }
      }
   }

   public final String getApi() {
      return this.api;
   }

   public final String getAuth() {
      return this.auth;
   }

   public final String getBroker() {
      return this.broker;
   }

   public final String getBssid() {
      return this.bssid;
   }

   public final String getPassword() {
      return this.password;
   }

   public final String getRand() {
      return this.rand;
   }

   public final String getRegion() {
      return this.region;
   }

   public final String getSsid() {
      return this.ssid;
   }

   public final String getText() {
      return this.text;
   }

   public int hashCode() {
      return (((((((this.ssid.hashCode() * 31 + this.bssid.hashCode()) * 31 + this.password.hashCode()) * 31 + this.api.hashCode()) * 31 + this.auth.hashCode()) * 31 + this.broker.hashCode()) * 31 + this.region.hashCode()) * 31 + this.text.hashCode()) * 31 + this.rand.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("ProvisionRequestBody(ssid=");
      var1.append(this.ssid);
      var1.append(", bssid=");
      var1.append(this.bssid);
      var1.append(", password=");
      var1.append(this.password);
      var1.append(", api=");
      var1.append(this.api);
      var1.append(", auth=");
      var1.append(this.auth);
      var1.append(", broker=");
      var1.append(this.broker);
      var1.append(", region=");
      var1.append(this.region);
      var1.append(", text=");
      var1.append(this.text);
      var1.append(", rand=");
      var1.append(this.rand);
      var1.append(')');
      return var1.toString();
   }
}
