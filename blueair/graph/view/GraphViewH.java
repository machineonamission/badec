package com.blueair.graph.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.SensorType;
import com.blueair.core.model.SimpleDatapoint;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.graph.databinding.GraphHBinding;
import com.blueair.graph.utils.ChartTimeScale;
import com.blueair.graph.utils.GraphUtils;
import com.blueair.graph.utils.MpChartUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.LimitLine.LimitLabelPosition;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.LineDataSet.Mode;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.BarLineChartTouchListener;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Utils;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\u0018\u0000 r2\u00020\u0001:\u0002qrB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"H\u0002J\u0016\u0010H\u001a\b\u0012\u0004\u0012\u00020\n0\u001b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u0013J\u001a\u0010L\u001a\u00020<2\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010O\u001a\u0004\u0018\u00010PJ\u000e\u0010Q\u001a\u00020<2\u0006\u0010R\u001a\u00020(J)\u0010S\u001a\u00020<2!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110(¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(R\u0012\u0004\u0012\u00020<0;J+\u0010T\u001a\u00020<2#\u0010=\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020<0;J\b\u0010U\u001a\u00020<H\u0014J\b\u0010V\u001a\u00020<H\u0014J\b\u0010W\u001a\u00020<H\u0002J\u000e\u0010X\u001a\u00020<2\u0006\u0010X\u001a\u00020JJ\u0014\u0010Y\u001a\u00020<2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u0014\u0010[\u001a\u00020<2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u001e\u0010\\\u001a\u00020<2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010]\u001a\u00020JH\u0002J\u0012\u0010^\u001a\u00020<2\b\u0010_\u001a\u0004\u0018\u00010$H\u0002J\u0012\u0010`\u001a\u00020<2\b\u0010_\u001a\u0004\u0018\u00010$H\u0002J\u001c\u0010a\u001a\u00020<2\u0006\u0010R\u001a\u00020(2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010$H\u0002J\u001e\u0010b\u001a\u00020<2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010c\u001a\u00020JH\u0002J\u0010\u0010d\u001a\u00020<2\u0006\u0010_\u001a\u00020$H\u0002J\b\u0010e\u001a\u00020<H\u0002J\b\u0010f\u001a\u00020<H\u0002J\u0010\u0010g\u001a\u00020<2\u0006\u0010h\u001a\u00020\"H\u0002J\u0012\u0010i\u001a\u00020<2\b\b\u0002\u0010j\u001a\u00020\nH\u0002J0\u0010k\u001a\u00020<2\u0006\u0010l\u001a\u00020J2\u0006\u0010m\u001a\u00020\n2\u0006\u0010n\u001a\u00020\n2\u0006\u0010o\u001a\u00020\n2\u0006\u0010p\u001a\u00020\nH\u0014R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\"@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b&\u0010'R$\u0010)\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020(@CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00108\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\"@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b9\u0010'R\u001c\u0010:\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020<\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010=\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020<\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010B\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001c@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020\n0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006s"},
   d2 = {"Lcom/blueair/graph/view/GraphViewH;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "xAxisLineJob", "Lkotlinx/coroutines/Job;", "value", "Lcom/blueair/graph/view/GraphViewH$DataType;", "dataType", "getDataType", "()Lcom/blueair/graph/view/GraphViewH$DataType;", "rawStartTime", "", "rawEndTime", "zeroTime", "", "Lcom/blueair/core/model/SimpleDatapoint;", "rawDatapoint", "setRawDatapoint", "(Ljava/util/List;)V", "getTimestampFromEntryX", "x", "", "entries", "Lcom/github/mikephil/charting/data/Entry;", "maxX", "setMaxX", "(F)V", "Lcom/blueair/graph/utils/ChartTimeScale;", "timeScale", "getTimeScale", "()Lcom/blueair/graph/utils/ChartTimeScale;", "setTimeScaleField", "(Lcom/blueair/graph/utils/ChartTimeScale;)V", "chartScale", "binding", "Lcom/blueair/graph/databinding/GraphHBinding;", "chart", "Lcom/github/mikephil/charting/charts/LineChart;", "scrollIndicatorTrack", "Landroid/widget/FrameLayout;", "scrollIndicator", "Landroid/view/View;", "scrollIndicatorPreviousDx", "scrollIndicatorPosition", "setScrollIndicatorPosition", "onTimeScaleChangedListener", "Lkotlin/Function1;", "", "onDatapointSelectedListener", "Lkotlin/ParameterName;", "name", "datapoint", "highlightedEntry", "highlightedPoint", "getHighlightedPoint", "()Lcom/blueair/core/model/SimpleDatapoint;", "setHighlightedPoint", "(Lcom/blueair/core/model/SimpleDatapoint;)V", "graphLineGradient", "getGradient", "setDataType", "", "type", "setTitle", "title", "", "onClickListener", "Landroid/view/View$OnClickListener;", "setTimeScale", "scale", "setOnTimeScaleChangedListener", "setOnDatapointSelectedListener", "onAttachedToWindow", "onDetachedFromWindow", "setupChart", "showProgress", "updateHistoricalData", "data", "updateRealTimeData", "setData", "isRealTime", "scaleAndCenter", "entry", "highlightEntry", "notifyChartScaleChanged", "notifyChartDataChanged", "isAppend", "setChartMarker", "highlightCenterEntry", "setupXAxisLines", "updateScrollIndicatorWidth", "chartScaleX", "updateScrollIndicatorPosition", "indicatorWidth", "onLayout", "changed", "left", "top", "right", "bottom", "DataType", "Companion", "graph_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GraphViewH extends ConstraintLayout {
   private static final int BLOCK_COUNT = 3;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final int DIVIDER_LINE_COLOR;
   private static final int DIVIDER_TEXT_COLOR;
   private static final long ONE_DAY_IN_MILLS = 86400000L;
   private static final float ONE_DAY_IN_X = 17280.0F;
   private static final long ONE_MONTH_IN_MILLS = 2592000000L;
   private static final float ONE_MONTH_IN_X = 518400.0F;
   private static final long ONE_WEEK_IN_MILLS = 604800000L;
   private static final float ONE_WEEK_IN_X = 120960.0F;
   private static final float SCALE_DAY = 240.0F;
   private static final float SCALE_MONTH = 1.0F;
   private static final float SCALE_WEEK = 3.3333333F;
   private static final int X_FACTOR = 5000;
   private final GraphHBinding binding;
   private final LineChart chart;
   private float chartScale;
   private DataType dataType;
   private List entries;
   private List graphLineGradient;
   private Entry highlightedEntry;
   private SimpleDatapoint highlightedPoint;
   private float maxX;
   private Function1 onDatapointSelectedListener;
   private Function1 onTimeScaleChangedListener;
   private List rawDatapoint;
   private long rawEndTime;
   private long rawStartTime;
   private final CoroutineScope scope;
   private final View scrollIndicator;
   private float scrollIndicatorPosition;
   private float scrollIndicatorPreviousDx;
   private final FrameLayout scrollIndicatorTrack;
   private ChartTimeScale timeScale;
   private Job xAxisLineJob;
   private long zeroTime;

   // $FF: synthetic method
   public static void $r8$lambda$ZvrLImZ_SG32RSQFUbMCW7eCTJw/* $FF was: $r8$lambda$ZvrLImZ-SG32RSQFUbMCW7eCTJw*/(GraphViewH var0, Entry var1) {
      highlightEntry$lambda$17(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$eAwnwxclj_owbnrv9JG5Pa_Xy8I/* $FF was: $r8$lambda$eAwnwxclj-owbnrv9JG5Pa_Xy8I*/(GraphViewH var0, float var1, RadioGroup var2, int var3) {
      _init_$lambda$9(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$xzfWI0F1KRotEvOX1TqbyRflNfo(GraphViewH var0, Entry var1) {
      highlightEntry$lambda$18(var0, var1);
   }

   static {
      DIVIDER_TEXT_COLOR = R.color.colorPrimaryText;
      DIVIDER_LINE_COLOR = R.color.gainsboro;
   }

   public GraphViewH(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1);
      this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus((CoroutineContext)SupervisorKt.SupervisorJob$default((Job)null, 1, (Object)null)));
      this.rawDatapoint = CollectionsKt.emptyList();
      this.entries = CollectionsKt.emptyList();
      this.timeScale = ChartTimeScale.DAY;
      this.chartScale = 240.0F;
      GraphHBinding var6 = GraphHBinding.inflate(LayoutInflater.from(this.getContext()), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      LineChart var4 = var6.lineChart;
      Intrinsics.checkNotNullExpressionValue(var4, "lineChart");
      this.chart = var4;
      FrameLayout var8 = var6.scrollIndicatorTrack;
      Intrinsics.checkNotNullExpressionValue(var8, "scrollIndicatorTrack");
      this.scrollIndicatorTrack = var8;
      View var9 = var6.scrollIndicator;
      Intrinsics.checkNotNullExpressionValue(var9, "scrollIndicator");
      this.scrollIndicator = var9;
      this.graphLineGradient = CollectionsKt.emptyList();
      RadioGroup var5 = var6.radioGroupTimeScale;
      ChartTimeScale var10 = this.timeScale;
      int var3 = GraphViewH.WhenMappings.$EnumSwitchMapping$0[var10.ordinal()];
      if (var3 != 1) {
         if (var3 != 2) {
            if (var3 != 3) {
               throw new NoWhenBranchMatchedException();
            }

            var3 = com.blueair.graph.R.id.rb_month;
         } else {
            var3 = com.blueair.graph.R.id.rb_week;
         }
      } else {
         var3 = com.blueair.graph.R.id.rb_day;
      }

      var5.check(var3);
      float var2 = var6.rbDay.getElevation();
      var6.radioGroupTimeScale.setOnCheckedChangeListener(new GraphViewH$$ExternalSyntheticLambda0(this, var2));
   }

   public GraphViewH(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2);
      this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus((CoroutineContext)SupervisorKt.SupervisorJob$default((Job)null, 1, (Object)null)));
      this.rawDatapoint = CollectionsKt.emptyList();
      this.entries = CollectionsKt.emptyList();
      this.timeScale = ChartTimeScale.DAY;
      this.chartScale = 240.0F;
      GraphHBinding var6 = GraphHBinding.inflate(LayoutInflater.from(this.getContext()), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      LineChart var7 = var6.lineChart;
      Intrinsics.checkNotNullExpressionValue(var7, "lineChart");
      this.chart = var7;
      FrameLayout var8 = var6.scrollIndicatorTrack;
      Intrinsics.checkNotNullExpressionValue(var8, "scrollIndicatorTrack");
      this.scrollIndicatorTrack = var8;
      View var9 = var6.scrollIndicator;
      Intrinsics.checkNotNullExpressionValue(var9, "scrollIndicator");
      this.scrollIndicator = var9;
      this.graphLineGradient = CollectionsKt.emptyList();
      RadioGroup var5 = var6.radioGroupTimeScale;
      ChartTimeScale var10 = this.timeScale;
      int var4 = GraphViewH.WhenMappings.$EnumSwitchMapping$0[var10.ordinal()];
      if (var4 != 1) {
         if (var4 != 2) {
            if (var4 != 3) {
               throw new NoWhenBranchMatchedException();
            }

            var4 = com.blueair.graph.R.id.rb_month;
         } else {
            var4 = com.blueair.graph.R.id.rb_week;
         }
      } else {
         var4 = com.blueair.graph.R.id.rb_day;
      }

      var5.check(var4);
      float var3 = var6.rbDay.getElevation();
      var6.radioGroupTimeScale.setOnCheckedChangeListener(new GraphViewH$$ExternalSyntheticLambda0(this, var3));
   }

   public GraphViewH(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
      this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus((CoroutineContext)SupervisorKt.SupervisorJob$default((Job)null, 1, (Object)null)));
      this.rawDatapoint = CollectionsKt.emptyList();
      this.entries = CollectionsKt.emptyList();
      this.timeScale = ChartTimeScale.DAY;
      this.chartScale = 240.0F;
      GraphHBinding var6 = GraphHBinding.inflate(LayoutInflater.from(this.getContext()), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      LineChart var7 = var6.lineChart;
      Intrinsics.checkNotNullExpressionValue(var7, "lineChart");
      this.chart = var7;
      FrameLayout var8 = var6.scrollIndicatorTrack;
      Intrinsics.checkNotNullExpressionValue(var8, "scrollIndicatorTrack");
      this.scrollIndicatorTrack = var8;
      View var9 = var6.scrollIndicator;
      Intrinsics.checkNotNullExpressionValue(var9, "scrollIndicator");
      this.scrollIndicator = var9;
      this.graphLineGradient = CollectionsKt.emptyList();
      RadioGroup var5 = var6.radioGroupTimeScale;
      ChartTimeScale var10 = this.timeScale;
      var3 = GraphViewH.WhenMappings.$EnumSwitchMapping$0[var10.ordinal()];
      if (var3 != 1) {
         if (var3 != 2) {
            if (var3 != 3) {
               throw new NoWhenBranchMatchedException();
            }

            var3 = com.blueair.graph.R.id.rb_month;
         } else {
            var3 = com.blueair.graph.R.id.rb_week;
         }
      } else {
         var3 = com.blueair.graph.R.id.rb_day;
      }

      var5.check(var3);
      float var4 = var6.rbDay.getElevation();
      var6.radioGroupTimeScale.setOnCheckedChangeListener(new GraphViewH$$ExternalSyntheticLambda0(this, var4));
   }

   public GraphViewH(Context var1, AttributeSet var2, int var3, int var4) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2, var3);
      this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus((CoroutineContext)SupervisorKt.SupervisorJob$default((Job)null, 1, (Object)null)));
      this.rawDatapoint = CollectionsKt.emptyList();
      this.entries = CollectionsKt.emptyList();
      this.timeScale = ChartTimeScale.DAY;
      this.chartScale = 240.0F;
      GraphHBinding var7 = GraphHBinding.inflate(LayoutInflater.from(this.getContext()), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var7, "inflate(...)");
      this.binding = var7;
      LineChart var8 = var7.lineChart;
      Intrinsics.checkNotNullExpressionValue(var8, "lineChart");
      this.chart = var8;
      FrameLayout var9 = var7.scrollIndicatorTrack;
      Intrinsics.checkNotNullExpressionValue(var9, "scrollIndicatorTrack");
      this.scrollIndicatorTrack = var9;
      View var10 = var7.scrollIndicator;
      Intrinsics.checkNotNullExpressionValue(var10, "scrollIndicator");
      this.scrollIndicator = var10;
      this.graphLineGradient = CollectionsKt.emptyList();
      RadioGroup var6 = var7.radioGroupTimeScale;
      ChartTimeScale var11 = this.timeScale;
      var3 = GraphViewH.WhenMappings.$EnumSwitchMapping$0[var11.ordinal()];
      if (var3 != 1) {
         if (var3 != 2) {
            if (var3 != 3) {
               throw new NoWhenBranchMatchedException();
            }

            var3 = com.blueair.graph.R.id.rb_month;
         } else {
            var3 = com.blueair.graph.R.id.rb_week;
         }
      } else {
         var3 = com.blueair.graph.R.id.rb_day;
      }

      var6.check(var3);
      float var5 = var7.rbDay.getElevation();
      var7.radioGroupTimeScale.setOnCheckedChangeListener(new GraphViewH$$ExternalSyntheticLambda0(this, var5));
   }

   private static final void _init_$lambda$9(GraphViewH var0, float var1, RadioGroup var2, int var3) {
      for(RadioButton var6 : (Iterable)CollectionsKt.listOf(new RadioButton[]{var0.binding.rbDay, var0.binding.rbWeek, var0.binding.rbMonth})) {
         float var4;
         if (var6.getId() == var3) {
            var4 = var1;
         } else {
            var4 = 0.0F;
         }

         var6.setElevation(var4);
      }

      ChartTimeScale var7;
      if (var3 == com.blueair.graph.R.id.rb_day) {
         var0.binding.rgSeparator1.setVisibility(4);
         var0.binding.rgSeparator2.setVisibility(0);
         var7 = ChartTimeScale.DAY;
      } else if (var3 == com.blueair.graph.R.id.rb_week) {
         var0.binding.rgSeparator1.setVisibility(4);
         var0.binding.rgSeparator2.setVisibility(4);
         var7 = ChartTimeScale.WEEK;
      } else if (var3 == com.blueair.graph.R.id.rb_month) {
         var0.binding.rgSeparator1.setVisibility(0);
         var0.binding.rgSeparator2.setVisibility(4);
         var7 = ChartTimeScale.MONTH;
      } else {
         var7 = ChartTimeScale.DAY;
      }

      notifyChartScaleChanged$default(var0, var7, (Entry)null, 2, (Object)null);
   }

   private final List getGradient(DataType var1) {
      List var6 = (List)(new ArrayList());
      boolean var5 = var1 instanceof DataType.HUM;
      byte var3 = 0;
      if (var5) {
         int var4 = getGradient$lambda$7$getColor(this, R.color.color_moderate);

         for(int var2 = 0; var2 < 7; ++var2) {
            var6.add(var4);
         }

         var4 = getGradient$lambda$7$getColor(this, R.color.color_good);

         for(int var8 = 0; var8 < 4; ++var8) {
            var6.add(var4);
         }

         var4 = getGradient$lambda$7$getColor(this, R.color.color_vpolluted);

         for(int var9 = var3; var9 < 7; ++var9) {
            var6.add(var4);
         }
      } else {
         if (var1 instanceof DataType.TMP) {
            var6.add(getGradient$lambda$7$getColor(this, R.color.colorPrimary));
            return var6;
         }

         if (!(var1 instanceof DataType.AQI)) {
            throw new NoWhenBranchMatchedException();
         }

         Iterator var7 = ((Iterable)CollectionsKt.listOf(new Integer[]{R.color.color_vpolluted, R.color.color_polluted, R.color.color_moderate, R.color.color_good, R.color.color_excellent})).iterator();

         while(var7.hasNext()) {
            var6.add(getGradient$lambda$7$getColor(this, ((Number)var7.next()).intValue()));
         }
      }

      return var6;
   }

   private static final int getGradient$lambda$7$getColor(GraphViewH var0, int var1) {
      return ResourcesCompat.getColor(var0.getResources(), var1, var0.getContext().getTheme());
   }

   private final long getTimestampFromEntryX(float var1) {
      return (long)(var1 * (float)5000) + this.zeroTime;
   }

   private final void highlightCenterEntry() {
      if (!this.entries.isEmpty()) {
         LineChart var5 = this.chart;
         MPPointD var7 = var5.getValuesByTouchPoint(var5.getViewPortHandler().contentLeft(), this.chart.getViewPortHandler().contentBottom(), this.chart.getAxisLeft().getAxisDependency());
         LineChart var6 = this.chart;
         MPPointD var10 = var6.getValuesByTouchPoint(var6.getViewPortHandler().contentRight(), this.chart.getViewPortHandler().contentBottom(), this.chart.getAxisLeft().getAxisDependency());
         double var1 = var7.x;
         double var3 = (var10.x - var7.x) / (double)2;
         this.chart.highlightValue((float)(var1 + var3), 0);
         Highlight[] var8 = this.chart.getHighlighted();
         if (var8 != null && var8.length != 0) {
            Entry var9 = ((ILineDataSet)((LineData)this.chart.getData()).getDataSets().get(0)).getEntryForXValue(var8[0].getX(), var8[0].getY());
            if (var9 == null) {
               return;
            }

            this.setChartMarker(var9);
         }

      }
   }

   private final void highlightEntry(Entry var1) {
      if (var1 == null) {
         this.chart.highlightValues((Highlight[])null);
         this.highlightedEntry = null;
         this.setHighlightedPoint((SimpleDatapoint)null);
      } else {
         this.scaleAndCenter(var1);
         this.chart.highlightValue(var1.getX(), 0);
         this.post(new GraphViewH$$ExternalSyntheticLambda1(this, var1));
         this.postDelayed(new GraphViewH$$ExternalSyntheticLambda2(this, var1), 300L);
      }
   }

   private static final void highlightEntry$lambda$17(GraphViewH var0, Entry var1) {
      var0.setChartMarker(var1);
   }

   private static final void highlightEntry$lambda$18(GraphViewH var0, Entry var1) {
      var0.setScrollIndicatorPosition((float)var0.chart.getWidth() * (var0.maxX - var1.getX()) / RangesKt.coerceAtLeast(var0.maxX - var0.chart.getXAxis().getAxisMinimum(), 1.0F));
   }

   private final void notifyChartDataChanged(List var1, boolean var2) {
      SimpleDatapoint var5 = this.highlightedPoint;
      boolean var3;
      if (var5 != null && var5.getTimeInMillis() != this.rawEndTime) {
         var3 = false;
      } else {
         var3 = true;
      }

      DataType var11 = this.dataType;
      if (var11 != null) {
         boolean var4;
         if (var2) {
            var4 = var3;
            if (!((Collection)var1).isEmpty()) {
               this.setMaxX(this.maxX + (float)((((SimpleDatapoint)CollectionsKt.last(var1)).getTimeInMillis() - this.rawEndTime) / (long)5000));
               this.setRawDatapoint(CollectionsKt.plus((Collection)this.rawDatapoint, (Iterable)var1));
               Iterable var14 = (Iterable)Companion.convertToEntries(var1, var11, this.zeroTime);

               for(Entry var10 : var14) {
                  ((LineData)this.chart.getData()).addEntry(var10, 0);
               }

               this.entries = CollectionsKt.plus((Collection)this.entries, var14);
               this.chart.notifyDataSetChanged();
               var4 = var3;
            }
         } else {
            this.setRawDatapoint(var1);
            if (var1.isEmpty()) {
               this.entries = CollectionsKt.emptyList();
            } else {
               this.entries = Companion.convertToEntries(var1, var11, this.zeroTime);
               LineDataSet var7 = new LineDataSet(this.entries, "");
               var7.setMode(Mode.HORIZONTAL_BEZIER);
               var7.setLineWidth(3.0F);
               var7.setColors(this.graphLineGradient);
               var7.setDrawValues(false);
               var7.setDrawCircles(false);
               var7.setDrawHighlightIndicators(false);
               this.chart.setData((ChartData)(new LineData(new ILineDataSet[]{var7})));
               Entry var6 = this.highlightedEntry;
               Entry var9;
               if (var6 == null) {
                  var9 = null;
               } else {
                  Iterator var12 = ((Iterable)this.entries).iterator();

                  do {
                     if (!var12.hasNext()) {
                        var8 = null;
                        break;
                     }

                     var8 = var12.next();
                  } while(((Entry)var8).getX() != var6.getX());

                  var9 = (Entry)var8;
               }

               this.notifyChartScaleChanged(this.timeScale, var9);
               var3 = false;
            }

            this.setMaxX(0.0F);
            var4 = var3;
         }

         if (this.entries.isEmpty()) {
            this.showProgress(true);
            this.chart.clear();
            this.setScrollIndicatorPosition(0.0F);
            this.highlightedEntry = null;
            this.setHighlightedPoint((SimpleDatapoint)null);
         } else {
            this.showProgress(false);
            this.chart.invalidate();
         }

         if (var4) {
            this.highlightEntry((Entry)CollectionsKt.lastOrNull(this.entries));
         }
      }

   }

   private final void notifyChartScaleChanged(ChartTimeScale var1, Entry var2) {
      ChartTouchListener var3 = this.chart.getOnTouchListener();
      BarLineChartTouchListener var5;
      if (var3 instanceof BarLineChartTouchListener) {
         var5 = (BarLineChartTouchListener)var3;
      } else {
         var5 = null;
      }

      if (var5 != null) {
         var5.stopDeceleration();
      }

      this.setTimeScaleField(var1);
      this.updateScrollIndicatorWidth(this.chartScale);
      this.setupXAxisLines();
      Entry var6 = var2;
      if (var2 == null) {
         var6 = (Entry)CollectionsKt.lastOrNull(this.entries);
      }

      this.highlightEntry(var6);
      Function1 var4 = this.onTimeScaleChangedListener;
      if (var4 != null) {
         var4.invoke(var1);
      }

   }

   // $FF: synthetic method
   static void notifyChartScaleChanged$default(GraphViewH var0, ChartTimeScale var1, Entry var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      var0.notifyChartScaleChanged(var1, var2);
   }

   private final void scaleAndCenter(Entry var1) {
      float var2;
      label14: {
         if (var1 == null) {
            var1 = (Entry)CollectionsKt.lastOrNull(this.entries);
            if (var1 == null) {
               var2 = 0.0F;
               break label14;
            }
         }

         var2 = var1.getX();
      }

      this.chart.zoomAndCenterAnimated(this.chartScale, 1.0F, var2, 0.0F, AxisDependency.RIGHT, 0L);
   }

   private final void setChartMarker(Entry var1) {
      DataType var8 = this.dataType;
      if (var8 != null) {
         MarkerView var5 = new MarkerView(this.getContext(), com.blueair.graph.R.layout.markerview_dot_new);
         View var7 = var5.findViewById(com.blueair.graph.R.id.marker_dot);
         View var10 = var5.findViewById(com.blueair.graph.R.id.dashed_line);
         MPPointD var6 = this.chart.getPixelForValues(var1.getX(), var1.getY(), AxisDependency.LEFT);
         float var2 = this.getResources().getDimension(R.dimen.chart_marker_size_outdoor) / (float)2;
         Intrinsics.checkNotNull(var10);
         ViewGroup.LayoutParams var9 = var10.getLayoutParams();
         if (var9 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
         }

         var9.height = this.chart.getHeight();
         var10.setLayoutParams(var9);
         var7.setTranslationY((float)var6.y - var2);
         var7.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this.getContext(), Companion.getLegendColor(var8, var1.getY()))));
         var5.setOffset(-var2, -((float)var6.y));
         this.chart.setMarker((IMarker)var5);
         this.highlightedEntry = var1;
         SimpleDatapoint var11 = (SimpleDatapoint)var1.getData();
         if (var11 instanceof SimpleDatapoint) {
            var11 = var11;
         } else {
            var11 = null;
         }

         if (var11 != null) {
            TextView var15 = this.binding.timeLabel;
            GraphUtils var13 = GraphUtils.INSTANCE;
            long var3 = var11.getTimeInMillis();
            Context var14 = this.getContext();
            Intrinsics.checkNotNullExpressionValue(var14, "getContext(...)");
            var15.setText((CharSequence)GraphUtils.getStringDate$default(var13, var3, var14, false, 4, (Object)null));
            this.setHighlightedPoint(var11);
         }
      }

   }

   private final void setData(List var1, boolean var2) {
      Timber.Forest var7 = Timber.Forest;
      StringBuilder var8 = new StringBuilder("setData: ");
      var8.append(var1.size());
      var8.append(", ");
      var8.append(var2);
      String var13 = var8.toString();
      boolean var6 = false;
      var7.d(var13, new Object[0]);
      List var10 = var1;
      if (var2) {
         var10 = var1;
         if (!((Collection)var1).isEmpty()) {
            long var3 = this.rawEndTime / 1000L;
            Iterable var11 = (Iterable)var1;
            Collection var9 = (Collection)(new ArrayList());

            for(Object var12 : var11) {
               if (((SimpleDatapoint)var12).getTimeInSeconds() > var3) {
                  var9.add(var12);
               }
            }

            var10 = (List)var9;
         }
      }

      boolean var5 = var6;
      if (var2) {
         var5 = var6;
         if (!((Collection)this.rawDatapoint).isEmpty()) {
            var5 = true;
         }
      }

      this.notifyChartDataChanged(var10, var5);
   }

   private final void setHighlightedPoint(SimpleDatapoint var1) {
      if (!Intrinsics.areEqual(this.highlightedPoint, var1)) {
         this.highlightedPoint = var1;
         Function1 var2 = this.onDatapointSelectedListener;
         if (var2 != null) {
            var2.invoke(var1);
         }
      }

   }

   private final void setMaxX(float var1) {
      if (this.maxX != var1) {
         this.maxX = var1;
      }
   }

   private final void setRawDatapoint(List var1) {
      this.rawDatapoint = var1;
      if (var1.isEmpty()) {
         this.zeroTime = 0L;
         this.rawStartTime = 0L;
         this.rawEndTime = 0L;
      } else {
         long var2 = ((SimpleDatapoint)CollectionsKt.first(var1)).getTimeInMillis();
         long var4 = ((SimpleDatapoint)CollectionsKt.last(var1)).getTimeInMillis();
         if (this.rawStartTime != var2) {
            this.zeroTime = var4;
         }

         this.rawStartTime = var2;
         this.rawEndTime = var4;
      }
   }

   private final void setScrollIndicatorPosition(float var1) {
      this.scrollIndicatorPosition = var1;
      updateScrollIndicatorPosition$default(this, 0, 1, (Object)null);
   }

   private final void setTimeScaleField(ChartTimeScale var1) {
      this.timeScale = var1;
      int var3 = GraphViewH.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
      float var2;
      if (var3 != 1) {
         if (var3 != 2) {
            if (var3 != 3) {
               throw new NoWhenBranchMatchedException();
            }

            var2 = 1.0F;
         } else {
            var2 = 3.3333333F;
         }
      } else {
         var2 = 240.0F;
      }

      this.chartScale = var2;
   }

   private final void setupChart() {
      LineChart var1 = this.chart;
      var1.setViewPortOffsets(0.0F, 0.0F, 0.0F, 0.0F);
      var1.setDrawGridBackground(false);
      var1.getDescription().setEnabled(false);
      var1.getLegend().setEnabled(false);
      var1.setTouchEnabled(true);
      var1.setDragDecelerationEnabled(true);
      var1.setDragEnabled(true);
      var1.setDragXEnabled(true);
      var1.setDragYEnabled(false);
      var1.setPinchZoom(true);
      var1.setDoubleTapToZoomEnabled(false);
      var1.setScaleEnabled(false);
      var1.setScaleXEnabled(false);
      var1.setScaleYEnabled(false);
      var1.setAutoScaleMinMaxEnabled(false);
      var1.setNoDataText("");
      var1.setClipValuesToContent(true);
      var1.setDragDecelerationFrictionCoef(0.85F);
      var1.setDrawMarkers(true);
      XAxis var2 = var1.getXAxis();
      var2.setAxisMinimum(-518400.0F);
      var2.setPosition(XAxisPosition.BOTTOM);
      var2.setDrawGridLines(false);
      var2.setDrawAxisLine(false);
      var2.setDrawLimitLinesBehindData(true);
      var2.setDrawLabels(false);
      var2.setGranularity(1.0F);
      YAxis var3 = var1.getAxisLeft();
      var3.setDrawGridLines(false);
      var3.setDrawAxisLine(false);
      var3.setDrawLimitLinesBehindData(true);
      var3.setDrawLabels(false);
      var3.setSpaceTop(0.0F);
      var3.setSpaceBottom(0.0F);
      var3.setAxisMinimum(0.0F);
      var3.setAxisMaximum(100.0F);
      var1.getAxisRight().setEnabled(false);
      var1.setOnChartGestureListener(new OnChartGestureListener(this) {
         final GraphViewH this$0;

         {
            this.this$0 = var1;
         }

         public void onChartDoubleTapped(MotionEvent var1) {
         }

         public void onChartFling(MotionEvent var1, MotionEvent var2, float var3, float var4) {
         }

         public void onChartGestureEnd(MotionEvent var1, ChartTouchListener.ChartGesture var2) {
            this.this$0.highlightCenterEntry();
         }

         public void onChartGestureStart(MotionEvent var1, ChartTouchListener.ChartGesture var2) {
            this.this$0.scrollIndicatorPreviousDx = 0.0F;
         }

         public void onChartLongPressed(MotionEvent var1) {
         }

         public void onChartScale(MotionEvent var1, float var2, float var3) {
         }

         public void onChartSingleTapped(MotionEvent var1) {
         }

         public void onChartTranslate(MotionEvent var1, float var2, float var3) {
            var3 = Math.abs(var2);
            float var4 = Math.abs(this.this$0.scrollIndicatorPreviousDx);
            byte var5;
            if (var2 < 0.0F) {
               var5 = -1;
            } else {
               var5 = 1;
            }

            var3 = (var3 - var4) * (float)var5;
            this.this$0.scrollIndicatorPreviousDx = var2;
            GraphViewH var6 = this.this$0;
            var6.setScrollIndicatorPosition(var6.scrollIndicatorPosition + var3 / this.this$0.chart.getScaleX());
            if (Math.abs(var3) > 1.0F) {
               this.this$0.highlightCenterEntry();
            }

         }
      });
   }

   private final void setupXAxisLines() {
      this.chart.getXAxis().removeAllLimitLines();
      Job var1 = this.xAxisLineJob;
      this.xAxisLineJob = BuildersKt.launch$default(this.scope, (CoroutineContext)null, (CoroutineStart)null, new Function2(var1, this, (Continuation)null) {
         final Job $previousJob;
         long J$0;
         long J$1;
         long J$2;
         Object L$0;
         int label;
         final GraphViewH this$0;

         {
            this.$previousJob = var1;
            this.this$0 = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$previousJob, this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var13;
            label58: {
               var13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     if (var2 != 2) {
                        if (var2 != 3) {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        List var22 = (List)this.L$0;
                        ResultKt.throwOnFailure(var1);
                        return Unit.INSTANCE;
                     }

                     ResultKt.throwOnFailure(var1);
                     break label58;
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  Job var17 = this.$previousJob;
                  if (var17 != null) {
                     Continuation var14 = (Continuation)this;
                     this.label = 1;
                     if (JobKt.cancelAndJoin(var17, var14) == var13) {
                        return var13;
                     }
                  }
               }

               CoroutineContext var23 = (CoroutineContext)Dispatchers.getMain();
               Function2 var18 = new Function2(this.this$0, (Continuation)null) {
                  int label;
                  final GraphViewH this$0;

                  {
                     this.this$0 = var1;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.this$0, var2));
                  }

                  public final Object invoke(CoroutineScope var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label == 0) {
                        ResultKt.throwOnFailure(var1);
                        this.this$0.chart.getXAxis().removeAllLimitLines();
                        this.this$0.chart.invalidate();
                        return Unit.INSTANCE;
                     } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }
                  }
               };
               Continuation var15 = (Continuation)this;
               this.label = 2;
               if (BuildersKt.withContext(var23, var18, var15) == var13) {
                  return var13;
               }
            }

            if (this.this$0.zeroTime <= 0L) {
               return Unit.INSTANCE;
            } else {
               List var19 = (List)(new ArrayList());
               ChartTimeScale var24 = this.this$0.getTimeScale();
               int var20 = null.WhenMappings.$EnumSwitchMapping$0[var24.ordinal()];
               long var3;
               if (var20 != 1) {
                  if (var20 != 2) {
                     if (var20 != 3) {
                        throw new NoWhenBranchMatchedException();
                     }

                     var3 = 3600000L;
                  } else {
                     var3 = 259200000L;
                  }
               } else {
                  var3 = 864000000L;
               }

               long var5 = this.this$0.rawEndTime;
               long var9 = this.this$0.rawEndTime;
               long var11 = (long)3600000;
               long var7 = this.this$0.zeroTime - 2592000000L;

               for(var5 -= var9 % var11; var5 >= var7; var5 -= var3) {
                  GraphUtils var25 = GraphUtils.INSTANCE;
                  Context var29 = this.this$0.getContext();
                  Intrinsics.checkNotNullExpressionValue(var29, "getContext(...)");
                  String var26 = GraphUtils.getStringDate$default(var25, var5, var29, false, 4, (Object)null);
                  LimitLine var27 = new LimitLine((float)((var5 - this.this$0.zeroTime) / (long)5000), var26);
                  GraphViewH var30 = this.this$0;
                  var27.setLineWidth(1.3F);
                  var27.setLabelPosition(LimitLabelPosition.RIGHT_BOTTOM);
                  var27.setTextColor(ContextCompat.getColor(var30.getContext(), GraphViewH.DIVIDER_TEXT_COLOR));
                  var27.setLineColor(ContextCompat.getColor(var30.getContext(), GraphViewH.DIVIDER_LINE_COLOR));
                  var27.setTextSize(10.0F);
                  var27.setXOffset(5.0F);
                  var27.setYOffset(5.0F);
                  var19.add(var27);
               }

               CoroutineContext var31 = (CoroutineContext)Dispatchers.getMain();
               Function2 var28 = new Function2(var19, this.this$0, (Continuation)null) {
                  final List $lines;
                  int label;
                  final GraphViewH this$0;

                  {
                     this.$lines = var1;
                     this.this$0 = var2;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.$lines, this.this$0, var2));
                  }

                  public final Object invoke(CoroutineScope var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     } else {
                        ResultKt.throwOnFailure(var1);
                        Iterable var2 = (Iterable)this.$lines;
                        GraphViewH var4 = this.this$0;

                        for(LimitLine var3 : var2) {
                           var4.chart.getXAxis().addLimitLine(var3);
                        }

                        this.this$0.chart.invalidate();
                        return Unit.INSTANCE;
                     }
                  }
               };
               Continuation var16 = (Continuation)this;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var19);
               this.J$0 = var3;
               this.J$1 = var5;
               this.J$2 = var7;
               this.label = 3;
               if (BuildersKt.withContext(var31, var28, var16) == var13) {
                  return var13;
               } else {
                  return Unit.INSTANCE;
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
               int[] var0 = new int[ChartTimeScale.values().length];

               try {
                  var0[ChartTimeScale.MONTH.ordinal()] = 1;
               } catch (NoSuchFieldError var4) {
               }

               try {
                  var0[ChartTimeScale.WEEK.ordinal()] = 2;
               } catch (NoSuchFieldError var3) {
               }

               try {
                  var0[ChartTimeScale.DAY.ordinal()] = 3;
               } catch (NoSuchFieldError var2) {
               }

               $EnumSwitchMapping$0 = var0;
            }
         }
      }, 3, (Object)null);
   }

   private final void updateScrollIndicatorPosition(int var1) {
      int var4 = this.scrollIndicatorTrack.getWidth();
      float var3 = RangesKt.coerceIn(1.0F - this.scrollIndicatorPosition / (float)this.chart.getWidth(), 0.0F, 1.0F);
      float var2 = (float)(var4 - var1);
      this.scrollIndicator.setX(var3 * var2);
   }

   // $FF: synthetic method
   static void updateScrollIndicatorPosition$default(GraphViewH var0, int var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.scrollIndicator.getWidth();
      }

      var0.updateScrollIndicatorPosition(var1);
   }

   private final void updateScrollIndicatorWidth(float var1) {
      var1 = RangesKt.coerceAtLeast(11.0F - var1, 1.0F) / 11.0F * (float)this.scrollIndicatorTrack.getWidth();
      this.scrollIndicator.getLayoutParams().width = MathKt.roundToInt(var1);
      this.scrollIndicator.requestLayout();
      this.updateScrollIndicatorPosition(MathKt.roundToInt(var1));
   }

   public final DataType getDataType() {
      return this.dataType;
   }

   public final SimpleDatapoint getHighlightedPoint() {
      return this.highlightedPoint;
   }

   public final ChartTimeScale getTimeScale() {
      return this.timeScale;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.setupChart();
      this.showProgress(true);
   }

   protected void onDetachedFromWindow() {
      this.chart.setOnChartGestureListener((OnChartGestureListener)null);
      CoroutineScopeKt.cancel$default(this.scope, (CancellationException)null, 1, (Object)null);
      super.onDetachedFromWindow();
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      this.chart.getViewPortHandler().setDragOffsetX(Utils.convertPixelsToDp((float)this.chart.getWidth() / 2.0F));
   }

   public final boolean setDataType(DataType var1) {
      Intrinsics.checkNotNullParameter(var1, "type");
      if (Intrinsics.areEqual(this.dataType, var1)) {
         return false;
      } else {
         this.dataType = var1;
         this.graphLineGradient = this.getGradient(var1);
         boolean var2 = var1 instanceof DataType.HUM;
         if (var2) {
            View var3 = this.binding.dividerH5;
            Intrinsics.checkNotNullExpressionValue(var3, "dividerH5");
            ViewExtensionsKt.show$default(var3, false, 1, (Object)null);
         } else if (var1 instanceof DataType.TMP) {
            View var4 = this.binding.dividerH5;
            Intrinsics.checkNotNullExpressionValue(var4, "dividerH5");
            ViewExtensionsKt.show$default(var4, false, 1, (Object)null);
            if (((DataType.TMP)var1).isCelsius()) {
               GraphHBinding var5 = this.binding;
               var5.labelYTmp2.setText((CharSequence)"40℃");
               var5.labelYTmp3.setText((CharSequence)"30℃");
               var5.labelYTmp4.setText((CharSequence)"20℃");
               var5.labelYTmp5.setText((CharSequence)"10℃");
               var5.labelYTmp6.setText((CharSequence)"0℃");
            } else {
               GraphHBinding var6 = this.binding;
               var6.labelYTmp2.setText((CharSequence)"104℉");
               var6.labelYTmp3.setText((CharSequence)"86℉");
               var6.labelYTmp4.setText((CharSequence)"68℉");
               var6.labelYTmp5.setText((CharSequence)"50℉");
               var6.labelYTmp6.setText((CharSequence)"32℉");
            }
         } else {
            if (!(var1 instanceof DataType.AQI)) {
               throw new NoWhenBranchMatchedException();
            }

            View var7 = this.binding.dividerH5;
            Intrinsics.checkNotNullExpressionValue(var7, "dividerH5");
            ViewExtensionsKt.hide(var7);
         }

         Group var8 = this.binding.groupHum;
         Intrinsics.checkNotNullExpressionValue(var8, "groupHum");
         ViewExtensionsKt.show((View)var8, var2);
         var8 = this.binding.groupTmp;
         Intrinsics.checkNotNullExpressionValue(var8, "groupTmp");
         ViewExtensionsKt.show((View)var8, var1 instanceof DataType.TMP);
         var8 = this.binding.groupAqi;
         Intrinsics.checkNotNullExpressionValue(var8, "groupAqi");
         ViewExtensionsKt.show((View)var8, var1 instanceof DataType.AQI);
         return true;
      }
   }

   public final void setOnDatapointSelectedListener(Function1 var1) {
      Intrinsics.checkNotNullParameter(var1, "onDatapointSelectedListener");
      this.onDatapointSelectedListener = var1;
   }

   public final void setOnTimeScaleChangedListener(Function1 var1) {
      Intrinsics.checkNotNullParameter(var1, "onTimeScaleChangedListener");
      this.onTimeScaleChangedListener = var1;
   }

   public final void setTimeScale(ChartTimeScale var1) {
      Intrinsics.checkNotNullParameter(var1, "scale");
      int var2 = GraphViewH.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
      if (var2 != 1) {
         if (var2 != 2) {
            if (var2 != 3) {
               throw new NoWhenBranchMatchedException();
            }

            var2 = com.blueair.graph.R.id.rb_month;
         } else {
            var2 = com.blueair.graph.R.id.rb_week;
         }
      } else {
         var2 = com.blueair.graph.R.id.rb_day;
      }

      if (this.binding.radioGroupTimeScale.getCheckedRadioButtonId() == var2) {
         notifyChartScaleChanged$default(this, var1, (Entry)null, 2, (Object)null);
      } else {
         this.binding.radioGroupTimeScale.check(var2);
      }
   }

   public final void setTitle(String var1, View.OnClickListener var2) {
      if (var1 == null) {
         FrameLayout var4 = this.binding.graphTitleContainer;
         Intrinsics.checkNotNullExpressionValue(var4, "graphTitleContainer");
         ViewExtensionsKt.hide((View)var4);
      } else {
         FrameLayout var3 = this.binding.graphTitleContainer;
         Intrinsics.checkNotNullExpressionValue(var3, "graphTitleContainer");
         ViewExtensionsKt.show$default((View)var3, false, 1, (Object)null);
         this.binding.graphTitle.setText((CharSequence)var1);
         if (var2 != null) {
            this.binding.graphTitle.setOnClickListener(var2);
         }

      }
   }

   public final void showProgress(boolean var1) {
      ProgressBlockerView var2 = this.binding.progressView;
      Intrinsics.checkNotNullExpressionValue(var2, "progressView");
      ViewExtensionsKt.show((View)var2, var1);
   }

   public final void updateHistoricalData(List var1) {
      Intrinsics.checkNotNullParameter(var1, "data");
      this.setData(var1, false);
   }

   public final void updateRealTimeData(List var1) {
      Intrinsics.checkNotNullParameter(var1, "data");
      this.setData(var1, true);
   }

   @Metadata(
      d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015*\b\u0012\u0004\u0012\u00020\u00170\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0007H\u0002J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"},
      d2 = {"Lcom/blueair/graph/view/GraphViewH$Companion;", "", "<init>", "()V", "X_FACTOR", "", "ONE_DAY_IN_MILLS", "", "ONE_WEEK_IN_MILLS", "ONE_MONTH_IN_MILLS", "ONE_DAY_IN_X", "", "ONE_WEEK_IN_X", "ONE_MONTH_IN_X", "BLOCK_COUNT", "SCALE_MONTH", "SCALE_WEEK", "SCALE_DAY", "DIVIDER_TEXT_COLOR", "DIVIDER_LINE_COLOR", "convertToEntries", "", "Lcom/github/mikephil/charting/data/Entry;", "Lcom/blueair/core/model/SimpleDatapoint;", "type", "Lcom/blueair/graph/view/GraphViewH$DataType;", "zeroTime", "getLegendColor", "value", "graph_otherRelease"},
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

      private final List convertToEntries(List var1, DataType var2, long var3) {
         if (var2 instanceof DataType.HUM) {
            Iterable var15 = (Iterable)var1;
            Collection var13 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var15, 10)));

            for(SimpleDatapoint var28 : var15) {
               float var21;
               if (var28.getValue() <= 10.0F) {
                  var21 = var28.getValue() * (float)5 / (float)3;
               } else if (var28.getValue() <= 70.0F) {
                  var21 = var28.getValue();
                  float var23 = (float)10;
                  var21 = (var21 - var23) * var23 / (float)9 + 16.666666F;
               } else {
                  var21 = (var28.getValue() - (float)70) * (float)5 / (float)9 + 83.333336F;
               }

               var13.add(new Entry(convertToEntries$getX(var3, var28), var21, var28));
            }

            return (List)var13;
         } else if (var2 instanceof DataType.TMP) {
            Iterable var26 = (Iterable)var1;
            Collection var12 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var26, 10)));

            for(SimpleDatapoint var27 : var26) {
               float var20;
               label65: {
                  short var24;
                  label64: {
                     float var6;
                     label63: {
                        if (((DataType.TMP)var2).isCelsius()) {
                           if (var27.getValue() <= 0.0F) {
                              var20 = (var27.getValue() + (float)40) * (float)5;
                              var24 = 12;
                              break label64;
                           }

                           if (var27.getValue() <= 40.0F) {
                              var20 = var27.getValue() * (float)5;
                              var6 = (float)3;
                              break label63;
                           }

                           var20 = (var27.getValue() - (float)40) * (float)5;
                           var24 = 18;
                        } else {
                           var20 = DeviceData.Companion.convertCelsiusToFahrenheit(var27.getValue());
                           if (var20 <= 32.0F) {
                              var20 = (var20 + (float)40) * (float)25;
                              var24 = 108;
                              break label64;
                           }

                           if (var20 <= 104.0F) {
                              var20 = (var20 - (float)32) * (float)25;
                              var6 = (float)27;
                              break label63;
                           }

                           var20 = (var20 - (float)104) * (float)25;
                           var24 = 162;
                        }

                        var20 = var20 / (float)var24 + 83.333336F;
                        break label65;
                     }

                     var20 = var20 / var6 + 16.666666F;
                     break label65;
                  }

                  var20 /= (float)var24;
               }

               var12.add(new Entry(convertToEntries$getX(var3, var27), var20, var27));
            }

            return (List)var12;
         } else if (!(var2 instanceof DataType.AQI)) {
            throw new NoWhenBranchMatchedException();
         } else {
            IndoorAirRatingRanges var8 = IndoorAirRatingRanges.Companion.instance(((DataType)var2).getDevice());
            var2 = var2;
            double[] var25 = var8.airRatingsFor(var2.getSensorType());
            Iterable var9 = (Iterable)var1;
            Collection var11 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var9, 10)));

            for(SimpleDatapoint var29 : var9) {
               var11.add(new Entry(convertToEntries$getX(var3, var29), (float)MpChartUtils.getScaledValueForChart$default(MpChartUtils.INSTANCE, var29.getValue(), var2.getSensorType(), var25, false, 8, (Object)null), var29));
            }

            return (List)var11;
         }
      }

      // $FF: synthetic method
      static List convertToEntries$default(Companion var0, List var1, DataType var2, long var3, int var5, Object var6) {
         if ((var5 & 2) != 0) {
            var3 = ((SimpleDatapoint)CollectionsKt.last(var1)).getTimeInMillis();
         }

         return var0.convertToEntries(var1, var2, var3);
      }

      private static final float convertToEntries$getX(long var0, SimpleDatapoint var2) {
         return (float)((var2.getTimeInMillis() - var0) / (long)5000);
      }

      private final int getLegendColor(DataType var1, float var2) {
         if (var1 instanceof DataType.HUM) {
            if (var2 < 38.88889F) {
               return R.color.color_vpolluted;
            } else {
               return var2 <= 61.11111F ? R.color.color_good : R.color.color_moderate;
            }
         } else if (var1 instanceof DataType.TMP) {
            return R.color.colorPrimary;
         } else if (var1 instanceof DataType.AQI) {
            IndoorAirRatingRanges var4 = IndoorAirRatingRanges.Companion.instance(((DataType)var1).getDevice());
            MpChartUtils var3 = MpChartUtils.INSTANCE;
            var1 = var1;
            IndoorAirRatingRanges.IndoorAirRating var6 = var4.rating(var3.getRealValueFromScaledChartValue(var2, var1.getSensorType(), true, var4.airRatingsFor(var1.getSensorType())), var1.getSensorType());
            if (Intrinsics.areEqual(var6, IndoorAirRatingRanges.IndoorAirRating.VERY_POLLUTED.INSTANCE)) {
               return R.color.color_vpolluted;
            } else if (Intrinsics.areEqual(var6, IndoorAirRatingRanges.IndoorAirRating.POLLUTED.INSTANCE)) {
               return R.color.color_polluted;
            } else if (Intrinsics.areEqual(var6, IndoorAirRatingRanges.IndoorAirRating.MODERATE.INSTANCE)) {
               return R.color.color_moderate;
            } else if (Intrinsics.areEqual(var6, IndoorAirRatingRanges.IndoorAirRating.GOOD.INSTANCE)) {
               return R.color.color_good;
            } else if (Intrinsics.areEqual(var6, IndoorAirRatingRanges.IndoorAirRating.EXCELLENT.INSTANCE)) {
               return R.color.color_excellent;
            } else if (var6 == null) {
               return R.color.colorPrimary;
            } else {
               throw new NoWhenBranchMatchedException();
            }
         } else {
            throw new NoWhenBranchMatchedException();
         }
      }
   }

   @Metadata(
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u0010\u0011\u0012¨\u0006\u0013"},
      d2 = {"Lcom/blueair/graph/view/GraphViewH$DataType;", "", "device", "Lcom/blueair/core/model/HasSensorData;", "<init>", "(Lcom/blueair/core/model/HasSensorData;)V", "getDevice", "()Lcom/blueair/core/model/HasSensorData;", "toSensorType", "Lcom/blueair/core/model/SensorType;", "equals", "", "other", "HUM", "TMP", "AQI", "Lcom/blueair/graph/view/GraphViewH$DataType$AQI;", "Lcom/blueair/graph/view/GraphViewH$DataType$HUM;", "Lcom/blueair/graph/view/GraphViewH$DataType$TMP;", "graph_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public abstract static class DataType {
      private final HasSensorData device;

      private DataType(HasSensorData var1) {
         this.device = var1;
      }

      // $FF: synthetic method
      public DataType(HasSensorData var1, DefaultConstructorMarker var2) {
         this(var1);
      }

      public boolean equals(Object var1) {
         if (var1 instanceof HUM) {
            return this instanceof HUM;
         } else if (var1 instanceof TMP) {
            return this instanceof TMP && ((TMP)this).isCelsius() == ((TMP)var1).isCelsius();
         } else {
            return var1 instanceof AQI && this instanceof AQI && ((AQI)this).getSensorType() == ((AQI)var1).getSensorType();
         }
      }

      public final HasSensorData getDevice() {
         return this.device;
      }

      public final SensorType toSensorType() {
         if (this instanceof HUM) {
            return SensorType.HUM;
         } else if (this instanceof TMP) {
            return SensorType.TMP;
         } else if (this instanceof AQI) {
            return ((AQI)this).getSensorType();
         } else {
            throw new NoWhenBranchMatchedException();
         }
      }

      @Metadata(
         d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"},
         d2 = {"Lcom/blueair/graph/view/GraphViewH$DataType$AQI;", "Lcom/blueair/graph/view/GraphViewH$DataType;", "device", "Lcom/blueair/core/model/HasSensorData;", "sensorType", "Lcom/blueair/core/model/SensorType;", "<init>", "(Lcom/blueair/core/model/HasSensorData;Lcom/blueair/core/model/SensorType;)V", "getSensorType", "()Lcom/blueair/core/model/SensorType;", "graph_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class AQI extends DataType {
         private final SensorType sensorType;

         public AQI(HasSensorData var1, SensorType var2) {
            Intrinsics.checkNotNullParameter(var1, "device");
            Intrinsics.checkNotNullParameter(var2, "sensorType");
            super(var1, (DefaultConstructorMarker)null);
            this.sensorType = var2;
         }

         public final SensorType getSensorType() {
            return this.sensorType;
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/graph/view/GraphViewH$DataType$HUM;", "Lcom/blueair/graph/view/GraphViewH$DataType;", "device", "Lcom/blueair/core/model/HasSensorData;", "<init>", "(Lcom/blueair/core/model/HasSensorData;)V", "graph_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class HUM extends DataType {
         public HUM(HasSensorData var1) {
            Intrinsics.checkNotNullParameter(var1, "device");
            super(var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\b¨\u0006\t"},
         d2 = {"Lcom/blueair/graph/view/GraphViewH$DataType$TMP;", "Lcom/blueair/graph/view/GraphViewH$DataType;", "device", "Lcom/blueair/core/model/HasSensorData;", "isCelsius", "", "<init>", "(Lcom/blueair/core/model/HasSensorData;Z)V", "()Z", "graph_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class TMP extends DataType {
         private final boolean isCelsius;

         public TMP(HasSensorData var1, boolean var2) {
            Intrinsics.checkNotNullParameter(var1, "device");
            super(var1, (DefaultConstructorMarker)null);
            this.isCelsius = var2;
         }

         public final boolean isCelsius() {
            return this.isCelsius;
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
         int[] var0 = new int[ChartTimeScale.values().length];

         try {
            var0[ChartTimeScale.DAY.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[ChartTimeScale.WEEK.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[ChartTimeScale.MONTH.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
