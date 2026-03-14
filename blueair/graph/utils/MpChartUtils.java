package com.blueair.graph.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.blueair.core.model.SensorType;
import com.blueair.viewcore.R;
import com.github.mikephil.charting.data.Entry;
import io.flatcircle.viewhelper.ScreenDensity;
import io.flatcircle.viewhelper.ViewHelperUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u00018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J&\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ&\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ.\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0012J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0012J\u0018\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0016\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0012J\u0016\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ(\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u000eJ&\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&J\u0016\u0010\"\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&J\u0018\u0010+\u001a\u00020#2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010,\u001a\u00020&H\u0002J\u001a\u0010-\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\b\b\u0002\u0010'\u001a\u00020\u000eH\u0002J\u001a\u0010.\u001a\u00020#2\u0006\u0010)\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u000eH\u0002J\u001e\u0010/\u001a\u00020#2\u0006\u0010)\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010%\u001a\u00020&J\u0018\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020#H\u0002J\"\u00103\u001a\b\u0012\u0004\u0012\u000205042\f\u00106\u001a\b\u0012\u0004\u0012\u000205042\u0006\u0010\u0006\u001a\u00020\u0007J$\u00103\u001a\b\u0012\u0004\u0012\u000205042\f\u00106\u001a\b\u0012\u0004\u0012\u000205042\u0006\u00107\u001a\u00020\u0005H\u0002¨\u00069"},
   d2 = {"Lcom/blueair/graph/utils/MpChartUtils;", "", "<init>", "()V", "getSamplingThreshold", "", "timeScale", "Lcom/blueair/graph/utils/ChartTimeScale;", "getYAxisMinimum", "context", "Landroid/content/Context;", "sensorType", "Lcom/blueair/core/model/SensorType;", "indoor", "", "tempIsCelsius", "getYAxisMaximum", "getPaintColorForLineChart", "", "view", "Landroid/view/View;", "paint", "Landroid/graphics/Paint;", "chartHeight", "numberOfSensorRanges", "getGraphIncrements", "", "numberOfIncrements", "getArrayOfColor", "getFloatArrayForGraph", "", "getChartLabelYOffsetDivisor", "showDeviceLearningGraphOverlay", "koreaDeviceLearning", "getScaledValueForChart", "", "realValue", "maxThresholds", "", "isCelsius", "getRealValueFromScaledChartValue", "scaledValue", "dataValue", "getRealDefaultValueFromScaledValue", "maxThresholdArray", "getScaledTemperatureForChart", "getRealTemperatureFromScaledValue", "getRealValueFromScaledChartValueOutdoor", "valueFromPercentageForOutdoor", "highRangeArray", "percentage", "reduceWithDouglasPeucker", "", "Lcom/github/mikephil/charting/data/Entry;", "points", "tolerance", "Line", "graph_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class MpChartUtils {
   public static final MpChartUtils INSTANCE = new MpChartUtils();

   private MpChartUtils() {
   }

   private final int[] getArrayOfColor(View var1, int var2) {
      Context var4 = var1.getContext();
      int[] var5 = new int[100];
      int[] var7 = this.getGraphIncrements(var1, var2 - 1);
      byte var3 = 0;
      if (var2 != 6) {
         if (var2 != 7) {
            for(int var8 = var3; var8 < 100; ++var8) {
               if (var8 <= 25) {
                  var5[var8] = ResourcesCompat.getColor(var4.getResources(), R.color.dark_orange_severity, (Resources.Theme)null);
               } else if (var8 <= 48) {
                  var5[var8] = ResourcesCompat.getColor(var4.getResources(), R.color.orange_severity, (Resources.Theme)null);
               } else if (var8 <= 71) {
                  var5[var8] = ResourcesCompat.getColor(var4.getResources(), R.color.blue_severity, (Resources.Theme)null);
               } else {
                  var5[var8] = ResourcesCompat.getColor(var4.getResources(), R.color.light_blue_severity, (Resources.Theme)null);
               }
            }
         } else {
            for(int var11 = 0; var11 < 100; ++var11) {
               Resources var6 = var4.getResources();
               if (var11 <= var7[0]) {
                  var2 = R.color.gauge_band_6_outdoor;
               } else if (var11 <= var7[1]) {
                  var2 = R.color.gauge_band_5_outdoor;
               } else if (var11 <= var7[2]) {
                  var2 = R.color.gauge_band_4_outdoor;
               } else if (var11 <= var7[3]) {
                  var2 = R.color.gauge_band_3_outdoor;
               } else if (var11 <= var7[4]) {
                  var2 = R.color.gauge_band_2_outdoor;
               } else {
                  var2 = R.color.gauge_band_1_outdoor;
               }

               var5[var11] = ResourcesCompat.getColor(var6, var2, (Resources.Theme)null);
            }
         }
      } else {
         for(int var12 = 0; var12 < 100; ++var12) {
            Resources var13 = var4.getResources();
            if (var12 <= var7[0]) {
               var2 = R.color.color_vpolluted;
            } else if (var12 <= var7[1]) {
               var2 = R.color.color_polluted;
            } else if (var12 <= var7[2]) {
               var2 = R.color.color_moderate;
            } else if (var12 <= var7[3]) {
               var2 = R.color.color_good;
            } else {
               var2 = R.color.color_excellent;
            }

            var5[var12] = ResourcesCompat.getColor(var13, var2, (Resources.Theme)null);
         }
      }

      return var5;
   }

   private final float[] getFloatArrayForGraph() {
      Iterable var2 = (Iterable)(new IntRange(0, 99));
      Collection var1 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var2, 10)));
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         var1.add((float)((IntIterator)var3).nextInt() / 100.0F);
      }

      return CollectionsKt.toFloatArray((Collection)((List)var1));
   }

   private final double getRealDefaultValueFromScaledValue(float var1, double[] var2) {
      Timber.Forest var12 = Timber.Forest;
      StringBuilder var13 = new StringBuilder("getRealDefaultValueFromScaledValue: scaledValue = ");
      var13.append(var1);
      var13.append(", maxThresholdArray = ");
      var13.append(ArraysKt.toList(var2));
      var12.d(var13.toString(), new Object[0]);
      int var10 = 100 / var2.length;
      Timber.Forest var17 = Timber.Forest;
      StringBuilder var16 = new StringBuilder("getRealDefaultValueFromScaledValue: sizeOfIncrement = ");
      var16.append(var10);
      var17.d(var16.toString(), new Object[0]);
      if (var1 <= 0.0F) {
         return (double)0.0F;
      } else if (var1 <= (float)var10) {
         return (double)var1 / ((double)var10 / var2[0]);
      } else {
         int var11 = var2.length;
         if (2 <= var11) {
            int var9 = 2;

            while(true) {
               if (var1 <= (float)(var9 * var10)) {
                  double var7 = (double)var10;
                  var11 = var9 - 1;
                  double var5 = var2[var11];
                  double var3 = var2[var9 - 2];
                  var5 = var7 / (var5 - var3);
                  return ((double)(var1 - (float)(var11 * var10)) + var3 * var5) / var5;
               }

               if (var9 == var11) {
                  break;
               }

               ++var9;
            }
         }

         return ArraysKt.last(var2);
      }
   }

   private final double getRealTemperatureFromScaledValue(float var1, boolean var2) {
      double var3;
      double var5;
      if (!var2) {
         var3 = (double)100.0F;
         if (!(var1 <= 25.0F) && !(var1 <= 50.0F) && !(var1 <= 75.0F) && !(var1 <= 100.0F)) {
            return (double)40.0F;
         }

         var5 = (double)var1 * (double)105.0F;
      } else {
         var3 = (double)2.5F;
         if (!(var1 <= 25.0F) && !(var1 <= 50.0F) && !(var1 <= 75.0F) && !(var1 <= 100.0F)) {
            return (double)40.0F;
         }

         var5 = (double)var1;
      }

      return var5 / var3;
   }

   // $FF: synthetic method
   static double getRealTemperatureFromScaledValue$default(MpChartUtils var0, float var1, boolean var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = true;
      }

      return var0.getRealTemperatureFromScaledValue(var1, var2);
   }

   private final double getScaledTemperatureForChart(double var1, boolean var3) {
      if (!var3) {
         Timber.Forest var4 = Timber.Forest;
         StringBuilder var5 = new StringBuilder("getScaledTemperatureForChart: FAHRENHEIT realValue = ");
         var5.append(var1);
         var4.d(var5.toString(), new Object[0]);
         if (var1 < (double)32.0F) {
            return (double)0.0F;
         } else if (var1 <= (double)50.0F) {
            return var1 * (double)100.0F / (double)105.0F;
         } else if (var1 <= (double)70.0F) {
            return var1 * (double)100.0F / (double)105;
         } else if (var1 <= (double)85.0F) {
            return var1 * (double)100.0F / (double)105;
         } else {
            return var1 <= (double)105.0F ? var1 * (double)100.0F / (double)105 : (double)100.0F;
         }
      } else if (var1 <= (double)10.0F) {
         return var1 * (double)2.5F;
      } else if (var1 <= (double)20.0F) {
         return var1 * (double)2.5F;
      } else if (var1 <= (double)30.0F) {
         return var1 * (double)2.5F;
      } else {
         return var1 <= (double)40.0F ? var1 * (double)2.5F : (double)100.0F;
      }
   }

   // $FF: synthetic method
   static double getScaledTemperatureForChart$default(MpChartUtils var0, double var1, boolean var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var3 = true;
      }

      return var0.getScaledTemperatureForChart(var1, var3);
   }

   // $FF: synthetic method
   public static double getScaledValueForChart$default(MpChartUtils var0, float var1, SensorType var2, double[] var3, boolean var4, int var5, Object var6) {
      if ((var5 & 8) != 0) {
         var4 = true;
      }

      return var0.getScaledValueForChart(var1, var2, var3, var4);
   }

   private final List reduceWithDouglasPeucker(List var1, float var2) {
      if (var1.size() < 2) {
         return var1;
      } else {
         Line var8 = new Line((Entry)var1.get(0), (Entry)var1.get(var1.size() - 1));
         float var4 = 0.0F;
         int var7 = 0;

         float var3;
         for(int var6 = 1; var6 < var1.size() - 1; var4 = var3) {
            float var5 = var8.distance((Entry)var1.get(var6));
            var3 = var4;
            if (var5 > var4) {
               var7 = var6;
               var3 = var5;
            }

            ++var6;
         }

         if (var4 > var2) {
            List var9 = var1.subList(0, var7 + 1);
            List var12 = var1.subList(var7, var1.size());
            var1 = this.reduceWithDouglasPeucker((List)(new ArrayList((Collection)var9)), var2);
            var12 = this.reduceWithDouglasPeucker((List)(new ArrayList((Collection)var12)), var2);
            ArrayList var11 = new ArrayList((Collection)var1);
            ArrayList var14 = new ArrayList((Collection)var12.subList(1, var12.size()));
            return (List)(new ArrayList((Collection)CollectionsKt.plus((Collection)var11, (Iterable)var14)));
         } else {
            return (List)var8.getPoints();
         }
      }
   }

   private final double valueFromPercentageForOutdoor(double[] var1, double var2) {
      int var10 = 0;
      List var14 = CollectionsKt.mutableListOf(new Double[]{(double)0.0F});
      Iterable var15 = (Iterable)ArraysKt.dropLast(var1, 0);
      Collection var13 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var15, 10)));
      Iterator var21 = var15.iterator();

      while(var21.hasNext()) {
         var13.add(((Number)var21.next()).doubleValue() + 0.01);
      }

      var14.addAll((Collection)((List)var13));
      double[] var20 = CollectionsKt.toDoubleArray((Collection)var14);
      int var12 = var1.length;
      if (var2 <= (double)0.0F) {
         return (double)0.0F;
      } else if (var2 >= (double)99.0F) {
         return var1[var12 - 1];
      } else {
         while(var10 < 6) {
            double var8 = (double)var10;
            int var11 = var10 + 1;
            double var4 = (double)var11;
            if (var2 > 16.666666666666668 * var8 && var2 <= 16.666666666666668 * var4) {
               if (var10 == 0) {
                  return var2 * var1[var10] * (double)var12 / (double)100;
               }

               double var6 = (double)100.0F / (double)var12;
               var8 *= var6;
               var2 = (var2 - var8) / (var6 * var4 - var8);
               var4 = var1[var10];
               var6 = var20[var10];
               return var4 * var2 - var2 * var6 + var6;
            }

            var10 = var11;
         }

         return (double)0.0F;
      }
   }

   public final float getChartLabelYOffsetDivisor(View var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      int var3 = -1;
      if (var2 != 6) {
         if (var2 != 7) {
            ScreenDensity var6 = ViewHelperUtil.INSTANCE.calculateScreenDensity(var1);
            if (var6 != null) {
               var3 = MpChartUtils.WhenMappings.$EnumSwitchMapping$2[var6.ordinal()];
            }

            if (var3 != 1) {
               if (var3 != 2) {
                  if (var3 != 3) {
                     return var3 != 4 ? 24.0F : 28.0F;
                  } else {
                     return 26.0F;
                  }
               } else {
                  return 32.0F;
               }
            } else {
               return 34.0F;
            }
         } else {
            ScreenDensity var5 = ViewHelperUtil.INSTANCE.calculateScreenDensity(var1);
            if (var5 != null) {
               var3 = MpChartUtils.WhenMappings.$EnumSwitchMapping$2[var5.ordinal()];
            }

            if (var3 != 1) {
               return var3 != 2 ? 32.0F : 48.0F;
            } else {
               return 55.0F;
            }
         }
      } else {
         ScreenDensity var4 = ViewHelperUtil.INSTANCE.calculateScreenDensity(var1);
         if (var4 != null) {
            var3 = MpChartUtils.WhenMappings.$EnumSwitchMapping$2[var4.ordinal()];
         }

         if (var3 != 1) {
            if (var3 != 2) {
               if (var3 != 3) {
                  if (var3 != 4) {
                     return var3 != 5 ? 32.0F : 30.0F;
                  } else {
                     return 34.0F;
                  }
               } else {
                  return 32.0F;
               }
            } else {
               return 38.0F;
            }
         } else {
            return 40.0F;
         }
      }
   }

   public final int[] getGraphIncrements(View var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      byte var4 = 80;
      int var3 = 22;
      int var7 = -1;
      if (var2 != 5) {
         byte var9 = 71;
         int var8 = 48;
         if (var2 != 6) {
            ScreenDensity var36 = ViewHelperUtil.INSTANCE.calculateScreenDensity(var1);
            if (var36 != null) {
               var2 = MpChartUtils.WhenMappings.$EnumSwitchMapping$2[var36.ordinal()];
            }

            var36 = ViewHelperUtil.INSTANCE.calculateScreenDensity(var1);
            if (var36 != null) {
               var2 = MpChartUtils.WhenMappings.$EnumSwitchMapping$2[var36.ordinal()];
            }

            ScreenDensity var13 = ViewHelperUtil.INSTANCE.calculateScreenDensity(var1);
            if (var13 != null) {
               var2 = MpChartUtils.WhenMappings.$EnumSwitchMapping$2[var13.ordinal()];
            }

            return new int[]{25, 48, 71, 100};
         } else {
            ScreenDensity var32 = ViewHelperUtil.INSTANCE.calculateScreenDensity(var1);
            if (var32 == null) {
               var2 = -1;
            } else {
               var2 = MpChartUtils.WhenMappings.$EnumSwitchMapping$2[var32.ordinal()];
            }

            byte var28 = (byte)var3;
            if (var2 != 1) {
               var28 = (byte)var3;
               if (var2 != 2) {
                  if (var2 != 3) {
                     if (var2 != 4) {
                        var28 = 16;
                     } else {
                        var28 = 18;
                     }
                  } else {
                     var28 = 20;
                  }
               }
            }

            var32 = ViewHelperUtil.INSTANCE.calculateScreenDensity(var1);
            if (var32 == null) {
               var2 = -1;
            } else {
               var2 = MpChartUtils.WhenMappings.$EnumSwitchMapping$2[var32.ordinal()];
            }

            var3 = (byte)37;
            byte var6 = var3;
            if (var2 != 1) {
               var6 = var3;
               if (var2 != 2) {
                  if (var2 != 3) {
                     if (var2 != 4) {
                        var6 = 32;
                     } else {
                        var6 = 34;
                     }
                  } else {
                     var6 = 36;
                  }
               }
            }

            var32 = ViewHelperUtil.INSTANCE.calculateScreenDensity(var1);
            if (var32 == null) {
               var2 = -1;
            } else {
               var2 = MpChartUtils.WhenMappings.$EnumSwitchMapping$2[var32.ordinal()];
            }

            if (var2 != 1) {
               if (var2 != 2) {
                  if (var2 != 3) {
                     if (var2 != 4) {
                        var2 = var8;
                     } else {
                        var2 = 50;
                     }
                  } else {
                     var2 = 52;
                  }
               } else {
                  var2 = 54;
               }
            } else {
               var2 = 55;
            }

            var32 = ViewHelperUtil.INSTANCE.calculateScreenDensity(var1);
            if (var32 == null) {
               var8 = -1;
            } else {
               var8 = MpChartUtils.WhenMappings.$EnumSwitchMapping$2[var32.ordinal()];
            }

            if (var8 != 1) {
               if (var8 != 2) {
                  var3 = var9;
                  if (var8 != 3) {
                     if (var8 != 4) {
                        var3 = (byte)67;
                     } else {
                        var3 = (byte)69;
                     }
                  }
               } else {
                  var3 = (byte)72;
               }
            } else {
               var3 = (byte)73;
            }

            ScreenDensity var12 = ViewHelperUtil.INSTANCE.calculateScreenDensity(var1);
            if (var12 != null) {
               var7 = MpChartUtils.WhenMappings.$EnumSwitchMapping$2[var12.ordinal()];
            }

            if (var7 != 1) {
               if (var7 != 2) {
                  if (var7 != 3) {
                     if (var7 == 4) {
                        var4 = 82;
                     }
                  } else {
                     var4 = 84;
                  }
               } else {
                  var4 = 85;
               }
            } else {
               var4 = 86;
            }

            return new int[]{var28, var6, var2, var3, var4, 100};
         }
      } else {
         ScreenDensity var10 = ViewHelperUtil.INSTANCE.calculateScreenDensity(var1);
         if (var10 == null) {
            var2 = -1;
         } else {
            var2 = MpChartUtils.WhenMappings.$EnumSwitchMapping$2[var10.ordinal()];
         }

         byte var5;
         if (var2 != 1) {
            var5 = (byte)var3;
            if (var2 != 2) {
               var5 = 21;
            }
         } else {
            var5 = 23;
         }

         var10 = ViewHelperUtil.INSTANCE.calculateScreenDensity(var1);
         if (var10 == null) {
            var2 = -1;
         } else {
            var2 = MpChartUtils.WhenMappings.$EnumSwitchMapping$2[var10.ordinal()];
         }

         if (var2 != 1) {
            if (var2 != 2) {
               if (var2 != 3) {
                  var2 = 38;
               } else {
                  var2 = 40;
               }
            } else {
               var2 = 42;
            }
         } else {
            var2 = 44;
         }

         var10 = ViewHelperUtil.INSTANCE.calculateScreenDensity(var1);
         if (var10 == null) {
            var3 = -1;
         } else {
            var3 = MpChartUtils.WhenMappings.$EnumSwitchMapping$2[var10.ordinal()];
         }

         if (var3 != 1) {
            if (var3 != 2) {
               if (var3 != 3) {
                  var3 = 56;
               } else {
                  var3 = 58;
               }
            } else {
               var3 = 60;
            }
         } else {
            var3 = 62;
         }

         ScreenDensity var11 = ViewHelperUtil.INSTANCE.calculateScreenDensity(var1);
         if (var11 != null) {
            var7 = MpChartUtils.WhenMappings.$EnumSwitchMapping$2[var11.ordinal()];
         }

         if (var7 != 1) {
            if (var7 != 2) {
               if (var7 != 3) {
                  var4 = 74;
               } else {
                  var4 = 76;
               }
            } else {
               var4 = 78;
            }
         }

         return new int[]{var5, var2, var3, var4, 100};
      }
   }

   public final int getPaintColorForLineChart(View var1, Paint var2, float var3, SensorType var4, int var5) {
      Intrinsics.checkNotNullParameter(var1, "view");
      Intrinsics.checkNotNullParameter(var2, "paint");
      Intrinsics.checkNotNullParameter(var4, "sensorType");
      int var6 = MpChartUtils.WhenMappings.$EnumSwitchMapping$1[var4.ordinal()];
      if (var6 != 1 && var6 != 2) {
         var2.setShader((Shader)(new LinearGradient(0.0F, 25.0F, 0.0F, var3, this.getArrayOfColor(var1, var5), this.getFloatArrayForGraph(), TileMode.CLAMP)));
         return var2.getColor();
      } else {
         var2.setShader((Shader)null);
         return ContextCompat.getColor(var1.getContext(), R.color.bruno_blue);
      }
   }

   public final double getRealValueFromScaledChartValue(float var1, SensorType var2, boolean var3, double[] var4) {
      Intrinsics.checkNotNullParameter(var2, "sensorType");
      Intrinsics.checkNotNullParameter(var4, "maxThresholds");
      Timber.Forest var5 = Timber.Forest;
      StringBuilder var6 = new StringBuilder("getRealValueFromScaledChartValue: sensorType = ");
      var6.append(var2);
      var6.append(", maxThresholds = ");
      var6.append(ArraysKt.toList(var4));
      var5.d(var6.toString(), new Object[0]);
      switch (MpChartUtils.WhenMappings.$EnumSwitchMapping$1[var2.ordinal()]) {
         case 1:
            return this.getRealTemperatureFromScaledValue(var1, var3);
         case 2:
            return Math.min(Math.max((double)0.0F, (double)var1), (double)100.0F);
         case 3:
         case 4:
         case 5:
         case 6:
         case 7:
            return this.getRealDefaultValueFromScaledValue(var1, var4);
         case 8:
         case 9:
         case 10:
            return (double)var1;
         default:
            throw new NoWhenBranchMatchedException();
      }
   }

   public final double getRealValueFromScaledChartValueOutdoor(double var1, SensorType var3, double[] var4) {
      Intrinsics.checkNotNullParameter(var3, "sensorType");
      Intrinsics.checkNotNullParameter(var4, "maxThresholds");
      double var5 = var1;
      if (var3 != SensorType.TMP) {
         if (var3 == SensorType.HUM) {
            var5 = var1;
         } else {
            var5 = this.valueFromPercentageForOutdoor(var4, var1);
         }
      }

      return var5;
   }

   public final float getSamplingThreshold(ChartTimeScale var1) {
      Intrinsics.checkNotNullParameter(var1, "timeScale");
      int var2 = MpChartUtils.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
      if (var2 != 1) {
         if (var2 != 2) {
            if (var2 == 3) {
               return 6.0F;
            } else {
               throw new NoWhenBranchMatchedException();
            }
         } else {
            return 4.0F;
         }
      } else {
         return 0.0F;
      }
   }

   public final double getScaledValueForChart(float var1, SensorType var2, double[] var3, boolean var4) {
      Intrinsics.checkNotNullParameter(var2, "sensorType");
      Intrinsics.checkNotNullParameter(var3, "maxThresholds");
      double var5;
      switch (MpChartUtils.WhenMappings.$EnumSwitchMapping$1[var2.ordinal()]) {
         case 1:
            var5 = this.getScaledTemperatureForChart((double)var1, var4);
            break;
         case 2:
            var5 = Math.max((double)0.0F, (double)var1);
            break;
         case 3:
         case 4:
         case 5:
         case 6:
         case 7:
            var5 = this.getScaledValueForChart(var1, var3);
            break;
         case 8:
         case 9:
         case 10:
            var5 = (double)var1;
            break;
         default:
            throw new NoWhenBranchMatchedException();
      }

      return Math.min((double)100.0F, var5);
   }

   public final double getScaledValueForChart(float var1, double[] var2) {
      Intrinsics.checkNotNullParameter(var2, "maxThresholds");
      double var3 = (double)100.0F / (double)var2.length;
      int var12 = var2.length;
      int var11 = 0;

      while(true) {
         if (var11 >= var12) {
            var11 = -1;
            break;
         }

         double var5 = var2[var11];
         if ((double)var1 < var5) {
            break;
         }

         ++var11;
      }

      if (var1 <= 0.0F) {
         return (double)0.0F;
      } else {
         double var9 = (double)var1;
         if (var9 >= ArraysKt.last(var2)) {
            return (double)100.0F;
         } else if (var11 == 0) {
            return var9 * (var3 / var2[0]);
         } else {
            double var13 = (double)var11;
            double var7 = var2[var11 - 1];
            return var13 * var3 + (var9 - var7) * (var3 / (var2[var11] - var7));
         }
      }
   }

   public final float getYAxisMaximum(Context var1, SensorType var2, boolean var3, boolean var4) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "sensorType");
      if (MpChartUtils.WhenMappings.$EnumSwitchMapping$1[var2.ordinal()] == 1) {
         if (var4) {
            return var3 ? 40.0F : 60.0F;
         } else {
            return var3 ? 104.0F : 140.0F;
         }
      } else {
         return 100.0F;
      }
   }

   public final float getYAxisMinimum(Context var1, SensorType var2, boolean var3, boolean var4) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "sensorType");
      if (MpChartUtils.WhenMappings.$EnumSwitchMapping$1[var2.ordinal()] == 1) {
         if (var4) {
            return var3 ? -10.0F : -20.0F;
         } else {
            return var3 ? 14.0F : -4.0F;
         }
      } else {
         return 0.0F;
      }
   }

   public final List reduceWithDouglasPeucker(List var1, ChartTimeScale var2) {
      Intrinsics.checkNotNullParameter(var1, "points");
      Intrinsics.checkNotNullParameter(var2, "timeScale");
      int var3 = MpChartUtils.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
      if (var3 != 1 && var3 != 2 && var3 != 3) {
         throw new NoWhenBranchMatchedException();
      } else {
         return var1;
      }
   }

   public final boolean showDeviceLearningGraphOverlay(boolean var1, SensorType var2) {
      Intrinsics.checkNotNullParameter(var2, "sensorType");
      return var1 && var2 != SensorType.TMP && var2 != SensorType.HUM;
   }

   @Metadata(
      d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0003R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"},
      d2 = {"Lcom/blueair/graph/utils/MpChartUtils$Line;", "", "p1", "Lcom/github/mikephil/charting/data/Entry;", "p2", "<init>", "(Lcom/github/mikephil/charting/data/Entry;Lcom/github/mikephil/charting/data/Entry;)V", "points", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPoints", "()Ljava/util/ArrayList;", "sxey", "", "exsy", "dx", "dy", "length", "distance", "pt", "graph_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   private static final class Line {
      private final float dx;
      private final float dy;
      private final float exsy;
      private final float length;
      private final ArrayList points;
      private final float sxey;

      public Line(Entry var1, Entry var2) {
         Intrinsics.checkNotNullParameter(var1, "p1");
         Intrinsics.checkNotNullParameter(var2, "p2");
         super();
         float var3 = var1.getX() - var2.getX();
         this.dx = var3;
         float var4 = var1.getY() - var2.getY();
         this.dy = var4;
         this.sxey = var1.getX() * var2.getY();
         this.exsy = var2.getX() * var1.getY();
         this.length = (float)Math.sqrt((double)(var3 * var3 + var4 * var4));
         this.points = CollectionsKt.arrayListOf(new Entry[]{var1, var2});
      }

      public final float distance(Entry var1) {
         Intrinsics.checkNotNullParameter(var1, "pt");
         return Math.abs(this.dy * var1.getX() - this.dx * var1.getY() + this.sxey - this.exsy) / this.length;
      }

      public final ArrayList getPoints() {
         return this.points;
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
      public static final int[] $EnumSwitchMapping$1;
      public static final int[] $EnumSwitchMapping$2;

      static {
         int[] var0 = new int[ChartTimeScale.values().length];

         try {
            var0[ChartTimeScale.DAY.ordinal()] = 1;
         } catch (NoSuchFieldError var19) {
         }

         try {
            var0[ChartTimeScale.WEEK.ordinal()] = 2;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[ChartTimeScale.MONTH.ordinal()] = 3;
         } catch (NoSuchFieldError var17) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[SensorType.values().length];

         try {
            var0[SensorType.TMP.ordinal()] = 1;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[SensorType.HUM.ordinal()] = 2;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[SensorType.PM1.ordinal()] = 3;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[SensorType.PM10.ordinal()] = 4;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[SensorType.PM25.ordinal()] = 5;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[SensorType.VOC.ordinal()] = 6;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[SensorType.HCHO.ordinal()] = 7;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[SensorType.FAN.ordinal()] = 8;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[SensorType.WEIGHT.ordinal()] = 9;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[SensorType.RPM.ordinal()] = 10;
         } catch (NoSuchFieldError var7) {
         }

         $EnumSwitchMapping$1 = var0;
         var0 = new int[ScreenDensity.values().length];

         try {
            var0[ScreenDensity.XXXHIGH.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[ScreenDensity.XXHIGH.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[ScreenDensity.XHIGH.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[ScreenDensity.HIGH.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[ScreenDensity.LOW.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$2 = var0;
      }
   }
}
