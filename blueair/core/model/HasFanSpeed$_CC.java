package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;

// $FF: synthetic class
public final class HasFanSpeed$_CC {
   public static AutoMode $default$getAutoMode(HasFanSpeed var0) {
      return AutoMode.Companion.from(var0, var0.getAutoModeText());
   }

   public static FanSpeedEnum $default$getFanSpeedEnum(HasFanSpeed var0) {
      return FanSpeedEnum.Companion.fromServerValue(var0, var0.getFanSpeed());
   }

   public static Filter $default$getFilter(HasFanSpeed var0) {
      return Filter.Companion.fromServerValue(var0.getFilterType());
   }

   public static boolean $default$getHasGear0(HasFanSpeed var0) {
      return !(var0 instanceof DeviceHumidifier20) && !(var0 instanceof DeviceCombo2in120) && !(var0 instanceof DevicePet20) && (!(var0 instanceof DeviceMiniRestful) || !((DeviceMiniRestful)var0).hasNightMode());
   }

   public static boolean $default$getHasGear4(HasFanSpeed var0) {
      return var0 instanceof DeviceBlue && ((DeviceBlue)var0).isPremium() || var0 instanceof DeviceG4 && ((DeviceG4)var0).isPlus() || var0 instanceof DeviceNewClassic || var0 instanceof DeviceCombo3in1 || var0 instanceof DeviceCombo2in1 || var0 instanceof DeviceBlue40 && !((DeviceBlue40)var0).isSmallSize() || var0 instanceof DeviceCombo2in120;
   }

   public static FilterTrigger $default$getTrigger(HasFanSpeed var0) {
      return FilterTrigger.Companion.fromServerValue(var0.getFilterTrigger());
   }

   public static UiAutoMode $default$getUiAutoMode(HasFanSpeed var0) {
      return UiAutoMode.Companion.from(var0, var0.getAutoModeText());
   }

   // $FF: synthetic method
   public static AutoMode access$getAutoMode$jd(HasFanSpeed var0) {
      return $default$getAutoMode(var0);
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(HasFanSpeed var0) {
      return Device$_CC.$default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static FanSpeedEnum access$getFanSpeedEnum$jd(HasFanSpeed var0) {
      return $default$getFanSpeedEnum(var0);
   }

   // $FF: synthetic method
   public static Filter access$getFilter$jd(HasFanSpeed var0) {
      return $default$getFilter(var0);
   }

   // $FF: synthetic method
   public static boolean access$getHasGear0$jd(HasFanSpeed var0) {
      return $default$getHasGear0(var0);
   }

   // $FF: synthetic method
   public static boolean access$getHasGear4$jd(HasFanSpeed var0) {
      return $default$getHasGear4(var0);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(HasFanSpeed var0, Context var1) {
      return Device$_CC.$default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static FilterTrigger access$getTrigger$jd(HasFanSpeed var0) {
      return $default$getTrigger(var0);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(HasFanSpeed var0) {
      return Device$_CC.$default$getType(var0);
   }

   // $FF: synthetic method
   public static UiAutoMode access$getUiAutoMode$jd(HasFanSpeed var0) {
      return $default$getUiAutoMode(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(HasFanSpeed var0) {
      return Device$_CC.$default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(HasFanSpeed var0) {
      return Device$_CC.$default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(HasFanSpeed var0) {
      return Device$_CC.$default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(HasFanSpeed var0) {
      return Device$_CC.$default$supportResetFilterOnline(var0);
   }
}
