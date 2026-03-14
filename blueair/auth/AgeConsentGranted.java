package com.blueair.auth;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0083\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u000f"},
   d2 = {"Lcom/blueair/auth/AgeConsentGranted;", "", "isConsentGranted", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
final class AgeConsentGranted {
   private final boolean isConsentGranted;

   public AgeConsentGranted(boolean var1) {
      this.isConsentGranted = var1;
   }

   // $FF: synthetic method
   public static AgeConsentGranted copy$default(AgeConsentGranted var0, boolean var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.isConsentGranted;
      }

      return var0.copy(var1);
   }

   public final boolean component1() {
      return this.isConsentGranted;
   }

   public final AgeConsentGranted copy(boolean var1) {
      return new AgeConsentGranted(var1);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof AgeConsentGranted)) {
         return false;
      } else {
         var1 = var1;
         return this.isConsentGranted == var1.isConsentGranted;
      }
   }

   public int hashCode() {
      return AddDeviceState$$ExternalSyntheticBackport0.m(this.isConsentGranted);
   }

   public final boolean isConsentGranted() {
      return this.isConsentGranted;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("AgeConsentGranted(isConsentGranted=");
      var1.append(this.isConsentGranted);
      var1.append(')');
      return var1.toString();
   }
}
