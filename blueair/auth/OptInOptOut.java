package com.blueair.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"},
   d2 = {"Lcom/blueair/auth/OptInOptOut;", "", "BRAND_XX_BH8488_EML", "Lcom/blueair/auth/BrandXxBh8488Eml;", "unilever", "Lcom/blueair/auth/Unilever;", "<init>", "(Lcom/blueair/auth/BrandXxBh8488Eml;Lcom/blueair/auth/Unilever;)V", "getBRAND_XX_BH8488_EML", "()Lcom/blueair/auth/BrandXxBh8488Eml;", "getUnilever", "()Lcom/blueair/auth/Unilever;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class OptInOptOut {
   private final BrandXxBh8488Eml BRAND_XX_BH8488_EML;
   private final Unilever unilever;

   public OptInOptOut(BrandXxBh8488Eml var1, Unilever var2) {
      Intrinsics.checkNotNullParameter(var1, "BRAND_XX_BH8488_EML");
      Intrinsics.checkNotNullParameter(var2, "unilever");
      super();
      this.BRAND_XX_BH8488_EML = var1;
      this.unilever = var2;
   }

   // $FF: synthetic method
   public static OptInOptOut copy$default(OptInOptOut var0, BrandXxBh8488Eml var1, Unilever var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.BRAND_XX_BH8488_EML;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.unilever;
      }

      return var0.copy(var1, var2);
   }

   public final BrandXxBh8488Eml component1() {
      return this.BRAND_XX_BH8488_EML;
   }

   public final Unilever component2() {
      return this.unilever;
   }

   public final OptInOptOut copy(BrandXxBh8488Eml var1, Unilever var2) {
      Intrinsics.checkNotNullParameter(var1, "BRAND_XX_BH8488_EML");
      Intrinsics.checkNotNullParameter(var2, "unilever");
      return new OptInOptOut(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof OptInOptOut)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.BRAND_XX_BH8488_EML, var1.BRAND_XX_BH8488_EML)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.unilever, var1.unilever);
         }
      }
   }

   public final BrandXxBh8488Eml getBRAND_XX_BH8488_EML() {
      return this.BRAND_XX_BH8488_EML;
   }

   public final Unilever getUnilever() {
      return this.unilever;
   }

   public int hashCode() {
      return this.BRAND_XX_BH8488_EML.hashCode() * 31 + this.unilever.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("OptInOptOut(BRAND_XX_BH8488_EML=");
      var1.append(this.BRAND_XX_BH8488_EML);
      var1.append(", unilever=");
      var1.append(this.unilever);
      var1.append(')');
      return var1.toString();
   }
}
