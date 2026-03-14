package com.blueair.auth;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0006\"\u0004\b\u0007\u0010\u0005¨\u0006\u0010"},
   d2 = {"Lcom/blueair/auth/Email;", "", "isSubscribed", "", "<init>", "(Z)V", "()Z", "setSubscribed", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class Email {
   private boolean isSubscribed;

   public Email(boolean var1) {
      this.isSubscribed = var1;
   }

   // $FF: synthetic method
   public static Email copy$default(Email var0, boolean var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.isSubscribed;
      }

      return var0.copy(var1);
   }

   public final boolean component1() {
      return this.isSubscribed;
   }

   public final Email copy(boolean var1) {
      return new Email(var1);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof Email)) {
         return false;
      } else {
         var1 = var1;
         return this.isSubscribed == var1.isSubscribed;
      }
   }

   public int hashCode() {
      return AddDeviceState$$ExternalSyntheticBackport0.m(this.isSubscribed);
   }

   public final boolean isSubscribed() {
      return this.isSubscribed;
   }

   public final void setSubscribed(boolean var1) {
      this.isSubscribed = var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("Email(isSubscribed=");
      var1.append(this.isSubscribed);
      var1.append(')');
      return var1.toString();
   }
}
