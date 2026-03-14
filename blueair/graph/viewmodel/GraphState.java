package com.blueair.graph.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceUuid;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.PollutantType;
import com.blueair.core.model.SensorType;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.graph.utils.ChartTimeScale;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0001iBß\u0001\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020\u0002J\u0011\u0010L\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0011\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0011\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0011\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0011\u0010Q\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u000fHÆ\u0003J\t\u0010T\u001a\u00020\u000fHÆ\u0003J\t\u0010U\u001a\u00020\u0012HÆ\u0003J\t\u0010V\u001a\u00020\u0014HÆ\u0003J\t\u0010W\u001a\u00020\u0014HÆ\u0003J\u000f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004HÆ\u0003J\t\u0010Y\u001a\u00020\u0019HÆ\u0003J\t\u0010Z\u001a\u00020\u000fHÆ\u0003J\t\u0010[\u001a\u00020\u001cHÆ\u0003Já\u0001\u0010\\\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u001cHÆ\u0001J\u0006\u0010]\u001a\u00020\u0014J\u0013\u0010^\u001a\u00020\u00192\b\u0010_\u001a\u0004\u0018\u00010`HÖ\u0003J\t\u0010a\u001a\u00020\u0014HÖ\u0001J\t\u0010b\u001a\u00020cHÖ\u0001J\u0016\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\u0014R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u001c\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u001c\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0015\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u00102R\u0011\u0010\u001a\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b3\u0010*R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R!\u00106\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b:\u0010;\u0012\u0004\b7\u00108\u001a\u0004\b9\u00102R\u0017\u0010<\u001a\u00020=8F¢\u0006\f\u0012\u0004\b>\u00108\u001a\u0004\b?\u0010@R\u0017\u0010A\u001a\u00020B8F¢\u0006\f\u0012\u0004\bC\u00108\u001a\u0004\bD\u0010ER#\u0010F\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\bI\u0010;\u0012\u0004\bG\u00108\u001a\u0004\bH\u0010(¨\u0006j"},
   d2 = {"Lcom/blueair/graph/viewmodel/GraphState;", "Landroid/os/Parcelable;", "Lcom/blueair/graph/viewmodel/GraphMergeable;", "graphHistoricalDataPoints", "", "Lcom/github/mikephil/charting/data/Entry;", "graphReducedHistoricalDataPoints", "graphRealTimeDataPoints", "graphRelativeTimedDataPoints", "compareGraphDataPoints", "timeStampFilter", "", "", "lastSelectedEntry", "startingTimeInMillis", "", "latestTimeInMillis", "timeScale", "Lcom/blueair/graph/utils/ChartTimeScale;", "typeCode", "", "numberOfRanges", "maxThresholds", "", "isCelsius", "", "timeStamp", "deviceRatings", "Lcom/blueair/core/util/IndoorAirRatingRanges;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Set;Lcom/github/mikephil/charting/data/Entry;JJLcom/blueair/graph/utils/ChartTimeScale;IILjava/util/List;ZJLcom/blueair/core/util/IndoorAirRatingRanges;)V", "getGraphHistoricalDataPoints", "()Ljava/util/List;", "getGraphReducedHistoricalDataPoints", "getGraphRealTimeDataPoints", "getGraphRelativeTimedDataPoints", "getCompareGraphDataPoints", "getTimeStampFilter", "()Ljava/util/Set;", "getLastSelectedEntry", "()Lcom/github/mikephil/charting/data/Entry;", "getStartingTimeInMillis", "()J", "getLatestTimeInMillis", "getTimeScale", "()Lcom/blueair/graph/utils/ChartTimeScale;", "getTypeCode", "()I", "getNumberOfRanges", "getMaxThresholds", "()Z", "getTimeStamp", "getDeviceRatings", "()Lcom/blueair/core/util/IndoorAirRatingRanges;", "shouldShowGraph", "getShouldShowGraph$annotations", "()V", "getShouldShowGraph", "shouldShowGraph$delegate", "Lkotlin/Lazy;", "pollutantType", "Lcom/blueair/core/model/PollutantType;", "getPollutantType$annotations", "getPollutantType", "()Lcom/blueair/core/model/PollutantType;", "sensorType", "Lcom/blueair/core/model/SensorType;", "getSensorType$annotations", "getSensorType", "()Lcom/blueair/core/model/SensorType;", "relativelyTimedLastSelectedEntry", "getRelativelyTimedLastSelectedEntry$annotations", "getRelativelyTimedLastSelectedEntry", "relativelyTimedLastSelectedEntry$delegate", "merge", "right", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "graph_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GraphState implements Parcelable, GraphMergeable {
   public static final Parcelable.Creator CREATOR = new Creator();
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final List compareGraphDataPoints;
   private final IndoorAirRatingRanges deviceRatings;
   private final List graphHistoricalDataPoints;
   private final List graphRealTimeDataPoints;
   private final List graphReducedHistoricalDataPoints;
   private final List graphRelativeTimedDataPoints;
   private final boolean isCelsius;
   private final Entry lastSelectedEntry;
   private final long latestTimeInMillis;
   private final List maxThresholds;
   private final int numberOfRanges;
   private final Lazy relativelyTimedLastSelectedEntry$delegate;
   private final Lazy shouldShowGraph$delegate;
   private final long startingTimeInMillis;
   private final ChartTimeScale timeScale;
   private final long timeStamp;
   private final Set timeStampFilter;
   private final int typeCode;

   // $FF: synthetic method
   public static boolean $r8$lambda$8UUJxfJAFWrjRvDrTPbyDXmssdU(GraphState var0) {
      return shouldShowGraph_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Entry $r8$lambda$PzUVwg44d9XDQ86M1rN7JumH4lg(GraphState var0) {
      return relativelyTimedLastSelectedEntry_delegate$lambda$2(var0);
   }

   public GraphState() {
      this((List)null, (List)null, (List)null, (List)null, (List)null, (Set)null, (Entry)null, 0L, 0L, (ChartTimeScale)null, 0, 0, (List)null, false, 0L, (IndoorAirRatingRanges)null, 65535, (DefaultConstructorMarker)null);
   }

   public GraphState(List var1, List var2, List var3, List var4, List var5, Set var6, Entry var7, long var8, long var10, ChartTimeScale var12, int var13, int var14, List var15, boolean var16, long var17, IndoorAirRatingRanges var19) {
      Intrinsics.checkNotNullParameter(var12, "timeScale");
      Intrinsics.checkNotNullParameter(var15, "maxThresholds");
      Intrinsics.checkNotNullParameter(var19, "deviceRatings");
      super();
      this.graphHistoricalDataPoints = var1;
      this.graphReducedHistoricalDataPoints = var2;
      this.graphRealTimeDataPoints = var3;
      this.graphRelativeTimedDataPoints = var4;
      this.compareGraphDataPoints = var5;
      this.timeStampFilter = var6;
      this.lastSelectedEntry = var7;
      this.startingTimeInMillis = var8;
      this.latestTimeInMillis = var10;
      this.timeScale = var12;
      this.typeCode = var13;
      this.numberOfRanges = var14;
      this.maxThresholds = var15;
      this.isCelsius = var16;
      this.timeStamp = var17;
      this.deviceRatings = var19;
      this.shouldShowGraph$delegate = LazyKt.lazy(new GraphState$$ExternalSyntheticLambda0(this));
      this.relativelyTimedLastSelectedEntry$delegate = LazyKt.lazy(new GraphState$$ExternalSyntheticLambda1(this));
   }

   // $FF: synthetic method
   public GraphState(List var1, List var2, List var3, List var4, List var5, Set var6, Entry var7, long var8, long var10, ChartTimeScale var12, int var13, int var14, List var15, boolean var16, long var17, IndoorAirRatingRanges var19, int var20, DefaultConstructorMarker var21) {
      Object var22 = null;
      if ((var20 & 1) != 0) {
         var1 = null;
      }

      if ((var20 & 2) != 0) {
         var2 = null;
      }

      if ((var20 & 4) != 0) {
         var3 = null;
      }

      if ((var20 & 8) != 0) {
         var4 = null;
      }

      if ((var20 & 16) != 0) {
         var5 = null;
      }

      if ((var20 & 32) != 0) {
         var6 = null;
      }

      if ((var20 & 64) != 0) {
         var7 = (Entry)var22;
      }

      if ((var20 & 128) != 0) {
         var8 = System.currentTimeMillis() - GraphViewModel.Companion.getMONTH_IN_MILIS();
      }

      if ((var20 & 256) != 0) {
         var10 = System.currentTimeMillis();
      }

      if ((var20 & 512) != 0) {
         var12 = GraphViewModel.Companion.getDEFAULT_TIME_SCALE();
      }

      if ((var20 & 1024) != 0) {
         var13 = PollutantType.AQI.INSTANCE.getCode();
      }

      if ((var20 & 2048) != 0) {
         var14 = 0;
      }

      if ((var20 & 4096) != 0) {
         var15 = CollectionsKt.emptyList();
      }

      if ((var20 & 8192) != 0) {
         var16 = true;
      }

      if ((var20 & 16384) != 0) {
         var17 = 0L;
      }

      if ((var20 & '耀') != 0) {
         var19 = IndoorAirRatingRanges.Companion.instance(new DeviceG4("", (String)null, 0, (Integer)null, 0, (String)null, (String)null, (DeviceUuid)null, false, (IndoorDatapoint)null, 0, false, 0, 0L, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (double[])null, (double[])null, (double[])null, (double[])null, (double[])null, 0, false, false, false, (Boolean)null, (String)null, false, (String)null, 0, (String)null, (WelcomeHomeLocation)null, (Boolean)null, (Integer)null, (Long)null, -2, 4095, (DefaultConstructorMarker)null));
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var10, var12, var13, var14, var15, var16, var17, var19);
   }

   // $FF: synthetic method
   public static GraphState copy$default(GraphState var0, List var1, List var2, List var3, List var4, List var5, Set var6, Entry var7, long var8, long var10, ChartTimeScale var12, int var13, int var14, List var15, boolean var16, long var17, IndoorAirRatingRanges var19, int var20, Object var21) {
      if ((var20 & 1) != 0) {
         var1 = var0.graphHistoricalDataPoints;
      }

      if ((var20 & 2) != 0) {
         var2 = var0.graphReducedHistoricalDataPoints;
      }

      if ((var20 & 4) != 0) {
         var3 = var0.graphRealTimeDataPoints;
      }

      if ((var20 & 8) != 0) {
         var4 = var0.graphRelativeTimedDataPoints;
      }

      if ((var20 & 16) != 0) {
         var5 = var0.compareGraphDataPoints;
      }

      if ((var20 & 32) != 0) {
         var6 = var0.timeStampFilter;
      }

      if ((var20 & 64) != 0) {
         var7 = var0.lastSelectedEntry;
      }

      if ((var20 & 128) != 0) {
         var8 = var0.startingTimeInMillis;
      }

      if ((var20 & 256) != 0) {
         var10 = var0.latestTimeInMillis;
      }

      if ((var20 & 512) != 0) {
         var12 = var0.timeScale;
      }

      if ((var20 & 1024) != 0) {
         var13 = var0.typeCode;
      }

      if ((var20 & 2048) != 0) {
         var14 = var0.numberOfRanges;
      }

      if ((var20 & 4096) != 0) {
         var15 = var0.maxThresholds;
      }

      if ((var20 & 8192) != 0) {
         var16 = var0.isCelsius;
      }

      if ((var20 & 16384) != 0) {
         var17 = var0.timeStamp;
      }

      if ((var20 & '耀') != 0) {
         var19 = var0.deviceRatings;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var10, var12, var13, var14, var15, var16, var17, var19);
   }

   // $FF: synthetic method
   public static void getPollutantType$annotations() {
   }

   // $FF: synthetic method
   public static void getRelativelyTimedLastSelectedEntry$annotations() {
   }

   // $FF: synthetic method
   public static void getSensorType$annotations() {
   }

   // $FF: synthetic method
   public static void getShouldShowGraph$annotations() {
   }

   private static final Entry relativelyTimedLastSelectedEntry_delegate$lambda$2(GraphState var0) {
      Entry var1 = var0.lastSelectedEntry;
      return var1 != null ? new Entry(var1.getX() - (float)var0.startingTimeInMillis, var1.getY()) : null;
   }

   private static final boolean shouldShowGraph_delegate$lambda$0(GraphState var0) {
      Collection var2 = (Collection)var0.getGraphRelativeTimedDataPoints();
      boolean var1;
      if (var2 != null && !var2.isEmpty()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1 ^ true;
   }

   public final List component1() {
      return this.graphHistoricalDataPoints;
   }

   public final ChartTimeScale component10() {
      return this.timeScale;
   }

   public final int component11() {
      return this.typeCode;
   }

   public final int component12() {
      return this.numberOfRanges;
   }

   public final List component13() {
      return this.maxThresholds;
   }

   public final boolean component14() {
      return this.isCelsius;
   }

   public final long component15() {
      return this.timeStamp;
   }

   public final IndoorAirRatingRanges component16() {
      return this.deviceRatings;
   }

   public final List component2() {
      return this.graphReducedHistoricalDataPoints;
   }

   public final List component3() {
      return this.graphRealTimeDataPoints;
   }

   public final List component4() {
      return this.graphRelativeTimedDataPoints;
   }

   public final List component5() {
      return this.compareGraphDataPoints;
   }

   public final Set component6() {
      return this.timeStampFilter;
   }

   public final Entry component7() {
      return this.lastSelectedEntry;
   }

   public final long component8() {
      return this.startingTimeInMillis;
   }

   public final long component9() {
      return this.latestTimeInMillis;
   }

   public final GraphState copy(List var1, List var2, List var3, List var4, List var5, Set var6, Entry var7, long var8, long var10, ChartTimeScale var12, int var13, int var14, List var15, boolean var16, long var17, IndoorAirRatingRanges var19) {
      Intrinsics.checkNotNullParameter(var12, "timeScale");
      Intrinsics.checkNotNullParameter(var15, "maxThresholds");
      Intrinsics.checkNotNullParameter(var19, "deviceRatings");
      return new GraphState(var1, var2, var3, var4, var5, var6, var7, var8, var10, var12, var13, var14, var15, var16, var17, var19);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof GraphState)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.graphHistoricalDataPoints, var1.graphHistoricalDataPoints)) {
            return false;
         } else if (!Intrinsics.areEqual(this.graphReducedHistoricalDataPoints, var1.graphReducedHistoricalDataPoints)) {
            return false;
         } else if (!Intrinsics.areEqual(this.graphRealTimeDataPoints, var1.graphRealTimeDataPoints)) {
            return false;
         } else if (!Intrinsics.areEqual(this.graphRelativeTimedDataPoints, var1.graphRelativeTimedDataPoints)) {
            return false;
         } else if (!Intrinsics.areEqual(this.compareGraphDataPoints, var1.compareGraphDataPoints)) {
            return false;
         } else if (!Intrinsics.areEqual(this.timeStampFilter, var1.timeStampFilter)) {
            return false;
         } else if (!Intrinsics.areEqual(this.lastSelectedEntry, var1.lastSelectedEntry)) {
            return false;
         } else if (this.startingTimeInMillis != var1.startingTimeInMillis) {
            return false;
         } else if (this.latestTimeInMillis != var1.latestTimeInMillis) {
            return false;
         } else if (this.timeScale != var1.timeScale) {
            return false;
         } else if (this.typeCode != var1.typeCode) {
            return false;
         } else if (this.numberOfRanges != var1.numberOfRanges) {
            return false;
         } else if (!Intrinsics.areEqual(this.maxThresholds, var1.maxThresholds)) {
            return false;
         } else if (this.isCelsius != var1.isCelsius) {
            return false;
         } else if (this.timeStamp != var1.timeStamp) {
            return false;
         } else {
            return Intrinsics.areEqual(this.deviceRatings, var1.deviceRatings);
         }
      }
   }

   public List getCompareGraphDataPoints() {
      return this.compareGraphDataPoints;
   }

   public final IndoorAirRatingRanges getDeviceRatings() {
      return this.deviceRatings;
   }

   public List getGraphHistoricalDataPoints() {
      return this.graphHistoricalDataPoints;
   }

   public List getGraphRealTimeDataPoints() {
      return this.graphRealTimeDataPoints;
   }

   public List getGraphReducedHistoricalDataPoints() {
      return this.graphReducedHistoricalDataPoints;
   }

   public List getGraphRelativeTimedDataPoints() {
      return this.graphRelativeTimedDataPoints;
   }

   public final Entry getLastSelectedEntry() {
      return this.lastSelectedEntry;
   }

   public final long getLatestTimeInMillis() {
      return this.latestTimeInMillis;
   }

   public final List getMaxThresholds() {
      return this.maxThresholds;
   }

   public final int getNumberOfRanges() {
      return this.numberOfRanges;
   }

   public final PollutantType getPollutantType() {
      return PollutantType.Companion.fromCode(this.typeCode);
   }

   public final Entry getRelativelyTimedLastSelectedEntry() {
      return (Entry)this.relativelyTimedLastSelectedEntry$delegate.getValue();
   }

   public final SensorType getSensorType() {
      SensorType var2 = (SensorType)ArraysKt.getOrNull(SensorType.values(), this.typeCode);
      SensorType var1 = var2;
      if (var2 == null) {
         var1 = SensorType.PM25;
      }

      return var1;
   }

   public final boolean getShouldShowGraph() {
      return (Boolean)this.shouldShowGraph$delegate.getValue();
   }

   public final long getStartingTimeInMillis() {
      return this.startingTimeInMillis;
   }

   public final ChartTimeScale getTimeScale() {
      return this.timeScale;
   }

   public final long getTimeStamp() {
      return this.timeStamp;
   }

   public Set getTimeStampFilter() {
      return this.timeStampFilter;
   }

   public final int getTypeCode() {
      return this.typeCode;
   }

   public int hashCode() {
      List var8 = this.graphHistoricalDataPoints;
      int var7 = 0;
      int var1;
      if (var8 == null) {
         var1 = 0;
      } else {
         var1 = var8.hashCode();
      }

      var8 = this.graphReducedHistoricalDataPoints;
      int var2;
      if (var8 == null) {
         var2 = 0;
      } else {
         var2 = var8.hashCode();
      }

      var8 = this.graphRealTimeDataPoints;
      int var3;
      if (var8 == null) {
         var3 = 0;
      } else {
         var3 = var8.hashCode();
      }

      var8 = this.graphRelativeTimedDataPoints;
      int var4;
      if (var8 == null) {
         var4 = 0;
      } else {
         var4 = var8.hashCode();
      }

      var8 = this.compareGraphDataPoints;
      int var5;
      if (var8 == null) {
         var5 = 0;
      } else {
         var5 = var8.hashCode();
      }

      Set var13 = this.timeStampFilter;
      int var6;
      if (var13 == null) {
         var6 = 0;
      } else {
         var6 = var13.hashCode();
      }

      Entry var14 = this.lastSelectedEntry;
      if (var14 != null) {
         var7 = var14.hashCode();
      }

      return ((((((((((((((var1 * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var7) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.startingTimeInMillis)) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.latestTimeInMillis)) * 31 + this.timeScale.hashCode()) * 31 + this.typeCode) * 31 + this.numberOfRanges) * 31 + this.maxThresholds.hashCode()) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.isCelsius)) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.timeStamp)) * 31 + this.deviceRatings.hashCode();
   }

   public final boolean isCelsius() {
      return this.isCelsius;
   }

   public final GraphState merge(GraphMergeable var1) {
      Intrinsics.checkNotNullParameter(var1, "right");
      List var3 = this.getGraphHistoricalDataPoints();
      List var2 = var3;
      if (var3 == null) {
         var2 = var1.getGraphHistoricalDataPoints();
      }

      List var4 = this.getGraphReducedHistoricalDataPoints();
      var3 = var4;
      if (var4 == null) {
         var3 = var1.getGraphReducedHistoricalDataPoints();
      }

      List var5 = this.getGraphRealTimeDataPoints();
      var4 = var5;
      if (var5 == null) {
         var4 = var1.getGraphRealTimeDataPoints();
      }

      List var6 = this.getGraphRelativeTimedDataPoints();
      var5 = var6;
      if (var6 == null) {
         var5 = var1.getGraphRelativeTimedDataPoints();
      }

      List var7 = this.getCompareGraphDataPoints();
      var6 = var7;
      if (var7 == null) {
         var6 = var1.getCompareGraphDataPoints();
      }

      Set var8 = this.getTimeStampFilter();
      Set var13 = var8;
      if (var8 == null) {
         var13 = var1.getTimeStampFilter();
      }

      return copy$default(this, var2, var3, var4, var5, var6, var13, (Entry)null, 0L, 0L, (ChartTimeScale)null, 0, 0, (List)null, false, 0L, (IndoorAirRatingRanges)null, 65472, (Object)null);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("GraphState(graphHistoricalDataPoints=");
      var1.append(this.graphHistoricalDataPoints);
      var1.append(", graphReducedHistoricalDataPoints=");
      var1.append(this.graphReducedHistoricalDataPoints);
      var1.append(", graphRealTimeDataPoints=");
      var1.append(this.graphRealTimeDataPoints);
      var1.append(", graphRelativeTimedDataPoints=");
      var1.append(this.graphRelativeTimedDataPoints);
      var1.append(", compareGraphDataPoints=");
      var1.append(this.compareGraphDataPoints);
      var1.append(", timeStampFilter=");
      var1.append(this.timeStampFilter);
      var1.append(", lastSelectedEntry=");
      var1.append(this.lastSelectedEntry);
      var1.append(", startingTimeInMillis=");
      var1.append(this.startingTimeInMillis);
      var1.append(", latestTimeInMillis=");
      var1.append(this.latestTimeInMillis);
      var1.append(", timeScale=");
      var1.append(this.timeScale);
      var1.append(", typeCode=");
      var1.append(this.typeCode);
      var1.append(", numberOfRanges=");
      var1.append(this.numberOfRanges);
      var1.append(", maxThresholds=");
      var1.append(this.maxThresholds);
      var1.append(", isCelsius=");
      var1.append(this.isCelsius);
      var1.append(", timeStamp=");
      var1.append(this.timeStamp);
      var1.append(", deviceRatings=");
      var1.append(this.deviceRatings);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      List var3 = this.graphHistoricalDataPoints;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeInt(var3.size());
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            var1.writeParcelable((Parcelable)var4.next(), var2);
         }
      }

      var3 = this.graphReducedHistoricalDataPoints;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeInt(var3.size());
         Iterator var6 = var3.iterator();

         while(var6.hasNext()) {
            var1.writeParcelable((Parcelable)var6.next(), var2);
         }
      }

      var3 = this.graphRealTimeDataPoints;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeInt(var3.size());
         Iterator var8 = var3.iterator();

         while(var8.hasNext()) {
            var1.writeParcelable((Parcelable)var8.next(), var2);
         }
      }

      var3 = this.graphRelativeTimedDataPoints;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeInt(var3.size());
         Iterator var10 = var3.iterator();

         while(var10.hasNext()) {
            var1.writeParcelable((Parcelable)var10.next(), var2);
         }
      }

      var3 = this.compareGraphDataPoints;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeInt(var3.size());
         Iterator var12 = var3.iterator();

         while(var12.hasNext()) {
            var1.writeParcelable((Parcelable)var12.next(), var2);
         }
      }

      Set var13 = this.timeStampFilter;
      if (var13 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeInt(var13.size());
         Iterator var14 = var13.iterator();

         while(var14.hasNext()) {
            var1.writeFloat(((Number)var14.next()).floatValue());
         }
      }

      var1.writeParcelable((Parcelable)this.lastSelectedEntry, var2);
      var1.writeLong(this.startingTimeInMillis);
      var1.writeLong(this.latestTimeInMillis);
      var1.writeString(this.timeScale.name());
      var1.writeInt(this.typeCode);
      var1.writeInt(this.numberOfRanges);
      List var15 = this.maxThresholds;
      var1.writeInt(var15.size());
      Iterator var16 = var15.iterator();

      while(var16.hasNext()) {
         var1.writeDouble(((Number)var16.next()).doubleValue());
      }

      var1.writeInt(this.isCelsius);
      var1.writeLong(this.timeStamp);
      var1.writeParcelable(this.deviceRatings, var2);
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"},
      d2 = {"Lcom/blueair/graph/viewmodel/GraphState$Companion;", "", "<init>", "()V", "indoorDefault", "Lcom/blueair/graph/viewmodel/GraphState;", "outdoorDefault", "graph_otherRelease"},
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

      public final GraphState indoorDefault() {
         GraphState var2 = new GraphState((List)null, (List)null, (List)null, (List)null, (List)null, (Set)null, (Entry)null, 0L, 0L, (ChartTimeScale)null, 0, 0, (List)null, false, 0L, (IndoorAirRatingRanges)null, 65535, (DefaultConstructorMarker)null);
         int var1 = SensorType.PM25.ordinal();
         return GraphState.copy$default(var2, (List)null, (List)null, (List)null, (List)null, (List)null, (Set)null, (Entry)null, 0L, 0L, ChartTimeScale.DAY, var1, 0, (List)null, false, 0L, (IndoorAirRatingRanges)null, 63999, (Object)null);
      }

      public final GraphState outdoorDefault() {
         return new GraphState((List)null, (List)null, (List)null, (List)null, (List)null, (Set)null, (Entry)null, 0L, 0L, (ChartTimeScale)null, 0, 0, (List)null, false, 0L, (IndoorAirRatingRanges)null, 65535, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final GraphState createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         int var2 = var1.readInt();
         Object var12 = null;
         boolean var10 = false;
         ArrayList var11;
         if (var2 == 0) {
            var11 = null;
         } else {
            int var3 = var1.readInt();
            ArrayList var13 = new ArrayList(var3);
            var2 = 0;

            while(true) {
               var11 = var13;
               if (var2 == var3) {
                  break;
               }

               var13.add(var1.readParcelable(GraphState.class.getClassLoader()));
               ++var2;
            }
         }

         List var14 = (List)var11;
         if (var1.readInt() == 0) {
            var11 = null;
         } else {
            int var27 = var1.readInt();
            ArrayList var41 = new ArrayList(var27);
            var2 = 0;

            while(true) {
               var11 = var41;
               if (var2 == var27) {
                  break;
               }

               var41.add(var1.readParcelable(GraphState.class.getClassLoader()));
               ++var2;
            }
         }

         List var15 = (List)var11;
         if (var1.readInt() == 0) {
            var11 = null;
         } else {
            int var28 = var1.readInt();
            ArrayList var42 = new ArrayList(var28);
            var2 = 0;

            while(true) {
               var11 = var42;
               if (var2 == var28) {
                  break;
               }

               var42.add(var1.readParcelable(GraphState.class.getClassLoader()));
               ++var2;
            }
         }

         List var16 = (List)var11;
         if (var1.readInt() == 0) {
            var11 = null;
         } else {
            int var29 = var1.readInt();
            ArrayList var43 = new ArrayList(var29);
            var2 = 0;

            while(true) {
               var11 = var43;
               if (var2 == var29) {
                  break;
               }

               var43.add(var1.readParcelable(GraphState.class.getClassLoader()));
               ++var2;
            }
         }

         List var17 = (List)var11;
         if (var1.readInt() == 0) {
            var11 = null;
         } else {
            int var30 = var1.readInt();
            ArrayList var44 = new ArrayList(var30);
            var2 = 0;

            while(true) {
               var11 = var44;
               if (var2 == var30) {
                  break;
               }

               var44.add(var1.readParcelable(GraphState.class.getClassLoader()));
               ++var2;
            }
         }

         List var45 = (List)var11;
         LinkedHashSet var37;
         if (var1.readInt() == 0) {
            var37 = (LinkedHashSet)var12;
         } else {
            int var31 = var1.readInt();
            LinkedHashSet var39 = new LinkedHashSet(var31);
            var2 = 0;

            while(true) {
               var37 = var39;
               if (var2 == var31) {
                  break;
               }

               var39.add(var1.readFloat());
               ++var2;
            }
         }

         Set var40 = (Set)var37;
         Entry var38 = (Entry)var1.readParcelable(GraphState.class.getClassLoader());
         long var6 = var1.readLong();
         long var8 = var1.readLong();
         ChartTimeScale var18 = ChartTimeScale.valueOf(var1.readString());
         int var4 = var1.readInt();
         int var32 = var1.readInt();
         int var5 = var1.readInt();
         ArrayList var19 = new ArrayList(var5);

         for(int var26 = 0; var26 != var5; ++var26) {
            var19.add(var1.readDouble());
         }

         List var46 = (List)var19;
         if (var1.readInt() != 0) {
            var10 = true;
         }

         return new GraphState(var14, var15, var16, var17, var45, var40, var38, var6, var8, var18, var4, var32, var46, var10, var1.readLong(), (IndoorAirRatingRanges)var1.readParcelable(GraphState.class.getClassLoader()));
      }

      public final GraphState[] newArray(int var1) {
         return new GraphState[var1];
      }
   }
}
