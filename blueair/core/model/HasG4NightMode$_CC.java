package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;

// $FF: synthetic class
public final class HasG4NightMode$_CC {
   public static FilterTrigger $default$getG4NightModeTrigger(HasG4NightMode var0) {
      return FilterTrigger.Companion.fromServerValue(var0.getG4NightModeFilterTrigger());
   }

   public static UiG4NightMode $default$getUiG4NightMode(HasG4NightMode var0) {
      return UiG4NightMode.Companion.from(var0);
   }

   // $FF: synthetic method
   public static AutoMode access$getAutoMode$jd(HasG4NightMode var0) {
      return HasFanSpeed$_CC.$default$getAutoMode(var0);
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(HasG4NightMode var0) {
      return Device$_CC.$default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static FanSpeedEnum access$getFanSpeedEnum$jd(HasG4NightMode var0) {
      return HasFanSpeed$_CC.$default$getFanSpeedEnum(var0);
   }

   // $FF: synthetic method
   public static Filter access$getFilter$jd(HasG4NightMode var0) {
      return HasFanSpeed$_CC.$default$getFilter(var0);
   }

   // $FF: synthetic method
   public static FilterTrigger access$getG4NightModeTrigger$jd(HasG4NightMode var0) {
      return $default$getG4NightModeTrigger(var0);
   }

   // $FF: synthetic method
   public static boolean access$getHasGear0$jd(HasG4NightMode var0) {
      return HasFanSpeed$_CC.$default$getHasGear0(var0);
   }

   // $FF: synthetic method
   public static boolean access$getHasGear4$jd(HasG4NightMode var0) {
      return HasFanSpeed$_CC.$default$getHasGear4(var0);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(HasG4NightMode var0, Context var1) {
      return Device$_CC.$default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static FilterTrigger access$getTrigger$jd(HasG4NightMode var0) {
      return HasFanSpeed$_CC.$default$getTrigger(var0);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(HasG4NightMode var0) {
      return Device$_CC.$default$getType(var0);
   }

   // $FF: synthetic method
   public static UiAutoMode access$getUiAutoMode$jd(HasG4NightMode var0) {
      return HasFanSpeed$_CC.$default$getUiAutoMode(var0);
   }

   // $FF: synthetic method
   public static UiG4NightMode access$getUiG4NightMode$jd(HasG4NightMode var0) {
      return $default$getUiG4NightMode(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(HasG4NightMode var0) {
      return Device$_CC.$default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(HasG4NightMode var0) {
      return Device$_CC.$default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(HasG4NightMode var0) {
      return Device$_CC.$default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(HasG4NightMode var0) {
      return Device$_CC.$default$supportResetFilterOnline(var0);
   }
}
