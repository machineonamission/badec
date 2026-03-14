package com.blueair.sdk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"},
   d2 = {"Lcom/blueair/sdk/KlaviyoProfileLocationData;", "", "email", "", "countryCode", "state", "city", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getCountryCode", "getState", "getCity", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class KlaviyoProfileLocationData {
   private final String city;
   private final String countryCode;
   private final String email;
   private final String state;

   public KlaviyoProfileLocationData(String var1, String var2, String var3, String var4) {
      Intrinsics.checkNotNullParameter(var1, "email");
      super();
      this.email = var1;
      this.countryCode = var2;
      this.state = var3;
      this.city = var4;
   }

   // $FF: synthetic method
   public static KlaviyoProfileLocationData copy$default(KlaviyoProfileLocationData var0, String var1, String var2, String var3, String var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.email;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.countryCode;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.state;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.city;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   public final String component1() {
      return this.email;
   }

   public final String component2() {
      return this.countryCode;
   }

   public final String component3() {
      return this.state;
   }

   public final String component4() {
      return this.city;
   }

   public final KlaviyoProfileLocationData copy(String var1, String var2, String var3, String var4) {
      Intrinsics.checkNotNullParameter(var1, "email");
      return new KlaviyoProfileLocationData(var1, var2, var3, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof KlaviyoProfileLocationData)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.email, var1.email)) {
            return false;
         } else if (!Intrinsics.areEqual(this.countryCode, var1.countryCode)) {
            return false;
         } else if (!Intrinsics.areEqual(this.state, var1.state)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.city, var1.city);
         }
      }
   }

   public final String getCity() {
      return this.city;
   }

   public final String getCountryCode() {
      return this.countryCode;
   }

   public final String getEmail() {
      return this.email;
   }

   public final String getState() {
      return this.state;
   }

   public int hashCode() {
      int var4 = this.email.hashCode();
      String var5 = this.countryCode;
      int var3 = 0;
      int var1;
      if (var5 == null) {
         var1 = 0;
      } else {
         var1 = var5.hashCode();
      }

      var5 = this.state;
      int var2;
      if (var5 == null) {
         var2 = 0;
      } else {
         var2 = var5.hashCode();
      }

      var5 = this.city;
      if (var5 != null) {
         var3 = var5.hashCode();
      }

      return ((var4 * 31 + var1) * 31 + var2) * 31 + var3;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("KlaviyoProfileLocationData(email=");
      var1.append(this.email);
      var1.append(", countryCode=");
      var1.append(this.countryCode);
      var1.append(", state=");
      var1.append(this.state);
      var1.append(", city=");
      var1.append(this.city);
      var1.append(')');
      return var1.toString();
   }
}
