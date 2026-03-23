package com.blueair.graph.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.res.ResourcesCompat;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.SensorType;
import com.blueair.core.model.SimpleDatapoint;
import com.blueair.graph.view.GraphView;
import com.blueair.graph.viewmodel.GraphState;
import com.blueair.graph.viewmodel.GraphViewModel;
import com.blueair.viewcore.R;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u00106\u001a\u000207H\u0014J\b\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020<H\u0016J\u001c\u0010=\u001a\u0002092\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?H@¢\u0006\u0002\u0010AJ\u001c\u0010B\u001a\u0002092\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?H@¢\u0006\u0002\u0010AR\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0019XD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0014\u0010!\u001a\u00020\"XD¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010(\u001a\u0004\u0018\u00010)X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001b\u0010,\u001a\u00020-8TX\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010'R\u0014\u00104\u001a\u00020\u0019XD¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001b¨\u0006C"}, d2 = {"Lcom/blueair/graph/view/FanHistoryGraphView;", "Lcom/blueair/graph/view/GraphView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttonInfo", "Lcom/google/android/material/button/MaterialButton;", "getButtonInfo", "()Lcom/google/android/material/button/MaterialButton;", "graphRangeSelector", "Lcom/blueair/graph/view/GraphRangeSelector;", "getGraphRangeSelector", "()Lcom/blueair/graph/view/GraphRangeSelector;", "drawingMode", "Lcom/github/mikephil/charting/data/LineDataSet$Mode;", "getDrawingMode", "()Lcom/github/mikephil/charting/data/LineDataSet$Mode;", "supportsLegend", "", "getSupportsLegend", "()Z", "dividerLineColor", "getDividerLineColor", "()I", "dividerTextColor", "getDividerTextColor", "emptyStateSeverityLabel", "", "getEmptyStateSeverityLabel", "()Ljava/lang/String;", "fixedMarkerImage", "getFixedMarkerImage", "()Ljava/lang/Integer;", "graphLineSingleColor", "", "getGraphLineSingleColor", "()Ljava/lang/Void;", "graphLineGradient", "", "getGraphLineGradient", "()[I", "graphLineGradient$delegate", "Lkotlin/Lazy;", "graphfillDrawable", "getGraphfillDrawable", "showOutdoorLegend", "getShowOutdoorLegend", "createViewModel", "Lcom/blueair/graph/viewmodel/GraphViewModel;", "setupUiOverlay", "", "updateHeaderSelectedDatapoint", "selectedPoint", "Lcom/blueair/graph/view/GraphView$SelectedPoint;", "updateHistorical", "nuDatapoints", "", "Lcom/blueair/core/model/SimpleDatapoint;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRealTime", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: FanHistoryGraphView.kt */
public final class FanHistoryGraphView extends GraphView {
    private final MaterialButton buttonInfo;
    private final int dividerLineColor = R.color.indoor_divider_line;
    private final int dividerTextColor = R.color.indoor_divider_text;
    private final LineDataSet.Mode drawingMode = LineDataSet.Mode.HORIZONTAL_BEZIER;
    private final String emptyStateSeverityLabel = "";
    private final int fixedMarkerImage = R.drawable.ic_marker_dot_tealblue;
    private final Lazy graphLineGradient$delegate = LazyKt.lazy(new FanHistoryGraphView$$ExternalSyntheticLambda0(this));
    private final Void graphLineSingleColor;
    private final GraphRangeSelector graphRangeSelector;
    private final int graphfillDrawable = R.drawable.fill_gradient_fan_graph;
    private final boolean showOutdoorLegend;
    private final boolean supportsLegend;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FanHistoryGraphView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        getViewModel().setSensorType(SensorType.FAN);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FanHistoryGraphView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        getViewModel().setSensorType(SensorType.FAN);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FanHistoryGraphView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        getViewModel().setSensorType(SensorType.FAN);
    }

    public MaterialButton getButtonInfo() {
        return this.buttonInfo;
    }

    /* access modifiers changed from: protected */
    public GraphRangeSelector getGraphRangeSelector() {
        return this.graphRangeSelector;
    }

    public LineDataSet.Mode getDrawingMode() {
        return this.drawingMode;
    }

    /* access modifiers changed from: protected */
    public boolean getSupportsLegend() {
        return this.supportsLegend;
    }

    /* access modifiers changed from: protected */
    public int getDividerLineColor() {
        return this.dividerLineColor;
    }

    /* access modifiers changed from: protected */
    public int getDividerTextColor() {
        return this.dividerTextColor;
    }

    /* access modifiers changed from: protected */
    public String getEmptyStateSeverityLabel() {
        return this.emptyStateSeverityLabel;
    }

    /* access modifiers changed from: protected */
    public Integer getFixedMarkerImage() {
        return Integer.valueOf(this.fixedMarkerImage);
    }

    /* access modifiers changed from: protected */
    public Void getGraphLineSingleColor() {
        return this.graphLineSingleColor;
    }

    /* access modifiers changed from: protected */
    public int[] getGraphLineGradient() {
        return (int[]) this.graphLineGradient$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final int[] graphLineGradient_delegate$lambda$0(FanHistoryGraphView fanHistoryGraphView) {
        return new int[]{ResourcesCompat.getColor(fanHistoryGraphView.getResources(), R.color.marineblue, fanHistoryGraphView.getContext().getTheme()), ResourcesCompat.getColor(fanHistoryGraphView.getResources(), R.color.aquablue, fanHistoryGraphView.getContext().getTheme()), ResourcesCompat.getColor(fanHistoryGraphView.getResources(), R.color.lightbluegrey, fanHistoryGraphView.getContext().getTheme())};
    }

    /* access modifiers changed from: protected */
    public Integer getGraphfillDrawable() {
        return Integer.valueOf(this.graphfillDrawable);
    }

    public boolean getShowOutdoorLegend() {
        return this.showOutdoorLegend;
    }

    /* access modifiers changed from: protected */
    public GraphViewModel createViewModel() {
        return new GraphViewModel(false, AnalyticEvent.OnboardingLogEvent.PAIR_BTN_FAN);
    }

    public void setupUiOverlay() {
        getBinding().graphHeader.setVisibility(8);
        getBinding().buttonInfo.setVisibility(8);
    }

    public void updateHeaderSelectedDatapoint(GraphView.SelectedPoint selectedPoint) {
        Intrinsics.checkNotNullParameter(selectedPoint, "selectedPoint");
        GraphView.updateHeaderSelectedDatapoint$default(this, selectedPoint, (String) null, R.color.marineblue, (String) null, (String) null, 16, (Object) null);
    }

    public final Object updateHistorical(List<SimpleDatapoint> list, Continuation<? super Unit> continuation) {
        GraphViewModel.updateIndoorHistorical$default(getViewModel(), list, false, GraphState.Companion.indoorDefault().getDeviceRatings(), false, (SensorType) null, 24, (Object) null);
        return Unit.INSTANCE;
    }

    public final Object updateRealTime(List<SimpleDatapoint> list, Continuation<? super Unit> continuation) {
        GraphViewModel.updateIndoorRealTime$default(getViewModel(), list, false, GraphState.Companion.indoorDefault().getDeviceRatings(), (SensorType) null, 8, (Object) null);
        return Unit.INSTANCE;
    }
}
