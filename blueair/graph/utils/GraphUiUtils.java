package com.blueair.graph.utils;

import com.blueair.core.model.SensorType;
import com.blueair.viewcore.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bR!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0014\u0010\bR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0017\u0010\b¨\u0006\u001c"},
   d2 = {"Lcom/blueair/graph/utils/GraphUiUtils;", "", "<init>", "()V", "severityDots", "", "", "getSeverityDots", "()Ljava/util/List;", "severityDots$delegate", "Lkotlin/Lazy;", "severityDot8Null", "getSeverityDot8Null", "()I", "severityDots8", "getSeverityDots8", "severityDots8$delegate", "severityDot6Null", "getSeverityDot6Null", "severityDots6", "getSeverityDots6", "severityDots6$delegate", "severityColors", "getSeverityColors", "severityColors$delegate", "getSensorName", "sensorType", "Lcom/blueair/core/model/SensorType;", "graph_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GraphUiUtils {
   public static final GraphUiUtils INSTANCE = new GraphUiUtils();
   private static final Lazy severityColors$delegate;
   private static final int severityDot6Null;
   private static final int severityDot8Null;
   private static final Lazy severityDots$delegate = LazyKt.lazy(new GraphUiUtils$$ExternalSyntheticLambda0());
   private static final Lazy severityDots6$delegate;
   private static final Lazy severityDots8$delegate;

   // $FF: synthetic method
   public static List $r8$lambda$EoeHDOb8oiB_KHfRWsCFCONBRsA() {
      return severityColors_delegate$lambda$3();
   }

   // $FF: synthetic method
   public static List $r8$lambda$N5nbXYyz7ZCIwNnXjbxd2HMwk0o() {
      return severityDots8_delegate$lambda$1();
   }

   // $FF: synthetic method
   public static List $r8$lambda$TsQNsUO0TrRJdDnbukutzbFo7RQ() {
      return severityDots6_delegate$lambda$2();
   }

   // $FF: synthetic method
   public static List $r8$lambda$u_jdKhcwNSWZBa64NPIqC_goeyE() {
      return severityDots_delegate$lambda$0();
   }

   static {
      severityDot8Null = R.drawable.ic_aqi_dot_null_8;
      severityDots8$delegate = LazyKt.lazy(new GraphUiUtils$$ExternalSyntheticLambda1());
      severityDot6Null = R.drawable.ic_aqi_dot_null_6;
      severityDots6$delegate = LazyKt.lazy(new GraphUiUtils$$ExternalSyntheticLambda2());
      severityColors$delegate = LazyKt.lazy(new GraphUiUtils$$ExternalSyntheticLambda3());
   }

   private GraphUiUtils() {
   }

   private static final List severityColors_delegate$lambda$3() {
      return CollectionsKt.listOf(new Integer[]{R.color.color_excellent, R.color.color_good, R.color.color_moderate, R.color.color_polluted, R.color.color_vpolluted});
   }

   private static final List severityDots6_delegate$lambda$2() {
      return CollectionsKt.listOf(new Integer[]{R.drawable.ic_aqi_dot_excellent_6, R.drawable.ic_aqi_dot_good_6, R.drawable.ic_aqi_dot_moderate_6, R.drawable.ic_aqi_dot_polluted_6, R.drawable.ic_aqi_dot_vpolluted_6});
   }

   private static final List severityDots8_delegate$lambda$1() {
      return CollectionsKt.listOf(new Integer[]{R.drawable.ic_aqi_dot_excellent_8, R.drawable.ic_aqi_dot_good_8, R.drawable.ic_aqi_dot_moderate_8, R.drawable.ic_aqi_dot_polluted_8, R.drawable.ic_aqi_dot_vpolluted_8});
   }

   private static final List severityDots_delegate$lambda$0() {
      return CollectionsKt.listOf(new Integer[]{R.drawable.ic_marker_dot_excellent, R.drawable.ic_marker_dot_good, R.drawable.ic_marker_dot_moderate, R.drawable.ic_marker_dot_polluted, R.drawable.ic_marker_dot_vpolluted});
   }

   public final int getSensorName(SensorType var1) {
      Intrinsics.checkNotNullParameter(var1, "sensorType");
      switch (GraphUiUtils.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()]) {
         case 1:
            return R.string.pm_1;
         case 2:
            return R.string.pm_25;
         case 3:
            return R.string.pm_10;
         case 4:
            return R.string.hum_expanded;
         case 5:
            return R.string.temp_expanded;
         case 6:
            return R.string.pet_sensor_tvoc;
         case 7:
            return R.string.hcho_title;
         default:
            return R.string.pm_25;
      }
   }

   public final List getSeverityColors() {
      return (List)severityColors$delegate.getValue();
   }

   public final int getSeverityDot6Null() {
      return severityDot6Null;
   }

   public final int getSeverityDot8Null() {
      return severityDot8Null;
   }

   public final List getSeverityDots() {
      return (List)severityDots$delegate.getValue();
   }

   public final List getSeverityDots6() {
      return (List)severityDots6$delegate.getValue();
   }

   public final List getSeverityDots8() {
      return (List)severityDots8$delegate.getValue();
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
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[SensorType.PM25.ordinal()] = 2;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[SensorType.PM10.ordinal()] = 3;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[SensorType.HUM.ordinal()] = 4;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[SensorType.TMP.ordinal()] = 5;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[SensorType.VOC.ordinal()] = 6;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[SensorType.HCHO.ordinal()] = 7;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
