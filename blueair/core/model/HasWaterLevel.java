package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\tÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasWaterLevel;", "Lcom/blueair/core/model/Device;", "waterLevel", "", "getWaterLevel", "()I", "Lcom/blueair/core/model/WaterLevel;", "isInWaterLevel", "", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasWaterLevel extends Device {
   int getWaterLevel();

   boolean isInWaterLevel(WaterLevel var1);

   WaterLevel waterLevel();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasWaterLevel var0) {
         return HasWaterLevel$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasWaterLevel var0, Context var1) {
         return HasWaterLevel$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasWaterLevel var0) {
         return HasWaterLevel$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasWaterLevel var0) {
         return HasWaterLevel$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isInWaterLevel(HasWaterLevel var0, WaterLevel var1) {
         Intrinsics.checkNotNullParameter(var1, "waterLevel");
         return HasWaterLevel$_CC.access$isInWaterLevel$jd(var0, var1);
      }

      @Deprecated
      public static boolean isOnline(HasWaterLevel var0) {
         return HasWaterLevel$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasWaterLevel var0) {
         return HasWaterLevel$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasWaterLevel var0) {
         return HasWaterLevel$_CC.access$supportResetFilterOnline$jd(var0);
      }

      @Deprecated
      public static WaterLevel waterLevel(HasWaterLevel var0) {
         return HasWaterLevel$_CC.access$waterLevel$jd(var0);
      }
   }
}
