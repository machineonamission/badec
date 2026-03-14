package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"},
   d2 = {"Lcom/blueair/api/restapi/G4NightModeTrigger;", "", "nmt", "", "n", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getNmt", "()Ljava/lang/String;", "getN", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class G4NightModeTrigger {
   private final String n;
   private final String nmt;

   public G4NightModeTrigger(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "nmt");
      Intrinsics.checkNotNullParameter(var2, "n");
      super();
      this.nmt = var1;
      this.n = var2;
   }

   // $FF: synthetic method
   public G4NightModeTrigger(String var1, String var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         var2 = "nm";
      }

      this(var1, var2);
   }

   // $FF: synthetic method
   public static G4NightModeTrigger copy$default(G4NightModeTrigger var0, String var1, String var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.nmt;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.n;
      }

      return var0.copy(var1, var2);
   }

   public final String component1() {
      return this.nmt;
   }

   public final String component2() {
      return this.n;
   }

   public final G4NightModeTrigger copy(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "nmt");
      Intrinsics.checkNotNullParameter(var2, "n");
      return new G4NightModeTrigger(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof G4NightModeTrigger)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.nmt, var1.nmt)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.n, var1.n);
         }
      }
   }

   public final String getN() {
      return this.n;
   }

   public final String getNmt() {
      return this.nmt;
   }

   public int hashCode() {
      return this.nmt.hashCode() * 31 + this.n.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("G4NightModeTrigger(nmt=");
      var1.append(this.nmt);
      var1.append(", n=");
      var1.append(this.n);
      var1.append(')');
      return var1.toString();
   }
}
