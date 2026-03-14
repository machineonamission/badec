package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"},
   d2 = {"Lcom/blueair/core/model/Pollutant;", "", "concentration", "", "<init>", "(Ljava/lang/Double;)V", "getConcentration", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "copy", "(Ljava/lang/Double;)Lcom/blueair/core/model/Pollutant;", "equals", "", "other", "hashCode", "", "toString", "", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class Pollutant {
   private final Double concentration;

   public Pollutant(Double var1) {
      this.concentration = var1;
   }

   // $FF: synthetic method
   public static Pollutant copy$default(Pollutant var0, Double var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.concentration;
      }

      return var0.copy(var1);
   }

   public final Double component1() {
      return this.concentration;
   }

   public final Pollutant copy(Double var1) {
      return new Pollutant(var1);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof Pollutant)) {
         return false;
      } else {
         var1 = var1;
         return Intrinsics.areEqual(this.concentration, var1.concentration);
      }
   }

   public final Double getConcentration() {
      return this.concentration;
   }

   public int hashCode() {
      Double var1 = this.concentration;
      return var1 == null ? 0 : var1.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("Pollutant(concentration=");
      var1.append(this.concentration);
      var1.append(')');
      return var1.toString();
   }
}
