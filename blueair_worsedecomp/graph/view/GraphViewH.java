package com.blueair.graph.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
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
import com.foobot.liblabclient.core.WsDefinition;
import com.github.mikephil.charting.charts.LineChart;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\u0018\u0000 r2\u00020\u0001:\u0002qrB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"H\u0002J\u0016\u0010H\u001a\b\u0012\u0004\u0012\u00020\n0\u001b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u0013J\u001a\u0010L\u001a\u00020<2\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010O\u001a\u0004\u0018\u00010PJ\u000e\u0010Q\u001a\u00020<2\u0006\u0010R\u001a\u00020(J)\u0010S\u001a\u00020<2!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110(¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(R\u0012\u0004\u0012\u00020<0;J+\u0010T\u001a\u00020<2#\u0010=\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020<0;J\b\u0010U\u001a\u00020<H\u0014J\b\u0010V\u001a\u00020<H\u0014J\b\u0010W\u001a\u00020<H\u0002J\u000e\u0010X\u001a\u00020<2\u0006\u0010X\u001a\u00020JJ\u0014\u0010Y\u001a\u00020<2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u0014\u0010[\u001a\u00020<2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u001e\u0010\\\u001a\u00020<2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010]\u001a\u00020JH\u0002J\u0012\u0010^\u001a\u00020<2\b\u0010_\u001a\u0004\u0018\u00010$H\u0002J\u0012\u0010`\u001a\u00020<2\b\u0010_\u001a\u0004\u0018\u00010$H\u0002J\u001c\u0010a\u001a\u00020<2\u0006\u0010R\u001a\u00020(2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010$H\u0002J\u001e\u0010b\u001a\u00020<2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010c\u001a\u00020JH\u0002J\u0010\u0010d\u001a\u00020<2\u0006\u0010_\u001a\u00020$H\u0002J\b\u0010e\u001a\u00020<H\u0002J\b\u0010f\u001a\u00020<H\u0002J\u0010\u0010g\u001a\u00020<2\u0006\u0010h\u001a\u00020\"H\u0002J\u0012\u0010i\u001a\u00020<2\b\b\u0002\u0010j\u001a\u00020\nH\u0002J0\u0010k\u001a\u00020<2\u0006\u0010l\u001a\u00020J2\u0006\u0010m\u001a\u00020\n2\u0006\u0010n\u001a\u00020\n2\u0006\u0010o\u001a\u00020\n2\u0006\u0010p\u001a\u00020\nH\u0014R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R*\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\"@BX\u000e¢\u0006\b\n\u0000\"\u0004\b&\u0010'R$\u0010)\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020(@CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u001e\u00108\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\"@BX\u000e¢\u0006\b\n\u0000\"\u0004\b9\u0010'R\u001c\u0010:\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020<\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R-\u0010=\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020<\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R(\u0010B\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001c@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020\n0\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Lcom/blueair/graph/view/GraphViewH;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "xAxisLineJob", "Lkotlinx/coroutines/Job;", "value", "Lcom/blueair/graph/view/GraphViewH$DataType;", "dataType", "getDataType", "()Lcom/blueair/graph/view/GraphViewH$DataType;", "rawStartTime", "", "rawEndTime", "zeroTime", "", "Lcom/blueair/core/model/SimpleDatapoint;", "rawDatapoint", "setRawDatapoint", "(Ljava/util/List;)V", "getTimestampFromEntryX", "x", "", "entries", "Lcom/github/mikephil/charting/data/Entry;", "maxX", "setMaxX", "(F)V", "Lcom/blueair/graph/utils/ChartTimeScale;", "timeScale", "getTimeScale", "()Lcom/blueair/graph/utils/ChartTimeScale;", "setTimeScaleField", "(Lcom/blueair/graph/utils/ChartTimeScale;)V", "chartScale", "binding", "Lcom/blueair/graph/databinding/GraphHBinding;", "chart", "Lcom/github/mikephil/charting/charts/LineChart;", "scrollIndicatorTrack", "Landroid/widget/FrameLayout;", "scrollIndicator", "Landroid/view/View;", "scrollIndicatorPreviousDx", "scrollIndicatorPosition", "setScrollIndicatorPosition", "onTimeScaleChangedListener", "Lkotlin/Function1;", "", "onDatapointSelectedListener", "Lkotlin/ParameterName;", "name", "datapoint", "highlightedEntry", "highlightedPoint", "getHighlightedPoint", "()Lcom/blueair/core/model/SimpleDatapoint;", "setHighlightedPoint", "(Lcom/blueair/core/model/SimpleDatapoint;)V", "graphLineGradient", "getGradient", "setDataType", "", "type", "setTitle", "title", "", "onClickListener", "Landroid/view/View$OnClickListener;", "setTimeScale", "scale", "setOnTimeScaleChangedListener", "setOnDatapointSelectedListener", "onAttachedToWindow", "onDetachedFromWindow", "setupChart", "showProgress", "updateHistoricalData", "data", "updateRealTimeData", "setData", "isRealTime", "scaleAndCenter", "entry", "highlightEntry", "notifyChartScaleChanged", "notifyChartDataChanged", "isAppend", "setChartMarker", "highlightCenterEntry", "setupXAxisLines", "updateScrollIndicatorWidth", "chartScaleX", "updateScrollIndicatorPosition", "indicatorWidth", "onLayout", "changed", "left", "top", "right", "bottom", "DataType", "Companion", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GraphViewH.kt */
public final class GraphViewH extends ConstraintLayout {
    private static final int BLOCK_COUNT = 3;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int DIVIDER_LINE_COLOR = R.color.gainsboro;
    /* access modifiers changed from: private */
    public static final int DIVIDER_TEXT_COLOR = R.color.colorPrimaryText;
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
    private final GraphHBinding binding;
    /* access modifiers changed from: private */
    public final LineChart chart;
    private float chartScale = 240.0f;
    private DataType dataType;
    private List<? extends Entry> entries = CollectionsKt.emptyList();
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
    private ChartTimeScale timeScale = ChartTimeScale.DAY;
    private Job xAxisLineJob;
    /* access modifiers changed from: private */
    public long zeroTime;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GraphViewH.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.graph.utils.ChartTimeScale[] r0 = com.blueair.graph.utils.ChartTimeScale.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.graph.utils.ChartTimeScale r1 = com.blueair.graph.utils.ChartTimeScale.DAY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.graph.utils.ChartTimeScale r1 = com.blueair.graph.utils.ChartTimeScale.WEEK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.graph.utils.ChartTimeScale r1 = com.blueair.graph.utils.ChartTimeScale.MONTH     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.view.GraphViewH.WhenMappings.<clinit>():void");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0003\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/blueair/graph/view/GraphViewH$DataType;", "", "device", "Lcom/blueair/core/model/HasSensorData;", "<init>", "(Lcom/blueair/core/model/HasSensorData;)V", "getDevice", "()Lcom/blueair/core/model/HasSensorData;", "toSensorType", "Lcom/blueair/core/model/SensorType;", "equals", "", "other", "HUM", "TMP", "AQI", "Lcom/blueair/graph/view/GraphViewH$DataType$AQI;", "Lcom/blueair/graph/view/GraphViewH$DataType$HUM;", "Lcom/blueair/graph/view/GraphViewH$DataType$TMP;", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GraphViewH.kt */
    public static abstract class DataType {
        private final HasSensorData device;

