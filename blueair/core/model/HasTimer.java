package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0012À\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasTimer;", "Lcom/blueair/core/model/Device;", "timerStatus", "", "getTimerStatus", "()I", "timerDuration", "getTimerDuration", "timerLeftTime", "getTimerLeftTime", "timerLeftTimeUpdateTime", "", "getTimerLeftTimeUpdateTime", "()J", "Lcom/blueair/core/model/TimerState;", "getRealTimerLeftTime", "nowInMills", "getLeftSeconds", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasTimer extends Device {
   int getLeftSeconds();

   int getRealTimerLeftTime(long var1);

   int getTimerDuration();

   int getTimerLeftTime();

   long getTimerLeftTimeUpdateTime();

   int getTimerStatus();

   TimerState timerStatus();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasTimer var0) {
         return HasTimer$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static int getLeftSeconds(HasTimer var0) {
         return HasTimer$_CC.access$getLeftSeconds$jd(var0);
      }

      @Deprecated
      public static int getRealTimerLeftTime(HasTimer var0, long var1) {
         return HasTimer$_CC.access$getRealTimerLeftTime$jd(var0, var1);
      }

      // $FF: synthetic method
      public static int getRealTimerLeftTime$default(HasTimer var0, long var1, int var3, Object var4) {
         return HasTimer$_CC.getRealTimerLeftTime$default(var0, var1, var3, var4);
      }

      @Deprecated
      public static TimeZone getTimezone(HasTimer var0, Context var1) {
         return HasTimer$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasTimer var0) {
         return HasTimer$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasTimer var0) {
         return HasTimer$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isOnline(HasTimer var0) {
         return HasTimer$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasTimer var0) {
         return HasTimer$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasTimer var0) {
         return HasTimer$_CC.access$supportResetFilterOnline$jd(var0);
      }

      @Deprecated
      public static TimerState timerStatus(HasTimer var0) {
         return HasTimer$_CC.access$timerStatus$jd(var0);
      }
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[TimerState.values().length];

         try {
            var0[TimerState.START.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[TimerState.RESUME.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[TimerState.STOP.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
