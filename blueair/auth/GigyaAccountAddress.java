package com.blueair.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006\""},
   d2 = {"Lcom/blueair/auth/GigyaAccountAddress;", "", "stateCode", "", "addressLine1", "city", "country", "postCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getStateCode", "()Ljava/lang/String;", "setStateCode", "(Ljava/lang/String;)V", "getAddressLine1", "setAddressLine1", "getCity", "setCity", "getCountry", "setCountry", "getPostCode", "setPostCode", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GigyaAccountAddress {
   private String addressLine1;
   private String city;
   private String country;
   private String postCode;
   private String stateCode;

   public GigyaAccountAddress() {
      this((String)null, (String)null, (String)null, (String)null, (String)null, 31, (DefaultConstructorMarker)null);
   }

   public GigyaAccountAddress(String var1, String var2, String var3, String var4, String var5) {
      this.stateCode = var1;
      this.addressLine1 = var2;
      this.city = var3;
      this.country = var4;
      this.postCode = var5;
   }

   // $FF: synthetic method
   public GigyaAccountAddress(String var1, String var2, String var3, String var4, String var5, int var6, DefaultConstructorMarker var7) {
      if ((var6 & 1) != 0) {
         var1 = null;
      }

      if ((var6 & 2) != 0) {
         var2 = null;
      }

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
   public static GigyaAccountAddress copy$default(GigyaAccountAddress var0, String var1, String var2, String var3, String var4, String var5, int var6, Object var7) {
      if ((var6 & 1) != 0) {
         var1 = var0.stateCode;
      }

      if ((var6 & 2) != 0) {
         var2 = var0.addressLine1;
      }

      if ((var6 & 4) != 0) {
         var3 = var0.city;
      }

      if ((var6 & 8) != 0) {
         var4 = var0.country;
      }

      if ((var6 & 16) != 0) {
         var5 = var0.postCode;
      }

      return var0.copy(var1, var2, var3, var4, var5);
   }

   public final String component1() {
      return this.stateCode;
   }

   public final String component2() {
      return this.addressLine1;
   }

   public final String component3() {
      return this.city;
   }

   public final String component4() {
      return this.country;
   }

   public final String component5() {
      return this.postCode;
   }

   public final GigyaAccountAddress copy(String var1, String var2, String var3, String var4, String var5) {
      return new GigyaAccountAddress(var1, var2, var3, var4, var5);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof GigyaAccountAddress)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.stateCode, var1.stateCode)) {
            return false;
         } else if (!Intrinsics.areEqual(this.addressLine1, var1.addressLine1)) {
            return false;
         } else if (!Intrinsics.areEqual(this.city, var1.city)) {
            return false;
         } else if (!Intrinsics.areEqual(this.country, var1.country)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.postCode, var1.postCode);
         }
      }
   }

   public final String getAddressLine1() {
      return this.addressLine1;
   }

   public final String getCity() {
      return this.city;
   }

   public final String getCountry() {
      return this.country;
   }

   public final String getPostCode() {
      return this.postCode;
   }

   public final String getStateCode() {
      return this.stateCode;
   }

   public int hashCode() {
      String var6 = this.stateCode;
      int var5 = 0;
      int var1;
      if (var6 == null) {
         var1 = 0;
      } else {
         var1 = var6.hashCode();
      }

      var6 = this.addressLine1;
      int var2;
      if (var6 == null) {
         var2 = 0;
      } else {
         var2 = var6.hashCode();
      }

      var6 = this.city;
      int var3;
      if (var6 == null) {
         var3 = 0;
      } else {
         var3 = var6.hashCode();
      }

      var6 = this.country;
      int var4;
      if (var6 == null) {
         var4 = 0;
      } else {
         var4 = var6.hashCode();
      }

      var6 = this.postCode;
      if (var6 != null) {
         var5 = var6.hashCode();
      }

      return (((var1 * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5;
   }

   public final void setAddressLine1(String var1) {
      this.addressLine1 = var1;
   }

   public final void setCity(String var1) {
      this.city = var1;
   }

   public final void setCountry(String var1) {
      this.country = var1;
   }

   public final void setPostCode(String var1) {
      this.postCode = var1;
   }

   public final void setStateCode(String var1) {
      this.stateCode = var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("GigyaAccountAddress(stateCode=");
      var1.append(this.stateCode);
      var1.append(", addressLine1=");
      var1.append(this.addressLine1);
      var1.append(", city=");
      var1.append(this.city);
      var1.append(", country=");
      var1.append(this.country);
      var1.append(", postCode=");
      var1.append(this.postCode);
      var1.append(')');
      return var1.toString();
   }
}
