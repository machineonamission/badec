package com.blueair.graph.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.blueair.core.model.PollutantType;
import com.blueair.core.model.SimpleDatapoint;
import com.blueair.core.util.OutdoorAirRatingRanges;
import com.blueair.graph.utils.GraphUiUtils;
import com.blueair.graph.view.GraphView;
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
import timber.log.Timber;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u00101\u001a\u000202H\u0014J\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u001c\u00107\u001a\u0002042\f\u00108\u001a\b\u0012\u0004\u0012\u00020:09H@¢\u0006\u0002\u0010;J\u001c\u0010<\u001a\u0002042\f\u00108\u001a\b\u0012\u0004\u0012\u00020:09H@¢\u0006\u0002\u0010;J\b\u0010=\u001a\u000204H\u0016J\u0010\u0010>\u001a\u0002042\u0006\u0010?\u001a\u00020@H\u0016R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\u001e8TX\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u0004\u0018\u00010\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0014\u0010%\u001a\u00020&XD¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010)\u001a\u0004\u0018\u00010\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0014\u0010+\u001a\u00020,8TX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020&XD¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(¨\u0006A"}, d2 = {"Lcom/blueair/graph/view/OutdoorGraphView;", "Lcom/blueair/graph/view/GraphView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttonInfo", "Lcom/google/android/material/button/MaterialButton;", "getButtonInfo", "()Lcom/google/android/material/button/MaterialButton;", "drawingMode", "Lcom/github/mikephil/charting/data/LineDataSet$Mode;", "getDrawingMode", "()Lcom/github/mikephil/charting/data/LineDataSet$Mode;", "dividerLineColor", "getDividerLineColor", "()I", "dividerTextColor", "getDividerTextColor", "graphLineSingleColor", "", "getGraphLineSingleColor", "()Ljava/lang/Void;", "graphLineGradient", "", "getGraphLineGradient", "()[I", "graphLineGradient$delegate", "Lkotlin/Lazy;", "graphfillDrawable", "getGraphfillDrawable", "supportsLegend", "", "getSupportsLegend", "()Z", "fixedMarkerImage", "getFixedMarkerImage", "emptyStateSeverityLabel", "", "getEmptyStateSeverityLabel", "()Ljava/lang/String;", "showOutdoorLegend", "getShowOutdoorLegend", "createViewModel", "Lcom/blueair/graph/viewmodel/GraphViewModel;", "setPollutantType", "", "nuPollutantType", "Lcom/blueair/core/model/PollutantType;", "updateRealTime", "datapoints", "", "Lcom/blueair/core/model/SimpleDatapoint;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateHistorical", "setupUiOverlay", "updateHeaderSelectedDatapoint", "selectedPoint", "Lcom/blueair/graph/view/GraphView$SelectedPoint;", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: OutdoorGraphView.kt */
public final class OutdoorGraphView extends GraphView {
    private final MaterialButton buttonInfo;
    private final int dividerLineColor = R.color.outdoor_divider_line;
    private final int dividerTextColor = R.color.outdoor_divider_text;
    private final LineDataSet.Mode drawingMode = LineDataSet.Mode.HORIZONTAL_BEZIER;
    private final Void fixedMarkerImage;
    private final Lazy graphLineGradient$delegate = LazyKt.lazy(new OutdoorGraphView$$ExternalSyntheticLambda0(this));
    private final Void graphLineSingleColor;
    private final Void graphfillDrawable;
    private final boolean showOutdoorLegend;
    private final boolean supportsLegend = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutdoorGraphView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutdoorGraphView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutdoorGraphView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public MaterialButton getButtonInfo() {
        return this.buttonInfo;
    }

    public LineDataSet.Mode getDrawingMode() {
        return this.drawingMode;
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
    public Void getGraphLineSingleColor() {
        return this.graphLineSingleColor;
    }

    /* access modifiers changed from: protected */
    public int[] getGraphLineGradient() {
        return (int[]) this.graphLineGradient$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final int[] graphLineGradient_delegate$lambda$0(OutdoorGraphView outdoorGraphView) {
        return new int[]{ResourcesCompat.getColor(outdoorGraphView.getResources(), R.color.color_vpolluted, outdoorGraphView.getContext().getTheme()), ResourcesCompat.getColor(outdoorGraphView.getResources(), R.color.color_polluted, outdoorGraphView.getContext().getTheme()), ResourcesCompat.getColor(outdoorGraphView.getResources(), R.color.color_moderate, outdoorGraphView.getContext().getTheme()), ResourcesCompat.getColor(outdoorGraphView.getResources(), R.color.color_good, outdoorGraphView.getContext().getTheme()), ResourcesCompat.getColor(outdoorGraphView.getResources(), R.color.color_excellent, outdoorGraphView.getContext().getTheme())};
    }

    /* access modifiers changed from: protected */
    public Void getGraphfillDrawable() {
        return this.graphfillDrawable;
    }

    /* access modifiers changed from: protected */
    public boolean getSupportsLegend() {
        return this.supportsLegend;
    }

    /* access modifiers changed from: protected */
    public Void getFixedMarkerImage() {
        return this.fixedMarkerImage;
    }

    /* access modifiers changed from: protected */
    public String getEmptyStateSeverityLabel() {
        String string = getResources().getString(R.string.aqi_expanded);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public boolean getShowOutdoorLegend() {
        return this.showOutdoorLegend;
    }

    /* access modifiers changed from: protected */
    public GraphViewModel createViewModel() {
        return new GraphViewModel(true, "outdoor");
    }

    public final void setPollutantType(PollutantType pollutantType) {
        Intrinsics.checkNotNullParameter(pollutantType, "nuPollutantType");
        getViewModel().setPollutantType(pollutantType);
    }

    public final Object updateRealTime(List<SimpleDatapoint> list, Continuation<? super Unit> continuation) {
        GraphViewModel.updateOutdoorRealTime$default(getViewModel(), list, (PollutantType) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    public final Object updateHistorical(List<SimpleDatapoint> list, Continuation<? super Unit> continuation) {
        GraphViewModel.updateOutdoorHistorical$default(getViewModel(), list, false, (PollutantType) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    public void setupUiOverlay() {
        View rangeSelectLayout;
        getBinding().progressView.setAnimationRawRes(R.raw.loading_animation_white);
        GraphRangeSelector graphRangeSelector = getGraphRangeSelector();
        if (graphRangeSelector != null && (rangeSelectLayout = graphRangeSelector.getRangeSelectLayout()) != null) {
            rangeSelectLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.marineblue, getContext().getTheme()));
        }
    }

    public void updateHeaderSelectedDatapoint(GraphView.SelectedPoint selectedPoint) {
        Intrinsics.checkNotNullParameter(selectedPoint, "selectedPoint");
        SimpleDatapoint point = selectedPoint.getPoint();
        int pollutantRangePosition = OutdoorAirRatingRanges.INSTANCE.getPollutantRangePosition(point.getValue(), PollutantType.AQI.INSTANCE);
        int intValue = GraphUiUtils.INSTANCE.getSeverityColors().get(pollutantRangePosition).intValue();
        String str = getResources().getStringArray(R.array.severity_strings)[pollutantRangePosition];
        Timber.Forest forest = Timber.Forest;
        forest.d("updateHeaderSelectedDatapoint: dataPoint = " + point + ", rangePos = " + pollutantRangePosition + ", severityDescript = " + str, new Object[0]);
        GraphView.updateHeaderSelectedDatapoint$default(this, selectedPoint, getResources().getString(R.string.aqi_title), intValue, str, (String) null, 16, (Object) null);
    }
}
