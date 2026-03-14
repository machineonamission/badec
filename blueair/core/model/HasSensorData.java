package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.util.IndoorAirRatingRanges;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0017H\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\"\u001a\u00020\u0017H\u0016J\u001a\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\"\u001a\u00020\u0017H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010\"\u001a\u00020\u0017H\u0016R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0012\u0010\u0012\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0012\u0010\u0014\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 ¨\u0006)À\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/Device;", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "", "getLastSelectedSensorTypeIndex", "()I", "pm1Ranges", "", "getPm1Ranges", "()[D", "pm10Ranges", "getPm10Ranges", "pm25Ranges", "getPm25Ranges", "vocRanges", "getVocRanges", "hchoRanges", "getHchoRanges", "lastSelectedSensorType", "Lcom/blueair/core/model/SensorType;", "getLastSelectedSensorType$annotations", "()V", "getLastSelectedSensorType", "()Lcom/blueair/core/model/SensorType;", "airRatingRanges", "Lcom/blueair/core/util/IndoorAirRatingRanges;", "getAirRatingRanges$annotations", "getAirRatingRanges", "()Lcom/blueair/core/util/IndoorAirRatingRanges;", "airRatingsFor", "sensorType", "aqiFor", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "sensorValue", "", "supports", "", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface HasSensorData extends Device {
   double[] airRatingsFor(SensorType var1);

   IndoorAirRatingRanges.IndoorAirRating aqiFor(double var1, SensorType var3);

   IndoorAirRatingRanges.IndoorAirRating aqiFor(SensorType var1);

   IndoorAirRatingRanges getAirRatingRanges();

   double[] getHchoRanges();

   SensorType getLastSelectedSensorType();

   int getLastSelectedSensorTypeIndex();

   IndoorDatapoint getLatestSensorDatapoint();

   double[] getPm10Ranges();

   double[] getPm1Ranges();

   double[] getPm25Ranges();

   double[] getVocRanges();

   boolean supports(SensorType var1);

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static double[] airRatingsFor(HasSensorData var0, SensorType var1) {
         Intrinsics.checkNotNullParameter(var1, "sensorType");
         return HasSensorData$_CC.access$airRatingsFor$jd(var0, var1);
      }

      @Deprecated
      public static IndoorAirRatingRanges.IndoorAirRating aqiFor(HasSensorData var0, double var1, SensorType var3) {
         Intrinsics.checkNotNullParameter(var3, "sensorType");
         return HasSensorData$_CC.access$aqiFor$jd(var0, var1, var3);
      }

      @Deprecated
      public static IndoorAirRatingRanges.IndoorAirRating aqiFor(HasSensorData var0, SensorType var1) {
         Intrinsics.checkNotNullParameter(var1, "sensorType");
         return HasSensorData$_CC.access$aqiFor$jd(var0, var1);
      }

      @Deprecated
      public static IndoorAirRatingRanges getAirRatingRanges(HasSensorData var0) {
         return HasSensorData$_CC.access$getAirRatingRanges$jd(var0);
      }

      // $FF: synthetic method
      public static void getAirRatingRanges$annotations() {
      }

      @Deprecated
      public static ConnectivityStatus getConnectivityStatus(HasSensorData var0) {
         return HasSensorData$_CC.access$getConnectivityStatus$jd(var0);
      }

      @Deprecated
      public static SensorType getLastSelectedSensorType(HasSensorData var0) {
         return HasSensorData$_CC.access$getLastSelectedSensorType$jd(var0);
      }

      // $FF: synthetic method
      public static void getLastSelectedSensorType$annotations() {
      }

      @Deprecated
      public static TimeZone getTimezone(HasSensorData var0, Context var1) {
         return HasSensorData$_CC.access$getTimezone$jd(var0, var1);
      }

      @Deprecated
      public static DeviceType getType(HasSensorData var0) {
         return HasSensorData$_CC.access$getType$jd(var0);
      }

      @Deprecated
      public static boolean isCnDevice(HasSensorData var0) {
         return HasSensorData$_CC.access$isCnDevice$jd(var0);
      }

      @Deprecated
      public static boolean isOnline(HasSensorData var0) {
         return HasSensorData$_CC.access$isOnline$jd(var0);
      }

      @Deprecated
      public static boolean isUsDevice(HasSensorData var0) {
         return HasSensorData$_CC.access$isUsDevice$jd(var0);
      }

      @Deprecated
      public static boolean supportResetFilterOnline(HasSensorData var0) {
         return HasSensorData$_CC.access$supportResetFilterOnline$jd(var0);
      }

      @Deprecated
      public static boolean supports(HasSensorData var0, SensorType var1) {
         Intrinsics.checkNotNullParameter(var1, "sensorType");
         return HasSensorData$_CC.access$supports$jd(var0, var1);
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
         int[] var0 = new int[SensorType.values().length];

         try {
            var0[SensorType.PM1.ordinal()] = 1;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[SensorType.PM10.ordinal()] = 2;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[SensorType.PM25.ordinal()] = 3;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[SensorType.VOC.ordinal()] = 4;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[SensorType.HCHO.ordinal()] = 5;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[SensorType.HUM.ordinal()] = 6;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[SensorType.TMP.ordinal()] = 7;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[SensorType.FAN.ordinal()] = 8;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[SensorType.WEIGHT.ordinal()] = 9;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[SensorType.RPM.ordinal()] = 10;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
