package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/Device;", "brightness", "", "getBrightness", "()I", "brightnessEnum", "Lcom/blueair/core/model/Brightness;", "getBrightnessEnum", "()Lcom/blueair/core/model/Brightness;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasBrightness extends Device {
   int getBrightness();

   Brightness getBrightnessEnum();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static Brightness getBrightnessEnum(HasBrightness var0) {
         return HasBrightness$_CC.access$getBrightnessEnum$jd(var0);
      }

      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasBrightness var0) {
         return HasBrightness$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasBrightness var0, Context var1) {
         return HasBrightness$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasBrightness var0) {
         return HasBrightness$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasBrightness var0) {
         return HasBrightness$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isOnline(HasBrightness var0) {
         return HasBrightness$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasBrightness var0) {
         return HasBrightness$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasBrightness var0) {
         return HasBrightness$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
