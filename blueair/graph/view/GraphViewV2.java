package com.blueair.graph.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.TypedValueCompat;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.SensorType;
import com.blueair.core.model.SimpleDatapoint;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.graph.databinding.GraphV2Binding;
import com.blueair.graph.utils.ChartTimeScale;
import com.blueair.graph.utils.GraphUtils;
import com.blueair.graph.utils.MpChartUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
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
import java.math.RoundingMode;
import java.text.DecimalFormat;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
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
   d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b!\u0018\u0000 \u0089\u00012\u00020\u0001:\u0004\u0088\u0001\u0089\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0002J\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00020\n0\u001d2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010U\u001a\u00020S2\u0006\u0010V\u001a\u00020\u0013H\u0007J\u001f\u0010W\u001a\u00020>2\u0012\u0010X\u001a\n\u0012\u0006\b\u0001\u0012\u00020Z0Y\"\u00020Z¢\u0006\u0002\u0010[J\u0012\u0010\\\u001a\u00020M*\u00020]2\u0006\u0010^\u001a\u00020MJ\u0018\u0010_\u001a\u00020M2\b\b\u0001\u0010`\u001a\u00020\n2\u0006\u0010^\u001a\u00020MJ\u000e\u0010a\u001a\u00020>2\u0006\u0010b\u001a\u00020*J)\u0010c\u001a\u00020>2!\u0010<\u001a\u001d\u0012\u0013\u0012\u00110*¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(b\u0012\u0004\u0012\u00020>0=J+\u0010d\u001a\u00020>2#\u0010?\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001e¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020>0=J\b\u0010e\u001a\u00020>H\u0014J\b\u0010f\u001a\u00020>H\u0014J\u0010\u0010g\u001a\u00020>2\u0006\u0010h\u001a\u00020iH\u0014J\b\u0010j\u001a\u00020>H\u0002J\u000e\u0010k\u001a\u00020>2\u0006\u0010k\u001a\u00020SJ\u0014\u0010l\u001a\u00020>2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\u0014\u0010n\u001a\u00020>2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\u001e\u0010o\u001a\u00020>2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010p\u001a\u00020SH\u0002J\u0012\u0010q\u001a\u00020>2\b\u0010r\u001a\u0004\u0018\u00010&H\u0002J\u0012\u0010s\u001a\u00020>2\b\u0010r\u001a\u0004\u0018\u00010&H\u0002J\u001c\u0010t\u001a\u00020>2\u0006\u0010b\u001a\u00020*2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010&H\u0002J\u001e\u0010u\u001a\u00020>2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010v\u001a\u00020SH\u0002J\u0012\u0010w\u001a\u0004\u0018\u00010M2\u0006\u0010x\u001a\u00020\u001eH\u0002J\u000e\u0010y\u001a\u00020M2\u0006\u0010\u0012\u001a\u00020$J\b\u0010z\u001a\u00020\nH\u0002J\u0010\u0010{\u001a\u00020>2\u0006\u0010r\u001a\u00020&H\u0002J\b\u0010|\u001a\u00020>H\u0002J\u0012\u0010}\u001a\u00020>2\b\b\u0002\u0010v\u001a\u00020SH\u0002J\u0010\u0010~\u001a\u00020>2\u0006\u0010\u007f\u001a\u00020$H\u0002J\u0014\u0010\u0080\u0001\u001a\u00020>2\t\b\u0002\u0010\u0081\u0001\u001a\u00020\nH\u0002J6\u0010\u0082\u0001\u001a\u00020>2\u0007\u0010\u0083\u0001\u001a\u00020S2\u0007\u0010\u0084\u0001\u001a\u00020\n2\u0007\u0010\u0085\u0001\u001a\u00020\n2\u0007\u0010\u0086\u0001\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u00020\nH\u0014R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b \u0010!R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010'\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020$@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b(\u0010)R$\u0010+\u001a\u00020*2\u0006\u0010\u0012\u001a\u00020*@CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010:\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020$@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b;\u0010)R\u001c\u0010<\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020>\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010?\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001e¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020>\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010C\u001a\u0004\u0018\u00010&2\b\u0010\u0012\u001a\u0004\u0018\u00010&@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bD\u0010ER(\u0010F\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001e@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020\n0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010L\u001a\u00020MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u000e\u0010R\u001a\u00020SX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008a\u0001"},
   d2 = {"Lcom/blueair/graph/view/GraphViewV2;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "xAxisLineJob", "Lkotlinx/coroutines/Job;", "value", "Lcom/blueair/graph/view/GraphViewV2$DataType;", "dataType", "getDataType", "()Lcom/blueair/graph/view/GraphViewV2$DataType;", "df", "Ljava/text/DecimalFormat;", "rawStartTime", "", "rawEndTime", "zeroTime", "", "Lcom/blueair/core/model/SimpleDatapoint;", "rawDatapoint", "setRawDatapoint", "(Ljava/util/List;)V", "getTimestampFromEntryX", "x", "", "entries", "Lcom/github/mikephil/charting/data/Entry;", "maxX", "setMaxX", "(F)V", "Lcom/blueair/graph/utils/ChartTimeScale;", "timeScale", "getTimeScale", "()Lcom/blueair/graph/utils/ChartTimeScale;", "setTimeScaleField", "(Lcom/blueair/graph/utils/ChartTimeScale;)V", "chartScale", "binding", "Lcom/blueair/graph/databinding/GraphV2Binding;", "chart", "Lcom/github/mikephil/charting/charts/LineChart;", "scrollIndicatorTrack", "Landroid/widget/FrameLayout;", "scrollIndicator", "Landroid/view/View;", "scrollIndicatorPreviousDx", "scrollIndicatorPosition", "setScrollIndicatorPosition", "onTimeScaleChangedListener", "Lkotlin/Function1;", "", "onDatapointSelectedListener", "Lkotlin/ParameterName;", "name", "datapoint", "highlightedEntry", "setHighlightedEntry", "(Lcom/github/mikephil/charting/data/Entry;)V", "highlightedPoint", "getHighlightedPoint", "()Lcom/blueair/core/model/SimpleDatapoint;", "setHighlightedPoint", "(Lcom/blueair/core/model/SimpleDatapoint;)V", "graphLineGradient", "sensorName", "", "getSensorName", "()Ljava/lang/String;", "setSensorName", "(Ljava/lang/String;)V", "firstDraw", "", "getGradient", "setDataType", "type", "applyRangeContentDesp", "textViews", "", "Landroid/widget/TextView;", "([Landroid/widget/TextView;)V", "formatRange", "Lcom/blueair/core/model/SensorType;", "range", "concatLegendStr", "stringRes", "setTimeScale", "scale", "setOnTimeScaleChangedListener", "setOnDatapointSelectedListener", "onAttachedToWindow", "onDetachedFromWindow", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "setupChart", "showProgress", "updateHistoricalData", "data", "updateRealTimeData", "setData", "isRealTime", "scaleAndCenter", "entry", "highlightEntry", "notifyChartScaleChanged", "notifyChartDataChanged", "isAppend", "buildContentDesp", "it", "convertRealValue", "getSensorTitle", "setChartMarker", "highlightCenterEntry", "setupXAxisLines", "updateScrollIndicatorWidth", "chartScaleX", "updateScrollIndicatorPosition", "indicatorWidth", "onLayout", "changed", "left", "top", "right", "bottom", "DataType", "Companion", "graph_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GraphViewV2 extends ConstraintLayout {
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
   private final GraphV2Binding binding;
   private final LineChart chart;
   private float chartScale;
   private DataType dataType;
   private final DecimalFormat df;
   private List entries;
   private boolean firstDraw;
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
   private String sensorName;
   private ChartTimeScale timeScale;
   private Job xAxisLineJob;
   private long zeroTime;

   // $FF: synthetic method
   public static void $r8$lambda$IaqmUfoJK4ypRSysHNLRua1taYw(GraphViewV2 var0, Entry var1) {
      highlightEntry$lambda$19(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$TSEduWmwmOuUcnfBF6557Yz445Q(GraphViewV2 var0, Entry var1) {
      highlightEntry$lambda$18(var0, var1);
   }

   // $FF: synthetic method
   public static CharSequence $r8$lambda$kjfmY6EHCcGDqVaBde9Vf6Wt_Wk/* $FF was: $r8$lambda$kjfmY6EHCcGDqVaBde9Vf6Wt-Wk*/(GraphViewV2 var0, String var1) {
      return formatRange$lambda$12(var0, var1);
   }

   static {
      DIVIDER_TEXT_COLOR = R.color.surface_dark_55;
      DIVIDER_LINE_COLOR = R.color.surface_dark_5;
   }

   public GraphViewV2(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1);
      this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus((CoroutineContext)SupervisorKt.SupervisorJob$default((Job)null, 1, (Object)null)));
      DecimalFormat var3 = new DecimalFormat("0.00");
      var3.setRoundingMode(RoundingMode.DOWN);
      this.df = var3;
      this.rawDatapoint = CollectionsKt.emptyList();
      this.entries = CollectionsKt.emptyList();
      this.timeScale = ChartTimeScale.DAY;
      this.chartScale = 240.0F;
      GraphV2Binding var4 = GraphV2Binding.inflate(LayoutInflater.from(this.getContext()), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.binding = var4;
      LineChart var2 = var4.lineChart;
      Intrinsics.checkNotNullExpressionValue(var2, "lineChart");
      this.chart = var2;
      FrameLayout var6 = var4.scrollIndicatorTrack;
      Intrinsics.checkNotNullExpressionValue(var6, "scrollIndicatorTrack");
      this.scrollIndicatorTrack = var6;
      View var5 = var4.scrollIndicator;
      Intrinsics.checkNotNullExpressionValue(var5, "scrollIndicator");
      this.scrollIndicator = var5;
      this.graphLineGradient = CollectionsKt.emptyList();
      this.sensorName = "";
      this.firstDraw = true;
   }

   public GraphViewV2(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2);
      this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus((CoroutineContext)SupervisorKt.SupervisorJob$default((Job)null, 1, (Object)null)));
      DecimalFormat var3 = new DecimalFormat("0.00");
      var3.setRoundingMode(RoundingMode.DOWN);
      this.df = var3;
      this.rawDatapoint = CollectionsKt.emptyList();
      this.entries = CollectionsKt.emptyList();
      this.timeScale = ChartTimeScale.DAY;
      this.chartScale = 240.0F;
      GraphV2Binding var4 = GraphV2Binding.inflate(LayoutInflater.from(this.getContext()), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.binding = var4;
      LineChart var6 = var4.lineChart;
      Intrinsics.checkNotNullExpressionValue(var6, "lineChart");
      this.chart = var6;
      FrameLayout var7 = var4.scrollIndicatorTrack;
      Intrinsics.checkNotNullExpressionValue(var7, "scrollIndicatorTrack");
      this.scrollIndicatorTrack = var7;
      View var5 = var4.scrollIndicator;
      Intrinsics.checkNotNullExpressionValue(var5, "scrollIndicator");
      this.scrollIndicator = var5;
      this.graphLineGradient = CollectionsKt.emptyList();
      this.sensorName = "";
      this.firstDraw = true;
   }

   public GraphViewV2(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
      this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus((CoroutineContext)SupervisorKt.SupervisorJob$default((Job)null, 1, (Object)null)));
      DecimalFormat var4 = new DecimalFormat("0.00");
      var4.setRoundingMode(RoundingMode.DOWN);
      this.df = var4;
      this.rawDatapoint = CollectionsKt.emptyList();
      this.entries = CollectionsKt.emptyList();
      this.timeScale = ChartTimeScale.DAY;
      this.chartScale = 240.0F;
      GraphV2Binding var5 = GraphV2Binding.inflate(LayoutInflater.from(this.getContext()), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
      this.binding = var5;
      LineChart var7 = var5.lineChart;
      Intrinsics.checkNotNullExpressionValue(var7, "lineChart");
      this.chart = var7;
      FrameLayout var8 = var5.scrollIndicatorTrack;
      Intrinsics.checkNotNullExpressionValue(var8, "scrollIndicatorTrack");
      this.scrollIndicatorTrack = var8;
      View var6 = var5.scrollIndicator;
      Intrinsics.checkNotNullExpressionValue(var6, "scrollIndicator");
      this.scrollIndicator = var6;
      this.graphLineGradient = CollectionsKt.emptyList();
      this.sensorName = "";
      this.firstDraw = true;
   }

   public GraphViewV2(Context var1, AttributeSet var2, int var3, int var4) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2, var3);
      this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus((CoroutineContext)SupervisorKt.SupervisorJob$default((Job)null, 1, (Object)null)));
      DecimalFormat var5 = new DecimalFormat("0.00");
      var5.setRoundingMode(RoundingMode.DOWN);
      this.df = var5;
      this.rawDatapoint = CollectionsKt.emptyList();
      this.entries = CollectionsKt.emptyList();
      this.timeScale = ChartTimeScale.DAY;
      this.chartScale = 240.0F;
      GraphV2Binding var6 = GraphV2Binding.inflate(LayoutInflater.from(this.getContext()), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      LineChart var8 = var6.lineChart;
      Intrinsics.checkNotNullExpressionValue(var8, "lineChart");
      this.chart = var8;
      FrameLayout var9 = var6.scrollIndicatorTrack;
      Intrinsics.checkNotNullExpressionValue(var9, "scrollIndicatorTrack");
      this.scrollIndicatorTrack = var9;
      View var7 = var6.scrollIndicator;
      Intrinsics.checkNotNullExpressionValue(var7, "scrollIndicator");
      this.scrollIndicator = var7;
      this.graphLineGradient = CollectionsKt.emptyList();
      this.sensorName = "";
      this.firstDraw = true;
   }

   private final String buildContentDesp(SimpleDatapoint var1) {
      int var2 = this.getSensorTitle();
      DataType var3 = this.dataType;
      String var6;
      if (var3 instanceof DataType.TMP) {
         Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type com.blueair.graph.view.GraphViewV2.DataType.TMP");
         if (((DataType.TMP)var3).isCelsius()) {
            var6 = this.getContext().getString(R.string.temperature_celsius);
         } else {
            var6 = this.getContext().getString(R.string.temperature_fahrenheit);
         }
      } else {
         var6 = "";
      }

      Intrinsics.checkNotNull(var6);
      if (var2 != 0) {
         String var5 = this.getContext().getString(R.string.sensor_graph_summary, new Object[]{this.getContext().getString(var2), this.convertRealValue(var1.getValue())});
         Intrinsics.checkNotNullExpressionValue(var5, "getString(...)");
         StringBuilder var4 = new StringBuilder();
         var4.append(var5);
         var4.append(' ');
         var4.append(var6);
         return var4.toString();
      } else {
         return null;
      }
   }

   private static final CharSequence formatRange$lambda$12(GraphViewV2 var0, String var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      String var2 = var0.df.format(Double.parseDouble(var1) / (double)10000);
      Intrinsics.checkNotNullExpressionValue(var2, "format(...)");
      return (CharSequence)var2;
   }

   private final List getGradient(DataType var1) {
      List var6 = (List)(new ArrayList());
      boolean var5 = var1 instanceof DataType.HUM;
      byte var3 = 0;
      if (var5) {
         int var4 = getGradient$lambda$8$getColor(this, R.color.color_moderate);

         for(int var2 = 0; var2 < 3; ++var2) {
            var6.add(var4);
         }

         var4 = getGradient$lambda$8$getColor(this, R.color.color_good);

         for(int var8 = 0; var8 < 2; ++var8) {
            var6.add(var4);
         }

         var4 = getGradient$lambda$8$getColor(this, R.color.color_vpolluted);

         for(int var9 = var3; var9 < 3; ++var9) {
            var6.add(var4);
         }
      } else {
         if (var1 instanceof DataType.TMP) {
            var6.add(getGradient$lambda$8$getColor(this, R.color.colorPrimary));
            return var6;
         }

         if (!(var1 instanceof DataType.AQI)) {
            throw new NoWhenBranchMatchedException();
         }

         Iterator var7 = ((Iterable)CollectionsKt.listOf(new Integer[]{R.color.color_vpolluted, R.color.color_polluted, R.color.color_moderate, R.color.color_good, R.color.color_excellent})).iterator();

         while(var7.hasNext()) {
            var6.add(getGradient$lambda$8$getColor(this, ((Number)var7.next()).intValue()));
         }
      }

      return var6;
   }

   private static final int getGradient$lambda$8$getColor(GraphViewV2 var0, int var1) {
      return ResourcesCompat.getColor(var0.getResources(), var1, var0.getContext().getTheme());
   }

   private final int getSensorTitle() {
      DataType var3 = this.dataType;
      Object var4 = null;
      HasSensorData var6;
      if (var3 != null) {
         var6 = var3.getDevice();
      } else {
         var6 = null;
      }

      boolean var2 = var6 instanceof DevicePet20;
      DataType var5 = this.dataType;
      SensorType var7 = (SensorType)var4;
      if (var5 != null) {
         var7 = var5.toSensorType();
      }

      int var1;
      if (var7 == null) {
         var1 = -1;
      } else {
         var1 = GraphViewV2.WhenMappings.$EnumSwitchMapping$1[var7.ordinal()];
      }

      switch (var1) {
         case 1:
            if (var2) {
               return R.string.pet_sensor_pm1;
            }

            return R.string.pm1_title_short;
         case 2:
            if (var2) {
               return R.string.pet_sensor_pm25;
            }

            return R.string.pm25_title;
         case 3:
            if (var2) {
               return R.string.pet_sensor_pm10;
            }

            return R.string.pm10_title_short;
         case 4:
            if (var2) {
               return R.string.pet_sensor_tvoc;
            }

            return R.string.voc_title_short;
         case 5:
            return R.string.hcho_title;
         case 6:
            return R.string.humidity_levels;
         case 7:
            return R.string.indoor_temperature;
         case 8:
            return R.string.fan_title;
         default:
            return 0;
      }
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
         double var3 = var7.x;
         double var1 = (var10.x - var7.x) / (double)2;
         this.chart.highlightValue((float)(var3 + var1), 0);
         Highlight[] var8 = this.chart.getHighlighted();
         if (var8 != null && var8.length != 0) {
            Entry var9 = ((ILineDataSet)((LineData)this.chart.getData()).getDataSets().get(0)).getEntryForXValue(var8[0].getX(), var8[0].getY());
            if (var9 == null) {
               return;
            }

            this.setHighlightedEntry(var9);
            this.setChartMarker(var9);
         }

      }
   }

   private final void highlightEntry(Entry var1) {
      if (var1 == null) {
         this.chart.highlightValues((Highlight[])null);
         this.setHighlightedEntry((Entry)null);
      } else {
         this.scaleAndCenter(var1);
         this.chart.highlightValue(var1.getX(), 0);
         this.setHighlightedEntry(var1);
         this.post(new GraphViewV2$$ExternalSyntheticLambda1(this, var1));
         this.postDelayed(new GraphViewV2$$ExternalSyntheticLambda2(this, var1), 300L);
      }
   }

   private static final void highlightEntry$lambda$18(GraphViewV2 var0, Entry var1) {
      var0.setChartMarker(var1);
   }

   private static final void highlightEntry$lambda$19(GraphViewV2 var0, Entry var1) {
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

      DataType var7 = this.dataType;
      if (var7 != null) {
         var5 = null;
         boolean var4;
         if (var2) {
            var4 = var3;
            if (!((Collection)var1).isEmpty()) {
               this.setMaxX(this.maxX + (float)((((SimpleDatapoint)CollectionsKt.last(var1)).getTimeInMillis() - this.rawEndTime) / (long)5000));
               this.setRawDatapoint(CollectionsKt.plus((Collection)this.rawDatapoint, (Iterable)var1));
               Iterable var22 = (Iterable)Companion.convertToEntries(var1, var7, this.zeroTime);

               for(Entry var15 : var22) {
                  ((LineData)this.chart.getData()).addEntry(var15, 0);
               }

               this.entries = CollectionsKt.plus((Collection)this.entries, var22);
               this.setupXAxisLines(true);
               this.chart.notifyDataSetChanged();
               var4 = var3;
            }
         } else {
            this.setRawDatapoint(var1);
            if (var1.isEmpty()) {
               this.entries = CollectionsKt.emptyList();
            } else {
               this.entries = Companion.convertToEntries(var1, var7, this.zeroTime);
               LineDataSet var10 = new LineDataSet(this.entries, "");
               var10.setMode(Mode.HORIZONTAL_BEZIER);
               var10.setLineWidth(4.0F);
               var10.setColors(this.graphLineGradient);
               var10.setDrawValues(false);
               var10.setDrawCircles(false);
               var10.setDrawHighlightIndicators(false);
               var10.setDrawEndMarker(true);
               this.chart.setData((ChartData)(new LineData(new ILineDataSet[]{var10})));
               SimpleDatapoint var8 = this.highlightedPoint;
               Entry var14;
               if (var8 == null) {
                  var14 = null;
               } else {
                  Iterator var9 = ((Iterable)this.entries).iterator();

                  while(true) {
                     if (var9.hasNext()) {
                        Object var6 = var9.next();
                        Object var12 = ((Entry)var6).getData();
                        SimpleDatapoint var13;
                        if (var12 instanceof SimpleDatapoint) {
                           var13 = (SimpleDatapoint)var12;
                        } else {
                           var13 = null;
                        }

                        if (var13 == null || var13.getTimeInSeconds() != var8.getTimeInSeconds()) {
                           continue;
                        }

                        var11 = var6;
                        break;
                     }

                     var11 = null;
                     break;
                  }

                  var14 = (Entry)var11;
               }

               this.notifyChartScaleChanged(this.timeScale, var14);
               var3 = false;
            }

            this.setMaxX(0.0F);
            var4 = var3;
         }

         if (this.entries.isEmpty()) {
            this.showProgress(true);
            this.chart.clear();
            this.setScrollIndicatorPosition(0.0F);
            this.setHighlightedEntry((Entry)null);
         } else {
            IMarker var16 = this.chart.getEndMarker();
            MarkerView var17;
            if (var16 instanceof MarkerView) {
               var17 = (MarkerView)var16;
            } else {
               var17 = null;
            }

            if (var17 != null) {
               ImageView var18 = (ImageView)var17.findViewById(com.blueair.graph.R.id.marker_dot);
               if (var18 != null) {
                  var18.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this.getContext(), Companion.getLegendColor(var7, ((Entry)CollectionsKt.last(this.entries)).getY()))));
               }
            }

            this.showProgress(false);
            this.chart.invalidate();
         }

         if (var4) {
            this.highlightEntry((Entry)CollectionsKt.lastOrNull(this.entries));
         }

         Entry var19 = (Entry)CollectionsKt.lastOrNull(this.entries);
         Object var20;
         if (var19 != null) {
            var20 = var19.getData();
         } else {
            var20 = null;
         }

         if (var20 instanceof SimpleDatapoint) {
            var5 = (SimpleDatapoint)var20;
         }

         if (var5 != null) {
            this.chart.setContentDescription((CharSequence)this.buildContentDesp(var5));
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
      setupXAxisLines$default(this, false, 1, (Object)null);
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
   static void notifyChartScaleChanged$default(GraphViewV2 var0, ChartTimeScale var1, Entry var2, int var3, Object var4) {
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
      SimpleDatapoint var9 = (SimpleDatapoint)var1.getData();
      boolean var6 = var9 instanceof SimpleDatapoint;
      Object var11 = null;
      if (var6) {
         var9 = var9;
      } else {
         var9 = null;
      }

      MarkerView var13 = new MarkerView(this.getContext(), com.blueair.graph.R.layout.markerview_label);
      TextView var14 = (TextView)var13.findViewById(com.blueair.graph.R.id.marker_text);
      View var10 = var13.findViewById(com.blueair.graph.R.id.dashed_line);
      MPPointD var15 = this.chart.getPixelForValues(var1.getX(), var1.getY(), AxisDependency.LEFT);
      float var3 = this.getResources().getDimension(R.dimen.chart_marker_dot_offset);
      float var2 = this.getResources().getDimension(R.dimen.chart_marker_text_offset);
      Intrinsics.checkNotNull(var10);
      ViewGroup.LayoutParams var16 = var10.getLayoutParams();
      if (var16 != null) {
         var16.height = MathKt.roundToInt(this.chart.getViewPortHandler().contentHeight());
         var10.setLayoutParams(var16);
         int var4;
         if (var9 != null) {
            var4 = MathKt.roundToInt(var9.getValue());
         } else {
            var4 = 0;
         }

         int var5;
         label66: {
            DataType var17 = this.dataType;
            if (var17 instanceof DataType.TMP) {
               DataType.TMP var18;
               if (var17 instanceof DataType.TMP) {
                  var18 = (DataType.TMP)var17;
               } else {
                  var18 = null;
               }

               if (var18 == null || !var18.isCelsius()) {
                  var5 = DeviceData.Companion.convertCelsiusToFahrenheit(var4);
                  break label66;
               }
            }

            var5 = var4;
         }

         String var12 = String.valueOf(var5);
         String var26 = var12;
         if (var4 != 0) {
            DataType var19 = this.dataType;
            SensorType var20;
            if (var19 != null) {
               var20 = var19.toSensorType();
            } else {
               var20 = null;
            }

            var26 = var12;
            if (var20 == SensorType.HCHO) {
               var26 = this.df.format((double)var4 / (double)10000);
               Intrinsics.checkNotNullExpressionValue(var26, "format(...)");
            }
         }

         DataType var29 = this.dataType;
         String var21;
         if (var29 instanceof DataType.HUM) {
            var21 = "%";
         } else if (var29 instanceof DataType.TMP) {
            DataType.TMP var22 = (DataType.TMP)var11;
            if (var29 instanceof DataType.TMP) {
               var22 = (DataType.TMP)var29;
            }

            if (var22 != null && !var22.isCelsius()) {
               var21 = "℉";
            } else {
               var21 = "℃";
            }
         } else {
            var21 = "";
         }

         StringBuilder var28 = new StringBuilder();
         var28.append(var26);
         var28.append(var21);
         var14.setText((CharSequence)var28.toString());
         var14.setTranslationY((float)var15.y - var2 - var3);
         var13.setOffset(-var3, -((float)var15.y));
         this.chart.setMarker((IMarker)var13);
         if (var9 != null) {
            TextView var23 = this.binding.timeLabel;
            GraphUtils var27 = GraphUtils.INSTANCE;
            long var7 = var9.getTimeInMillis();
            Context var25 = this.getContext();
            Intrinsics.checkNotNullExpressionValue(var25, "getContext(...)");
            var23.setText((CharSequence)var27.getStringDate(var7, var25, true));
         }

      } else {
         throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      }
   }

   private final void setData(List var1, boolean var2) {
      Timber.Forest var7 = Timber.Forest;
      StringBuilder var8 = new StringBuilder("setData: ");
      var8.append(var1.size());
      var8.append(", ");
      var8.append(var2);
      String var13 = var8.toString();
      boolean var4 = false;
      var7.d(var13, new Object[0]);
      List var10 = var1;
      if (var2) {
         var10 = var1;
         if (!((Collection)var1).isEmpty()) {
            long var5 = this.rawEndTime / 1000L;
            Iterable var11 = (Iterable)var1;
            Collection var9 = (Collection)(new ArrayList());

            for(Object var12 : var11) {
               if (((SimpleDatapoint)var12).getTimeInSeconds() > var5) {
                  var9.add(var12);
               }
            }

            var10 = (List)var9;
         }
      }

      boolean var3 = var4;
      if (var2) {
         var3 = var4;
         if (!((Collection)this.rawDatapoint).isEmpty()) {
            var3 = true;
         }
      }

      this.notifyChartDataChanged(var10, var3);
   }

   private final void setHighlightedEntry(Entry var1) {
      if (!Intrinsics.areEqual(this.highlightedEntry, var1)) {
         this.highlightedEntry = var1;
         SimpleDatapoint var2 = null;
         Object var3;
         if (var1 != null) {
            var3 = var1.getData();
         } else {
            var3 = null;
         }

         if (var3 instanceof SimpleDatapoint) {
            var2 = (SimpleDatapoint)var3;
         }

         this.setHighlightedPoint(var2);
      }
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
         long var4 = ((SimpleDatapoint)CollectionsKt.first(var1)).getTimeInMillis();
         long var2 = ((SimpleDatapoint)CollectionsKt.last(var1)).getTimeInMillis();
         if (this.rawStartTime != var4) {
            this.zeroTime = var2;
         }

         this.rawStartTime = var4;
         this.rawEndTime = var2;
      }
   }

   private final void setScrollIndicatorPosition(float var1) {
      this.scrollIndicatorPosition = var1;
      updateScrollIndicatorPosition$default(this, 0, 1, (Object)null);
   }

   private final void setTimeScaleField(ChartTimeScale var1) {
      this.timeScale = var1;
      int var3 = GraphViewV2.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
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
      LineChart var2 = this.chart;
      float var1 = TypedValueCompat.dpToPx(1.0F, var2.getResources().getDisplayMetrics());
      var2.setViewPortOffsets(0.0F, (float)40 * var1, 0.0F, (float)12 * var1);
      var2.setDrawGridBackground(false);
      var2.getDescription().setEnabled(false);
      var2.getLegend().setEnabled(false);
      var2.setTouchEnabled(true);
      var2.setDragDecelerationEnabled(true);
      var2.setDragEnabled(true);
      var2.setDragXEnabled(true);
      var2.setDragYEnabled(false);
      var2.setPinchZoom(true);
      var2.setDoubleTapToZoomEnabled(false);
      var2.setScaleEnabled(false);
      var2.setScaleXEnabled(false);
      var2.setScaleYEnabled(false);
      var2.setAutoScaleMinMaxEnabled(false);
      var2.setNoDataText("");
      var2.setClipValuesToContent(true);
      var2.setDragDecelerationFrictionCoef(0.85F);
      var2.setDrawMarkers(true);
      MarkerView var3 = new MarkerView(var2.getContext(), com.blueair.graph.R.layout.markerview_dot_v2);
      var1 = -var3.getResources().getDimension(R.dimen.chart_marker_dot_offset);
      var3.setOffset(var1, var1);
      var2.setEndMarker((IMarker)var3);
      XAxis var7 = var2.getXAxis();
      var7.setAxisMinimum(-518400.0F);
      var7.setPosition(XAxisPosition.BOTTOM);
      var7.setDrawGridLines(false);
      var7.setDrawAxisLine(false);
      var7.setDrawLimitLinesBehindData(true);
      var7.setDrawLabels(false);
      var7.setGranularity(1.0F);
      YAxis var8 = var2.getAxisLeft();
      var8.setDrawGridLines(false);
      var8.setDrawAxisLine(false);
      var8.setDrawLimitLinesBehindData(true);
      var8.setDrawLabels(false);
      var8.setSpaceTop(0.0F);
      var8.setSpaceBottom(0.0F);
      var8.setAxisMinimum(0.0F);
      var8.setAxisMaximum(100.0F);
      var2.getAxisRight().setEnabled(false);
      var2.setOnChartGestureListener(new OnChartGestureListener(this) {
         final GraphViewV2 this$0;

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
            float var4 = Math.abs(var2);
            var3 = Math.abs(this.this$0.scrollIndicatorPreviousDx);
            byte var5;
            if (var2 < 0.0F) {
               var5 = -1;
            } else {
               var5 = 1;
            }

            var3 = (var4 - var3) * (float)var5;
            this.this$0.scrollIndicatorPreviousDx = var2;
            GraphViewV2 var6 = this.this$0;
            var6.setScrollIndicatorPosition(var6.scrollIndicatorPosition + var3 / this.this$0.chart.getScaleX());
            if (Math.abs(var3) > 1.0F) {
               this.this$0.highlightCenterEntry();
            }

         }
      });
      ViewUtils var5 = ViewUtils.INSTANCE;
      ConstraintLayout var9 = this.binding.clLegendAqi;
      Intrinsics.checkNotNullExpressionValue(var9, "clLegendAqi");
      ViewUtils.setAccessibilityDelegate$default(var5, (View)var9, Reflection.getOrCreateKotlinClass(ListView.class), (String)null, (Function2)null, 12, (Object)null);
      ViewUtils var10 = ViewUtils.INSTANCE;
      ConstraintLayout var6 = this.binding.clLegendHum;
      Intrinsics.checkNotNullExpressionValue(var6, "clLegendHum");
      ViewUtils.setAccessibilityDelegate$default(var10, (View)var6, Reflection.getOrCreateKotlinClass(ListView.class), (String)null, (Function2)null, 12, (Object)null);
   }

   private final void setupXAxisLines(boolean var1) {
      if (!this.firstDraw) {
         Job var2 = this.xAxisLineJob;
         this.xAxisLineJob = BuildersKt.launch$default(this.scope, (CoroutineContext)null, (CoroutineStart)null, new Function2(var2, var1, this, (Continuation)null) {
            final boolean $isAppend;
            final Job $previousJob;
            long J$0;
            long J$1;
            Object L$0;
            Object L$1;
            int label;
            final GraphViewV2 this$0;

            {
               this.$previousJob = var1;
               this.$isAppend = var2;
               this.this$0 = var3;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.$previousJob, this.$isAppend, this.this$0, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               Object var12;
               label81: {
                  var12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var3 = this.label;
                  if (var3 != 0) {
                     if (var3 != 1) {
                        if (var3 != 2) {
                           if (var3 != 3) {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           Ref.LongRef var10 = (Ref.LongRef)this.L$1;
                           List var23 = (List)this.L$0;
                           ResultKt.throwOnFailure(var1);
                           return Unit.INSTANCE;
                        }

                        ResultKt.throwOnFailure(var1);
                        break label81;
                     }

                     ResultKt.throwOnFailure(var1);
                  } else {
                     ResultKt.throwOnFailure(var1);
                     Job var24 = this.$previousJob;
                     if (var24 != null) {
                        Continuation var15 = (Continuation)this;
                        this.label = 1;
                        if (JobKt.cancelAndJoin(var24, var15) == var12) {
                           return var12;
                        }
                     }
                  }

                  if (!this.$isAppend) {
                     CoroutineContext var11 = (CoroutineContext)Dispatchers.getMain();
                     Function2 var16 = new Function2(this.this$0, (Continuation)null) {
                        int label;
                        final GraphViewV2 this$0;

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
                     Continuation var25 = (Continuation)this;
                     this.label = 2;
                     if (BuildersKt.withContext(var11, var16, var25) == var12) {
                        return var12;
                     }
                  }
               }

               if (this.this$0.zeroTime <= 0L) {
                  return Unit.INSTANCE;
               } else {
                  List var13 = (List)(new ArrayList());
                  ChartTimeScale var17 = this.this$0.getTimeScale();
                  int var22 = null.WhenMappings.$EnumSwitchMapping$0[var17.ordinal()];
                  long var4;
                  if (var22 != 1) {
                     if (var22 != 2) {
                        if (var22 != 3) {
                           throw new NoWhenBranchMatchedException();
                        }

                        var4 = 3600000L;
                     } else {
                        var4 = 259200000L;
                     }
                  } else {
                     var4 = 864000000L;
                  }

                  long var8 = this.this$0.rawEndTime - this.this$0.rawEndTime % (long)3600000;
                  Ref.LongRef var31 = new Ref.LongRef();
                  var31.element = this.this$0.zeroTime - 2592000000L;
                  Ref.LongRef var18 = var31;
                  long var6 = var8;
                  if (this.$isAppend) {
                     List var19 = this.this$0.chart.getXAxis().getLimitLines();
                     Intrinsics.checkNotNullExpressionValue(var19, "getLimitLines(...)");
                     Iterator var20 = ((Iterable)var19).iterator();
                     Float var26;
                     if (!var20.hasNext()) {
                        var26 = null;
                     } else {
                        float var2;
                        for(var2 = ((LimitLine)var20.next()).getLimit(); var20.hasNext(); var2 = Math.max(var2, ((LimitLine)var20.next()).getLimit())) {
                        }

                        var26 = Boxing.boxFloat(var2);
                     }

                     var18 = var31;
                     var6 = var8;
                     if (var26 != null) {
                        GraphViewV2 var21 = this.this$0;
                        var31.element = (long)(((Number)var26).floatValue() * (float)5000) + var21.zeroTime + var4;
                        var6 = var8;
                        var18 = var31;
                     }
                  }

                  while(var6 > var18.element) {
                     GraphUtils var27 = GraphUtils.INSTANCE;
                     Context var32 = this.this$0.getContext();
                     Intrinsics.checkNotNullExpressionValue(var32, "getContext(...)");
                     String var28 = var27.getStringDate(var6, var32, true);
                     LimitLine var33 = new LimitLine((float)((var6 - this.this$0.zeroTime) / (long)5000), var28);
                     GraphViewV2 var29 = this.this$0;
                     var33.setLineWidth(1.0F);
                     var33.setLabelPosition(LimitLabelPosition.CENTER_TOP);
                     var33.setTextColor(ContextCompat.getColor(var29.getContext(), GraphViewV2.DIVIDER_TEXT_COLOR));
                     var33.setLineColor(ContextCompat.getColor(var29.getContext(), GraphViewV2.DIVIDER_LINE_COLOR));
                     var33.setTextSize(12.0F);
                     var33.setXOffset(0.0F);
                     var33.setYOffset(3.0F);
                     var13.add(var33);
                     var6 -= var4;
                  }

                  CoroutineContext var34 = (CoroutineContext)Dispatchers.getMain();
                  Function2 var14 = new Function2(var13, this.this$0, (Continuation)null) {
                     final List $lines;
                     int label;
                     final GraphViewV2 this$0;

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
                           GraphViewV2 var4 = this.this$0;

                           for(LimitLine var5 : var2) {
                              var4.chart.getXAxis().addLimitLine(var5);
                           }

                           this.this$0.chart.invalidate();
                           return Unit.INSTANCE;
                        }
                     }
                  };
                  Continuation var30 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var13);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var18);
                  this.J$0 = var4;
                  this.J$1 = var6;
                  this.label = 3;
                  if (BuildersKt.withContext(var34, var14, var30) == var12) {
                     return var12;
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
   }

   // $FF: synthetic method
   static void setupXAxisLines$default(GraphViewV2 var0, boolean var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = false;
      }

      var0.setupXAxisLines(var1);
   }

   private final void updateScrollIndicatorPosition(int var1) {
      int var4 = this.scrollIndicatorTrack.getWidth();
      float var3 = RangesKt.coerceIn(1.0F - this.scrollIndicatorPosition / (float)this.chart.getWidth(), 0.0F, 1.0F);
      float var2 = (float)(var4 - var1);
      this.scrollIndicator.setX(var3 * var2);
   }

   // $FF: synthetic method
   static void updateScrollIndicatorPosition$default(GraphViewV2 var0, int var1, int var2, Object var3) {
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

   public final void applyRangeContentDesp(TextView... var1) {
      Intrinsics.checkNotNullParameter(var1, "textViews");
      String var5 = this.getContext().getString(R.string.infix_to);
      StringBuilder var4 = new StringBuilder(" ");
      var4.append(var5);
      var4.append(' ');
      String var6 = var4.toString();

      for(TextView var7 : var1) {
         var7.setContentDescription((CharSequence)StringsKt.replace$default(var7.getText().toString(), "-", var6, false, 4, (Object)null));
      }

   }

   public final String concatLegendStr(int var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "range");
      StringBuilder var3 = new StringBuilder();
      var3.append(this.getResources().getString(var1));
      var3.append(" (");
      var3.append(var2);
      var3.append(')');
      return var3.toString();
   }

   public final String convertRealValue(float var1) {
      DataType var2 = this.dataType;
      SensorType var3;
      if (var2 != null) {
         var3 = var2.toSensorType();
      } else {
         var3 = null;
      }

      if (var3 == SensorType.HCHO) {
         String var4 = this.df.format((double)var1 / (double)10000);
         Intrinsics.checkNotNull(var4);
         return var4;
      } else {
         return String.valueOf((int)var1);
      }
   }

   protected void dispatchDraw(Canvas var1) {
      Intrinsics.checkNotNullParameter(var1, "canvas");
      super.dispatchDraw(var1);
      if (this.firstDraw) {
         this.firstDraw = false;
         setupXAxisLines$default(this, false, 1, (Object)null);
      }

   }

   public final String formatRange(SensorType var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "<this>");
      Intrinsics.checkNotNullParameter(var2, "range");
      if (var1 == SensorType.HCHO) {
         List var3 = StringsKt.split$default((CharSequence)var2, new String[]{"-"}, false, 0, 6, (Object)null);
         if (var3.size() == 2) {
            return CollectionsKt.joinToString$default((Iterable)var3, (CharSequence)"-", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, new GraphViewV2$$ExternalSyntheticLambda0(this), 30, (Object)null);
         }
      }

      return var2;
   }

   public final DataType getDataType() {
      return this.dataType;
   }

   public final SimpleDatapoint getHighlightedPoint() {
      return this.highlightedPoint;
   }

   public final String getSensorName() {
      return this.sensorName;
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
         GraphV2Binding var5 = this.binding;
         boolean var4 = var1 instanceof DataType.HUM;
         if (var4) {
            View var6 = var5.dividerH5;
            Intrinsics.checkNotNullExpressionValue(var6, "dividerH5");
            ViewExtensionsKt.show$default(var6, false, 1, (Object)null);
            var6 = var5.dividerH6;
            Intrinsics.checkNotNullExpressionValue(var6, "dividerH6");
            ViewExtensionsKt.show$default(var6, false, 1, (Object)null);
            var6 = var5.dividerH7;
            Intrinsics.checkNotNullExpressionValue(var6, "dividerH7");
            ViewExtensionsKt.show$default(var6, false, 1, (Object)null);
            var5.legendHum1.setText((CharSequence)this.concatLegendStr(R.string.humidity_level_moist, "51-80%"));
            var5.legendHum2.setText((CharSequence)this.concatLegendStr(R.string.humidity_level_ideal, "30-50%"));
            var5.legendHum3.setText((CharSequence)this.concatLegendStr(R.string.humidity_level_dry, "0-29%"));
            TextView var7 = var5.legendHum1;
            Intrinsics.checkNotNullExpressionValue(var7, "legendHum1");
            TextView var16 = var5.legendHum2;
            Intrinsics.checkNotNullExpressionValue(var16, "legendHum2");
            TextView var8 = var5.legendHum3;
            Intrinsics.checkNotNullExpressionValue(var8, "legendHum3");
            this.applyRangeContentDesp(var7, var16, var8);
         } else if (var1 instanceof DataType.TMP) {
            View var17 = var5.dividerH5;
            Intrinsics.checkNotNullExpressionValue(var17, "dividerH5");
            ViewExtensionsKt.hide(var17);
            var17 = var5.dividerH6;
            Intrinsics.checkNotNullExpressionValue(var17, "dividerH6");
            ViewExtensionsKt.hide(var17);
            var17 = var5.dividerH7;
            Intrinsics.checkNotNullExpressionValue(var17, "dividerH7");
            ViewExtensionsKt.hide(var17);
            if (((DataType.TMP)var1).isCelsius()) {
               var5.labelYTmp1.setText((CharSequence)"40℃");
               var5.labelYTmp2.setText((CharSequence)"30℃");
               var5.labelYTmp3.setText((CharSequence)"20℃");
               var5.labelYTmp4.setText((CharSequence)"10℃");
               var5.labelYTmp5.setText((CharSequence)"0℃");
               var5.labelYTmp6.setText((CharSequence)"-10℃");
            } else {
               var5.labelYTmp1.setText((CharSequence)"104℉");
               var5.labelYTmp2.setText((CharSequence)"86℉");
               var5.labelYTmp3.setText((CharSequence)"68℉");
               var5.labelYTmp4.setText((CharSequence)"50℉");
               var5.labelYTmp5.setText((CharSequence)"32℉");
               var5.labelYTmp6.setText((CharSequence)"14℉");
            }
         } else {
            if (!(var1 instanceof DataType.AQI)) {
               throw new NoWhenBranchMatchedException();
            }

            View var20 = var5.dividerH5;
            Intrinsics.checkNotNullExpressionValue(var20, "dividerH5");
            ViewExtensionsKt.hide(var20);
            var20 = var5.dividerH6;
            Intrinsics.checkNotNullExpressionValue(var20, "dividerH6");
            ViewExtensionsKt.hide(var20);
            var20 = var5.dividerH7;
            Intrinsics.checkNotNullExpressionValue(var20, "dividerH7");
            ViewExtensionsKt.hide(var20);
            IndoorAirRatingRanges var23 = IndoorAirRatingRanges.Companion.instance(var1.getDevice());
            DataType.AQI var31 = (DataType.AQI)var1;
            double[] var36 = var23.airRatingsFor(var31.getSensorType());
            Collection var24 = (Collection)(new ArrayList(var36.length));
            int var3 = var36.length;

            for(int var2 = 0; var2 < var3; ++var2) {
               var24.add((int)var36[var2]);
            }

            List var25 = (List)var24;
            SensorType var37 = var31.getSensorType();
            StringBuilder var32 = new StringBuilder("0-");
            var32.append(((Number)var25.get(0)).intValue());
            String var33 = this.formatRange(var37, var32.toString());
            StringBuilder var9 = new StringBuilder();
            var9.append(((Number)var25.get(0)).intValue() + 1);
            var9.append('-');
            var9.append(((Number)var25.get(1)).intValue());
            String var40 = this.formatRange(var37, var9.toString());
            StringBuilder var10 = new StringBuilder();
            var10.append(((Number)var25.get(1)).intValue() + 1);
            var10.append('-');
            var10.append(((Number)var25.get(2)).intValue());
            String var43 = this.formatRange(var37, var10.toString());
            StringBuilder var11 = new StringBuilder();
            var11.append(((Number)var25.get(2)).intValue() + 1);
            var11.append('-');
            var11.append(((Number)var25.get(3)).intValue());
            String var46 = this.formatRange(var37, var11.toString());
            StringBuilder var12 = new StringBuilder();
            var12.append(((Number)var25.get(3)).intValue() + 1);
            var12.append('-');
            var12.append(((Number)var25.get(4)).intValue());
            String var26 = this.formatRange(var37, var12.toString());
            var5.labelYAqi5.setText((CharSequence)var33);
            var5.labelYAqi4.setText((CharSequence)var40);
            var5.labelYAqi3.setText((CharSequence)var43);
            var5.labelYAqi2.setText((CharSequence)var46);
            var5.labelYAqi1.setText((CharSequence)var26);
            var5.legendAqi1.setText((CharSequence)this.concatLegendStr(R.string.excellent, var33));
            var5.legendAqi2.setText((CharSequence)this.concatLegendStr(R.string.good, var40));
            var5.legendAqi3.setText((CharSequence)this.concatLegendStr(R.string.moderate, var43));
            var5.legendAqi4.setText((CharSequence)this.concatLegendStr(R.string.polluted, var46));
            var5.legendAqi5.setText((CharSequence)this.concatLegendStr(R.string.vpolluted, var26));
            TextView var44 = var5.labelYAqi5;
            Intrinsics.checkNotNullExpressionValue(var44, "labelYAqi5");
            TextView var34 = var5.labelYAqi4;
            Intrinsics.checkNotNullExpressionValue(var34, "labelYAqi4");
            TextView var38 = var5.labelYAqi3;
            Intrinsics.checkNotNullExpressionValue(var38, "labelYAqi3");
            TextView var41 = var5.labelYAqi2;
            Intrinsics.checkNotNullExpressionValue(var41, "labelYAqi2");
            TextView var27 = var5.labelYAqi1;
            Intrinsics.checkNotNullExpressionValue(var27, "labelYAqi1");
            this.applyRangeContentDesp(var44, var34, var38, var41, var27);
            var27 = var5.legendAqi1;
            Intrinsics.checkNotNullExpressionValue(var27, "legendAqi1");
            var41 = var5.legendAqi2;
            Intrinsics.checkNotNullExpressionValue(var41, "legendAqi2");
            var44 = var5.legendAqi3;
            Intrinsics.checkNotNullExpressionValue(var44, "legendAqi3");
            var34 = var5.legendAqi4;
            Intrinsics.checkNotNullExpressionValue(var34, "legendAqi4");
            var38 = var5.legendAqi5;
            Intrinsics.checkNotNullExpressionValue(var38, "legendAqi5");
            this.applyRangeContentDesp(var27, var41, var44, var34, var38);
         }

         Group var29 = var5.groupHum;
         Intrinsics.checkNotNullExpressionValue(var29, "groupHum");
         ViewExtensionsKt.show((View)var29, var4);
         var29 = var5.groupTmp;
         Intrinsics.checkNotNullExpressionValue(var29, "groupTmp");
         ViewExtensionsKt.show((View)var29, var1 instanceof DataType.TMP);
         Group var13 = var5.groupAqi;
         Intrinsics.checkNotNullExpressionValue(var13, "groupAqi");
         ViewExtensionsKt.show((View)var13, var1 instanceof DataType.AQI);
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

   public final void setSensorName(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.sensorName = var1;
   }

   public final void setTimeScale(ChartTimeScale var1) {
      Intrinsics.checkNotNullParameter(var1, "scale");
      notifyChartScaleChanged$default(this, var1, (Entry)null, 2, (Object)null);
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
      d2 = {"Lcom/blueair/graph/view/GraphViewV2$Companion;", "", "<init>", "()V", "X_FACTOR", "", "ONE_DAY_IN_MILLS", "", "ONE_WEEK_IN_MILLS", "ONE_MONTH_IN_MILLS", "ONE_DAY_IN_X", "", "ONE_WEEK_IN_X", "ONE_MONTH_IN_X", "BLOCK_COUNT", "SCALE_MONTH", "SCALE_WEEK", "SCALE_DAY", "DIVIDER_TEXT_COLOR", "DIVIDER_LINE_COLOR", "convertToEntries", "", "Lcom/github/mikephil/charting/data/Entry;", "Lcom/blueair/core/model/SimpleDatapoint;", "type", "Lcom/blueair/graph/view/GraphViewV2$DataType;", "zeroTime", "getLegendColor", "value", "graph_otherRelease"},
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
            Iterable var13 = (Iterable)var1;
            Collection var11 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var13, 10)));

            for(SimpleDatapoint var14 : var13) {
               float var15 = var14.getValue();
               var11.add(new Entry(convertToEntries$getX(var3, var14), RangesKt.coerceIn(var15 * 1.25F, 0.0F, 100.0F), var14));
            }

            return (List)var11;
         } else if (var2 instanceof DataType.TMP) {
            Iterable var17 = (Iterable)var1;
            Collection var10 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var17, 10)));

            for(SimpleDatapoint var18 : var17) {
               float var5;
               if (((DataType.TMP)var2).isCelsius()) {
                  var5 = (var18.getValue() + (float)10) * (float)2;
               } else {
                  var5 = (DeviceData.Companion.convertCelsiusToFahrenheit(var18.getValue()) - (float)14) * (float)10 / (float)9;
               }

               var10.add(new Entry(convertToEntries$getX(var3, var18), RangesKt.coerceIn(var5, 0.0F, 100.0F), var18));
            }

            return (List)var10;
         } else if (!(var2 instanceof DataType.AQI)) {
            throw new NoWhenBranchMatchedException();
         } else {
            IndoorAirRatingRanges var6 = IndoorAirRatingRanges.Companion.instance(((DataType)var2).getDevice());
            var2 = var2;
            double[] var16 = var6.airRatingsFor(var2.getSensorType());
            Iterable var7 = (Iterable)var1;
            Collection var9 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var7, 10)));

            for(SimpleDatapoint var8 : var7) {
               var9.add(new Entry(convertToEntries$getX(var3, var8), (float)MpChartUtils.getScaledValueForChart$default(MpChartUtils.INSTANCE, var8.getValue(), var2.getSensorType(), var16, false, 8, (Object)null), var8));
            }

            return (List)var9;
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
            if (var2 < 37.5F) {
               return R.color.color_vpolluted;
            } else {
               return var2 <= 62.5F ? R.color.color_good : R.color.color_moderate;
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
      d2 = {"Lcom/blueair/graph/view/GraphViewV2$DataType;", "", "device", "Lcom/blueair/core/model/HasSensorData;", "<init>", "(Lcom/blueair/core/model/HasSensorData;)V", "getDevice", "()Lcom/blueair/core/model/HasSensorData;", "toSensorType", "Lcom/blueair/core/model/SensorType;", "equals", "", "other", "HUM", "TMP", "AQI", "Lcom/blueair/graph/view/GraphViewV2$DataType$AQI;", "Lcom/blueair/graph/view/GraphViewV2$DataType$HUM;", "Lcom/blueair/graph/view/GraphViewV2$DataType$TMP;", "graph_otherRelease"},
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
         d2 = {"Lcom/blueair/graph/view/GraphViewV2$DataType$AQI;", "Lcom/blueair/graph/view/GraphViewV2$DataType;", "device", "Lcom/blueair/core/model/HasSensorData;", "sensorType", "Lcom/blueair/core/model/SensorType;", "<init>", "(Lcom/blueair/core/model/HasSensorData;Lcom/blueair/core/model/SensorType;)V", "getSensorType", "()Lcom/blueair/core/model/SensorType;", "graph_otherRelease"},
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
         d2 = {"Lcom/blueair/graph/view/GraphViewV2$DataType$HUM;", "Lcom/blueair/graph/view/GraphViewV2$DataType;", "device", "Lcom/blueair/core/model/HasSensorData;", "<init>", "(Lcom/blueair/core/model/HasSensorData;)V", "graph_otherRelease"},
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
         d2 = {"Lcom/blueair/graph/view/GraphViewV2$DataType$TMP;", "Lcom/blueair/graph/view/GraphViewV2$DataType;", "device", "Lcom/blueair/core/model/HasSensorData;", "isCelsius", "", "<init>", "(Lcom/blueair/core/model/HasSensorData;Z)V", "()Z", "graph_otherRelease"},
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
      public static final int[] $EnumSwitchMapping$1;

      static {
         int[] var0 = new int[ChartTimeScale.values().length];

         try {
            var0[ChartTimeScale.DAY.ordinal()] = 1;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[ChartTimeScale.WEEK.ordinal()] = 2;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[ChartTimeScale.MONTH.ordinal()] = 3;
         } catch (NoSuchFieldError var10) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[SensorType.values().length];

         try {
            var0[SensorType.PM1.ordinal()] = 1;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[SensorType.PM25.ordinal()] = 2;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[SensorType.PM10.ordinal()] = 3;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[SensorType.VOC.ordinal()] = 4;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[SensorType.HCHO.ordinal()] = 5;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[SensorType.HUM.ordinal()] = 6;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[SensorType.TMP.ordinal()] = 7;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[SensorType.FAN.ordinal()] = 8;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$1 = var0;
      }
   }
}
