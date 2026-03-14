package com.blueair.core.model;

import android.content.Context;
import java.util.Iterator;
import java.util.TimeZone;

// $FF: synthetic class
public final class HasPetMainMode$_CC {
   public static SmartSubMode $default$smartSubMode(HasPetMainMode var0) {
      Iterator var2 = ((Iterable)SmartSubMode.getEntries()).iterator();

      while(true) {
         if (var2.hasNext()) {
            Object var1 = var2.next();
            if (((SmartSubMode)var1).getValue() != var0.getSmartSubMode()) {
               continue;
            }

            var3 = var1;
            break;
         }

         var3 = null;
         break;
      }

      SmartSubMode var4 = (SmartSubMode)var3;
      return var4 == null ? SmartSubMode.AUTO_ON : var4;
   }

   // $FF: synthetic method
   public static ApSubMode access$apSubMode$jd(HasPetMainMode var0) {
      return HasMainMode$_CC.$default$apSubMode(var0);
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(HasPetMainMode var0) {
      return Device$_CC.$default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(HasPetMainMode var0, Context var1) {
      return Device$_CC.$default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(HasPetMainMode var0) {
      return Device$_CC.$default$getType(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(HasPetMainMode var0) {
      return Device$_CC.$default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isInApSubMode$jd(HasPetMainMode var0, ApSubMode var1) {
      return HasMainMode$_CC.$default$isInApSubMode(var0, var1);
   }

   // $FF: synthetic method
   public static boolean access$isInMainMode$jd(HasPetMainMode var0, MainMode var1) {
      return HasMainMode$_CC.$default$isInMainMode(var0, var1);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(HasPetMainMode var0) {
      return Device$_CC.$default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(HasPetMainMode var0) {
      return Device$_CC.$default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static MainMode access$mainMode$jd(HasPetMainMode var0) {
      return HasMainMode$_CC.$default$mainMode(var0);
   }

   // $FF: synthetic method
   public static SmartSubMode access$smartSubMode$jd(HasPetMainMode var0) {
      return $default$smartSubMode(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(HasPetMainMode var0) {
      return Device$_CC.$default$supportResetFilterOnline(var0);
   }
}
