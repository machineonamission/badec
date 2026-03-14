package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.ranges.RangesKt;

// $FF: synthetic class
public final class HasWick$_CC {
   public static int $default$getWickDryLeftSeconds(HasWick var0) {
      return RangesKt.coerceAtLeast((int)((long)var0.getWickdryLeftTime() - (System.currentTimeMillis() / (long)1000 - var0.getWickdryLeftTimeUpdateTime())), 0);
   }

   public static int $default$getWickLifeLeft(HasWick var0) {
      return RangesKt.coerceIn(100 - var0.getWickUsage(), 0, 100);
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(HasWick var0) {
      return Device$_CC.$default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(HasWick var0, Context var1) {
      return Device$_CC.$default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(HasWick var0) {
      return Device$_CC.$default$getType(var0);
   }

   // $FF: synthetic method
   public static int access$getWickDryLeftSeconds$jd(HasWick var0) {
      return $default$getWickDryLeftSeconds(var0);
   }

   // $FF: synthetic method
   public static int access$getWickLifeLeft$jd(HasWick var0) {
      return $default$getWickLifeLeft(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(HasWick var0) {
      return Device$_CC.$default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(HasWick var0) {
      return Device$_CC.$default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(HasWick var0) {
      return Device$_CC.$default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(HasWick var0) {
      return Device$_CC.$default$supportResetFilterOnline(var0);
   }
}
