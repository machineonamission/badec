package com.blueair.viewcore.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J/\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u001dR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/blueair/viewcore/view/AllQualityStatusView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "pm25Layout", "Lcom/blueair/viewcore/view/QualityStatusView;", "pm10Layout", "coLayout", "so2OrElseLayout", "bind", "", "pollutants", "Lcom/blueair/core/model/OutdoorPollutants;", "type", "Lcom/blueair/core/model/PollutantType;", "value", "", "aqi", "layout", "(Lcom/blueair/core/model/PollutantType;Ljava/lang/Double;ILcom/blueair/viewcore/view/QualityStatusView;)V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AllQualityStatusView.kt */
public final class AllQualityStatusView extends ConstraintLayout {
    private final QualityStatusView coLayout;
    private final QualityStatusView pm10Layout;
    private final QualityStatusView pm25Layout;
    private final QualityStatusView so2OrElseLayout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AllQualityStatusView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        ConstraintLayout.inflate(getContext(), R.layout.all_quality_status_view, this);
        View findViewById = findViewById(R.id.sensor_pm25_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.pm25Layout = (QualityStatusView) findViewById;
        View findViewById2 = findViewById(R.id.sensor_pm10_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.pm10Layout = (QualityStatusView) findViewById2;
        View findViewById3 = findViewById(R.id.sensor_co_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.coLayout = (QualityStatusView) findViewById3;
        View findViewById4 = findViewById(R.id.sensor_so2_or_else_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.so2OrElseLayout = (QualityStatusView) findViewById4;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AllQualityStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        ConstraintLayout.inflate(getContext(), R.layout.all_quality_status_view, this);
        View findViewById = findViewById(R.id.sensor_pm25_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.pm25Layout = (QualityStatusView) findViewById;
        View findViewById2 = findViewById(R.id.sensor_pm10_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.pm10Layout = (QualityStatusView) findViewById2;
        View findViewById3 = findViewById(R.id.sensor_co_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.coLayout = (QualityStatusView) findViewById3;
        View findViewById4 = findViewById(R.id.sensor_so2_or_else_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.so2OrElseLayout = (QualityStatusView) findViewById4;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AllQualityStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        ConstraintLayout.inflate(getContext(), R.layout.all_quality_status_view, this);
        View findViewById = findViewById(R.id.sensor_pm25_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.pm25Layout = (QualityStatusView) findViewById;
        View findViewById2 = findViewById(R.id.sensor_pm10_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.pm10Layout = (QualityStatusView) findViewById2;
        View findViewById3 = findViewById(R.id.sensor_co_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.coLayout = (QualityStatusView) findViewById3;
        View findViewById4 = findViewById(R.id.sensor_so2_or_else_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.so2OrElseLayout = (QualityStatusView) findViewById4;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AllQualityStatusView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        ConstraintLayout.inflate(getContext(), R.layout.all_quality_status_view, this);
        View findViewById = findViewById(R.id.sensor_pm25_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.pm25Layout = (QualityStatusView) findViewById;
        View findViewById2 = findViewById(R.id.sensor_pm10_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.pm10Layout = (QualityStatusView) findViewById2;
        View findViewById3 = findViewById(R.id.sensor_co_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.coLayout = (QualityStatusView) findViewById3;
        View findViewById4 = findViewById(R.id.sensor_so2_or_else_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.so2OrElseLayout = (QualityStatusView) findViewById4;
    }

    public final void bind(OutdoorPollutants outdoorPollutants) {
        Intrinsics.checkNotNullParameter(outdoorPollutants, "pollutants");
        PollutantType pollutantType = PollutantType.PM25.INSTANCE;
        Pollutant pm25 = outdoorPollutants.getPm25();
        Double d = null;
        bind(pollutantType, pm25 != null ? pm25.getConcentration() : null, outdoorPollutants.getPm25AQI(), this.pm25Layout);
        PollutantType pollutantType2 = PollutantType.PM10.INSTANCE;
        Pollutant pm10 = outdoorPollutants.getPm10();
        bind(pollutantType2, pm10 != null ? pm10.getConcentration() : null, outdoorPollutants.getPm10AQI(), this.pm10Layout);
        PollutantType pollutantType3 = PollutantType.CO.INSTANCE;
        Pollutant co = outdoorPollutants.getCo();
        bind(pollutantType3, co != null ? co.getConcentration() : null, outdoorPollutants.getCoAQI(), this.coLayout);
        PollutantType pollutantType4 = PollutantType.SO2.INSTANCE;
        Pollutant so2 = outdoorPollutants.getSo2();
        if (so2 != null) {
            d = so2.getConcentration();
        }
        bind(pollutantType4, d, outdoorPollutants.getSo2AQI(), this.so2OrElseLayout);
    }

    private final void bind(PollutantType pollutantType, Double d, int i, QualityStatusView qualityStatusView) {
        int i2;
        String str;
        if (Intrinsics.areEqual((Object) pollutantType, (Object) PollutantType.PM25.INSTANCE)) {
            i2 = R.string.pm25_title;
        } else if (Intrinsics.areEqual((Object) pollutantType, (Object) PollutantType.PM10.INSTANCE)) {
            i2 = R.string.pm10_title_short;
        } else if (Intrinsics.areEqual((Object) pollutantType, (Object) PollutantType.CO.INSTANCE)) {
            i2 = R.string.co_title_short;
        } else if (Intrinsics.areEqual((Object) pollutantType, (Object) PollutantType.NO2.INSTANCE)) {
            i2 = R.string.no2_title_alt;
        } else if (Intrinsics.areEqual((Object) pollutantType, (Object) PollutantType.O3.INSTANCE)) {
            i2 = R.string.o3_title_alt;
        } else if (Intrinsics.areEqual((Object) pollutantType, (Object) PollutantType.SO2.INSTANCE)) {
            i2 = R.string.so2_title_alt;
        } else if (Intrinsics.areEqual((Object) pollutantType, (Object) PollutantType.AQI.INSTANCE)) {
            i2 = R.string.aqi_title;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        ((TextView) qualityStatusView.findViewById(R.id.quality_title)).setText(i2);
        if (Intrinsics.areEqual((Object) pollutantType, (Object) PollutantType.CO.INSTANCE)) {
            str = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(d != null ? d.doubleValue() : 0.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        } else {
            str = String.valueOf(d != null ? (int) d.doubleValue() : 0);
        }
        ((TextView) qualityStatusView.findViewById(R.id.quality_value)).setText(StringsKt.padStart$default(str, 3, 0, 2, (Object) null));
        int pollutantRangePosition = OutdoorAirRatingRanges.INSTANCE.getPollutantRangePosition((float) i, PollutantType.AQI.INSTANCE);
        if (pollutantRangePosition < 0) {
            Timber.Forest forest = Timber.Forest;
            forest.w("bind: imagePos " + pollutantRangePosition + " for value " + i + " is not found", new Object[0]);
            pollutantRangePosition = OutdoorAirRatingRanges.INSTANCE.getMaxPollutantRangePosition(PollutantType.AQI.INSTANCE);
        }
        ((ImageView) qualityStatusView.findViewById(R.id.quality_status_image)).setImageTintList(ColorStateList.valueOf(getResources().getColor(OutdoorUiUtils.INSTANCE.getAqiSeverityColorsNew().get(pollutantRangePosition).intValue(), (Resources.Theme) null)));
    }
}
