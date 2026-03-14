package com.blueair.core.model;

import android.content.Context;
import java.util.Iterator;
import java.util.TimeZone;

// $FF: synthetic class
public final class HasOscillation$_CC {
   public static boolean $default$isOscillationEnabled(HasOscillation var0) {
      return var0.getOscillationState() == 1;
   }

   public static OscillationDirection $default$oscillationDirection(HasOscillation var0) {
      Iterator var2 = ((Iterable)OscillationDirection.getEntries()).iterator();

      while(true) {
         if (var2.hasNext()) {
            Object var1 = var2.next();
            if (((OscillationDirection)var1).getValue() != var0.getOscillationDirection()) {
               continue;
            }

            var3 = var1;
            break;
         }

         var3 = null;
         break;
      }

      OscillationDirection var4 = (OscillationDirection)var3;
      return var4 == null ? OscillationDirection.STRAIGHT : var4;
   }

   public static OscillationFanSpeed $default$oscillationFanSpeed(HasOscillation var0) {
      Iterator var2 = ((Iterable)OscillationFanSpeed.getEntries()).iterator();

      while(true) {
         if (var2.hasNext()) {
            Object var1 = var2.next();
            if (((OscillationFanSpeed)var1).getValue() != var0.getOscillationFanSpeed()) {
               continue;
            }

            var3 = var1;
            break;
         }

         var3 = null;
         break;
      }

      OscillationFanSpeed var4 = (OscillationFanSpeed)var3;
      return var4 == null ? OscillationFanSpeed.SPEED_1 : var4;
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(HasOscillation var0) {
      return Device$_CC.$default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(HasOscillation var0, Context var1) {
      return Device$_CC.$default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(HasOscillation var0) {
      return Device$_CC.$default$getType(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(HasOscillation var0) {
      return Device$_CC.$default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(HasOscillation var0) {
      return Device$_CC.$default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isOscillationEnabled$jd(HasOscillation var0) {
      return $default$isOscillationEnabled(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(HasOscillation var0) {
      return Device$_CC.$default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static OscillationDirection access$oscillationDirection$jd(HasOscillation var0) {
      return $default$oscillationDirection(var0);
   }

   // $FF: synthetic method
   public static OscillationFanSpeed access$oscillationFanSpeed$jd(HasOscillation var0) {
      return $default$oscillationFanSpeed(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(HasOscillation var0) {
      return Device$_CC.$default$supportResetFilterOnline(var0);
   }
}
