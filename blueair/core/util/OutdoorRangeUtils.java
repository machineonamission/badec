package com.blueair.core.util;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J%\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u0011J \u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"},
   d2 = {"Lcom/blueair/core/util/OutdoorRangeUtils;", "", "<init>", "()V", "AQI_LOW", "", "AQI_HIGH", "convertIAQIToMeasurement", "", "iAQI", "low", "high", "(Ljava/lang/Double;[D[D)Ljava/lang/Double;", "convertMeasurementToiAQI", "", "value", "", "(Ljava/lang/Double;[D[D)I", "findIndexOfMeasurement", "measurement", "lowValues", "highValues", "getAQIFromIndividualAQI", "allAQI", "", "convertAqiToPercentage", "aqi", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class OutdoorRangeUtils {
   private static final double[] AQI_HIGH = new double[]{(double)50.0F, (double)100.0F, (double)150.0F, (double)200.0F, (double)300.0F, (double)500.0F};
   private static final double[] AQI_LOW = new double[]{(double)0.0F, (double)51.0F, (double)101.0F, (double)151.0F, (double)201.0F, (double)301.0F};
   public static final OutdoorRangeUtils INSTANCE = new OutdoorRangeUtils();

   private OutdoorRangeUtils() {
   }

   private final int findIndexOfMeasurement(double var1, double[] var3, double[] var4) {
      int var10 = var3.length;
      if (var10 == var4.length) {
         int var9 = var4.length;
         int var8 = 0;

         for(int var7 = 0; var8 < var9; ++var7) {
            double var10000 = var4[var8];
            if (var1 >= var3[var7] && var1 <= var4[var7] || var7 == var10 - 1 && var1 > var4[var7]) {
               return var7;
            }

            ++var8;
         }
      }

      return 0;
   }

   public final double convertAqiToPercentage(double var1) {
      if (var1 <= (double)0.0F) {
         var1 = (double)0.0F;
      } else if (!(var1 <= (double)200.0F)) {
         if (var1 <= (double)500.0F) {
            double var3 = (double)200;
            var1 = (var1 - var3) / (double)6 + var3;
         } else {
            var1 = (double)250.0F;
         }
      }

      return var1 / (double)250;
   }

   public final Double convertIAQIToMeasurement(Double var1, double[] var2, double[] var3) {
      Intrinsics.checkNotNullParameter(var2, "low");
      Intrinsics.checkNotNullParameter(var3, "high");
      if (var1 != null) {
         ((Number)var1).doubleValue();
         OutdoorRangeUtils var15 = INSTANCE;
         double var4 = var1;
         double[] var14 = AQI_LOW;
         double[] var13 = AQI_HIGH;
         int var12 = var15.findIndexOfMeasurement(var4, var14, var13);
         double var6 = var2[var12];
         var4 = var3[var12];
         double var8 = var14[var12];
         double var10 = var13[var12];
         return (var1 - var8) * (var4 - var6) / (var10 - var8) + var6;
      } else {
         return null;
      }
   }

   public final int convertMeasurementToiAQI(float var1, double[] var2, double[] var3) {
      Intrinsics.checkNotNullParameter(var2, "low");
      Intrinsics.checkNotNullParameter(var3, "high");
      return var1 == Float.MAX_VALUE ? 0 : this.convertMeasurementToiAQI((double)var1, var2, var3);
   }

   public final int convertMeasurementToiAQI(Double var1, double[] var2, double[] var3) {
      Intrinsics.checkNotNullParameter(var2, "low");
      Intrinsics.checkNotNullParameter(var3, "high");
      if (var1 != null) {
         ((Number)var1).doubleValue();
         int var14 = INSTANCE.findIndexOfMeasurement(var1, var2, var3);
         double var4 = AQI_LOW[var14];
         double var10 = AQI_HIGH[var14];
         double var12 = var2[var14];
         double var6 = var3[var14];
         double var8 = (var10 - var4) / (var6 - var12) * (var1 - var12) + var4;
         Timber.Forest var16 = Timber.Forest;
         StringBuilder var15 = new StringBuilder("convertMeasurementToiAQI: ");
         var15.append(var1);
         var15.append(" -> ");
         var15.append(var8);
         var15.append(" | iHigh=");
         var15.append(var10);
         var15.append(" iLow=");
         var15.append(var4);
         var15.append(" cHigh=");
         var15.append(var6);
         var15.append(" cLow=");
         var15.append(var12);
         var16.d(var15.toString(), new Object[0]);
         return (int)var8;
      } else {
         return 0;
      }
   }

   public final int getAQIFromIndividualAQI(int[] var1) {
      Intrinsics.checkNotNullParameter(var1, "allAQI");
      Integer var2 = ArraysKt.maxOrNull(var1);
      return var2 != null ? var2 : 0;
   }
}
