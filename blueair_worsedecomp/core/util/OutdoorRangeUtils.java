package com.blueair.core.util;

import androidx.recyclerview.widget.ItemTouchHelper;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J%\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u0011J \u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/blueair/core/util/OutdoorRangeUtils;", "", "<init>", "()V", "AQI_LOW", "", "AQI_HIGH", "convertIAQIToMeasurement", "", "iAQI", "low", "high", "(Ljava/lang/Double;[D[D)Ljava/lang/Double;", "convertMeasurementToiAQI", "", "value", "", "(Ljava/lang/Double;[D[D)I", "findIndexOfMeasurement", "measurement", "lowValues", "highValues", "getAQIFromIndividualAQI", "allAQI", "", "convertAqiToPercentage", "aqi", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: OutdoorRangeUtils.kt */
public final class OutdoorRangeUtils {
    private static final double[] AQI_HIGH = {50.0d, 100.0d, 150.0d, 200.0d, 300.0d, 500.0d};
    private static final double[] AQI_LOW = {0.0d, 51.0d, 101.0d, 151.0d, 201.0d, 301.0d};
    public static final OutdoorRangeUtils INSTANCE = new OutdoorRangeUtils();

    public final double convertAqiToPercentage(double d) {
        if (d <= 0.0d) {
            d = 0.0d;
        } else if (d > 200.0d) {
            if (d <= 500.0d) {
                double d2 = (double) 200;
                d = ((d - d2) / ((double) 6)) + d2;
            } else {
                d = 250.0d;
            }
        }
        return d / ((double) ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    }

    private OutdoorRangeUtils() {
    }

    public final Double convertIAQIToMeasurement(Double d, double[] dArr, double[] dArr2) {
        Intrinsics.checkNotNullParameter(dArr, "low");
        Intrinsics.checkNotNullParameter(dArr2, "high");
        if (d == null) {
            return null;
        }
        d.doubleValue();
        OutdoorRangeUtils outdoorRangeUtils = INSTANCE;
        double doubleValue = d.doubleValue();
        double[] dArr3 = AQI_LOW;
        double[] dArr4 = AQI_HIGH;
        int findIndexOfMeasurement = outdoorRangeUtils.findIndexOfMeasurement(doubleValue, dArr3, dArr4);
        double d2 = dArr[findIndexOfMeasurement];
        double d3 = dArr2[findIndexOfMeasurement];
        double d4 = dArr3[findIndexOfMeasurement];
        return Double.valueOf((((d.doubleValue() - d4) * (d3 - d2)) / (dArr4[findIndexOfMeasurement] - d4)) + d2);
    }

    public final int convertMeasurementToiAQI(float f, double[] dArr, double[] dArr2) {
        Intrinsics.checkNotNullParameter(dArr, "low");
        Intrinsics.checkNotNullParameter(dArr2, "high");
        if (f == Float.MAX_VALUE) {
            return 0;
        }
        return convertMeasurementToiAQI(Double.valueOf((double) f), dArr, dArr2);
    }

    public final int convertMeasurementToiAQI(Double d, double[] dArr, double[] dArr2) {
        Intrinsics.checkNotNullParameter(dArr, "low");
        Intrinsics.checkNotNullParameter(dArr2, "high");
        if (d == null) {
            return 0;
        }
        d.doubleValue();
        int findIndexOfMeasurement = INSTANCE.findIndexOfMeasurement(d.doubleValue(), dArr, dArr2);
        double d2 = AQI_LOW[findIndexOfMeasurement];
        double d3 = AQI_HIGH[findIndexOfMeasurement];
        double d4 = dArr[findIndexOfMeasurement];
        double d5 = dArr2[findIndexOfMeasurement];
        double doubleValue = (((d3 - d2) / (d5 - d4)) * (d.doubleValue() - d4)) + d2;
        Timber.Forest forest = Timber.Forest;
        forest.d("convertMeasurementToiAQI: " + d + " -> " + doubleValue + " | iHigh=" + d3 + " iLow=" + d2 + " cHigh=" + d5 + " cLow=" + d4, new Object[0]);
        return (int) doubleValue;
    }

    private final int findIndexOfMeasurement(double d, double[] dArr, double[] dArr2) {
        int length = dArr.length;
        if (length == dArr2.length) {
            int length2 = dArr2.length;
            int i = 0;
            int i2 = 0;
            while (i < length2) {
                double d2 = dArr2[i];
                int i3 = i2 + 1;
                if ((d >= dArr[i2] && d <= dArr2[i2]) || (i2 == length - 1 && d > dArr2[i2])) {
                    return i2;
                }
                i++;
                i2 = i3;
            }
        }
        return 0;
    }

    public final int getAQIFromIndividualAQI(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "allAQI");
        Integer maxOrNull = ArraysKt.maxOrNull(iArr);
        if (maxOrNull != null) {
            return maxOrNull.intValue();
        }
        return 0;
    }
}
