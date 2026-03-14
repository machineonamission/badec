package com.blueair.core.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.core.model.DeviceIcp;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.SensorType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0002,-B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015J*\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001f0\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150$2\b\u0010%\u001a\u0004\u0018\u00010\u0018J\u0006\u0010&\u001a\u00020\u001fJ\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006."},
   d2 = {"Lcom/blueair/core/util/IndoorAirRatingRanges;", "Landroid/os/Parcelable;", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "<init>", "([D[D[D[D[D)V", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "rating", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "device", "Lcom/blueair/core/model/HasSensorData;", "sensorType", "Lcom/blueair/core/model/SensorType;", "ratingFromDatapoint", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "value", "", "ratingValue", "", "airRatingsFor", "getRangePosition", "", "numberOfRangesFor", "voteWorstRating", "Lkotlin/Pair;", "sensorTypes", "", "indoorDatapoint", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "IndoorAirRating", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class IndoorAirRatingRanges implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final double[] HCHO_RANGES_DEFAULT = new double[]{(double)399.0F, (double)799.0F, (double)1499.0F, (double)1999.0F, (double)9999.0F};
   private static final double[] PM10_RANGES_DEFAULT = new double[]{(double)20.0F, (double)50.0F, (double)70.0F, (double)100.0F, (double)999.0F};
   private static final double[] PM1_RANGES_DEFAULT = new double[]{(double)8.0F, (double)20.0F, (double)28.0F, (double)40.0F, (double)999.0F};
   private static final double[] PM25_RANGES_G4 = new double[]{(double)10.0F, (double)25.0F, (double)35.0F, (double)50.0F, (double)999.0F};
   private static final double[] PM25_RANGES_ICP = new double[]{(double)15.0F, (double)30.0F, (double)40.0F, (double)79.0F, (double)999.0F};
   private static final double[] PM25_RANGES_LEGACY = new double[]{(double)9.0F, (double)35.0F, (double)150.0F, (double)300.0F, (double)999.0F};
   private static final double[] VOC_RANGES_G4 = new double[]{(double)150.0F, (double)275.0F, (double)375.0F, (double)450.0F, (double)500.0F};
   private static final double[] VOC_RANGES_LEGACY = new double[]{(double)220.0F, (double)450.0F, (double)702.0F, (double)900.0F, (double)999.0F};
   private final double[] hchoRanges;
   private final double[] pm10Ranges;
   private final double[] pm1Ranges;
   private final double[] pm25Ranges;
   private final double[] vocRanges;

   public IndoorAirRatingRanges(double[] var1, double[] var2, double[] var3, double[] var4, double[] var5) {
      Intrinsics.checkNotNullParameter(var1, "pm1Ranges");
      Intrinsics.checkNotNullParameter(var2, "pm10Ranges");
      Intrinsics.checkNotNullParameter(var3, "pm25Ranges");
      Intrinsics.checkNotNullParameter(var4, "vocRanges");
      Intrinsics.checkNotNullParameter(var5, "hchoRanges");
      super();
      this.pm1Ranges = var1;
      this.pm10Ranges = var2;
      this.pm25Ranges = var3;
      this.vocRanges = var4;
      this.hchoRanges = var5;
   }

   private static final float ratingValue$calculateScaledValue(double[] var0, float var1, int var2, float var3, float var4) {
      double var7 = var0[var2];
      double var5 = var0[var2 - 1];
      return (float)(((double)var1 - var5) / (var7 - var5) * (double)var3 + (double)var4);
   }

   public final double[] airRatingsFor(SensorType var1) {
      Intrinsics.checkNotNullParameter(var1, "sensorType");
      switch (IndoorAirRatingRanges.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()]) {
         case 1:
            return this.pm1Ranges;
         case 2:
            return this.pm10Ranges;
         case 3:
            return this.pm25Ranges;
         case 4:
            return this.vocRanges;
         case 5:
            return this.hchoRanges;
         case 6:
         case 7:
         case 8:
         case 9:
         case 10:
            return new double[0];
         default:
            throw new NoWhenBranchMatchedException();
      }
   }

   public final int describeContents() {
      return 0;
   }

   public final double[] getHchoRanges() {
      return this.hchoRanges;
   }

   public final double[] getPm10Ranges() {
      return this.pm10Ranges;
   }

   public final double[] getPm1Ranges() {
      return this.pm1Ranges;
   }

   public final double[] getPm25Ranges() {
      return this.pm25Ranges;
   }

   public final int getRangePosition(float var1, SensorType var2) {
      Intrinsics.checkNotNullParameter(var2, "sensorType");
      double[] var7 = this.airRatingsFor(var2);
      int var6 = var7.length;

      for(int var5 = 0; var5 < var6; ++var5) {
         double var3 = var7[var5];
         if ((double)var1 <= var3) {
            return var5;
         }
      }

      return -1;
   }

   public final double[] getVocRanges() {
      return this.vocRanges;
   }

   public final int numberOfRangesFor(SensorType var1) {
      Intrinsics.checkNotNullParameter(var1, "sensorType");
      return this.airRatingsFor(var1).length;
   }

   public final IndoorAirRating rating(double var1, SensorType var3) {
      Intrinsics.checkNotNullParameter(var3, "sensorType");
      if (var3 == SensorType.HUM) {
         if (var1 <= (double)10.0F) {
            return IndoorAirRatingRanges.IndoorAirRating.POLLUTED.INSTANCE;
         } else if ((double)11.0F <= var1 && var1 <= (double)29.0F) {
            return IndoorAirRatingRanges.IndoorAirRating.MODERATE.INSTANCE;
         } else if ((double)30.0F <= var1 && var1 <= (double)50.0F) {
            return IndoorAirRatingRanges.IndoorAirRating.EXCELLENT.INSTANCE;
         } else if ((double)51.0F <= var1 && var1 <= (double)70.0F) {
            return IndoorAirRatingRanges.IndoorAirRating.MODERATE.INSTANCE;
         } else {
            return (double)71.0F <= var1 && var1 <= (double)100.0F ? (IndoorAirRating)IndoorAirRatingRanges.IndoorAirRating.POLLUTED.INSTANCE : null;
         }
      } else {
         int var4 = IndoorAirRatingRanges.WhenMappings.$EnumSwitchMapping$0[var3.ordinal()];
         double[] var8;
         if (var4 != 1) {
            if (var4 != 2) {
               if (var4 != 3) {
                  if (var4 != 4) {
                     if (var4 != 5) {
                        return null;
                     }

                     var8 = this.hchoRanges;
                  } else {
                     var8 = this.vocRanges;
                  }
               } else {
                  var8 = this.pm25Ranges;
               }
            } else {
               var8 = this.pm10Ranges;
            }
         } else {
            var8 = this.pm1Ranges;
         }

         int var7 = var8.length;
         var4 = 0;

         int var5;
         int var6;
         for(var6 = 0; var4 < var7; var6 = var5) {
            var5 = var6;
            if (var1 > var8[var4]) {
               var5 = var6 + 1;
            }

            ++var4;
         }

         Timber.Forest var9 = Timber.Forest;
         StringBuilder var12 = new StringBuilder("Rating for ");
         var12.append(var3);
         var12.append(", ");
         var12.append(var1);
         var12.append(" is index ");
         var12.append(var6);
         var9.v(var12.toString(), new Object[0]);
         IndoorAirRating var13 = IndoorAirRatingRanges.IndoorAirRating.Companion.fromIndex(var6);
         IndoorAirRating var10 = var13;
         if (var13 == null) {
            var10 = IndoorAirRatingRanges.IndoorAirRating.VERY_POLLUTED.INSTANCE;
         }

         return var10;
      }
   }

   public final IndoorAirRating rating(HasSensorData var1, SensorType var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "sensorType");
      IndoorDatapoint var3 = var1.getLatestSensorDatapoint();
      if (var3 == null) {
         return null;
      } else {
         Float var4 = var3.valueFor(var2);
         return var4 != null ? this.rating((double)var4, var2) : null;
      }
   }

   public final IndoorAirRating ratingFromDatapoint(IndoorDatapoint var1, SensorType var2) {
      Intrinsics.checkNotNullParameter(var1, "dataPoint");
      Intrinsics.checkNotNullParameter(var2, "sensorType");
      Float var3 = var1.valueFor(var2);
      return var3 != null ? this.rating((double)var3, var2) : null;
   }

   public final float ratingValue(float var1, SensorType var2) {
      Intrinsics.checkNotNullParameter(var2, "sensorType");
      if (var2 == SensorType.HUM) {
         if (var1 <= 10.0F) {
            float var13 = (float)10;
            return (var13 - var1) / var13 * (float)25 + (float)50;
         } else if (var1 < 30.0F) {
            float var11 = (float)20;
            var1 = (var11 - (var1 - (float)10)) / var11;
            var11 = (float)25;
            return var1 * var11 + var11;
         } else if (var1 <= 50.0F) {
            return Math.abs(var1 - (float)40) / (float)10 * (float)25;
         } else if (var1 <= 70.0F) {
            var1 = (var1 - (float)50) / (float)20;
            float var5 = (float)25;
            return var1 * var5 + var5;
         } else {
            return (var1 - (float)70) / (float)30 * (float)25 + (float)50;
         }
      } else {
         int var6 = IndoorAirRatingRanges.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
         double[] var10;
         if (var6 != 1) {
            if (var6 != 2) {
               if (var6 != 3) {
                  if (var6 != 4) {
                     if (var6 != 5) {
                        return 50.0F;
                     }

                     var10 = this.hchoRanges;
                  } else {
                     var10 = this.vocRanges;
                  }
               } else {
                  var10 = this.pm25Ranges;
               }
            } else {
               var10 = this.pm10Ranges;
            }
         } else {
            var10 = this.pm1Ranges;
         }

         int var7 = var10.length;
         var6 = 0;

         while(true) {
            if (var6 >= var7) {
               var6 = -1;
               break;
            }

            double var3 = var10[var6];
            if ((double)var1 <= var3) {
               break;
            }

            ++var6;
         }

         if (var6 != 0) {
            if (var6 != 1) {
               if (var6 != 2) {
                  if (var6 != 3) {
                     return var6 != 4 ? 100.0F : ratingValue$calculateScaledValue(var10, var1, var6, 25.0F, 75.0F);
                  } else {
                     return ratingValue$calculateScaledValue(var10, var1, var6, 25.0F, 50.0F);
                  }
               } else {
                  return ratingValue$calculateScaledValue(var10, var1, var6, 25.0F, 25.0F);
               }
            } else {
               return ratingValue$calculateScaledValue(var10, var1, var6, 25.0F, 0.0F);
            }
         } else {
            return 0.0F;
         }
      }
   }

   public final Pair voteWorstRating(List var1, IndoorDatapoint var2) {
      Intrinsics.checkNotNullParameter(var1, "sensorTypes");
      Pair var4 = new Pair(SensorType.PM25, -1);
      Iterator var5 = ((Iterable)var1).iterator();
      Pair var7 = var4;

      while(var5.hasNext()) {
         SensorType var6 = (SensorType)var5.next();
         Float var8;
         if (var2 != null) {
            var8 = var2.valueFor(var6);
         } else {
            var8 = null;
         }

         int var3;
         label24: {
            if (var8 != null) {
               IndoorAirRating var9 = this.rating((double)var8, var6);
               if (var9 != null) {
                  var3 = var9.getRating();
                  break label24;
               }
            }

            var3 = -1;
         }

         if (((Number)var7.getSecond()).intValue() <= var3) {
            var7 = new Pair(var6, var3);
         }
      }

      return var7;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeDoubleArray(this.pm1Ranges);
      var1.writeDoubleArray(this.pm10Ranges);
      var1.writeDoubleArray(this.pm25Ranges);
      var1.writeDoubleArray(this.vocRanges);
      var1.writeDoubleArray(this.hchoRanges);
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0018\u001a\u00020\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u001d"},
      d2 = {"Lcom/blueair/core/util/IndoorAirRatingRanges$Companion;", "", "<init>", "()V", "PM1_RANGES_DEFAULT", "", "getPM1_RANGES_DEFAULT", "()[D", "PM25_RANGES_G4", "getPM25_RANGES_G4", "PM25_RANGES_LEGACY", "getPM25_RANGES_LEGACY", "PM25_RANGES_ICP", "getPM25_RANGES_ICP", "PM10_RANGES_DEFAULT", "getPM10_RANGES_DEFAULT", "VOC_RANGES_G4", "getVOC_RANGES_G4", "VOC_RANGES_LEGACY", "getVOC_RANGES_LEGACY", "HCHO_RANGES_DEFAULT", "getHCHO_RANGES_DEFAULT", "instance", "Lcom/blueair/core/util/IndoorAirRatingRanges;", "device", "Lcom/blueair/core/model/HasSensorData;", "getAirRatingSensors", "", "Lcom/blueair/core/model/SensorType;", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final List getAirRatingSensors(HasSensorData var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         if (var1 instanceof DevicePet20) {
            return CollectionsKt.listOf(new SensorType[]{SensorType.PM25, SensorType.PM1, SensorType.PM10, SensorType.VOC});
         } else {
            return var1 instanceof DeviceBlue40 && ((DeviceBlue40)var1).useTVOCForAqi() ? CollectionsKt.listOf(new SensorType[]{SensorType.PM25, SensorType.VOC}) : CollectionsKt.listOf(SensorType.PM25);
         }
      }

      public final double[] getHCHO_RANGES_DEFAULT() {
         return IndoorAirRatingRanges.HCHO_RANGES_DEFAULT;
      }

      public final double[] getPM10_RANGES_DEFAULT() {
         return IndoorAirRatingRanges.PM10_RANGES_DEFAULT;
      }

      public final double[] getPM1_RANGES_DEFAULT() {
         return IndoorAirRatingRanges.PM1_RANGES_DEFAULT;
      }

      public final double[] getPM25_RANGES_G4() {
         return IndoorAirRatingRanges.PM25_RANGES_G4;
      }

      public final double[] getPM25_RANGES_ICP() {
         return IndoorAirRatingRanges.PM25_RANGES_ICP;
      }

      public final double[] getPM25_RANGES_LEGACY() {
         return IndoorAirRatingRanges.PM25_RANGES_LEGACY;
      }

      public final double[] getVOC_RANGES_G4() {
         return IndoorAirRatingRanges.VOC_RANGES_G4;
      }

      public final double[] getVOC_RANGES_LEGACY() {
         return IndoorAirRatingRanges.VOC_RANGES_LEGACY;
      }

      public final IndoorAirRatingRanges instance(HasSensorData var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         boolean var4 = DeviceKt.isG4orB4orNB(var1);
         int var2 = var1.getPm1Ranges().length;
         boolean var3 = true;
         if (var2 == 0) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         double[] var7;
         if (!var2) {
            var7 = var1.getPm1Ranges();
         } else {
            var7 = this.getPM1_RANGES_DEFAULT();
         }

         if (var1.getPm10Ranges().length == 0) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         double[] var8;
         if (!var2) {
            var8 = var1.getPm10Ranges();
         } else {
            var8 = this.getPM10_RANGES_DEFAULT();
         }

         if (var1.getPm25Ranges().length == 0) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         double[] var5;
         if (!var2) {
            var5 = var1.getPm25Ranges();
         } else if (var4) {
            var5 = this.getPM25_RANGES_G4();
         } else if (var1 instanceof DeviceIcp) {
            var5 = this.getPM25_RANGES_ICP();
         } else {
            var5 = this.getPM25_RANGES_LEGACY();
         }

         Timber.Forest var9 = Timber.Forest;
         StringBuilder var6 = new StringBuilder("IndoorAirRatingRanges: pm25Ranges = ");
         var6.append(ArraysKt.toList(var5));
         var9.d(var6.toString(), new Object[0]);
         if (var1.getVocRanges().length == 0) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         double[] var16;
         if (!var2) {
            var16 = var1.getVocRanges();
         } else if (var4) {
            var16 = this.getVOC_RANGES_G4();
         } else {
            var16 = this.getVOC_RANGES_LEGACY();
         }

         if (var1.getHchoRanges().length == 0) {
            var2 = var3;
         } else {
            var2 = 0;
         }

         double[] var10;
         if (!var2) {
            var10 = var1.getHchoRanges();
         } else {
            var10 = this.getHCHO_RANGES_DEFAULT();
         }

         return new IndoorAirRatingRanges(var7, var8, var5, var16, var10);
      }
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final IndoorAirRatingRanges createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         return new IndoorAirRatingRanges(var1.createDoubleArray(), var1.createDoubleArray(), var1.createDoubleArray(), var1.createDoubleArray(), var1.createDoubleArray());
      }

      public final IndoorAirRatingRanges[] newArray(int var1) {
         return new IndoorAirRatingRanges[var1];
      }
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\u0006\b\t\n\u000b\f\rB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0005\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"},
      d2 = {"Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "", "rating", "", "<init>", "(I)V", "getRating", "()I", "Companion", "EXCELLENT", "GOOD", "MODERATE", "POLLUTED", "VERY_POLLUTED", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$EXCELLENT;", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$GOOD;", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$MODERATE;", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$POLLUTED;", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$VERY_POLLUTED;", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public abstract static class IndoorAirRating {
      public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
      private final int rating;

      private IndoorAirRating(int var1) {
         this.rating = var1;
      }

      // $FF: synthetic method
      public IndoorAirRating(int var1, DefaultConstructorMarker var2) {
         this(var1);
      }

      public final int getRating() {
         return this.rating;
      }

      @Metadata(
         d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002¨\u0006\n"},
         d2 = {"Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$Companion;", "", "<init>", "()V", "fromIndex", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "index", "", "fromRating", "rating", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class Companion {
         private Companion() {
         }

         // $FF: synthetic method
         public Companion(DefaultConstructorMarker var1) {
            this();
         }

         private final IndoorAirRating fromRating(int var1) {
            if (var1 == IndoorAirRatingRanges.IndoorAirRating.EXCELLENT.INSTANCE.getRating()) {
               return IndoorAirRatingRanges.IndoorAirRating.EXCELLENT.INSTANCE;
            } else if (var1 == IndoorAirRatingRanges.IndoorAirRating.GOOD.INSTANCE.getRating()) {
               return IndoorAirRatingRanges.IndoorAirRating.GOOD.INSTANCE;
            } else if (var1 == IndoorAirRatingRanges.IndoorAirRating.MODERATE.INSTANCE.getRating()) {
               return IndoorAirRatingRanges.IndoorAirRating.MODERATE.INSTANCE;
            } else if (var1 == IndoorAirRatingRanges.IndoorAirRating.POLLUTED.INSTANCE.getRating()) {
               return IndoorAirRatingRanges.IndoorAirRating.POLLUTED.INSTANCE;
            } else {
               return var1 == IndoorAirRatingRanges.IndoorAirRating.VERY_POLLUTED.INSTANCE.getRating() ? (IndoorAirRating)IndoorAirRatingRanges.IndoorAirRating.VERY_POLLUTED.INSTANCE : null;
            }
         }

         public final IndoorAirRating fromIndex(int var1) {
            return this.fromRating(var1);
         }
      }

      @Metadata(
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
         d2 = {"Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$EXCELLENT;", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "<init>", "()V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class EXCELLENT extends IndoorAirRating {
         public static final EXCELLENT INSTANCE = new EXCELLENT();

         private EXCELLENT() {
            super(0, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
         d2 = {"Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$GOOD;", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "<init>", "()V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class GOOD extends IndoorAirRating {
         public static final GOOD INSTANCE = new GOOD();

         private GOOD() {
            super(1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
         d2 = {"Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$MODERATE;", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "<init>", "()V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class MODERATE extends IndoorAirRating {
         public static final MODERATE INSTANCE = new MODERATE();

         private MODERATE() {
            super(2, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
         d2 = {"Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$POLLUTED;", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "<init>", "()V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class POLLUTED extends IndoorAirRating {
         public static final POLLUTED INSTANCE = new POLLUTED();

         private POLLUTED() {
            super(3, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
         d2 = {"Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating$VERY_POLLUTED;", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "<init>", "()V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class VERY_POLLUTED extends IndoorAirRating {
         public static final VERY_POLLUTED INSTANCE = new VERY_POLLUTED();

         private VERY_POLLUTED() {
            super(4, (DefaultConstructorMarker)null);
         }
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
