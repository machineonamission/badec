package com.blueair.graph.utils;

import com.blueair.core.model.SensorType;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.ValueFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/blueair/graph/utils/YAxisValueFormatter;", "Lcom/github/mikephil/charting/formatter/ValueFormatter;", "sensorType", "Lcom/blueair/core/model/SensorType;", "indoor", "", "isCelsius", "maxThresholds", "", "<init>", "(Lcom/blueair/core/model/SensorType;ZZ[D)V", "getSensorType", "()Lcom/blueair/core/model/SensorType;", "getIndoor", "()Z", "getMaxThresholds", "()[D", "getAxisLabel", "", "value", "", "axis", "Lcom/github/mikephil/charting/components/AxisBase;", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ValueFormatter.kt */
public final class YAxisValueFormatter extends ValueFormatter {
    private final boolean indoor;
    private final boolean isCelsius;
    private final double[] maxThresholds;
    private final SensorType sensorType;

    public YAxisValueFormatter(SensorType sensorType2, boolean z, boolean z2, double[] dArr) {
        Intrinsics.checkNotNullParameter(sensorType2, "sensorType");
        Intrinsics.checkNotNullParameter(dArr, "maxThresholds");
        this.sensorType = sensorType2;
        this.indoor = z;
        this.isCelsius = z2;
        this.maxThresholds = dArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ YAxisValueFormatter(SensorType sensorType2, boolean z, boolean z2, double[] dArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sensorType2, (i & 2) != 0 ? true : z, (i & 4) != 0 ? true : z2, dArr);
    }

    public final boolean getIndoor() {
        return this.indoor;
    }

    public final double[] getMaxThresholds() {
        return this.maxThresholds;
    }

    public final SensorType getSensorType() {
        return this.sensorType;
    }

    public final boolean isCelsius() {
        return this.isCelsius;
    }

    public String getAxisLabel(float f, AxisBase axisBase) {
        if (this.indoor) {
            return String.valueOf(MathKt.roundToInt(MpChartUtils.INSTANCE.getRealValueFromScaledChartValue(f, this.sensorType, this.isCelsius, this.maxThresholds)));
        }
        return String.valueOf(MathKt.roundToInt(MpOutdoorChartUtils.INSTANCE.getRealValueFromScaledChartValueOutdoor((double) f, this.maxThresholds)));
    }
}
