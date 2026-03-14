package com.blueair.core.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"},
   d2 = {"Lcom/blueair/core/model/UserInfoExtras;", "", "chinaPrivacyConsentVersion", "", "<init>", "(I)V", "getChinaPrivacyConsentVersion", "()I", "setChinaPrivacyConsentVersion", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class UserInfoExtras {
   private int chinaPrivacyConsentVersion;

   public UserInfoExtras() {
      this(0, 1, (DefaultConstructorMarker)null);
   }

   public UserInfoExtras(@Json(name = "china_privacy_consent_version") int var1) {
      this.chinaPrivacyConsentVersion = var1;
   }

   // $FF: synthetic method
   public UserInfoExtras(int var1, int var2, DefaultConstructorMarker var3) {
      if ((var2 & 1) != 0) {
         var1 = 0;
      }

      this(var1);
   }

   // $FF: synthetic method
   public static UserInfoExtras copy$default(UserInfoExtras var0, int var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.chinaPrivacyConsentVersion;
      }

      return var0.copy(var1);
   }

   public final int component1() {
      return this.chinaPrivacyConsentVersion;
   }

   public final UserInfoExtras copy(@Json(name = "china_privacy_consent_version") int var1) {
      return new UserInfoExtras(var1);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof UserInfoExtras)) {
         return false;
      } else {
         var1 = var1;
         return this.chinaPrivacyConsentVersion == var1.chinaPrivacyConsentVersion;
      }
   }

   public final int getChinaPrivacyConsentVersion() {
      return this.chinaPrivacyConsentVersion;
   }

   public int hashCode() {
      return this.chinaPrivacyConsentVersion;
   }

   public final void setChinaPrivacyConsentVersion(int var1) {
      this.chinaPrivacyConsentVersion = var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("UserInfoExtras(chinaPrivacyConsentVersion=");
      var1.append(this.chinaPrivacyConsentVersion);
      var1.append(')');
      return var1.toString();
   }
}
