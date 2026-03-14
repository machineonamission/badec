package com.blueair.sdk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003Je\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014¨\u0006)"},
   d2 = {"Lcom/blueair/sdk/KlaviyoProfileData;", "", "gigyaUid", "", "email", "language", "filterReplacement", "", "quickAlarmStop", "cleaningReminders", "waterLevel", "marketingNotifications", "transactionalNotifications", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIII)V", "getGigyaUid", "()Ljava/lang/String;", "getEmail", "getLanguage", "getFilterReplacement", "()I", "getQuickAlarmStop", "getCleaningReminders", "getWaterLevel", "getMarketingNotifications", "getTransactionalNotifications", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "sdk_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class KlaviyoProfileData {
   private final int cleaningReminders;
   private final String email;
   private final int filterReplacement;
   private final String gigyaUid;
   private final String language;
   private final int marketingNotifications;
   private final int quickAlarmStop;
   private final int transactionalNotifications;
   private final int waterLevel;

   public KlaviyoProfileData(String var1, String var2, String var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Intrinsics.checkNotNullParameter(var2, "email");
      Intrinsics.checkNotNullParameter(var3, "language");
      super();
      this.gigyaUid = var1;
      this.email = var2;
      this.language = var3;
      this.filterReplacement = var4;
      this.quickAlarmStop = var5;
      this.cleaningReminders = var6;
      this.waterLevel = var7;
      this.marketingNotifications = var8;
      this.transactionalNotifications = var9;
   }

   // $FF: synthetic method
   public static KlaviyoProfileData copy$default(KlaviyoProfileData var0, String var1, String var2, String var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, Object var11) {
      if ((var10 & 1) != 0) {
         var1 = var0.gigyaUid;
      }

      if ((var10 & 2) != 0) {
         var2 = var0.email;
      }

      if ((var10 & 4) != 0) {
         var3 = var0.language;
      }

      if ((var10 & 8) != 0) {
         var4 = var0.filterReplacement;
      }

      if ((var10 & 16) != 0) {
         var5 = var0.quickAlarmStop;
      }

      if ((var10 & 32) != 0) {
         var6 = var0.cleaningReminders;
      }

      if ((var10 & 64) != 0) {
         var7 = var0.waterLevel;
      }

      if ((var10 & 128) != 0) {
         var8 = var0.marketingNotifications;
      }

      if ((var10 & 256) != 0) {
         var9 = var0.transactionalNotifications;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public final String component1() {
      return this.gigyaUid;
   }

   public final String component2() {
      return this.email;
   }

   public final String component3() {
      return this.language;
   }

   public final int component4() {
      return this.filterReplacement;
   }

   public final int component5() {
      return this.quickAlarmStop;
   }

   public final int component6() {
      return this.cleaningReminders;
   }

   public final int component7() {
      return this.waterLevel;
   }

   public final int component8() {
      return this.marketingNotifications;
   }

   public final int component9() {
      return this.transactionalNotifications;
   }

   public final KlaviyoProfileData copy(String var1, String var2, String var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Intrinsics.checkNotNullParameter(var2, "email");
      Intrinsics.checkNotNullParameter(var3, "language");
      return new KlaviyoProfileData(var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof KlaviyoProfileData)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.gigyaUid, var1.gigyaUid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.email, var1.email)) {
            return false;
         } else if (!Intrinsics.areEqual(this.language, var1.language)) {
            return false;
         } else if (this.filterReplacement != var1.filterReplacement) {
            return false;
         } else if (this.quickAlarmStop != var1.quickAlarmStop) {
            return false;
         } else if (this.cleaningReminders != var1.cleaningReminders) {
            return false;
         } else if (this.waterLevel != var1.waterLevel) {
            return false;
         } else if (this.marketingNotifications != var1.marketingNotifications) {
            return false;
         } else {
            return this.transactionalNotifications == var1.transactionalNotifications;
         }
      }
   }

   public final int getCleaningReminders() {
      return this.cleaningReminders;
   }

   public final String getEmail() {
      return this.email;
   }

   public final int getFilterReplacement() {
      return this.filterReplacement;
   }

   public final String getGigyaUid() {
      return this.gigyaUid;
   }

   public final String getLanguage() {
      return this.language;
   }

   public final int getMarketingNotifications() {
      return this.marketingNotifications;
   }

   public final int getQuickAlarmStop() {
      return this.quickAlarmStop;
   }

   public final int getTransactionalNotifications() {
      return this.transactionalNotifications;
   }

   public final int getWaterLevel() {
      return this.waterLevel;
   }

   public int hashCode() {
      String var2 = this.gigyaUid;
      int var1;
      if (var2 == null) {
         var1 = 0;
      } else {
         var1 = var2.hashCode();
      }

      return (((((((var1 * 31 + this.email.hashCode()) * 31 + this.language.hashCode()) * 31 + this.filterReplacement) * 31 + this.quickAlarmStop) * 31 + this.cleaningReminders) * 31 + this.waterLevel) * 31 + this.marketingNotifications) * 31 + this.transactionalNotifications;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("KlaviyoProfileData(gigyaUid=");
      var1.append(this.gigyaUid);
      var1.append(", email=");
      var1.append(this.email);
      var1.append(", language=");
      var1.append(this.language);
      var1.append(", filterReplacement=");
      var1.append(this.filterReplacement);
      var1.append(", quickAlarmStop=");
      var1.append(this.quickAlarmStop);
      var1.append(", cleaningReminders=");
      var1.append(this.cleaningReminders);
      var1.append(", waterLevel=");
      var1.append(this.waterLevel);
      var1.append(", marketingNotifications=");
      var1.append(this.marketingNotifications);
      var1.append(", transactionalNotifications=");
      var1.append(this.transactionalNotifications);
      var1.append(')');
      return var1.toString();
   }
}
