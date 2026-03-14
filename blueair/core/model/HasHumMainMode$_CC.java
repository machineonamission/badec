package com.blueair.core.model;

import android.content.Context;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

// $FF: synthetic class
public final class HasHumMainMode$_CC {
   public static HumSubMode $default$humSubMode(HasHumMainMode var0) {
      Iterator var2 = ((Iterable)HumSubMode.getEntries()).iterator();

      while(true) {
         if (var2.hasNext()) {
            Object var1 = var2.next();
            if (((HumSubMode)var1).getValue() != var0.getHumSubMode()) {
               continue;
            }

            var3 = var1;
            break;
         }

         var3 = null;
         break;
      }

      HumSubMode var4 = (HumSubMode)var3;
      return var4 == null ? HumSubMode.AUTO : var4;
   }

   public static boolean $default$isInHumSubMode(HasHumMainMode var0, HumSubMode var1) {
      Intrinsics.checkNotNullParameter(var1, "subMode");
      return var0.getHumSubMode() == var1.getValue();
   }

   // $FF: synthetic method
   public static ApSubMode access$apSubMode$jd(HasHumMainMode var0) {
      return HasMainMode$_CC.$default$apSubMode(var0);
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(HasHumMainMode var0) {
      return Device$_CC.$default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(HasHumMainMode var0, Context var1) {
      return Device$_CC.$default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(HasHumMainMode var0) {
      return Device$_CC.$default$getType(var0);
   }

   // $FF: synthetic method
   public static HumSubMode access$humSubMode$jd(HasHumMainMode var0) {
      return $default$humSubMode(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(HasHumMainMode var0) {
      return Device$_CC.$default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isInApSubMode$jd(HasHumMainMode var0, ApSubMode var1) {
      return HasMainMode$_CC.$default$isInApSubMode(var0, var1);
   }

   // $FF: synthetic method
   public static boolean access$isInHumSubMode$jd(HasHumMainMode var0, HumSubMode var1) {
      return $default$isInHumSubMode(var0, var1);
   }

   // $FF: synthetic method
   public static boolean access$isInMainMode$jd(HasHumMainMode var0, MainMode var1) {
      return HasMainMode$_CC.$default$isInMainMode(var0, var1);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(HasHumMainMode var0) {
      return Device$_CC.$default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(HasHumMainMode var0) {
      return Device$_CC.$default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static MainMode access$mainMode$jd(HasHumMainMode var0) {
      return HasMainMode$_CC.$default$mainMode(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(HasHumMainMode var0) {
      return Device$_CC.$default$supportResetFilterOnline(var0);
   }
}
