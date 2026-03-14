package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\tÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasMode;", "Lcom/blueair/core/model/Device;", "mode", "", "getMode", "()I", "Lcom/blueair/core/model/Mode;", "isInMode", "", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasMode extends Device {
   int getMode();

   boolean isInMode(Mode var1);

   Mode mode();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasMode var0) {
         return HasMode$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasMode var0, Context var1) {
         return HasMode$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasMode var0) {
         return HasMode$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasMode var0) {
         return HasMode$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isInMode(HasMode var0, Mode var1) {
         Intrinsics.checkNotNullParameter(var1, "mode");
         return HasMode$_CC.access$isInMode$jd(var0, var1);
      }

      @Deprecated
      public static boolean isOnline(HasMode var0) {
         return HasMode$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasMode var0) {
         return HasMode$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static Mode mode(HasMode var0) {
         return HasMode$_CC.access$mode$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasMode var0) {
         return HasMode$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
