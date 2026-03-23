package com.blueair.graph.utils;

import android.content.Context;
import com.blueair.viewcore.R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0015J(\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0015H\u0002¨\u0006\u0019"}, d2 = {"Lcom/blueair/graph/utils/SensorRangeUtils;", "", "<init>", "()V", "percentageFromIndoorRange", "", "ranges", "", "value", "percentageFromRange", "thresholds", "getSeekbarValue", "", "progress", "", "minThresh", "maxThresh", "mapValueToSeverityPM25Indoor", "", "context", "Landroid/content/Context;", "", "mapValueToSeverityVOCIndoor", "mapValueToSeverity", "severity_array_id", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SensorRangeUtils.kt */
public final class SensorRangeUtils {
    public static final SensorRangeUtils INSTANCE = new SensorRangeUtils();

    private SensorRangeUtils() {
    }

    public final double percentageFromIndoorRange(double[] dArr, double d) {
        Intrinsics.checkNotNullParameter(dArr, "ranges");
        if (!(dArr.length == 0)) {
            return percentageFromRange(dArr, d);
        }
        return Double.MAX_VALUE;
    }

    public final double percentageFromRange(double[] dArr, double d) {
        Intrinsics.checkNotNullParameter(dArr, "thresholds");
        if (!(dArr.length == 0)) {
            double length = 100.0d / ((double) (dArr.length - 1));
            if (d == 0.0d) {
                return 0.0d;
            }
            if (d > dArr[dArr.length - 1]) {
                return 99.0d;
            }
            int length2 = dArr.length - 1;
            for (int i = 0; i < length2; i++) {
                double d2 = dArr[i];
                if (d > d2) {
                    double d3 = dArr[i + 1];
                    if (d <= d3) {
                        return (((double) i) * length) + (((d - d2) / (d3 - d2)) * length);
                    }
                }
            }
        }
        return 0.0d;
    }

    public final float getSeekbarValue(int i, double[] dArr, double[] dArr2) {
        float f;
        char c;
        Intrinsics.checkNotNullParameter(dArr, "minThresh");
        Intrinsics.checkNotNullParameter(dArr2, "maxThresh");
        if (i <= 25) {
            c = 0;
            f = 0.0f;
        } else if (26 <= i && i < 51) {
            c = 1;
            f = 25.0f;
        } else if (51 > i || i >= 76) {
            c = 3;
            f = 75.0f;
        } else {
            c = 2;
            f = 50.0f;
        }
        double d = dArr[c];
        return ((float) d) + (((((float) i) - f) * (((float) dArr2[c]) - ((float) d))) / 25.0f);
    }

    public final String mapValueToSeverityPM25Indoor(Context context, float f, int[] iArr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iArr, "thresholds");
        return mapValueToSeverity(context, f, R.array.severity_strings, iArr);
    }

    public final String mapValueToSeverityVOCIndoor(Context context, float f, int[] iArr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iArr, "thresholds");
        return mapValueToSeverity(context, f, R.array.severity_strings, iArr);
    }

    private final String mapValueToSeverity(Context context, float f, int i, int[] iArr) {
        Object obj;
        String[] stringArray = context.getResources().getStringArray(i);
        Iterator it = ArraysKt.getIndices(iArr).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (f < ((float) iArr[((Number) obj).intValue()])) {
                break;
            }
        }
        Integer num = (Integer) obj;
        String str = stringArray[num != null ? num.intValue() : iArr.length - 1];
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        return str;
    }
}