        public /* synthetic */ DataType(HasSensorData hasSensorData, DefaultConstructorMarker defaultConstructorMarker) {
            this(hasSensorData);
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/graph/view/GraphViewH$DataType$HUM;", "Lcom/blueair/graph/view/GraphViewH$DataType;", "device", "Lcom/blueair/core/model/HasSensorData;", "<init>", "(Lcom/blueair/core/model/HasSensorData;)V", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: GraphViewH.kt */
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

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lcom/blueair/graph/view/GraphViewH$DataType$TMP;", "Lcom/blueair/graph/view/GraphViewH$DataType;", "device", "Lcom/blueair/core/model/HasSensorData;", "isCelsius", "", "<init>", "(Lcom/blueair/core/model/HasSensorData;Z)V", "()Z", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: GraphViewH.kt */
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

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/blueair/graph/view/GraphViewH$DataType$AQI;", "Lcom/blueair/graph/view/GraphViewH$DataType;", "device", "Lcom/blueair/core/model/HasSensorData;", "sensorType", "Lcom/blueair/core/model/SensorType;", "<init>", "(Lcom/blueair/core/model/HasSensorData;Lcom/blueair/core/model/SensorType;)V", "getSensorType", "()Lcom/blueair/core/model/SensorType;", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: GraphViewH.kt */
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

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015*\b\u0012\u0004\u0012\u00020\u00170\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0007H\u0002J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/blueair/graph/view/GraphViewH$Companion;", "", "<init>", "()V", "X_FACTOR", "", "ONE_DAY_IN_MILLS", "", "ONE_WEEK_IN_MILLS", "ONE_MONTH_IN_MILLS", "ONE_DAY_IN_X", "", "ONE_WEEK_IN_X", "ONE_MONTH_IN_X", "BLOCK_COUNT", "SCALE_MONTH", "SCALE_WEEK", "SCALE_DAY", "DIVIDER_TEXT_COLOR", "DIVIDER_LINE_COLOR", "convertToEntries", "", "Lcom/github/mikephil/charting/data/Entry;", "Lcom/blueair/core/model/SimpleDatapoint;", "type", "Lcom/blueair/graph/view/GraphViewH$DataType;", "zeroTime", "getLegendColor", "value", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GraphViewH.kt */
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
            int i;
            float f2;
            float f3;
            float f4;
            int i2;
            float f5;
            float f6;
            DataType dataType2 = dataType;
            long j2 = j;
            if (dataType2 instanceof DataType.HUM) {
                Iterable<SimpleDatapoint> iterable = list;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (SimpleDatapoint simpleDatapoint : iterable) {
                    if (simpleDatapoint.getValue() <= 10.0f) {
                        f6 = (simpleDatapoint.getValue() * ((float) 5)) / ((float) 3);
                    } else if (simpleDatapoint.getValue() <= 70.0f) {
                        float f7 = (float) 10;
                        f6 = (((simpleDatapoint.getValue() - f7) * f7) / ((float) 9)) + 16.666666f;
                    } else {
                        f6 = (((simpleDatapoint.getValue() - ((float) 70)) * ((float) 5)) / ((float) 9)) + 83.333336f;
                    }
                    arrayList.add(new Entry(convertToEntries$getX(j2, simpleDatapoint), f6, (Object) simpleDatapoint));
                }
                return (List) arrayList;
            } else if (dataType2 instanceof DataType.TMP) {
                Iterable<SimpleDatapoint> iterable2 = list;
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                for (SimpleDatapoint simpleDatapoint2 : iterable2) {
                    if (!((DataType.TMP) dataType2).isCelsius()) {
                        float convertCelsiusToFahrenheit = DeviceData.Companion.convertCelsiusToFahrenheit(simpleDatapoint2.getValue());
                        if (convertCelsiusToFahrenheit <= 32.0f) {
                            f5 = (convertCelsiusToFahrenheit + ((float) 40)) * ((float) 25);
                            i2 = AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR;
                        } else if (convertCelsiusToFahrenheit <= 104.0f) {
                            f4 = (convertCelsiusToFahrenheit - ((float) 32)) * ((float) 25);
                            f3 = (float) 27;
                            f = (f4 / f3) + 16.666666f;
                            arrayList2.add(new Entry(convertToEntries$getX(j2, simpleDatapoint2), f, (Object) simpleDatapoint2));
                        } else {
                            f2 = (convertCelsiusToFahrenheit - ((float) 104)) * ((float) 25);
                            i = 162;
                            f = (f2 / ((float) i)) + 83.333336f;
                            arrayList2.add(new Entry(convertToEntries$getX(j2, simpleDatapoint2), f, (Object) simpleDatapoint2));
                        }
                    } else if (simpleDatapoint2.getValue() <= 0.0f) {
                        f5 = (simpleDatapoint2.getValue() + ((float) 40)) * ((float) 5);
                        i2 = 12;
                    } else if (simpleDatapoint2.getValue() <= 40.0f) {
                        f4 = simpleDatapoint2.getValue() * ((float) 5);
                        f3 = (float) 3;
                        f = (f4 / f3) + 16.666666f;
                        arrayList2.add(new Entry(convertToEntries$getX(j2, simpleDatapoint2), f, (Object) simpleDatapoint2));
                    } else {
                        f2 = (simpleDatapoint2.getValue() - ((float) 40)) * ((float) 5);
                        i = 18;
                        f = (f2 / ((float) i)) + 83.333336f;
                        arrayList2.add(new Entry(convertToEntries$getX(j2, simpleDatapoint2), f, (Object) simpleDatapoint2));
                    }
                    f = f5 / ((float) i2);
                    arrayList2.add(new Entry(convertToEntries$getX(j2, simpleDatapoint2), f, (Object) simpleDatapoint2));
                }
                return (List) arrayList2;
            } else if (dataType2 instanceof DataType.AQI) {
                DataType.AQI aqi = (DataType.AQI) dataType2;
                double[] airRatingsFor = IndoorAirRatingRanges.Companion.instance(dataType2.getDevice()).airRatingsFor(aqi.getSensorType());
                Iterable<SimpleDatapoint> iterable3 = list;
                Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable3, 10));
                for (SimpleDatapoint simpleDatapoint3 : iterable3) {
                    arrayList3.add(new Entry(convertToEntries$getX(j2, simpleDatapoint3), (float) MpChartUtils.getScaledValueForChart$default(MpChartUtils.INSTANCE, simpleDatapoint3.getValue(), aqi.getSensorType(), airRatingsFor, false, 8, (Object) null), (Object) simpleDatapoint3));
                }
                return (List) arrayList3;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }

