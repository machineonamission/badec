package com.blueair.core.model;

import android.content.Context;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

// $FF: synthetic class
public final class HasCombo3in1MainMode$_CC {
   public static int $default$currentFanSpeed(HasCombo3in1MainMode var0) {
      MainMode var2 = var0.mainMode();
      int var1 = HasCombo3in1MainMode.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
      if (var1 != 1) {
         if (var1 != 2) {
            return var1 != 3 ? var0.getApFanSpeed() : var0.getCoolFanSpeed();
         } else {
            return var0.getHeatFanSpeed();
         }
      } else {
         return var0.getApFanSpeed();
      }
   }

   public static FanSpeedEnum $default$currentFanSpeedEnum(HasCombo3in1MainMode var0) {
      return FanSpeedEnum.Companion.fromServerValue(var0, var0.currentFanSpeed());
   }

   public static ApSubMode $default$currentSubMode(HasCombo3in1MainMode var0) {
      MainMode var2 = var0.mainMode();
      int var1 = HasCombo3in1MainMode.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
      if (var1 != 1) {
         if (var1 != 2) {
            if (var1 != 3) {
               var1 = var0.getApSubMode();
            } else {
               var1 = var0.getCoolSubMode();
            }
         } else {
            var1 = var0.getHeatSubMode();
         }
      } else {
         var1 = var0.getApSubMode();
      }

      Iterator var6 = ((Iterable)ApSubMode.getEntries()).iterator();

      do {
         if (!var6.hasNext()) {
            var3 = null;
            break;
         }

         var3 = var6.next();
      } while(((ApSubMode)var3).getValue() != var1);

      ApSubMode var4 = (ApSubMode)var3;
      return var4 == null ? ApSubMode.FAN : var4;
   }

   public static boolean $default$isInSubMode(HasCombo3in1MainMode var0, ApSubMode var1) {
      Intrinsics.checkNotNullParameter(var1, "subMode");
      return var0.currentSubMode() == var1;
   }

   // $FF: synthetic method
   public static ApSubMode access$apSubMode$jd(HasCombo3in1MainMode var0) {
      return HasMainMode$_CC.$default$apSubMode(var0);
   }

   // $FF: synthetic method
   public static int access$currentFanSpeed$jd(HasCombo3in1MainMode var0) {
      return $default$currentFanSpeed(var0);
   }

   // $FF: synthetic method
   public static FanSpeedEnum access$currentFanSpeedEnum$jd(HasCombo3in1MainMode var0) {
      return $default$currentFanSpeedEnum(var0);
   }

   // $FF: synthetic method
   public static ApSubMode access$currentSubMode$jd(HasCombo3in1MainMode var0) {
      return $default$currentSubMode(var0);
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(HasCombo3in1MainMode var0) {
      return Device$_CC.$default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(HasCombo3in1MainMode var0, Context var1) {
      return Device$_CC.$default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(HasCombo3in1MainMode var0) {
      return Device$_CC.$default$getType(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(HasCombo3in1MainMode var0) {
      return Device$_CC.$default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isInApSubMode$jd(HasCombo3in1MainMode var0, ApSubMode var1) {
      return HasMainMode$_CC.$default$isInApSubMode(var0, var1);
   }

   // $FF: synthetic method
   public static boolean access$isInMainMode$jd(HasCombo3in1MainMode var0, MainMode var1) {
      return HasMainMode$_CC.$default$isInMainMode(var0, var1);
   }

   // $FF: synthetic method
   public static boolean access$isInSubMode$jd(HasCombo3in1MainMode var0, ApSubMode var1) {
      return $default$isInSubMode(var0, var1);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(HasCombo3in1MainMode var0) {
      return Device$_CC.$default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(HasCombo3in1MainMode var0) {
      return Device$_CC.$default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static MainMode access$mainMode$jd(HasCombo3in1MainMode var0) {
      return HasMainMode$_CC.$default$mainMode(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(HasCombo3in1MainMode var0) {
      return Device$_CC.$default$supportResetFilterOnline(var0);
   }
}
