package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.util.IndoorAirRatingRanges;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

// $FF: synthetic class
public final class HasSensorData$_CC {
   public static double[] $default$airRatingsFor(HasSensorData var0, SensorType var1) {
      // $FF: Couldn't be decompiled
   }

   public static IndoorAirRatingRanges.IndoorAirRating $default$aqiFor(HasSensorData var0, double var1, SensorType var3) {
      Intrinsics.checkNotNullParameter(var3, "sensorType");
      return var0.getAirRatingRanges().rating(var1, var3);
   }

   public static IndoorAirRatingRanges.IndoorAirRating $default$aqiFor(HasSensorData var0, SensorType var1) {
      Intrinsics.checkNotNullParameter(var1, "sensorType");
      return var0.getAirRatingRanges().rating(var0, var1);
   }

   public static IndoorAirRatingRanges $default$getAirRatingRanges(HasSensorData var0) {
      return IndoorAirRatingRanges.Companion.instance(var0);
   }

   public static SensorType $default$getLastSelectedSensorType(HasSensorData var0) {
      SensorType var1 = SensorType.values()[var0.getLastSelectedSensorTypeIndex()];
      return var0.supports(var1) ? var1 : SensorType.PM25;
   }

   public static boolean $default$supports(HasSensorData var0, SensorType var1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   public static double[] access$airRatingsFor$jd(HasSensorData var0, SensorType var1) {
      return $default$airRatingsFor(var0, var1);
   }

   // $FF: synthetic method
   public static IndoorAirRatingRanges.IndoorAirRating access$aqiFor$jd(HasSensorData var0, double var1, SensorType var3) {
      return $default$aqiFor(var0, var1, var3);
   }

   // $FF: synthetic method
   public static IndoorAirRatingRanges.IndoorAirRating access$aqiFor$jd(HasSensorData var0, SensorType var1) {
      return $default$aqiFor(var0, var1);
   }

   // $FF: synthetic method
   public static IndoorAirRatingRanges access$getAirRatingRanges$jd(HasSensorData var0) {
      return $default$getAirRatingRanges(var0);
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(HasSensorData var0) {
      return Device$_CC.$default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static SensorType access$getLastSelectedSensorType$jd(HasSensorData var0) {
      return $default$getLastSelectedSensorType(var0);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(HasSensorData var0, Context var1) {
      return Device$_CC.$default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(HasSensorData var0) {
      return Device$_CC.$default$getType(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(HasSensorData var0) {
      return Device$_CC.$default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(HasSensorData var0) {
      return Device$_CC.$default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(HasSensorData var0) {
      return Device$_CC.$default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(HasSensorData var0) {
      return Device$_CC.$default$supportResetFilterOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$supports$jd(HasSensorData var0, SensorType var1) {
      return $default$supports(var0, var1);
   }
}
