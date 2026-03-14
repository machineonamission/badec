package com.blueair.core.model;

import android.content.Context;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.ranges.RangesKt;

// $FF: synthetic class
public final class HasTimer$_CC {
   public static int $default$getLeftSeconds(HasTimer var0) {
      int var1 = RangesKt.coerceAtLeast(var0.getTimerDuration(), 1);
      TimerState var3 = var0.timerStatus();
      int var2 = HasTimer.WhenMappings.$EnumSwitchMapping$0[var3.ordinal()];
      if (var2 != 1 && var2 != 2) {
         return var2 != 3 ? 0 : RangesKt.coerceIn(var0.getTimerLeftTime(), 0, var1);
      } else {
         return getRealTimerLeftTime$default(var0, 0L, 1, (Object)null);
      }
   }

   public static int $default$getRealTimerLeftTime(HasTimer var0, long var1) {
      return RangesKt.coerceIn((int)((long)var0.getTimerLeftTime() - (var1 / (long)1000 - var0.getTimerLeftTimeUpdateTime())), 0, var0.getTimerDuration());
   }

   public static TimerState $default$timerStatus(HasTimer var0) {
      Iterator var2 = ((Iterable)TimerState.getEntries()).iterator();

      while(true) {
         if (var2.hasNext()) {
            Object var1 = var2.next();
            if (((TimerState)var1).getValue() != var0.getTimerStatus()) {
               continue;
            }

            var3 = var1;
            break;
         }

         var3 = null;
         break;
      }

      TimerState var4 = (TimerState)var3;
      return var4 == null ? TimerState.COMPLETED : var4;
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(HasTimer var0) {
      return Device$_CC.$default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static int access$getLeftSeconds$jd(HasTimer var0) {
      return $default$getLeftSeconds(var0);
   }

   // $FF: synthetic method
   public static int access$getRealTimerLeftTime$jd(HasTimer var0, long var1) {
      return $default$getRealTimerLeftTime(var0, var1);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(HasTimer var0, Context var1) {
      return Device$_CC.$default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(HasTimer var0) {
      return Device$_CC.$default$getType(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(HasTimer var0) {
      return Device$_CC.$default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(HasTimer var0) {
      return Device$_CC.$default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(HasTimer var0) {
      return Device$_CC.$default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(HasTimer var0) {
      return Device$_CC.$default$supportResetFilterOnline(var0);
   }

   // $FF: synthetic method
   public static TimerState access$timerStatus$jd(HasTimer var0) {
      return $default$timerStatus(var0);
   }

   // $FF: synthetic method
   public static int getRealTimerLeftTime$default(HasTimer var0, long var1, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 1) != 0) {
            var1 = System.currentTimeMillis();
         }

         return var0.getRealTimerLeftTime(var1);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRealTimerLeftTime");
      }
   }
}
