package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J0\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"},
   d2 = {"Lcom/blueair/core/model/ScheduleMode;", "", "n", "", "v", "", "vb", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getN", "()Ljava/lang/String;", "getV", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVb", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/blueair/core/model/ScheduleMode;", "equals", "other", "hashCode", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ScheduleMode {
   private final String n;
   private final Integer v;
   private final Boolean vb;

   public ScheduleMode(String var1, Integer var2, Boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "n");
      super();
      this.n = var1;
      this.v = var2;
      this.vb = var3;
   }

   // $FF: synthetic method
   public ScheduleMode(String var1, Integer var2, Boolean var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = null;
      }

      this(var1, var2, var3);
   }

   // $FF: synthetic method
   public static ScheduleMode copy$default(ScheduleMode var0, String var1, Integer var2, Boolean var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.n;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.v;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.vb;
      }

      return var0.copy(var1, var2, var3);
   }

   public final String component1() {
      return this.n;
   }

   public final Integer component2() {
      return this.v;
   }

   public final Boolean component3() {
      return this.vb;
   }

   public final ScheduleMode copy(String var1, Integer var2, Boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "n");
      return new ScheduleMode(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof ScheduleMode)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.n, var1.n)) {
            return false;
         } else if (!Intrinsics.areEqual(this.v, var1.v)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.vb, var1.vb);
         }
      }
   }

   public final String getN() {
      return this.n;
   }

   public final Integer getV() {
      return this.v;
   }

   public final Boolean getVb() {
      return this.vb;
   }

   public int hashCode() {
      int var3 = this.n.hashCode();
      Integer var4 = this.v;
      int var2 = 0;
      int var1;
      if (var4 == null) {
         var1 = 0;
      } else {
         var1 = var4.hashCode();
      }

      Boolean var5 = this.vb;
      if (var5 != null) {
         var2 = var5.hashCode();
      }

      return (var3 * 31 + var1) * 31 + var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("ScheduleMode(n=");
      var1.append(this.n);
      var1.append(", v=");
      var1.append(this.v);
      var1.append(", vb=");
      var1.append(this.vb);
      var1.append(')');
      return var1.toString();
   }
}
