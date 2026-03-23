package com.blueair.graph.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¨\u0006\f"}, d2 = {"Lcom/blueair/graph/utils/MpOutdoorChartUtils;", "", "<init>", "()V", "getRealValueFromScaledChartValueOutdoor", "", "scaledValue", "maxThresholds", "", "valueFromPercentageForOutdoor", "highRangeArray", "percentage", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MpOutdoorChartUtils.kt */
public final class MpOutdoorChartUtils {
    public static final MpOutdoorChartUtils INSTANCE = new MpOutdoorChartUtils();

    private MpOutdoorChartUtils() {
    }

    public final double getRealValueFromScaledChartValueOutdoor(double d, double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "maxThresholds");
        return valueFromPercentageForOutdoor(dArr, d);
    }

    private final double valueFromPercentageForOutdoor(double[] dArr, double d) {
        double[] dArr2 = dArr;
        int i = 0;
        List mutableListOf = CollectionsKt.mutableListOf(Double.valueOf(0.0d));
        Iterable<Number> dropLast = ArraysKt.dropLast(dArr2, 0);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(dropLast, 10));
        for (Number doubleValue : dropLast) {
            arrayList.add(Double.valueOf(doubleValue.doubleValue() + 0.01d));
        }
        mutableListOf.addAll((List) arrayList);
        double[] doubleArray = CollectionsKt.toDoubleArray(mutableListOf);
        int length = dArr2.length;
        if (d <= 0.0d) {
            return 0.0d;
        }
        if (d >= 99.0d) {
            return dArr2[length - 1];
        }
        double d2 = (double) length;
        double d3 = 100.0d / d2;
        int i2 = length - 1;
        if (i2 >= 0) {
            while (true) {
                double d4 = ((double) i) * d3;
                int i3 = i + 1;
                double d5 = ((double) i3) * d3;
                if (d <= d4 || d > d5) {
                    if (i == i2) {
                        break;
                    }
                    i = i3;
                } else if (i == 0) {
                    return ((d * dArr2[i]) * d2) / ((double) 100);
                } else {
                    double d6 = (d - d4) / (d5 - d4);
                    double d7 = doubleArray[i];
                    return ((dArr2[i] * d6) - (d6 * d7)) + d7;
                }
            }
        }
        return 0.0d;
    }
}
