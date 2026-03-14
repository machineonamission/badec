package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\b\u001a\u00020\u000eH\u0016J\b\u0010\n\u001a\u00020\u000fH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006\u0010À\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasOscillation;", "Lcom/blueair/core/model/Device;", "oscillationState", "", "getOscillationState", "()I", "oscillationAngle", "getOscillationAngle", "oscillationDirection", "getOscillationDirection", "oscillationFanSpeed", "getOscillationFanSpeed", "isOscillationEnabled", "", "Lcom/blueair/core/model/OscillationDirection;", "Lcom/blueair/core/model/OscillationFanSpeed;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasOscillation extends Device {
   int getOscillationAngle();

   int getOscillationDirection();

   int getOscillationFanSpeed();

   int getOscillationState();

   boolean isOscillationEnabled();

   OscillationDirection oscillationDirection();

   OscillationFanSpeed oscillationFanSpeed();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasOscillation var0) {
         return HasOscillation$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasOscillation var0, Context var1) {
         return HasOscillation$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasOscillation var0) {
         return HasOscillation$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasOscillation var0) {
         return HasOscillation$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isOnline(HasOscillation var0) {
         return HasOscillation$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isOscillationEnabled(HasOscillation var0) {
         return HasOscillation$_CC.access$isOscillationEnabled$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasOscillation var0) {
         return HasOscillation$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static OscillationDirection oscillationDirection(HasOscillation var0) {
         return HasOscillation$_CC.access$oscillationDirection$jd(var0);
      }

      @Deprecated
      public static OscillationFanSpeed oscillationFanSpeed(HasOscillation var0) {
         return HasOscillation$_CC.access$oscillationFanSpeed$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasOscillation var0) {
         return HasOscillation$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
