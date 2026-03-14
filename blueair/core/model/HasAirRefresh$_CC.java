package com.blueair.core.model;

import android.content.Context;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

// $FF: synthetic class
public final class HasAirRefresh$_CC {
   public static AirRefreshState $default$airRefreshStatus(HasAirRefresh var0) {
      Iterator var2 = ((Iterable)AirRefreshState.getEntries()).iterator();

      while(true) {
         if (var2.hasNext()) {
            Object var1 = var2.next();
            if (((AirRefreshState)var1).getValue() != var0.getAirRefreshStatus()) {
               continue;
            }

            var3 = var1;
            break;
         }

         var3 = null;
         break;
      }

      AirRefreshState var4 = (AirRefreshState)var3;
      return var4 == null ? AirRefreshState.COMPLETED : var4;
   }

   public static int $default$getAirRefreshLeftSeconds(HasAirRefresh var0, long var1) {
      return RangesKt.coerceIn((int)((long)var0.getAirRefreshDuration() - (var1 / (long)1000 - (long)var0.getAirRefreshTimeStamp())), 0, var0.getAirRefreshDuration());
   }

   public static boolean $default$isInAirRefreshStatus(HasAirRefresh var0, AirRefreshState var1) {
      Intrinsics.checkNotNullParameter(var1, "status");
      return var0.getAirRefreshStatus() == var1.getValue();
   }

   // $FF: synthetic method
   public static AirRefreshState access$airRefreshStatus$jd(HasAirRefresh var0) {
      return $default$airRefreshStatus(var0);
   }

   // $FF: synthetic method
   public static int access$getAirRefreshLeftSeconds$jd(HasAirRefresh var0, long var1) {
      return $default$getAirRefreshLeftSeconds(var0, var1);
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(HasAirRefresh var0) {
      return Device$_CC.$default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(HasAirRefresh var0, Context var1) {
      return Device$_CC.$default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(HasAirRefresh var0) {
      return Device$_CC.$default$getType(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(HasAirRefresh var0) {
      return Device$_CC.$default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isInAirRefreshStatus$jd(HasAirRefresh var0, AirRefreshState var1) {
      return $default$isInAirRefreshStatus(var0, var1);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(HasAirRefresh var0) {
      return Device$_CC.$default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(HasAirRefresh var0) {
      return Device$_CC.$default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(HasAirRefresh var0) {
      return Device$_CC.$default$supportResetFilterOnline(var0);
   }

   // $FF: synthetic method
   public static int getAirRefreshLeftSeconds$default(HasAirRefresh var0, long var1, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 1) != 0) {
            var1 = System.currentTimeMillis();
         }

         return var0.getAirRefreshLeftSeconds(var1);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAirRefreshLeftSeconds");
      }
   }
}
