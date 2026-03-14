package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;

// $FF: synthetic class
public final class HasBrightness$_CC {
   public static Brightness $default$getBrightnessEnum(HasBrightness var0) {
      return Brightness.Companion.fromServerValue(var0, var0.getBrightness());
   }

   // $FF: synthetic method
   public static Brightness access$getBrightnessEnum$jd(HasBrightness var0) {
      return $default$getBrightnessEnum(var0);
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(HasBrightness var0) {
      return Device$_CC.$default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(HasBrightness var0, Context var1) {
      return Device$_CC.$default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(HasBrightness var0) {
      return Device$_CC.$default$getType(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(HasBrightness var0) {
      return Device$_CC.$default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(HasBrightness var0) {
      return Device$_CC.$default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(HasBrightness var0) {
      return Device$_CC.$default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(HasBrightness var0) {
      return Device$_CC.$default$supportResetFilterOnline(var0);
   }
}
