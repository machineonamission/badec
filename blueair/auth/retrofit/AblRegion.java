package com.blueair.auth.retrofit;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"},
   d2 = {"Lcom/blueair/auth/retrofit/AblRegion;", "", "region", "", "<init>", "(Ljava/lang/String;)V", "getRegion", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AblRegion {
   private final String region;

   public AblRegion(String var1) {
      Intrinsics.checkNotNullParameter(var1, "region");
      super();
      this.region = var1;
   }

   // $FF: synthetic method
   public static AblRegion copy$default(AblRegion var0, String var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.region;
      }

      return var0.copy(var1);
   }

   public final String component1() {
      return this.region;
   }

   public final AblRegion copy(String var1) {
      Intrinsics.checkNotNullParameter(var1, "region");
      return new AblRegion(var1);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof AblRegion)) {
         return false;
      } else {
         var1 = var1;
         return Intrinsics.areEqual(this.region, var1.region);
      }
   }

   public final String getRegion() {
      return this.region;
   }

   public int hashCode() {
      return this.region.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("AblRegion(region=");
      var1.append(this.region);
      var1.append(')');
      return var1.toString();
   }
}
