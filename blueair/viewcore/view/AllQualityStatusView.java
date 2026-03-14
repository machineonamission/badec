package com.blueair.viewcore.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.core.model.OutdoorPollutants;
import com.blueair.core.model.Pollutant;
import com.blueair.core.model.PollutantType;
import com.blueair.core.util.OutdoorAirRatingRanges;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.OutdoorUiUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J/\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u001dR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"},
   d2 = {"Lcom/blueair/viewcore/view/AllQualityStatusView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "pm25Layout", "Lcom/blueair/viewcore/view/QualityStatusView;", "pm10Layout", "coLayout", "so2OrElseLayout", "bind", "", "pollutants", "Lcom/blueair/core/model/OutdoorPollutants;", "type", "Lcom/blueair/core/model/PollutantType;", "value", "", "aqi", "layout", "(Lcom/blueair/core/model/PollutantType;Ljava/lang/Double;ILcom/blueair/viewcore/view/QualityStatusView;)V", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AllQualityStatusView extends ConstraintLayout {
   private final QualityStatusView coLayout;
   private final QualityStatusView pm10Layout;
   private final QualityStatusView pm25Layout;
   private final QualityStatusView so2OrElseLayout;

   public AllQualityStatusView(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1);
      ConstraintLayout.inflate(this.getContext(), R.layout.all_quality_status_view, (ViewGroup)this);
      View var2 = this.findViewById(R.id.sensor_pm25_layout);
      Intrinsics.checkNotNullExpressionValue(var2, "findViewById(...)");
      this.pm25Layout = (QualityStatusView)var2;
      var2 = this.findViewById(R.id.sensor_pm10_layout);
      Intrinsics.checkNotNullExpressionValue(var2, "findViewById(...)");
      this.pm10Layout = (QualityStatusView)var2;
      var2 = this.findViewById(R.id.sensor_co_layout);
      Intrinsics.checkNotNullExpressionValue(var2, "findViewById(...)");
      this.coLayout = (QualityStatusView)var2;
      var2 = this.findViewById(R.id.sensor_so2_or_else_layout);
      Intrinsics.checkNotNullExpressionValue(var2, "findViewById(...)");
      this.so2OrElseLayout = (QualityStatusView)var2;
   }

   public AllQualityStatusView(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2);
      ConstraintLayout.inflate(this.getContext(), R.layout.all_quality_status_view, (ViewGroup)this);
      View var3 = this.findViewById(R.id.sensor_pm25_layout);
      Intrinsics.checkNotNullExpressionValue(var3, "findViewById(...)");
      this.pm25Layout = (QualityStatusView)var3;
      var3 = this.findViewById(R.id.sensor_pm10_layout);
      Intrinsics.checkNotNullExpressionValue(var3, "findViewById(...)");
      this.pm10Layout = (QualityStatusView)var3;
      var3 = this.findViewById(R.id.sensor_co_layout);
      Intrinsics.checkNotNullExpressionValue(var3, "findViewById(...)");
      this.coLayout = (QualityStatusView)var3;
      var3 = this.findViewById(R.id.sensor_so2_or_else_layout);
      Intrinsics.checkNotNullExpressionValue(var3, "findViewById(...)");
      this.so2OrElseLayout = (QualityStatusView)var3;
   }

   public AllQualityStatusView(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2, var3);
      ConstraintLayout.inflate(this.getContext(), R.layout.all_quality_status_view, (ViewGroup)this);
      View var4 = this.findViewById(R.id.sensor_pm25_layout);
      Intrinsics.checkNotNullExpressionValue(var4, "findViewById(...)");
      this.pm25Layout = (QualityStatusView)var4;
      var4 = this.findViewById(R.id.sensor_pm10_layout);
      Intrinsics.checkNotNullExpressionValue(var4, "findViewById(...)");
      this.pm10Layout = (QualityStatusView)var4;
      var4 = this.findViewById(R.id.sensor_co_layout);
      Intrinsics.checkNotNullExpressionValue(var4, "findViewById(...)");
      this.coLayout = (QualityStatusView)var4;
      var4 = this.findViewById(R.id.sensor_so2_or_else_layout);
      Intrinsics.checkNotNullExpressionValue(var4, "findViewById(...)");
      this.so2OrElseLayout = (QualityStatusView)var4;
   }

   public AllQualityStatusView(Context var1, AttributeSet var2, int var3, int var4) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2, var3, var4);
      ConstraintLayout.inflate(this.getContext(), R.layout.all_quality_status_view, (ViewGroup)this);
      View var5 = this.findViewById(R.id.sensor_pm25_layout);
      Intrinsics.checkNotNullExpressionValue(var5, "findViewById(...)");
      this.pm25Layout = (QualityStatusView)var5;
      var5 = this.findViewById(R.id.sensor_pm10_layout);
      Intrinsics.checkNotNullExpressionValue(var5, "findViewById(...)");
      this.pm10Layout = (QualityStatusView)var5;
      var5 = this.findViewById(R.id.sensor_co_layout);
      Intrinsics.checkNotNullExpressionValue(var5, "findViewById(...)");
      this.coLayout = (QualityStatusView)var5;
      var5 = this.findViewById(R.id.sensor_so2_or_else_layout);
      Intrinsics.checkNotNullExpressionValue(var5, "findViewById(...)");
      this.so2OrElseLayout = (QualityStatusView)var5;
   }

   private final void bind(PollutantType var1, Double var2, int var3, QualityStatusView var4) {
      int var7;
      if (Intrinsics.areEqual(var1, PollutantType.PM25.INSTANCE)) {
         var7 = R.string.pm25_title;
      } else if (Intrinsics.areEqual(var1, PollutantType.PM10.INSTANCE)) {
         var7 = R.string.pm10_title_short;
      } else if (Intrinsics.areEqual(var1, PollutantType.CO.INSTANCE)) {
         var7 = R.string.co_title_short;
      } else if (Intrinsics.areEqual(var1, PollutantType.NO2.INSTANCE)) {
         var7 = R.string.no2_title_alt;
      } else if (Intrinsics.areEqual(var1, PollutantType.O3.INSTANCE)) {
         var7 = R.string.o3_title_alt;
      } else if (Intrinsics.areEqual(var1, PollutantType.SO2.INSTANCE)) {
         var7 = R.string.so2_title_alt;
      } else {
         if (!Intrinsics.areEqual(var1, PollutantType.AQI.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
         }

         var7 = R.string.aqi_title;
      }

      ((TextView)var4.findViewById(R.id.quality_title)).setText(var7);
      String var8;
      if (Intrinsics.areEqual(var1, PollutantType.CO.INSTANCE)) {
         double var5;
         if (var2 != null) {
            var5 = var2;
         } else {
            var5 = (double)0.0F;
         }

         var8 = String.format("%.1f", Arrays.copyOf(new Object[]{var5}, 1));
         Intrinsics.checkNotNullExpressionValue(var8, "format(...)");
      } else {
         if (var2 != null) {
            var7 = (int)var2;
         } else {
            var7 = 0;
         }

         var8 = String.valueOf(var7);
      }

      ((TextView)var4.findViewById(R.id.quality_value)).setText((CharSequence)StringsKt.padStart$default(var8, 3, '\u0000', 2, (Object)null));
      var7 = OutdoorAirRatingRanges.INSTANCE.getPollutantRangePosition((float)var3, PollutantType.AQI.INSTANCE);
      if (var7 >= 0) {
         var3 = var7;
      } else {
         Timber.Forest var10 = Timber.Forest;
         StringBuilder var9 = new StringBuilder("bind: imagePos ");
         var9.append(var7);
         var9.append(" for value ");
         var9.append(var3);
         var9.append(" is not found");
         var10.w(var9.toString(), new Object[0]);
         var3 = OutdoorAirRatingRanges.INSTANCE.getMaxPollutantRangePosition(PollutantType.AQI.INSTANCE);
      }

      var3 = this.getResources().getColor(((Number)OutdoorUiUtils.INSTANCE.getAqiSeverityColorsNew().get(var3)).intValue(), (Resources.Theme)null);
      ((ImageView)var4.findViewById(R.id.quality_status_image)).setImageTintList(ColorStateList.valueOf(var3));
   }

   public final void bind(OutdoorPollutants var1) {
      Intrinsics.checkNotNullParameter(var1, "pollutants");
      PollutantType var4 = PollutantType.PM25.INSTANCE;
      Pollutant var2 = var1.getPm25();
      Object var3 = null;
      Double var6;
      if (var2 != null) {
         var6 = var2.getConcentration();
      } else {
         var6 = null;
      }

      this.bind(var4, var6, var1.getPm25AQI(), this.pm25Layout);
      var4 = PollutantType.PM10.INSTANCE;
      Pollutant var7 = var1.getPm10();
      Double var8;
      if (var7 != null) {
         var8 = var7.getConcentration();
      } else {
         var8 = null;
      }

      this.bind(var4, var8, var1.getPm10AQI(), this.pm10Layout);
      var4 = PollutantType.CO.INSTANCE;
      Pollutant var9 = var1.getCo();
      Double var10;
      if (var9 != null) {
         var10 = var9.getConcentration();
      } else {
         var10 = null;
      }

      this.bind(var4, var10, var1.getCoAQI(), this.coLayout);
      var4 = PollutantType.SO2.INSTANCE;
      Pollutant var5 = var1.getSo2();
      var10 = (Double)var3;
      if (var5 != null) {
         var10 = var5.getConcentration();
      }

      this.bind(var4, var10, var1.getSo2AQI(), this.so2OrElseLayout);
   }
}
