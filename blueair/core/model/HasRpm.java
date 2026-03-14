package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasRpm;", "Lcom/blueair/core/model/Device;", "rpm", "", "getRpm", "()I", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasRpm extends Device {
   int getRpm();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasRpm var0) {
         return HasRpm$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasRpm var0, Context var1) {
         return HasRpm$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasRpm var0) {
         return HasRpm$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasRpm var0) {
         return HasRpm$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isOnline(HasRpm var0) {
         return HasRpm$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasRpm var0) {
         return HasRpm$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasRpm var0) {
         return HasRpm$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
