package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.util.SkuConfigurationManager;
import java.util.TimeZone;

// $FF: synthetic class
public final class HasGermShieldMode$_CC {
   public static boolean $default$getHasGermShieldNightMode(HasGermShieldMode var0) {
      return SkuConfigurationManager.INSTANCE.getConfig().skuSupportGermShieldNightMode(DeviceKt.getSkuCompat(var0));
   }

   public static boolean $default$isGermShieldPlus(HasGermShieldMode var0) {
      return SkuConfigurationManager.INSTANCE.getConfig().skuSupportGermShieldPlus(DeviceKt.getSkuCompat(var0));
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(HasGermShieldMode var0) {
      return Device$_CC.$default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static boolean access$getHasGermShieldNightMode$jd(HasGermShieldMode var0) {
      return $default$getHasGermShieldNightMode(var0);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(HasGermShieldMode var0, Context var1) {
      return Device$_CC.$default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(HasGermShieldMode var0) {
      return Device$_CC.$default$getType(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(HasGermShieldMode var0) {
      return Device$_CC.$default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isGermShieldPlus$jd(HasGermShieldMode var0) {
      return $default$isGermShieldPlus(var0);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(HasGermShieldMode var0) {
      return Device$_CC.$default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(HasGermShieldMode var0) {
      return Device$_CC.$default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(HasGermShieldMode var0) {
      return Device$_CC.$default$supportResetFilterOnline(var0);
   }
}
