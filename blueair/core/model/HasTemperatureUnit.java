package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasTemperatureUnit;", "Lcom/blueair/core/model/Device;", "temperatureUnit", "", "getTemperatureUnit", "()I", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasTemperatureUnit extends Device {
   int getTemperatureUnit();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasTemperatureUnit var0) {
         return HasTemperatureUnit$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasTemperatureUnit var0, Context var1) {
         return HasTemperatureUnit$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasTemperatureUnit var0) {
         return HasTemperatureUnit$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasTemperatureUnit var0) {
         return HasTemperatureUnit$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isOnline(HasTemperatureUnit var0) {
         return HasTemperatureUnit$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasTemperatureUnit var0) {
         return HasTemperatureUnit$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasTemperatureUnit var0) {
         return HasTemperatureUnit$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
