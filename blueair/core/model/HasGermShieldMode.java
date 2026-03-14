package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00038VX\u0096\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0007\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00038VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\t\u001a\u0004\b\f\u0010\u0004¨\u0006\rÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasGermShieldMode;", "Lcom/blueair/core/model/Device;", "isGermShieldModeOn", "", "()Z", "isGermShieldNightModeOn", "()Ljava/lang/Boolean;", "isGermShieldPlus", "isGermShieldPlus$annotations", "()V", "hasGermShieldNightMode", "getHasGermShieldNightMode$annotations", "getHasGermShieldNightMode", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasGermShieldMode extends Device {
   boolean getHasGermShieldNightMode();

   boolean isGermShieldModeOn();

   Boolean isGermShieldNightModeOn();

   boolean isGermShieldPlus();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasGermShieldMode var0) {
         return HasGermShieldMode$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static boolean getHasGermShieldNightMode(HasGermShieldMode var0) {
         return HasGermShieldMode$_CC.access$getHasGermShieldNightMode$jd(var0);
      }

      // $FF: synthetic method
      public static void getHasGermShieldNightMode$annotations() {
      }

      @Deprecated
      public static TimeZone getTimezone(HasGermShieldMode var0, Context var1) {
         return HasGermShieldMode$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasGermShieldMode var0) {
         return HasGermShieldMode$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasGermShieldMode var0) {
         return HasGermShieldMode$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isGermShieldPlus(HasGermShieldMode var0) {
         return HasGermShieldMode$_CC.access$isGermShieldPlus$jd(var0);
      }

      // $FF: synthetic method
      public static void isGermShieldPlus$annotations() {
      }

      @Deprecated
      public static boolean isOnline(HasGermShieldMode var0) {
         return HasGermShieldMode$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasGermShieldMode var0) {
         return HasGermShieldMode$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasGermShieldMode var0) {
         return HasGermShieldMode$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
