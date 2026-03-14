package com.blueair.graph.utils;

import android.content.Context;
import com.blueair.viewcore.R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0015J(\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0015H\u0002¨\u0006\u0019"},
   d2 = {"Lcom/blueair/graph/utils/SensorRangeUtils;", "", "<init>", "()V", "percentageFromIndoorRange", "", "ranges", "", "value", "percentageFromRange", "thresholds", "getSeekbarValue", "", "progress", "", "minThresh", "maxThresh", "mapValueToSeverityPM25Indoor", "", "context", "Landroid/content/Context;", "", "mapValueToSeverityVOCIndoor", "mapValueToSeverity", "severity_array_id", "graph_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SensorRangeUtils {
   public static final SensorRangeUtils INSTANCE = new SensorRangeUtils();

   private SensorRangeUtils() {
   }

   private final String mapValueToSeverity(Context var1, float var2, int var3, int[] var4) {
      String[] var5 = var1.getResources().getStringArray(var3);
      Iterator var6 = ((Iterable)ArraysKt.getIndices(var4)).iterator();

      do {
         if (!var6.hasNext()) {
            var7 = null;
            break;
         }

         var7 = var6.next();
      } while(!(var2 < (float)var4[((Number)var7).intValue()]));

      Integer var8 = (Integer)var7;
      if (var8 != null) {
         var3 = var8;
      } else {
         var3 = var4.length - 1;
      }

      String var9 = var5[var3];
      Intrinsics.checkNotNullExpressionValue(var9, "get(...)");
      return var9;
   }

   public final float getSeekbarValue(int var1, double[] var2, double[] var3) {
      Intrinsics.checkNotNullParameter(var2, "minThresh");
      Intrinsics.checkNotNullParameter(var3, "maxThresh");
      float var6;
      byte var7;
      if (var1 <= 25) {
         var7 = 0;
         var6 = 0.0F;
      } else if (26 <= var1 && var1 < 51) {
         var7 = 1;
         var6 = 25.0F;
      } else if (51 <= var1 && var1 < 76) {
         var7 = 2;
         var6 = 50.0F;
      } else {
         var7 = 3;
         var6 = 75.0F;
      }

      double var4 = var2[var7];
      return (float)var4 + ((float)var1 - var6) * ((float)var3[var7] - (float)var4) / 25.0F;
   }

   public final String mapValueToSeverityPM25Indoor(Context var1, float var2, int[] var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var3, "thresholds");
      return this.mapValueToSeverity(var1, var2, R.array.severity_strings, var3);
   }

   public final String mapValueToSeverityVOCIndoor(Context var1, float var2, int[] var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var3, "thresholds");
      return this.mapValueToSeverity(var1, var2, R.array.severity_strings, var3);
   }

   public final double percentageFromIndoorRange(double[] var1, double var2) {
      Intrinsics.checkNotNullParameter(var1, "ranges");
      boolean var4;
      if (var1.length == 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      return !var4 ? this.percentageFromRange(var1, var2) : Double.MAX_VALUE;
   }

   public final double percentageFromRange(double[] var1, double var2) {
      Intrinsics.checkNotNullParameter(var1, "thresholds");
      int var10 = var1.length;
      byte var11 = 0;
      if (var10 == 0) {
         var10 = 1;
      } else {
         var10 = 0;
      }

      if (!var10) {
         double var4 = (double)100.0F / (double)(var1.length - 1);
         if (var2 == (double)0.0F) {
            return (double)0.0F;
         }

         if (var2 > var1[var1.length - 1]) {
            return (double)99.0F;
         }

         int var12 = var1.length;

         for(int var15 = var11; var15 < var12 - 1; ++var15) {
            double var6 = var1[var15];
            if (var2 > var6) {
               double var8 = var1[var15 + 1];
               if (var2 <= var8) {
                  var2 = (var2 - var6) / (var8 - var6);
                  return (double)var15 * var4 + var2 * var4;
               }
            }
         }
      }

      return (double)0.0F;
   }
}
