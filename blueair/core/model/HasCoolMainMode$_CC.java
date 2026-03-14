package com.blueair.core.model;

import android.content.Context;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

// $FF: synthetic class
public final class HasCoolMainMode$_CC {
   public static FanSpeedEnum $default$coolFanSpeedEnum(HasCoolMainMode var0) {
      return FanSpeedEnum.Companion.fromServerValue(var0, var0.getCoolFanSpeedLevel());
   }

   public static CoolSubMode $default$coolSubMode(HasCoolMainMode var0) {
      Iterator var2 = ((Iterable)CoolSubMode.getEntries()).iterator();

      while(true) {
         if (var2.hasNext()) {
            Object var1 = var2.next();
            if (((CoolSubMode)var1).getValue() != var0.getCoolSubMode()) {
               continue;
            }

            var3 = var1;
            break;
         }

         var3 = null;
         break;
      }

      CoolSubMode var4 = (CoolSubMode)var3;
      return var4 == null ? CoolSubMode.AUTO : var4;
   }

   public static boolean $default$isInSubMode(HasCoolMainMode var0, CoolSubMode var1) {
      Intrinsics.checkNotNullParameter(var1, "subMode");
      return var0.coolSubMode() == var1;
   }

   // $FF: synthetic method
   public static ApSubMode access$apSubMode$jd(HasCoolMainMode var0) {
      return HasMainMode$_CC.$default$apSubMode(var0);
   }

   // $FF: synthetic method
   public static FanSpeedEnum access$coolFanSpeedEnum$jd(HasCoolMainMode var0) {
      return $default$coolFanSpeedEnum(var0);
   }

   // $FF: synthetic method
   public static CoolSubMode access$coolSubMode$jd(HasCoolMainMode var0) {
      return $default$coolSubMode(var0);
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(HasCoolMainMode var0) {
      return Device$_CC.$default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(HasCoolMainMode var0, Context var1) {
      return Device$_CC.$default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(HasCoolMainMode var0) {
      return Device$_CC.$default$getType(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(HasCoolMainMode var0) {
      return Device$_CC.$default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isInApSubMode$jd(HasCoolMainMode var0, ApSubMode var1) {
      return HasMainMode$_CC.$default$isInApSubMode(var0, var1);
   }

   // $FF: synthetic method
   public static boolean access$isInMainMode$jd(HasCoolMainMode var0, MainMode var1) {
      return HasMainMode$_CC.$default$isInMainMode(var0, var1);
   }

   // $FF: synthetic method
   public static boolean access$isInSubMode$jd(HasCoolMainMode var0, CoolSubMode var1) {
      return $default$isInSubMode(var0, var1);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(HasCoolMainMode var0) {
      return Device$_CC.$default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(HasCoolMainMode var0) {
      return Device$_CC.$default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static MainMode access$mainMode$jd(HasCoolMainMode var0) {
      return HasMainMode$_CC.$default$mainMode(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(HasCoolMainMode var0) {
      return Device$_CC.$default$supportResetFilterOnline(var0);
   }
}
