package com.blueair.graph.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.SimpleDatapoint;
import com.blueair.graph.databinding.GraphBinding;
import com.blueair.graph.utils.ChartTimeScale;
import com.blueair.graph.utils.DayAxisValueFormatter;
import com.blueair.graph.utils.GraphUiUtils;
import com.blueair.graph.utils.GraphUtils;
import com.blueair.graph.utils.YAxisValueFormatterOutdoor;
import com.blueair.graph.viewmodel.GraphState;
import com.blueair.graph.viewmodel.GraphViewModel;
import com.blueair.graph.viewmodel.ReversedResult;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.CustomConstraintLayoutNonNullState;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.flatcircle.viewhelper.ViewHelperUtil;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 ¹\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0006¹\u0001º\u0001»\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0007\u0010\u000eB)\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0007\u0010\u0010J\b\u0010\u0016\u001a\u00020\u0003H$J\b\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH&J\b\u0010y\u001a\u00020\u0018H\u0014J\b\u0010z\u001a\u00020\u0018H\u0014J\u0010\u0010{\u001a\u00020\u00182\u0006\u0010|\u001a\u00020}H\u0016J\u0018\u0010~\u001a\u00020\u00182\u0006\u0010N\u001a\u00020O2\b\b\u0002\u0010\u001a\u00020+J\u0010\u0010\u0001\u001a\u00020\u00182\u0007\u0010\u0001\u001a\u00020+J\u0011\u0010\u0001\u001a\u00020\u00182\b\u0010\u0001\u001a\u00030\u0001J\u0007\u0010\u0001\u001a\u00020\u0018J\u0016\u0010\u0001\u001a\u00020\u00182\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020e0dJ\t\u0010\u0001\u001a\u00020\u0018H\u0002J\u0012\u0010\u0001\u001a\u00020\u00182\u0007\u0010\u0001\u001a\u00020\u0002H\u0016J\u0012\u0010\u0001\u001a\u00020\u00182\u0007\u0010\u0001\u001a\u00020eH\u0002J\t\u0010\u0001\u001a\u00020\u0018H\u0002J\t\u0010\u0001\u001a\u00020\u0018H\u0002J%\u0010\u0001\u001a\u00020\u00182\u0006\u0010N\u001a\u00020O2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u001b\u0010\u0001\u001a\u00030\u00012\u0006\u0010u\u001a\u00020e2\u0007\u0010\u0001\u001a\u000201H\u0002J\u0013\u0010\u0001\u001a\u00020\u00182\b\u0010\u0001\u001a\u00030\u0001H\u0002J\t\u0010\u0001\u001a\u00020\u0018H\u0002J\u001b\u0010\u0001\u001a\u00020\u00182\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u001a\u00020+H\u0002J!\u0010\u0001\u001a\u00020\u00182\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J!\u0010\u0001\u001a\u00020\u00182\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J'\u0010 \u0001\u001a\u00020\u00182\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010¡\u0001\u001a\u00020e2\u0007\u0010¢\u0001\u001a\u00020eH\u0016J'\u0010£\u0001\u001a\u00020\u00182\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010¤\u0001\u001a\u00020e2\u0007\u0010¥\u0001\u001a\u00020eH\u0016J\u0015\u0010¦\u0001\u001a\u00020\u00182\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0015\u0010§\u0001\u001a\u00020\u00182\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0015\u0010¨\u0001\u001a\u00020\u00182\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J3\u0010©\u0001\u001a\u00020\u00182\n\u0010ª\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010«\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010¬\u0001\u001a\u00020e2\u0007\u0010­\u0001\u001a\u00020eH\u0016J\t\u0010®\u0001\u001a\u00020\u0018H\u0014J>\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\t\u0010¯\u0001\u001a\u0004\u0018\u0001012\t\b\u0001\u0010°\u0001\u001a\u00020\r2\t\u0010±\u0001\u001a\u0004\u0018\u0001012\u000b\b\u0002\u0010²\u0001\u001a\u0004\u0018\u000101H\u0004J\u0012\u0010³\u0001\u001a\u00020\u00182\u0007\u0010´\u0001\u001a\u00020+H\u0002J\u0015\u0010µ\u0001\u001a\u00020\u00182\n\u0010¶\u0001\u001a\u0005\u0018\u00010·\u0001H\u0002J\t\u0010¸\u0001\u001a\u00020\u0018H\u0004R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u001c\u001a\u00020\rX¤\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u00020\rX¤\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0014\u0010!\u001a\u0004\u0018\u00010\rX¤\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u0004\u0018\u00010%X¤\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u0004\u0018\u00010\rX¤\u0004¢\u0006\u0006\u001a\u0004\b)\u0010#R\u0012\u0010*\u001a\u00020+X¤\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u0004\u0018\u00010\rX¤\u0004¢\u0006\u0006\u001a\u0004\b/\u0010#R\u0012\u00100\u001a\u000201X¤\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0012\u00104\u001a\u00020+X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010-R\u0014\u00106\u001a\u000207X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0016\u0010:\u001a\u0004\u0018\u00010;X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0016\u0010>\u001a\u0004\u0018\u00010?X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020CX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010D\u001a\u00020%8TX\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bE\u0010'R\u001c\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0014\u0010N\u001a\u00020O8BX\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR!\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001b0S8BX\u0002¢\u0006\f\n\u0004\bV\u0010G\u001a\u0004\bT\u0010UR\u001f\u0010W\u001a\u0010\u0012\f\u0012\n Y*\u0004\u0018\u00010\u001b0\u001b0X¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R!\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0S8BX\u0002¢\u0006\f\n\u0004\b_\u0010G\u001a\u0004\b^\u0010UR\u001f\u0010`\u001a\u0010\u0012\f\u0012\n Y*\u0004\u0018\u00010]0]0X¢\u0006\b\n\u0000\u001a\u0004\ba\u0010[R\u001a\u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0d0cX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0d0X8F¢\u0006\u0006\u001a\u0004\bg\u0010[R\u000e\u0010h\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010i\u001a\u00020+8BX\u0004¢\u0006\u0006\u001a\u0004\bj\u0010-R\u001b\u0010k\u001a\u00020\u00038VX\u0002¢\u0006\f\n\u0004\bn\u0010G\u001a\u0004\bl\u0010mR\u000e\u0010o\u001a\u00020pX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010v\u001a\u00020e2\u0006\u0010u\u001a\u00020e@BX\u000e¢\u0006\b\n\u0000\"\u0004\bw\u0010x¨\u0006¼\u0001"}, d2 = {"Lcom/blueair/graph/view/GraphView;", "Lcom/blueair/viewcore/viewmodel/CustomConstraintLayoutNonNullState;", "Lcom/blueair/graph/viewmodel/GraphState;", "Lcom/blueair/graph/viewmodel/GraphViewModel;", "Lcom/github/mikephil/charting/listener/OnChartGestureListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastState", "drawingMode", "Lcom/github/mikephil/charting/data/LineDataSet$Mode;", "getDrawingMode", "()Lcom/github/mikephil/charting/data/LineDataSet$Mode;", "createViewModel", "setupUiOverlay", "", "updateHeaderSelectedDatapoint", "selectedPoint", "Lcom/blueair/graph/view/GraphView$SelectedPoint;", "dividerLineColor", "getDividerLineColor", "()I", "dividerTextColor", "getDividerTextColor", "graphLineSingleColor", "getGraphLineSingleColor", "()Ljava/lang/Integer;", "graphLineGradient", "", "getGraphLineGradient", "()[I", "graphfillDrawable", "getGraphfillDrawable", "supportsLegend", "", "getSupportsLegend", "()Z", "fixedMarkerImage", "getFixedMarkerImage", "emptyStateSeverityLabel", "", "getEmptyStateSeverityLabel", "()Ljava/lang/String;", "showOutdoorLegend", "getShowOutdoorLegend", "binding", "Lcom/blueair/graph/databinding/GraphBinding;", "getBinding", "()Lcom/blueair/graph/databinding/GraphBinding;", "buttonInfo", "Lcom/google/android/material/button/MaterialButton;", "getButtonInfo", "()Lcom/google/android/material/button/MaterialButton;", "graphRangeSelector", "Lcom/blueair/graph/view/GraphRangeSelector;", "getGraphRangeSelector", "()Lcom/blueair/graph/view/GraphRangeSelector;", "lineChart", "Lcom/github/mikephil/charting/charts/LineChart;", "graphCompareLineGradient", "getGraphCompareLineGradient", "graphCompareLineGradient$delegate", "Lkotlin/Lazy;", "scrollingViewParent", "Landroid/view/ViewParent;", "getScrollingViewParent", "()Landroid/view/ViewParent;", "setScrollingViewParent", "(Landroid/view/ViewParent;)V", "timeScale", "Lcom/blueair/graph/utils/ChartTimeScale;", "getTimeScale", "()Lcom/blueair/graph/utils/ChartTimeScale;", "selectedDatapointPublisher", "Lio/reactivex/subjects/PublishSubject;", "getSelectedDatapointPublisher", "()Lio/reactivex/subjects/PublishSubject;", "selectedDatapointPublisher$delegate", "liveSelectedDataPoint", "Landroidx/lifecycle/LiveData;", "kotlin.jvm.PlatformType", "getLiveSelectedDataPoint", "()Landroidx/lifecycle/LiveData;", "scaleChangedPublisher", "Lcom/blueair/graph/view/GraphView$ScaleEvent;", "getScaleChangedPublisher", "scaleChangedPublisher$delegate", "liveScale", "getLiveScale", "_liveTimeStamps", "Landroidx/lifecycle/MutableLiveData;", "", "", "liveTimeStamps", "getLiveTimeStamps", "hasScaleZoomed", "rangeSelectorVisibility", "getRangeSelectorVisibility", "viewModel", "getViewModel", "()Lcom/blueair/graph/viewmodel/GraphViewModel;", "viewModel$delegate", "scrollIndicatorRoot", "Landroid/widget/FrameLayout;", "scrollIndicator", "Landroid/view/View;", "scrollIndicatorWidth", "prevDX", "value", "scrollIndicatorPosition", "setScrollIndicatorPosition", "(F)V", "onAttachedToWindow", "onDetachedFromWindow", "attachLifeCycle", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "updateScale", "explicit", "updateProgress", "showProgress", "gotoTime", "timeInMillis", "", "refresh", "setTimeStampFilter", "nuTimeStampFilter", "initialSetup", "onStateUpdate", "state", "updateScrollScale", "chartScale", "updateScrollPosition", "setupYAxisLines", "setupXAxisLines", "startingTime", "latestTime", "makeDateLine", "Lcom/github/mikephil/charting/components/LimitLine;", "text", "setChartMarker", "entry", "Lcom/github/mikephil/charting/data/Entry;", "highlightCenterDataEntry", "selectedEntryUpdated", "onChartGestureStart", "me", "Landroid/view/MotionEvent;", "lastPerformedGesture", "Lcom/github/mikephil/charting/listener/ChartTouchListener$ChartGesture;", "onChartGestureEnd", "onChartTranslate", "dX", "dY", "onChartScale", "scaleX", "scaleY", "onChartLongPressed", "onChartDoubleTapped", "onChartSingleTapped", "onChartFling", "me1", "me2", "velocityX", "velocityY", "showEmptyState", "dataUnit", "severityColor", "severityDescript", "valueLabelString", "showLegend", "show", "updateLegend", "selectedDataPoint", "Lcom/blueair/core/model/SimpleDatapoint;", "initUiOverlay", "Companion", "SelectedPoint", "ScaleEvent", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GraphView.kt */
public abstract class GraphView extends CustomConstraintLayoutNonNullState<GraphState, GraphViewModel> implements OnChartGestureListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int LATEST_TIME_ERROR_MILLIS = 1000;
    public static final float MAX_VISIBLE_X_RANGE_DEFAULT = 2.67800013E9f;
    public static final float MIN_VISIBLE_X_RANGE_DEFAULT = 440000.0f;
    public static final long ONE_DAY_IN_MILLIS = 86400000;
    public static final long ONE_HOUR_IN_MILLIS = 3600000;
    public static final long ONE_WEEK_IN_MILLIS = 604800000;
    public static final double SCALED_Y_MAX = 100.0d;
    public static final long SCALE_CHANGE_ANIM_DURATION = 600;
    public static final double SCALE_CHANGE_PERC_DAY = 0.6d;
    public static final double SCALE_CHANGE_PERC_WEEK = 0.8d;
    public static final float SCALE_DAY = 320.0f;
    public static final float SCALE_MAX = 8928.0f;
    public static final float SCALE_MONTH = 1.0f;
    public static final float SCALE_WEEK = 10.0f;
    private final MutableLiveData<Set<Float>> _liveTimeStamps;
    private final GraphBinding binding;
    private final MaterialButton buttonInfo;
    private final Lazy graphCompareLineGradient$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda0(this));
    private final GraphRangeSelector graphRangeSelector;
    private boolean hasScaleZoomed;
    private GraphState lastState;
    private final LineChart lineChart;
    private final LiveData<ScaleEvent> liveScale;
    private final LiveData<SelectedPoint> liveSelectedDataPoint;
    private float prevDX;
    private final Lazy scaleChangedPublisher$delegate;
    private final View scrollIndicator;
    private float scrollIndicatorPosition;
    private final FrameLayout scrollIndicatorRoot;
    private int scrollIndicatorWidth;
    private ViewParent scrollingViewParent;
    private final Lazy selectedDatapointPublisher$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda1());
    private final Lazy viewModel$delegate;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GraphView.kt */
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
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.view.GraphView.WhenMappings.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public abstract GraphViewModel createViewModel();

    /* access modifiers changed from: protected */
    public abstract int getDividerLineColor();

    /* access modifiers changed from: protected */
    public abstract int getDividerTextColor();

    public abstract LineDataSet.Mode getDrawingMode();

    /* access modifiers changed from: protected */
    public abstract String getEmptyStateSeverityLabel();

    /* access modifiers changed from: protected */
    public abstract Integer getFixedMarkerImage();

    /* access modifiers changed from: protected */
    public abstract int[] getGraphLineGradient();

    /* access modifiers changed from: protected */
    public abstract Integer getGraphLineSingleColor();

    /* access modifiers changed from: protected */
    public abstract Integer getGraphfillDrawable();

    public abstract boolean getShowOutdoorLegend();

    /* access modifiers changed from: protected */
    public abstract boolean getSupportsLegend();

    public void onChartDoubleTapped(MotionEvent motionEvent) {
    }

    public void onChartFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
    }

    public void onChartLongPressed(MotionEvent motionEvent) {
    }

    public void onChartSingleTapped(MotionEvent motionEvent) {
    }

    public abstract void setupUiOverlay();

    public abstract void updateHeaderSelectedDatapoint(SelectedPoint selectedPoint);

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/blueair/graph/view/GraphView$Companion;", "", "<init>", "()V", "MIN_VISIBLE_X_RANGE_DEFAULT", "", "MAX_VISIBLE_X_RANGE_DEFAULT", "ONE_HOUR_IN_MILLIS", "", "ONE_DAY_IN_MILLIS", "ONE_WEEK_IN_MILLIS", "SCALE_MONTH", "SCALE_WEEK", "SCALE_DAY", "SCALE_MAX", "SCALED_Y_MAX", "", "SCALE_CHANGE_PERC_WEEK", "SCALE_CHANGE_PERC_DAY", "LATEST_TIME_ERROR_MILLIS", "", "SCALE_CHANGE_ANIM_DURATION", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GraphView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public final GraphBinding getBinding() {
        return this.binding;
    }

    public MaterialButton getButtonInfo() {
        return this.buttonInfo;
    }

    /* access modifiers changed from: protected */
    public GraphRangeSelector getGraphRangeSelector() {
        return this.graphRangeSelector;
    }

    /* access modifiers changed from: protected */
    public int[] getGraphCompareLineGradient() {
        return (int[]) this.graphCompareLineGradient$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final int[] graphCompareLineGradient_delegate$lambda$0(GraphView graphView) {
        return new int[]{ResourcesCompat.getColor(graphView.getResources(), R.color.darkgray, graphView.getContext().getTheme()), ResourcesCompat.getColor(graphView.getResources(), R.color.silver, graphView.getContext().getTheme())};
    }

    public final ViewParent getScrollingViewParent() {
        return this.scrollingViewParent;
    }

    public final void setScrollingViewParent(ViewParent viewParent) {
        this.scrollingViewParent = viewParent;
    }

    private final ChartTimeScale getTimeScale() {
        return ((GraphState) getViewModel().getState()).getTimeScale();
    }

    private final PublishSubject<SelectedPoint> getSelectedDatapointPublisher() {
        Object value = this.selectedDatapointPublisher$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (PublishSubject) value;
    }

    /* access modifiers changed from: private */
    public static final PublishSubject selectedDatapointPublisher_delegate$lambda$1() {
        return PublishSubject.create();
    }

    public final LiveData<SelectedPoint> getLiveSelectedDataPoint() {
        return this.liveSelectedDataPoint;
    }

    /* access modifiers changed from: private */
    public static final SelectedPoint liveSelectedDataPoint$lambda$3(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return (SelectedPoint) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final SelectedPoint liveSelectedDataPoint$lambda$2(GraphView graphView, SelectedPoint selectedPoint) {
        Intrinsics.checkNotNullParameter(selectedPoint, "it");
        graphView.updateLegend(selectedPoint.getPoint());
        graphView.updateHeaderSelectedDatapoint(selectedPoint);
        return selectedPoint;
    }

    private final PublishSubject<ScaleEvent> getScaleChangedPublisher() {
        Object value = this.scaleChangedPublisher$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (PublishSubject) value;
    }

    /* access modifiers changed from: private */
    public static final PublishSubject scaleChangedPublisher_delegate$lambda$4() {
        return PublishSubject.create();
    }

    public final LiveData<ScaleEvent> getLiveScale() {
        return this.liveScale;
    }

    public final LiveData<Set<Float>> getLiveTimeStamps() {
        return Transformations.distinctUntilChanged(this._liveTimeStamps);
    }

    private final boolean getRangeSelectorVisibility() {
        GraphRangeSelector graphRangeSelector2 = getGraphRangeSelector();
        if (graphRangeSelector2 != null) {
            return graphRangeSelector2.isExpanded();
        }
        return false;
    }

    public GraphViewModel getViewModel() {
        return (GraphViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final GraphViewModel viewModel_delegate$lambda$5(GraphView graphView) {
        return graphView.createViewModel();
    }

    private final void setScrollIndicatorPosition(float f) {
        this.scrollIndicatorPosition = f;
        updateScrollPosition();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraphView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        GraphBinding inflate = GraphBinding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        this.buttonInfo = inflate.buttonInfo;
        this.graphRangeSelector = inflate.graphRangeSelectorTop;
        LineChart lineChart2 = inflate.lineChart;
        Intrinsics.checkNotNullExpressionValue(lineChart2, "lineChart");
        this.lineChart = lineChart2;
        Flowable<R> flowable = getSelectedDatapointPublisher().debounce(25, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).map(new GraphView$$ExternalSyntheticLambda3(new GraphView$$ExternalSyntheticLambda2(this))).toFlowable(BackpressureStrategy.LATEST);
        Intrinsics.checkNotNullExpressionValue(flowable, "toFlowable(...)");
        this.liveSelectedDataPoint = LiveDataReactiveStreams.fromPublisher(flowable);
        this.scaleChangedPublisher$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda4());
        Flowable<ScaleEvent> flowable2 = getScaleChangedPublisher().toFlowable(BackpressureStrategy.LATEST);
        Intrinsics.checkNotNullExpressionValue(flowable2, "toFlowable(...)");
        this.liveScale = Transformations.distinctUntilChanged(LiveDataReactiveStreams.fromPublisher(flowable2));
        this._liveTimeStamps = new MutableLiveData<>();
        this.viewModel$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda5(this));
        FrameLayout frameLayout = inflate.scrollIndicatorRoot;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "scrollIndicatorRoot");
        this.scrollIndicatorRoot = frameLayout;
        View view = inflate.scrollIndicator;
        Intrinsics.checkNotNullExpressionValue(view, "scrollIndicator");
        this.scrollIndicator = view;
        setSaveEnabled(true);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraphView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        GraphBinding inflate = GraphBinding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        this.buttonInfo = inflate.buttonInfo;
        this.graphRangeSelector = inflate.graphRangeSelectorTop;
        LineChart lineChart2 = inflate.lineChart;
        Intrinsics.checkNotNullExpressionValue(lineChart2, "lineChart");
        this.lineChart = lineChart2;
        Flowable<R> flowable = getSelectedDatapointPublisher().debounce(25, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).map(new GraphView$$ExternalSyntheticLambda3(new GraphView$$ExternalSyntheticLambda2(this))).toFlowable(BackpressureStrategy.LATEST);
        Intrinsics.checkNotNullExpressionValue(flowable, "toFlowable(...)");
        this.liveSelectedDataPoint = LiveDataReactiveStreams.fromPublisher(flowable);
        this.scaleChangedPublisher$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda4());
        Flowable<ScaleEvent> flowable2 = getScaleChangedPublisher().toFlowable(BackpressureStrategy.LATEST);
        Intrinsics.checkNotNullExpressionValue(flowable2, "toFlowable(...)");
        this.liveScale = Transformations.distinctUntilChanged(LiveDataReactiveStreams.fromPublisher(flowable2));
        this._liveTimeStamps = new MutableLiveData<>();
        this.viewModel$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda5(this));
        FrameLayout frameLayout = inflate.scrollIndicatorRoot;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "scrollIndicatorRoot");
        this.scrollIndicatorRoot = frameLayout;
        View view = inflate.scrollIndicator;
        Intrinsics.checkNotNullExpressionValue(view, "scrollIndicator");
        this.scrollIndicator = view;
        setSaveEnabled(true);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraphView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        GraphBinding inflate = GraphBinding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        this.buttonInfo = inflate.buttonInfo;
        this.graphRangeSelector = inflate.graphRangeSelectorTop;
        LineChart lineChart2 = inflate.lineChart;
        Intrinsics.checkNotNullExpressionValue(lineChart2, "lineChart");
        this.lineChart = lineChart2;
        Flowable<R> flowable = getSelectedDatapointPublisher().debounce(25, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).map(new GraphView$$ExternalSyntheticLambda3(new GraphView$$ExternalSyntheticLambda2(this))).toFlowable(BackpressureStrategy.LATEST);
        Intrinsics.checkNotNullExpressionValue(flowable, "toFlowable(...)");
        this.liveSelectedDataPoint = LiveDataReactiveStreams.fromPublisher(flowable);
        this.scaleChangedPublisher$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda4());
        Flowable<ScaleEvent> flowable2 = getScaleChangedPublisher().toFlowable(BackpressureStrategy.LATEST);
        Intrinsics.checkNotNullExpressionValue(flowable2, "toFlowable(...)");
        this.liveScale = Transformations.distinctUntilChanged(LiveDataReactiveStreams.fromPublisher(flowable2));
        this._liveTimeStamps = new MutableLiveData<>();
        this.viewModel$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda5(this));
        FrameLayout frameLayout = inflate.scrollIndicatorRoot;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "scrollIndicatorRoot");
        this.scrollIndicatorRoot = frameLayout;
        View view = inflate.scrollIndicator;
        Intrinsics.checkNotNullExpressionValue(view, "scrollIndicator");
        this.scrollIndicator = view;
        setSaveEnabled(true);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraphView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        GraphBinding inflate = GraphBinding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        this.buttonInfo = inflate.buttonInfo;
        this.graphRangeSelector = inflate.graphRangeSelectorTop;
        LineChart lineChart2 = inflate.lineChart;
        Intrinsics.checkNotNullExpressionValue(lineChart2, "lineChart");
        this.lineChart = lineChart2;
        Flowable<R> flowable = getSelectedDatapointPublisher().debounce(25, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).map(new GraphView$$ExternalSyntheticLambda3(new GraphView$$ExternalSyntheticLambda2(this))).toFlowable(BackpressureStrategy.LATEST);
        Intrinsics.checkNotNullExpressionValue(flowable, "toFlowable(...)");
        this.liveSelectedDataPoint = LiveDataReactiveStreams.fromPublisher(flowable);
        this.scaleChangedPublisher$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda4());
        Flowable<ScaleEvent> flowable2 = getScaleChangedPublisher().toFlowable(BackpressureStrategy.LATEST);
        Intrinsics.checkNotNullExpressionValue(flowable2, "toFlowable(...)");
        this.liveScale = Transformations.distinctUntilChanged(LiveDataReactiveStreams.fromPublisher(flowable2));
        this._liveTimeStamps = new MutableLiveData<>();
        this.viewModel$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda5(this));
        FrameLayout frameLayout = inflate.scrollIndicatorRoot;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "scrollIndicatorRoot");
        this.scrollIndicatorRoot = frameLayout;
        View view = inflate.scrollIndicator;
        Intrinsics.checkNotNullExpressionValue(view, "scrollIndicator");
        this.scrollIndicator = view;
        setSaveEnabled(true);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        initialSetup();
        initUiOverlay();
        setupUiOverlay();
        showEmptyState();
        ProgressBlockerView progressBlockerView = this.binding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
        ViewExtensionsKt.show$default(progressBlockerView, false, 1, (Object) null);
        if (this instanceof IndoorGraphView) {
            IndoorGraphView indoorGraphView = (IndoorGraphView) this;
            this.scrollIndicatorRoot.setBackground(ResourcesCompat.getDrawable(indoorGraphView.getResources(), R.drawable.bg_scroll_graph_indoor, (Resources.Theme) null));
            this.scrollIndicator.setBackground(ResourcesCompat.getDrawable(indoorGraphView.getResources(), R.drawable.graph_scroll_indoor, (Resources.Theme) null));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.binding.lineChart.setOnChartGestureListener((OnChartGestureListener) null);
        super.onDetachedFromWindow();
    }

    public void attachLifeCycle(LifecycleOwner lifecycleOwner) {
        LiveData<ChartTimeScale> liveScale2;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        super.attachLifeCycle(lifecycleOwner);
        Timber.Forest forest = Timber.Forest;
        forest.d("attachLifeCycle: graphRangeSelector = " + getGraphRangeSelector(), new Object[0]);
        GraphRangeSelector graphRangeSelector2 = getGraphRangeSelector();
        if (graphRangeSelector2 != null && (liveScale2 = graphRangeSelector2.getLiveScale()) != null) {
            liveScale2.observe(lifecycleOwner, new GraphView$$ExternalSyntheticLambda7(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void attachLifeCycle$lambda$6(GraphView graphView, ChartTimeScale chartTimeScale) {
        Intrinsics.checkNotNull(chartTimeScale);
        graphView.updateScale(chartTimeScale, true);
    }

    public static /* synthetic */ void updateScale$default(GraphView graphView, ChartTimeScale chartTimeScale, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            graphView.updateScale(chartTimeScale, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateScale");
    }

    public final void updateScale(ChartTimeScale chartTimeScale, boolean z) {
        float f;
        Intrinsics.checkNotNullParameter(chartTimeScale, "timeScale");
        Timber.Forest forest = Timber.Forest;
        forest.d("updateScale: this = " + this + ", timeScale = " + chartTimeScale, new Object[0]);
        GraphViewModel.updateScale$default(getViewModel(), chartTimeScale, false, 2, (Object) null);
        getScaleChangedPublisher().onNext(new ScaleEvent(chartTimeScale, z));
        GraphRangeSelector graphRangeSelector2 = getGraphRangeSelector();
        if (graphRangeSelector2 != null) {
            graphRangeSelector2.updateTimeScale(chartTimeScale);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[chartTimeScale.ordinal()];
        if (i == 1) {
            f = 320.0f;
        } else if (i == 2) {
            f = 10.0f;
        } else if (i == 3) {
            f = 1.0f;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        updateScrollScale(f);
    }

    public final void updateProgress(boolean z) {
        ProgressBlockerView progressBlockerView = this.binding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
        ViewExtensionsKt.show(progressBlockerView, z);
    }

    public final void gotoTime(long j) {
        getViewModel().gotoTime(j);
    }

    public final void refresh() {
        getViewModel().refresh();
    }

    public final void setTimeStampFilter(Set<Float> set) {
        Intrinsics.checkNotNullParameter(set, "nuTimeStampFilter");
        getViewModel().setTimeStampFilter(set);
    }

    private final void initialSetup() {
        LineChart lineChart2 = this.binding.lineChart;
        lineChart2.setDrawGridBackground(false);
        lineChart2.getDescription().setEnabled(false);
        lineChart2.getLegend().setEnabled(false);
        lineChart2.setTouchEnabled(true);
        lineChart2.setDragEnabled(true);
        lineChart2.setDragXEnabled(true);
        lineChart2.setDragYEnabled(false);
        lineChart2.setPinchZoom(true);
        lineChart2.setDoubleTapToZoomEnabled(false);
        lineChart2.setScaleEnabled(true);
        lineChart2.setScaleXEnabled(true);
        lineChart2.setScaleYEnabled(false);
        this.binding.lineChart.setVisibleXRangeMinimum(440000.0f);
        this.binding.lineChart.setVisibleXRangeMaximum(2.67800013E9f);
        lineChart2.setAutoScaleMinMaxEnabled(false);
        lineChart2.setNoDataText("");
        lineChart2.setClipValuesToContent(true);
        lineChart2.setDragDecelerationFrictionCoef(0.85f);
        lineChart2.setDrawMarkers(true);
        XAxis xAxis = this.binding.lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawLabels(false);
        xAxis.setTextColor(ContextCompat.getColor(getContext(), R.color.aquablue));
        YAxis axisLeft = this.binding.lineChart.getAxisLeft();
        axisLeft.setDrawGridLines(false);
        axisLeft.setDrawAxisLine(false);
        axisLeft.setDrawLimitLinesBehindData(true);
        axisLeft.setTextColor(ContextCompat.getColor(getContext(), R.color.aquablue));
        axisLeft.setSpaceTop(0.0f);
        axisLeft.setSpaceBottom(0.0f);
        axisLeft.setAxisMinimum(0.0f);
        axisLeft.setAxisMaximum(100.0f);
        this.binding.lineChart.getAxisRight().setEnabled(false);
        this.binding.lineChart.setOnChartGestureListener(this);
        this.binding.lineChart.setOnTouchListener(new GraphView$$ExternalSyntheticLambda6(this));
    }

    /* access modifiers changed from: private */
    public static final boolean initialSetup$lambda$10(GraphView graphView, View view, MotionEvent motionEvent) {
        ViewParent viewParent;
        if (motionEvent != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                ViewParent viewParent2 = graphView.scrollingViewParent;
                if (viewParent2 != null) {
                    viewParent2.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((action == 1 || action == 3) && (viewParent = graphView.scrollingViewParent) != null) {
                viewParent.requestDisallowInterceptTouchEvent(false);
            }
        }
        return false;
    }

    public void onStateUpdate(GraphState graphState) {
        String str;
        boolean z;
        Entry entry;
        Entry entry2;
        float f;
        float f2;
        float f3;
        List list;
        Entry entry3;
        int[] graphLineGradient;
        GraphState graphState2 = graphState;
        Intrinsics.checkNotNullParameter(graphState2, "state");
        boolean shouldShowGraph = graphState2.getShouldShowGraph();
        GraphState graphState3 = this.lastState;
        boolean z2 = graphState3 != null && graphState3.getShouldShowGraph();
        ChartTimeScale timeScale = graphState2.getTimeScale();
        GraphState graphState4 = this.lastState;
        boolean z3 = timeScale != (graphState4 != null ? graphState4.getTimeScale() : null) || (shouldShowGraph && !z2);
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("onStateUpdate: shouldShowGraph = ");
        sb.append(shouldShowGraph);
        sb.append(", shouldChangeScale = ");
        sb.append(z3);
        sb.append(", hasScaleZoomed = ");
        sb.append(this.hasScaleZoomed);
        sb.append(", points.size = ");
        List<Entry> graphRelativeTimedDataPoints = graphState2.getGraphRelativeTimedDataPoints();
        sb.append(graphRelativeTimedDataPoints != null ? Integer.valueOf(graphRelativeTimedDataPoints.size()) : null);
        String str2 = ", ";
        sb.append(str2);
        sb.append(this);
        forest.v(sb.toString(), new Object[0]);
        ProgressBlockerView progressBlockerView = this.binding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
        ViewExtensionsKt.show(progressBlockerView, !shouldShowGraph);
        float latestTimeInMillis = (float) (graphState2.getLatestTimeInMillis() - graphState2.getStartingTimeInMillis());
        LineData lineData = new LineData();
        LineDataSet lineDataSet = new LineDataSet(shouldShowGraph ? graphState2.getGraphRelativeTimedDataPoints() : CollectionsKt.emptyList(), "DataSet Month");
        lineDataSet.setDrawIcons(true);
        lineDataSet.setLineWidth(3.0f);
        lineDataSet.setDrawValues(false);
        lineDataSet.setFormLineWidth(1.0f);
        lineDataSet.setFormSize(15.0f);
        lineDataSet.setMode(getDrawingMode());
        lineDataSet.setDrawCircles(false);
        lineDataSet.setDrawHighlightIndicators(false);
        Integer graphLineSingleColor = getGraphLineSingleColor();
        if (graphLineSingleColor != null) {
            lineDataSet.setColor(graphLineSingleColor.intValue());
        }
        if (getGraphLineSingleColor() == null && (graphLineGradient = getGraphLineGradient()) != null) {
            lineDataSet.setColors(ArraysKt.toList(graphLineGradient));
        }
        Integer graphfillDrawable = getGraphfillDrawable();
        if (graphfillDrawable != null) {
            int intValue = graphfillDrawable.intValue();
            lineDataSet.setDrawFilled(true);
            lineDataSet.setFillDrawable(ResourcesCompat.getDrawable(getResources(), intValue, getContext().getTheme()));
        }
        lineData.addDataSet(lineDataSet);
        if (shouldShowGraph) {
            List<Entry> graphRelativeTimedDataPoints2 = graphState2.getGraphRelativeTimedDataPoints();
            float min = Math.min((graphRelativeTimedDataPoints2 == null || (entry3 = (Entry) CollectionsKt.lastOrNull(graphRelativeTimedDataPoints2)) == null) ? latestTimeInMillis : entry3.getX(), latestTimeInMillis);
            Timber.Forest forest2 = Timber.Forest;
            StringBuilder sb2 = new StringBuilder("onStateUpdate: maxCompareTime = ");
            sb2.append(min);
            sb2.append(", lastpoint = (");
            List<Entry> graphRelativeTimedDataPoints3 = graphState2.getGraphRelativeTimedDataPoints();
            sb2.append(graphRelativeTimedDataPoints3 != null ? (Entry) CollectionsKt.lastOrNull(graphRelativeTimedDataPoints3) : null);
            sb2.append("), graphTimeMaximum = ");
            sb2.append(latestTimeInMillis);
            sb2.append(str2);
            sb2.append(this);
            forest2.v(sb2.toString(), new Object[0]);
            List<Entry> compareGraphDataPoints = graphState2.getCompareGraphDataPoints();
            if (compareGraphDataPoints != null) {
                Collection arrayList = new ArrayList();
                for (Entry entry4 : compareGraphDataPoints) {
                    String str3 = str2;
                    Entry entry5 = (entry4.getX() < ((float) graphState2.getStartingTimeInMillis()) || entry4.getX() - ((float) graphState2.getStartingTimeInMillis()) > min) ? null : new Entry(entry4.getX() - ((float) graphState2.getStartingTimeInMillis()), entry4.getY());
                    if (entry5 != null) {
                        arrayList.add(entry5);
                    }
                    str2 = str3;
                }
                str = str2;
                list = CollectionsKt.toMutableList((List) arrayList);
            } else {
                str = str2;
                list = null;
            }
            Entry entry6 = list != null ? (Entry) CollectionsKt.lastOrNull(list) : null;
            if (entry6 != null && ((double) entry6.getX()) < ((double) min) - 0.001d) {
                list.add(new Entry(min, entry6.getY()));
            }
            Timber.Forest forest3 = Timber.Forest;
            StringBuilder sb3 = new StringBuilder("onStateUpdate: comparePoints.last = (");
            sb3.append(list != null ? (Entry) CollectionsKt.lastOrNull(list) : null);
            sb3.append("), ");
            sb3.append(this);
            forest3.v(sb3.toString(), new Object[0]);
            Collection collection = list;
            LineDataSet lineDataSet2 = (collection == null || collection.isEmpty()) ? null : new LineDataSet(list, "DataSet Compare");
            if (lineDataSet2 != null) {
                lineDataSet2.setDrawIcons(true);
                lineDataSet2.setLineWidth(3.0f);
                lineDataSet2.setDrawValues(false);
                lineDataSet2.setFormLineWidth(1.0f);
                lineDataSet2.setFormSize(15.0f);
                lineDataSet2.setMode(getDrawingMode());
                lineDataSet2.setDrawCircles(false);
                lineDataSet2.setDrawHighlightIndicators(false);
                lineDataSet2.setColors(ArraysKt.toList(getGraphCompareLineGradient()));
            }
            if (lineDataSet2 != null) {
                lineData.addDataSet(lineDataSet2);
            }
        } else {
            str = str2;
        }
        this.lineChart.setData(lineData);
        XAxis xAxis = this.lineChart.getXAxis();
        xAxis.setAxisMinimum(0.0f);
        xAxis.setAxisMaximum(latestTimeInMillis);
        xAxis.setLabelCount(graphState2.getTimeScale() == ChartTimeScale.DAY ? 2 : 3);
        xAxis.setValueFormatter(new DayAxisValueFormatter(DateFormat.is24HourFormat(getContext()), graphState2.getStartingTimeInMillis(), graphState2.getTimeScale()));
        if (shouldShowGraph) {
            this.lineChart.getViewPortHandler().setDragOffsetX(Utils.convertPixelsToDp(((float) ViewHelperUtil.INSTANCE.getScreenWidth((View) this)) / 2.0f));
            xAxis.setGranularity(1.0f);
            z = true;
            xAxis.setDrawLimitLinesBehindData(true);
        } else {
            z = true;
        }
        YAxis axisLeft = this.lineChart.getAxisLeft();
        axisLeft.setAxisMinimum(-10.0f);
        axisLeft.setLabelCount(graphState2.getNumberOfRanges(), z);
        axisLeft.setValueFormatter(new YAxisValueFormatterOutdoor(CollectionsKt.toDoubleArray(graphState2.getMaxThresholds())));
        axisLeft.setDrawLabels(false);
        if (!shouldShowGraph || graphState2.getGraphRelativeTimedDataPoints() == null) {
            this.lineChart.getAxisLeft().removeAllLimitLines();
            this.lineChart.getXAxis().removeAllLimitLines();
        } else {
            setupYAxisLines();
            Timber.Forest.v("onStateUpdate: setupXAxisLines, timeScale = " + graphState2.getTimeScale() + ", startingTimeInMillis = " + graphState2.getStartingTimeInMillis() + ", latestTimeInMillis = " + graphState2.getLatestTimeInMillis() + str + this, new Object[0]);
            setupXAxisLines(graphState2.getTimeScale(), graphState2.getStartingTimeInMillis(), graphState2.getLatestTimeInMillis());
        }
        Entry relativelyTimedLastSelectedEntry = graphState2.getRelativelyTimedLastSelectedEntry();
        if (relativelyTimedLastSelectedEntry != null) {
            entry = lineDataSet.getEntryForXValue(relativelyTimedLastSelectedEntry.getX(), relativelyTimedLastSelectedEntry.getY());
        } else {
            List<Entry> graphRelativeTimedDataPoints4 = graphState2.getGraphRelativeTimedDataPoints();
            entry = graphRelativeTimedDataPoints4 != null ? (Entry) CollectionsKt.lastOrNull(graphRelativeTimedDataPoints4) : null;
        }
        Timber.Forest.v("onStateUpdate: nuSelected = (" + entry + "), lastSelectedGraphEntry = (" + relativelyTimedLastSelectedEntry + "), " + this, new Object[0]);
        if (entry != null) {
            selectedEntryUpdated(entry, false);
            this.lineChart.highlightValue(entry.getX(), 0);
        }
        this.lineChart.invalidate();
        if (z3) {
            int i = WhenMappings.$EnumSwitchMapping$0[graphState2.getTimeScale().ordinal()];
            if (i == 1) {
                f3 = 320.0f;
            } else if (i == 2) {
                f3 = 10.0f;
            } else if (i == 3) {
                f3 = 1.0f;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            Timber.Forest forest4 = Timber.Forest;
            StringBuilder sb4 = new StringBuilder("scaling: hasScaled = ");
            sb4.append(this.hasScaleZoomed);
            sb4.append(", zoomX = ");
            sb4.append(entry != null ? Float.valueOf(entry.getX()) : null);
            sb4.append(", maxX = ");
            entry2 = entry;
            sb4.append(((float) graphState2.getLatestTimeInMillis()) - ((float) graphState2.getStartingTimeInMillis()));
            sb4.append(", this = ");
            sb4.append(this);
            forest4.d(sb4.toString(), new Object[0]);
            if (this.hasScaleZoomed) {
                this.lineChart.zoomAndCenterAnimated(f3, 1.0f, entry2 != null ? entry2.getX() : latestTimeInMillis, 0.0f, this.lineChart.getAxisLeft().getAxisDependency(), 600);
                f = 1.0f;
            } else {
                float f4 = f3;
                this.hasScaleZoomed = true;
                f = 1.0f;
                this.lineChart.zoom(f4, 1.0f, entry2 != null ? entry2.getX() : latestTimeInMillis, 0.0f);
                this.lineChart.centerViewTo(entry2 != null ? entry2.getX() : latestTimeInMillis, 0.0f, this.lineChart.getAxisLeft().getAxisDependency());
            }
        } else {
            entry2 = entry;
            f = 1.0f;
            this.lineChart.centerViewToAnimated(entry2 != null ? entry2.getX() : latestTimeInMillis, 0.0f, this.lineChart.getAxisLeft().getAxisDependency(), 600);
        }
        if (!shouldShowGraph || graphState2.getGraphRelativeTimedDataPoints() == null) {
            GraphRangeSelector graphRangeSelector2 = getGraphRangeSelector();
            if (graphRangeSelector2 != null) {
                graphRangeSelector2.hideRangeSelector();
            }
            showEmptyState();
        }
        if (graphState2.getTimeStampFilter() == null) {
            MutableLiveData<Set<Float>> mutableLiveData = this._liveTimeStamps;
            List<Entry> graphReducedHistoricalDataPoints = graphState2.getGraphReducedHistoricalDataPoints();
            if (graphReducedHistoricalDataPoints == null) {
                graphReducedHistoricalDataPoints = CollectionsKt.emptyList();
            }
            Collection collection2 = graphReducedHistoricalDataPoints;
            List<Entry> graphRealTimeDataPoints = graphState2.getGraphRealTimeDataPoints();
            if (graphRealTimeDataPoints == null) {
                graphRealTimeDataPoints = CollectionsKt.emptyList();
            }
            Iterable<Entry> plus = CollectionsKt.plus(collection2, graphRealTimeDataPoints);
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(plus, 10));
            for (Entry x : plus) {
                arrayList2.add(Float.valueOf(x.getX()));
            }
            mutableLiveData.postValue(CollectionsKt.toSet((List) arrayList2));
        }
        this.lastState = graphState2;
        int i2 = WhenMappings.$EnumSwitchMapping$0[graphState2.getTimeScale().ordinal()];
        if (i2 == 1) {
            f2 = 320.0f;
        } else if (i2 == 2) {
            f2 = 10.0f;
        } else if (i2 == 3) {
            f2 = f;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        updateScrollScale(f2);
        if (entry2 != null) {
            setScrollIndicatorPosition(((float) getWidth()) - ((((float) getWidth()) / latestTimeInMillis) * Float.valueOf(entry2.getX()).floatValue()));
            ViewExtensionsKt.show$default(this.scrollIndicatorRoot, false, 1, (Object) null);
        }
    }

    private final void updateScrollScale(float f) {
        this.scrollIndicatorWidth = MathKt.roundToInt((((float) 11) - RangesKt.coerceAtMost(f, 10.0f)) * ((float) (this.scrollIndicatorRoot.getWidth() / 11)));
        this.scrollIndicator.getLayoutParams().width = this.scrollIndicatorWidth;
        this.scrollIndicator.requestLayout();
        updateScrollPosition();
    }

    private final void updateScrollPosition() {
        this.scrollIndicator.setX(((((float) getWidth()) - this.scrollIndicatorPosition) * ((((float) getWidth()) - ((float) (getWidth() - this.scrollIndicatorRoot.getWidth()))) - ((float) this.scrollIndicatorWidth))) / ((float) getWidth()));
    }

    private final void setupYAxisLines() {
        this.lineChart.getAxisLeft().removeAllLimitLines();
    }

    private final void setupXAxisLines(ChartTimeScale chartTimeScale, long j, long j2) {
        long j3;
        this.lineChart.getXAxis().removeAllLimitLines();
        long j4 = j2;
        while (j4 >= j) {
            GraphUtils graphUtils = GraphUtils.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.lineChart.getXAxis().addLimitLine(makeDateLine((float) (j4 - j), GraphUtils.getStringDate$default(graphUtils, j4, context, false, 4, (Object) null)));
            int i = WhenMappings.$EnumSwitchMapping$0[chartTimeScale.ordinal()];
            if (i == 1) {
                j3 = 3600000;
            } else if (i == 2) {
                j3 = 259200000;
            } else if (i == 3) {
                j3 = 1209600000;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            j4 -= j3;
        }
    }

    private final LimitLine makeDateLine(float f, String str) {
        LimitLine limitLine = new LimitLine(f, str);
        limitLine.setLineWidth(1.0f);
        limitLine.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        limitLine.setTextColor(ContextCompat.getColor(getContext(), getDividerTextColor()));
        limitLine.setLineColor(ContextCompat.getColor(getContext(), getDividerLineColor()));
        limitLine.setTextSize(13.0f);
        return limitLine;
    }

    private final void setChartMarker(Entry entry) {
        int i;
        MarkerView markerView = new MarkerView(getContext(), com.blueair.graph.R.layout.markerview_dot_outdoor);
        View findViewById = markerView.findViewById(com.blueair.graph.R.id.dashed_line);
        double d = this.lineChart.getPixelForValues(entry.getX(), entry.getY(), YAxis.AxisDependency.LEFT).y;
        float dimension = getResources().getDimension(R.dimen.chart_marker_size_outdoor);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = ((int) d) - ((int) dimension);
        findViewById.setLayoutParams(layoutParams);
        Integer fixedMarkerImage = getFixedMarkerImage();
        if (fixedMarkerImage != null) {
            i = fixedMarkerImage.intValue();
        } else {
            List<Integer> severityDots = GraphUiUtils.INSTANCE.getSeverityDots();
            double size = 100.0d / ((double) severityDots.size());
            int i2 = 0;
            while (i2 < severityDots.size()) {
                int i3 = i2 + 1;
                if (((double) entry.getY()) <= ((double) i3) * size) {
                    break;
                }
                i2 = i3;
            }
            Timber.Forest.d("setChartMarker: val = " + entry.getY() + ", markerImgPos = " + i2 + ", result = " + (((double) (i2 + 1)) * size), new Object[0]);
            i = severityDots.get(i2).intValue();
        }
        ((ImageView) markerView.findViewById(com.blueair.graph.R.id.img)).setImageResource(i);
        float f = dimension * -0.5f;
        markerView.setOffset(f, (((float) d) * -1.0f) - f);
        markerView.setGravity(80);
        this.lineChart.setMarker(markerView);
    }

    private final void highlightCenterDataEntry() {
        if (this.lineChart.getData() == null) {
            Timber.Forest.w("chart data is null", new Object[0]);
            return;
        }
        LineChart lineChart2 = this.lineChart;
        MPPointD valuesByTouchPoint = lineChart2.getValuesByTouchPoint(lineChart2.getViewPortHandler().contentLeft(), this.lineChart.getViewPortHandler().contentBottom(), this.lineChart.getAxisLeft().getAxisDependency());
        LineChart lineChart3 = this.lineChart;
        this.lineChart.highlightValue((float) (valuesByTouchPoint.x + ((lineChart3.getValuesByTouchPoint(lineChart3.getViewPortHandler().contentRight(), this.lineChart.getViewPortHandler().contentBottom(), this.lineChart.getAxisLeft().getAxisDependency()).x - valuesByTouchPoint.x) / ((double) 2))), 0);
        Highlight[] highlighted = this.lineChart.getHighlighted();
        if (highlighted == null || highlighted.length == 0) {
            Timber.Forest.w("highlighted chart value is null or empty", new Object[0]);
            return;
        }
        Collection dataSets = ((LineData) this.lineChart.getData()).getDataSets();
        if (dataSets == null || dataSets.isEmpty()) {
            Timber.Forest.w("LineChart has no data", new Object[0]);
            return;
        }
        Entry entryForXValue = ((ILineDataSet) ((LineData) this.lineChart.getData()).getDataSets().get(0)).getEntryForXValue(highlighted[0].getX(), highlighted[0].getY());
        if (entryForXValue == null) {
            Timber.Forest.w("highlightCenterDataEntry; No entry highlighted on chart. Entry == null", new Object[0]);
        } else if (Intrinsics.areEqual((Object) entryForXValue, (Object) getViewModel().getTempRelativelyTimedLastSelectedEntry())) {
            Timber.Forest.w("highlightCenterDataEntry: IGNORE same entry selected", new Object[0]);
        } else {
            selectedEntryUpdated(entryForXValue, true);
        }
    }

    private final void selectedEntryUpdated(Entry entry, boolean z) {
        GraphState graphState = (GraphState) getViewModel().getState();
        setChartMarker(entry);
        ReversedResult reverseRelativelyTimedEntryToDataPoint = getViewModel().reverseRelativelyTimedEntryToDataPoint(entry);
        if (reverseRelativelyTimedEntryToDataPoint != null) {
            getSelectedDatapointPublisher().onNext(new SelectedPoint(reverseRelativelyTimedEntryToDataPoint.getDataPoint(), reverseRelativelyTimedEntryToDataPoint.getCompareDataPoint(), z));
            if (z) {
                Timber.Forest forest = Timber.Forest;
                StringBuilder sb = new StringBuilder("selectedEntryUpdated: entry = ");
                sb.append(entry);
                sb.append(", graphRelativeTimedDataPoints.last() = ");
                List<Entry> graphRelativeTimedDataPoints = graphState.getGraphRelativeTimedDataPoints();
                sb.append(graphRelativeTimedDataPoints != null ? (Entry) CollectionsKt.lastOrNull(graphRelativeTimedDataPoints) : null);
                forest.d(sb.toString(), new Object[0]);
                List<Entry> graphRelativeTimedDataPoints2 = graphState.getGraphRelativeTimedDataPoints();
                if (Intrinsics.areEqual((Object) entry, (Object) graphRelativeTimedDataPoints2 != null ? (Entry) CollectionsKt.lastOrNull(graphRelativeTimedDataPoints2) : null)) {
                    getViewModel().setTempRelativelyTimedLastSelectedEntry((Entry) null);
                    Timber.Forest.v("selectedEntryUpdated: clear selected", new Object[0]);
                } else if (!Intrinsics.areEqual((Object) entry, (Object) getViewModel().getTempRelativelyTimedLastSelectedEntry())) {
                    getViewModel().setTempRelativelyTimedLastSelectedEntry(entry);
                    Timber.Forest.v("selectedEntryUpdated: set selected", new Object[0]);
                } else {
                    Timber.Forest.v("selectedEntryUpdated: IGNORE", new Object[0]);
                }
            }
        }
    }

    public void onChartGestureStart(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture) {
        this.prevDX = 0.0f;
    }

    public void onChartGestureEnd(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture) {
        highlightCenterDataEntry();
    }

    public void onChartTranslate(MotionEvent motionEvent, float f, float f2) {
        float abs = Math.abs(f) - Math.abs(this.prevDX);
        if (f < 0.0f) {
            abs = -abs;
        }
        this.prevDX = f;
        setScrollIndicatorPosition(RangesKt.coerceIn(this.scrollIndicatorPosition + (abs / this.lineChart.getScaleX()), 0.0f, (float) this.lineChart.getWidth()));
        highlightCenterDataEntry();
    }

    public void onChartScale(MotionEvent motionEvent, float f, float f2) {
        ChartTimeScale chartTimeScale;
        float scaleX = this.lineChart.getScaleX();
        updateScrollScale(scaleX);
        Timber.Forest forest = Timber.Forest;
        forest.d("onChartScale: nuScaleX = " + scaleX, new Object[0]);
        if (scaleX > 8978.0f) {
            LineChart lineChart2 = this.lineChart;
            lineChart2.zoomAndCenterAnimated(8928.0f, f2, lineChart2.getHighestVisibleX(), 0.0f, this.lineChart.getAxisLeft().getAxisDependency(), 500);
            return;
        }
        double d = (double) scaleX;
        if (d >= 192.0d) {
            chartTimeScale = ChartTimeScale.DAY;
        } else if (d >= 8.0d) {
            chartTimeScale = ChartTimeScale.WEEK;
        } else {
            chartTimeScale = ChartTimeScale.MONTH;
        }
        Timber.Forest forest2 = Timber.Forest;
        forest2.d("onChartScale: nuScale = " + chartTimeScale + ", oldScale = " + ((GraphState) getViewModel().getState()).getTimeScale(), new Object[0]);
        if (chartTimeScale != ((GraphState) getViewModel().getState()).getTimeScale()) {
            updateScale(chartTimeScale, true);
        }
    }

    /* access modifiers changed from: protected */
    public void showEmptyState() {
        Timber.Forest forest = Timber.Forest;
        forest.d("showEmptyState: emptyStateSeverityLabel  = " + getEmptyStateSeverityLabel(), new Object[0]);
        GraphRangeSelector graphRangeSelector2 = getGraphRangeSelector();
        if (graphRangeSelector2 != null) {
            graphRangeSelector2.reset();
        }
        this.binding.valueLabel.setVisibility(8);
        if (getFixedMarkerImage() != null) {
            showLegend(false);
            this.binding.severityLabel.setVisibility(4);
            return;
        }
        showLegend(true);
        this.binding.severityLabel.setText(getEmptyStateSeverityLabel());
        this.binding.severityLabel.setVisibility(0);
        this.binding.severityLabel.setContentDescription((CharSequence) null);
    }

    public static /* synthetic */ void updateHeaderSelectedDatapoint$default(GraphView graphView, SelectedPoint selectedPoint, String str, int i, String str2, String str3, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 16) != 0) {
                str3 = null;
            }
            graphView.updateHeaderSelectedDatapoint(selectedPoint, str, i, str2, str3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateHeaderSelectedDatapoint");
    }

    /* access modifiers changed from: protected */
    public final void updateHeaderSelectedDatapoint(SelectedPoint selectedPoint, String str, int i, String str2, String str3) {
        String str4;
        Intrinsics.checkNotNullParameter(selectedPoint, "selectedPoint");
        SimpleDatapoint point = selectedPoint.getPoint();
        Timber.Forest.d("updateHeaderSelectedDatapoint", new Object[0]);
        GraphRangeSelector graphRangeSelector2 = getGraphRangeSelector();
        if (graphRangeSelector2 != null) {
            graphRangeSelector2.updateTime(point);
        }
        if (str3 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(MathKt.roundToInt(point.getValue()));
            if (str != null) {
                str4 = " " + str;
            } else {
                str4 = "";
            }
            sb.append(str4);
            str3 = sb.toString();
        }
        if (selectedPoint.getComparedPoint() != null) {
            String str5 = " (" + MathKt.roundToInt(selectedPoint.getComparedPoint().getValue()) + ") ";
            SpannableString spannableString = new SpannableString(str3 + str5);
            spannableString.setSpan(new ForegroundColorSpan(ResourcesCompat.getColor(getResources(), R.color.niekiegray, getContext().getTheme())), spannableString.length() - str5.length(), spannableString.length(), 0);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(spannableString);
            this.binding.valueLabel.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            this.binding.valueLabel.setText(str3);
        }
        this.binding.valueLabel.setTextColor(ResourcesCompat.getColor(getResources(), i, getContext().getTheme()));
        if (!getRangeSelectorVisibility()) {
            this.binding.valueLabel.setVisibility(0);
        }
        CharSequence charSequence = str2;
        if (charSequence == null || charSequence.length() == 0) {
            this.binding.severityLabel.setVisibility(8);
            return;
        }
        this.binding.severityLabel.setText(charSequence);
        this.binding.severityLabel.setVisibility(0);
        this.binding.severityLabel.setContentDescription(getResources().getString(R.string.current_aqi_content_description, new Object[]{str2}));
    }

    private final void showLegend(boolean z) {
        int i = 0;
        this.binding.legendLabels.setVisibility(z ? 0 : 4);
        Group group = this.binding.legendOutdoorGroup;
        Intrinsics.checkNotNullExpressionValue(group, "legendOutdoorGroup");
        View view = group;
        if (!(z && getShowOutdoorLegend())) {
            i = 8;
        }
        view.setVisibility(i);
    }

    private final void updateLegend(SimpleDatapoint simpleDatapoint) {
        Entry latestGraphDataPoint = getViewModel().getLatestGraphDataPoint();
        long x = (latestGraphDataPoint != null ? (long) latestGraphDataPoint.getX() : 0) + getViewModel().getStartingTimeInMillis();
        Timber.Forest forest = Timber.Forest;
        boolean z = false;
        forest.d("updateLegend: supportsLegend = " + getSupportsLegend() + ", selectedDataPoint = " + simpleDatapoint + ", latest graphTime = " + x + ", viewModel.latestGraphDataPoint = " + getViewModel().getLatestGraphDataPoint(), new Object[0]);
        if (getSupportsLegend() && (getViewModel().getTempRelativelyTimedLastSelectedEntry() == null || (simpleDatapoint != null && Math.abs(x - simpleDatapoint.getTimeInMillis()) < 1000))) {
            z = true;
        }
        showLegend(z);
    }

    /* access modifiers changed from: protected */
    public final void initUiOverlay() {
        Timber.Forest forest = Timber.Forest;
        forest.d("initUiOverlay: graphRangeSelector = " + getGraphRangeSelector() + ", graph_range_selector_top = " + this.binding.graphRangeSelectorTop, new Object[0]);
        GraphRangeSelector graphRangeSelector2 = getGraphRangeSelector();
        if (graphRangeSelector2 != null) {
            graphRangeSelector2.reset();
        }
        GraphRangeSelector graphRangeSelector3 = getGraphRangeSelector();
        if (graphRangeSelector3 != null) {
            graphRangeSelector3.updateTimeScale(getTimeScale());
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/blueair/graph/view/GraphView$SelectedPoint;", "", "point", "Lcom/blueair/core/model/SimpleDatapoint;", "comparedPoint", "explicit", "", "<init>", "(Lcom/blueair/core/model/SimpleDatapoint;Lcom/blueair/core/model/SimpleDatapoint;Z)V", "getPoint", "()Lcom/blueair/core/model/SimpleDatapoint;", "getComparedPoint", "getExplicit", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GraphView.kt */
    public static final class SelectedPoint {
        private final SimpleDatapoint comparedPoint;
        private final boolean explicit;
        private final SimpleDatapoint point;

        public static /* synthetic */ SelectedPoint copy$default(SelectedPoint selectedPoint, SimpleDatapoint simpleDatapoint, SimpleDatapoint simpleDatapoint2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                simpleDatapoint = selectedPoint.point;
            }
            if ((i & 2) != 0) {
                simpleDatapoint2 = selectedPoint.comparedPoint;
            }
            if ((i & 4) != 0) {
                z = selectedPoint.explicit;
            }
            return selectedPoint.copy(simpleDatapoint, simpleDatapoint2, z);
        }

        public final SimpleDatapoint component1() {
            return this.point;
        }

        public final SimpleDatapoint component2() {
            return this.comparedPoint;
        }

        public final boolean component3() {
            return this.explicit;
        }

        public final SelectedPoint copy(SimpleDatapoint simpleDatapoint, SimpleDatapoint simpleDatapoint2, boolean z) {
            Intrinsics.checkNotNullParameter(simpleDatapoint, "point");
            return new SelectedPoint(simpleDatapoint, simpleDatapoint2, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SelectedPoint)) {
                return false;
            }
            SelectedPoint selectedPoint = (SelectedPoint) obj;
            return Intrinsics.areEqual((Object) this.point, (Object) selectedPoint.point) && Intrinsics.areEqual((Object) this.comparedPoint, (Object) selectedPoint.comparedPoint) && this.explicit == selectedPoint.explicit;
        }

        public int hashCode() {
            int hashCode = this.point.hashCode() * 31;
            SimpleDatapoint simpleDatapoint = this.comparedPoint;
            return ((hashCode + (simpleDatapoint == null ? 0 : simpleDatapoint.hashCode())) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.explicit);
        }

        public String toString() {
            return "SelectedPoint(point=" + this.point + ", comparedPoint=" + this.comparedPoint + ", explicit=" + this.explicit + ')';
        }

        public SelectedPoint(SimpleDatapoint simpleDatapoint, SimpleDatapoint simpleDatapoint2, boolean z) {
            Intrinsics.checkNotNullParameter(simpleDatapoint, "point");
            this.point = simpleDatapoint;
            this.comparedPoint = simpleDatapoint2;
            this.explicit = z;
        }

        public final SimpleDatapoint getPoint() {
            return this.point;
        }

        public final SimpleDatapoint getComparedPoint() {
            return this.comparedPoint;
        }

        public final boolean getExplicit() {
            return this.explicit;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/blueair/graph/view/GraphView$ScaleEvent;", "", "timeScale", "Lcom/blueair/graph/utils/ChartTimeScale;", "explicit", "", "<init>", "(Lcom/blueair/graph/utils/ChartTimeScale;Z)V", "getTimeScale", "()Lcom/blueair/graph/utils/ChartTimeScale;", "getExplicit", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GraphView.kt */
    public static final class ScaleEvent {
        private final boolean explicit;
        private final ChartTimeScale timeScale;

        public static /* synthetic */ ScaleEvent copy$default(ScaleEvent scaleEvent, ChartTimeScale chartTimeScale, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                chartTimeScale = scaleEvent.timeScale;
            }
            if ((i & 2) != 0) {
                z = scaleEvent.explicit;
            }
            return scaleEvent.copy(chartTimeScale, z);
        }

        public final ChartTimeScale component1() {
            return this.timeScale;
        }

        public final boolean component2() {
            return this.explicit;
        }

        public final ScaleEvent copy(ChartTimeScale chartTimeScale, boolean z) {
            Intrinsics.checkNotNullParameter(chartTimeScale, "timeScale");
            return new ScaleEvent(chartTimeScale, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ScaleEvent)) {
                return false;
            }
            ScaleEvent scaleEvent = (ScaleEvent) obj;
            return this.timeScale == scaleEvent.timeScale && this.explicit == scaleEvent.explicit;
        }

        public int hashCode() {
            return (this.timeScale.hashCode() * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.explicit);
        }

        public String toString() {
            return "ScaleEvent(timeScale=" + this.timeScale + ", explicit=" + this.explicit + ')';
        }

        public ScaleEvent(ChartTimeScale chartTimeScale, boolean z) {
            Intrinsics.checkNotNullParameter(chartTimeScale, "timeScale");
            this.timeScale = chartTimeScale;
            this.explicit = z;
        }

        public final boolean getExplicit() {
            return this.explicit;
        }

        public final ChartTimeScale getTimeScale() {
            return this.timeScale;
        }
    }
}
