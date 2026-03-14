package com.blueair.auth;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"},
   d2 = {"Lcom/blueair/auth/ProfileDto;", "", "firstName", "", "lastName", "phones", "", "Lcom/blueair/auth/Phone;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getFirstName", "()Ljava/lang/String;", "getLastName", "getPhones", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
final class ProfileDto {
   private final String firstName;
   private final String lastName;
   private final List phones;

   public ProfileDto(String var1, String var2, List var3) {
      Intrinsics.checkNotNullParameter(var1, "firstName");
      Intrinsics.checkNotNullParameter(var2, "lastName");
      super();
      this.firstName = var1;
      this.lastName = var2;
      this.phones = var3;
   }

   // $FF: synthetic method
   public static ProfileDto copy$default(ProfileDto var0, String var1, String var2, List var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.firstName;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.lastName;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.phones;
      }

      return var0.copy(var1, var2, var3);
   }

   public final String component1() {
      return this.firstName;
   }

   public final String component2() {
      return this.lastName;
   }

   public final List component3() {
      return this.phones;
   }

   public final ProfileDto copy(String var1, String var2, List var3) {
      Intrinsics.checkNotNullParameter(var1, "firstName");
      Intrinsics.checkNotNullParameter(var2, "lastName");
      return new ProfileDto(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof ProfileDto)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.firstName, var1.firstName)) {
            return false;
         } else if (!Intrinsics.areEqual(this.lastName, var1.lastName)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.phones, var1.phones);
         }
      }
   }

   public final String getFirstName() {
      return this.firstName;
   }

   public final String getLastName() {
      return this.lastName;
   }

   public final List getPhones() {
      return this.phones;
   }

   public int hashCode() {
      int var2 = this.firstName.hashCode();
      int var3 = this.lastName.hashCode();
      List var4 = this.phones;
      int var1;
      if (var4 == null) {
         var1 = 0;
      } else {
         var1 = var4.hashCode();
      }

      return (var2 * 31 + var3) * 31 + var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("ProfileDto(firstName=");
      var1.append(this.firstName);
      var1.append(", lastName=");
      var1.append(this.lastName);
      var1.append(", phones=");
      var1.append(this.phones);
      var1.append(')');
      return var1.toString();
   }
}
