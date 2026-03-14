package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasWaterInfill;", "Lcom/blueair/core/model/Device;", "waterInfill", "", "getWaterInfill", "()Z", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasWaterInfill extends Device {
   boolean getWaterInfill();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasWaterInfill var0) {
         return HasWaterInfill$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasWaterInfill var0, Context var1) {
         return HasWaterInfill$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasWaterInfill var0) {
         return HasWaterInfill$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasWaterInfill var0) {
         return HasWaterInfill$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isOnline(HasWaterInfill var0) {
         return HasWaterInfill$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasWaterInfill var0) {
         return HasWaterInfill$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasWaterInfill var0) {
         return HasWaterInfill$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
