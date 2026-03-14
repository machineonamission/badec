package com.blueair.graph.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.blueair.core.model.PollutantType;
import com.blueair.core.model.SimpleDatapoint;
import com.blueair.core.util.OutdoorAirRatingRanges;
import com.blueair.graph.utils.GraphUiUtils;
import com.blueair.graph.viewmodel.GraphViewModel;
import com.blueair.viewcore.R;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.LineDataSet.Mode;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u00101\u001a\u000202H\u0014J\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u001c\u00107\u001a\u0002042\f\u00108\u001a\b\u0012\u0004\u0012\u00020:09H\u0087@¢\u0006\u0002\u0010;J\u001c\u0010<\u001a\u0002042\f\u00108\u001a\b\u0012\u0004\u0012\u00020:09H\u0087@¢\u0006\u0002\u0010;J\b\u0010=\u001a\u000204H\u0016J\u0010\u0010>\u001a\u0002042\u0006\u0010?\u001a\u00020@H\u0016R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\nX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\nX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\u001e8TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u0004\u0018\u00010\u001aX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0014\u0010%\u001a\u00020&X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010)\u001a\u0004\u0018\u00010\u001aX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0014\u0010+\u001a\u00020,8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020&X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(¨\u0006A"},
   d2 = {"Lcom/blueair/graph/view/OutdoorGraphView;", "Lcom/blueair/graph/view/GraphView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttonInfo", "Lcom/google/android/material/button/MaterialButton;", "getButtonInfo", "()Lcom/google/android/material/button/MaterialButton;", "drawingMode", "Lcom/github/mikephil/charting/data/LineDataSet$Mode;", "getDrawingMode", "()Lcom/github/mikephil/charting/data/LineDataSet$Mode;", "dividerLineColor", "getDividerLineColor", "()I", "dividerTextColor", "getDividerTextColor", "graphLineSingleColor", "", "getGraphLineSingleColor", "()Ljava/lang/Void;", "graphLineGradient", "", "getGraphLineGradient", "()[I", "graphLineGradient$delegate", "Lkotlin/Lazy;", "graphfillDrawable", "getGraphfillDrawable", "supportsLegend", "", "getSupportsLegend", "()Z", "fixedMarkerImage", "getFixedMarkerImage", "emptyStateSeverityLabel", "", "getEmptyStateSeverityLabel", "()Ljava/lang/String;", "showOutdoorLegend", "getShowOutdoorLegend", "createViewModel", "Lcom/blueair/graph/viewmodel/GraphViewModel;", "setPollutantType", "", "nuPollutantType", "Lcom/blueair/core/model/PollutantType;", "updateRealTime", "datapoints", "", "Lcom/blueair/core/model/SimpleDatapoint;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateHistorical", "setupUiOverlay", "updateHeaderSelectedDatapoint", "selectedPoint", "Lcom/blueair/graph/view/GraphView$SelectedPoint;", "graph_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class OutdoorGraphView extends GraphView {
   private final MaterialButton buttonInfo;
   private final int dividerLineColor;
   private final int dividerTextColor;
   private final LineDataSet.Mode drawingMode;
   private final Void fixedMarkerImage;
   private final Lazy graphLineGradient$delegate;
   private final Void graphLineSingleColor;
   private final Void graphfillDrawable;
   private final boolean showOutdoorLegend;
   private final boolean supportsLegend;

   // $FF: synthetic method
   public static int[] $r8$lambda$KQMmiKyW1HqreEcbf0GR_Gr2bbY/* $FF was: $r8$lambda$KQMmiKyW1HqreEcbf0GR-Gr2bbY*/(OutdoorGraphView var0) {
      return graphLineGradient_delegate$lambda$0(var0);
   }

   public OutdoorGraphView(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1);
      this.drawingMode = Mode.HORIZONTAL_BEZIER;
      this.dividerLineColor = R.color.outdoor_divider_line;
      this.dividerTextColor = R.color.outdoor_divider_text;
      this.graphLineGradient$delegate = LazyKt.lazy(new OutdoorGraphView$$ExternalSyntheticLambda0(this));
      this.supportsLegend = true;
   }

   public OutdoorGraphView(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2);
      this.drawingMode = Mode.HORIZONTAL_BEZIER;
      this.dividerLineColor = R.color.outdoor_divider_line;
      this.dividerTextColor = R.color.outdoor_divider_text;
      this.graphLineGradient$delegate = LazyKt.lazy(new OutdoorGraphView$$ExternalSyntheticLambda0(this));
      this.supportsLegend = true;
   }

   public OutdoorGraphView(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
      this.drawingMode = Mode.HORIZONTAL_BEZIER;
      this.dividerLineColor = R.color.outdoor_divider_line;
      this.dividerTextColor = R.color.outdoor_divider_text;
      this.graphLineGradient$delegate = LazyKt.lazy(new OutdoorGraphView$$ExternalSyntheticLambda0(this));
      this.supportsLegend = true;
   }

   private static final int[] graphLineGradient_delegate$lambda$0(OutdoorGraphView var0) {
      return new int[]{ResourcesCompat.getColor(var0.getResources(), R.color.color_vpolluted, var0.getContext().getTheme()), ResourcesCompat.getColor(var0.getResources(), R.color.color_polluted, var0.getContext().getTheme()), ResourcesCompat.getColor(var0.getResources(), R.color.color_moderate, var0.getContext().getTheme()), ResourcesCompat.getColor(var0.getResources(), R.color.color_good, var0.getContext().getTheme()), ResourcesCompat.getColor(var0.getResources(), R.color.color_excellent, var0.getContext().getTheme())};
   }

   protected GraphViewModel createViewModel() {
      return new GraphViewModel(true, "outdoor");
   }

   public MaterialButton getButtonInfo() {
      return this.buttonInfo;
   }

   protected int getDividerLineColor() {
      return this.dividerLineColor;
   }

   protected int getDividerTextColor() {
      return this.dividerTextColor;
   }

   public LineDataSet.Mode getDrawingMode() {
      return this.drawingMode;
   }

   protected String getEmptyStateSeverityLabel() {
      String var1 = this.getResources().getString(R.string.aqi_expanded);
      Intrinsics.checkNotNullExpressionValue(var1, "getString(...)");
      return var1;
   }

   protected Void getFixedMarkerImage() {
      return this.fixedMarkerImage;
   }

   protected int[] getGraphLineGradient() {
      return (int[])this.graphLineGradient$delegate.getValue();
   }

   protected Void getGraphLineSingleColor() {
      return this.graphLineSingleColor;
   }

   protected Void getGraphfillDrawable() {
      return this.graphfillDrawable;
   }

   public boolean getShowOutdoorLegend() {
      return this.showOutdoorLegend;
   }

   protected boolean getSupportsLegend() {
      return this.supportsLegend;
   }

   public final void setPollutantType(PollutantType var1) {
      Intrinsics.checkNotNullParameter(var1, "nuPollutantType");
      this.getViewModel().setPollutantType(var1);
   }

   public void setupUiOverlay() {
      this.getBinding().progressView.setAnimationRawRes(R.raw.loading_animation_white);
      GraphRangeSelector var1 = this.getGraphRangeSelector();
      if (var1 != null) {
         View var2 = var1.getRangeSelectLayout();
         if (var2 != null) {
            var2.setBackgroundColor(ResourcesCompat.getColor(this.getResources(), R.color.marineblue, this.getContext().getTheme()));
         }
      }

   }

   public void updateHeaderSelectedDatapoint(GraphView.SelectedPoint var1) {
      Intrinsics.checkNotNullParameter(var1, "selectedPoint");
      SimpleDatapoint var5 = var1.getPoint();
      int var3 = OutdoorAirRatingRanges.INSTANCE.getPollutantRangePosition(var5.getValue(), PollutantType.AQI.INSTANCE);
      int var2 = ((Number)GraphUiUtils.INSTANCE.getSeverityColors().get(var3)).intValue();
      String var6 = this.getResources().getStringArray(R.array.severity_strings)[var3];
      Timber.Forest var7 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("updateHeaderSelectedDatapoint: dataPoint = ");
      var4.append(var5);
      var4.append(", rangePos = ");
      var4.append(var3);
      var4.append(", severityDescript = ");
      var4.append(var6);
      var7.d(var4.toString(), new Object[0]);
      GraphView.updateHeaderSelectedDatapoint$default(this, var1, this.getResources().getString(R.string.aqi_title), var2, var6, (String)null, 16, (Object)null);
   }

   public final Object updateHistorical(List var1, Continuation var2) {
      GraphViewModel.updateOutdoorHistorical$default(this.getViewModel(), var1, false, (PollutantType)null, 6, (Object)null);
      return Unit.INSTANCE;
   }

   public final Object updateRealTime(List var1, Continuation var2) {
      GraphViewModel.updateOutdoorRealTime$default(this.getViewModel(), var1, (PollutantType)null, 2, (Object)null);
      return Unit.INSTANCE;
   }
}
