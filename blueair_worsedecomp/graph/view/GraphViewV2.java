package com.blueair.graph.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.TypedValueCompat;
import com.blueair.auth.GigyaService;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.SensorType;
import com.blueair.core.model.SimpleDatapoint;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.graph.databinding.GraphV2Binding;
import com.blueair.graph.utils.ChartTimeScale;
import com.blueair.graph.utils.MpChartUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.foobot.liblabclient.core.WsDefinition;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 \u00012\u00020\u0001:\u0004\u0001\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"H\u0002J\u0016\u0010R\u001a\b\u0012\u0004\u0012\u00020\n0\u001b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010S\u001a\u00020Q2\u0006\u0010T\u001a\u00020\u0013H\u0007J\u001f\u0010U\u001a\u00020<2\u0012\u0010V\u001a\n\u0012\u0006\b\u0001\u0012\u00020X0W\"\u00020X¢\u0006\u0002\u0010YJ\u0018\u0010Z\u001a\u00020K2\b\b\u0001\u0010[\u001a\u00020\n2\u0006\u0010\\\u001a\u00020KJ\u000e\u0010]\u001a\u00020<2\u0006\u0010^\u001a\u00020(J)\u0010_\u001a\u00020<2!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110(¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(^\u0012\u0004\u0012\u00020<0;J+\u0010`\u001a\u00020<2#\u0010=\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020<0;J\b\u0010a\u001a\u00020<H\u0014J\b\u0010b\u001a\u00020<H\u0014J\u0010\u0010c\u001a\u00020<2\u0006\u0010d\u001a\u00020eH\u0014J\b\u0010f\u001a\u00020<H\u0002J\u000e\u0010g\u001a\u00020<2\u0006\u0010g\u001a\u00020QJ\u0014\u0010h\u001a\u00020<2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u0014\u0010j\u001a\u00020<2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u001e\u0010k\u001a\u00020<2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010l\u001a\u00020QH\u0002J\u0012\u0010m\u001a\u00020<2\b\u0010n\u001a\u0004\u0018\u00010$H\u0002J\u0012\u0010o\u001a\u00020<2\b\u0010n\u001a\u0004\u0018\u00010$H\u0002J\u001c\u0010p\u001a\u00020<2\u0006\u0010^\u001a\u00020(2\n\b\u0002\u0010n\u001a\u0004\u0018\u00010$H\u0002J\u001e\u0010q\u001a\u00020<2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010r\u001a\u00020QH\u0002J\u0012\u0010s\u001a\u0004\u0018\u00010K2\u0006\u0010t\u001a\u00020\u001cH\u0002J\b\u0010u\u001a\u00020\nH\u0002J\u0010\u0010v\u001a\u00020<2\u0006\u0010n\u001a\u00020$H\u0002J\b\u0010w\u001a\u00020<H\u0002J\u0012\u0010x\u001a\u00020<2\b\b\u0002\u0010r\u001a\u00020QH\u0002J\u0010\u0010y\u001a\u00020<2\u0006\u0010z\u001a\u00020\"H\u0002J\u0012\u0010{\u001a\u00020<2\b\b\u0002\u0010|\u001a\u00020\nH\u0002J3\u0010}\u001a\u00020<2\u0006\u0010~\u001a\u00020Q2\u0006\u0010\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0014R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R*\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\"@BX\u000e¢\u0006\b\n\u0000\"\u0004\b&\u0010'R$\u0010)\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020(@CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u001e\u00108\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\"@BX\u000e¢\u0006\b\n\u0000\"\u0004\b9\u0010'R\u001c\u0010:\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020<\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R-\u0010=\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020<\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\"\u0010A\u001a\u0004\u0018\u00010$2\b\u0010\u0012\u001a\u0004\u0018\u00010$@BX\u000e¢\u0006\b\n\u0000\"\u0004\bB\u0010CR(\u0010D\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001c@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0014\u0010I\u001a\b\u0012\u0004\u0012\u00020\n0\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010J\u001a\u00020KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u000e\u0010P\u001a\u00020QX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/blueair/graph/view/GraphViewV2;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "xAxisLineJob", "Lkotlinx/coroutines/Job;", "value", "Lcom/blueair/graph/view/GraphViewV2$DataType;", "dataType", "getDataType", "()Lcom/blueair/graph/view/GraphViewV2$DataType;", "rawStartTime", "", "rawEndTime", "zeroTime", "", "Lcom/blueair/core/model/SimpleDatapoint;", "rawDatapoint", "setRawDatapoint", "(Ljava/util/List;)V", "getTimestampFromEntryX", "x", "", "entries", "Lcom/github/mikephil/charting/data/Entry;", "maxX", "setMaxX", "(F)V", "Lcom/blueair/graph/utils/ChartTimeScale;", "timeScale", "getTimeScale", "()Lcom/blueair/graph/utils/ChartTimeScale;", "setTimeScaleField", "(Lcom/blueair/graph/utils/ChartTimeScale;)V", "chartScale", "binding", "Lcom/blueair/graph/databinding/GraphV2Binding;", "chart", "Lcom/github/mikephil/charting/charts/LineChart;", "scrollIndicatorTrack", "Landroid/widget/FrameLayout;", "scrollIndicator", "Landroid/view/View;", "scrollIndicatorPreviousDx", "scrollIndicatorPosition", "setScrollIndicatorPosition", "onTimeScaleChangedListener", "Lkotlin/Function1;", "", "onDatapointSelectedListener", "Lkotlin/ParameterName;", "name", "datapoint", "highlightedEntry", "setHighlightedEntry", "(Lcom/github/mikephil/charting/data/Entry;)V", "highlightedPoint", "getHighlightedPoint", "()Lcom/blueair/core/model/SimpleDatapoint;", "setHighlightedPoint", "(Lcom/blueair/core/model/SimpleDatapoint;)V", "graphLineGradient", "sensorName", "", "getSensorName", "()Ljava/lang/String;", "setSensorName", "(Ljava/lang/String;)V", "firstDraw", "", "getGradient", "setDataType", "type", "applyRangeContentDesp", "textViews", "", "Landroid/widget/TextView;", "([Landroid/widget/TextView;)V", "concatLegendStr", "stringRes", "range", "setTimeScale", "scale", "setOnTimeScaleChangedListener", "setOnDatapointSelectedListener", "onAttachedToWindow", "onDetachedFromWindow", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "setupChart", "showProgress", "updateHistoricalData", "data", "updateRealTimeData", "setData", "isRealTime", "scaleAndCenter", "entry", "highlightEntry", "notifyChartScaleChanged", "notifyChartDataChanged", "isAppend", "buildContentDesp", "it", "getSensorTitle", "setChartMarker", "highlightCenterEntry", "setupXAxisLines", "updateScrollIndicatorWidth", "chartScaleX", "updateScrollIndicatorPosition", "indicatorWidth", "onLayout", "changed", "left", "top", "right", "bottom", "DataType", "Companion", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GraphViewV2.kt */
public final class GraphViewV2 extends ConstraintLayout {
    private static final int BLOCK_COUNT = 3;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int DIVIDER_LINE_COLOR = R.color.surface_dark_5;
    /* access modifiers changed from: private */
    public static final int DIVIDER_TEXT_COLOR = R.color.surface_dark_55;
    private static final long ONE_DAY_IN_MILLS = 86400000;
    private static final float ONE_DAY_IN_X = 17280.0f;
    private static final long ONE_MONTH_IN_MILLS = 2592000000L;
    private static final float ONE_MONTH_IN_X = 518400.0f;
    private static final long ONE_WEEK_IN_MILLS = 604800000;
    private static final float ONE_WEEK_IN_X = 120960.0f;
    private static final float SCALE_DAY = 240.0f;
    private static final float SCALE_MONTH = 1.0f;
    private static final float SCALE_WEEK = 3.3333333f;
    private static final int X_FACTOR = 5000;
    private final GraphV2Binding binding;
    /* access modifiers changed from: private */
    public final LineChart chart;
    private float chartScale = 240.0f;
    private DataType dataType;
    private List<? extends Entry> entries = CollectionsKt.emptyList();
    private boolean firstDraw;
    private List<Integer> graphLineGradient;
    private Entry highlightedEntry;
    private SimpleDatapoint highlightedPoint;
    private float maxX;
    private Function1<? super SimpleDatapoint, Unit> onDatapointSelectedListener;
    private Function1<? super ChartTimeScale, Unit> onTimeScaleChangedListener;
    private List<SimpleDatapoint> rawDatapoint = CollectionsKt.emptyList();
    /* access modifiers changed from: private */
    public long rawEndTime;
    private long rawStartTime;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    private final View scrollIndicator;
    /* access modifiers changed from: private */
    public float scrollIndicatorPosition;
    /* access modifiers changed from: private */
    public float scrollIndicatorPreviousDx;
    private final FrameLayout scrollIndicatorTrack;
    private String sensorName;
    private ChartTimeScale timeScale = ChartTimeScale.DAY;
    private Job xAxisLineJob;
    /* access modifiers changed from: private */
    public long zeroTime;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GraphViewV2.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0055 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0067 */
        static {
            /*
                com.blueair.graph.utils.ChartTimeScale[] r0 = com.blueair.graph.utils.ChartTimeScale.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.blueair.graph.utils.ChartTimeScale r2 = com.blueair.graph.utils.ChartTimeScale.DAY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.blueair.graph.utils.ChartTimeScale r3 = com.blueair.graph.utils.ChartTimeScale.WEEK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.blueair.graph.utils.ChartTimeScale r4 = com.blueair.graph.utils.ChartTimeScale.MONTH     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                com.blueair.core.model.SensorType[] r0 = com.blueair.core.model.SensorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.SensorType r4 = com.blueair.core.model.SensorType.PM1     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM25     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM10     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.VOC     // Catch:{ NoSuchFieldError -> 0x004c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.HCHO     // Catch:{ NoSuchFieldError -> 0x0055 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0055 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0055 }
            L_0x0055:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.HUM     // Catch:{ NoSuchFieldError -> 0x005e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.TMP     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.FAN     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.view.GraphViewV2.WhenMappings.<clinit>():void");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0003\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/blueair/graph/view/GraphViewV2$DataType;", "", "device", "Lcom/blueair/core/model/HasSensorData;", "<init>", "(Lcom/blueair/core/model/HasSensorData;)V", "getDevice", "()Lcom/blueair/core/model/HasSensorData;", "toSensorType", "Lcom/blueair/core/model/SensorType;", "equals", "", "other", "HUM", "TMP", "AQI", "Lcom/blueair/graph/view/GraphViewV2$DataType$AQI;", "Lcom/blueair/graph/view/GraphViewV2$DataType$HUM;", "Lcom/blueair/graph/view/GraphViewV2$DataType$TMP;", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GraphViewV2.kt */
    public static abstract class DataType {
        private final HasSensorData device;

        public /* synthetic */ DataType(HasSensorData hasSensorData, DefaultConstructorMarker defaultConstructorMarker) {
            this(hasSensorData);
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/graph/view/GraphViewV2$DataType$HUM;", "Lcom/blueair/graph/view/GraphViewV2$DataType;", "device", "Lcom/blueair/core/model/HasSensorData;", "<init>", "(Lcom/blueair/core/model/HasSensorData;)V", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: GraphViewV2.kt */
        public static final class HUM extends DataType {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public HUM(HasSensorData hasSensorData) {
                super(hasSensorData, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(hasSensorData, "device");
            }
        }

        private DataType(HasSensorData hasSensorData) {
            this.device = hasSensorData;
        }

        public final HasSensorData getDevice() {
            return this.device;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lcom/blueair/graph/view/GraphViewV2$DataType$TMP;", "Lcom/blueair/graph/view/GraphViewV2$DataType;", "device", "Lcom/blueair/core/model/HasSensorData;", "isCelsius", "", "<init>", "(Lcom/blueair/core/model/HasSensorData;Z)V", "()Z", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: GraphViewV2.kt */
        public static final class TMP extends DataType {
            private final boolean isCelsius;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public TMP(HasSensorData hasSensorData, boolean z) {
                super(hasSensorData, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(hasSensorData, "device");
                this.isCelsius = z;
            }

            public final boolean isCelsius() {
                return this.isCelsius;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/blueair/graph/view/GraphViewV2$DataType$AQI;", "Lcom/blueair/graph/view/GraphViewV2$DataType;", "device", "Lcom/blueair/core/model/HasSensorData;", "sensorType", "Lcom/blueair/core/model/SensorType;", "<init>", "(Lcom/blueair/core/model/HasSensorData;Lcom/blueair/core/model/SensorType;)V", "getSensorType", "()Lcom/blueair/core/model/SensorType;", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: GraphViewV2.kt */
        public static final class AQI extends DataType {
            private final SensorType sensorType;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public AQI(HasSensorData hasSensorData, SensorType sensorType2) {
                super(hasSensorData, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(hasSensorData, "device");
                Intrinsics.checkNotNullParameter(sensorType2, "sensorType");
                this.sensorType = sensorType2;
            }

            public final SensorType getSensorType() {
                return this.sensorType;
            }
        }

        public final SensorType toSensorType() {
            if (this instanceof HUM) {
                return SensorType.HUM;
            }
            if (this instanceof TMP) {
                return SensorType.TMP;
            }
            if (this instanceof AQI) {
                return ((AQI) this).getSensorType();
            }
            throw new NoWhenBranchMatchedException();
        }

        public boolean equals(Object obj) {
            if (obj instanceof HUM) {
                return this instanceof HUM;
            }
            return obj instanceof TMP ? (this instanceof TMP) && ((TMP) this).isCelsius() == ((TMP) obj).isCelsius() : (obj instanceof AQI) && (this instanceof AQI) && ((AQI) this).getSensorType() == ((AQI) obj).getSensorType();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015*\b\u0012\u0004\u0012\u00020\u00170\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0007H\u0002J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/blueair/graph/view/GraphViewV2$Companion;", "", "<init>", "()V", "X_FACTOR", "", "ONE_DAY_IN_MILLS", "", "ONE_WEEK_IN_MILLS", "ONE_MONTH_IN_MILLS", "ONE_DAY_IN_X", "", "ONE_WEEK_IN_X", "ONE_MONTH_IN_X", "BLOCK_COUNT", "SCALE_MONTH", "SCALE_WEEK", "SCALE_DAY", "DIVIDER_TEXT_COLOR", "DIVIDER_LINE_COLOR", "convertToEntries", "", "Lcom/github/mikephil/charting/data/Entry;", "Lcom/blueair/core/model/SimpleDatapoint;", "type", "Lcom/blueair/graph/view/GraphViewV2$DataType;", "zeroTime", "getLegendColor", "value", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GraphViewV2.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        static /* synthetic */ List convertToEntries$default(Companion companion, List list, DataType dataType, long j, int i, Object obj) {
            if ((i & 2) != 0) {
                j = ((SimpleDatapoint) CollectionsKt.last(list)).getTimeInMillis();
            }
            return companion.convertToEntries(list, dataType, j);
        }

        private static final float convertToEntries$getX(long j, SimpleDatapoint simpleDatapoint) {
            return (float) ((simpleDatapoint.getTimeInMillis() - j) / ((long) 5000));
        }

        /* access modifiers changed from: private */
        public final List<Entry> convertToEntries(List<SimpleDatapoint> list, DataType dataType, long j) {
            float f;
            if (dataType instanceof DataType.HUM) {
                Iterable<SimpleDatapoint> iterable = list;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (SimpleDatapoint simpleDatapoint : iterable) {
                    arrayList.add(new Entry(convertToEntries$getX(j, simpleDatapoint), simpleDatapoint.getValue() * 1.25f, (Object) simpleDatapoint));
                }
                return (List) arrayList;
            } else if (dataType instanceof DataType.TMP) {
                Iterable<SimpleDatapoint> iterable2 = list;
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                for (SimpleDatapoint simpleDatapoint2 : iterable2) {
                    if (((DataType.TMP) dataType).isCelsius()) {
                        f = (simpleDatapoint2.getValue() + ((float) 10)) * ((float) 2);
                    } else {
                        f = ((DeviceData.Companion.convertCelsiusToFahrenheit(simpleDatapoint2.getValue()) - ((float) 14)) * ((float) 10)) / ((float) 9);
                    }
                    arrayList2.add(new Entry(convertToEntries$getX(j, simpleDatapoint2), f, (Object) simpleDatapoint2));
                }
                return (List) arrayList2;
            } else if (dataType instanceof DataType.AQI) {
                DataType.AQI aqi = (DataType.AQI) dataType;
                double[] airRatingsFor = IndoorAirRatingRanges.Companion.instance(dataType.getDevice()).airRatingsFor(aqi.getSensorType());
                Iterable<SimpleDatapoint> iterable3 = list;
                Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable3, 10));
                for (SimpleDatapoint simpleDatapoint3 : iterable3) {
                    arrayList3.add(new Entry(convertToEntries$getX(j, simpleDatapoint3), (float) MpChartUtils.getScaledValueForChart$default(MpChartUtils.INSTANCE, simpleDatapoint3.getValue(), aqi.getSensorType(), airRatingsFor, false, 8, (Object) null), (Object) simpleDatapoint3));
                }
                return (List) arrayList3;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }

        /* access modifiers changed from: private */
        public final int getLegendColor(DataType dataType, float f) {
            if (dataType instanceof DataType.HUM) {
                if (f < 37.5f) {
                    return R.color.color_vpolluted;
                }
                if (f <= 62.5f) {
                    return R.color.color_good;
                }
                return R.color.color_moderate;
            } else if (dataType instanceof DataType.TMP) {
                return R.color.colorPrimary;
            } else {
                if (dataType instanceof DataType.AQI) {
                    IndoorAirRatingRanges instance = IndoorAirRatingRanges.Companion.instance(dataType.getDevice());
                    DataType.AQI aqi = (DataType.AQI) dataType;
                    IndoorAirRatingRanges.IndoorAirRating rating = instance.rating(MpChartUtils.INSTANCE.getRealValueFromScaledChartValue(f, aqi.getSensorType(), true, instance.airRatingsFor(aqi.getSensorType())), aqi.getSensorType());
                    if (Intrinsics.areEqual((Object) rating, (Object) IndoorAirRatingRanges.IndoorAirRating.VERY_POLLUTED.INSTANCE)) {
                        return R.color.color_vpolluted;
                    }
                    if (Intrinsics.areEqual((Object) rating, (Object) IndoorAirRatingRanges.IndoorAirRating.POLLUTED.INSTANCE)) {
                        return R.color.color_polluted;
                    }
                    if (Intrinsics.areEqual((Object) rating, (Object) IndoorAirRatingRanges.IndoorAirRating.MODERATE.INSTANCE)) {
                        return R.color.color_moderate;
                    }
                    if (Intrinsics.areEqual((Object) rating, (Object) IndoorAirRatingRanges.IndoorAirRating.GOOD.INSTANCE)) {
                        return R.color.color_good;
                    }
                    if (Intrinsics.areEqual((Object) rating, (Object) IndoorAirRatingRanges.IndoorAirRating.EXCELLENT.INSTANCE)) {
                        return R.color.color_excellent;
                    }
                    if (rating == null) {
                        return R.color.colorPrimary;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraphViewV2(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        GraphV2Binding inflate = GraphV2Binding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        LineChart lineChart = inflate.lineChart;
        Intrinsics.checkNotNullExpressionValue(lineChart, "lineChart");
        this.chart = lineChart;
        FrameLayout frameLayout = inflate.scrollIndicatorTrack;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "scrollIndicatorTrack");
        this.scrollIndicatorTrack = frameLayout;
        View view = inflate.scrollIndicator;
        Intrinsics.checkNotNullExpressionValue(view, "scrollIndicator");
        this.scrollIndicator = view;
        this.graphLineGradient = CollectionsKt.emptyList();
        this.sensorName = "";
        this.firstDraw = true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraphViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        GraphV2Binding inflate = GraphV2Binding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        LineChart lineChart = inflate.lineChart;
        Intrinsics.checkNotNullExpressionValue(lineChart, "lineChart");
        this.chart = lineChart;
        FrameLayout frameLayout = inflate.scrollIndicatorTrack;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "scrollIndicatorTrack");
        this.scrollIndicatorTrack = frameLayout;
        View view = inflate.scrollIndicator;
        Intrinsics.checkNotNullExpressionValue(view, "scrollIndicator");
        this.scrollIndicator = view;
        this.graphLineGradient = CollectionsKt.emptyList();
        this.sensorName = "";
        this.firstDraw = true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraphViewV2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        GraphV2Binding inflate = GraphV2Binding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        LineChart lineChart = inflate.lineChart;
        Intrinsics.checkNotNullExpressionValue(lineChart, "lineChart");
        this.chart = lineChart;
        FrameLayout frameLayout = inflate.scrollIndicatorTrack;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "scrollIndicatorTrack");
        this.scrollIndicatorTrack = frameLayout;
        View view = inflate.scrollIndicator;
        Intrinsics.checkNotNullExpressionValue(view, "scrollIndicator");
        this.scrollIndicator = view;
        this.graphLineGradient = CollectionsKt.emptyList();
        this.sensorName = "";
        this.firstDraw = true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraphViewV2(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        GraphV2Binding inflate = GraphV2Binding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        LineChart lineChart = inflate.lineChart;
        Intrinsics.checkNotNullExpressionValue(lineChart, "lineChart");
        this.chart = lineChart;
        FrameLayout frameLayout = inflate.scrollIndicatorTrack;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "scrollIndicatorTrack");
        this.scrollIndicatorTrack = frameLayout;
        View view = inflate.scrollIndicator;
        Intrinsics.checkNotNullExpressionValue(view, "scrollIndicator");
        this.scrollIndicator = view;
        this.graphLineGradient = CollectionsKt.emptyList();
        this.sensorName = "";
        this.firstDraw = true;
    }

    public final DataType getDataType() {
        return this.dataType;
    }

    private final void setRawDatapoint(List<SimpleDatapoint> list) {
        this.rawDatapoint = list;
        if (list.isEmpty()) {
            this.zeroTime = 0;
            this.rawStartTime = 0;
            this.rawEndTime = 0;
            return;
        }
        long timeInMillis = ((SimpleDatapoint) CollectionsKt.first(list)).getTimeInMillis();
        long timeInMillis2 = ((SimpleDatapoint) CollectionsKt.last(list)).getTimeInMillis();
        if (this.rawStartTime != timeInMillis) {
            this.zeroTime = timeInMillis2;
        }
        this.rawStartTime = timeInMillis;
        this.rawEndTime = timeInMillis2;
    }

    private final long getTimestampFromEntryX(float f) {
        return ((long) (f * ((float) 5000))) + this.zeroTime;
    }

    private final void setMaxX(float f) {
        if (this.maxX != f) {
            this.maxX = f;
        }
    }

    public final ChartTimeScale getTimeScale() {
        return this.timeScale;
    }

    private final void setTimeScaleField(ChartTimeScale chartTimeScale) {
        float f;
        this.timeScale = chartTimeScale;
        int i = WhenMappings.$EnumSwitchMapping$0[chartTimeScale.ordinal()];
        if (i == 1) {
            f = 240.0f;
        } else if (i == 2) {
            f = SCALE_WEEK;
        } else if (i == 3) {
            f = 1.0f;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.chartScale = f;
    }

    /* access modifiers changed from: private */
    public final void setScrollIndicatorPosition(float f) {
        this.scrollIndicatorPosition = f;
        updateScrollIndicatorPosition$default(this, 0, 1, (Object) null);
    }

    private final void setHighlightedEntry(Entry entry) {
        if (!Intrinsics.areEqual((Object) this.highlightedEntry, (Object) entry)) {
            this.highlightedEntry = entry;
            SimpleDatapoint simpleDatapoint = null;
            Object data = entry != null ? entry.getData() : null;
            if (data instanceof SimpleDatapoint) {
                simpleDatapoint = (SimpleDatapoint) data;
            }
            setHighlightedPoint(simpleDatapoint);
        }
    }

    public final SimpleDatapoint getHighlightedPoint() {
        return this.highlightedPoint;
    }

    private final void setHighlightedPoint(SimpleDatapoint simpleDatapoint) {
        if (!Intrinsics.areEqual((Object) this.highlightedPoint, (Object) simpleDatapoint)) {
            this.highlightedPoint = simpleDatapoint;
            Function1<? super SimpleDatapoint, Unit> function1 = this.onDatapointSelectedListener;
            if (function1 != null) {
                function1.invoke(simpleDatapoint);
            }
        }
    }

    public final String getSensorName() {
        return this.sensorName;
    }

    public final void setSensorName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sensorName = str;
    }

    private final List<Integer> getGradient(DataType dataType2) {
        List<Integer> arrayList = new ArrayList<>();
        if (dataType2 instanceof DataType.HUM) {
            int gradient$lambda$7$getColor = getGradient$lambda$7$getColor(this, R.color.color_moderate);
            for (int i = 0; i < 3; i++) {
                arrayList.add(Integer.valueOf(gradient$lambda$7$getColor));
            }
            int gradient$lambda$7$getColor2 = getGradient$lambda$7$getColor(this, R.color.color_good);
            for (int i2 = 0; i2 < 2; i2++) {
                arrayList.add(Integer.valueOf(gradient$lambda$7$getColor2));
            }
            int gradient$lambda$7$getColor3 = getGradient$lambda$7$getColor(this, R.color.color_vpolluted);
            for (int i3 = 0; i3 < 3; i3++) {
                arrayList.add(Integer.valueOf(gradient$lambda$7$getColor3));
            }
        } else if (dataType2 instanceof DataType.TMP) {
            arrayList.add(Integer.valueOf(getGradient$lambda$7$getColor(this, R.color.colorPrimary)));
            return arrayList;
        } else if (dataType2 instanceof DataType.AQI) {
            for (Number intValue : CollectionsKt.listOf(Integer.valueOf(R.color.color_vpolluted), Integer.valueOf(R.color.color_polluted), Integer.valueOf(R.color.color_moderate), Integer.valueOf(R.color.color_good), Integer.valueOf(R.color.color_excellent))) {
                arrayList.add(Integer.valueOf(getGradient$lambda$7$getColor(this, intValue.intValue())));
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return arrayList;
    }

    private static final int getGradient$lambda$7$getColor(GraphViewV2 graphViewV2, int i) {
        return ResourcesCompat.getColor(graphViewV2.getResources(), i, graphViewV2.getContext().getTheme());
    }

    public final boolean setDataType(DataType dataType2) {
        Intrinsics.checkNotNullParameter(dataType2, "type");
        if (Intrinsics.areEqual((Object) this.dataType, (Object) dataType2)) {
            return false;
        }
        this.dataType = dataType2;
        this.graphLineGradient = getGradient(dataType2);
        GraphV2Binding graphV2Binding = this.binding;
        boolean z = dataType2 instanceof DataType.HUM;
        if (z) {
            View view = graphV2Binding.dividerH5;
            Intrinsics.checkNotNullExpressionValue(view, "dividerH5");
            ViewExtensionsKt.show$default(view, false, 1, (Object) null);
            View view2 = graphV2Binding.dividerH6;
            Intrinsics.checkNotNullExpressionValue(view2, "dividerH6");
            ViewExtensionsKt.show$default(view2, false, 1, (Object) null);
            View view3 = graphV2Binding.dividerH7;
            Intrinsics.checkNotNullExpressionValue(view3, "dividerH7");
            ViewExtensionsKt.show$default(view3, false, 1, (Object) null);
            graphV2Binding.legendHum1.setText(concatLegendStr(R.string.humidity_level_moist, "51-80%"));
            graphV2Binding.legendHum2.setText(concatLegendStr(R.string.humidity_level_ideal, "30-50%"));
            graphV2Binding.legendHum3.setText(concatLegendStr(R.string.humidity_level_dry, "0-29%"));
            TextView textView = graphV2Binding.legendHum1;
            Intrinsics.checkNotNullExpressionValue(textView, "legendHum1");
            TextView textView2 = graphV2Binding.legendHum2;
            Intrinsics.checkNotNullExpressionValue(textView2, "legendHum2");
            TextView textView3 = graphV2Binding.legendHum3;
            Intrinsics.checkNotNullExpressionValue(textView3, "legendHum3");
            applyRangeContentDesp(textView, textView2, textView3);
        } else if (dataType2 instanceof DataType.TMP) {
            View view4 = graphV2Binding.dividerH5;
            Intrinsics.checkNotNullExpressionValue(view4, "dividerH5");
            ViewExtensionsKt.hide(view4);
            View view5 = graphV2Binding.dividerH6;
            Intrinsics.checkNotNullExpressionValue(view5, "dividerH6");
            ViewExtensionsKt.hide(view5);
            View view6 = graphV2Binding.dividerH7;
            Intrinsics.checkNotNullExpressionValue(view6, "dividerH7");
            ViewExtensionsKt.hide(view6);
            if (((DataType.TMP) dataType2).isCelsius()) {
                graphV2Binding.labelYTmp1.setText("40℃");
                graphV2Binding.labelYTmp2.setText("30℃");
                graphV2Binding.labelYTmp3.setText("20℃");
                graphV2Binding.labelYTmp4.setText("10℃");
                graphV2Binding.labelYTmp5.setText("0℃");
                graphV2Binding.labelYTmp6.setText("-10℃");
            } else {
                graphV2Binding.labelYTmp1.setText("104℉");
                graphV2Binding.labelYTmp2.setText("86℉");
                graphV2Binding.labelYTmp3.setText("68℉");
                graphV2Binding.labelYTmp4.setText("50℉");
                graphV2Binding.labelYTmp5.setText("32℉");
                graphV2Binding.labelYTmp6.setText("14℉");
            }
        } else if (dataType2 instanceof DataType.AQI) {
            View view7 = graphV2Binding.dividerH5;
            Intrinsics.checkNotNullExpressionValue(view7, "dividerH5");
            ViewExtensionsKt.hide(view7);
            View view8 = graphV2Binding.dividerH6;
            Intrinsics.checkNotNullExpressionValue(view8, "dividerH6");
            ViewExtensionsKt.hide(view8);
            View view9 = graphV2Binding.dividerH7;
            Intrinsics.checkNotNullExpressionValue(view9, "dividerH7");
            ViewExtensionsKt.hide(view9);
            double[] airRatingsFor = IndoorAirRatingRanges.Companion.instance(dataType2.getDevice()).airRatingsFor(((DataType.AQI) dataType2).getSensorType());
            Collection arrayList = new ArrayList(airRatingsFor.length);
            for (double d : airRatingsFor) {
                arrayList.add(Integer.valueOf((int) d));
            }
            List list = (List) arrayList;
            String str = "0-" + ((Number) list.get(0)).intValue();
            StringBuilder sb = new StringBuilder();
            sb.append(((Number) list.get(0)).intValue() + 1);
            sb.append('-');
            sb.append(((Number) list.get(1)).intValue());
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(((Number) list.get(1)).intValue() + 1);
            sb3.append('-');
            sb3.append(((Number) list.get(2)).intValue());
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(((Number) list.get(2)).intValue() + 1);
            sb5.append('-');
            sb5.append(((Number) list.get(3)).intValue());
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(((Number) list.get(3)).intValue() + 1);
            sb7.append('-');
            sb7.append(((Number) list.get(4)).intValue());
            String sb8 = sb7.toString();
            graphV2Binding.labelYAqi5.setText(str);
            graphV2Binding.labelYAqi4.setText(sb2);
            graphV2Binding.labelYAqi3.setText(sb4);
            graphV2Binding.labelYAqi2.setText(sb6);
            graphV2Binding.labelYAqi1.setText(sb8);
            graphV2Binding.legendAqi1.setText(concatLegendStr(R.string.excellent, str));
            graphV2Binding.legendAqi2.setText(concatLegendStr(R.string.good, sb2));
            graphV2Binding.legendAqi3.setText(concatLegendStr(R.string.moderate, sb4));
            graphV2Binding.legendAqi4.setText(concatLegendStr(R.string.polluted, sb6));
            graphV2Binding.legendAqi5.setText(concatLegendStr(R.string.vpolluted, sb8));
            TextView textView4 = graphV2Binding.labelYAqi5;
            Intrinsics.checkNotNullExpressionValue(textView4, "labelYAqi5");
            TextView textView5 = graphV2Binding.labelYAqi4;
            Intrinsics.checkNotNullExpressionValue(textView5, "labelYAqi4");
            TextView textView6 = graphV2Binding.labelYAqi3;
            Intrinsics.checkNotNullExpressionValue(textView6, "labelYAqi3");
            TextView textView7 = graphV2Binding.labelYAqi2;
            Intrinsics.checkNotNullExpressionValue(textView7, "labelYAqi2");
            TextView textView8 = graphV2Binding.labelYAqi1;
            Intrinsics.checkNotNullExpressionValue(textView8, "labelYAqi1");
            applyRangeContentDesp(textView4, textView5, textView6, textView7, textView8);
            TextView textView9 = graphV2Binding.legendAqi1;
            Intrinsics.checkNotNullExpressionValue(textView9, "legendAqi1");
            TextView textView10 = graphV2Binding.legendAqi2;
            Intrinsics.checkNotNullExpressionValue(textView10, "legendAqi2");
            TextView textView11 = graphV2Binding.legendAqi3;
            Intrinsics.checkNotNullExpressionValue(textView11, "legendAqi3");
            TextView textView12 = graphV2Binding.legendAqi4;
            Intrinsics.checkNotNullExpressionValue(textView12, "legendAqi4");
            TextView textView13 = graphV2Binding.legendAqi5;
            Intrinsics.checkNotNullExpressionValue(textView13, "legendAqi5");
            applyRangeContentDesp(textView9, textView10, textView11, textView12, textView13);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Group group = graphV2Binding.groupHum;
        Intrinsics.checkNotNullExpressionValue(group, "groupHum");
        ViewExtensionsKt.show(group, z);
        Group group2 = graphV2Binding.groupTmp;
        Intrinsics.checkNotNullExpressionValue(group2, "groupTmp");
        ViewExtensionsKt.show(group2, dataType2 instanceof DataType.TMP);
        Group group3 = graphV2Binding.groupAqi;
        Intrinsics.checkNotNullExpressionValue(group3, "groupAqi");
        ViewExtensionsKt.show(group3, dataType2 instanceof DataType.AQI);
        return true;
    }

    public final void applyRangeContentDesp(TextView... textViewArr) {
        Intrinsics.checkNotNullParameter(textViewArr, "textViews");
        String str = " " + getContext().getString(R.string.infix_to) + TokenParser.SP;
        for (TextView textView : textViewArr) {
            textView.setContentDescription(StringsKt.replace$default(textView.getText().toString(), GigyaService.DEFAULT_USER_NAME, str, false, 4, (Object) null));
        }
    }

    public final String concatLegendStr(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "range");
        return getResources().getString(i) + " (" + str + ')';
    }

    public final void setTimeScale(ChartTimeScale chartTimeScale) {
        Intrinsics.checkNotNullParameter(chartTimeScale, WsDefinition.SCALE);
        notifyChartScaleChanged$default(this, chartTimeScale, (Entry) null, 2, (Object) null);
    }

    public final void setOnTimeScaleChangedListener(Function1<? super ChartTimeScale, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onTimeScaleChangedListener");
        this.onTimeScaleChangedListener = function1;
    }

    public final void setOnDatapointSelectedListener(Function1<? super SimpleDatapoint, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onDatapointSelectedListener");
        this.onDatapointSelectedListener = function1;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setupChart();
        showProgress(true);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.chart.setOnChartGestureListener((OnChartGestureListener) null);
        CoroutineScopeKt.cancel$default(this.scope, (CancellationException) null, 1, (Object) null);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.firstDraw) {
            this.firstDraw = false;
            setupXAxisLines$default(this, false, 1, (Object) null);
        }
    }

    private final void setupChart() {
        LineChart lineChart = this.chart;
        float dpToPx = TypedValueCompat.dpToPx(1.0f, lineChart.getResources().getDisplayMetrics());
        lineChart.setViewPortOffsets(0.0f, ((float) 40) * dpToPx, 0.0f, ((float) 12) * dpToPx);
        lineChart.setDrawGridBackground(false);
        lineChart.getDescription().setEnabled(false);
        lineChart.getLegend().setEnabled(false);
        lineChart.setTouchEnabled(true);
        lineChart.setDragDecelerationEnabled(true);
        lineChart.setDragEnabled(true);
        lineChart.setDragXEnabled(true);
        lineChart.setDragYEnabled(false);
        lineChart.setPinchZoom(true);
        lineChart.setDoubleTapToZoomEnabled(false);
        lineChart.setScaleEnabled(false);
        lineChart.setScaleXEnabled(false);
        lineChart.setScaleYEnabled(false);
        lineChart.setAutoScaleMinMaxEnabled(false);
        lineChart.setNoDataText("");
        lineChart.setClipValuesToContent(true);
        lineChart.setDragDecelerationFrictionCoef(0.85f);
        lineChart.setDrawMarkers(true);
        MarkerView markerView = new MarkerView(lineChart.getContext(), com.blueair.graph.R.layout.markerview_dot_v2);
        float f = -markerView.getResources().getDimension(R.dimen.chart_marker_dot_offset);
        markerView.setOffset(f, f);
        lineChart.setEndMarker(markerView);
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setAxisMinimum(-518400.0f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawLimitLinesBehindData(true);
        xAxis.setDrawLabels(false);
        xAxis.setGranularity(1.0f);
        YAxis axisLeft = lineChart.getAxisLeft();
        axisLeft.setDrawGridLines(false);
        axisLeft.setDrawAxisLine(false);
        axisLeft.setDrawLimitLinesBehindData(true);
        axisLeft.setDrawLabels(false);
        axisLeft.setSpaceTop(0.0f);
        axisLeft.setSpaceBottom(0.0f);
        axisLeft.setAxisMinimum(0.0f);
        axisLeft.setAxisMaximum(100.0f);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.setOnChartGestureListener(new GraphViewV2$setupChart$1$4(this));
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        ConstraintLayout constraintLayout = this.binding.clLegendAqi;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "clLegendAqi");
        ViewUtils.setAccessibilityDelegate$default(viewUtils, constraintLayout, Reflection.getOrCreateKotlinClass(ListView.class), (String) null, (Function2) null, 12, (Object) null);
        ViewUtils viewUtils2 = ViewUtils.INSTANCE;
        ConstraintLayout constraintLayout2 = this.binding.clLegendHum;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "clLegendHum");
        ViewUtils.setAccessibilityDelegate$default(viewUtils2, constraintLayout2, Reflection.getOrCreateKotlinClass(ListView.class), (String) null, (Function2) null, 12, (Object) null);
    }

    public final void showProgress(boolean z) {
        ProgressBlockerView progressBlockerView = this.binding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
        ViewExtensionsKt.show(progressBlockerView, z);
    }

    public final void updateHistoricalData(List<SimpleDatapoint> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        setData(list, false);
    }

    public final void updateRealTimeData(List<SimpleDatapoint> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        setData(list, true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.util.List<com.blueair.core.model.SimpleDatapoint>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setData(java.util.List<com.blueair.core.model.SimpleDatapoint> r8, boolean r9) {
        /*
            r7 = this;
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "setData: "
            r1.<init>(r2)
            int r2 = r8.size()
            r1.append(r2)
            java.lang.String r2 = ", "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r0.d(r1, r3)
            if (r9 == 0) goto L_0x005b
            r0 = r8
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x005b
            long r0 = r7.rawEndTime
            r3 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r3
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r8 = r8.iterator()
        L_0x003f:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L_0x0058
            java.lang.Object r4 = r8.next()
            r5 = r4
            com.blueair.core.model.SimpleDatapoint r5 = (com.blueair.core.model.SimpleDatapoint) r5
            long r5 = r5.getTimeInSeconds()
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 <= 0) goto L_0x003f
            r3.add(r4)
            goto L_0x003f
        L_0x0058:
            r8 = r3
            java.util.List r8 = (java.util.List) r8
        L_0x005b:
            if (r9 == 0) goto L_0x0068
            java.util.List<com.blueair.core.model.SimpleDatapoint> r9 = r7.rawDatapoint
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            if (r9 != 0) goto L_0x0068
            r2 = 1
        L_0x0068:
            r7.notifyChartDataChanged(r8, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.view.GraphViewV2.setData(java.util.List, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r9 = (com.github.mikephil.charting.data.Entry) kotlin.collections.CollectionsKt.lastOrNull(r8.entries);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void scaleAndCenter(com.github.mikephil.charting.data.Entry r9) {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x0008
        L_0x0002:
            float r9 = r9.getX()
        L_0x0006:
            r3 = r9
            goto L_0x0015
        L_0x0008:
            java.util.List<? extends com.github.mikephil.charting.data.Entry> r9 = r8.entries
            java.lang.Object r9 = kotlin.collections.CollectionsKt.lastOrNull(r9)
            com.github.mikephil.charting.data.Entry r9 = (com.github.mikephil.charting.data.Entry) r9
            if (r9 == 0) goto L_0x0013
            goto L_0x0002
        L_0x0013:
            r9 = 0
            goto L_0x0006
        L_0x0015:
            com.github.mikephil.charting.charts.LineChart r0 = r8.chart
            float r1 = r8.chartScale
            com.github.mikephil.charting.components.YAxis$AxisDependency r5 = com.github.mikephil.charting.components.YAxis.AxisDependency.RIGHT
            r6 = 0
            r2 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            r0.zoomAndCenterAnimated(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.view.GraphViewV2.scaleAndCenter(com.github.mikephil.charting.data.Entry):void");
    }

    private final void highlightEntry(Entry entry) {
        if (entry == null) {
            this.chart.highlightValues((Highlight[]) null);
            setHighlightedEntry((Entry) null);
            return;
        }
        scaleAndCenter(entry);
        this.chart.highlightValue(entry.getX(), 0);
        setHighlightedEntry(entry);
        post(new GraphViewV2$$ExternalSyntheticLambda0(this, entry));
        postDelayed(new GraphViewV2$$ExternalSyntheticLambda1(this, entry), 300);
    }

    /* access modifiers changed from: private */
    public static final void highlightEntry$lambda$16(GraphViewV2 graphViewV2, Entry entry) {
        graphViewV2.setChartMarker(entry);
    }

    /* access modifiers changed from: private */
    public static final void highlightEntry$lambda$17(GraphViewV2 graphViewV2, Entry entry) {
        graphViewV2.setScrollIndicatorPosition((((float) graphViewV2.chart.getWidth()) * (graphViewV2.maxX - entry.getX())) / RangesKt.coerceAtLeast(graphViewV2.maxX - graphViewV2.chart.getXAxis().getAxisMinimum(), 1.0f));
    }

    static /* synthetic */ void notifyChartScaleChanged$default(GraphViewV2 graphViewV2, ChartTimeScale chartTimeScale, Entry entry, int i, Object obj) {
        if ((i & 2) != 0) {
            entry = null;
        }
        graphViewV2.notifyChartScaleChanged(chartTimeScale, entry);
    }

    private final void notifyChartScaleChanged(ChartTimeScale chartTimeScale, Entry entry) {
        ChartTouchListener onTouchListener = this.chart.getOnTouchListener();
        BarLineChartTouchListener barLineChartTouchListener = onTouchListener instanceof BarLineChartTouchListener ? (BarLineChartTouchListener) onTouchListener : null;
        if (barLineChartTouchListener != null) {
            barLineChartTouchListener.stopDeceleration();
        }
        setTimeScaleField(chartTimeScale);
        updateScrollIndicatorWidth(this.chartScale);
        setupXAxisLines$default(this, false, 1, (Object) null);
        if (entry == null) {
            entry = (Entry) CollectionsKt.lastOrNull(this.entries);
        }
        highlightEntry(entry);
        Function1<? super ChartTimeScale, Unit> function1 = this.onTimeScaleChangedListener;
        if (function1 != null) {
            function1.invoke(chartTimeScale);
        }
    }

    private final void notifyChartDataChanged(List<SimpleDatapoint> list, boolean z) {
        ImageView imageView;
        Entry entry;
        Object obj;
        SimpleDatapoint simpleDatapoint = this.highlightedPoint;
        boolean z2 = simpleDatapoint == null || simpleDatapoint.getTimeInMillis() == this.rawEndTime;
        DataType dataType2 = this.dataType;
        if (dataType2 != null) {
            SimpleDatapoint simpleDatapoint2 = null;
            if (!z) {
                setRawDatapoint(list);
                if (list.isEmpty()) {
                    this.entries = CollectionsKt.emptyList();
                } else {
                    this.entries = Companion.convertToEntries(list, dataType2, this.zeroTime);
                    LineDataSet lineDataSet = new LineDataSet(this.entries, "");
                    lineDataSet.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
                    lineDataSet.setLineWidth(4.0f);
                    lineDataSet.setColors(this.graphLineGradient);
                    lineDataSet.setDrawValues(false);
                    lineDataSet.setDrawCircles(false);
                    lineDataSet.setDrawHighlightIndicators(false);
                    lineDataSet.setDrawEndMarker(true);
                    this.chart.setData(new LineData(lineDataSet));
                    SimpleDatapoint simpleDatapoint3 = this.highlightedPoint;
                    if (simpleDatapoint3 != null) {
                        Iterator it = this.entries.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            Object data = ((Entry) obj).getData();
                            SimpleDatapoint simpleDatapoint4 = data instanceof SimpleDatapoint ? (SimpleDatapoint) data : null;
                            if (simpleDatapoint4 != null && simpleDatapoint4.getTimeInSeconds() == simpleDatapoint3.getTimeInSeconds()) {
                                break;
                            }
                        }
                        entry = (Entry) obj;
                    } else {
                        entry = null;
                    }
                    notifyChartScaleChanged(this.timeScale, entry);
                    z2 = false;
                }
                setMaxX(0.0f);
            } else if (!list.isEmpty()) {
                setMaxX(this.maxX + ((float) ((((SimpleDatapoint) CollectionsKt.last(list)).getTimeInMillis() - this.rawEndTime) / ((long) 5000))));
                setRawDatapoint(CollectionsKt.plus(this.rawDatapoint, list));
                Iterable<Entry> access$convertToEntries = Companion.convertToEntries(list, dataType2, this.zeroTime);
                for (Entry addEntry : access$convertToEntries) {
                    ((LineData) this.chart.getData()).addEntry(addEntry, 0);
                }
                this.entries = CollectionsKt.plus(this.entries, access$convertToEntries);
                setupXAxisLines(true);
                this.chart.notifyDataSetChanged();
            }
            if (this.entries.isEmpty()) {
                showProgress(true);
                this.chart.clear();
                setScrollIndicatorPosition(0.0f);
                setHighlightedEntry((Entry) null);
            } else {
                IMarker endMarker = this.chart.getEndMarker();
                MarkerView markerView = endMarker instanceof MarkerView ? (MarkerView) endMarker : null;
                if (!(markerView == null || (imageView = (ImageView) markerView.findViewById(com.blueair.graph.R.id.marker_dot)) == null)) {
                    imageView.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), Companion.getLegendColor(dataType2, ((Entry) CollectionsKt.last(this.entries)).getY()))));
                }
                showProgress(false);
                this.chart.invalidate();
            }
            if (z2) {
                highlightEntry((Entry) CollectionsKt.lastOrNull(this.entries));
            }
            Entry entry2 = (Entry) CollectionsKt.lastOrNull(this.entries);
            Object data2 = entry2 != null ? entry2.getData() : null;
            if (data2 instanceof SimpleDatapoint) {
                simpleDatapoint2 = (SimpleDatapoint) data2;
            }
            if (simpleDatapoint2 != null) {
                this.chart.setContentDescription(buildContentDesp(simpleDatapoint2));
            }
        }
    }

    private final String buildContentDesp(SimpleDatapoint simpleDatapoint) {
        String str;
        int sensorTitle = getSensorTitle();
        DataType dataType2 = this.dataType;
        if (dataType2 instanceof DataType.TMP) {
            Intrinsics.checkNotNull(dataType2, "null cannot be cast to non-null type com.blueair.graph.view.GraphViewV2.DataType.TMP");
            if (((DataType.TMP) dataType2).isCelsius()) {
                str = getContext().getString(R.string.temperature_celsius);
            } else {
                str = getContext().getString(R.string.temperature_fahrenheit);
            }
        } else {
            str = "";
        }
        Intrinsics.checkNotNull(str);
        if (sensorTitle == 0) {
            return null;
        }
        String string = getContext().getString(R.string.sensor_graph_summary, new Object[]{getContext().getString(sensorTitle), String.valueOf((int) simpleDatapoint.getValue())});
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string + TokenParser.SP + str;
    }

    private final int getSensorTitle() {
        DataType dataType2 = this.dataType;
        SensorType sensorType = null;
        boolean z = (dataType2 != null ? dataType2.getDevice() : null) instanceof DevicePet20;
        DataType dataType3 = this.dataType;
        if (dataType3 != null) {
            sensorType = dataType3.toSensorType();
        }
        switch (sensorType == null ? -1 : WhenMappings.$EnumSwitchMapping$1[sensorType.ordinal()]) {
            case 1:
                return z ? R.string.pet_sensor_pm1 : R.string.pm1_title_short;
            case 2:
                return z ? R.string.pet_sensor_pm25 : R.string.pm25_title;
            case 3:
                return z ? R.string.pet_sensor_pm10 : R.string.pm10_title_short;
            case 4:
                return z ? R.string.pet_sensor_tvoc : R.string.voc_title_short;
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

    /* JADX WARNING: type inference failed for: r7v4, types: [com.blueair.graph.view.GraphViewV2$DataType] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setChartMarker(com.github.mikephil.charting.data.Entry r11) {
        /*
            r10 = this;
            java.lang.Object r0 = r11.getData()
            boolean r1 = r0 instanceof com.blueair.core.model.SimpleDatapoint
            r2 = 0
            if (r1 == 0) goto L_0x000c
            com.blueair.core.model.SimpleDatapoint r0 = (com.blueair.core.model.SimpleDatapoint) r0
            goto L_0x000d
        L_0x000c:
            r0 = r2
        L_0x000d:
            com.github.mikephil.charting.components.MarkerView r1 = new com.github.mikephil.charting.components.MarkerView
            android.content.Context r3 = r10.getContext()
            int r4 = com.blueair.graph.R.layout.markerview_label
            r1.<init>(r3, r4)
            int r3 = com.blueair.graph.R.id.marker_text
            android.view.View r3 = r1.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r4 = com.blueair.graph.R.id.dashed_line
            android.view.View r4 = r1.findViewById(r4)
            com.github.mikephil.charting.charts.LineChart r5 = r10.chart
            float r6 = r11.getX()
            float r11 = r11.getY()
            com.github.mikephil.charting.components.YAxis$AxisDependency r7 = com.github.mikephil.charting.components.YAxis.AxisDependency.LEFT
            com.github.mikephil.charting.utils.MPPointD r11 = r5.getPixelForValues(r6, r11, r7)
            android.content.res.Resources r5 = r10.getResources()
            int r6 = com.blueair.viewcore.R.dimen.chart_marker_dot_offset
            float r5 = r5.getDimension(r6)
            android.content.res.Resources r6 = r10.getResources()
            int r7 = com.blueair.viewcore.R.dimen.chart_marker_text_offset
            float r6 = r6.getDimension(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            android.view.ViewGroup$LayoutParams r7 = r4.getLayoutParams()
            if (r7 == 0) goto L_0x00fe
            com.github.mikephil.charting.charts.LineChart r8 = r10.chart
            com.github.mikephil.charting.utils.ViewPortHandler r8 = r8.getViewPortHandler()
            float r8 = r8.contentHeight()
            int r8 = kotlin.math.MathKt.roundToInt((float) r8)
            r7.height = r8
            r4.setLayoutParams(r7)
            if (r0 == 0) goto L_0x0071
            float r4 = r0.getValue()
            int r4 = kotlin.math.MathKt.roundToInt((float) r4)
            goto L_0x0072
        L_0x0071:
            r4 = 0
        L_0x0072:
            com.blueair.graph.view.GraphViewV2$DataType r7 = r10.dataType
            boolean r8 = r7 instanceof com.blueair.graph.view.GraphViewV2.DataType.TMP
            r9 = 1
            if (r8 == 0) goto L_0x0090
            boolean r8 = r7 instanceof com.blueair.graph.view.GraphViewV2.DataType.TMP
            if (r8 == 0) goto L_0x0080
            com.blueair.graph.view.GraphViewV2$DataType$TMP r7 = (com.blueair.graph.view.GraphViewV2.DataType.TMP) r7
            goto L_0x0081
        L_0x0080:
            r7 = r2
        L_0x0081:
            if (r7 == 0) goto L_0x008a
            boolean r7 = r7.isCelsius()
            if (r7 != r9) goto L_0x008a
            goto L_0x0090
        L_0x008a:
            com.blueair.core.model.DeviceData$Companion r7 = com.blueair.core.model.DeviceData.Companion
            int r4 = r7.convertCelsiusToFahrenheit((int) r4)
        L_0x0090:
            com.blueair.graph.view.GraphViewV2$DataType r7 = r10.dataType
            boolean r8 = r7 instanceof com.blueair.graph.view.GraphViewV2.DataType.HUM
            if (r8 == 0) goto L_0x0099
            java.lang.String r2 = "%"
            goto L_0x00b4
        L_0x0099:
            boolean r8 = r7 instanceof com.blueair.graph.view.GraphViewV2.DataType.TMP
            if (r8 == 0) goto L_0x00b2
            boolean r8 = r7 instanceof com.blueair.graph.view.GraphViewV2.DataType.TMP
            if (r8 == 0) goto L_0x00a4
            r2 = r7
            com.blueair.graph.view.GraphViewV2$DataType$TMP r2 = (com.blueair.graph.view.GraphViewV2.DataType.TMP) r2
        L_0x00a4:
            if (r2 == 0) goto L_0x00af
            boolean r2 = r2.isCelsius()
            if (r2 != 0) goto L_0x00af
            java.lang.String r2 = "℉"
            goto L_0x00b4
        L_0x00af:
            java.lang.String r2 = "℃"
            goto L_0x00b4
        L_0x00b2:
            java.lang.String r2 = ""
        L_0x00b4:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r4)
            r7.append(r2)
            java.lang.String r2 = r7.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.setText(r2)
            double r7 = r11.y
            float r2 = (float) r7
            float r2 = r2 - r6
            float r2 = r2 - r5
            r3.setTranslationY(r2)
            float r2 = -r5
            double r3 = r11.y
            float r11 = (float) r3
            float r11 = -r11
            r1.setOffset(r2, r11)
            com.github.mikephil.charting.charts.LineChart r11 = r10.chart
            com.github.mikephil.charting.components.IMarker r1 = (com.github.mikephil.charting.components.IMarker) r1
            r11.setMarker(r1)
            if (r0 == 0) goto L_0x00fd
            com.blueair.graph.databinding.GraphV2Binding r11 = r10.binding
            android.widget.TextView r11 = r11.timeLabel
            com.blueair.graph.utils.GraphUtils r1 = com.blueair.graph.utils.GraphUtils.INSTANCE
            long r2 = r0.getTimeInMillis()
            android.content.Context r0 = r10.getContext()
            java.lang.String r4 = "getContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            java.lang.String r0 = r1.getStringDate(r2, r0, r9)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r11.setText(r0)
        L_0x00fd:
            return
        L_0x00fe:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams"
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.view.GraphViewV2.setChartMarker(com.github.mikephil.charting.data.Entry):void");
    }

    /* access modifiers changed from: private */
    public final void highlightCenterEntry() {
        Entry entryForXValue;
        if (!this.entries.isEmpty()) {
            LineChart lineChart = this.chart;
            MPPointD valuesByTouchPoint = lineChart.getValuesByTouchPoint(lineChart.getViewPortHandler().contentLeft(), this.chart.getViewPortHandler().contentBottom(), this.chart.getAxisLeft().getAxisDependency());
            LineChart lineChart2 = this.chart;
            this.chart.highlightValue((float) (valuesByTouchPoint.x + ((lineChart2.getValuesByTouchPoint(lineChart2.getViewPortHandler().contentRight(), this.chart.getViewPortHandler().contentBottom(), this.chart.getAxisLeft().getAxisDependency()).x - valuesByTouchPoint.x) / ((double) 2))), 0);
            Highlight[] highlighted = this.chart.getHighlighted();
            if (highlighted != null && highlighted.length != 0 && (entryForXValue = ((ILineDataSet) ((LineData) this.chart.getData()).getDataSets().get(0)).getEntryForXValue(highlighted[0].getX(), highlighted[0].getY())) != null) {
                setHighlightedEntry(entryForXValue);
                setChartMarker(entryForXValue);
            }
        }
    }

    static /* synthetic */ void setupXAxisLines$default(GraphViewV2 graphViewV2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        graphViewV2.setupXAxisLines(z);
    }

    private final void setupXAxisLines(boolean z) {
        if (!this.firstDraw) {
            this.xAxisLineJob = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new GraphViewV2$setupXAxisLines$1(this.xAxisLineJob, z, this, (Continuation<? super GraphViewV2$setupXAxisLines$1>) null), 3, (Object) null);
        }
    }

    private final void updateScrollIndicatorWidth(float f) {
        float coerceAtLeast = (RangesKt.coerceAtLeast(11.0f - f, 1.0f) / 11.0f) * ((float) this.scrollIndicatorTrack.getWidth());
        this.scrollIndicator.getLayoutParams().width = MathKt.roundToInt(coerceAtLeast);
        this.scrollIndicator.requestLayout();
        updateScrollIndicatorPosition(MathKt.roundToInt(coerceAtLeast));
    }

    static /* synthetic */ void updateScrollIndicatorPosition$default(GraphViewV2 graphViewV2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = graphViewV2.scrollIndicator.getWidth();
        }
        graphViewV2.updateScrollIndicatorPosition(i);
    }

    private final void updateScrollIndicatorPosition(int i) {
        this.scrollIndicator.setX(RangesKt.coerceIn(1.0f - (this.scrollIndicatorPosition / ((float) this.chart.getWidth())), 0.0f, 1.0f) * ((float) (this.scrollIndicatorTrack.getWidth() - i)));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.chart.getViewPortHandler().setDragOffsetX(Utils.convertPixelsToDp(((float) this.chart.getWidth()) / 2.0f));
    }
}
