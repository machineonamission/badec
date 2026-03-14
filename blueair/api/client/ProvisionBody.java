package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"},
   d2 = {"Lcom/blueair/api/client/ProvisionBody;", "", "ssid", "", "bssid", "password", "rand", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSsid", "()Ljava/lang/String;", "getBssid", "getPassword", "getRand", "getText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ProvisionBody {
   private final String bssid;
   private final String password;
   private final String rand;
   private final String ssid;
   private final String text;

   public ProvisionBody(String var1, String var2, String var3, String var4, String var5) {
      Intrinsics.checkNotNullParameter(var1, "ssid");
      Intrinsics.checkNotNullParameter(var2, "bssid");
      Intrinsics.checkNotNullParameter(var3, "password");
      Intrinsics.checkNotNullParameter(var4, "rand");
      Intrinsics.checkNotNullParameter(var5, "text");
      super();
      this.ssid = var1;
      this.bssid = var2;
      this.password = var3;
      this.rand = var4;
      this.text = var5;
   }

   // $FF: synthetic method
   public static ProvisionBody copy$default(ProvisionBody var0, String var1, String var2, String var3, String var4, String var5, int var6, Object var7) {
      if ((var6 & 1) != 0) {
         var1 = var0.ssid;
      }

      if ((var6 & 2) != 0) {
         var2 = var0.bssid;
      }

      if ((var6 & 4) != 0) {
         var3 = var0.password;
      }

      if ((var6 & 8) != 0) {
         var4 = var0.rand;
      }

      if ((var6 & 16) != 0) {
         var5 = var0.text;
      }

      return var0.copy(var1, var2, var3, var4, var5);
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
      return this.rand;
   }

   public final String component5() {
      return this.text;
   }

   public final ProvisionBody copy(String var1, String var2, String var3, String var4, String var5) {
      Intrinsics.checkNotNullParameter(var1, "ssid");
      Intrinsics.checkNotNullParameter(var2, "bssid");
      Intrinsics.checkNotNullParameter(var3, "password");
      Intrinsics.checkNotNullParameter(var4, "rand");
      Intrinsics.checkNotNullParameter(var5, "text");
      return new ProvisionBody(var1, var2, var3, var4, var5);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof ProvisionBody)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.ssid, var1.ssid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.bssid, var1.bssid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.password, var1.password)) {
            return false;
         } else if (!Intrinsics.areEqual(this.rand, var1.rand)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.text, var1.text);
         }
      }
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

   public final String getSsid() {
      return this.ssid;
   }

   public final String getText() {
      return this.text;
   }

   public int hashCode() {
      return (((this.ssid.hashCode() * 31 + this.bssid.hashCode()) * 31 + this.password.hashCode()) * 31 + this.rand.hashCode()) * 31 + this.text.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("ProvisionBody(ssid=");
      var1.append(this.ssid);
      var1.append(", bssid=");
      var1.append(this.bssid);
      var1.append(", password=");
      var1.append(this.password);
      var1.append(", rand=");
      var1.append(this.rand);
      var1.append(", text=");
      var1.append(this.text);
      var1.append(')');
      return var1.toString();
   }
}
