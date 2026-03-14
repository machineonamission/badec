package com.blueair.core.model;

import android.content.Context;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

// $FF: synthetic class
public final class HasMainMode$_CC {
   public static ApSubMode $default$apSubMode(HasMainMode var0) {
      Iterator var2 = ((Iterable)ApSubMode.getEntries()).iterator();

      while(true) {
         if (var2.hasNext()) {
            Object var1 = var2.next();
            if (((ApSubMode)var1).getValue() != var0.getApSubMode()) {
               continue;
            }

            var3 = var1;
            break;
         }

         var3 = null;
         break;
      }

      ApSubMode var4 = (ApSubMode)var3;
      return var4 == null ? ApSubMode.FAN : var4;
   }

   public static boolean $default$isInApSubMode(HasMainMode var0, ApSubMode var1) {
      Intrinsics.checkNotNullParameter(var1, "subMode");
      return var0.getApSubMode() == var1.getValue();
   }

   public static boolean $default$isInMainMode(HasMainMode var0, MainMode var1) {
      Intrinsics.checkNotNullParameter(var1, "mainMode");
      return var0.getMainMode() == var1.getValue();
   }

   public static MainMode $default$mainMode(HasMainMode var0) {
      Iterator var2 = ((Iterable)MainMode.getEntries()).iterator();

      while(true) {
         if (var2.hasNext()) {
            Object var1 = var2.next();
            if (((MainMode)var1).getValue() != var0.getMainMode()) {
               continue;
            }

            var3 = var1;
            break;
         }

         var3 = null;
         break;
      }

      MainMode var4 = (MainMode)var3;
      return var4 == null ? MainMode.AirPurify : var4;
   }

   // $FF: synthetic method
   public static ApSubMode access$apSubMode$jd(HasMainMode var0) {
      return $default$apSubMode(var0);
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(HasMainMode var0) {
      return Device$_CC.$default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(HasMainMode var0, Context var1) {
      return Device$_CC.$default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(HasMainMode var0) {
      return Device$_CC.$default$getType(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(HasMainMode var0) {
      return Device$_CC.$default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isInApSubMode$jd(HasMainMode var0, ApSubMode var1) {
      return $default$isInApSubMode(var0, var1);
   }

   // $FF: synthetic method
   public static boolean access$isInMainMode$jd(HasMainMode var0, MainMode var1) {
      return $default$isInMainMode(var0, var1);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(HasMainMode var0) {
      return Device$_CC.$default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(HasMainMode var0) {
      return Device$_CC.$default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static MainMode access$mainMode$jd(HasMainMode var0) {
      return $default$mainMode(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(HasMainMode var0) {
      return Device$_CC.$default$supportResetFilterOnline(var0);
   }
}
