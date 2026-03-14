package com.blueair.core.model;

import com.blueair.core.util.OutdoorRangeUtils;
import com.blueair.core.util.OutdoorRanges;

// $FF: synthetic class
public final class IOutdoorPollutants$_CC {
   public static Double $default$getCalculatedAQI(IOutdoorPollutants var0) {
      int var3 = var0.getNo2AQI();
      int var5 = var0.getPm10AQI();
      int var2 = var0.getPm25AQI();
      int var4 = var0.getSo2AQI();
      int var6 = var0.getCoAQI();
      int var1 = var0.getO3AQI();
      return (double)OutdoorRangeUtils.INSTANCE.getAQIFromIndividualAQI(new int[]{var3, var5, var2, var4, var6, var1});
   }

   public static int $default$getCoAQI(IOutdoorPollutants var0) {
      OutdoorRangeUtils var1 = OutdoorRangeUtils.INSTANCE;
      Pollutant var2 = var0.getCo_ppb();
      Double var3;
      if (var2 != null) {
         var3 = var2.getConcentration();
      } else {
         var3 = null;
      }

      return var1.convertMeasurementToiAQI(var3, OutdoorRanges.CO.INSTANCE.getLow(), OutdoorRanges.CO.INSTANCE.getHigh());
   }

   public static int $default$getNo2AQI(IOutdoorPollutants var0) {
      OutdoorRangeUtils var1 = OutdoorRangeUtils.INSTANCE;
      Pollutant var2 = var0.getNo2();
      Double var3;
      if (var2 != null) {
         var3 = var2.getConcentration();
      } else {
         var3 = null;
      }

      return var1.convertMeasurementToiAQI(var3, OutdoorRanges.NO2.INSTANCE.getLow(), OutdoorRanges.NO2.INSTANCE.getHigh());
   }

   public static int $default$getO3AQI(IOutdoorPollutants var0) {
      OutdoorRangeUtils var1 = OutdoorRangeUtils.INSTANCE;
      Pollutant var2 = var0.getO3();
      Double var3;
      if (var2 != null) {
         var3 = var2.getConcentration();
      } else {
         var3 = null;
      }

      return var1.convertMeasurementToiAQI(var3, OutdoorRanges.O3.INSTANCE.getLow(), OutdoorRanges.O3.INSTANCE.getHigh());
   }

   public static int $default$getPm10AQI(IOutdoorPollutants var0) {
      OutdoorRangeUtils var1 = OutdoorRangeUtils.INSTANCE;
      Pollutant var2 = var0.getPm10();
      Double var3;
      if (var2 != null) {
         var3 = var2.getConcentration();
      } else {
         var3 = null;
      }

      return var1.convertMeasurementToiAQI(var3, OutdoorRanges.PM10.INSTANCE.getLow(), OutdoorRanges.PM10.INSTANCE.getHigh());
   }

   public static int $default$getPm25AQI(IOutdoorPollutants var0) {
      OutdoorRangeUtils var1 = OutdoorRangeUtils.INSTANCE;
      Pollutant var2 = var0.getPm25();
      Double var3;
      if (var2 != null) {
         var3 = var2.getConcentration();
      } else {
         var3 = null;
      }

      return var1.convertMeasurementToiAQI(var3, OutdoorRanges.PM25.INSTANCE.getLow(), OutdoorRanges.PM25.INSTANCE.getHigh());
   }

   public static int $default$getSo2AQI(IOutdoorPollutants var0) {
      OutdoorRangeUtils var1 = OutdoorRangeUtils.INSTANCE;
      Pollutant var2 = var0.getSo2();
      Double var3;
      if (var2 != null) {
         var3 = var2.getConcentration();
      } else {
         var3 = null;
      }

      return var1.convertMeasurementToiAQI(var3, OutdoorRanges.SO2.INSTANCE.getLow(), OutdoorRanges.SO2.INSTANCE.getHigh());
   }

   // $FF: synthetic method
   public static Double access$getCalculatedAQI$jd(IOutdoorPollutants var0) {
      return $default$getCalculatedAQI(var0);
   }

   // $FF: synthetic method
   public static int access$getCoAQI$jd(IOutdoorPollutants var0) {
      return $default$getCoAQI(var0);
   }

   // $FF: synthetic method
   public static int access$getNo2AQI$jd(IOutdoorPollutants var0) {
      return $default$getNo2AQI(var0);
   }

   // $FF: synthetic method
   public static int access$getO3AQI$jd(IOutdoorPollutants var0) {
      return $default$getO3AQI(var0);
   }

   // $FF: synthetic method
   public static int access$getPm10AQI$jd(IOutdoorPollutants var0) {
      return $default$getPm10AQI(var0);
   }

   // $FF: synthetic method
   public static int access$getPm25AQI$jd(IOutdoorPollutants var0) {
      return $default$getPm25AQI(var0);
   }

   // $FF: synthetic method
   public static int access$getSo2AQI$jd(IOutdoorPollutants var0) {
      return $default$getSo2AQI(var0);
   }
}
