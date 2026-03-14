package com.blueair.core.model;

import android.content.Context;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

// $FF: synthetic class
public final class HasMode$_CC {
   public static boolean $default$isInMode(HasMode var0, Mode var1) {
      Intrinsics.checkNotNullParameter(var1, "mode");
      return var0.getMode() == var1.getValue();
   }

   public static Mode $default$mode(HasMode var0) {
      Iterator var2 = ((Iterable)Mode.getEntries()).iterator();

      while(true) {
         if (var2.hasNext()) {
            Object var1 = var2.next();
            if (((Mode)var1).getValue() != var0.getMode()) {
               continue;
            }

            var3 = var1;
            break;
         }

         var3 = null;
         break;
      }

      Mode var4 = (Mode)var3;
      return var4 == null ? Mode.FAN : var4;
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(HasMode var0) {
      return Device$_CC.$default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(HasMode var0, Context var1) {
      return Device$_CC.$default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(HasMode var0) {
      return Device$_CC.$default$getType(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(HasMode var0) {
      return Device$_CC.$default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isInMode$jd(HasMode var0, Mode var1) {
      return $default$isInMode(var0, var1);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(HasMode var0) {
      return Device$_CC.$default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(HasMode var0) {
      return Device$_CC.$default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static Mode access$mode$jd(HasMode var0) {
      return $default$mode(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(HasMode var0) {
      return Device$_CC.$default$supportResetFilterOnline(var0);
   }
}
