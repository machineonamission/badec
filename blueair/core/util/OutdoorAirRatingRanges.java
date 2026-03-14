package com.blueair.core.util;

import com.blueair.core.model.PollutantType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010$\u001a\u00020%J\u000e\u0010*\u001a\u00020'2\u0006\u0010$\u001a\u00020%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007¨\u0006+"},
   d2 = {"Lcom/blueair/core/util/OutdoorAirRatingRanges;", "", "<init>", "()V", "PM25_LOW", "", "getPM25_LOW", "()[D", "PM25_HIGH", "getPM25_HIGH", "PM10_LOW", "getPM10_LOW", "PM10_HIGH", "getPM10_HIGH", "O3_LOW", "getO3_LOW", "O3_HIGH", "getO3_HIGH", "SO2_LOW", "getSO2_LOW", "SO2_HIGH", "getSO2_HIGH", "CO_LOW", "getCO_LOW", "CO_HIGH", "getCO_HIGH", "NO2_LOW", "getNO2_LOW", "NO2_HIGH", "getNO2_HIGH", "AQI_LOW", "getAQI_LOW", "AQI_HIGH", "getAQI_HIGH", "airRatingsFor", "Lcom/blueair/core/util/OutdoorRanges;", "pollutantType", "Lcom/blueair/core/model/PollutantType;", "getPollutantRangePosition", "", "value", "", "getMaxPollutantRangePosition", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class OutdoorAirRatingRanges {
   private static final double[] AQI_HIGH = new double[]{(double)50.0F, (double)100.0F, (double)150.0F, (double)200.0F, (double)500.0F};
   private static final double[] AQI_LOW = new double[]{(double)0.0F, (double)51.0F, (double)101.0F, (double)151.0F, (double)201.0F};
   private static final double[] CO_HIGH = new double[]{4.4, 9.4, 12.4, 15.4, 30.4, 50.4};
   private static final double[] CO_LOW = new double[]{(double)0.0F, (double)4.5F, (double)9.5F, (double)12.5F, (double)15.5F, (double)30.5F};
   public static final OutdoorAirRatingRanges INSTANCE = new OutdoorAirRatingRanges();
   private static final double[] NO2_HIGH = new double[]{(double)53.0F, (double)100.0F, (double)360.0F, (double)649.0F, (double)1249.0F, (double)2049.0F};
   private static final double[] NO2_LOW = new double[]{(double)0.0F, (double)54.0F, (double)101.0F, (double)361.0F, (double)650.0F, (double)1250.0F};
   private static final double[] O3_HIGH = new double[]{(double)59.0F, (double)75.0F, (double)95.0F, (double)115.0F, (double)374.0F, (double)604.0F};
   private static final double[] O3_LOW = new double[]{(double)0.0F, (double)60.0F, (double)76.0F, (double)96.0F, (double)116.0F, (double)375.0F};
   private static final double[] PM10_HIGH = new double[]{(double)20.0F, (double)50.0F, (double)70.0F, (double)100.0F, (double)400.0F, (double)600.0F};
   private static final double[] PM10_LOW = new double[]{(double)0.0F, (double)21.0F, (double)51.0F, (double)71.0F, (double)101.0F, (double)401.0F};
   private static final double[] PM25_HIGH = new double[]{(double)12.0F, 35.4, 55.4, 150.4, 250.4, 500.4};
   private static final double[] PM25_LOW = new double[]{(double)0.0F, 12.1, (double)35.5F, (double)55.5F, (double)150.5F, (double)250.5F};
   private static final double[] SO2_HIGH = new double[]{(double)35.0F, (double)75.0F, (double)185.0F, (double)304.0F, (double)604.0F, (double)1004.0F};
   private static final double[] SO2_LOW = new double[]{(double)0.0F, (double)36.0F, (double)76.0F, (double)186.0F, (double)305.0F, (double)605.0F};

   private OutdoorAirRatingRanges() {
   }

   public final OutdoorRanges airRatingsFor(PollutantType var1) {
      Intrinsics.checkNotNullParameter(var1, "pollutantType");
      if (Intrinsics.areEqual(var1, PollutantType.AQI.INSTANCE)) {
         return OutdoorRanges.AQI.INSTANCE;
      } else if (Intrinsics.areEqual(var1, PollutantType.CO.INSTANCE)) {
         return OutdoorRanges.CO.INSTANCE;
      } else if (Intrinsics.areEqual(var1, PollutantType.NO2.INSTANCE)) {
         return OutdoorRanges.NO2.INSTANCE;
      } else if (Intrinsics.areEqual(var1, PollutantType.O3.INSTANCE)) {
         return OutdoorRanges.O3.INSTANCE;
      } else if (Intrinsics.areEqual(var1, PollutantType.PM10.INSTANCE)) {
         return OutdoorRanges.PM10.INSTANCE;
      } else if (Intrinsics.areEqual(var1, PollutantType.PM25.INSTANCE)) {
         return OutdoorRanges.PM25.INSTANCE;
      } else if (Intrinsics.areEqual(var1, PollutantType.SO2.INSTANCE)) {
         return OutdoorRanges.SO2.INSTANCE;
      } else {
         throw new NoWhenBranchMatchedException();
      }
   }

   public final double[] getAQI_HIGH() {
      return AQI_HIGH;
   }

   public final double[] getAQI_LOW() {
      return AQI_LOW;
   }

   public final double[] getCO_HIGH() {
      return CO_HIGH;
   }

   public final double[] getCO_LOW() {
      return CO_LOW;
   }

   public final int getMaxPollutantRangePosition(PollutantType var1) {
      Intrinsics.checkNotNullParameter(var1, "pollutantType");
      return this.airRatingsFor(var1).getHigh().length - 1;
   }

   public final double[] getNO2_HIGH() {
      return NO2_HIGH;
   }

   public final double[] getNO2_LOW() {
      return NO2_LOW;
   }

   public final double[] getO3_HIGH() {
      return O3_HIGH;
   }

   public final double[] getO3_LOW() {
      return O3_LOW;
   }

   public final double[] getPM10_HIGH() {
      return PM10_HIGH;
   }

   public final double[] getPM10_LOW() {
      return PM10_LOW;
   }

   public final double[] getPM25_HIGH() {
      return PM25_HIGH;
   }

   public final double[] getPM25_LOW() {
      return PM25_LOW;
   }

   public final int getPollutantRangePosition(float var1, PollutantType var2) {
      Intrinsics.checkNotNullParameter(var2, "pollutantType");
      double[] var7 = this.airRatingsFor(var2).getHigh();
      int var6 = var7.length;

      for(int var5 = 0; var5 < var6; ++var5) {
         double var3 = var7[var5];
         if ((double)var1 <= var3) {
            return var5;
         }
      }

      return -1;
   }

   public final double[] getSO2_HIGH() {
      return SO2_HIGH;
   }

   public final double[] getSO2_LOW() {
      return SO2_LOW;
   }
}
