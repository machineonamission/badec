package com.blueair.viewcore.utils;

import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.CoolSubMode;
import com.blueair.core.model.DehSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HumSubMode;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 A2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001ABk\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010.\u001a\u0004\u0018\u00010/J\b\u00100\u001a\u0004\u0018\u000101J\b\u00102\u001a\u0004\u0018\u000103J\b\u00104\u001a\u0004\u0018\u000105J\b\u00106\u001a\u0004\u0018\u000107J\b\u00108\u001a\u0004\u0018\u000109J\u0010\u0010:\u001a\u00020\u00002\b\u0010;\u001a\u0004\u0018\u00010<J\u0018\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011j\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-¨\u0006B"},
   d2 = {"Lcom/blueair/viewcore/utils/ModeIcon;", "", "text", "", "onIcon", "onIconDisabled", "offIcon", "offIconDisabled", "flatIcon", "textShort", "onIconV2", "offIconV2", "disabledIconV2", "onIconDisabledV2", "<init>", "(Ljava/lang/String;IIIIIIIIIIII)V", "getText", "()I", "getOnIcon", "getOnIconDisabled", "getOffIcon", "getOffIconDisabled", "getFlatIcon", "getTextShort", "getOnIconV2", "getOffIconV2", "getDisabledIconV2", "getOnIconDisabledV2", "AIR_PURIFY", "HEAT", "COOL", "HUM", "SMART", "PREVIOUS", "STANDBY", "FAN_SPEED", "AUTO", "WATERDROP_AUTO", "NIGHT", "ECO", "SKIN", "CHILD_LOCK", "DISINFECTION", "DRYING", "CONTINUOUS", "BOOST", "toMainMode", "Lcom/blueair/core/model/MainMode;", "toApSubMode", "Lcom/blueair/core/model/ApSubMode;", "toCoolSubMode", "Lcom/blueair/core/model/CoolSubMode;", "toDehSubMode", "Lcom/blueair/core/model/DehSubMode;", "toHumSubMode", "Lcom/blueair/core/model/HumSubMode;", "toMode", "Lcom/blueair/core/model/Mode;", "proofread", "device", "Lcom/blueair/core/model/Device;", "obtainIconV2Res", "on", "", "disable", "Companion", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum ModeIcon {
   private static final EnumEntries $ENTRIES;
   private static final ModeIcon[] $VALUES;
   AIR_PURIFY(R.string.main_mode_ap, R.drawable.mode_icon_purify_on, R.drawable.mode_icon_purify_on_disabled, R.drawable.mode_icon_purify_off, R.drawable.mode_icon_purify_off_disabled, R.drawable.mode_icon_purify_flat, R.string.main_mode_ap_short, R.drawable.mode_icon_v2_purify_on, R.drawable.mode_icon_v2_purify_off, R.drawable.mode_icon_v2_purify_disabled, 0, 1024, (DefaultConstructorMarker)null),
   AUTO(R.string.auto, R.drawable.mode_icon_auto_on, R.drawable.mode_icon_auto_on_disabled, R.drawable.mode_icon_auto_off, R.drawable.mode_icon_auto_off_disabled, R.drawable.mode_icon_auto_flat, 0, R.drawable.mode_icon_v2_auto_on, R.drawable.mode_icon_v2_auto_off, R.drawable.mode_icon_v2_auto_disabled, R.drawable.mode_icon_v2_auto_on_disabled, 64, (DefaultConstructorMarker)null),
   BOOST(R.string.boost, R.drawable.mode_icon_boost_on, R.drawable.mode_icon_boost_disabled, R.drawable.mode_icon_boost_off, R.drawable.mode_icon_boost_disabled, R.drawable.mode_icon_boost_flat, 0, R.drawable.mode_icon_boost_on, R.drawable.mode_icon_boost_off, R.drawable.mode_icon_boost_disabled, 0, 1088, (DefaultConstructorMarker)null),
   CHILD_LOCK(R.string.childlock_title, R.drawable.mode_icon_childlock_on, R.drawable.mode_icon_childlock_on_disabled, R.drawable.mode_icon_childlock_off, R.drawable.mode_icon_childlock_off_disabled, R.drawable.mode_icon_childlock_flat, 0, 0, 0, 0, 0, 1984, (DefaultConstructorMarker)null),
   CONTINUOUS(R.string.main_mode_continuous, R.drawable.mode_icon_cycle_on, R.drawable.mode_icon_cycle_on_disabled, R.drawable.mode_icon_cycle_off, R.drawable.mode_icon_cycle_off_disabled, R.drawable.mode_icon_cycle_flat, 0, R.drawable.mode_icon_v2_continuous_on, R.drawable.mode_icon_v2_continuous_off, R.drawable.mode_icon_v2_continuous_disabled, 0, 1088, (DefaultConstructorMarker)null),
   COOL(R.string.main_mode_cool, R.drawable.mode_icon_cool_on, R.drawable.mode_icon_cool_on_disabled, R.drawable.mode_icon_cool_off, R.drawable.mode_icon_cool_off_disabled, R.drawable.mode_icon_cool_flat, R.string.main_mode_cool_short, R.drawable.mode_icon_v2_cool_on, R.drawable.mode_icon_v2_cool_off, R.drawable.mode_icon_v2_cool_disabled, 0, 1024, (DefaultConstructorMarker)null);

   public static final Companion Companion;
   DISINFECTION(R.string.disinfection, R.drawable.mode_icon_disinfection_on, R.drawable.mode_icon_disinfection_on_disabled, R.drawable.mode_icon_disinfection_off, R.drawable.mode_icon_disinfection_off_disabled, R.drawable.mode_icon_disinfection_flat, 0, R.drawable.mode_icon_v2_disinfection_on, R.drawable.mode_icon_v2_disinfection_off, R.drawable.mode_icon_v2_disinfection_disabled, 0, 1088, (DefaultConstructorMarker)null),
   DRYING(R.string.main_mode_drying, R.drawable.mode_icon_clothes_on, R.drawable.mode_icon_clothes_on_disabled, R.drawable.mode_icon_clothes_off, R.drawable.mode_icon_clothes_off_disabled, R.drawable.mode_icon_clothes_flat, 0, R.drawable.mode_icon_v2_drying_on, R.drawable.mode_icon_v2_drying_off, R.drawable.mode_icon_v2_drying_disabled, 0, 1088, (DefaultConstructorMarker)null),
   ECO(R.string.eco, R.drawable.mode_icon_eco_on, R.drawable.mode_icon_eco_on_disabled, R.drawable.mode_icon_eco_off, R.drawable.mode_icon_eco_off_disabled, R.drawable.mode_icon_eco_flat, 0, R.drawable.mode_icon_v2_eco_on, R.drawable.mode_icon_v2_eco_off, R.drawable.mode_icon_v2_eco_disabled, 0, 1088, (DefaultConstructorMarker)null),
   FAN_SPEED(R.string.fan_speed, R.drawable.mode_icon_fanspeed_on, R.drawable.mode_icon_fanspeed_on_disabled, R.drawable.mode_icon_fanspeed_off, R.drawable.mode_icon_fanspeed_off_disabled, R.drawable.mode_icon_fanspeed_flat, R.string.fan, R.drawable.mode_icon_v2_fanspeed_on, R.drawable.mode_icon_v2_fanspeed_off, R.drawable.mode_icon_v2_fanspeed_disabled, R.drawable.mode_icon_v2_fanspeed_on_disabled),
   HEAT(R.string.main_mode_heat, R.drawable.mode_icon_heat_on, R.drawable.mode_icon_heat_on_disabled, R.drawable.mode_icon_heat_off, R.drawable.mode_icon_heat_off_disabled, R.drawable.mode_icon_heat_flat, R.string.main_mode_heat_short, R.drawable.mode_icon_v2_heat_on, R.drawable.mode_icon_v2_heat_off, R.drawable.mode_icon_v2_heat_disabled, R.drawable.mode_icon_v2_heat_on_disabled),
   HUM(R.string.purification_and_humidification, R.drawable.mode_icon_hum_on, R.drawable.mode_icon_hum_on_disabled, R.drawable.mode_icon_hum_off, R.drawable.mode_icon_hum_off_disabled, R.drawable.mode_icon_hum_flat, 0, 0, 0, 0, 0, 1984, (DefaultConstructorMarker)null),
   NIGHT(R.string.night, R.drawable.mode_icon_night_on, R.drawable.mode_icon_night_on_disabled, R.drawable.mode_icon_night_off, R.drawable.mode_icon_night_off_disabled, R.drawable.mode_icon_night_flat, 0, R.drawable.mode_icon_v2_night_on, R.drawable.mode_icon_v2_night_off, R.drawable.mode_icon_v2_night_disabled, 0, 1088, (DefaultConstructorMarker)null),
   PREVIOUS(R.string.schedule_previous, R.drawable.mode_icon_previous_on, R.drawable.mode_icon_previous_on_disabled, R.drawable.mode_icon_previous_off, R.drawable.mode_icon_previous_off_disabled, R.drawable.mode_icon_previous_flat, 0, 0, 0, 0, 0, 1984, (DefaultConstructorMarker)null),
   SKIN(R.string.skin, R.drawable.mode_icon_skin_on, R.drawable.mode_icon_skin_disabled, R.drawable.mode_icon_skin_off, R.drawable.mode_icon_skin_disabled, R.drawable.mode_icon_skin_flat, 0, 0, 0, 0, 0, 1984, (DefaultConstructorMarker)null),
   SMART(R.string.main_mode_smart, R.drawable.mode_icon_smart_on, R.drawable.mode_icon_smart_on_disabled, R.drawable.mode_icon_smart_off, R.drawable.mode_icon_smart_off_disabled, R.drawable.mode_icon_smart_flat, 0, R.drawable.mode_icon_v2_smart_on, R.drawable.mode_icon_v2_smart_off, R.drawable.mode_icon_v2_smart_disabled, 0, 1088, (DefaultConstructorMarker)null),
   STANDBY(R.string.stand_by, R.drawable.mode_icon_standby_on, R.drawable.mode_icon_standby_on_disabled, R.drawable.mode_icon_standby_off, R.drawable.mode_icon_standby_off_disabled, R.drawable.mode_icon_standby_flat, 0, R.drawable.mode_icon_v2_standby_on, R.drawable.mode_icon_v2_standby_off, R.drawable.mode_icon_v2_standby_disabled, 0, 1088, (DefaultConstructorMarker)null),
   WATERDROP_AUTO(R.string.auto, R.drawable.mode_icon_auto_on, R.drawable.mode_icon_auto_on_disabled, R.drawable.mode_icon_auto_off, R.drawable.mode_icon_auto_off_disabled, R.drawable.mode_icon_waterdrop_auto_flat, 0, R.drawable.mode_icon_waterdrop_auto_on, R.drawable.mode_icon_waterdrop_auto_off, R.drawable.mode_icon_waterdrop_auto_disabled, 0, 1088, (DefaultConstructorMarker)null);

   private final int disabledIconV2;
   private final int flatIcon;
   private final int offIcon;
   private final int offIconDisabled;
   private final int offIconV2;
   private final int onIcon;
   private final int onIconDisabled;
   private final int onIconDisabledV2;
   private final int onIconV2;
   private final int text;
   private final int textShort;

   // $FF: synthetic method
   private static final ModeIcon[] $values() {
      return new ModeIcon[]{AIR_PURIFY, HEAT, COOL, HUM, SMART, PREVIOUS, STANDBY, FAN_SPEED, AUTO, WATERDROP_AUTO, NIGHT, ECO, SKIN, CHILD_LOCK, DISINFECTION, DRYING, CONTINUOUS, BOOST};
   }

   static {
      ModeIcon[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
      Companion = new Companion((DefaultConstructorMarker)null);
   }

   private ModeIcon(int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13) {
      this.text = var3;
      this.onIcon = var4;
      this.onIconDisabled = var5;
      this.offIcon = var6;
      this.offIconDisabled = var7;
      this.flatIcon = var8;
      this.textShort = var9;
      this.onIconV2 = var10;
      this.offIconV2 = var11;
      this.disabledIconV2 = var12;
      this.onIconDisabledV2 = var13;
   }

   // $FF: synthetic method
   ModeIcon(int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, DefaultConstructorMarker var15) {
      if ((var14 & 64) != 0) {
         var9 = var3;
      }

      if ((var14 & 128) != 0) {
         var10 = var4;
      }

      if ((var14 & 256) != 0) {
         var11 = var6;
      }

      if ((var14 & 512) != 0) {
         var12 = var7;
      }

      if ((var14 & 1024) != 0) {
         var13 = var5;
      }

      this(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   // $FF: synthetic method
   public static int obtainIconV2Res$default(ModeIcon var0, boolean var1, boolean var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 2) != 0) {
            var2 = false;
         }

         return var0.obtainIconV2Res(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: obtainIconV2Res");
      }
   }

   public final int getDisabledIconV2() {
      return this.disabledIconV2;
   }

   public final int getFlatIcon() {
      return this.flatIcon;
   }

   public final int getOffIcon() {
      return this.offIcon;
   }

   public final int getOffIconDisabled() {
      return this.offIconDisabled;
   }

   public final int getOffIconV2() {
      return this.offIconV2;
   }

   public final int getOnIcon() {
      return this.onIcon;
   }

   public final int getOnIconDisabled() {
      return this.onIconDisabled;
   }

   public final int getOnIconDisabledV2() {
      return this.onIconDisabledV2;
   }

   public final int getOnIconV2() {
      return this.onIconV2;
   }

   public final int getText() {
      return this.text;
   }

   public final int getTextShort() {
      return this.textShort;
   }

   public final int obtainIconV2Res(boolean var1, boolean var2) {
      if (var1) {
         return var2 ? this.onIconDisabledV2 : this.onIconV2;
      } else {
         return var2 ? this.disabledIconV2 : this.offIconV2;
      }
   }

   public final ModeIcon proofread(Device var1) {
      if (var1 != null && DeviceKt.useWatetdropAuto(var1) && this == AUTO) {
         return WATERDROP_AUTO;
      } else {
         return this == DRYING && var1 instanceof DeviceDehumidifier && ((DeviceDehumidifier)var1).isUsDevice() ? BOOST : this;
      }
   }

   public final ApSubMode toApSubMode() {
      switch (ModeIcon.WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
         case 6:
            return ApSubMode.FAN;
         case 7:
         case 8:
            return ApSubMode.AUTO;
         case 9:
            return ApSubMode.NIGHT;
         case 10:
            return ApSubMode.ECO;
         default:
            return null;
      }
   }

   public final CoolSubMode toCoolSubMode() {
      switch (ModeIcon.WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
         case 6:
            return CoolSubMode.FAN;
         case 7:
         case 8:
            return CoolSubMode.AUTO;
         case 9:
            return CoolSubMode.NIGHT;
         default:
            return null;
      }
   }

   public final DehSubMode toDehSubMode() {
      switch (ModeIcon.WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
         case 7:
         case 8:
            return DehSubMode.AUTO;
         case 9:
         case 10:
         default:
            return null;
         case 11:
         case 12:
            return DehSubMode.DRYING;
         case 13:
            return DehSubMode.CONTINUOUS;
      }
   }

   public final HumSubMode toHumSubMode() {
      int var1 = ModeIcon.WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
      if (var1 != 14) {
         switch (var1) {
            case 6:
               return HumSubMode.FAN;
            case 7:
            case 8:
               return HumSubMode.AUTO;
            case 9:
               return HumSubMode.NIGHT;
            default:
               return null;
         }
      } else {
         return HumSubMode.SKIN;
      }
   }

   public final MainMode toMainMode() {
      int var1 = ModeIcon.WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
      if (var1 != 1) {
         if (var1 != 2) {
            if (var1 != 3) {
               if (var1 != 4) {
                  return var1 != 5 ? null : MainMode.Humidification;
               } else {
                  return MainMode.SMART;
               }
            } else {
               return MainMode.COOL;
            }
         } else {
            return MainMode.HEAT;
         }
      } else {
         return MainMode.AirPurify;
      }
   }

   public final Mode toMode() {
      int var1 = ModeIcon.WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
      if (var1 != 14) {
         switch (var1) {
            case 6:
               return Mode.FAN;
            case 7:
            case 8:
               return Mode.AUTO;
            case 9:
               return Mode.NIGHT;
            case 10:
               return Mode.ECO;
            default:
               return null;
         }
      } else {
         return Mode.SKIN;
      }
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/viewcore/utils/ModeIcon$Companion;", "", "<init>", "()V", "fromMainMode", "Lcom/blueair/viewcore/utils/ModeIcon;", "mainMode", "Lcom/blueair/core/model/MainMode;", "viewcore_otherRelease"},
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

      public final ModeIcon fromMainMode(MainMode var1) {
         Intrinsics.checkNotNullParameter(var1, "mainMode");
         int var2 = ModeIcon.Companion.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
         if (var2 != 1) {
            if (var2 != 2) {
               if (var2 != 3) {
                  return var2 != 4 ? ModeIcon.AIR_PURIFY : ModeIcon.HUM;
               } else {
                  return ModeIcon.SMART;
               }
            } else {
               return ModeIcon.COOL;
            }
         } else {
            return ModeIcon.HEAT;
         }
      }

      // $FF: synthetic class
      @Metadata(
         k = 3,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class WhenMappings {
         public static final int[] $EnumSwitchMapping$0;

         static {
            int[] var0 = new int[MainMode.values().length];

            try {
               var0[MainMode.HEAT.ordinal()] = 1;
            } catch (NoSuchFieldError var5) {
            }

            try {
               var0[MainMode.COOL.ordinal()] = 2;
            } catch (NoSuchFieldError var4) {
            }

            try {
               var0[MainMode.SMART.ordinal()] = 3;
            } catch (NoSuchFieldError var3) {
            }

            try {
               var0[MainMode.Humidification.ordinal()] = 4;
            } catch (NoSuchFieldError var2) {
            }

            $EnumSwitchMapping$0 = var0;
         }
      }
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[ModeIcon.values().length];

         try {
            var0[ModeIcon.AIR_PURIFY.ordinal()] = 1;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[ModeIcon.HEAT.ordinal()] = 2;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[ModeIcon.COOL.ordinal()] = 3;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[ModeIcon.SMART.ordinal()] = 4;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[ModeIcon.HUM.ordinal()] = 5;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[ModeIcon.FAN_SPEED.ordinal()] = 6;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[ModeIcon.AUTO.ordinal()] = 7;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[ModeIcon.WATERDROP_AUTO.ordinal()] = 8;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[ModeIcon.NIGHT.ordinal()] = 9;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[ModeIcon.ECO.ordinal()] = 10;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[ModeIcon.DRYING.ordinal()] = 11;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[ModeIcon.BOOST.ordinal()] = 12;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[ModeIcon.CONTINUOUS.ordinal()] = 13;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[ModeIcon.SKIN.ordinal()] = 14;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
