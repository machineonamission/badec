package com.blueair.devicedetails.util;

import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.CoolSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo3in1;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceFanTable;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceHumidifier20;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceMiniRestful;
import com.blueair.core.model.HasAirRefresh;
import com.blueair.core.model.HasAlarm;
import com.blueair.core.model.HasBody;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasCoolMainMode;
import com.blueair.core.model.HasDualOscillation;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasGermShieldMode;
import com.blueair.core.model.HasHinsMode;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasHumMode;
import com.blueair.core.model.HasMoodLamp;
import com.blueair.core.model.HasNightLamp;
import com.blueair.core.model.HasOscillation;
import com.blueair.core.model.HasPetMainMode;
import com.blueair.core.model.HasRemoveYellowWater;
import com.blueair.core.model.HasWaterLevel;
import com.blueair.core.model.HasWaterTank;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.HasWickDryDuration;
import com.blueair.core.model.HumSubMode;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.WaterLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(
   d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¨\u0006\u0006"},
   d2 = {"supportControl", "", "Lcom/blueair/core/model/Device;", "control", "Lcom/blueair/devicedetails/util/DeviceControl;", "forceOffline", "devicedetails_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceControlKt {
   // $FF: synthetic method
   public static final boolean access$supportControl(Device var0, DeviceControl var1, boolean var2) {
      return supportControl(var0, var1, var2);
   }

   private static final boolean supportControl(Device var0, DeviceControl var1, boolean var2) {
      if (var0.getConnectivityStatus() == ConnectivityStatus.ONLINE && !var2) {
         var2 = false;
      } else {
         var2 = true;
      }

      int var3 = DeviceControlKt.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
      HasBody var6 = null;
      Boolean var4 = null;
      Object var5 = null;
      switch (var3) {
         case 1:
            return var2;
         case 2:
            return var0 instanceof HasAirRefresh;
         case 3:
            return DeviceKt.hasAirFilter(var0);
         case 4:
            return var0 instanceof HasWick;
         case 5:
            HasRemoveYellowWater var9;
            if (var0 instanceof HasRemoveYellowWater) {
               var9 = (HasRemoveYellowWater)var0;
            } else {
               var9 = null;
            }

            if (var9 != null) {
               var4 = var9.getYwrmEnabled();
            }

            if (var4 == null || var0 instanceof DeviceHumidifier20 && var0.isCnDevice()) {
               return false;
            }

            return true;
         case 6:
            if (!var2 && !DeviceKt.isStandByOn(var0) && DeviceControlUtils.INSTANCE.shouldShowBrightness(var0)) {
               if (var0 instanceof HasBody) {
                  var6 = (HasBody)var0;
               }

               if (var6 == null || var6.getBodyMounted()) {
                  return true;
               }
            }

            return false;
         case 7:
            if (!var2 && !DeviceKt.isStandByOn(var0) && DeviceControlUtils.INSTANCE.isFanMode(var0) && !DeviceControlUtils.INSTANCE.shouldHideFanSpeed(var0)) {
               return true;
            }

            return false;
         case 8:
            if (!var2 && !DeviceKt.isStandByOn(var0) && DeviceControlUtils.INSTANCE.shouldShowTimer(var0)) {
               return true;
            }

            return false;
         case 9:
            if (!(var0 instanceof DeviceDehumidifier) && !(var0 instanceof HasWick)) {
               return false;
            }

            return true;
         case 10:
            return var0 instanceof DeviceDehumidifier;
         case 11:
            if (var0 instanceof DeviceDehumidifier && ((DeviceDehumidifier)var0).isInWaterLevel(WaterLevel.FULL)) {
               return true;
            }

            return false;
         case 12:
            if (var0 instanceof HasWaterTank && ((HasWaterTank)var0).getWaterTankFailure()) {
               return true;
            }

            return false;
         case 13:
            if ((!(var0 instanceof HasWaterLevel) || var0 instanceof DeviceDehumidifier || !((HasWaterLevel)var0).isInWaterLevel(WaterLevel.SHORTAGE)) && (!(var0 instanceof DeviceHumidifier) || !((DeviceHumidifier)var0).getWaterShortage())) {
               return false;
            }

            return true;
         case 14:
            return var0 instanceof HasMoodLamp;
         case 15:
            return var0 instanceof HasNightLamp;
         case 16:
            return var0 instanceof HasAlarm;
         case 17:
            return var0 instanceof HasWickDryDuration;
         case 18:
            if (var0 instanceof DeviceMiniRestful && !((DeviceMiniRestful)var0).hasNightMode()) {
               return false;
            }

            return true;
         case 19:
            return var0 instanceof HasCombo3in1MainMode;
         case 20:
            if (!(var0 instanceof HasWick) || var0 instanceof HasWickDryDuration || var2 && var0 instanceof DeviceHumidifier) {
               return false;
            }

            return true;
         case 21:
            if (!var2 && !DeviceKt.isStandByOn(var0) && DeviceKt.isDisinfectionOn(var0)) {
               return true;
            }

            return false;
         case 22:
            if (!(var0 instanceof HasHumMode) && !(var0 instanceof HasHumMainMode)) {
               return false;
            }

            return true;
         case 23:
            return var0 instanceof HasHinsMode;
         case 24:
            if (!var2 && !DeviceKt.isStandByOn(var0) && var0 instanceof HasHinsMode && var0 instanceof HasG4NightMode && ((HasG4NightMode)var0).isG4NightModeOn()) {
               return true;
            }

            return false;
         case 25:
            if (var0 instanceof HasHumMainMode) {
               HasHumMainMode var8 = (HasHumMainMode)var0;
               if (var8.isInHumSubMode(HumSubMode.SKIN) && var8.isInMainMode(MainMode.Humidification) && !DeviceKt.isStandByOn(var0)) {
                  return true;
               }
            }

            return false;
         case 26:
            if (var0 instanceof HasPetMainMode && ((HasPetMainMode)var0).isInMainMode(MainMode.SMART) && !DeviceKt.isStandByOn(var0)) {
               var6 = (HasBody)var5;
               if (var0 instanceof HasBody) {
                  var6 = (HasBody)var0;
               }

               if (var6 == null || var6.getBodyMounted()) {
                  return true;
               }
            }

            return false;
         case 27:
            if (var0 instanceof HasCombo3in1MainMode && ((HasCombo3in1MainMode)var0).isInMainMode(MainMode.HEAT) && !var2 && !DeviceKt.isStandByOn(var0)) {
               return true;
            }

            return false;
         case 28:
            if (var0 instanceof HasCombo3in1MainMode && !((HasCombo3in1MainMode)var0).isInMainMode(MainMode.HEAT) && var0.isUsDevice() && !var2 && !DeviceKt.isStandByOn(var0)) {
               return true;
            }

            return false;
         case 29:
            if (!DeviceKt.isSafetySwitchOn(var0) && !DeviceKt.hasFrontPanel(var0)) {
               return true;
            }

            return false;
         case 30:
            if (!DeviceKt.isSafetySwitchOn(var0) && DeviceKt.hasFrontPanel(var0)) {
               return true;
            }

            return false;
         case 31:
            if (var0 instanceof HasBody && !((HasBody)var0).getBodyMounted()) {
               return true;
            }

            return false;
         case 32:
            return var0 instanceof HasOscillation;
         case 33:
            return var0 instanceof DeviceCombo3in1;
         case 34:
            return var0 instanceof HasGermShieldMode;
         case 35:
            if (!var2 && !DeviceKt.isStandByOn(var0) && var0 instanceof HasGermShieldMode && ((HasGermShieldMode)var0).getHasGermShieldNightMode() && var0 instanceof HasG4NightMode && ((HasG4NightMode)var0).isG4NightModeOn() && !DeviceKt.isDisinfectionOn(var0)) {
               return true;
            }

            return false;
         case 36:
            if (!var2 && !DeviceKt.isStandByOn(var0) && var0 instanceof HasDualOscillation && DeviceControlUtils.INSTANCE.isFanMode(var0)) {
               return true;
            }

            return false;
         case 37:
            if (!var2 && !DeviceKt.isStandByOn(var0) && var0 instanceof HasCoolMainMode && ((HasCoolMainMode)var0).isInSubMode(CoolSubMode.AUTO)) {
               return true;
            }

            return false;
         case 38:
            if (!var2 && !DeviceKt.isStandByOn(var0) && var0 instanceof DeviceFanTable && ((DeviceFanTable)var0).isInSubMode(CoolSubMode.NIGHT)) {
               return true;
            }

            return false;
         case 39:
         case 40:
            return true;
         default:
            throw new NoWhenBranchMatchedException();
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
         int[] var0 = new int[DeviceControl.values().length];

         try {
            var0[DeviceControl.OFFLINE.ordinal()] = 1;
         } catch (NoSuchFieldError var41) {
         }

         try {
            var0[DeviceControl.AUTO_REFRESH.ordinal()] = 2;
         } catch (NoSuchFieldError var40) {
         }

         try {
            var0[DeviceControl.FILTER.ordinal()] = 3;
         } catch (NoSuchFieldError var39) {
         }

         try {
            var0[DeviceControl.WICK.ordinal()] = 4;
         } catch (NoSuchFieldError var38) {
         }

         try {
            var0[DeviceControl.REFRESHER.ordinal()] = 5;
         } catch (NoSuchFieldError var37) {
         }

         try {
            var0[DeviceControl.BRIGHTNESS.ordinal()] = 6;
         } catch (NoSuchFieldError var36) {
         }

         try {
            var0[DeviceControl.FAN_SPEED.ordinal()] = 7;
         } catch (NoSuchFieldError var35) {
         }

         try {
            var0[DeviceControl.TIMER.ordinal()] = 8;
         } catch (NoSuchFieldError var34) {
         }

         try {
            var0[DeviceControl.TARGET_HUM.ordinal()] = 9;
         } catch (NoSuchFieldError var33) {
         }

         try {
            var0[DeviceControl.MAIN_MODES_DEHUM.ordinal()] = 10;
         } catch (NoSuchFieldError var32) {
         }

         try {
            var0[DeviceControl.MSG_WATER_TANK_FULL.ordinal()] = 11;
         } catch (NoSuchFieldError var31) {
         }

         try {
            var0[DeviceControl.MSG_WATER_TANK_FAILURE.ordinal()] = 12;
         } catch (NoSuchFieldError var30) {
         }

         try {
            var0[DeviceControl.MSG_WATER_TANK_SHORTAGE.ordinal()] = 13;
         } catch (NoSuchFieldError var29) {
         }

         try {
            var0[DeviceControl.MOOD_LAMP.ordinal()] = 14;
         } catch (NoSuchFieldError var28) {
         }

         try {
            var0[DeviceControl.NIGHT_LAMP.ordinal()] = 15;
         } catch (NoSuchFieldError var27) {
         }

         try {
            var0[DeviceControl.ALARMS.ordinal()] = 16;
         } catch (NoSuchFieldError var26) {
         }

         try {
            var0[DeviceControl.WICK_DRYING.ordinal()] = 17;
         } catch (NoSuchFieldError var25) {
         }

         try {
            var0[DeviceControl.MODE_BUTTONS.ordinal()] = 18;
         } catch (NoSuchFieldError var24) {
         }

         try {
            var0[DeviceControl.MAIN_MODES_COMBO3IN1.ordinal()] = 19;
         } catch (NoSuchFieldError var23) {
         }

         try {
            var0[DeviceControl.AUTO_DRY.ordinal()] = 20;
         } catch (NoSuchFieldError var22) {
         }

         try {
            var0[DeviceControl.DISINFECTION.ordinal()] = 21;
         } catch (NoSuchFieldError var21) {
         }

         try {
            var0[DeviceControl.MODE_HUMIDIFICATION.ordinal()] = 22;
         } catch (NoSuchFieldError var20) {
         }

         try {
            var0[DeviceControl.HINS_PURE.ordinal()] = 23;
         } catch (NoSuchFieldError var19) {
         }

         try {
            var0[DeviceControl.HINS_PURE_NIGHT.ordinal()] = 24;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[DeviceControl.SKIN_HINT.ordinal()] = 25;
         } catch (NoSuchFieldError var17) {
         }

         try {
            var0[DeviceControl.SMART_HINT.ordinal()] = 26;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[DeviceControl.HEATING_HINT.ordinal()] = 27;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[DeviceControl.CANT_HEAT_HINT.ordinal()] = 28;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[DeviceControl.MSG_FILTER_DOOR_OPEN.ordinal()] = 29;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[DeviceControl.MSG_FRONT_PANEL_OPEN.ordinal()] = 30;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[DeviceControl.MSG_TOP_PART_DISPLACED.ordinal()] = 31;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[DeviceControl.OSCILLATION.ordinal()] = 32;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[DeviceControl.TARGET_TEMPERATURE.ordinal()] = 33;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[DeviceControl.GERM_SHIELD.ordinal()] = 34;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[DeviceControl.GERM_SHIELD_NIGHT.ordinal()] = 35;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[DeviceControl.DUAL_OSCILLATION.ordinal()] = 36;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[DeviceControl.AUTO_LEVEL.ordinal()] = 37;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[DeviceControl.NIGHT_SLEEP.ordinal()] = 38;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[DeviceControl.SCHEDULE.ordinal()] = 39;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DeviceControl.SETTINGS.ordinal()] = 40;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
