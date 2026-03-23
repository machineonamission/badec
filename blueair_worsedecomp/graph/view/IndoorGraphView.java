package com.blueair.graph.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.res.ResourcesCompat;
import com.blueair.core.model.PollutantType;
import com.blueair.core.model.SensorType;
import com.blueair.core.model.SimpleDatapoint;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.graph.utils.GraphUiUtils;
import com.blueair.graph.view.GraphView;
import com.blueair.graph.viewmodel.GraphState;
import com.blueair.graph.viewmodel.GraphViewModel;
import com.blueair.viewcore.R;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\fJ\b\u00106\u001a\u000207H\u0014J\u000e\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;J,\u0010<\u001a\u0002092\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>2\u0006\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020BH@¢\u0006\u0002\u0010CJ,\u0010D\u001a\u0002092\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>2\u0006\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020BH@¢\u0006\u0002\u0010CJ\u001c\u0010E\u001a\u0002092\f\u0010F\u001a\b\u0012\u0004\u0012\u00020?0>H@¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u000209H\u0016J\u0010\u0010I\u001a\u0002092\u0006\u0010J\u001a\u00020KH\u0016R\u0014\u0010\r\u001a\u00020\u000e8TX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u001bXD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\t8TX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8TX\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u0016\u0010'\u001a\u0004\u0018\u00010(X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,8TX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u0010/\u001a\u0004\u0018\u00010\t8TX\u0004¢\u0006\u0006\u001a\u0004\b0\u0010 R$\u00102\u001a\u00020,2\u0006\u00101\u001a\u00020,@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010.\"\u0004\b4\u00105¨\u0006L"}, d2 = {"Lcom/blueair/graph/view/IndoorGraphView;", "Lcom/blueair/graph/view/GraphView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "graphRangeSelector", "Lcom/blueair/graph/view/GraphRangeSelector;", "getGraphRangeSelector", "()Lcom/blueair/graph/view/GraphRangeSelector;", "drawingMode", "Lcom/github/mikephil/charting/data/LineDataSet$Mode;", "getDrawingMode", "()Lcom/github/mikephil/charting/data/LineDataSet$Mode;", "dividerLineColor", "getDividerLineColor", "()I", "dividerTextColor", "getDividerTextColor", "emptyStateSeverityLabel", "", "getEmptyStateSeverityLabel", "()Ljava/lang/String;", "graphLineSingleColor", "getGraphLineSingleColor", "()Ljava/lang/Integer;", "graphLineGradient", "", "getGraphLineGradient", "()[I", "graphLineGradient$delegate", "Lkotlin/Lazy;", "graphfillDrawable", "", "getGraphfillDrawable", "()Ljava/lang/Void;", "supportsLegend", "", "getSupportsLegend", "()Z", "fixedMarkerImage", "getFixedMarkerImage", "value", "showOutdoorLegend", "getShowOutdoorLegend", "setShowOutdoorLegend", "(Z)V", "createViewModel", "Lcom/blueair/graph/viewmodel/GraphViewModel;", "setSensorType", "", "nuSensorType", "Lcom/blueair/core/model/SensorType;", "updateRealTime", "datapoints", "", "Lcom/blueair/core/model/SimpleDatapoint;", "isCelsius", "ratings", "Lcom/blueair/core/util/IndoorAirRatingRanges;", "(Ljava/util/List;ZLcom/blueair/core/util/IndoorAirRatingRanges;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateHistorical", "compareWith", "nuDatapoints", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupUiOverlay", "updateHeaderSelectedDatapoint", "selectedPoint", "Lcom/blueair/graph/view/GraphView$SelectedPoint;", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: IndoorGraphView.kt */
public final class IndoorGraphView extends GraphView {
    private final int dividerLineColor = R.color.indoor_divider_line;
    private final int dividerTextColor = R.color.indoor_divider_text;
    private final LineDataSet.Mode drawingMode = LineDataSet.Mode.HORIZONTAL_BEZIER;
    private final String emptyStateSeverityLabel = "";
    private final Lazy graphLineGradient$delegate = LazyKt.lazy(new IndoorGraphView$$ExternalSyntheticLambda0(this));
    private final Void graphfillDrawable;
    private boolean showOutdoorLegend;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorGraphView.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.blueair.core.model.SensorType[] r0 = com.blueair.core.model.SensorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.HUM     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.TMP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.HCHO     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.VOC     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.view.IndoorGraphView.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IndoorGraphView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IndoorGraphView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IndoorGraphView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    /* access modifiers changed from: protected */
    public GraphRangeSelector getGraphRangeSelector() {
        GraphRangeSelector graphRangeSelector = getBinding().graphRangeSelectorTop;
        Intrinsics.checkNotNullExpressionValue(graphRangeSelector, "graphRangeSelectorTop");
        return graphRangeSelector;
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
    public String getEmptyStateSeverityLabel() {
        return this.emptyStateSeverityLabel;
    }

    /* access modifiers changed from: protected */
    public Integer getGraphLineSingleColor() {
        int i = WhenMappings.$EnumSwitchMapping$0[getViewModel().getSensorType$graph_otherRelease().ordinal()];
        if (i == 1 || i == 2) {
            return Integer.valueOf(ResourcesCompat.getColor(getResources(), R.color.marineblue, getContext().getTheme()));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int[] getGraphLineGradient() {
        return (int[]) this.graphLineGradient$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final int[] graphLineGradient_delegate$lambda$0(IndoorGraphView indoorGraphView) {
        return new int[]{ResourcesCompat.getColor(indoorGraphView.getResources(), R.color.color_vpolluted, indoorGraphView.getContext().getTheme()), ResourcesCompat.getColor(indoorGraphView.getResources(), R.color.color_polluted, indoorGraphView.getContext().getTheme()), ResourcesCompat.getColor(indoorGraphView.getResources(), R.color.color_moderate, indoorGraphView.getContext().getTheme()), ResourcesCompat.getColor(indoorGraphView.getResources(), R.color.color_good, indoorGraphView.getContext().getTheme()), ResourcesCompat.getColor(indoorGraphView.getResources(), R.color.color_excellent, indoorGraphView.getContext().getTheme())};
    }

    /* access modifiers changed from: protected */
    public Void getGraphfillDrawable() {
        return this.graphfillDrawable;
    }

    /* access modifiers changed from: protected */
    public boolean getSupportsLegend() {
        int i = WhenMappings.$EnumSwitchMapping$0[getViewModel().getSensorType$graph_otherRelease().ordinal()];
        return (i == 1 || i == 2) ? false : true;
    }

    /* access modifiers changed from: protected */
    public Integer getFixedMarkerImage() {
        int i = WhenMappings.$EnumSwitchMapping$0[getViewModel().getSensorType$graph_otherRelease().ordinal()];
        if (i == 1 || i == 2) {
            return Integer.valueOf(R.drawable.ic_marker_dot_marineblue);
        }
        return null;
    }

    public boolean getShowOutdoorLegend() {
        return this.showOutdoorLegend;
    }

    public void setShowOutdoorLegend(boolean z) {
        this.showOutdoorLegend = z;
        Group group = getBinding().legendOutdoorGroup;
        Intrinsics.checkNotNullExpressionValue(group, "legendOutdoorGroup");
        ViewExtensionsKt.show(group, z);
    }

    /* access modifiers changed from: protected */
    public GraphViewModel createViewModel() {
        return new GraphViewModel(false, "indoor");
    }

    public final void setSensorType(SensorType sensorType) {
        Intrinsics.checkNotNullParameter(sensorType, "nuSensorType");
        getViewModel().setSensorType(sensorType);
    }

    public final Object updateRealTime(List<SimpleDatapoint> list, boolean z, IndoorAirRatingRanges indoorAirRatingRanges, Continuation<? super Unit> continuation) {
        GraphViewModel.updateIndoorRealTime$default(getViewModel(), list, z, indoorAirRatingRanges, (SensorType) null, 8, (Object) null);
        return Unit.INSTANCE;
    }

    public final Object updateHistorical(List<SimpleDatapoint> list, boolean z, IndoorAirRatingRanges indoorAirRatingRanges, Continuation<? super Unit> continuation) {
        GraphViewModel.updateIndoorHistorical$default(getViewModel(), list, z, indoorAirRatingRanges, false, (SensorType) null, 16, (Object) null);
        return Unit.INSTANCE;
    }

    public final Object compareWith(List<SimpleDatapoint> list, Continuation<? super Unit> continuation) {
        getViewModel().updateOutdoorHistorical(list, true, PollutantType.Companion.fromSensorType(((GraphState) getViewModel().getState()).getSensorType()));
        return Unit.INSTANCE;
    }

    public void setupUiOverlay() {
        View rangeSelectLayout;
        MaterialButton rangeDay;
        MaterialButton rangeDay2;
        MaterialButton rangeWeek;
        MaterialButton rangeWeek2;
        MaterialButton rangeMonth;
        MaterialButton rangeMonth2;
        MaterialButton rangeClose;
        MaterialButton rangeClose2;
        MaterialButton timeButton;
        MaterialButton timeButton2;
        MaterialButton timeButton3;
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("setupUiOverlay: graphRangeSelector.id = ");
        GraphRangeSelector graphRangeSelector = getGraphRangeSelector();
        sb.append(graphRangeSelector != null ? Integer.valueOf(graphRangeSelector.getId()) : null);
        sb.append(", graphRangeSelector = ");
        sb.append(getGraphRangeSelector());
        forest.d(sb.toString(), new Object[0]);
        GraphRangeSelector graphRangeSelector2 = getGraphRangeSelector();
        if (!(graphRangeSelector2 == null || (timeButton3 = graphRangeSelector2.getTimeButton()) == null)) {
            timeButton3.setTextColor(ResourcesCompat.getColor(getResources(), R.color.marineblue, getContext().getTheme()));
        }
        GraphRangeSelector graphRangeSelector3 = getGraphRangeSelector();
        if (!(graphRangeSelector3 == null || (timeButton2 = graphRangeSelector3.getTimeButton()) == null)) {
            timeButton2.setIconTintResource(R.color.marineblue);
        }
        GraphRangeSelector graphRangeSelector4 = getGraphRangeSelector();
        if (!(graphRangeSelector4 == null || (timeButton = graphRangeSelector4.getTimeButton()) == null)) {
            timeButton.setRippleColorResource(R.color.lightbluegrey);
        }
        GraphRangeSelector graphRangeSelector5 = getGraphRangeSelector();
        if (!(graphRangeSelector5 == null || (rangeClose2 = graphRangeSelector5.getRangeClose()) == null)) {
            rangeClose2.setIconTintResource(R.color.marineblue);
        }
        GraphRangeSelector graphRangeSelector6 = getGraphRangeSelector();
        if (!(graphRangeSelector6 == null || (rangeClose = graphRangeSelector6.getRangeClose()) == null)) {
            rangeClose.setRippleColorResource(R.color.lightbluegrey);
        }
        getBinding().severityLabel.setTextColor(ResourcesCompat.getColor(getResources(), R.color.marineblue, getContext().getTheme()));
        GraphRangeSelector graphRangeSelector7 = getGraphRangeSelector();
        if (!(graphRangeSelector7 == null || (rangeMonth2 = graphRangeSelector7.getRangeMonth()) == null)) {
            rangeMonth2.setTextColor(ResourcesCompat.getColor(getResources(), R.color.marineblue, getContext().getTheme()));
        }
        GraphRangeSelector graphRangeSelector8 = getGraphRangeSelector();
        if (!(graphRangeSelector8 == null || (rangeMonth = graphRangeSelector8.getRangeMonth()) == null)) {
            rangeMonth.setRippleColorResource(R.color.lightbluegrey);
        }
        GraphRangeSelector graphRangeSelector9 = getGraphRangeSelector();
        if (!(graphRangeSelector9 == null || (rangeWeek2 = graphRangeSelector9.getRangeWeek()) == null)) {
            rangeWeek2.setTextColor(ResourcesCompat.getColor(getResources(), R.color.marineblue, getContext().getTheme()));
        }
        GraphRangeSelector graphRangeSelector10 = getGraphRangeSelector();
        if (!(graphRangeSelector10 == null || (rangeWeek = graphRangeSelector10.getRangeWeek()) == null)) {
            rangeWeek.setRippleColorResource(R.color.lightbluegrey);
        }
        GraphRangeSelector graphRangeSelector11 = getGraphRangeSelector();
        if (!(graphRangeSelector11 == null || (rangeDay2 = graphRangeSelector11.getRangeDay()) == null)) {
            rangeDay2.setTextColor(ResourcesCompat.getColor(getResources(), R.color.marineblue, getContext().getTheme()));
        }
        GraphRangeSelector graphRangeSelector12 = getGraphRangeSelector();
        if (!(graphRangeSelector12 == null || (rangeDay = graphRangeSelector12.getRangeDay()) == null)) {
            rangeDay.setRippleColorResource(R.color.lightbluegrey);
        }
        GraphRangeSelector graphRangeSelector13 = getGraphRangeSelector();
        if (!(graphRangeSelector13 == null || (rangeSelectLayout = graphRangeSelector13.getRangeSelectLayout()) == null)) {
            rangeSelectLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.white_60, getContext().getTheme()));
        }
        getBinding().legendOutdoor.setTextColor(ResourcesCompat.getColor(getResources(), R.color.marineblue95, getContext().getTheme()));
        getBinding().legendVpollLabel.setTextColor(ResourcesCompat.getColor(getResources(), R.color.marineblue95, getContext().getTheme()));
        getBinding().legendPollLabel.setTextColor(ResourcesCompat.getColor(getResources(), R.color.marineblue95, getContext().getTheme()));
        getBinding().legendModLabel.setTextColor(ResourcesCompat.getColor(getResources(), R.color.marineblue95, getContext().getTheme()));
        getBinding().legendGoodLabel.setTextColor(ResourcesCompat.getColor(getResources(), R.color.marineblue95, getContext().getTheme()));
        getBinding().legendExcelLabel.setTextColor(ResourcesCompat.getColor(getResources(), R.color.marineblue95, getContext().getTheme()));
    }

    public void updateHeaderSelectedDatapoint(GraphView.SelectedPoint selectedPoint) {
        String str;
        Intrinsics.checkNotNullParameter(selectedPoint, "selectedPoint");
        SimpleDatapoint point = selectedPoint.getPoint();
        SensorType sensorType$graph_otherRelease = getViewModel().getSensorType$graph_otherRelease();
        int i = R.color.marineblue;
        ((GraphState) getViewModel().getState()).getCompareGraphDataPoints();
        if (sensorType$graph_otherRelease == SensorType.HUM || sensorType$graph_otherRelease == SensorType.TMP) {
            GraphView.updateHeaderSelectedDatapoint$default(this, selectedPoint, (String) null, i, (String) null, (String) null, 16, (Object) null);
            return;
        }
        double[] airRatingsFor = getViewModel().getDeviceRatings().airRatingsFor(getViewModel().getSensorType$graph_otherRelease());
        float value = point.getValue();
        int length = airRatingsFor.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            if (((double) value) <= airRatingsFor[i2]) {
                break;
            }
            i2++;
        }
        if (i2 == -1) {
            i2 = airRatingsFor.length - 1;
        }
        GraphUiUtils.INSTANCE.getSeverityDots().get(i2).intValue();
        String str2 = getResources().getStringArray(R.array.severity_strings)[i2];
        Timber.Forest.d("updateHeaderSelectedDatapoint: dataPoint = " + point + ", rangePos = " + i2 + ", severityDescript = " + str2, new Object[0]);
        int i3 = WhenMappings.$EnumSwitchMapping$0[sensorType$graph_otherRelease.ordinal()];
        if (i3 == 3) {
            str = sensorType$graph_otherRelease.formatValue(Float.valueOf(selectedPoint.getPoint().getValue()));
        } else if (i3 != 4) {
            str = null;
        } else {
            str = "";
        }
        String str3 = str2;
        updateHeaderSelectedDatapoint(selectedPoint, (String) null, i, str3, str);
    }
}
