package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"},
   d2 = {"Lcom/blueair/core/model/FilterLifeTime;", "", "filterLife", "", "<init>", "(I)V", "getFilterLife", "()I", "NoFilterInfo", "FilterDaysLeft", "FilterPercentageLeft", "Lcom/blueair/core/model/FilterLifeTime$FilterDaysLeft;", "Lcom/blueair/core/model/FilterLifeTime$FilterPercentageLeft;", "Lcom/blueair/core/model/FilterLifeTime$NoFilterInfo;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class FilterLifeTime {
   private final int filterLife;

   private FilterLifeTime(int var1) {
      this.filterLife = var1;
   }

   // $FF: synthetic method
   public FilterLifeTime(int var1, DefaultConstructorMarker var2) {
      this(var1);
   }

   public int getFilterLife() {
      return this.filterLife;
   }

   @Metadata(
      d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0017"},
      d2 = {"Lcom/blueair/core/model/FilterLifeTime$FilterDaysLeft;", "Lcom/blueair/core/model/FilterLifeTime;", "filterLife", "", "filterLifePercentage", "<init>", "(ILjava/lang/Integer;)V", "getFilterLife", "()I", "getFilterLifePercentage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(ILjava/lang/Integer;)Lcom/blueair/core/model/FilterLifeTime$FilterDaysLeft;", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class FilterDaysLeft extends FilterLifeTime {
      private final int filterLife;
      private final Integer filterLifePercentage;

      public FilterDaysLeft(int var1, Integer var2) {
         super(var1, (DefaultConstructorMarker)null);
         this.filterLife = var1;
         this.filterLifePercentage = var2;
      }

      // $FF: synthetic method
      public FilterDaysLeft(int var1, Integer var2, int var3, DefaultConstructorMarker var4) {
         if ((var3 & 2) != 0) {
            var2 = null;
         }

         this(var1, var2);
      }

      // $FF: synthetic method
      public static FilterDaysLeft copy$default(FilterDaysLeft var0, int var1, Integer var2, int var3, Object var4) {
         if ((var3 & 1) != 0) {
            var1 = var0.filterLife;
         }

         if ((var3 & 2) != 0) {
            var2 = var0.filterLifePercentage;
         }

         return var0.copy(var1, var2);
      }

      public final int component1() {
         return this.filterLife;
      }

      public final Integer component2() {
         return this.filterLifePercentage;
      }

      public final FilterDaysLeft copy(int var1, Integer var2) {
         return new FilterDaysLeft(var1, var2);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof FilterDaysLeft)) {
            return false;
         } else {
            var1 = var1;
            if (this.filterLife != var1.filterLife) {
               return false;
            } else {
               return Intrinsics.areEqual(this.filterLifePercentage, var1.filterLifePercentage);
            }
         }
      }

      public int getFilterLife() {
         return this.filterLife;
      }

      public final Integer getFilterLifePercentage() {
         return this.filterLifePercentage;
      }

      public int hashCode() {
         int var2 = this.filterLife;
         Integer var3 = this.filterLifePercentage;
         int var1;
         if (var3 == null) {
            var1 = 0;
         } else {
            var1 = var3.hashCode();
         }

         return var2 * 31 + var1;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("FilterDaysLeft(filterLife=");
         var1.append(this.filterLife);
         var1.append(", filterLifePercentage=");
         var1.append(this.filterLifePercentage);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/FilterLifeTime$FilterPercentageLeft;", "Lcom/blueair/core/model/FilterLifeTime;", "filterLife", "", "<init>", "(I)V", "getFilterLife", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class FilterPercentageLeft extends FilterLifeTime {
      private final int filterLife;

      public FilterPercentageLeft(int var1) {
         super(var1, (DefaultConstructorMarker)null);
         this.filterLife = var1;
      }

      // $FF: synthetic method
      public static FilterPercentageLeft copy$default(FilterPercentageLeft var0, int var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = var0.filterLife;
         }

         return var0.copy(var1);
      }

      public final int component1() {
         return this.filterLife;
      }

      public final FilterPercentageLeft copy(int var1) {
         return new FilterPercentageLeft(var1);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof FilterPercentageLeft)) {
            return false;
         } else {
            var1 = var1;
            return this.filterLife == var1.filterLife;
         }
      }

      public int getFilterLife() {
         return this.filterLife;
      }

      public int hashCode() {
         return this.filterLife;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("FilterPercentageLeft(filterLife=");
         var1.append(this.filterLife);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/FilterLifeTime$NoFilterInfo;", "Lcom/blueair/core/model/FilterLifeTime;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class NoFilterInfo extends FilterLifeTime {
      public NoFilterInfo() {
         super(100, (DefaultConstructorMarker)null);
      }
   }
}
