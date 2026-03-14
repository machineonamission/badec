package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"},
   d2 = {"Lcom/blueair/core/model/MbLocationProperties;", "", "address", "", "<init>", "(Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class MbLocationProperties {
   private final String address;

   public MbLocationProperties(String var1) {
      this.address = var1;
   }

   // $FF: synthetic method
   public static MbLocationProperties copy$default(MbLocationProperties var0, String var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.address;
      }

      return var0.copy(var1);
   }

   public final String component1() {
      return this.address;
   }

   public final MbLocationProperties copy(String var1) {
      return new MbLocationProperties(var1);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof MbLocationProperties)) {
         return false;
      } else {
         var1 = var1;
         return Intrinsics.areEqual(this.address, var1.address);
      }
   }

   public final String getAddress() {
      return this.address;
   }

   public int hashCode() {
      String var1 = this.address;
      return var1 == null ? 0 : var1.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("MbLocationProperties(address=");
      var1.append(this.address);
      var1.append(')');
      return var1.toString();
   }
}
