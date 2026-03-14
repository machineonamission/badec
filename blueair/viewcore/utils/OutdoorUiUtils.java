package com.blueair.viewcore.utils;

import com.blueair.viewcore.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"},
   d2 = {"Lcom/blueair/viewcore/utils/OutdoorUiUtils;", "", "<init>", "()V", "aqiSeverityColorsNew", "", "", "getAqiSeverityColorsNew", "()Ljava/util/List;", "aqiSeverityColorsNew$delegate", "Lkotlin/Lazy;", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class OutdoorUiUtils {
   public static final OutdoorUiUtils INSTANCE = new OutdoorUiUtils();
   private static final Lazy aqiSeverityColorsNew$delegate = LazyKt.lazy(new OutdoorUiUtils$$ExternalSyntheticLambda0());

   // $FF: synthetic method
   public static List $r8$lambda$827qNyJue_u3IRu300POBtkyPr4/* $FF was: $r8$lambda$827qNyJue-u3IRu300POBtkyPr4*/() {
      return aqiSeverityColorsNew_delegate$lambda$0();
   }

   private OutdoorUiUtils() {
   }

   private static final List aqiSeverityColorsNew_delegate$lambda$0() {
      return CollectionsKt.listOf(new Integer[]{R.color.outdoor_aqi_excellent, R.color.outdoor_aqi_good, R.color.outdoor_aqi_moderate, R.color.outdoor_aqi_polluted, R.color.outdoor_aqi_very_polluted});
   }

   public final List getAqiSeverityColorsNew() {
      return (List)aqiSeverityColorsNew$delegate.getValue();
   }
}
