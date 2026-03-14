package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasBleFunctions;", "Lcom/blueair/core/model/Device;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasBleFunctions extends Device {
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasBleFunctions var0) {
         return HasBleFunctions$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasBleFunctions var0, Context var1) {
         return HasBleFunctions$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasBleFunctions var0) {
         return HasBleFunctions$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasBleFunctions var0) {
         return HasBleFunctions$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isOnline(HasBleFunctions var0) {
         return HasBleFunctions$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasBleFunctions var0) {
         return HasBleFunctions$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasBleFunctions var0) {
         return HasBleFunctions$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
