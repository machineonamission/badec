package com.blueair.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
   d2 = {"Lcom/blueair/auth/SubscriptionsDto;", "", "optInOptOut", "Lcom/blueair/auth/OptInOptOut;", "<init>", "(Lcom/blueair/auth/OptInOptOut;)V", "getOptInOptOut", "()Lcom/blueair/auth/OptInOptOut;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SubscriptionsDto {
   private final OptInOptOut optInOptOut;

   public SubscriptionsDto() {
      this((OptInOptOut)null, 1, (DefaultConstructorMarker)null);
   }

   public SubscriptionsDto(OptInOptOut var1) {
      this.optInOptOut = var1;
   }

   // $FF: synthetic method
   public SubscriptionsDto(OptInOptOut var1, int var2, DefaultConstructorMarker var3) {
      if ((var2 & 1) != 0) {
         var1 = new OptInOptOut(new BrandXxBh8488Eml(new Email(false)), new Unilever(new Email(false)));
      }

      this(var1);
   }

   // $FF: synthetic method
   public static SubscriptionsDto copy$default(SubscriptionsDto var0, OptInOptOut var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.optInOptOut;
      }

      return var0.copy(var1);
   }

   public final OptInOptOut component1() {
      return this.optInOptOut;
   }

   public final SubscriptionsDto copy(OptInOptOut var1) {
      return new SubscriptionsDto(var1);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof SubscriptionsDto)) {
         return false;
      } else {
         var1 = var1;
         return Intrinsics.areEqual(this.optInOptOut, var1.optInOptOut);
      }
   }

   public final OptInOptOut getOptInOptOut() {
      return this.optInOptOut;
   }

   public int hashCode() {
      OptInOptOut var1 = this.optInOptOut;
      return var1 == null ? 0 : var1.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("SubscriptionsDto(optInOptOut=");
      var1.append(this.optInOptOut);
      var1.append(')');
      return var1.toString();
   }
}
