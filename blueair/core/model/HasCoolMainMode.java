package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\u0010À\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasCoolMainMode;", "Lcom/blueair/core/model/HasMainMode;", "coolSubMode", "", "getCoolSubMode", "()I", "coolFanSpeedLevel", "getCoolFanSpeedLevel", "coolAutoLevel", "getCoolAutoLevel", "Lcom/blueair/core/model/CoolSubMode;", "isInSubMode", "", "subMode", "coolFanSpeedEnum", "Lcom/blueair/core/model/FanSpeedEnum;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasCoolMainMode extends HasMainMode {
   FanSpeedEnum coolFanSpeedEnum();

   CoolSubMode coolSubMode();

   int getCoolAutoLevel();

   int getCoolFanSpeedLevel();

   int getCoolSubMode();

   boolean isInSubMode(CoolSubMode var1);

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ApSubMode apSubMode(HasCoolMainMode var0) {
         return HasCoolMainMode$_CC.access$apSubMode$jd(var0);
      }

      @Deprecated
      public static FanSpeedEnum coolFanSpeedEnum(HasCoolMainMode var0) {
         return HasCoolMainMode$_CC.access$coolFanSpeedEnum$jd(var0);
      }

      @Deprecated
      public static CoolSubMode coolSubMode(HasCoolMainMode var0) {
         return HasCoolMainMode$_CC.access$coolSubMode$jd(var0);
      }

      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasCoolMainMode var0) {
         return HasCoolMainMode$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasCoolMainMode var0, Context var1) {
         return HasCoolMainMode$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasCoolMainMode var0) {
         return HasCoolMainMode$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasCoolMainMode var0) {
         return HasCoolMainMode$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isInApSubMode(HasCoolMainMode var0, ApSubMode var1) {
         Intrinsics.checkNotNullParameter(var1, "subMode");
         return HasCoolMainMode$_CC.access$isInApSubMode$jd(var0, var1);
      }

      @Deprecated
      public static boolean isInMainMode(HasCoolMainMode var0, MainMode var1) {
         Intrinsics.checkNotNullParameter(var1, "mainMode");
         return HasCoolMainMode$_CC.access$isInMainMode$jd(var0, var1);
      }

      @Deprecated
      public static boolean isInSubMode(HasCoolMainMode var0, CoolSubMode var1) {
         Intrinsics.checkNotNullParameter(var1, "subMode");
         return HasCoolMainMode$_CC.access$isInSubMode$jd(var0, var1);
      }

      @Deprecated
      public static boolean isOnline(HasCoolMainMode var0) {
         return HasCoolMainMode$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasCoolMainMode var0) {
         return HasCoolMainMode$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static MainMode mainMode(HasCoolMainMode var0) {
         return HasCoolMainMode$_CC.access$mainMode$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasCoolMainMode var0) {
         return HasCoolMainMode$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
