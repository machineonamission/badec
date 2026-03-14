package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u0013\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020%H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0012\u0010\u0012\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u0012\u0010\u001c\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019¨\u0006&À\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasCombo3in1MainMode;", "Lcom/blueair/core/model/HasMainMode;", "apFanSpeed", "", "getApFanSpeed", "()I", "heatSubMode", "getHeatSubMode", "heatFanSpeed", "getHeatFanSpeed", "heatAutoTmp", "", "getHeatAutoTmp", "()D", "heatEcoTmp", "getHeatEcoTmp", "coolSubMode", "getCoolSubMode", "coolFanSpeed", "getCoolFanSpeed", "coolAutoTag", "getCoolAutoTag", "coolAutoPresets", "", "getCoolAutoPresets", "()[D", "coolEcoTag", "getCoolEcoTag", "coolEcoPresets", "getCoolEcoPresets", "currentSubMode", "Lcom/blueair/core/model/ApSubMode;", "isInSubMode", "", "subMode", "currentFanSpeed", "currentFanSpeedEnum", "Lcom/blueair/core/model/FanSpeedEnum;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasCombo3in1MainMode extends HasMainMode {
   int currentFanSpeed();

   FanSpeedEnum currentFanSpeedEnum();

   ApSubMode currentSubMode();

   int getApFanSpeed();

   double[] getCoolAutoPresets();

   int getCoolAutoTag();

   double[] getCoolEcoPresets();

   int getCoolEcoTag();

   int getCoolFanSpeed();

   int getCoolSubMode();

   double getHeatAutoTmp();

   double getHeatEcoTmp();

   int getHeatFanSpeed();

   int getHeatSubMode();

   boolean isInSubMode(ApSubMode var1);

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static ApSubMode apSubMode(HasCombo3in1MainMode var0) {
         return HasCombo3in1MainMode$_CC.access$apSubMode$jd(var0);
      }

      @Deprecated
      public static int currentFanSpeed(HasCombo3in1MainMode var0) {
         return HasCombo3in1MainMode$_CC.access$currentFanSpeed$jd(var0);
      }

      @Deprecated
      public static FanSpeedEnum currentFanSpeedEnum(HasCombo3in1MainMode var0) {
         return HasCombo3in1MainMode$_CC.access$currentFanSpeedEnum$jd(var0);
      }

      @Deprecated
      public static ApSubMode currentSubMode(HasCombo3in1MainMode var0) {
         return HasCombo3in1MainMode$_CC.access$currentSubMode$jd(var0);
      }

      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasCombo3in1MainMode var0) {
         return HasCombo3in1MainMode$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static TimeZone getTimezone(HasCombo3in1MainMode var0, Context var1) {
         return HasCombo3in1MainMode$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasCombo3in1MainMode var0) {
         return HasCombo3in1MainMode$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasCombo3in1MainMode var0) {
         return HasCombo3in1MainMode$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isInApSubMode(HasCombo3in1MainMode var0, ApSubMode var1) {
         Intrinsics.checkNotNullParameter(var1, "subMode");
         return HasCombo3in1MainMode$_CC.access$isInApSubMode$jd(var0, var1);
      }

      @Deprecated
      public static boolean isInMainMode(HasCombo3in1MainMode var0, MainMode var1) {
         Intrinsics.checkNotNullParameter(var1, "mainMode");
         return HasCombo3in1MainMode$_CC.access$isInMainMode$jd(var0, var1);
      }

      @Deprecated
      public static boolean isInSubMode(HasCombo3in1MainMode var0, ApSubMode var1) {
         Intrinsics.checkNotNullParameter(var1, "subMode");
         return HasCombo3in1MainMode$_CC.access$isInSubMode$jd(var0, var1);
      }

      @Deprecated
      public static boolean isOnline(HasCombo3in1MainMode var0) {
         return HasCombo3in1MainMode$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasCombo3in1MainMode var0) {
         return HasCombo3in1MainMode$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static MainMode mainMode(HasCombo3in1MainMode var0) {
         return HasCombo3in1MainMode$_CC.access$mainMode$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasCombo3in1MainMode var0) {
         return HasCombo3in1MainMode$_CC.access$supportResetFilterOnline$jd(var0);
      }
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[MainMode.values().length];

         try {
            var0[MainMode.AirPurify.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[MainMode.HEAT.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[MainMode.COOL.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
