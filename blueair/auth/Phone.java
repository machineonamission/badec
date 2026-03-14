package com.blueair.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"},
   d2 = {"Lcom/blueair/auth/Phone;", "", "number", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getNumber", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
final class Phone {
   private final String number;
   private final String type;

   public Phone(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "number");
      Intrinsics.checkNotNullParameter(var2, "type");
      super();
      this.number = var1;
      this.type = var2;
   }

   // $FF: synthetic method
   public static Phone copy$default(Phone var0, String var1, String var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.number;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.type;
      }

      return var0.copy(var1, var2);
   }

   public final String component1() {
      return this.number;
   }

   public final String component2() {
      return this.type;
   }

   public final Phone copy(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "number");
      Intrinsics.checkNotNullParameter(var2, "type");
      return new Phone(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof Phone)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.number, var1.number)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.type, var1.type);
         }
      }
   }

   public final String getNumber() {
      return this.number;
   }

   public final String getType() {
      return this.type;
   }

   public int hashCode() {
      return this.number.hashCode() * 31 + this.type.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("Phone(number=");
      var1.append(this.number);
      var1.append(", type=");
      var1.append(this.type);
      var1.append(')');
      return var1.toString();
   }
}
