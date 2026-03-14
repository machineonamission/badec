package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007À\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasPetMainMode;", "Lcom/blueair/core/model/HasMainMode;", "smartSubMode", "", "getSmartSubMode", "()I", "Lcom/blueair/core/model/SmartSubMode;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasPetMainMode extends HasMainMode {
   int getSmartSubMode();

   SmartSubMode smartSubMode();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ApSubMode apSubMode(HasPetMainMode var0) {
         return HasPetMainMode$_CC.access$apSubMode$jd(var0);
      }

      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasPetMainMode var0) {
         return HasPetMainMode$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasPetMainMode var0, Context var1) {
         return HasPetMainMode$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasPetMainMode var0) {
         return HasPetMainMode$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasPetMainMode var0) {
         return HasPetMainMode$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isInApSubMode(HasPetMainMode var0, ApSubMode var1) {
         Intrinsics.checkNotNullParameter(var1, "subMode");
         return HasPetMainMode$_CC.access$isInApSubMode$jd(var0, var1);
      }

      @Deprecated
      public static boolean isInMainMode(HasPetMainMode var0, MainMode var1) {
         Intrinsics.checkNotNullParameter(var1, "mainMode");
         return HasPetMainMode$_CC.access$isInMainMode$jd(var0, var1);
      }

      @Deprecated
      public static boolean isOnline(HasPetMainMode var0) {
         return HasPetMainMode$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasPetMainMode var0) {
         return HasPetMainMode$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static MainMode mainMode(HasPetMainMode var0) {
         return HasPetMainMode$_CC.access$mainMode$jd(var0);
      }

      @Deprecated
      public static SmartSubMode smartSubMode(HasPetMainMode var0) {
         return HasPetMainMode$_CC.access$smartSubMode$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasPetMainMode var0) {
         return HasPetMainMode$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }
}
