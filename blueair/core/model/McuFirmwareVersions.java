package com.blueair.core.model;

import com.blueair.core.util.StringUtils;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001+Bk\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003\u0012\b\b\u0003\u0010\t\u001a\u00020\u0003\u0012\b\b\u0003\u0010\n\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0003\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003Jm\u0010$\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006,"},
   d2 = {"Lcom/blueair/core/model/McuFirmwareVersions;", "", "mrestNightModeV2", "", "mrestAlarmSoundV2", "mrestHourFormatV2", "mrestBrightnessV2", "hum20BrightnessV2", "dehumidifierBrightnessV2", "combo2in120NightModeV2", "combo2in120BrightnessV2", "blue40BrightnessV2", "pet20BrightnessV2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMrestNightModeV2", "()Ljava/lang/String;", "getMrestAlarmSoundV2", "getMrestHourFormatV2", "getMrestBrightnessV2", "getHum20BrightnessV2", "getDehumidifierBrightnessV2", "getCombo2in120NightModeV2", "getCombo2in120BrightnessV2", "getBlue40BrightnessV2", "getPet20BrightnessV2", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class McuFirmwareVersions {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final String blue40BrightnessV2;
   private final String combo2in120BrightnessV2;
   private final String combo2in120NightModeV2;
   private final String dehumidifierBrightnessV2;
   private final String hum20BrightnessV2;
   private final String mrestAlarmSoundV2;
   private final String mrestBrightnessV2;
   private final String mrestHourFormatV2;
   private final String mrestNightModeV2;
   private final String pet20BrightnessV2;

   public McuFirmwareVersions() {
      this((String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, 1023, (DefaultConstructorMarker)null);
   }

   public McuFirmwareVersions(@Json(name = "mrest_night_mode_v2") String var1, @Json(name = "mrest_alarm_sound_v2") String var2, @Json(name = "mrest_hour_format_v2") String var3, @Json(name = "mrest_brightness_v2") String var4, @Json(name = "hum20_brightness_v2") String var5, @Json(name = "dehumidifier_brightness_v2") String var6, @Json(name = "combo2in120_night_mode_v2") String var7, @Json(name = "combo2in120_brightness_v2") String var8, @Json(name = "blue40_brightness_v2") String var9, @Json(name = "pet20_brightness_v2") String var10) {
      Intrinsics.checkNotNullParameter(var1, "mrestNightModeV2");
      Intrinsics.checkNotNullParameter(var2, "mrestAlarmSoundV2");
      Intrinsics.checkNotNullParameter(var3, "mrestHourFormatV2");
      Intrinsics.checkNotNullParameter(var4, "mrestBrightnessV2");
      Intrinsics.checkNotNullParameter(var5, "hum20BrightnessV2");
      Intrinsics.checkNotNullParameter(var6, "dehumidifierBrightnessV2");
      Intrinsics.checkNotNullParameter(var7, "combo2in120NightModeV2");
      Intrinsics.checkNotNullParameter(var8, "combo2in120BrightnessV2");
      Intrinsics.checkNotNullParameter(var9, "blue40BrightnessV2");
      Intrinsics.checkNotNullParameter(var10, "pet20BrightnessV2");
      super();
      this.mrestNightModeV2 = var1;
      this.mrestAlarmSoundV2 = var2;
      this.mrestHourFormatV2 = var3;
      this.mrestBrightnessV2 = var4;
      this.hum20BrightnessV2 = var5;
      this.dehumidifierBrightnessV2 = var6;
      this.combo2in120NightModeV2 = var7;
      this.combo2in120BrightnessV2 = var8;
      this.blue40BrightnessV2 = var9;
      this.pet20BrightnessV2 = var10;
   }

   // $FF: synthetic method
   public McuFirmwareVersions(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, int var11, DefaultConstructorMarker var12) {
      if ((var11 & 1) != 0) {
         var1 = "1.2.3";
      }

      if ((var11 & 2) != 0) {
         var2 = "1.0.6";
      }

      if ((var11 & 4) != 0) {
         var3 = "1.1.0";
      }

      if ((var11 & 8) != 0) {
         var4 = "1.2.3";
      }

      if ((var11 & 16) != 0) {
         var5 = "1.0.3";
      }

      if ((var11 & 32) != 0) {
         var6 = "0.0.0";
      }

      if ((var11 & 64) != 0) {
         var7 = "2.0.0";
      }

      if ((var11 & 128) != 0) {
         var8 = "1.0.9";
      }

      if ((var11 & 256) != 0) {
         var9 = "1.1.0";
      }

      if ((var11 & 512) != 0) {
         var10 = "0.0.0";
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
   }

   // $FF: synthetic method
   public static McuFirmwareVersions copy$default(McuFirmwareVersions var0, String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, int var11, Object var12) {
      if ((var11 & 1) != 0) {
         var1 = var0.mrestNightModeV2;
      }

      if ((var11 & 2) != 0) {
         var2 = var0.mrestAlarmSoundV2;
      }

      if ((var11 & 4) != 0) {
         var3 = var0.mrestHourFormatV2;
      }

      if ((var11 & 8) != 0) {
         var4 = var0.mrestBrightnessV2;
      }

      if ((var11 & 16) != 0) {
         var5 = var0.hum20BrightnessV2;
      }

      if ((var11 & 32) != 0) {
         var6 = var0.dehumidifierBrightnessV2;
      }

      if ((var11 & 64) != 0) {
         var7 = var0.combo2in120NightModeV2;
      }

      if ((var11 & 128) != 0) {
         var8 = var0.combo2in120BrightnessV2;
      }

      if ((var11 & 256) != 0) {
         var9 = var0.blue40BrightnessV2;
      }

      if ((var11 & 512) != 0) {
         var10 = var0.pet20BrightnessV2;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
   }

   public final String component1() {
      return this.mrestNightModeV2;
   }

   public final String component10() {
      return this.pet20BrightnessV2;
   }

   public final String component2() {
      return this.mrestAlarmSoundV2;
   }

   public final String component3() {
      return this.mrestHourFormatV2;
   }

   public final String component4() {
      return this.mrestBrightnessV2;
   }

   public final String component5() {
      return this.hum20BrightnessV2;
   }

   public final String component6() {
      return this.dehumidifierBrightnessV2;
   }

   public final String component7() {
      return this.combo2in120NightModeV2;
   }

   public final String component8() {
      return this.combo2in120BrightnessV2;
   }

   public final String component9() {
      return this.blue40BrightnessV2;
   }

   public final McuFirmwareVersions copy(@Json(name = "mrest_night_mode_v2") String var1, @Json(name = "mrest_alarm_sound_v2") String var2, @Json(name = "mrest_hour_format_v2") String var3, @Json(name = "mrest_brightness_v2") String var4, @Json(name = "hum20_brightness_v2") String var5, @Json(name = "dehumidifier_brightness_v2") String var6, @Json(name = "combo2in120_night_mode_v2") String var7, @Json(name = "combo2in120_brightness_v2") String var8, @Json(name = "blue40_brightness_v2") String var9, @Json(name = "pet20_brightness_v2") String var10) {
      Intrinsics.checkNotNullParameter(var1, "mrestNightModeV2");
      Intrinsics.checkNotNullParameter(var2, "mrestAlarmSoundV2");
      Intrinsics.checkNotNullParameter(var3, "mrestHourFormatV2");
      Intrinsics.checkNotNullParameter(var4, "mrestBrightnessV2");
      Intrinsics.checkNotNullParameter(var5, "hum20BrightnessV2");
      Intrinsics.checkNotNullParameter(var6, "dehumidifierBrightnessV2");
      Intrinsics.checkNotNullParameter(var7, "combo2in120NightModeV2");
      Intrinsics.checkNotNullParameter(var8, "combo2in120BrightnessV2");
      Intrinsics.checkNotNullParameter(var9, "blue40BrightnessV2");
      Intrinsics.checkNotNullParameter(var10, "pet20BrightnessV2");
      return new McuFirmwareVersions(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof McuFirmwareVersions)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.mrestNightModeV2, var1.mrestNightModeV2)) {
            return false;
         } else if (!Intrinsics.areEqual(this.mrestAlarmSoundV2, var1.mrestAlarmSoundV2)) {
            return false;
         } else if (!Intrinsics.areEqual(this.mrestHourFormatV2, var1.mrestHourFormatV2)) {
            return false;
         } else if (!Intrinsics.areEqual(this.mrestBrightnessV2, var1.mrestBrightnessV2)) {
            return false;
         } else if (!Intrinsics.areEqual(this.hum20BrightnessV2, var1.hum20BrightnessV2)) {
            return false;
         } else if (!Intrinsics.areEqual(this.dehumidifierBrightnessV2, var1.dehumidifierBrightnessV2)) {
            return false;
         } else if (!Intrinsics.areEqual(this.combo2in120NightModeV2, var1.combo2in120NightModeV2)) {
            return false;
         } else if (!Intrinsics.areEqual(this.combo2in120BrightnessV2, var1.combo2in120BrightnessV2)) {
            return false;
         } else if (!Intrinsics.areEqual(this.blue40BrightnessV2, var1.blue40BrightnessV2)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.pet20BrightnessV2, var1.pet20BrightnessV2);
         }
      }
   }

   public final String getBlue40BrightnessV2() {
      return this.blue40BrightnessV2;
   }

   public final String getCombo2in120BrightnessV2() {
      return this.combo2in120BrightnessV2;
   }

   public final String getCombo2in120NightModeV2() {
      return this.combo2in120NightModeV2;
   }

   public final String getDehumidifierBrightnessV2() {
      return this.dehumidifierBrightnessV2;
   }

   public final String getHum20BrightnessV2() {
      return this.hum20BrightnessV2;
   }

   public final String getMrestAlarmSoundV2() {
      return this.mrestAlarmSoundV2;
   }

   public final String getMrestBrightnessV2() {
      return this.mrestBrightnessV2;
   }

   public final String getMrestHourFormatV2() {
      return this.mrestHourFormatV2;
   }

   public final String getMrestNightModeV2() {
      return this.mrestNightModeV2;
   }

   public final String getPet20BrightnessV2() {
      return this.pet20BrightnessV2;
   }

   public int hashCode() {
      return ((((((((this.mrestNightModeV2.hashCode() * 31 + this.mrestAlarmSoundV2.hashCode()) * 31 + this.mrestHourFormatV2.hashCode()) * 31 + this.mrestBrightnessV2.hashCode()) * 31 + this.hum20BrightnessV2.hashCode()) * 31 + this.dehumidifierBrightnessV2.hashCode()) * 31 + this.combo2in120NightModeV2.hashCode()) * 31 + this.combo2in120BrightnessV2.hashCode()) * 31 + this.blue40BrightnessV2.hashCode()) * 31 + this.pet20BrightnessV2.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("McuFirmwareVersions(mrestNightModeV2=");
      var1.append(this.mrestNightModeV2);
      var1.append(", mrestAlarmSoundV2=");
      var1.append(this.mrestAlarmSoundV2);
      var1.append(", mrestHourFormatV2=");
      var1.append(this.mrestHourFormatV2);
      var1.append(", mrestBrightnessV2=");
      var1.append(this.mrestBrightnessV2);
      var1.append(", hum20BrightnessV2=");
      var1.append(this.hum20BrightnessV2);
      var1.append(", dehumidifierBrightnessV2=");
      var1.append(this.dehumidifierBrightnessV2);
      var1.append(", combo2in120NightModeV2=");
      var1.append(this.combo2in120NightModeV2);
      var1.append(", combo2in120BrightnessV2=");
      var1.append(this.combo2in120BrightnessV2);
      var1.append(", blue40BrightnessV2=");
      var1.append(this.blue40BrightnessV2);
      var1.append(", pet20BrightnessV2=");
      var1.append(this.pet20BrightnessV2);
      var1.append(')');
      return var1.toString();
   }

   @Metadata(
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"},
      d2 = {"Lcom/blueair/core/model/McuFirmwareVersions$Companion;", "", "<init>", "()V", "compare", "", "new", "", "old", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final int compare(String var1, String var2) {
         Intrinsics.checkNotNullParameter(var1, "new");
         Intrinsics.checkNotNullParameter(var2, "old");
         return StringUtils.INSTANCE.compareVersion(var1, var2);
      }
   }
}
