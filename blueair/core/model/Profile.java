package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"},
   d2 = {"Lcom/blueair/core/model/Profile;", "", "country", "", "email", "firstName", "lastName", "zip", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCountry", "()Ljava/lang/String;", "getEmail", "getFirstName", "getLastName", "getZip", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class Profile {
   private final String country;
   private final String email;
   private final String firstName;
   private final String lastName;
   private final String zip;

   public Profile(String var1, String var2, String var3, String var4, String var5) {
      this.country = var1;
      this.email = var2;
      this.firstName = var3;
      this.lastName = var4;
      this.zip = var5;
   }

   // $FF: synthetic method
   public static Profile copy$default(Profile var0, String var1, String var2, String var3, String var4, String var5, int var6, Object var7) {
      if ((var6 & 1) != 0) {
         var1 = var0.country;
      }

      if ((var6 & 2) != 0) {
         var2 = var0.email;
      }

      if ((var6 & 4) != 0) {
         var3 = var0.firstName;
      }

      if ((var6 & 8) != 0) {
         var4 = var0.lastName;
      }

      if ((var6 & 16) != 0) {
         var5 = var0.zip;
      }

      return var0.copy(var1, var2, var3, var4, var5);
   }

   public final String component1() {
      return this.country;
   }

   public final String component2() {
      return this.email;
   }

   public final String component3() {
      return this.firstName;
   }

   public final String component4() {
      return this.lastName;
   }

   public final String component5() {
      return this.zip;
   }

   public final Profile copy(String var1, String var2, String var3, String var4, String var5) {
      return new Profile(var1, var2, var3, var4, var5);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof Profile)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.country, var1.country)) {
            return false;
         } else if (!Intrinsics.areEqual(this.email, var1.email)) {
            return false;
         } else if (!Intrinsics.areEqual(this.firstName, var1.firstName)) {
            return false;
         } else if (!Intrinsics.areEqual(this.lastName, var1.lastName)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.zip, var1.zip);
         }
      }
   }

   public final String getCountry() {
      return this.country;
   }

   public final String getEmail() {
      return this.email;
   }

   public final String getFirstName() {
      return this.firstName;
   }

   public final String getLastName() {
      return this.lastName;
   }

   public final String getZip() {
      return this.zip;
   }

   public int hashCode() {
      String var6 = this.country;
      int var5 = 0;
      int var1;
      if (var6 == null) {
         var1 = 0;
      } else {
         var1 = var6.hashCode();
      }

      var6 = this.email;
      int var2;
      if (var6 == null) {
         var2 = 0;
      } else {
         var2 = var6.hashCode();
      }

      var6 = this.firstName;
      int var3;
      if (var6 == null) {
         var3 = 0;
      } else {
         var3 = var6.hashCode();
      }

      var6 = this.lastName;
      int var4;
      if (var6 == null) {
         var4 = 0;
      } else {
         var4 = var6.hashCode();
      }

      var6 = this.zip;
      if (var6 != null) {
         var5 = var6.hashCode();
      }

      return (((var1 * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("Profile(country=");
      var1.append(this.country);
      var1.append(", email=");
      var1.append(this.email);
      var1.append(", firstName=");
      var1.append(this.firstName);
      var1.append(", lastName=");
      var1.append(this.lastName);
      var1.append(", zip=");
      var1.append(this.zip);
      var1.append(')');
      return var1.toString();
   }
}
