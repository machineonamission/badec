package com.blueair.auth;

import com.gigya.android.sdk.account.models.GigyaAccount;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"},
   d2 = {"Lcom/blueair/auth/GigyaAccountExtended;", "Lcom/gigya/android/sdk/account/models/GigyaAccount;", "data", "Lcom/blueair/auth/GigyaAccountData;", "subscriptions", "Lcom/blueair/auth/SubscriptionsDto;", "<init>", "(Lcom/blueair/auth/GigyaAccountData;Lcom/blueair/auth/SubscriptionsDto;)V", "getData", "()Lcom/blueair/auth/GigyaAccountData;", "setData", "(Lcom/blueair/auth/GigyaAccountData;)V", "getSubscriptions", "()Lcom/blueair/auth/SubscriptionsDto;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GigyaAccountExtended extends GigyaAccount {
   private GigyaAccountData data;
   private final SubscriptionsDto subscriptions;

   public GigyaAccountExtended(GigyaAccountData var1, SubscriptionsDto var2) {
      Intrinsics.checkNotNullParameter(var1, "data");
      Intrinsics.checkNotNullParameter(var2, "subscriptions");
      super();
      this.data = var1;
      this.subscriptions = var2;
   }

   // $FF: synthetic method
   public static GigyaAccountExtended copy$default(GigyaAccountExtended var0, GigyaAccountData var1, SubscriptionsDto var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.data;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.subscriptions;
      }

      return var0.copy(var1, var2);
   }

   public final GigyaAccountData component1() {
      return this.data;
   }

   public final SubscriptionsDto component2() {
      return this.subscriptions;
   }

   public final GigyaAccountExtended copy(GigyaAccountData var1, SubscriptionsDto var2) {
      Intrinsics.checkNotNullParameter(var1, "data");
      Intrinsics.checkNotNullParameter(var2, "subscriptions");
      return new GigyaAccountExtended(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof GigyaAccountExtended)) {
         return false;
      } else {
         GigyaAccountExtended var2 = (GigyaAccountExtended)var1;
         if (!Intrinsics.areEqual(this.data, var2.data)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.subscriptions, var2.subscriptions);
         }
      }
   }

   public final GigyaAccountData getData() {
      return this.data;
   }

   public final SubscriptionsDto getSubscriptions() {
      return this.subscriptions;
   }

   public int hashCode() {
      return this.data.hashCode() * 31 + this.subscriptions.hashCode();
   }

   public final void setData(GigyaAccountData var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.data = var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("GigyaAccountExtended(data=");
      var1.append(this.data);
      var1.append(", subscriptions=");
      var1.append(this.subscriptions);
      var1.append(')');
      return var1.toString();
   }
}
