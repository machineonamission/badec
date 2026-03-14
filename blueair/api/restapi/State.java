package com.blueair.api.restapi;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001a\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003JF\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"},
   d2 = {"Lcom/blueair/api/restapi/State;", "", "n", "", "v", "", "vb", "", "vj", "t", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Object;J)V", "getN", "()Ljava/lang/String;", "getV", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVb", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getVj", "()Ljava/lang/Object;", "getT", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Object;J)Lcom/blueair/api/restapi/State;", "equals", "other", "hashCode", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class State {
   private final String n;
   private final long t;
   private final Integer v;
   private final Boolean vb;
   private final Object vj;

   public State(String var1, Integer var2, Boolean var3, Object var4, long var5) {
      Intrinsics.checkNotNullParameter(var1, "n");
      super();
      this.n = var1;
      this.v = var2;
      this.vb = var3;
      this.vj = var4;
      this.t = var5;
   }

   // $FF: synthetic method
   public static State copy$default(State var0, String var1, Integer var2, Boolean var3, Object var4, long var5, int var7, Object var8) {
      if ((var7 & 1) != 0) {
         var1 = var0.n;
      }

      if ((var7 & 2) != 0) {
         var2 = var0.v;
      }

      if ((var7 & 4) != 0) {
         var3 = var0.vb;
      }

      if ((var7 & 8) != 0) {
         var4 = var0.vj;
      }

      if ((var7 & 16) != 0) {
         var5 = var0.t;
      }

      return var0.copy(var1, var2, var3, var4, var5);
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

   public final Object component4() {
      return this.vj;
   }

   public final long component5() {
      return this.t;
   }

   public final State copy(String var1, Integer var2, Boolean var3, Object var4, long var5) {
      Intrinsics.checkNotNullParameter(var1, "n");
      return new State(var1, var2, var3, var4, var5);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof State)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.n, var1.n)) {
            return false;
         } else if (!Intrinsics.areEqual(this.v, var1.v)) {
            return false;
         } else if (!Intrinsics.areEqual(this.vb, var1.vb)) {
            return false;
         } else if (!Intrinsics.areEqual(this.vj, var1.vj)) {
            return false;
         } else {
            return this.t == var1.t;
         }
      }
   }

   public final String getN() {
      return this.n;
   }

   public final long getT() {
      return this.t;
   }

   public final Integer getV() {
      return this.v;
   }

   public final Boolean getVb() {
      return this.vb;
   }

   public final Object getVj() {
      return this.vj;
   }

   public int hashCode() {
      int var4 = this.n.hashCode();
      Integer var5 = this.v;
      int var3 = 0;
      int var1;
      if (var5 == null) {
         var1 = 0;
      } else {
         var1 = var5.hashCode();
      }

      Boolean var6 = this.vb;
      int var2;
      if (var6 == null) {
         var2 = 0;
      } else {
         var2 = var6.hashCode();
      }

      Object var7 = this.vj;
      if (var7 != null) {
         var3 = var7.hashCode();
      }

      return (((var4 * 31 + var1) * 31 + var2) * 31 + var3) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.t);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("State(n=");
      var1.append(this.n);
      var1.append(", v=");
      var1.append(this.v);
      var1.append(", vb=");
      var1.append(this.vb);
      var1.append(", vj=");
      var1.append(this.vj);
      var1.append(", t=");
      var1.append(this.t);
      var1.append(')');
      return var1.toString();
   }
}
