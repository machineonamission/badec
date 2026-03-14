package com.blueair.core.model;

import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010\u0019R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005¨\u0006\u001aÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/core/model/IOutdoorPollutants;", "", "co_ppb", "Lcom/blueair/core/model/Pollutant;", "getCo_ppb", "()Lcom/blueair/core/model/Pollutant;", "no2", "getNo2", "o3", "getO3", "pm10", "getPm10", "pm25", "getPm25", "so2", "getSo2", "getNo2AQI", "", "getPm10AQI", "getPm25AQI", "getSo2AQI", "getCoAQI", "getO3AQI", "getCalculatedAQI", "", "()Ljava/lang/Double;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface IOutdoorPollutants {
   Double getCalculatedAQI();

   int getCoAQI();

   Pollutant getCo_ppb();

   Pollutant getNo2();

   int getNo2AQI();

   Pollutant getO3();

   int getO3AQI();

   Pollutant getPm10();

   int getPm10AQI();

   Pollutant getPm25();

   int getPm25AQI();

   Pollutant getSo2();

   int getSo2AQI();

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static Double getCalculatedAQI(IOutdoorPollutants var0) {
         return IOutdoorPollutants$_CC.access$getCalculatedAQI$jd(var0);
      }

      @Deprecated
      public static int getCoAQI(IOutdoorPollutants var0) {
         return IOutdoorPollutants$_CC.access$getCoAQI$jd(var0);
      }

      @Deprecated
      public static int getNo2AQI(IOutdoorPollutants var0) {
         return IOutdoorPollutants$_CC.access$getNo2AQI$jd(var0);
      }

      @Deprecated
      public static int getO3AQI(IOutdoorPollutants var0) {
         return IOutdoorPollutants$_CC.access$getO3AQI$jd(var0);
      }

      @Deprecated
      public static int getPm10AQI(IOutdoorPollutants var0) {
         return IOutdoorPollutants$_CC.access$getPm10AQI$jd(var0);
      }

      @Deprecated
      public static int getPm25AQI(IOutdoorPollutants var0) {
         return IOutdoorPollutants$_CC.access$getPm25AQI$jd(var0);
      }

      @Deprecated
      public static int getSo2AQI(IOutdoorPollutants var0) {
         return IOutdoorPollutants$_CC.access$getSo2AQI$jd(var0);
      }
   }
}
