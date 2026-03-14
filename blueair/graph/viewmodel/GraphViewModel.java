package com.blueair.graph.viewmodel;

import com.blueair.core.model.PollutantType;
import com.blueair.core.model.SensorType;
import com.blueair.core.model.SimpleDatapoint;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.core.util.OutdoorAirRatingRanges;
import com.blueair.core.util.OutdoorRanges;
import com.blueair.graph.utils.ChartTimeScale;
import com.blueair.graph.utils.MpChartUtils;
import com.blueair.graph.utils.MpOutdoorChartUtils;
import com.blueair.viewcore.viewmodel.StandardVMNonNullState;
import com.github.mikephil.charting.data.Entry;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 g2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001gB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u001a2\b\b\u0002\u00104\u001a\u00020\u0005J\u0006\u00105\u001a\u000202J\u000e\u00106\u001a\u0002022\u0006\u00107\u001a\u00020,J\u000e\u00108\u001a\u0002022\u0006\u00109\u001a\u00020\u0012J\u000e\u0010:\u001a\u0002022\u0006\u0010;\u001a\u00020\u0016J\u0014\u0010<\u001a\u0002022\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>J2\u0010@\u001a\u0002022\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020$2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0012H\u0007J\"\u0010G\u001a\u0002022\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0B2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0016H\u0007J2\u0010I\u001a\u0002022\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010J\u001a\u00020\u00022\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020?0LH\u0002J<\u0010M\u001a\u0002022\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020$2\b\b\u0002\u0010N\u001a\u00020\u00052\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0012H\u0007J,\u0010O\u001a\u0002022\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0B2\b\b\u0002\u0010N\u001a\u00020\u00052\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0016H\u0007J<\u0010P\u001a\u0002022\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010J\u001a\u00020\u00022\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020?0L2\b\b\u0002\u0010N\u001a\u00020\u0005H\u0007J&\u0010Q\u001a\u0002022\f\u0010R\u001a\b\u0012\u0004\u0012\u00020 0B2\u0006\u0010S\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u0002H\u0003J\u001a\u0010T\u001a\u0002022\u0006\u0010U\u001a\u00020\u00022\b\b\u0002\u0010V\u001a\u00020\u0005H\u0003J\u0012\u0010W\u001a\u0004\u0018\u00010 2\u0006\u0010X\u001a\u00020 H\u0002J\u0010\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010X\u001a\u00020 J\u001a\u0010[\u001a\u0004\u0018\u00010C2\u0006\u0010\\\u001a\u00020,2\u0006\u0010]\u001a\u00020?H\u0002J\u0012\u0010^\u001a\u0004\u0018\u00010C2\u0006\u0010X\u001a\u00020 H\u0002J\u001a\u0010_\u001a\u0004\u0018\u00010C2\u0006\u0010\\\u001a\u00020,2\u0006\u0010`\u001a\u00020aH\u0002J\n\u0010b\u001a\u0004\u0018\u00010\u0002H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u0002X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000bR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\"\"\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0013\u0010/\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b0\u0010\"R\u0012\u0010c\u001a\u00020dX\u0096\u0005¢\u0006\u0006\u001a\u0004\be\u0010f¨\u0006h"},
   d2 = {"Lcom/blueair/graph/viewmodel/GraphViewModel;", "Lcom/blueair/viewcore/viewmodel/StandardVMNonNullState;", "Lcom/blueair/graph/viewmodel/GraphState;", "Lkotlinx/coroutines/CoroutineScope;", "outdoor", "", "name", "", "<init>", "(ZLjava/lang/String;)V", "getOutdoor", "()Z", "getName", "()Ljava/lang/String;", "defaultState", "getDefaultState", "()Lcom/blueair/graph/viewmodel/GraphState;", "sensorType", "Lcom/blueair/core/model/SensorType;", "getSensorType$graph_otherRelease", "()Lcom/blueair/core/model/SensorType;", "pollutantType", "Lcom/blueair/core/model/PollutantType;", "getPollutantType$graph_otherRelease", "()Lcom/blueair/core/model/PollutantType;", "timeScale", "Lcom/blueair/graph/utils/ChartTimeScale;", "getTimeScale$graph_otherRelease", "()Lcom/blueair/graph/utils/ChartTimeScale;", "isCelsius", "isCelsius$graph_otherRelease", "tempLastSelectedEntry", "Lcom/github/mikephil/charting/data/Entry;", "getTempLastSelectedEntry", "()Lcom/github/mikephil/charting/data/Entry;", "deviceRatings", "Lcom/blueair/core/util/IndoorAirRatingRanges;", "getDeviceRatings", "()Lcom/blueair/core/util/IndoorAirRatingRanges;", "tempRelativelyTimedLastSelectedEntry", "getTempRelativelyTimedLastSelectedEntry", "setTempRelativelyTimedLastSelectedEntry", "(Lcom/github/mikephil/charting/data/Entry;)V", "startingTimeInMillis", "", "getStartingTimeInMillis", "()J", "latestGraphDataPoint", "getLatestGraphDataPoint", "updateScale", "", "nuTimeScale", "force", "refresh", "gotoTime", "timeInMillis", "setSensorType", "nuSensorType", "setPollutantType", "nuPollutantType", "setTimeStampFilter", "nuTimeStampFilter", "", "", "updateIndoorRealTime", "nuDatapoints", "", "Lcom/blueair/core/model/SimpleDatapoint;", "nuIsCelsius", "ratings", "overrideSensorType", "updateOutdoorRealTime", "overridePollutantType", "updateRealTime", "nuState", "entryYMapper", "Lkotlin/Function1;", "updateIndoorHistorical", "isCompare", "updateOutdoorHistorical", "updateHistorical", "updateGraphDataPoints", "nuDataPoints", "isRealTime", "updateState", "nuGraphState", "doMerge", "getCompareDataPointForEntry", "entry", "reverseRelativelyTimedEntryToDataPoint", "Lcom/blueair/graph/viewmodel/ReversedResult;", "reverseIndoorEntryToDataPoint", "x", "y", "reverseOutdoorEntryToDataPoint", "reverseEntryToDataPoint", "unscaledValue", "", "onSaveState", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "graph_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GraphViewModel extends StandardVMNonNullState implements CoroutineScope {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final ChartTimeScale DEFAULT_TIME_SCALE;
   private static final long MONTH_IN_MILIS;
   private final DefaultCoroutineScope $$delegate_0;
   private final GraphState defaultState;
   private final String name;
   private final boolean outdoor;
   private Entry tempRelativelyTimedLastSelectedEntry;

   // $FF: synthetic method
   public static float $r8$lambda$Ds93YOQN5T8bNFO_DpokXQimqQk(double[] var0, float var1) {
      return updateOutdoorHistorical$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static float $r8$lambda$KFVr3jARAh0372L6V06wXZTqpXY(OutdoorRanges var0, float var1) {
      return updateOutdoorRealTime$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static float $r8$lambda$dh9wO3yC3ilWahO6ePhs_8t42dY(SensorType var0, double[] var1, boolean var2, float var3) {
      return updateIndoorRealTime$lambda$5(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static float $r8$lambda$gaOIMbPTz__Bpi733g88hZgtY0E/* $FF was: $r8$lambda$gaOIMbPTz_-Bpi733g88hZgtY0E*/(SensorType var0, double[] var1, boolean var2, float var3) {
      return updateIndoorHistorical$lambda$8(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Entry $r8$lambda$jZSyIDSaH_2nINL39sSpzitEDjE(long var0, Entry var2) {
      return updateGraphDataPoints$lambda$12(var0, var2);
   }

   static {
      DEFAULT_TIME_SCALE = ChartTimeScale.WEEK;
      MONTH_IN_MILIS = TimeUnit.DAYS.toMillis(30L);
   }

   public GraphViewModel(boolean var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "name");
      super();
      this.$$delegate_0 = new DefaultCoroutineScope();
      this.outdoor = var1;
      this.name = var2;
      GraphState var3;
      if (var1) {
         var3 = GraphState.Companion.outdoorDefault();
      } else {
         var3 = GraphState.Companion.indoorDefault();
      }

      this.defaultState = var3;
   }

   private final Entry getCompareDataPointForEntry(Entry var1) {
      List var5 = ((GraphState)this.getState()).getCompareGraphDataPoints();
      if (var5 != null) {
         Iterator var8 = ((Iterable)var5).iterator();
         Object var9;
         if (!var8.hasNext()) {
            var9 = null;
         } else {
            var9 = var8.next();
            if (var8.hasNext()) {
               float var3 = Math.abs(((Entry)var9).getX() - var1.getX());
               Object var6 = var9;

               do {
                  Object var7 = var8.next();
                  float var4 = Math.abs(((Entry)var7).getX() - var1.getX());
                  var9 = var6;
                  float var2 = var3;
                  if (Float.compare(var3, var4) > 0) {
                     var9 = var7;
                     var2 = var4;
                  }

                  var6 = var9;
                  var3 = var2;
               } while(var8.hasNext());
            }
         }

         Entry var10 = (Entry)var9;
         if (var10 != null && Math.abs(var10.getX() - var1.getX()) < (float)3600000L) {
            return var10;
         }
      }

      return null;
   }

   private final Entry getTempLastSelectedEntry() {
      Entry var1 = this.tempRelativelyTimedLastSelectedEntry;
      return var1 != null ? new Entry(var1.getX() + (float)this.getStartingTimeInMillis(), var1.getY()) : null;
   }

   private final SimpleDatapoint reverseEntryToDataPoint(long var1, double var3) {
      SimpleDatapoint var6 = new SimpleDatapoint(var1 / (long)1000, (float)var3);
      Timber.Forest var7 = Timber.Forest;
      StringBuilder var5 = new StringBuilder("reverseEntryToDataPoint: entry = ");
      var5.append(var1);
      var5.append(" ; dp = ");
      var5.append(var6);
      var7.v(var5.toString(), new Object[0]);
      return var6;
   }

   private final SimpleDatapoint reverseIndoorEntryToDataPoint(long var1, float var3) {
      return this.reverseEntryToDataPoint(var1, MpChartUtils.INSTANCE.getRealValueFromScaledChartValue(var3, this.getSensorType$graph_otherRelease(), this.isCelsius$graph_otherRelease(), this.getDeviceRatings().airRatingsFor(this.getSensorType$graph_otherRelease())));
   }

   private final SimpleDatapoint reverseOutdoorEntryToDataPoint(Entry var1) {
      double var2 = MpOutdoorChartUtils.INSTANCE.getRealValueFromScaledChartValueOutdoor((double)var1.getY(), OutdoorAirRatingRanges.INSTANCE.airRatingsFor(this.getPollutantType$graph_otherRelease()).getHigh());
      return this.reverseEntryToDataPoint((long)var1.getX(), var2);
   }

   private final void updateGraphDataPoints(List var1, boolean var2, GraphState var3) {
      Timber.Forest var13 = Timber.Forest;
      StringBuilder var12 = new StringBuilder("updateGraphDataPoints, isRealTime = ");
      var12.append(var2);
      var12.append(", size = ");
      var12.append(var1.size());
      var12.append(", hasTimeStampFilter = ");
      boolean var6;
      if (var3.getTimeStampFilter() != null) {
         var6 = true;
      } else {
         var6 = false;
      }

      var12.append(var6);
      var12.append(", nuState.containsCompare() = ");
      Collection var11 = (Collection)var3.getCompareGraphDataPoints();
      boolean var5;
      if (var11 != null && !var11.isEmpty()) {
         var5 = false;
      } else {
         var5 = true;
      }

      float var4;
      long var7;
      long var9;
      label122: {
         var12.append(var5 ^ true);
         var12.append(", ");
         var12.append(this.name);
         var13.v(var12.toString(), new Object[0]);
         var7 = System.currentTimeMillis();
         var9 = var7 - MONTH_IN_MILIS;
         List var22 = var3.getGraphHistoricalDataPoints();
         if (var22 != null) {
            Entry var23 = (Entry)CollectionsKt.lastOrNull(var22);
            if (var23 != null) {
               var4 = var23.getX();
               break label122;
            }
         }

         var4 = 0.0F;
      }

      List var24;
      if (var2) {
         if (var3.getTimeStampFilter() != null) {
            var24 = var3.getGraphHistoricalDataPoints();
         } else {
            var24 = var3.getGraphReducedHistoricalDataPoints();
         }
      } else {
         var24 = var1;
      }

      if (!var2) {
         var1 = var3.getGraphRealTimeDataPoints();
      }

      Integer var36 = null;
      if (var1 != null) {
         Iterable var25 = (Iterable)var1;
         Collection var18 = (Collection)(new ArrayList());

         for(Object var15 : var25) {
            Entry var26 = (Entry)var15;
            if (var26 instanceof GraphEntry) {
               if (!((float)((GraphEntry)var26).getXx() > var4)) {
                  continue;
               }
            } else if (!(var26.getX() > var4)) {
               continue;
            }

            var18.add(var15);
         }

         var1 = (List)var18;
      } else {
         var1 = null;
      }

      label140: {
         GraphViewModel$$ExternalSyntheticLambda4 var44 = new GraphViewModel$$ExternalSyntheticLambda4(var9);
         Collection var27 = (Collection)var24;
         if (var27 == null || var27.isEmpty()) {
            var27 = (Collection)var1;
            if (var27 == null || var27.isEmpty()) {
               var35 = null;
               break label140;
            }
         }

         List var29;
         if (var24 == null) {
            var29 = CollectionsKt.emptyList();
         } else {
            var29 = var24;
         }

         Collection var37 = (Collection)var29;
         Iterable var30;
         if (var1 != null) {
            var30 = (Iterable)var1;
         } else {
            var30 = (Iterable)CollectionsKt.emptyList();
         }

         List var38 = CollectionsKt.plus(var37, var30);
         List var31 = var38;
         if (var3.getTimeStampFilter() != null) {
            Timber.Forest var32 = Timber.Forest;
            StringBuilder var16 = new StringBuilder("updateGraphDataPoints: filter timeStamps, ");
            var16.append(this.name);
            var32.v(var16.toString(), new Object[0]);
            Iterable var39 = (Iterable)var38;
            Collection var33 = (Collection)(new ArrayList());

            for(Object var17 : var39) {
               Entry var40 = (Entry)var17;
               if (var3.getTimeStampFilter().contains(var40.getX())) {
                  var33.add(var17);
               }
            }

            var31 = (List)var33;
         }

         Iterable var41 = (Iterable)var31;
         Collection var34 = (Collection)(new ArrayList());
         Iterator var47 = var41.iterator();

         while(var47.hasNext()) {
            Entry var42 = (Entry)var44.invoke((Entry)var47.next());
            if (var42 != null) {
               var34.add(var42);
            }
         }

         var35 = (List)var34;
      }

      Timber.Forest var45 = Timber.Forest;
      StringBuilder var43 = new StringBuilder("updateGraphDataPoints: combinedRelativeTimedDataPoints.size = ");
      if (var35 != null) {
         var36 = var35.size();
      }

      var43.append(var36);
      var43.append(", ");
      var43.append(this.name);
      var45.v(var43.toString(), new Object[0]);
      if (!Intrinsics.areEqual(var35, var3.getGraphRelativeTimedDataPoints())) {
         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getMain(), (CoroutineStart)null, new Function2(this, var3, var24, var1, var35, var9, var7, (Continuation)null) {
            final List $combinedRelativeTimedDataPoints;
            final long $latestTimeInMillis;
            final List $nuGraphRealTimeDataPoints;
            final List $nuGraphReducedHistoricalDataPoints;
            final GraphState $nuState;
            final long $startingTimeInMillis;
            int label;
            final GraphViewModel this$0;

            {
               this.this$0 = var1;
               this.$nuState = var2;
               this.$nuGraphReducedHistoricalDataPoints = var3;
               this.$nuGraphRealTimeDataPoints = var4;
               this.$combinedRelativeTimedDataPoints = var5;
               this.$startingTimeInMillis = var6;
               this.$latestTimeInMillis = var8;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$nuState, this.$nuGraphReducedHistoricalDataPoints, this.$nuGraphRealTimeDataPoints, this.$combinedRelativeTimedDataPoints, this.$startingTimeInMillis, this.$latestTimeInMillis, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               IntrinsicsKt.getCOROUTINE_SUSPENDED();
               if (this.label == 0) {
                  ResultKt.throwOnFailure(var1);
                  this.this$0.updateState(GraphState.copy$default(this.$nuState, (List)null, this.$nuGraphReducedHistoricalDataPoints, this.$nuGraphRealTimeDataPoints, this.$combinedRelativeTimedDataPoints, (List)null, (Set)null, (Entry)null, this.$startingTimeInMillis, this.$latestTimeInMillis, (ChartTimeScale)null, 0, 0, (List)null, false, 0L, (IndoorAirRatingRanges)null, 65137, (Object)null), true);
                  return Unit.INSTANCE;
               } else {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }
            }
         }, 2, (Object)null);
      } else {
         Timber.Forest var20 = Timber.Forest;
         StringBuilder var21 = new StringBuilder("updateGraphDataPoints: IGNORE since same data, name = ");
         var21.append(this.name);
         var20.d(var21.toString(), new Object[0]);
      }
   }

   private static final Entry updateGraphDataPoints$lambda$12(long var0, Entry var2) {
      Intrinsics.checkNotNullParameter(var2, "e");
      if (var2 instanceof GraphEntry) {
         var2 = var2;
         return var2.getXx() >= var0 ? new Entry((float)(var2.getXx() - var0), var2.getYy()) : null;
      } else {
         float var4 = ((Entry)var2).getX();
         float var3 = (float)var0;
         return var4 >= var3 ? new Entry(((Entry)var2).getX() - var3, ((Entry)var2).getY()) : null;
      }
   }

   // $FF: synthetic method
   public static void updateHistorical$default(GraphViewModel var0, List var1, GraphState var2, Function1 var3, boolean var4, int var5, Object var6) {
      if ((var5 & 8) != 0) {
         var4 = false;
      }

      var0.updateHistorical(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static void updateIndoorHistorical$default(GraphViewModel var0, List var1, boolean var2, IndoorAirRatingRanges var3, boolean var4, SensorType var5, int var6, Object var7) {
      if ((var6 & 8) != 0) {
         var4 = false;
      }

      if ((var6 & 16) != 0) {
         var5 = null;
      }

      var0.updateIndoorHistorical(var1, var2, var3, var4, var5);
   }

   private static final float updateIndoorHistorical$lambda$8(SensorType var0, double[] var1, boolean var2, float var3) {
      return (float)MpChartUtils.INSTANCE.getScaledValueForChart(var3, var0, var1, var2);
   }

   // $FF: synthetic method
   public static void updateIndoorRealTime$default(GraphViewModel var0, List var1, boolean var2, IndoorAirRatingRanges var3, SensorType var4, int var5, Object var6) {
      if ((var5 & 8) != 0) {
         var4 = null;
      }

      var0.updateIndoorRealTime(var1, var2, var3, var4);
   }

   private static final float updateIndoorRealTime$lambda$5(SensorType var0, double[] var1, boolean var2, float var3) {
      return (float)MpChartUtils.INSTANCE.getScaledValueForChart(var3, var0, var1, var2);
   }

   // $FF: synthetic method
   public static void updateOutdoorHistorical$default(GraphViewModel var0, List var1, boolean var2, PollutantType var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = false;
      }

      if ((var4 & 4) != 0) {
         var3 = null;
      }

      var0.updateOutdoorHistorical(var1, var2, var3);
   }

   private static final float updateOutdoorHistorical$lambda$9(double[] var0, float var1) {
      return (float)MpChartUtils.INSTANCE.getScaledValueForChart(var1, var0);
   }

   // $FF: synthetic method
   public static void updateOutdoorRealTime$default(GraphViewModel var0, List var1, PollutantType var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      var0.updateOutdoorRealTime(var1, var2);
   }

   private static final float updateOutdoorRealTime$lambda$6(OutdoorRanges var0, float var1) {
      return (float)MpChartUtils.INSTANCE.getScaledValueForChart(var1, var0.getHigh());
   }

   private final void updateRealTime(List var1, GraphState var2, Function1 var3) {
      if (!var1.isEmpty()) {
         Timber.Forest var5 = Timber.Forest;
         StringBuilder var4 = new StringBuilder("updateRealTime, size = ");
         var4.append(var1.size());
         var4.append(", name = ");
         var4.append(this.name);
         var5.v(var4.toString(), new Object[0]);
         Iterable var7 = (Iterable)var1;
         Collection var6 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var7, 10)));

         for(SimpleDatapoint var8 : var7) {
            var6.add(new GraphEntry(var8.getTimeInMillis(), ((Number)var3.invoke(var8.getValue())).floatValue()));
         }

         this.updateGraphDataPoints((List)var6, true, var2);
      }
   }

   // $FF: synthetic method
   public static void updateScale$default(GraphViewModel var0, ChartTimeScale var1, boolean var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      var0.updateScale(var1, var2);
   }

   private final void updateState(GraphState var1, boolean var2) {
      Object var5 = this.getStateLock();
      synchronized(var5){}

      Throwable var10000;
      label2325: {
         GraphState var6;
         Timber.Forest var7;
         StringBuilder var8;
         Collection var9;
         try {
            var6 = (GraphState)this.getState();
            var7 = Timber.Forest;
            var8 = new StringBuilder("updateState, \nnuState.graphRelativeTimedDataPoints.isNull() = ");
            var9 = (Collection)var1.getGraphRelativeTimedDataPoints();
         } catch (Throwable var249) {
            var10000 = var249;
            boolean var10001 = false;
            break label2325;
         }

         boolean var3;
         boolean var4;
         label2316: {
            label2315: {
               var4 = true;
               if (var9 != null) {
                  try {
                     if (!var9.isEmpty()) {
                        break label2315;
                     }
                  } catch (Throwable var248) {
                     var10000 = var248;
                     boolean var265 = false;
                     break label2325;
                  }
               }

               var3 = true;
               break label2316;
            }

            var3 = false;
         }

         try {
            var8.append(var3);
            var8.append(", nuState.compareGraphDataPoints.isNull() = ");
            var9 = (Collection)var1.getCompareGraphDataPoints();
         } catch (Throwable var247) {
            var10000 = var247;
            boolean var266 = false;
            break label2325;
         }

         label2304: {
            label2303: {
               if (var9 != null) {
                  try {
                     if (!var9.isEmpty()) {
                        break label2303;
                     }
                  } catch (Throwable var246) {
                     var10000 = var246;
                     boolean var267 = false;
                     break label2325;
                  }
               }

               var3 = true;
               break label2304;
            }

            var3 = false;
         }

         try {
            var8.append(var3);
            var8.append(", \noldState.graphRelativeTimedDataPoints.isNull() = ");
            var9 = (Collection)var6.getGraphRelativeTimedDataPoints();
         } catch (Throwable var245) {
            var10000 = var245;
            boolean var268 = false;
            break label2325;
         }

         label2292: {
            label2291: {
               if (var9 != null) {
                  try {
                     if (!var9.isEmpty()) {
                        break label2291;
                     }
                  } catch (Throwable var244) {
                     var10000 = var244;
                     boolean var269 = false;
                     break label2325;
                  }
               }

               var3 = true;
               break label2292;
            }

            var3 = false;
         }

         try {
            var8.append(var3);
            var8.append(", oldState.compareGraphDataPoints.isNull() = ");
            var9 = (Collection)var6.getCompareGraphDataPoints();
         } catch (Throwable var243) {
            var10000 = var243;
            boolean var270 = false;
            break label2325;
         }

         label2280: {
            label2279: {
               if (var9 != null) {
                  try {
                     if (!var9.isEmpty()) {
                        break label2279;
                     }
                  } catch (Throwable var242) {
                     var10000 = var242;
                     boolean var271 = false;
                     break label2325;
                  }
               }

               var3 = true;
               break label2280;
            }

            var3 = false;
         }

         try {
            var8.append(var3);
            var8.append(", \nname = ");
            var8.append(this.name);
            var7.v(var8.toString(), new Object[0]);
         } catch (Throwable var241) {
            var10000 = var241;
            boolean var272 = false;
            break label2325;
         }

         if (var2) {
            try {
               var1 = var1.merge(var6);
            } catch (Throwable var240) {
               var10000 = var240;
               boolean var273 = false;
               break label2325;
            }
         }

         try {
            var6 = GraphState.copy$default(var1, (List)null, (List)null, (List)null, (List)null, (List)null, (Set)null, this.getTempLastSelectedEntry(), 0L, 0L, (ChartTimeScale)null, 0, 0, (List)null, false, 0L, (IndoorAirRatingRanges)null, 65471, (Object)null);
            var250 = Timber.Forest;
            var259 = new StringBuilder("updateState, \nfinalState.graphRelativeTimedDataPoints.isNull() = ");
            var260 = (Collection)var6.getGraphRelativeTimedDataPoints();
         } catch (Throwable var239) {
            var10000 = var239;
            boolean var274 = false;
            break label2325;
         }

         label2260: {
            label2259: {
               if (var260 != null) {
                  try {
                     if (!var260.isEmpty()) {
                        break label2259;
                     }
                  } catch (Throwable var238) {
                     var10000 = var238;
                     boolean var275 = false;
                     break label2325;
                  }
               }

               var2 = true;
               break label2260;
            }

            var2 = false;
         }

         try {
            var259.append(var2);
            var259.append(", finalState.compareGraphDataPoints.isNull() = ");
            var261 = (Collection)var6.getCompareGraphDataPoints();
         } catch (Throwable var237) {
            var10000 = var237;
            boolean var276 = false;
            break label2325;
         }

         var2 = var4;
         if (var261 != null) {
            label2247: {
               label2246: {
                  try {
                     if (var261.isEmpty()) {
                        break label2246;
                     }
                  } catch (Throwable var236) {
                     var10000 = var236;
                     boolean var277 = false;
                     break label2325;
                  }

                  var2 = false;
                  break label2247;
               }

               var2 = var4;
            }
         }

         label2240:
         try {
            var259.append(var2);
            var259.append(", \nname = ");
            var259.append(this.name);
            var250.v(var259.toString(), new Object[0]);
            this.setState(var6);
            Unit var252 = Unit.INSTANCE;
            return;
         } catch (Throwable var235) {
            var10000 = var235;
            boolean var278 = false;
            break label2240;
         }
      }

      Throwable var251 = var10000;
      throw var251;
   }

   // $FF: synthetic method
   static void updateState$default(GraphViewModel var0, GraphState var1, boolean var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = true;
      }

      var0.updateState(var1, var2);
   }

   public CoroutineContext getCoroutineContext() {
      return this.$$delegate_0.getCoroutineContext();
   }

   protected GraphState getDefaultState() {
      return this.defaultState;
   }

   public final IndoorAirRatingRanges getDeviceRatings() {
      return ((GraphState)this.getState()).getDeviceRatings();
   }

   public final Entry getLatestGraphDataPoint() {
      List var1 = ((GraphState)this.getState()).getGraphRelativeTimedDataPoints();
      return var1 != null ? (Entry)CollectionsKt.lastOrNull(var1) : null;
   }

   public final String getName() {
      return this.name;
   }

   public final boolean getOutdoor() {
      return this.outdoor;
   }

   public final PollutantType getPollutantType$graph_otherRelease() {
      if (this.outdoor) {
         return ((GraphState)this.getState()).getPollutantType();
      } else {
         PollutantType var2 = PollutantType.Companion.fromSensorType(((GraphState)this.getState()).getSensorType());
         PollutantType var1 = var2;
         if (var2 == null) {
            var1 = PollutantType.PM25.INSTANCE;
         }

         return var1;
      }
   }

   public final SensorType getSensorType$graph_otherRelease() {
      return ((GraphState)this.getState()).getSensorType();
   }

   public final long getStartingTimeInMillis() {
      return ((GraphState)this.getState()).getStartingTimeInMillis();
   }

   public final Entry getTempRelativelyTimedLastSelectedEntry() {
      return this.tempRelativelyTimedLastSelectedEntry;
   }

   public final ChartTimeScale getTimeScale$graph_otherRelease() {
      return ((GraphState)this.getState()).getTimeScale();
   }

   public final void gotoTime(long var1) {
      GraphState var12 = GraphState.copy$default((GraphState)this.getState(), (List)null, (List)null, (List)null, (List)null, (List)null, (Set)null, (Entry)null, 0L, 0L, (ChartTimeScale)null, 0, 0, (List)null, false, 0L, (IndoorAirRatingRanges)null, 65535, (Object)null);
      long var7 = var12.getStartingTimeInMillis();
      List var9 = var12.getGraphRelativeTimedDataPoints();
      Entry var16;
      if (var9 != null) {
         Iterator var13 = ((Iterable)var9).iterator();
         Object var15;
         if (!var13.hasNext()) {
            var15 = null;
         } else {
            var15 = var13.next();
            if (var13.hasNext()) {
               Entry var10 = (Entry)var15;
               float var6 = (float)(var1 - var7);
               float var3 = Math.abs(var6 - var10.getX());
               Object var17 = var15;

               do {
                  Object var11 = var13.next();
                  float var5 = Math.abs(var6 - ((Entry)var11).getX());
                  float var4 = var3;
                  var15 = var17;
                  if (Float.compare(var3, var5) > 0) {
                     var15 = var11;
                     var4 = var5;
                  }

                  var3 = var4;
                  var17 = var15;
               } while(var13.hasNext());
            }
         }

         var16 = (Entry)var15;
      } else {
         var16 = null;
      }

      Entry var18;
      if (var16 != null) {
         var18 = new Entry(var16.getX() + (float)var12.getStartingTimeInMillis(), var16.getY());
      } else {
         var18 = null;
      }

      Timber.Forest var22 = Timber.Forest;
      StringBuilder var21 = new StringBuilder("gotoTime: relativelyTimedClosestEntry = ");
      var21.append(var16);
      var21.append(", closestEntry = ");
      var21.append(var18);
      var21.append(", tempLastSelectedEntry = ");
      var21.append(this.getTempLastSelectedEntry());
      var21.append(", name = ");
      var21.append(this.name);
      var22.v(var21.toString(), new Object[0]);
      if (var16 != null) {
         float var14 = var16.getX();
         var18 = this.tempRelativelyTimedLastSelectedEntry;
         Float var20;
         if (var18 != null) {
            var20 = var18.getX();
         } else {
            var20 = null;
         }

         if (!Intrinsics.areEqual(var14, var20)) {
            this.tempRelativelyTimedLastSelectedEntry = var16;
            updateState$default(this, var12, false, 2, (Object)null);
         }
      }

   }

   public final boolean isCelsius$graph_otherRelease() {
      return ((GraphState)this.getState()).isCelsius();
   }

   public GraphState onSaveState() {
      ChartTimeScale var4 = ((GraphState)this.getState()).getTimeScale();
      int var1 = ((GraphState)this.getState()).getTypeCode();
      Entry var6 = ((GraphState)this.getState()).getLastSelectedEntry();
      int var2 = ((GraphState)this.getState()).getNumberOfRanges();
      List var5 = ((GraphState)this.getState()).getMaxThresholds();
      boolean var3 = ((GraphState)this.getState()).isCelsius();
      return new GraphState((List)null, (List)null, (List)null, (List)null, (List)null, (Set)null, var6, ((GraphState)this.getState()).getStartingTimeInMillis(), ((GraphState)this.getState()).getLatestTimeInMillis(), var4, var1, var2, var5, var3, 0L, (IndoorAirRatingRanges)null, 49215, (DefaultConstructorMarker)null);
   }

   public final void refresh() {
      this.updateScale(((GraphState)this.getState()).getTimeScale(), true);
   }

   public final ReversedResult reverseRelativelyTimedEntryToDataPoint(Entry var1) {
      Intrinsics.checkNotNullParameter(var1, "entry");
      Entry var4 = new Entry(var1.getX() + (float)this.getStartingTimeInMillis(), var1.getY());
      SimpleDatapoint var5;
      if (this.outdoor) {
         var5 = this.reverseOutdoorEntryToDataPoint(var4);
      } else {
         var5 = this.reverseIndoorEntryToDataPoint((long)var1.getX() + this.getStartingTimeInMillis(), var1.getY());
      }

      Object var3 = null;
      if (var5 != null) {
         SimpleDatapoint var2 = (SimpleDatapoint)var3;
         if (!this.outdoor) {
            var2 = (SimpleDatapoint)var3;
            if (PollutantType.Companion.fromSensorType(this.getSensorType$graph_otherRelease()) != null) {
               var4 = this.getCompareDataPointForEntry(var4);
               var2 = (SimpleDatapoint)var3;
               if (var4 != null) {
                  var2 = this.reverseIndoorEntryToDataPoint((long)var4.getX(), var4.getY());
               }
            }
         }

         return new ReversedResult(var5, var2);
      } else {
         return null;
      }
   }

   public final void setPollutantType(PollutantType var1) {
      Intrinsics.checkNotNullParameter(var1, "nuPollutantType");
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("setPollutantType = ");
      var3.append(var1);
      var3.append(", name = ");
      var3.append(this.name);
      var4.v(var3.toString(), new Object[0]);
      this.tempRelativelyTimedLastSelectedEntry = null;
      Object var8 = this.getStateLock();
      synchronized(var8){}

      try {
         GraphState var9 = (GraphState)this.getState();
         int var2 = var1.getCode();
         this.updateState(GraphState.copy$default(var9, (List)null, (List)null, (List)null, (List)null, (List)null, (Set)null, (Entry)null, System.currentTimeMillis() - MONTH_IN_MILIS, System.currentTimeMillis(), (ChartTimeScale)null, var2, 0, (List)null, false, 0L, (IndoorAirRatingRanges)null, 64000, (Object)null), false);
         Unit var7 = Unit.INSTANCE;
      } finally {
         ;
      }

   }

   public final void setSensorType(SensorType var1) {
      Intrinsics.checkNotNullParameter(var1, "nuSensorType");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("setSensorType = ");
      var4.append(var1);
      var4.append(", name = ");
      var4.append(this.name);
      var3.v(var4.toString(), new Object[0]);
      this.tempRelativelyTimedLastSelectedEntry = null;
      Object var8 = this.getStateLock();
      synchronized(var8){}

      try {
         GraphState var9 = (GraphState)this.getState();
         int var2 = var1.ordinal();
         this.updateState(GraphState.copy$default(var9, (List)null, (List)null, (List)null, (List)null, (List)null, (Set)null, (Entry)null, System.currentTimeMillis() - MONTH_IN_MILIS, System.currentTimeMillis(), (ChartTimeScale)null, var2, 0, (List)null, false, 0L, (IndoorAirRatingRanges)null, 64000, (Object)null), false);
         Unit var7 = Unit.INSTANCE;
      } finally {
         ;
      }

   }

   public final void setTempRelativelyTimedLastSelectedEntry(Entry var1) {
      this.tempRelativelyTimedLastSelectedEntry = var1;
   }

   public final void setTimeStampFilter(Set var1) {
      Intrinsics.checkNotNullParameter(var1, "nuTimeStampFilter");
      if (!Intrinsics.areEqual(var1, ((GraphState)this.getState()).getTimeStampFilter())) {
         List var3 = ((GraphState)this.getState()).getGraphHistoricalDataPoints();
         List var2 = ((GraphState)this.getState()).getGraphRealTimeDataPoints();
         GraphState var4 = GraphState.copy$default((GraphState)this.getState(), (List)null, (List)null, (List)null, (List)null, (List)null, var1, (Entry)null, 0L, 0L, (ChartTimeScale)null, 0, 0, (List)null, false, 0L, (IndoorAirRatingRanges)null, 65503, (Object)null);
         if (var3 == null && var2 == null) {
            updateState$default(this, var4, false, 2, (Object)null);
         } else {
            BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var3, this, var4, var2, (Continuation)null) {
               final List $graphHistoricalDataPoints;
               final List $graphRealTimeDataPoints;
               final GraphState $nuState;
               int label;
               final GraphViewModel this$0;

               {
                  this.$graphHistoricalDataPoints = var1;
                  this.this$0 = var2;
                  this.$nuState = var3;
                  this.$graphRealTimeDataPoints = var4;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.$graphHistoricalDataPoints, this.this$0, this.$nuState, this.$graphRealTimeDataPoints, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  if (this.label == 0) {
                     ResultKt.throwOnFailure(var1);
                     List var2 = this.$graphHistoricalDataPoints;
                     if (var2 != null) {
                        this.this$0.updateGraphDataPoints(var2, false, this.$nuState);
                     } else {
                        var2 = this.$graphRealTimeDataPoints;
                        if (var2 != null) {
                           this.this$0.updateGraphDataPoints(var2, true, this.$nuState);
                        }
                     }

                     return Unit.INSTANCE;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               }
            }, 2, (Object)null);
         }
      }
   }

   public final void updateHistorical(List var1, GraphState var2, Function1 var3, boolean var4) {
      Intrinsics.checkNotNullParameter(var1, "nuDatapoints");
      Intrinsics.checkNotNullParameter(var2, "nuState");
      Intrinsics.checkNotNullParameter(var3, "entryYMapper");
      if (!var1.isEmpty()) {
         Timber.Forest var5 = Timber.Forest;
         StringBuilder var6 = new StringBuilder("updateHistorical, isCompare = ");
         var6.append(var4);
         var6.append(", size = ");
         var6.append(var1.size());
         var6.append(", name = ");
         var6.append(this.name);
         var5.v(var6.toString(), new Object[0]);
         Iterable var12 = (Iterable)var1;
         Collection var7 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var12, 10)));

         for(SimpleDatapoint var13 : var12) {
            var7.add(new Entry((float)var13.getTimeInMillis(), ((Number)var3.invoke(var13.getValue())).floatValue()));
         }

         List var11 = (List)var7;
         List var8 = MpChartUtils.INSTANCE.reduceWithDouglasPeucker(var11, this.getTimeScale$graph_otherRelease());
         Timber.Forest var16 = Timber.Forest;
         StringBuilder var14 = new StringBuilder("updateHistorical: reducedDataPoints.size = ");
         var14.append(var8.size());
         var14.append(", ");
         var14.append(this.name);
         var16.v(var14.toString(), new Object[0]);
         if (var4) {
            if (!Intrinsics.areEqual(var8, var2.getCompareGraphDataPoints())) {
               BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getMain(), (CoroutineStart)null, new Function2(this, var2, var8, (Continuation)null) {
                  final GraphState $nuState;
                  final List $reducedDataPoints;
                  int label;
                  final GraphViewModel this$0;

                  {
                     this.this$0 = var1;
                     this.$nuState = var2;
                     this.$reducedDataPoints = var3;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.this$0, this.$nuState, this.$reducedDataPoints, var2));
                  }

                  public final Object invoke(CoroutineScope var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label == 0) {
                        ResultKt.throwOnFailure(var1);
                        this.this$0.updateState(GraphState.copy$default(this.$nuState, (List)null, (List)null, (List)null, (List)null, this.$reducedDataPoints, (Set)null, (Entry)null, 0L, 0L, (ChartTimeScale)null, 0, 0, (List)null, false, 0L, (IndoorAirRatingRanges)null, 65519, (Object)null), true);
                        return Unit.INSTANCE;
                     } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }
                  }
               }, 2, (Object)null);
            } else {
               Timber.Forest var10 = Timber.Forest;
               StringBuilder var9 = new StringBuilder("updateHistorical: IGNORE COMPARE SINCE SAME, name = ");
               var9.append(this.name);
               var10.v(var9.toString(), new Object[0]);
            }
         } else {
            if (var2.getTimeStampFilter() != null) {
               var8 = var11;
            }

            this.updateGraphDataPoints(var8, false, GraphState.copy$default(var2, var11, (List)null, (List)null, (List)null, (List)null, (Set)null, (Entry)null, 0L, 0L, (ChartTimeScale)null, 0, 0, (List)null, false, 0L, (IndoorAirRatingRanges)null, 65534, (Object)null));
         }
      }
   }

   public final void updateIndoorHistorical(List var1, boolean var2, IndoorAirRatingRanges var3, boolean var4, SensorType var5) {
      Intrinsics.checkNotNullParameter(var1, "nuDatapoints");
      Intrinsics.checkNotNullParameter(var3, "ratings");
      GraphState var7 = (GraphState)this.getState();
      if (var5 == null) {
         var5 = var7.getSensorType();
      }

      Timber.Forest var9 = Timber.Forest;
      StringBuilder var8 = new StringBuilder("updateIndoorHistorical, isCompare = ");
      var8.append(var4);
      var8.append(", size = ");
      var8.append(var1.size());
      var8.append(", name = ");
      var8.append(this.name);
      var9.v(var8.toString(), new Object[0]);
      double[] var11 = var3.airRatingsFor(var5);
      int var6 = var3.numberOfRangesFor(var5);
      GraphState var10;
      if (var4) {
         var10 = GraphState.copy$default(var7, (List)null, (List)null, (List)null, (List)null, (List)null, (Set)null, (Entry)null, 0L, 0L, (ChartTimeScale)null, 0, 0, (List)null, false, 0L, (IndoorAirRatingRanges)null, 65535, (Object)null);
      } else {
         var10 = GraphState.copy$default(var7, (List)null, (List)null, (List)null, (List)null, (List)null, (Set)null, (Entry)null, 0L, 0L, (ChartTimeScale)null, 0, var6, ArraysKt.toList(var11), var2, 0L, var3, 18431, (Object)null);
      }

      this.updateHistorical(var1, var10, new GraphViewModel$$ExternalSyntheticLambda1(var5, var11, var2), var4);
   }

   public final void updateIndoorRealTime(List var1, boolean var2, IndoorAirRatingRanges var3, SensorType var4) {
      Intrinsics.checkNotNullParameter(var1, "nuDatapoints");
      Intrinsics.checkNotNullParameter(var3, "ratings");
      Timber.Forest var6 = Timber.Forest;
      StringBuilder var5 = new StringBuilder("updateIndoorRealTime, size = ");
      var5.append(var1.size());
      var5.append(", name = ");
      var5.append(this.name);
      var6.v(var5.toString(), new Object[0]);
      GraphState var7 = (GraphState)this.getState();
      if (var4 == null) {
         var4 = ((GraphState)this.getState()).getSensorType();
      }

      double[] var8 = var3.airRatingsFor(var4);
      this.updateRealTime(var1, GraphState.copy$default(var7, (List)null, (List)null, (List)null, (List)null, (List)null, (Set)null, (Entry)null, 0L, 0L, (ChartTimeScale)null, 0, var3.numberOfRangesFor(var4), ArraysKt.toList(var8), var2, 0L, var3, 18431, (Object)null), new GraphViewModel$$ExternalSyntheticLambda3(var4, var8, var2));
   }

   public final void updateOutdoorHistorical(List var1, boolean var2, PollutantType var3) {
      Intrinsics.checkNotNullParameter(var1, "nuDatapoints");
      Timber.Forest var5 = Timber.Forest;
      StringBuilder var6 = new StringBuilder("updateOutdoorHistorical, isCompare = ");
      var6.append(var2);
      var6.append(", size = ");
      var6.append(var1.size());
      var6.append(", name = ");
      var6.append(this.name);
      var5.v(var6.toString(), new Object[0]);
      PollutantType.Companion var12 = PollutantType.Companion;
      PollutantType var8;
      if (var3 == null) {
         var8 = this.getPollutantType$graph_otherRelease();
      } else {
         var8 = var3;
      }

      SensorType var9 = var12.toSensorType(var8);
      double[] var7;
      if (var2 && var9 != null) {
         var7 = ((GraphState)this.getState()).getDeviceRatings().airRatingsFor(var9);
      } else {
         OutdoorAirRatingRanges var10 = OutdoorAirRatingRanges.INSTANCE;
         if (var3 == null) {
            var3 = this.getPollutantType$graph_otherRelease();
         }

         var7 = var10.airRatingsFor(var3).getHigh();
      }

      int var4 = var7.length;
      GraphState var11;
      if (var2) {
         var11 = GraphState.copy$default((GraphState)this.getState(), (List)null, (List)null, (List)null, (List)null, (List)null, (Set)null, (Entry)null, 0L, 0L, (ChartTimeScale)null, 0, 0, (List)null, false, 0L, (IndoorAirRatingRanges)null, 65535, (Object)null);
      } else {
         var11 = GraphState.copy$default((GraphState)this.getState(), (List)null, (List)null, (List)null, (List)null, (List)null, (Set)null, (Entry)null, 0L, 0L, (ChartTimeScale)null, 0, var4, ArraysKt.toList(var7), false, 0L, (IndoorAirRatingRanges)null, 59391, (Object)null);
      }

      this.updateHistorical(var1, var11, new GraphViewModel$$ExternalSyntheticLambda0(var7), var2);
   }

   public final void updateOutdoorRealTime(List var1, PollutantType var2) {
      Intrinsics.checkNotNullParameter(var1, "nuDatapoints");
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var5 = new StringBuilder("updateOutdoorRealTime, size = ");
      var5.append(var1.size());
      var5.append(", name = ");
      var5.append(this.name);
      var4.v(var5.toString(), new Object[0]);
      OutdoorAirRatingRanges var7 = OutdoorAirRatingRanges.INSTANCE;
      if (var2 == null) {
         var2 = this.getPollutantType$graph_otherRelease();
      }

      OutdoorRanges var8 = var7.airRatingsFor(var2);
      double[] var6 = var8.getHigh();
      int var3 = var6.length;
      this.updateRealTime(var1, GraphState.copy$default((GraphState)this.getState(), (List)null, (List)null, (List)null, (List)null, (List)null, (Set)null, (Entry)null, 0L, 0L, (ChartTimeScale)null, 0, var3, ArraysKt.toList(var6), false, 0L, (IndoorAirRatingRanges)null, 59391, (Object)null), new GraphViewModel$$ExternalSyntheticLambda2(var8));
   }

   public final void updateScale(ChartTimeScale var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "nuTimeScale");
      if (var1 != ((GraphState)this.getState()).getTimeScale() || var2) {
         Timber.Forest var4 = Timber.Forest;
         StringBuilder var3 = new StringBuilder("updateScale: name = ");
         var3.append(this.name);
         var4.v(var3.toString(), new Object[0]);
         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
            final ChartTimeScale $nuTimeScale;
            private Object L$0;
            int label;
            final GraphViewModel this$0;

            {
               this.this$0 = var1;
               this.$nuTimeScale = var2;
            }

            public final Continuation create(Object var1, Continuation var2) {
               Function2 var3 = new <anonymous constructor>(this.this$0, this.$nuTimeScale, var2);
               var3.L$0 = var1;
               return (Continuation)var3;
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               CoroutineScope var2 = (CoroutineScope)this.L$0;
               IntrinsicsKt.getCOROUTINE_SUSPENDED();
               if (this.label == 0) {
                  ResultKt.throwOnFailure(var1);
                  GraphState var3 = GraphState.copy$default((GraphState)this.this$0.getState(), (List)null, (List)null, (List)null, (List)null, (List)null, (Set)null, (Entry)null, 0L, 0L, this.$nuTimeScale, 0, 0, (List)null, false, 0L, (IndoorAirRatingRanges)null, 65023, (Object)null);
                  List var5 = var3.getGraphHistoricalDataPoints();
                  if (var5 != null) {
                     ChartTimeScale var4 = this.$nuTimeScale;
                     var5 = MpChartUtils.INSTANCE.reduceWithDouglasPeucker(var5, var4);
                  } else {
                     var5 = null;
                  }

                  if (var5 != null && !Intrinsics.areEqual(var5, var3.getGraphReducedHistoricalDataPoints())) {
                     this.this$0.updateGraphDataPoints(var5, false, var3);
                  } else {
                     BuildersKt.launch$default(var2, (CoroutineContext)Dispatchers.getMain(), (CoroutineStart)null, new Function2(this.this$0, var3, (Continuation)null) {
                        final GraphState $nuState;
                        int label;
                        final GraphViewModel this$0;

                        {
                           this.this$0 = var1;
                           this.$nuState = var2;
                        }

                        public final Continuation create(Object var1, Continuation var2) {
                           return (Continuation)(new <anonymous constructor>(this.this$0, this.$nuState, var2));
                        }

                        public final Object invoke(CoroutineScope var1, Continuation var2) {
                           return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object var1) {
                           IntrinsicsKt.getCOROUTINE_SUSPENDED();
                           if (this.label == 0) {
                              ResultKt.throwOnFailure(var1);
                              this.this$0.updateState(this.$nuState, true);
                              return Unit.INSTANCE;
                           } else {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }
                        }
                     }, 2, (Object)null);
                  }

                  return Unit.INSTANCE;
               } else {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }
            }
         }, 2, (Object)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"},
      d2 = {"Lcom/blueair/graph/viewmodel/GraphViewModel$Companion;", "", "<init>", "()V", "DEFAULT_TIME_SCALE", "Lcom/blueair/graph/utils/ChartTimeScale;", "getDEFAULT_TIME_SCALE", "()Lcom/blueair/graph/utils/ChartTimeScale;", "MONTH_IN_MILIS", "", "getMONTH_IN_MILIS", "()J", "graph_otherRelease"},
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

      public final ChartTimeScale getDEFAULT_TIME_SCALE() {
         return GraphViewModel.DEFAULT_TIME_SCALE;
      }

      public final long getMONTH_IN_MILIS() {
         return GraphViewModel.MONTH_IN_MILIS;
      }
   }
}
