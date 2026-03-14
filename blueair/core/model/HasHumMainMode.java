package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\nÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasHumMainMode;", "Lcom/blueair/core/model/HasMainMode;", "humSubMode", "", "getHumSubMode", "()I", "Lcom/blueair/core/model/HumSubMode;", "isInHumSubMode", "", "subMode", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasHumMainMode extends HasMainMode {
   int getHumSubMode();

   HumSubMode humSubMode();

   boolean isInHumSubMode(HumSubMode var1);

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ApSubMode apSubMode(HasHumMainMode var0) {
         return HasHumMainMode$_CC.access$apSubMode$jd(var0);
      }

      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasHumMainMode var0) {
         return HasHumMainMode$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasHumMainMode var0, Context var1) {
         return HasHumMainMode$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasHumMainMode var0) {
         return HasHumMainMode$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static HumSubMode humSubMode(HasHumMainMode var0) {
         return HasHumMainMode$_CC.access$humSubMode$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasHumMainMode var0) {
         return HasHumMainMode$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isInApSubMode(HasHumMainMode var0, ApSubMode var1) {
         Intrinsics.checkNotNullParameter(var1, "subMode");
         return HasHumMainMode$_CC.access$isInApSubMode$jd(var0, var1);
      }

      @Deprecated
      public static boolean isInHumSubMode(HasHumMainMode var0, HumSubMode var1) {
         Intrinsics.checkNotNullParameter(var1, "subMode");
         return HasHumMainMode$_CC.access$isInHumSubMode$jd(var0, var1);
      }

      @Deprecated
      public static boolean isInMainMode(HasHumMainMode var0, MainMode var1) {
         Intrinsics.checkNotNullParameter(var1, "mainMode");
         return HasHumMainMode$_CC.access$isInMainMode$jd(var0, var1);
      }

      @Deprecated
      public static boolean isOnline(HasHumMainMode var0) {
         return HasHumMainMode$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasHumMainMode var0) {
         return HasHumMainMode$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static MainMode mainMode(HasHumMainMode var0) {
         return HasHumMainMode$_CC.access$mainMode$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasHumMainMode var0) {
         return HasHumMainMode$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
