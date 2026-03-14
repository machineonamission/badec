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
import com.blueair.graph.viewmodel.GraphState;
import com.blueair.graph.viewmodel.GraphViewModel;
import com.blueair.viewcore.R;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.LineDataSet.Mode;
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

@Metadata(
   d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\fJ\b\u00106\u001a\u000207H\u0014J\u000e\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;J,\u0010<\u001a\u0002092\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>2\u0006\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020BH\u0087@¢\u0006\u0002\u0010CJ,\u0010D\u001a\u0002092\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>2\u0006\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020BH\u0087@¢\u0006\u0002\u0010CJ\u001c\u0010E\u001a\u0002092\f\u0010F\u001a\b\u0012\u0004\u0012\u00020?0>H\u0087@¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u000209H\u0016J\u0010\u0010I\u001a\u0002092\u0006\u0010J\u001a\u00020KH\u0016R\u0014\u0010\r\u001a\u00020\u000e8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\tX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\tX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u001bX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\t8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u0016\u0010'\u001a\u0004\u0018\u00010(X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u0010/\u001a\u0004\u0018\u00010\t8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b0\u0010 R$\u00102\u001a\u00020,2\u0006\u00101\u001a\u00020,@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010.\"\u0004\b4\u00105¨\u0006L"},
   d2 = {"Lcom/blueair/graph/view/IndoorGraphView;", "Lcom/blueair/graph/view/GraphView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "graphRangeSelector", "Lcom/blueair/graph/view/GraphRangeSelector;", "getGraphRangeSelector", "()Lcom/blueair/graph/view/GraphRangeSelector;", "drawingMode", "Lcom/github/mikephil/charting/data/LineDataSet$Mode;", "getDrawingMode", "()Lcom/github/mikephil/charting/data/LineDataSet$Mode;", "dividerLineColor", "getDividerLineColor", "()I", "dividerTextColor", "getDividerTextColor", "emptyStateSeverityLabel", "", "getEmptyStateSeverityLabel", "()Ljava/lang/String;", "graphLineSingleColor", "getGraphLineSingleColor", "()Ljava/lang/Integer;", "graphLineGradient", "", "getGraphLineGradient", "()[I", "graphLineGradient$delegate", "Lkotlin/Lazy;", "graphfillDrawable", "", "getGraphfillDrawable", "()Ljava/lang/Void;", "supportsLegend", "", "getSupportsLegend", "()Z", "fixedMarkerImage", "getFixedMarkerImage", "value", "showOutdoorLegend", "getShowOutdoorLegend", "setShowOutdoorLegend", "(Z)V", "createViewModel", "Lcom/blueair/graph/viewmodel/GraphViewModel;", "setSensorType", "", "nuSensorType", "Lcom/blueair/core/model/SensorType;", "updateRealTime", "datapoints", "", "Lcom/blueair/core/model/SimpleDatapoint;", "isCelsius", "ratings", "Lcom/blueair/core/util/IndoorAirRatingRanges;", "(Ljava/util/List;ZLcom/blueair/core/util/IndoorAirRatingRanges;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateHistorical", "compareWith", "nuDatapoints", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupUiOverlay", "updateHeaderSelectedDatapoint", "selectedPoint", "Lcom/blueair/graph/view/GraphView$SelectedPoint;", "graph_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class IndoorGraphView extends GraphView {
   private final int dividerLineColor;
   private final int dividerTextColor;
   private final LineDataSet.Mode drawingMode;
   private final String emptyStateSeverityLabel;
   private final Lazy graphLineGradient$delegate;
   private final Void graphfillDrawable;
   private boolean showOutdoorLegend;

   // $FF: synthetic method
   public static int[] $r8$lambda$CmrhWPTksEXFRXqqdsFCsK5wPnc(IndoorGraphView var0) {
      return graphLineGradient_delegate$lambda$0(var0);
   }

   public IndoorGraphView(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2);
      this.drawingMode = Mode.HORIZONTAL_BEZIER;
      this.dividerLineColor = R.color.indoor_divider_line;
      this.dividerTextColor = R.color.indoor_divider_text;
      this.emptyStateSeverityLabel = "";
      this.graphLineGradient$delegate = LazyKt.lazy(new IndoorGraphView$$ExternalSyntheticLambda0(this));
   }

   public IndoorGraphView(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2, var3);
      this.drawingMode = Mode.HORIZONTAL_BEZIER;
      this.dividerLineColor = R.color.indoor_divider_line;
      this.dividerTextColor = R.color.indoor_divider_text;
      this.emptyStateSeverityLabel = "";
      this.graphLineGradient$delegate = LazyKt.lazy(new IndoorGraphView$$ExternalSyntheticLambda0(this));
   }

   public IndoorGraphView(Context var1, AttributeSet var2, int var3, int var4) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2, var3, var4);
      this.drawingMode = Mode.HORIZONTAL_BEZIER;
      this.dividerLineColor = R.color.indoor_divider_line;
      this.dividerTextColor = R.color.indoor_divider_text;
      this.emptyStateSeverityLabel = "";
      this.graphLineGradient$delegate = LazyKt.lazy(new IndoorGraphView$$ExternalSyntheticLambda0(this));
   }

   private static final int[] graphLineGradient_delegate$lambda$0(IndoorGraphView var0) {
      return new int[]{ResourcesCompat.getColor(var0.getResources(), R.color.color_vpolluted, var0.getContext().getTheme()), ResourcesCompat.getColor(var0.getResources(), R.color.color_polluted, var0.getContext().getTheme()), ResourcesCompat.getColor(var0.getResources(), R.color.color_moderate, var0.getContext().getTheme()), ResourcesCompat.getColor(var0.getResources(), R.color.color_good, var0.getContext().getTheme()), ResourcesCompat.getColor(var0.getResources(), R.color.color_excellent, var0.getContext().getTheme())};
   }

   public final Object compareWith(List var1, Continuation var2) {
      this.getViewModel().updateOutdoorHistorical(var1, true, PollutantType.Companion.fromSensorType(((GraphState)this.getViewModel().getState()).getSensorType()));
      return Unit.INSTANCE;
   }

   protected GraphViewModel createViewModel() {
      return new GraphViewModel(false, "indoor");
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
      return this.emptyStateSeverityLabel;
   }

   protected Integer getFixedMarkerImage() {
      SensorType var2 = this.getViewModel().getSensorType$graph_otherRelease();
      int var1 = IndoorGraphView.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
      return var1 != 1 && var1 != 2 ? null : R.drawable.ic_marker_dot_marineblue;
   }

   protected int[] getGraphLineGradient() {
      return (int[])this.graphLineGradient$delegate.getValue();
   }

   protected Integer getGraphLineSingleColor() {
      SensorType var2 = this.getViewModel().getSensorType$graph_otherRelease();
      int var1 = IndoorGraphView.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
      return var1 != 1 && var1 != 2 ? null : ResourcesCompat.getColor(this.getResources(), R.color.marineblue, this.getContext().getTheme());
   }

   protected GraphRangeSelector getGraphRangeSelector() {
      GraphRangeSelector var1 = this.getBinding().graphRangeSelectorTop;
      Intrinsics.checkNotNullExpressionValue(var1, "graphRangeSelectorTop");
      return var1;
   }

   protected Void getGraphfillDrawable() {
      return this.graphfillDrawable;
   }

   public boolean getShowOutdoorLegend() {
      return this.showOutdoorLegend;
   }

   protected boolean getSupportsLegend() {
      SensorType var2 = this.getViewModel().getSensorType$graph_otherRelease();
      int var1 = IndoorGraphView.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
      return var1 != 1 && var1 != 2;
   }

   public final void setSensorType(SensorType var1) {
      Intrinsics.checkNotNullParameter(var1, "nuSensorType");
      this.getViewModel().setSensorType(var1);
   }

   public void setShowOutdoorLegend(boolean var1) {
      this.showOutdoorLegend = var1;
      Group var2 = this.getBinding().legendOutdoorGroup;
      Intrinsics.checkNotNullExpressionValue(var2, "legendOutdoorGroup");
      ViewExtensionsKt.show((View)var2, var1);
   }

   public void setupUiOverlay() {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("setupUiOverlay: graphRangeSelector.id = ");
      GraphRangeSelector var1 = this.getGraphRangeSelector();
      Integer var4;
      if (var1 != null) {
         var4 = var1.getId();
      } else {
         var4 = null;
      }

      var2.append(var4);
      var2.append(", graphRangeSelector = ");
      var2.append(this.getGraphRangeSelector());
      var3.d(var2.toString(), new Object[0]);
      GraphRangeSelector var5 = this.getGraphRangeSelector();
      if (var5 != null) {
         MaterialButton var6 = var5.getTimeButton();
         if (var6 != null) {
            var6.setTextColor(ResourcesCompat.getColor(this.getResources(), R.color.marineblue, this.getContext().getTheme()));
         }
      }

      var5 = this.getGraphRangeSelector();
      if (var5 != null) {
         MaterialButton var8 = var5.getTimeButton();
         if (var8 != null) {
            var8.setIconTintResource(R.color.marineblue);
         }
      }

      var5 = this.getGraphRangeSelector();
      if (var5 != null) {
         MaterialButton var10 = var5.getTimeButton();
         if (var10 != null) {
            var10.setRippleColorResource(R.color.lightbluegrey);
         }
      }

      var5 = this.getGraphRangeSelector();
      if (var5 != null) {
         MaterialButton var12 = var5.getRangeClose();
         if (var12 != null) {
            var12.setIconTintResource(R.color.marineblue);
         }
      }

      var5 = this.getGraphRangeSelector();
      if (var5 != null) {
         MaterialButton var14 = var5.getRangeClose();
         if (var14 != null) {
            var14.setRippleColorResource(R.color.lightbluegrey);
         }
      }

      this.getBinding().severityLabel.setTextColor(ResourcesCompat.getColor(this.getResources(), R.color.marineblue, this.getContext().getTheme()));
      var5 = this.getGraphRangeSelector();
      if (var5 != null) {
         MaterialButton var16 = var5.getRangeMonth();
         if (var16 != null) {
            var16.setTextColor(ResourcesCompat.getColor(this.getResources(), R.color.marineblue, this.getContext().getTheme()));
         }
      }

      var5 = this.getGraphRangeSelector();
      if (var5 != null) {
         MaterialButton var18 = var5.getRangeMonth();
         if (var18 != null) {
            var18.setRippleColorResource(R.color.lightbluegrey);
         }
      }

      var5 = this.getGraphRangeSelector();
      if (var5 != null) {
         MaterialButton var20 = var5.getRangeWeek();
         if (var20 != null) {
            var20.setTextColor(ResourcesCompat.getColor(this.getResources(), R.color.marineblue, this.getContext().getTheme()));
         }
      }

      var5 = this.getGraphRangeSelector();
      if (var5 != null) {
         MaterialButton var22 = var5.getRangeWeek();
         if (var22 != null) {
            var22.setRippleColorResource(R.color.lightbluegrey);
         }
      }

      var5 = this.getGraphRangeSelector();
      if (var5 != null) {
         MaterialButton var24 = var5.getRangeDay();
         if (var24 != null) {
            var24.setTextColor(ResourcesCompat.getColor(this.getResources(), R.color.marineblue, this.getContext().getTheme()));
         }
      }

      var5 = this.getGraphRangeSelector();
      if (var5 != null) {
         MaterialButton var26 = var5.getRangeDay();
         if (var26 != null) {
            var26.setRippleColorResource(R.color.lightbluegrey);
         }
      }

      var5 = this.getGraphRangeSelector();
      if (var5 != null) {
         View var28 = var5.getRangeSelectLayout();
         if (var28 != null) {
            var28.setBackgroundColor(ResourcesCompat.getColor(this.getResources(), R.color.white_60, this.getContext().getTheme()));
         }
      }

      this.getBinding().legendOutdoor.setTextColor(ResourcesCompat.getColor(this.getResources(), R.color.marineblue95, this.getContext().getTheme()));
      this.getBinding().legendVpollLabel.setTextColor(ResourcesCompat.getColor(this.getResources(), R.color.marineblue95, this.getContext().getTheme()));
      this.getBinding().legendPollLabel.setTextColor(ResourcesCompat.getColor(this.getResources(), R.color.marineblue95, this.getContext().getTheme()));
      this.getBinding().legendModLabel.setTextColor(ResourcesCompat.getColor(this.getResources(), R.color.marineblue95, this.getContext().getTheme()));
      this.getBinding().legendGoodLabel.setTextColor(ResourcesCompat.getColor(this.getResources(), R.color.marineblue95, this.getContext().getTheme()));
      this.getBinding().legendExcelLabel.setTextColor(ResourcesCompat.getColor(this.getResources(), R.color.marineblue95, this.getContext().getTheme()));
   }

   public void updateHeaderSelectedDatapoint(GraphView.SelectedPoint var1) {
      Intrinsics.checkNotNullParameter(var1, "selectedPoint");
      SimpleDatapoint var8 = var1.getPoint();
      SensorType var10 = this.getViewModel().getSensorType$graph_otherRelease();
      int var7 = R.color.marineblue;
      ((GraphState)this.getViewModel().getState()).getCompareGraphDataPoints();
      if (var10 != SensorType.HUM && var10 != SensorType.TMP) {
         double[] var9 = this.getViewModel().getDeviceRatings().airRatingsFor(this.getViewModel().getSensorType$graph_otherRelease());
         float var4 = var8.getValue();
         int var6 = var9.length;
         int var5 = 0;

         while(true) {
            if (var5 >= var6) {
               var5 = -1;
               break;
            }

            double var2 = var9[var5];
            if ((double)var4 <= var2) {
               break;
            }

            ++var5;
         }

         var6 = var5;
         if (var5 == -1) {
            var6 = var9.length - 1;
         }

         ((Number)GraphUiUtils.INSTANCE.getSeverityDots().get(var6)).intValue();
         String var16 = this.getResources().getStringArray(R.array.severity_strings)[var6];
         Timber.Forest var12 = Timber.Forest;
         StringBuilder var11 = new StringBuilder("updateHeaderSelectedDatapoint: dataPoint = ");
         var11.append(var8);
         var11.append(", rangePos = ");
         var11.append(var6);
         var11.append(", severityDescript = ");
         var11.append(var16);
         var12.d(var11.toString(), new Object[0]);
         var5 = IndoorGraphView.WhenMappings.$EnumSwitchMapping$0[var10.ordinal()];
         String var15;
         if (var5 != 3) {
            if (var5 != 4) {
               var15 = null;
            } else {
               var15 = "";
            }
         } else {
            var15 = var10.formatValue(var1.getPoint().getValue());
         }

         this.updateHeaderSelectedDatapoint(var1, (String)null, var7, var16, var15);
      } else {
         GraphView.updateHeaderSelectedDatapoint$default(this, var1, (String)null, var7, (String)null, (String)null, 16, (Object)null);
      }
   }

   public final Object updateHistorical(List var1, boolean var2, IndoorAirRatingRanges var3, Continuation var4) {
      GraphViewModel.updateIndoorHistorical$default(this.getViewModel(), var1, var2, var3, false, (SensorType)null, 16, (Object)null);
      return Unit.INSTANCE;
   }

   public final Object updateRealTime(List var1, boolean var2, IndoorAirRatingRanges var3, Continuation var4) {
      GraphViewModel.updateIndoorRealTime$default(this.getViewModel(), var1, var2, var3, (SensorType)null, 8, (Object)null);
      return Unit.INSTANCE;
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
         int[] var0 = new int[SensorType.values().length];

         try {
            var0[SensorType.HUM.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[SensorType.TMP.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[SensorType.HCHO.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[SensorType.VOC.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