        /* access modifiers changed from: private */
        public final int getLegendColor(DataType dataType, float f) {
            if (dataType instanceof DataType.HUM) {
                if (f < 38.88889f) {
                    return R.color.color_vpolluted;
                }
                if (f <= 61.11111f) {
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
    public GraphViewH(Context context) {
        super(context);
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        GraphHBinding inflate = GraphHBinding.inflate(LayoutInflater.from(getContext()), this, true);
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
        RadioGroup radioGroup = inflate.radioGroupTimeScale;
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.timeScale.ordinal()];
        if (i2 == 1) {
            i = com.blueair.graph.R.id.rb_day;
        } else if (i2 == 2) {
            i = com.blueair.graph.R.id.rb_week;
        } else if (i2 == 3) {
            i = com.blueair.graph.R.id.rb_month;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        radioGroup.check(i);
        inflate.radioGroupTimeScale.setOnCheckedChangeListener(new GraphViewH$$ExternalSyntheticLambda0(this, inflate.rbDay.getElevation()));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraphViewH(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        GraphHBinding inflate = GraphHBinding.inflate(LayoutInflater.from(getContext()), this, true);
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
        RadioGroup radioGroup = inflate.radioGroupTimeScale;
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.timeScale.ordinal()];
        if (i2 == 1) {
            i = com.blueair.graph.R.id.rb_day;
        } else if (i2 == 2) {
            i = com.blueair.graph.R.id.rb_week;
        } else if (i2 == 3) {
            i = com.blueair.graph.R.id.rb_month;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        radioGroup.check(i);
        inflate.radioGroupTimeScale.setOnCheckedChangeListener(new GraphViewH$$ExternalSyntheticLambda0(this, inflate.rbDay.getElevation()));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraphViewH(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        Intrinsics.checkNotNullParameter(context, "context");
        GraphHBinding inflate = GraphHBinding.inflate(LayoutInflater.from(getContext()), this, true);
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
        RadioGroup radioGroup = inflate.radioGroupTimeScale;
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.timeScale.ordinal()];
        if (i3 == 1) {
            i2 = com.blueair.graph.R.id.rb_day;
        } else if (i3 == 2) {
            i2 = com.blueair.graph.R.id.rb_week;
        } else if (i3 == 3) {
            i2 = com.blueair.graph.R.id.rb_month;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        radioGroup.check(i2);
        inflate.radioGroupTimeScale.setOnCheckedChangeListener(new GraphViewH$$ExternalSyntheticLambda0(this, inflate.rbDay.getElevation()));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraphViewH(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        GraphHBinding inflate = GraphHBinding.inflate(LayoutInflater.from(getContext()), this, true);
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
        RadioGroup radioGroup = inflate.radioGroupTimeScale;
        int i4 = WhenMappings.$EnumSwitchMapping$0[this.timeScale.ordinal()];
        if (i4 == 1) {
            i3 = com.blueair.graph.R.id.rb_day;
        } else if (i4 == 2) {
            i3 = com.blueair.graph.R.id.rb_week;
        } else if (i4 == 3) {
            i3 = com.blueair.graph.R.id.rb_month;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        radioGroup.check(i3);
        inflate.radioGroupTimeScale.setOnCheckedChangeListener(new GraphViewH$$ExternalSyntheticLambda0(this, inflate.rbDay.getElevation()));
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

    private final List<Integer> getGradient(DataType dataType2) {
        List<Integer> arrayList = new ArrayList<>();
        if (dataType2 instanceof DataType.HUM) {
            int gradient$lambda$7$getColor = getGradient$lambda$7$getColor(this, R.color.color_moderate);
            for (int i = 0; i < 7; i++) {
                arrayList.add(Integer.valueOf(gradient$lambda$7$getColor));
            }
            int gradient$lambda$7$getColor2 = getGradient$lambda$7$getColor(this, R.color.color_good);
            for (int i2 = 0; i2 < 4; i2++) {
                arrayList.add(Integer.valueOf(gradient$lambda$7$getColor2));
            }
            int gradient$lambda$7$getColor3 = getGradient$lambda$7$getColor(this, R.color.color_vpolluted);
            for (int i3 = 0; i3 < 7; i3++) {
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

    private static final int getGradient$lambda$7$getColor(GraphViewH graphViewH, int i) {
        return ResourcesCompat.getColor(graphViewH.getResources(), i, graphViewH.getContext().getTheme());
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$9(GraphViewH graphViewH, float f, RadioGroup radioGroup, int i) {
        ChartTimeScale chartTimeScale;
        for (RadioButton radioButton : CollectionsKt.listOf(graphViewH.binding.rbDay, graphViewH.binding.rbWeek, graphViewH.binding.rbMonth)) {
            radioButton.setElevation(radioButton.getId() == i ? f : 0.0f);
        }
        if (i == com.blueair.graph.R.id.rb_day) {
            graphViewH.binding.rgSeparator1.setVisibility(4);
            graphViewH.binding.rgSeparator2.setVisibility(0);
            chartTimeScale = ChartTimeScale.DAY;
        } else if (i == com.blueair.graph.R.id.rb_week) {
            graphViewH.binding.rgSeparator1.setVisibility(4);
            graphViewH.binding.rgSeparator2.setVisibility(4);
            chartTimeScale = ChartTimeScale.WEEK;
        } else if (i == com.blueair.graph.R.id.rb_month) {
            graphViewH.binding.rgSeparator1.setVisibility(0);
            graphViewH.binding.rgSeparator2.setVisibility(4);
            chartTimeScale = ChartTimeScale.MONTH;
        } else {
            chartTimeScale = ChartTimeScale.DAY;
        }
        notifyChartScaleChanged$default(graphViewH, chartTimeScale, (Entry) null, 2, (Object) null);
    }

    public final boolean setDataType(DataType dataType2) {
        Intrinsics.checkNotNullParameter(dataType2, "type");
        if (Intrinsics.areEqual((Object) this.dataType, (Object) dataType2)) {
            return false;
        }
        this.dataType = dataType2;
        this.graphLineGradient = getGradient(dataType2);
        boolean z = dataType2 instanceof DataType.HUM;
        if (z) {
            View view = this.binding.dividerH5;
            Intrinsics.checkNotNullExpressionValue(view, "dividerH5");
            ViewExtensionsKt.show$default(view, false, 1, (Object) null);
        } else if (dataType2 instanceof DataType.TMP) {
            View view2 = this.binding.dividerH5;
            Intrinsics.checkNotNullExpressionValue(view2, "dividerH5");
            ViewExtensionsKt.show$default(view2, false, 1, (Object) null);
            if (((DataType.TMP) dataType2).isCelsius()) {
                GraphHBinding graphHBinding = this.binding;
                graphHBinding.labelYTmp2.setText("40℃");
                graphHBinding.labelYTmp3.setText("30℃");
                graphHBinding.labelYTmp4.setText("20℃");
                graphHBinding.labelYTmp5.setText("10℃");
                graphHBinding.labelYTmp6.setText("0℃");
            } else {
                GraphHBinding graphHBinding2 = this.binding;
                graphHBinding2.labelYTmp2.setText("104℉");
                graphHBinding2.labelYTmp3.setText("86℉");
                graphHBinding2.labelYTmp4.setText("68℉");
                graphHBinding2.labelYTmp5.setText("50℉");
                graphHBinding2.labelYTmp6.setText("32℉");
            }
        } else if (dataType2 instanceof DataType.AQI) {
            View view3 = this.binding.dividerH5;
            Intrinsics.checkNotNullExpressionValue(view3, "dividerH5");
            ViewExtensionsKt.hide(view3);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Group group = this.binding.groupHum;
        Intrinsics.checkNotNullExpressionValue(group, "groupHum");
        ViewExtensionsKt.show(group, z);
        Group group2 = this.binding.groupTmp;
        Intrinsics.checkNotNullExpressionValue(group2, "groupTmp");
        ViewExtensionsKt.show(group2, dataType2 instanceof DataType.TMP);
        Group group3 = this.binding.groupAqi;
        Intrinsics.checkNotNullExpressionValue(group3, "groupAqi");
        ViewExtensionsKt.show(group3, dataType2 instanceof DataType.AQI);
        return true;
    }

    public final void setTitle(String str, View.OnClickListener onClickListener) {
        if (str == null) {
            FrameLayout frameLayout = this.binding.graphTitleContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "graphTitleContainer");
            ViewExtensionsKt.hide(frameLayout);
            return;
        }
        FrameLayout frameLayout2 = this.binding.graphTitleContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "graphTitleContainer");
        ViewExtensionsKt.show$default(frameLayout2, false, 1, (Object) null);
        this.binding.graphTitle.setText(str);
        if (onClickListener != null) {
            this.binding.graphTitle.setOnClickListener(onClickListener);
        }
    }

    public final void setTimeScale(ChartTimeScale chartTimeScale) {
        int i;
        Intrinsics.checkNotNullParameter(chartTimeScale, WsDefinition.SCALE);
        int i2 = WhenMappings.$EnumSwitchMapping$0[chartTimeScale.ordinal()];
        if (i2 == 1) {
            i = com.blueair.graph.R.id.rb_day;
        } else if (i2 == 2) {
            i = com.blueair.graph.R.id.rb_week;
        } else if (i2 == 3) {
            i = com.blueair.graph.R.id.rb_month;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (this.binding.radioGroupTimeScale.getCheckedRadioButtonId() == i) {
            notifyChartScaleChanged$default(this, chartTimeScale, (Entry) null, 2, (Object) null);
        } else {
            this.binding.radioGroupTimeScale.check(i);
        }
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

    private final void setupChart() {
        LineChart lineChart = this.chart;
        lineChart.setViewPortOffsets(0.0f, 0.0f, 0.0f, 0.0f);
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
        lineChart.setOnChartGestureListener(new GraphViewH$setupChart$1$3(this));
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
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.view.GraphViewH.setData(java.util.List, boolean):void");
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
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.view.GraphViewH.scaleAndCenter(com.github.mikephil.charting.data.Entry):void");
    }

    private final void highlightEntry(Entry entry) {
        if (entry == null) {
            this.chart.highlightValues((Highlight[]) null);
            this.highlightedEntry = null;
            setHighlightedPoint((SimpleDatapoint) null);
            return;
        }
        scaleAndCenter(entry);
        this.chart.highlightValue(entry.getX(), 0);
        post(new GraphViewH$$ExternalSyntheticLambda1(this, entry));
        postDelayed(new GraphViewH$$ExternalSyntheticLambda2(this, entry), 300);
    }

    /* access modifiers changed from: private */
    public static final void highlightEntry$lambda$17(GraphViewH graphViewH, Entry entry) {
        graphViewH.setChartMarker(entry);
    }

    /* access modifiers changed from: private */
    public static final void highlightEntry$lambda$18(GraphViewH graphViewH, Entry entry) {
        graphViewH.setScrollIndicatorPosition((((float) graphViewH.chart.getWidth()) * (graphViewH.maxX - entry.getX())) / RangesKt.coerceAtLeast(graphViewH.maxX - graphViewH.chart.getXAxis().getAxisMinimum(), 1.0f));
    }

    static /* synthetic */ void notifyChartScaleChanged$default(GraphViewH graphViewH, ChartTimeScale chartTimeScale, Entry entry, int i, Object obj) {
        if ((i & 2) != 0) {
            entry = null;
        }
        graphViewH.notifyChartScaleChanged(chartTimeScale, entry);
    }

    private final void notifyChartScaleChanged(ChartTimeScale chartTimeScale, Entry entry) {
        ChartTouchListener onTouchListener = this.chart.getOnTouchListener();
        BarLineChartTouchListener barLineChartTouchListener = onTouchListener instanceof BarLineChartTouchListener ? (BarLineChartTouchListener) onTouchListener : null;
        if (barLineChartTouchListener != null) {
            barLineChartTouchListener.stopDeceleration();
        }
        setTimeScaleField(chartTimeScale);
        updateScrollIndicatorWidth(this.chartScale);
        setupXAxisLines();
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
        Entry entry;
        Object obj;
        SimpleDatapoint simpleDatapoint = this.highlightedPoint;
        boolean z2 = simpleDatapoint == null || simpleDatapoint.getTimeInMillis() == this.rawEndTime;
        DataType dataType2 = this.dataType;
        if (dataType2 != null) {
            if (!z) {
                setRawDatapoint(list);
                if (list.isEmpty()) {
                    this.entries = CollectionsKt.emptyList();
                } else {
                    this.entries = Companion.convertToEntries(list, dataType2, this.zeroTime);
                    LineDataSet lineDataSet = new LineDataSet(this.entries, "");
                    lineDataSet.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
                    lineDataSet.setLineWidth(3.0f);
                    lineDataSet.setColors(this.graphLineGradient);
                    lineDataSet.setDrawValues(false);
                    lineDataSet.setDrawCircles(false);
                    lineDataSet.setDrawHighlightIndicators(false);
                    this.chart.setData(new LineData(lineDataSet));
                    Entry entry2 = this.highlightedEntry;
                    if (entry2 != null) {
                        Iterator it = this.entries.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            if (((Entry) obj).getX() == entry2.getX()) {
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
                this.chart.notifyDataSetChanged();
            }
            if (this.entries.isEmpty()) {
                showProgress(true);
                this.chart.clear();
                setScrollIndicatorPosition(0.0f);
                this.highlightedEntry = null;
                setHighlightedPoint((SimpleDatapoint) null);
            } else {
                showProgress(false);
                this.chart.invalidate();
            }
            if (z2) {
                highlightEntry((Entry) CollectionsKt.lastOrNull(this.entries));
            }
        }
    }

    private final void setChartMarker(Entry entry) {
        DataType dataType2 = this.dataType;
        if (dataType2 != null) {
            MarkerView markerView = new MarkerView(getContext(), com.blueair.graph.R.layout.markerview_dot_new);
            View findViewById = markerView.findViewById(com.blueair.graph.R.id.marker_dot);
            View findViewById2 = markerView.findViewById(com.blueair.graph.R.id.dashed_line);
            MPPointD pixelForValues = this.chart.getPixelForValues(entry.getX(), entry.getY(), YAxis.AxisDependency.LEFT);
            float dimension = getResources().getDimension(R.dimen.chart_marker_size_outdoor) / ((float) 2);
            Intrinsics.checkNotNull(findViewById2);
            ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = this.chart.getHeight();
                findViewById2.setLayoutParams(layoutParams);
                findViewById.setTranslationY(((float) pixelForValues.y) - dimension);
                findViewById.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), Companion.getLegendColor(dataType2, entry.getY()))));
                markerView.setOffset(-dimension, -((float) pixelForValues.y));
                this.chart.setMarker(markerView);
                this.highlightedEntry = entry;
                Object data = entry.getData();
                SimpleDatapoint simpleDatapoint = data instanceof SimpleDatapoint ? (SimpleDatapoint) data : null;
                if (simpleDatapoint != null) {
                    TextView textView = this.binding.timeLabel;
                    GraphUtils graphUtils = GraphUtils.INSTANCE;
                    long timeInMillis = simpleDatapoint.getTimeInMillis();
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    textView.setText(GraphUtils.getStringDate$default(graphUtils, timeInMillis, context, false, 4, (Object) null));
                    setHighlightedPoint(simpleDatapoint);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
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
                setChartMarker(entryForXValue);
            }
        }
    }

    private final void setupXAxisLines() {
        this.chart.getXAxis().removeAllLimitLines();
        this.xAxisLineJob = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new GraphViewH$setupXAxisLines$1(this.xAxisLineJob, this, (Continuation<? super GraphViewH$setupXAxisLines$1>) null), 3, (Object) null);
    }

    private final void updateScrollIndicatorWidth(float f) {
        float coerceAtLeast = (RangesKt.coerceAtLeast(11.0f - f, 1.0f) / 11.0f) * ((float) this.scrollIndicatorTrack.getWidth());
        this.scrollIndicator.getLayoutParams().width = MathKt.roundToInt(coerceAtLeast);
        this.scrollIndicator.requestLayout();
        updateScrollIndicatorPosition(MathKt.roundToInt(coerceAtLeast));
    }

    static /* synthetic */ void updateScrollIndicatorPosition$default(GraphViewH graphViewH, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = graphViewH.scrollIndicator.getWidth();
        }
        graphViewH.updateScrollIndicatorPosition(i);
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
