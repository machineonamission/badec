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
import android.widget.TextView.BufferType;
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
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
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
import java.util.Iterator;
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
import org.reactivestreams.Publisher;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 ¹\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0006¹\u0001º\u0001»\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0007\u0010\u000eB)\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0007\u0010\u0010J\b\u0010\u0016\u001a\u00020\u0003H$J\b\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH&J\b\u0010y\u001a\u00020\u0018H\u0014J\b\u0010z\u001a\u00020\u0018H\u0014J\u0010\u0010{\u001a\u00020\u00182\u0006\u0010|\u001a\u00020}H\u0016J\u0018\u0010~\u001a\u00020\u00182\u0006\u0010N\u001a\u00020O2\b\b\u0002\u0010\u007f\u001a\u00020+J\u0010\u0010\u0080\u0001\u001a\u00020\u00182\u0007\u0010\u0081\u0001\u001a\u00020+J\u0011\u0010\u0082\u0001\u001a\u00020\u00182\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001J\u0007\u0010\u0085\u0001\u001a\u00020\u0018J\u0016\u0010\u0086\u0001\u001a\u00020\u00182\r\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020e0dJ\t\u0010\u0088\u0001\u001a\u00020\u0018H\u0002J\u0012\u0010\u0089\u0001\u001a\u00020\u00182\u0007\u0010\u008a\u0001\u001a\u00020\u0002H\u0016J\u0012\u0010\u008b\u0001\u001a\u00020\u00182\u0007\u0010\u008c\u0001\u001a\u00020eH\u0002J\t\u0010\u008d\u0001\u001a\u00020\u0018H\u0002J\t\u0010\u008e\u0001\u001a\u00020\u0018H\u0002J%\u0010\u008f\u0001\u001a\u00020\u00182\u0006\u0010N\u001a\u00020O2\b\u0010\u0090\u0001\u001a\u00030\u0084\u00012\b\u0010\u0091\u0001\u001a\u00030\u0084\u0001H\u0002J\u001b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u0006\u0010u\u001a\u00020e2\u0007\u0010\u0094\u0001\u001a\u000201H\u0002J\u0013\u0010\u0095\u0001\u001a\u00020\u00182\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0002J\t\u0010\u0098\u0001\u001a\u00020\u0018H\u0002J\u001b\u0010\u0099\u0001\u001a\u00020\u00182\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0006\u0010\u007f\u001a\u00020+H\u0002J!\u0010\u009a\u0001\u001a\u00020\u00182\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u00012\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0016J!\u0010\u009f\u0001\u001a\u00020\u00182\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u00012\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0016J'\u0010 \u0001\u001a\u00020\u00182\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u00012\u0007\u0010¡\u0001\u001a\u00020e2\u0007\u0010¢\u0001\u001a\u00020eH\u0016J'\u0010£\u0001\u001a\u00020\u00182\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u00012\u0007\u0010¤\u0001\u001a\u00020e2\u0007\u0010¥\u0001\u001a\u00020eH\u0016J\u0015\u0010¦\u0001\u001a\u00020\u00182\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001H\u0016J\u0015\u0010§\u0001\u001a\u00020\u00182\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001H\u0016J\u0015\u0010¨\u0001\u001a\u00020\u00182\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001H\u0016J3\u0010©\u0001\u001a\u00020\u00182\n\u0010ª\u0001\u001a\u0005\u0018\u00010\u009c\u00012\n\u0010«\u0001\u001a\u0005\u0018\u00010\u009c\u00012\u0007\u0010¬\u0001\u001a\u00020e2\u0007\u0010\u00ad\u0001\u001a\u00020eH\u0016J\t\u0010®\u0001\u001a\u00020\u0018H\u0014J>\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\t\u0010¯\u0001\u001a\u0004\u0018\u0001012\t\b\u0001\u0010°\u0001\u001a\u00020\r2\t\u0010±\u0001\u001a\u0004\u0018\u0001012\u000b\b\u0002\u0010²\u0001\u001a\u0004\u0018\u000101H\u0004J\u0012\u0010³\u0001\u001a\u00020\u00182\u0007\u0010´\u0001\u001a\u00020+H\u0002J\u0015\u0010µ\u0001\u001a\u00020\u00182\n\u0010¶\u0001\u001a\u0005\u0018\u00010·\u0001H\u0002J\t\u0010¸\u0001\u001a\u00020\u0018H\u0004R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u001c\u001a\u00020\rX¤\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u00020\rX¤\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0014\u0010!\u001a\u0004\u0018\u00010\rX¤\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u0004\u0018\u00010%X¤\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u0004\u0018\u00010\rX¤\u0004¢\u0006\u0006\u001a\u0004\b)\u0010#R\u0012\u0010*\u001a\u00020+X¤\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u0004\u0018\u00010\rX¤\u0004¢\u0006\u0006\u001a\u0004\b/\u0010#R\u0012\u00100\u001a\u000201X¤\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0012\u00104\u001a\u00020+X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010-R\u0014\u00106\u001a\u000207X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0016\u0010:\u001a\u0004\u0018\u00010;X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0016\u0010>\u001a\u0004\u0018\u00010?X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010D\u001a\u00020%8TX\u0094\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bE\u0010'R\u001c\u0010H\u001a\u0004\u0018\u00010IX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0014\u0010N\u001a\u00020O8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR!\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001b0S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010G\u001a\u0004\bT\u0010UR\u001f\u0010W\u001a\u0010\u0012\f\u0012\n Y*\u0004\u0018\u00010\u001b0\u001b0X¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R!\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010G\u001a\u0004\b^\u0010UR\u001f\u0010`\u001a\u0010\u0012\f\u0012\n Y*\u0004\u0018\u00010]0]0X¢\u0006\b\n\u0000\u001a\u0004\ba\u0010[R\u001a\u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0d0cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0d0X8F¢\u0006\u0006\u001a\u0004\bg\u0010[R\u000e\u0010h\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010i\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bj\u0010-R\u001b\u0010k\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bn\u0010G\u001a\u0004\bl\u0010mR\u000e\u0010o\u001a\u00020pX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010v\u001a\u00020e2\u0006\u0010u\u001a\u00020e@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bw\u0010x¨\u0006¼\u0001"},
   d2 = {"Lcom/blueair/graph/view/GraphView;", "Lcom/blueair/viewcore/viewmodel/CustomConstraintLayoutNonNullState;", "Lcom/blueair/graph/viewmodel/GraphState;", "Lcom/blueair/graph/viewmodel/GraphViewModel;", "Lcom/github/mikephil/charting/listener/OnChartGestureListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastState", "drawingMode", "Lcom/github/mikephil/charting/data/LineDataSet$Mode;", "getDrawingMode", "()Lcom/github/mikephil/charting/data/LineDataSet$Mode;", "createViewModel", "setupUiOverlay", "", "updateHeaderSelectedDatapoint", "selectedPoint", "Lcom/blueair/graph/view/GraphView$SelectedPoint;", "dividerLineColor", "getDividerLineColor", "()I", "dividerTextColor", "getDividerTextColor", "graphLineSingleColor", "getGraphLineSingleColor", "()Ljava/lang/Integer;", "graphLineGradient", "", "getGraphLineGradient", "()[I", "graphfillDrawable", "getGraphfillDrawable", "supportsLegend", "", "getSupportsLegend", "()Z", "fixedMarkerImage", "getFixedMarkerImage", "emptyStateSeverityLabel", "", "getEmptyStateSeverityLabel", "()Ljava/lang/String;", "showOutdoorLegend", "getShowOutdoorLegend", "binding", "Lcom/blueair/graph/databinding/GraphBinding;", "getBinding", "()Lcom/blueair/graph/databinding/GraphBinding;", "buttonInfo", "Lcom/google/android/material/button/MaterialButton;", "getButtonInfo", "()Lcom/google/android/material/button/MaterialButton;", "graphRangeSelector", "Lcom/blueair/graph/view/GraphRangeSelector;", "getGraphRangeSelector", "()Lcom/blueair/graph/view/GraphRangeSelector;", "lineChart", "Lcom/github/mikephil/charting/charts/LineChart;", "graphCompareLineGradient", "getGraphCompareLineGradient", "graphCompareLineGradient$delegate", "Lkotlin/Lazy;", "scrollingViewParent", "Landroid/view/ViewParent;", "getScrollingViewParent", "()Landroid/view/ViewParent;", "setScrollingViewParent", "(Landroid/view/ViewParent;)V", "timeScale", "Lcom/blueair/graph/utils/ChartTimeScale;", "getTimeScale", "()Lcom/blueair/graph/utils/ChartTimeScale;", "selectedDatapointPublisher", "Lio/reactivex/subjects/PublishSubject;", "getSelectedDatapointPublisher", "()Lio/reactivex/subjects/PublishSubject;", "selectedDatapointPublisher$delegate", "liveSelectedDataPoint", "Landroidx/lifecycle/LiveData;", "kotlin.jvm.PlatformType", "getLiveSelectedDataPoint", "()Landroidx/lifecycle/LiveData;", "scaleChangedPublisher", "Lcom/blueair/graph/view/GraphView$ScaleEvent;", "getScaleChangedPublisher", "scaleChangedPublisher$delegate", "liveScale", "getLiveScale", "_liveTimeStamps", "Landroidx/lifecycle/MutableLiveData;", "", "", "liveTimeStamps", "getLiveTimeStamps", "hasScaleZoomed", "rangeSelectorVisibility", "getRangeSelectorVisibility", "viewModel", "getViewModel", "()Lcom/blueair/graph/viewmodel/GraphViewModel;", "viewModel$delegate", "scrollIndicatorRoot", "Landroid/widget/FrameLayout;", "scrollIndicator", "Landroid/view/View;", "scrollIndicatorWidth", "prevDX", "value", "scrollIndicatorPosition", "setScrollIndicatorPosition", "(F)V", "onAttachedToWindow", "onDetachedFromWindow", "attachLifeCycle", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "updateScale", "explicit", "updateProgress", "showProgress", "gotoTime", "timeInMillis", "", "refresh", "setTimeStampFilter", "nuTimeStampFilter", "initialSetup", "onStateUpdate", "state", "updateScrollScale", "chartScale", "updateScrollPosition", "setupYAxisLines", "setupXAxisLines", "startingTime", "latestTime", "makeDateLine", "Lcom/github/mikephil/charting/components/LimitLine;", "text", "setChartMarker", "entry", "Lcom/github/mikephil/charting/data/Entry;", "highlightCenterDataEntry", "selectedEntryUpdated", "onChartGestureStart", "me", "Landroid/view/MotionEvent;", "lastPerformedGesture", "Lcom/github/mikephil/charting/listener/ChartTouchListener$ChartGesture;", "onChartGestureEnd", "onChartTranslate", "dX", "dY", "onChartScale", "scaleX", "scaleY", "onChartLongPressed", "onChartDoubleTapped", "onChartSingleTapped", "onChartFling", "me1", "me2", "velocityX", "velocityY", "showEmptyState", "dataUnit", "severityColor", "severityDescript", "valueLabelString", "showLegend", "show", "updateLegend", "selectedDataPoint", "Lcom/blueair/core/model/SimpleDatapoint;", "initUiOverlay", "Companion", "SelectedPoint", "ScaleEvent", "graph_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class GraphView extends CustomConstraintLayoutNonNullState implements OnChartGestureListener {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final int LATEST_TIME_ERROR_MILLIS = 1000;
   public static final float MAX_VISIBLE_X_RANGE_DEFAULT = 2.678E9F;
   public static final float MIN_VISIBLE_X_RANGE_DEFAULT = 440000.0F;
   public static final long ONE_DAY_IN_MILLIS = 86400000L;
   public static final long ONE_HOUR_IN_MILLIS = 3600000L;
   public static final long ONE_WEEK_IN_MILLIS = 604800000L;
   public static final double SCALED_Y_MAX = (double)100.0F;
   public static final long SCALE_CHANGE_ANIM_DURATION = 600L;
   public static final double SCALE_CHANGE_PERC_DAY = 0.6;
   public static final double SCALE_CHANGE_PERC_WEEK = 0.8;
   public static final float SCALE_DAY = 320.0F;
   public static final float SCALE_MAX = 8928.0F;
   public static final float SCALE_MONTH = 1.0F;
   public static final float SCALE_WEEK = 10.0F;
   private final MutableLiveData _liveTimeStamps;
   private final GraphBinding binding;
   private final MaterialButton buttonInfo;
   private final Lazy graphCompareLineGradient$delegate;
   private final GraphRangeSelector graphRangeSelector;
   private boolean hasScaleZoomed;
   private GraphState lastState;
   private final LineChart lineChart;
   private final LiveData liveScale;
   private final LiveData liveSelectedDataPoint;
   private float prevDX;
   private final Lazy scaleChangedPublisher$delegate;
   private final View scrollIndicator;
   private float scrollIndicatorPosition;
   private final FrameLayout scrollIndicatorRoot;
   private int scrollIndicatorWidth;
   private ViewParent scrollingViewParent;
   private final Lazy selectedDatapointPublisher$delegate;
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static int[] $r8$lambda$79tLzivJySr5sjdfXaUTWheXSnI(GraphView var0) {
      return graphCompareLineGradient_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static SelectedPoint $r8$lambda$JvBLrT_DZWeeZlAqu2myq3fWRsU/* $FF was: $r8$lambda$JvBLrT-DZWeeZlAqu2myq3fWRsU*/(Function1 var0, Object var1) {
      return liveSelectedDataPoint$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$L2cYRgGWtiI3dhgXI_RcO42JJx8/* $FF was: $r8$lambda$L2cYRgGWtiI3dhgXI-RcO42JJx8*/(GraphView var0, View var1, MotionEvent var2) {
      return initialSetup$lambda$10(var0, var1, var2);
   }

   // $FF: synthetic method
   public static PublishSubject $r8$lambda$OY008WfxZ05R3wINrCgr_DAYjHo() {
      return selectedDatapointPublisher_delegate$lambda$1();
   }

   // $FF: synthetic method
   public static GraphViewModel $r8$lambda$eHnXhEVZs9KNL_dLFIB_Y7oX1wk/* $FF was: $r8$lambda$eHnXhEVZs9KNL-dLFIB_Y7oX1wk*/(GraphView var0) {
      return viewModel_delegate$lambda$5(var0);
   }

   // $FF: synthetic method
   public static PublishSubject $r8$lambda$h4STXtvMxyDCQ9dLQIQ1NxVV0KU() {
      return scaleChangedPublisher_delegate$lambda$4();
   }

   // $FF: synthetic method
   public static SelectedPoint $r8$lambda$oq_xbwY_xZgJZv4n_4fBQODKwu4/* $FF was: $r8$lambda$oq_xbwY-xZgJZv4n-4fBQODKwu4*/(GraphView var0, SelectedPoint var1) {
      return liveSelectedDataPoint$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$v0UoDVrxGh20IL5KS2DfSGebq7U(GraphView var0, ChartTimeScale var1) {
      attachLifeCycle$lambda$6(var0, var1);
   }

   public GraphView(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1);
      GraphBinding var3 = GraphBinding.inflate(LayoutInflater.from(this.getContext()), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
      this.binding = var3;
      this.buttonInfo = var3.buttonInfo;
      this.graphRangeSelector = var3.graphRangeSelectorTop;
      LineChart var2 = var3.lineChart;
      Intrinsics.checkNotNullExpressionValue(var2, "lineChart");
      this.lineChart = var2;
      this.graphCompareLineGradient$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda0(this));
      this.selectedDatapointPublisher$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda1());
      Flowable var5 = this.getSelectedDatapointPublisher().debounce(25L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).map(new GraphView$$ExternalSyntheticLambda3(new GraphView$$ExternalSyntheticLambda2(this))).toFlowable(BackpressureStrategy.LATEST);
      Intrinsics.checkNotNullExpressionValue(var5, "toFlowable(...)");
      this.liveSelectedDataPoint = LiveDataReactiveStreams.fromPublisher((Publisher)var5);
      this.scaleChangedPublisher$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda4());
      var5 = this.getScaleChangedPublisher().toFlowable(BackpressureStrategy.LATEST);
      Intrinsics.checkNotNullExpressionValue(var5, "toFlowable(...)");
      this.liveScale = Transformations.distinctUntilChanged(LiveDataReactiveStreams.fromPublisher((Publisher)var5));
      this._liveTimeStamps = new MutableLiveData();
      this.viewModel$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda5(this));
      FrameLayout var7 = var3.scrollIndicatorRoot;
      Intrinsics.checkNotNullExpressionValue(var7, "scrollIndicatorRoot");
      this.scrollIndicatorRoot = var7;
      View var4 = var3.scrollIndicator;
      Intrinsics.checkNotNullExpressionValue(var4, "scrollIndicator");
      this.scrollIndicator = var4;
      this.setSaveEnabled(true);
   }

   public GraphView(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2);
      GraphBinding var3 = GraphBinding.inflate(LayoutInflater.from(this.getContext()), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
      this.binding = var3;
      this.buttonInfo = var3.buttonInfo;
      this.graphRangeSelector = var3.graphRangeSelectorTop;
      LineChart var5 = var3.lineChart;
      Intrinsics.checkNotNullExpressionValue(var5, "lineChart");
      this.lineChart = var5;
      this.graphCompareLineGradient$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda0(this));
      this.selectedDatapointPublisher$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda1());
      Flowable var6 = this.getSelectedDatapointPublisher().debounce(25L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).map(new GraphView$$ExternalSyntheticLambda3(new GraphView$$ExternalSyntheticLambda2(this))).toFlowable(BackpressureStrategy.LATEST);
      Intrinsics.checkNotNullExpressionValue(var6, "toFlowable(...)");
      this.liveSelectedDataPoint = LiveDataReactiveStreams.fromPublisher((Publisher)var6);
      this.scaleChangedPublisher$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda4());
      var6 = this.getScaleChangedPublisher().toFlowable(BackpressureStrategy.LATEST);
      Intrinsics.checkNotNullExpressionValue(var6, "toFlowable(...)");
      this.liveScale = Transformations.distinctUntilChanged(LiveDataReactiveStreams.fromPublisher((Publisher)var6));
      this._liveTimeStamps = new MutableLiveData();
      this.viewModel$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda5(this));
      FrameLayout var8 = var3.scrollIndicatorRoot;
      Intrinsics.checkNotNullExpressionValue(var8, "scrollIndicatorRoot");
      this.scrollIndicatorRoot = var8;
      View var4 = var3.scrollIndicator;
      Intrinsics.checkNotNullExpressionValue(var4, "scrollIndicator");
      this.scrollIndicator = var4;
      this.setSaveEnabled(true);
   }

   public GraphView(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
      GraphBinding var4 = GraphBinding.inflate(LayoutInflater.from(this.getContext()), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.binding = var4;
      this.buttonInfo = var4.buttonInfo;
      this.graphRangeSelector = var4.graphRangeSelectorTop;
      LineChart var6 = var4.lineChart;
      Intrinsics.checkNotNullExpressionValue(var6, "lineChart");
      this.lineChart = var6;
      this.graphCompareLineGradient$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda0(this));
      this.selectedDatapointPublisher$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda1());
      Flowable var7 = this.getSelectedDatapointPublisher().debounce(25L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).map(new GraphView$$ExternalSyntheticLambda3(new GraphView$$ExternalSyntheticLambda2(this))).toFlowable(BackpressureStrategy.LATEST);
      Intrinsics.checkNotNullExpressionValue(var7, "toFlowable(...)");
      this.liveSelectedDataPoint = LiveDataReactiveStreams.fromPublisher((Publisher)var7);
      this.scaleChangedPublisher$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda4());
      var7 = this.getScaleChangedPublisher().toFlowable(BackpressureStrategy.LATEST);
      Intrinsics.checkNotNullExpressionValue(var7, "toFlowable(...)");
      this.liveScale = Transformations.distinctUntilChanged(LiveDataReactiveStreams.fromPublisher((Publisher)var7));
      this._liveTimeStamps = new MutableLiveData();
      this.viewModel$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda5(this));
      FrameLayout var9 = var4.scrollIndicatorRoot;
      Intrinsics.checkNotNullExpressionValue(var9, "scrollIndicatorRoot");
      this.scrollIndicatorRoot = var9;
      View var5 = var4.scrollIndicator;
      Intrinsics.checkNotNullExpressionValue(var5, "scrollIndicator");
      this.scrollIndicator = var5;
      this.setSaveEnabled(true);
   }

   public GraphView(Context var1, AttributeSet var2, int var3, int var4) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2, var3);
      GraphBinding var5 = GraphBinding.inflate(LayoutInflater.from(this.getContext()), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
      this.binding = var5;
      this.buttonInfo = var5.buttonInfo;
      this.graphRangeSelector = var5.graphRangeSelectorTop;
      LineChart var7 = var5.lineChart;
      Intrinsics.checkNotNullExpressionValue(var7, "lineChart");
      this.lineChart = var7;
      this.graphCompareLineGradient$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda0(this));
      this.selectedDatapointPublisher$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda1());
      Flowable var8 = this.getSelectedDatapointPublisher().debounce(25L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).map(new GraphView$$ExternalSyntheticLambda3(new GraphView$$ExternalSyntheticLambda2(this))).toFlowable(BackpressureStrategy.LATEST);
      Intrinsics.checkNotNullExpressionValue(var8, "toFlowable(...)");
      this.liveSelectedDataPoint = LiveDataReactiveStreams.fromPublisher((Publisher)var8);
      this.scaleChangedPublisher$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda4());
      var8 = this.getScaleChangedPublisher().toFlowable(BackpressureStrategy.LATEST);
      Intrinsics.checkNotNullExpressionValue(var8, "toFlowable(...)");
      this.liveScale = Transformations.distinctUntilChanged(LiveDataReactiveStreams.fromPublisher((Publisher)var8));
      this._liveTimeStamps = new MutableLiveData();
      this.viewModel$delegate = LazyKt.lazy(new GraphView$$ExternalSyntheticLambda5(this));
      FrameLayout var10 = var5.scrollIndicatorRoot;
      Intrinsics.checkNotNullExpressionValue(var10, "scrollIndicatorRoot");
      this.scrollIndicatorRoot = var10;
      View var6 = var5.scrollIndicator;
      Intrinsics.checkNotNullExpressionValue(var6, "scrollIndicator");
      this.scrollIndicator = var6;
      this.setSaveEnabled(true);
   }

   private static final void attachLifeCycle$lambda$6(GraphView var0, ChartTimeScale var1) {
      Intrinsics.checkNotNull(var1);
      var0.updateScale(var1, true);
   }

   private final boolean getRangeSelectorVisibility() {
      GraphRangeSelector var1 = this.getGraphRangeSelector();
      return var1 != null ? var1.isExpanded() : false;
   }

   private final PublishSubject getScaleChangedPublisher() {
      Object var1 = this.scaleChangedPublisher$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (PublishSubject)var1;
   }

   private final PublishSubject getSelectedDatapointPublisher() {
      Object var1 = this.selectedDatapointPublisher$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (PublishSubject)var1;
   }

   private final ChartTimeScale getTimeScale() {
      return ((GraphState)this.getViewModel().getState()).getTimeScale();
   }

   private static final int[] graphCompareLineGradient_delegate$lambda$0(GraphView var0) {
      return new int[]{ResourcesCompat.getColor(var0.getResources(), R.color.darkgray, var0.getContext().getTheme()), ResourcesCompat.getColor(var0.getResources(), R.color.silver, var0.getContext().getTheme())};
   }

   private final void highlightCenterDataEntry() {
      if (this.lineChart.getData() == null) {
         Timber.Forest.w("chart data is null", new Object[0]);
      } else {
         LineChart var5 = this.lineChart;
         MPPointD var7 = var5.getValuesByTouchPoint(var5.getViewPortHandler().contentLeft(), this.lineChart.getViewPortHandler().contentBottom(), this.lineChart.getAxisLeft().getAxisDependency());
         LineChart var6 = this.lineChart;
         MPPointD var10 = var6.getValuesByTouchPoint(var6.getViewPortHandler().contentRight(), this.lineChart.getViewPortHandler().contentBottom(), this.lineChart.getAxisLeft().getAxisDependency());
         double var1 = var7.x;
         double var3 = (var10.x - var7.x) / (double)2;
         this.lineChart.highlightValue((float)(var1 + var3), 0);
         Highlight[] var8 = this.lineChart.getHighlighted();
         if (var8 != null && var8.length != 0) {
            Collection var11 = (Collection)((LineData)this.lineChart.getData()).getDataSets();
            if (var11 != null && !var11.isEmpty()) {
               Entry var9 = ((ILineDataSet)((LineData)this.lineChart.getData()).getDataSets().get(0)).getEntryForXValue(var8[0].getX(), var8[0].getY());
               if (var9 == null) {
                  Timber.Forest.w("highlightCenterDataEntry; No entry highlighted on chart. Entry == null", new Object[0]);
               } else if (Intrinsics.areEqual(var9, this.getViewModel().getTempRelativelyTimedLastSelectedEntry())) {
                  Timber.Forest.w("highlightCenterDataEntry: IGNORE same entry selected", new Object[0]);
               } else {
                  this.selectedEntryUpdated(var9, true);
               }
            } else {
               Timber.Forest.w("LineChart has no data", new Object[0]);
            }
         } else {
            Timber.Forest.w("highlighted chart value is null or empty", new Object[0]);
         }
      }
   }

   private final void initialSetup() {
      LineChart var1 = this.binding.lineChart;
      var1.setDrawGridBackground(false);
      var1.getDescription().setEnabled(false);
      var1.getLegend().setEnabled(false);
      var1.setTouchEnabled(true);
      var1.setDragEnabled(true);
      var1.setDragXEnabled(true);
      var1.setDragYEnabled(false);
      var1.setPinchZoom(true);
      var1.setDoubleTapToZoomEnabled(false);
      var1.setScaleEnabled(true);
      var1.setScaleXEnabled(true);
      var1.setScaleYEnabled(false);
      this.binding.lineChart.setVisibleXRangeMinimum(440000.0F);
      this.binding.lineChart.setVisibleXRangeMaximum(2.678E9F);
      var1.setAutoScaleMinMaxEnabled(false);
      var1.setNoDataText("");
      var1.setClipValuesToContent(true);
      var1.setDragDecelerationFrictionCoef(0.85F);
      var1.setDrawMarkers(true);
      XAxis var2 = this.binding.lineChart.getXAxis();
      var2.setPosition(XAxisPosition.BOTTOM);
      var2.setDrawGridLines(false);
      var2.setDrawAxisLine(false);
      var2.setDrawLabels(false);
      var2.setTextColor(ContextCompat.getColor(this.getContext(), R.color.aquablue));
      YAxis var3 = this.binding.lineChart.getAxisLeft();
      var3.setDrawGridLines(false);
      var3.setDrawAxisLine(false);
      var3.setDrawLimitLinesBehindData(true);
      var3.setTextColor(ContextCompat.getColor(this.getContext(), R.color.aquablue));
      var3.setSpaceTop(0.0F);
      var3.setSpaceBottom(0.0F);
      var3.setAxisMinimum(0.0F);
      var3.setAxisMaximum(100.0F);
      this.binding.lineChart.getAxisRight().setEnabled(false);
      this.binding.lineChart.setOnChartGestureListener(this);
      this.binding.lineChart.setOnTouchListener(new GraphView$$ExternalSyntheticLambda6(this));
   }

   private static final boolean initialSetup$lambda$10(GraphView var0, View var1, MotionEvent var2) {
      if (var2 != null) {
         int var3 = var2.getAction();
         if (var3 != 0) {
            if (var3 == 1 || var3 == 3) {
               ViewParent var4 = var0.scrollingViewParent;
               if (var4 != null) {
                  var4.requestDisallowInterceptTouchEvent(false);
               }
            }
         } else {
            ViewParent var5 = var0.scrollingViewParent;
            if (var5 != null) {
               var5.requestDisallowInterceptTouchEvent(true);
            }
         }
      }

      return false;
   }

   private static final SelectedPoint liveSelectedDataPoint$lambda$2(GraphView var0, SelectedPoint var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.updateLegend(var1.getPoint());
      var0.updateHeaderSelectedDatapoint(var1);
      return var1;
   }

   private static final SelectedPoint liveSelectedDataPoint$lambda$3(Function1 var0, Object var1) {
      Intrinsics.checkNotNullParameter(var1, "p0");
      return (SelectedPoint)var0.invoke(var1);
   }

   private final LimitLine makeDateLine(float var1, String var2) {
      LimitLine var3 = new LimitLine(var1, var2);
      var3.setLineWidth(1.0F);
      var3.setLabelPosition(LimitLabelPosition.RIGHT_BOTTOM);
      var3.setTextColor(ContextCompat.getColor(this.getContext(), this.getDividerTextColor()));
      var3.setLineColor(ContextCompat.getColor(this.getContext(), this.getDividerLineColor()));
      var3.setTextSize(13.0F);
      return var3;
   }

   private static final PublishSubject scaleChangedPublisher_delegate$lambda$4() {
      return PublishSubject.create();
   }

   private static final PublishSubject selectedDatapointPublisher_delegate$lambda$1() {
      return PublishSubject.create();
   }

   private final void selectedEntryUpdated(Entry var1, boolean var2) {
      GraphState var4 = (GraphState)this.getViewModel().getState();
      this.setChartMarker(var1);
      ReversedResult var3 = this.getViewModel().reverseRelativelyTimedEntryToDataPoint(var1);
      if (var3 != null) {
         this.getSelectedDatapointPublisher().onNext(new SelectedPoint(var3.getDataPoint(), var3.getCompareDataPoint(), var2));
         if (var2) {
            Timber.Forest var6 = Timber.Forest;
            StringBuilder var5 = new StringBuilder("selectedEntryUpdated: entry = ");
            var5.append(var1);
            var5.append(", graphRelativeTimedDataPoints.last() = ");
            List var7 = var4.getGraphRelativeTimedDataPoints();
            Entry var8;
            if (var7 != null) {
               var8 = (Entry)CollectionsKt.lastOrNull(var7);
            } else {
               var8 = null;
            }

            var5.append(var8);
            var6.d(var5.toString(), new Object[0]);
            List var9 = var4.getGraphRelativeTimedDataPoints();
            Entry var10;
            if (var9 != null) {
               var10 = (Entry)CollectionsKt.lastOrNull(var9);
            } else {
               var10 = null;
            }

            if (Intrinsics.areEqual(var1, var10)) {
               this.getViewModel().setTempRelativelyTimedLastSelectedEntry((Entry)null);
               Timber.Forest.v("selectedEntryUpdated: clear selected", new Object[0]);
               return;
            }

            if (!Intrinsics.areEqual(var1, this.getViewModel().getTempRelativelyTimedLastSelectedEntry())) {
               this.getViewModel().setTempRelativelyTimedLastSelectedEntry(var1);
               Timber.Forest.v("selectedEntryUpdated: set selected", new Object[0]);
               return;
            }

            Timber.Forest.v("selectedEntryUpdated: IGNORE", new Object[0]);
         }
      }

   }

   private final void setChartMarker(Entry var1) {
      MarkerView var11 = new MarkerView(this.getContext(), com.blueair.graph.R.layout.markerview_dot_outdoor);
      View var12 = var11.findViewById(com.blueair.graph.R.id.dashed_line);
      double var4 = this.lineChart.getPixelForValues(var1.getX(), var1.getY(), AxisDependency.LEFT).y;
      float var8 = this.getResources().getDimension(R.dimen.chart_marker_size_outdoor);
      ViewGroup.LayoutParams var13 = var12.getLayoutParams();
      var13.height = (int)var4 - (int)var8;
      var12.setLayoutParams(var13);
      Integer var17 = this.getFixedMarkerImage();
      int var9;
      if (var17 != null) {
         var9 = var17;
      } else {
         List var19 = GraphUiUtils.INSTANCE.getSeverityDots();
         double var2 = (double)100.0F / (double)var19.size();

         int var10;
         for(var9 = 0; var9 < var19.size(); var9 = var10) {
            double var6 = (double)var1.getY();
            var10 = var9 + 1;
            if (!(var6 > (double)var10 * var2)) {
               break;
            }
         }

         Timber.Forest var14 = Timber.Forest;
         StringBuilder var18 = new StringBuilder("setChartMarker: val = ");
         var18.append(var1.getY());
         var18.append(", markerImgPos = ");
         var18.append(var9);
         var18.append(", result = ");
         var18.append((double)(var9 + 1) * var2);
         var14.d(var18.toString(), new Object[0]);
         var9 = ((Number)var19.get(var9)).intValue();
      }

      ((ImageView)var11.findViewById(com.blueair.graph.R.id.img)).setImageResource(var9);
      var8 *= -0.5F;
      var11.setOffset(var8, (float)var4 * -1.0F - var8);
      var11.setGravity(80);
      this.lineChart.setMarker((IMarker)var11);
   }

   private final void setScrollIndicatorPosition(float var1) {
      this.scrollIndicatorPosition = var1;
      this.updateScrollPosition();
   }

   private final void setupXAxisLines(ChartTimeScale var1, long var2, long var4) {
      this.lineChart.getXAxis().removeAllLimitLines();

      for(long var7 = var4; var7 >= var2; var7 -= var4) {
         GraphUtils var9 = GraphUtils.INSTANCE;
         Context var10 = this.getContext();
         Intrinsics.checkNotNullExpressionValue(var10, "getContext(...)");
         String var12 = GraphUtils.getStringDate$default(var9, var7, var10, false, 4, (Object)null);
         this.lineChart.getXAxis().addLimitLine(this.makeDateLine((float)(var7 - var2), var12));
         int var6 = GraphView.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
         if (var6 != 1) {
            if (var6 != 2) {
               if (var6 != 3) {
                  throw new NoWhenBranchMatchedException();
               }

               var4 = 1209600000L;
            } else {
               var4 = 259200000L;
            }
         } else {
            var4 = 3600000L;
         }
      }

   }

   private final void setupYAxisLines() {
      this.lineChart.getAxisLeft().removeAllLimitLines();
   }

   private final void showLegend(boolean var1) {
      Group var4 = this.binding.legendLabels;
      byte var3 = 0;
      byte var2;
      if (var1) {
         var2 = 0;
      } else {
         var2 = 4;
      }

      var4.setVisibility(var2);
      var4 = this.binding.legendOutdoorGroup;
      Intrinsics.checkNotNullExpressionValue(var4, "legendOutdoorGroup");
      View var8 = (View)var4;
      if (var1 && this.getShowOutdoorLegend()) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      if (var2) {
         var2 = var3;
      } else {
         var2 = 8;
      }

      var8.setVisibility(var2);
   }

   // $FF: synthetic method
   public static void updateHeaderSelectedDatapoint$default(GraphView var0, SelectedPoint var1, String var2, int var3, String var4, String var5, int var6, Object var7) {
      if (var7 == null) {
         if ((var6 & 16) != 0) {
            var5 = null;
         }

         var0.updateHeaderSelectedDatapoint(var1, var2, var3, var4, var5);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateHeaderSelectedDatapoint");
      }
   }

   private final void updateLegend(SimpleDatapoint var1) {
      Entry var6 = this.getViewModel().getLatestGraphDataPoint();
      long var4;
      if (var6 != null) {
         var4 = (long)var6.getX();
      } else {
         var4 = 0L;
      }

      var4 += this.getViewModel().getStartingTimeInMillis();
      Timber.Forest var9 = Timber.Forest;
      StringBuilder var7 = new StringBuilder("updateLegend: supportsLegend = ");
      var7.append(this.getSupportsLegend());
      var7.append(", selectedDataPoint = ");
      var7.append(var1);
      var7.append(", latest graphTime = ");
      var7.append(var4);
      var7.append(", viewModel.latestGraphDataPoint = ");
      var7.append(this.getViewModel().getLatestGraphDataPoint());
      String var10 = var7.toString();
      boolean var3 = false;
      var9.d(var10, new Object[0]);
      boolean var2 = var3;
      if (this.getSupportsLegend()) {
         label19: {
            if (this.getViewModel().getTempRelativelyTimedLastSelectedEntry() != null) {
               var2 = var3;
               if (var1 == null) {
                  break label19;
               }

               var2 = var3;
               if (Math.abs(var4 - var1.getTimeInMillis()) >= 1000L) {
                  break label19;
               }
            }

            var2 = true;
         }
      }

      this.showLegend(var2);
   }

   // $FF: synthetic method
   public static void updateScale$default(GraphView var0, ChartTimeScale var1, boolean var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 2) != 0) {
            var2 = false;
         }

         var0.updateScale(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateScale");
      }
   }

   private final void updateScrollPosition() {
      this.scrollIndicator.setX(((float)this.getWidth() - this.scrollIndicatorPosition) * ((float)this.getWidth() - (float)(this.getWidth() - this.scrollIndicatorRoot.getWidth()) - (float)this.scrollIndicatorWidth) / (float)this.getWidth());
   }

   private final void updateScrollScale(float var1) {
      var1 = RangesKt.coerceAtMost(var1, 10.0F);
      int var2 = this.scrollIndicatorRoot.getWidth();
      this.scrollIndicatorWidth = MathKt.roundToInt(((float)11 - var1) * (float)(var2 / 11));
      this.scrollIndicator.getLayoutParams().width = this.scrollIndicatorWidth;
      this.scrollIndicator.requestLayout();
      this.updateScrollPosition();
   }

   private static final GraphViewModel viewModel_delegate$lambda$5(GraphView var0) {
      return var0.createViewModel();
   }

   public void attachLifeCycle(LifecycleOwner var1) {
      Intrinsics.checkNotNullParameter(var1, "lifecycleOwner");
      super.attachLifeCycle(var1);
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("attachLifeCycle: graphRangeSelector = ");
      var2.append(this.getGraphRangeSelector());
      var3.d(var2.toString(), new Object[0]);
      GraphRangeSelector var4 = this.getGraphRangeSelector();
      if (var4 != null) {
         LiveData var5 = var4.getLiveScale();
         if (var5 != null) {
            var5.observe(var1, new GraphView$$ExternalSyntheticLambda7(this));
         }
      }

   }

   protected abstract GraphViewModel createViewModel();

   protected final GraphBinding getBinding() {
      return this.binding;
   }

   public MaterialButton getButtonInfo() {
      return this.buttonInfo;
   }

   protected abstract int getDividerLineColor();

   protected abstract int getDividerTextColor();

   public abstract LineDataSet.Mode getDrawingMode();

   protected abstract String getEmptyStateSeverityLabel();

   protected abstract Integer getFixedMarkerImage();

   protected int[] getGraphCompareLineGradient() {
      return (int[])this.graphCompareLineGradient$delegate.getValue();
   }

   protected abstract int[] getGraphLineGradient();

   protected abstract Integer getGraphLineSingleColor();

   protected GraphRangeSelector getGraphRangeSelector() {
      return this.graphRangeSelector;
   }

   protected abstract Integer getGraphfillDrawable();

   public final LiveData getLiveScale() {
      return this.liveScale;
   }

   public final LiveData getLiveSelectedDataPoint() {
      return this.liveSelectedDataPoint;
   }

   public final LiveData getLiveTimeStamps() {
      return Transformations.distinctUntilChanged((LiveData)this._liveTimeStamps);
   }

   public final ViewParent getScrollingViewParent() {
      return this.scrollingViewParent;
   }

   public abstract boolean getShowOutdoorLegend();

   protected abstract boolean getSupportsLegend();

   public GraphViewModel getViewModel() {
      return (GraphViewModel)this.viewModel$delegate.getValue();
   }

   public final void gotoTime(long var1) {
      this.getViewModel().gotoTime(var1);
   }

   protected final void initUiOverlay() {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var1 = new StringBuilder("initUiOverlay: graphRangeSelector = ");
      var1.append(this.getGraphRangeSelector());
      var1.append(", graph_range_selector_top = ");
      var1.append(this.binding.graphRangeSelectorTop);
      var2.d(var1.toString(), new Object[0]);
      GraphRangeSelector var3 = this.getGraphRangeSelector();
      if (var3 != null) {
         var3.reset();
      }

      var3 = this.getGraphRangeSelector();
      if (var3 != null) {
         var3.updateTimeScale(this.getTimeScale());
      }

   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.initialSetup();
      this.initUiOverlay();
      this.setupUiOverlay();
      this.showEmptyState();
      ProgressBlockerView var1 = this.binding.progressView;
      Intrinsics.checkNotNullExpressionValue(var1, "progressView");
      ViewExtensionsKt.show$default((View)var1, false, 1, (Object)null);
      if (this instanceof IndoorGraphView) {
         FrameLayout var3 = this.scrollIndicatorRoot;
         IndoorGraphView var2 = (IndoorGraphView)this;
         var3.setBackground(ResourcesCompat.getDrawable(var2.getResources(), R.drawable.bg_scroll_graph_indoor, (Resources.Theme)null));
         this.scrollIndicator.setBackground(ResourcesCompat.getDrawable(var2.getResources(), R.drawable.graph_scroll_indoor, (Resources.Theme)null));
      }

   }

   public void onChartDoubleTapped(MotionEvent var1) {
   }

   public void onChartFling(MotionEvent var1, MotionEvent var2, float var3, float var4) {
   }

   public void onChartGestureEnd(MotionEvent var1, ChartTouchListener.ChartGesture var2) {
      this.highlightCenterDataEntry();
   }

   public void onChartGestureStart(MotionEvent var1, ChartTouchListener.ChartGesture var2) {
      this.prevDX = 0.0F;
   }

   public void onChartLongPressed(MotionEvent var1) {
   }

   public void onChartScale(MotionEvent var1, float var2, float var3) {
      var2 = this.lineChart.getScaleX();
      this.updateScrollScale(var2);
      Timber.Forest var8 = Timber.Forest;
      StringBuilder var6 = new StringBuilder("onChartScale: nuScaleX = ");
      var6.append(var2);
      var8.d(var6.toString(), new Object[0]);
      if (var2 > 8978.0F) {
         LineChart var10 = this.lineChart;
         var10.zoomAndCenterAnimated(8928.0F, var3, var10.getHighestVisibleX(), 0.0F, this.lineChart.getAxisLeft().getAxisDependency(), 500L);
      } else {
         double var4 = (double)var2;
         ChartTimeScale var9;
         if (var4 >= (double)192.0F) {
            var9 = ChartTimeScale.DAY;
         } else if (var4 >= (double)8.0F) {
            var9 = ChartTimeScale.WEEK;
         } else {
            var9 = ChartTimeScale.MONTH;
         }

         Timber.Forest var7 = Timber.Forest;
         var6 = new StringBuilder("onChartScale: nuScale = ");
         var6.append(var9);
         var6.append(", oldScale = ");
         var6.append(((GraphState)this.getViewModel().getState()).getTimeScale());
         var7.d(var6.toString(), new Object[0]);
         if (var9 != ((GraphState)this.getViewModel().getState()).getTimeScale()) {
            this.updateScale(var9, true);
         }

      }
   }

   public void onChartSingleTapped(MotionEvent var1) {
   }

   public void onChartTranslate(MotionEvent var1, float var2, float var3) {
      float var4 = Math.abs(var2) - Math.abs(this.prevDX);
      var3 = var4;
      if (var2 < 0.0F) {
         var3 = -var4;
      }

      this.prevDX = var2;
      this.setScrollIndicatorPosition(RangesKt.coerceIn(this.scrollIndicatorPosition + var3 / this.lineChart.getScaleX(), 0.0F, (float)this.lineChart.getWidth()));
      this.highlightCenterDataEntry();
   }

   protected void onDetachedFromWindow() {
      this.binding.lineChart.setOnChartGestureListener((OnChartGestureListener)null);
      super.onDetachedFromWindow();
   }

   public void onStateUpdate(GraphState var1) {
      Intrinsics.checkNotNullParameter(var1, "state");
      boolean var7 = var1.getShouldShowGraph();
      GraphState var8 = this.lastState;
      boolean var5;
      if (var8 != null && var8.getShouldShowGraph()) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      ChartTimeScale var9 = var1.getTimeScale();
      var8 = this.lastState;
      ChartTimeScale var30;
      if (var8 != null) {
         var30 = var8.getTimeScale();
      } else {
         var30 = null;
      }

      boolean var6;
      if (var9 != var30 || var7 && !var5) {
         var6 = true;
      } else {
         var6 = false;
      }

      Timber.Forest var11 = Timber.Forest;
      StringBuilder var10 = new StringBuilder("onStateUpdate: shouldShowGraph = ");
      var10.append(var7);
      var10.append(", shouldChangeScale = ");
      var10.append(var6);
      var10.append(", hasScaleZoomed = ");
      var10.append(this.hasScaleZoomed);
      var10.append(", points.size = ");
      List var31 = var1.getGraphRelativeTimedDataPoints();
      Integer var32;
      if (var31 != null) {
         var32 = var31.size();
      } else {
         var32 = null;
      }

      var10.append(var32);
      String var50 = ", ";
      var10.append(", ");
      var10.append(this);
      var11.v(var10.toString(), new Object[0]);
      ProgressBlockerView var33 = this.binding.progressView;
      Intrinsics.checkNotNullExpressionValue(var33, "progressView");
      ViewExtensionsKt.show((View)var33, var7 ^ true);
      float var2 = (float)(var1.getLatestTimeInMillis() - var1.getStartingTimeInMillis());
      LineData var12 = new LineData();
      List var34;
      if (var7) {
         var34 = var1.getGraphRelativeTimedDataPoints();
      } else {
         var34 = CollectionsKt.emptyList();
      }

      LineDataSet var79 = new LineDataSet(var34, "DataSet Month");
      var79.setDrawIcons(true);
      var79.setLineWidth(3.0F);
      var79.setDrawValues(false);
      var79.setFormLineWidth(1.0F);
      var79.setFormSize(15.0F);
      var79.setMode(this.getDrawingMode());
      var79.setDrawCircles(false);
      var79.setDrawHighlightIndicators(false);
      Integer var35 = this.getGraphLineSingleColor();
      if (var35 != null) {
         var79.setColor(((Number)var35).intValue());
      }

      if (this.getGraphLineSingleColor() == null) {
         int[] var36 = this.getGraphLineGradient();
         if (var36 != null) {
            var79.setColors(ArraysKt.toList(var36));
         }
      }

      var35 = this.getGraphfillDrawable();
      if (var35 != null) {
         var5 = ((Number)var35).intValue();
         var79.setDrawFilled(true);
         var79.setFillDrawable(ResourcesCompat.getDrawable(this.getResources(), var5, this.getContext().getTheme()));
      }

      var12.addDataSet((IDataSet)var79);
      if (var7) {
         float var3;
         label238: {
            List var38 = var1.getGraphRelativeTimedDataPoints();
            if (var38 != null) {
               Entry var39 = (Entry)CollectionsKt.lastOrNull(var38);
               if (var39 != null) {
                  var3 = var39.getX();
                  break label238;
               }
            }

            var3 = var2;
         }

         var3 = Math.min(var3, var2);
         Timber.Forest var13 = Timber.Forest;
         var10 = new StringBuilder("onStateUpdate: maxCompareTime = ");
         var10.append(var3);
         var10.append(", lastpoint = (");
         List var40 = var1.getGraphRelativeTimedDataPoints();
         Entry var41;
         if (var40 != null) {
            var41 = (Entry)CollectionsKt.lastOrNull(var40);
         } else {
            var41 = null;
         }

         var10.append(var41);
         var10.append("), graphTimeMaximum = ");
         var10.append(var2);
         var10.append(", ");
         var10.append(this);
         var13.v(var10.toString(), new Object[0]);
         List var42 = var1.getCompareGraphDataPoints();
         String var44;
         List var53;
         if (var42 == null) {
            var44 = ", ";
            var53 = null;
         } else {
            Iterable var43 = (Iterable)var42;
            Collection var67 = (Collection)(new ArrayList());
            Iterator var83 = var43.iterator();
            var44 = var50;

            while(var83.hasNext()) {
               Entry var51 = (Entry)var83.next();
               if (var51.getX() >= (float)var1.getStartingTimeInMillis() && var51.getX() - (float)var1.getStartingTimeInMillis() <= var3) {
                  var51 = new Entry(var51.getX() - (float)var1.getStartingTimeInMillis(), var51.getY());
               } else {
                  var51 = null;
               }

               if (var51 != null) {
                  var67.add(var51);
               }
            }

            var53 = CollectionsKt.toMutableList((Collection)((List)var67));
         }

         Entry var68;
         if (var53 != null) {
            var68 = (Entry)CollectionsKt.lastOrNull(var53);
         } else {
            var68 = null;
         }

         if (var68 != null && (double)var68.getX() < (double)var3 - 0.001) {
            var53.add(new Entry(var3, var68.getY()));
         }

         var13 = Timber.Forest;
         StringBuilder var14 = new StringBuilder("onStateUpdate: comparePoints.last = (");
         if (var53 != null) {
            var68 = (Entry)CollectionsKt.lastOrNull(var53);
         } else {
            var68 = null;
         }

         var14.append(var68);
         var14.append("), ");
         var14.append(this);
         var13.v(var14.toString(), new Object[0]);
         Collection var70 = (Collection)var53;
         LineDataSet var71;
         if (var70 != null && !var70.isEmpty()) {
            var71 = new LineDataSet(var53, "DataSet Compare");
         } else {
            var71 = null;
         }

         if (var71 != null) {
            var71.setDrawIcons(true);
            var71.setLineWidth(3.0F);
            var71.setDrawValues(false);
            var71.setFormLineWidth(1.0F);
            var71.setFormSize(15.0F);
            var71.setMode(this.getDrawingMode());
            var71.setDrawCircles(false);
            var71.setDrawHighlightIndicators(false);
            var71.setColors(ArraysKt.toList(this.getGraphCompareLineGradient()));
         }

         var50 = var44;
         if (var71 != null) {
            var12.addDataSet((IDataSet)var71);
            var50 = var44;
         }
      } else {
         var50 = ", ";
      }

      this.lineChart.setData((ChartData)var12);
      XAxis var45 = this.lineChart.getXAxis();
      var45.setAxisMinimum(0.0F);
      var45.setAxisMaximum(var2);
      if (var1.getTimeScale() == ChartTimeScale.DAY) {
         var5 = 2;
      } else {
         var5 = 3;
      }

      var45.setLabelCount(var5);
      var45.setValueFormatter(new DayAxisValueFormatter(DateFormat.is24HourFormat(this.getContext()), var1.getStartingTimeInMillis(), var1.getTimeScale()));
      if (var7) {
         float var17 = (float)ViewHelperUtil.INSTANCE.getScreenWidth((View)this) / 2.0F;
         this.lineChart.getViewPortHandler().setDragOffsetX(Utils.convertPixelsToDp(var17));
         var45.setGranularity(1.0F);
         var45.setDrawLimitLinesBehindData(true);
      }

      YAxis var46 = this.lineChart.getAxisLeft();
      var46.setAxisMinimum(-10.0F);
      var46.setLabelCount(var1.getNumberOfRanges(), true);
      var46.setValueFormatter(new YAxisValueFormatterOutdoor(CollectionsKt.toDoubleArray((Collection)var1.getMaxThresholds())));
      var46.setDrawLabels(false);
      if (var7 && var1.getGraphRelativeTimedDataPoints() != null) {
         this.setupYAxisLines();
         Timber.Forest var72 = Timber.Forest;
         StringBuilder var47 = new StringBuilder("onStateUpdate: setupXAxisLines, timeScale = ");
         var47.append(var1.getTimeScale());
         var47.append(", startingTimeInMillis = ");
         var47.append(var1.getStartingTimeInMillis());
         var47.append(", latestTimeInMillis = ");
         var47.append(var1.getLatestTimeInMillis());
         var47.append(var50);
         var47.append(this);
         var72.v(var47.toString(), new Object[0]);
         this.setupXAxisLines(var1.getTimeScale(), var1.getStartingTimeInMillis(), var1.getLatestTimeInMillis());
      } else {
         this.lineChart.getAxisLeft().removeAllLimitLines();
         this.lineChart.getXAxis().removeAllLimitLines();
      }

      Entry var55 = var1.getRelativelyTimedLastSelectedEntry();
      Entry var48;
      if (var55 != null) {
         var48 = var79.getEntryForXValue(var55.getX(), var55.getY());
      } else {
         List var49 = var1.getGraphRelativeTimedDataPoints();
         if (var49 != null) {
            var48 = (Entry)CollectionsKt.lastOrNull(var49);
         } else {
            var48 = null;
         }
      }

      Timber.Forest var73 = Timber.Forest;
      StringBuilder var80 = new StringBuilder("onStateUpdate: nuSelected = (");
      var80.append(var48);
      var80.append("), lastSelectedGraphEntry = (");
      var80.append(var55);
      var80.append("), ");
      var80.append(this);
      var73.v(var80.toString(), new Object[0]);
      if (var48 != null) {
         this.selectedEntryUpdated(var48, false);
         this.lineChart.highlightValue(var48.getX(), 0);
      }

      this.lineChart.invalidate();
      if (var6) {
         ChartTimeScale var56 = var1.getTimeScale();
         var5 = GraphView.WhenMappings.$EnumSwitchMapping$0[var56.ordinal()];
         float var18;
         if (var5 != 1) {
            if (var5 != 2) {
               if (var5 != 3) {
                  throw new NoWhenBranchMatchedException();
               }

               var18 = 1.0F;
            } else {
               var18 = 10.0F;
            }
         } else {
            var18 = 320.0F;
         }

         Timber.Forest var81 = Timber.Forest;
         StringBuilder var74 = new StringBuilder("scaling: hasScaled = ");
         var74.append(this.hasScaleZoomed);
         var74.append(", zoomX = ");
         Float var57;
         if (var48 != null) {
            var57 = var48.getX();
         } else {
            var57 = null;
         }

         var74.append(var57);
         var74.append(", maxX = ");
         float var4 = (float)var1.getLatestTimeInMillis();
         var74.append(var4 - (float)var1.getStartingTimeInMillis());
         var74.append(", this = ");
         var74.append(this);
         var81.d(var74.toString(), new Object[0]);
         if (this.hasScaleZoomed) {
            LineChart var58 = this.lineChart;
            if (var48 != null) {
               var4 = var48.getX();
            } else {
               var4 = var2;
            }

            var58.zoomAndCenterAnimated(var18, 1.0F, var4, 0.0F, this.lineChart.getAxisLeft().getAxisDependency(), 600L);
         } else {
            this.hasScaleZoomed = true;
            LineChart var59 = this.lineChart;
            if (var48 != null) {
               var4 = var48.getX();
            } else {
               var4 = var2;
            }

            var59.zoom(var18, 1.0F, var4, 0.0F);
            var59 = this.lineChart;
            if (var48 != null) {
               var18 = var48.getX();
            } else {
               var18 = var2;
            }

            var59.centerViewTo(var18, 0.0F, this.lineChart.getAxisLeft().getAxisDependency());
         }
      } else {
         LineChart var61 = this.lineChart;
         float var20;
         if (var48 != null) {
            var20 = var48.getX();
         } else {
            var20 = var2;
         }

         var61.centerViewToAnimated(var20, 0.0F, this.lineChart.getAxisLeft().getAxisDependency(), 600L);
      }

      if (!var7 || var1.getGraphRelativeTimedDataPoints() == null) {
         GraphRangeSelector var62 = this.getGraphRangeSelector();
         if (var62 != null) {
            var62.hideRangeSelector();
         }

         this.showEmptyState();
      }

      if (var1.getTimeStampFilter() == null) {
         MutableLiveData var82 = this._liveTimeStamps;
         List var75 = var1.getGraphReducedHistoricalDataPoints();
         List var63 = var75;
         if (var75 == null) {
            var63 = CollectionsKt.emptyList();
         }

         Collection var76 = (Collection)var63;
         var63 = var1.getGraphRealTimeDataPoints();
         if (var63 == null) {
            var63 = CollectionsKt.emptyList();
         }

         Iterable var77 = (Iterable)CollectionsKt.plus(var76, (Iterable)var63);
         Collection var65 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var77, 10)));
         Iterator var78 = var77.iterator();

         while(var78.hasNext()) {
            var65.add(((Entry)var78.next()).getX());
         }

         var82.postValue(CollectionsKt.toSet((Iterable)((List)var65)));
      }

      this.lastState = var1;
      ChartTimeScale var15 = var1.getTimeScale();
      var5 = GraphView.WhenMappings.$EnumSwitchMapping$0[var15.ordinal()];
      float var21;
      if (var5 != 1) {
         if (var5 != 2) {
            if (var5 != 3) {
               throw new NoWhenBranchMatchedException();
            }

            var21 = 1.0F;
         } else {
            var21 = 10.0F;
         }
      } else {
         var21 = 320.0F;
      }

      this.updateScrollScale(var21);
      if (var48 != null) {
         var21 = ((Number)var48.getX()).floatValue();
         this.setScrollIndicatorPosition((float)this.getWidth() - (float)this.getWidth() / var2 * var21);
         ViewExtensionsKt.show$default((View)this.scrollIndicatorRoot, false, 1, (Object)null);
      }

   }

   public final void refresh() {
      this.getViewModel().refresh();
   }

   public final void setScrollingViewParent(ViewParent var1) {
      this.scrollingViewParent = var1;
   }

   public final void setTimeStampFilter(Set var1) {
      Intrinsics.checkNotNullParameter(var1, "nuTimeStampFilter");
      this.getViewModel().setTimeStampFilter(var1);
   }

   public abstract void setupUiOverlay();

   protected void showEmptyState() {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var1 = new StringBuilder("showEmptyState: emptyStateSeverityLabel  = ");
      var1.append(this.getEmptyStateSeverityLabel());
      var2.d(var1.toString(), new Object[0]);
      GraphRangeSelector var3 = this.getGraphRangeSelector();
      if (var3 != null) {
         var3.reset();
      }

      this.binding.valueLabel.setVisibility(8);
      if (this.getFixedMarkerImage() != null) {
         this.showLegend(false);
         this.binding.severityLabel.setVisibility(4);
      } else {
         this.showLegend(true);
         this.binding.severityLabel.setText((CharSequence)this.getEmptyStateSeverityLabel());
         this.binding.severityLabel.setVisibility(0);
         this.binding.severityLabel.setContentDescription((CharSequence)null);
      }
   }

   public abstract void updateHeaderSelectedDatapoint(SelectedPoint var1);

   protected final void updateHeaderSelectedDatapoint(SelectedPoint var1, String var2, int var3, String var4, String var5) {
      Intrinsics.checkNotNullParameter(var1, "selectedPoint");
      SimpleDatapoint var7 = var1.getPoint();
      Timber.Forest.d("updateHeaderSelectedDatapoint", new Object[0]);
      GraphRangeSelector var6 = this.getGraphRangeSelector();
      if (var6 != null) {
         var6.updateTime(var7);
      }

      String var16 = var5;
      if (var5 == null) {
         StringBuilder var15 = new StringBuilder();
         var15.append(MathKt.roundToInt(var7.getValue()));
         if (var2 != null) {
            StringBuilder var17 = new StringBuilder(" ");
            var17.append(var2);
            var2 = var17.toString();
         } else {
            var2 = "";
         }

         var15.append(var2);
         var16 = var15.toString();
      }

      if (var1.getComparedPoint() != null) {
         StringBuilder var12 = new StringBuilder(" (");
         var12.append(MathKt.roundToInt(var1.getComparedPoint().getValue()));
         var12.append(") ");
         String var8 = var12.toString();
         var12 = new StringBuilder();
         var12.append(var16);
         var12.append(var8);
         SpannableString var14 = new SpannableString((CharSequence)var12.toString());
         var14.setSpan(new ForegroundColorSpan(ResourcesCompat.getColor(this.getResources(), R.color.niekiegray, this.getContext().getTheme())), var14.length() - var8.length(), var14.length(), 0);
         SpannableStringBuilder var9 = new SpannableStringBuilder();
         var9.append((CharSequence)var14);
         this.binding.valueLabel.setText((CharSequence)var9, BufferType.SPANNABLE);
      } else {
         this.binding.valueLabel.setText((CharSequence)var16);
      }

      this.binding.valueLabel.setTextColor(ResourcesCompat.getColor(this.getResources(), var3, this.getContext().getTheme()));
      if (!this.getRangeSelectorVisibility()) {
         this.binding.valueLabel.setVisibility(0);
      }

      CharSequence var10 = (CharSequence)var4;
      if (var10 != null && var10.length() != 0) {
         this.binding.severityLabel.setText(var10);
         this.binding.severityLabel.setVisibility(0);
         this.binding.severityLabel.setContentDescription((CharSequence)this.getResources().getString(R.string.current_aqi_content_description, new Object[]{var4}));
      } else {
         this.binding.severityLabel.setVisibility(8);
      }
   }

   public final void updateProgress(boolean var1) {
      ProgressBlockerView var2 = this.binding.progressView;
      Intrinsics.checkNotNullExpressionValue(var2, "progressView");
      ViewExtensionsKt.show((View)var2, var1);
   }

   public final void updateScale(ChartTimeScale var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "timeScale");
      Timber.Forest var6 = Timber.Forest;
      StringBuilder var5 = new StringBuilder("updateScale: this = ");
      var5.append(this);
      var5.append(", timeScale = ");
      var5.append(var1);
      var6.d(var5.toString(), new Object[0]);
      GraphViewModel.updateScale$default(this.getViewModel(), var1, false, 2, (Object)null);
      this.getScaleChangedPublisher().onNext(new ScaleEvent(var1, var2));
      GraphRangeSelector var7 = this.getGraphRangeSelector();
      if (var7 != null) {
         var7.updateTimeScale(var1);
      }

      int var4 = GraphView.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
      float var3;
      if (var4 != 1) {
         if (var4 != 2) {
            if (var4 != 3) {
               throw new NoWhenBranchMatchedException();
            }

            var3 = 1.0F;
         } else {
            var3 = 10.0F;
         }
      } else {
         var3 = 320.0F;
      }

      this.updateScrollScale(var3);
   }

   @Metadata(
      d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"},
      d2 = {"Lcom/blueair/graph/view/GraphView$Companion;", "", "<init>", "()V", "MIN_VISIBLE_X_RANGE_DEFAULT", "", "MAX_VISIBLE_X_RANGE_DEFAULT", "ONE_HOUR_IN_MILLIS", "", "ONE_DAY_IN_MILLIS", "ONE_WEEK_IN_MILLIS", "SCALE_MONTH", "SCALE_WEEK", "SCALE_DAY", "SCALE_MAX", "SCALED_Y_MAX", "", "SCALE_CHANGE_PERC_WEEK", "SCALE_CHANGE_PERC_DAY", "LATEST_TIME_ERROR_MILLIS", "", "SCALE_CHANGE_ANIM_DURATION", "graph_otherRelease"},
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
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"},
      d2 = {"Lcom/blueair/graph/view/GraphView$ScaleEvent;", "", "timeScale", "Lcom/blueair/graph/utils/ChartTimeScale;", "explicit", "", "<init>", "(Lcom/blueair/graph/utils/ChartTimeScale;Z)V", "getTimeScale", "()Lcom/blueair/graph/utils/ChartTimeScale;", "getExplicit", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "graph_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ScaleEvent {
      private final boolean explicit;
      private final ChartTimeScale timeScale;

      public ScaleEvent(ChartTimeScale var1, boolean var2) {
         Intrinsics.checkNotNullParameter(var1, "timeScale");
         super();
         this.timeScale = var1;
         this.explicit = var2;
      }

      // $FF: synthetic method
      public static ScaleEvent copy$default(ScaleEvent var0, ChartTimeScale var1, boolean var2, int var3, Object var4) {
         if ((var3 & 1) != 0) {
            var1 = var0.timeScale;
         }

         if ((var3 & 2) != 0) {
            var2 = var0.explicit;
         }

         return var0.copy(var1, var2);
      }

      public final ChartTimeScale component1() {
         return this.timeScale;
      }

      public final boolean component2() {
         return this.explicit;
      }

      public final ScaleEvent copy(ChartTimeScale var1, boolean var2) {
         Intrinsics.checkNotNullParameter(var1, "timeScale");
         return new ScaleEvent(var1, var2);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof ScaleEvent)) {
            return false;
         } else {
            var1 = var1;
            if (this.timeScale != var1.timeScale) {
               return false;
            } else {
               return this.explicit == var1.explicit;
            }
         }
      }

      public final boolean getExplicit() {
         return this.explicit;
      }

      public final ChartTimeScale getTimeScale() {
         return this.timeScale;
      }

      public int hashCode() {
         return this.timeScale.hashCode() * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.explicit);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("ScaleEvent(timeScale=");
         var1.append(this.timeScale);
         var1.append(", explicit=");
         var1.append(this.explicit);
         var1.append(')');
         return var1.toString();
      }
   }

   @Metadata(
      d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"},
      d2 = {"Lcom/blueair/graph/view/GraphView$SelectedPoint;", "", "point", "Lcom/blueair/core/model/SimpleDatapoint;", "comparedPoint", "explicit", "", "<init>", "(Lcom/blueair/core/model/SimpleDatapoint;Lcom/blueair/core/model/SimpleDatapoint;Z)V", "getPoint", "()Lcom/blueair/core/model/SimpleDatapoint;", "getComparedPoint", "getExplicit", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "graph_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SelectedPoint {
      private final SimpleDatapoint comparedPoint;
      private final boolean explicit;
      private final SimpleDatapoint point;

      public SelectedPoint(SimpleDatapoint var1, SimpleDatapoint var2, boolean var3) {
         Intrinsics.checkNotNullParameter(var1, "point");
         super();
         this.point = var1;
         this.comparedPoint = var2;
         this.explicit = var3;
      }

      // $FF: synthetic method
      public static SelectedPoint copy$default(SelectedPoint var0, SimpleDatapoint var1, SimpleDatapoint var2, boolean var3, int var4, Object var5) {
         if ((var4 & 1) != 0) {
            var1 = var0.point;
         }

         if ((var4 & 2) != 0) {
            var2 = var0.comparedPoint;
         }

         if ((var4 & 4) != 0) {
            var3 = var0.explicit;
         }

         return var0.copy(var1, var2, var3);
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

      public final SelectedPoint copy(SimpleDatapoint var1, SimpleDatapoint var2, boolean var3) {
         Intrinsics.checkNotNullParameter(var1, "point");
         return new SelectedPoint(var1, var2, var3);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof SelectedPoint)) {
            return false;
         } else {
            var1 = var1;
            if (!Intrinsics.areEqual(this.point, var1.point)) {
               return false;
            } else if (!Intrinsics.areEqual(this.comparedPoint, var1.comparedPoint)) {
               return false;
            } else {
               return this.explicit == var1.explicit;
            }
         }
      }

      public final SimpleDatapoint getComparedPoint() {
         return this.comparedPoint;
      }

      public final boolean getExplicit() {
         return this.explicit;
      }

      public final SimpleDatapoint getPoint() {
         return this.point;
      }

      public int hashCode() {
         int var2 = this.point.hashCode();
         SimpleDatapoint var3 = this.comparedPoint;
         int var1;
         if (var3 == null) {
            var1 = 0;
         } else {
            var1 = var3.hashCode();
         }

         return (var2 * 31 + var1) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.explicit);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("SelectedPoint(point=");
         var1.append(this.point);
         var1.append(", comparedPoint=");
         var1.append(this.comparedPoint);
         var1.append(", explicit=");
         var1.append(this.explicit);
         var1.append(')');
         return var1.toString();
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
