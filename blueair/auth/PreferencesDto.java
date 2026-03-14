package com.blueair.auth;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0083\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"},
   d2 = {"Lcom/blueair/auth/PreferencesDto;", "", "cookies", "Lcom/blueair/auth/Cookies;", "privacy", "Lcom/blueair/auth/Privacy;", "ageConsentGranted", "Lcom/blueair/auth/AgeConsentGranted;", "<init>", "(Lcom/blueair/auth/Cookies;Lcom/blueair/auth/Privacy;Lcom/blueair/auth/AgeConsentGranted;)V", "getCookies", "()Lcom/blueair/auth/Cookies;", "getPrivacy", "()Lcom/blueair/auth/Privacy;", "getAgeConsentGranted", "()Lcom/blueair/auth/AgeConsentGranted;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
final class PreferencesDto {
   private final AgeConsentGranted ageConsentGranted;
   private final Cookies cookies;
   private final Privacy privacy;

   public PreferencesDto(Cookies var1, Privacy var2, AgeConsentGranted var3) {
      Intrinsics.checkNotNullParameter(var1, "cookies");
      Intrinsics.checkNotNullParameter(var2, "privacy");
      Intrinsics.checkNotNullParameter(var3, "ageConsentGranted");
      super();
      this.cookies = var1;
      this.privacy = var2;
      this.ageConsentGranted = var3;
   }

   // $FF: synthetic method
   public static PreferencesDto copy$default(PreferencesDto var0, Cookies var1, Privacy var2, AgeConsentGranted var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.cookies;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.privacy;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.ageConsentGranted;
      }

      return var0.copy(var1, var2, var3);
   }

   public final Cookies component1() {
      return this.cookies;
   }

   public final Privacy component2() {
      return this.privacy;
   }

   public final AgeConsentGranted component3() {
      return this.ageConsentGranted;
   }

   public final PreferencesDto copy(Cookies var1, Privacy var2, AgeConsentGranted var3) {
      Intrinsics.checkNotNullParameter(var1, "cookies");
      Intrinsics.checkNotNullParameter(var2, "privacy");
      Intrinsics.checkNotNullParameter(var3, "ageConsentGranted");
      return new PreferencesDto(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof PreferencesDto)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.cookies, var1.cookies)) {
            return false;
         } else if (!Intrinsics.areEqual(this.privacy, var1.privacy)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.ageConsentGranted, var1.ageConsentGranted);
         }
      }
   }

   public final AgeConsentGranted getAgeConsentGranted() {
      return this.ageConsentGranted;
   }

   public final Cookies getCookies() {
      return this.cookies;
   }

   public final Privacy getPrivacy() {
      return this.privacy;
   }

   public int hashCode() {
      return (this.cookies.hashCode() * 31 + this.privacy.hashCode()) * 31 + this.ageConsentGranted.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("PreferencesDto(cookies=");
      var1.append(this.cookies);
      var1.append(", privacy=");
      var1.append(this.privacy);
      var1.append(", ageConsentGranted=");
      var1.append(this.ageConsentGranted);
      var1.append(')');
      return var1.toString();
   }
}
