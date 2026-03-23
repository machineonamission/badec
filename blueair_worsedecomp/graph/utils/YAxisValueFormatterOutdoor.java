package com.blueair.graph.utils;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.ValueFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/blueair/graph/utils/YAxisValueFormatterOutdoor;", "Lcom/github/mikephil/charting/formatter/ValueFormatter;", "maxThresholds", "", "<init>", "([D)V", "getMaxThresholds", "()[D", "getAxisLabel", "", "value", "", "axis", "Lcom/github/mikephil/charting/components/AxisBase;", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MpOutdoorChartUtils.kt */
public final class YAxisValueFormatterOutdoor extends ValueFormatter {
    private final double[] maxThresholds;

    public YAxisValueFormatterOutdoor(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "maxThresholds");
        this.maxThresholds = dArr;
    }

    public final double[] getMaxThresholds() {
        return this.maxThresholds;
    }

    public String getAxisLabel(float f, AxisBase axisBase) {
        return String.valueOf(MathKt.roundToInt(MpOutdoorChartUtils.INSTANCE.getRealValueFromScaledChartValueOutdoor((double) f, this.maxThresholds)));
    }
}
