package com.blueair.graph.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¨\u0006\f"},
   d2 = {"Lcom/blueair/graph/utils/MpOutdoorChartUtils;", "", "<init>", "()V", "getRealValueFromScaledChartValueOutdoor", "", "scaledValue", "maxThresholds", "", "valueFromPercentageForOutdoor", "highRangeArray", "percentage", "graph_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class MpOutdoorChartUtils {
   public static final MpOutdoorChartUtils INSTANCE = new MpOutdoorChartUtils();

   private MpOutdoorChartUtils() {
   }

   private final double valueFromPercentageForOutdoor(double[] var1, double var2) {
      int var12 = 0;
      List var16 = CollectionsKt.mutableListOf(new Double[]{(double)0.0F});
      Iterable var17 = (Iterable)ArraysKt.dropLast(var1, 0);
      Collection var15 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var17, 10)));
      Iterator var23 = var17.iterator();

      while(var23.hasNext()) {
         var15.add(((Number)var23.next()).doubleValue() + 0.01);
      }

      var16.addAll((Collection)((List)var15));
      double[] var22 = CollectionsKt.toDoubleArray((Collection)var16);
      int var13 = var1.length;
      if (var2 <= (double)0.0F) {
         return (double)0.0F;
      } else if (var2 >= (double)99.0F) {
         return var1[var13 - 1];
      } else {
         double var8 = (double)var13;
         double var6 = (double)100.0F / var8;
         int var14 = var13 - 1;
         if (var14 >= 0) {
            while(true) {
               double var4 = (double)var12 * var6;
               var13 = var12 + 1;
               double var10 = (double)var13 * var6;
               if (var2 > var4 && var2 <= var10) {
                  if (var12 == 0) {
                     return var2 * var1[var12] * var8 / (double)100;
                  }

                  var6 = (var2 - var4) / (var10 - var4);
                  var4 = var1[var12];
                  var2 = var22[var12];
                  return var4 * var6 - var6 * var2 + var2;
               }

               if (var12 == var14) {
                  break;
               }

               var12 = var13;
            }
         }

         return (double)0.0F;
      }
   }

   public final double getRealValueFromScaledChartValueOutdoor(double var1, double[] var3) {
      Intrinsics.checkNotNullParameter(var3, "maxThresholds");
      return this.valueFromPercentageForOutdoor(var3, var1);
   }
}
