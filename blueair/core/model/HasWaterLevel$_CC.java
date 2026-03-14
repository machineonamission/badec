package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

// $FF: synthetic class
public final class HasWaterLevel$_CC {
   public static boolean $default$isInWaterLevel(HasWaterLevel var0, WaterLevel var1) {
      Intrinsics.checkNotNullParameter(var1, "waterLevel");
      return var1 == var0.waterLevel();
   }

   public static WaterLevel $default$waterLevel(HasWaterLevel var0) {
      return WaterLevel.Companion.fromValue(var0.getWaterLevel());
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(HasWaterLevel var0) {
      return Device$_CC.$default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(HasWaterLevel var0, Context var1) {
      return Device$_CC.$default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(HasWaterLevel var0) {
      return Device$_CC.$default$getType(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(HasWaterLevel var0) {
      return Device$_CC.$default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isInWaterLevel$jd(HasWaterLevel var0, WaterLevel var1) {
      return $default$isInWaterLevel(var0, var1);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(HasWaterLevel var0) {
      return Device$_CC.$default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(HasWaterLevel var0) {
      return Device$_CC.$default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(HasWaterLevel var0) {
      return Device$_CC.$default$supportResetFilterOnline(var0);
   }

   // $FF: synthetic method
   public static WaterLevel access$waterLevel$jd(HasWaterLevel var0) {
      return $default$waterLevel(var0);
   }
}
