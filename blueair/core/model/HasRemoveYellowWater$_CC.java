package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.ranges.RangesKt;

// $FF: synthetic class
public final class HasRemoveYellowWater$_CC {
   public static int $default$getRefresherLifeLeft(HasRemoveYellowWater var0) {
      return RangesKt.coerceIn(100 - var0.getYwrmUsage(), 0, 100);
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(HasRemoveYellowWater var0) {
      return Device$_CC.$default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static int access$getRefresherLifeLeft$jd(HasRemoveYellowWater var0) {
      return $default$getRefresherLifeLeft(var0);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(HasRemoveYellowWater var0, Context var1) {
      return Device$_CC.$default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(HasRemoveYellowWater var0) {
      return Device$_CC.$default$getType(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(HasRemoveYellowWater var0) {
      return Device$_CC.$default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(HasRemoveYellowWater var0) {
      return Device$_CC.$default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(HasRemoveYellowWater var0) {
      return Device$_CC.$default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(HasRemoveYellowWater var0) {
      return Device$_CC.$default$supportResetFilterOnline(var0);
   }
}
