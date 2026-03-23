package com.blueair.graph.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.blueair.core.model.SensorType;
import com.blueair.viewcore.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.github.mikephil.charting.data.Entry;
import io.flatcircle.viewhelper.ScreenDensity;
import io.flatcircle.viewhelper.ViewHelperUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import timber.log.Timber;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u00018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J&\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ&\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ.\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0012J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0012J\u0018\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0016\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0012J\u0016\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ(\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u000eJ&\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&J\u0016\u0010\"\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&J\u0018\u0010+\u001a\u00020#2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010,\u001a\u00020&H\u0002J\u001a\u0010-\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\b\b\u0002\u0010'\u001a\u00020\u000eH\u0002J\u001a\u0010.\u001a\u00020#2\u0006\u0010)\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u000eH\u0002J\u001e\u0010/\u001a\u00020#2\u0006\u0010)\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010%\u001a\u00020&J\u0018\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020#H\u0002J\"\u00103\u001a\b\u0012\u0004\u0012\u000205042\f\u00106\u001a\b\u0012\u0004\u0012\u000205042\u0006\u0010\u0006\u001a\u00020\u0007J$\u00103\u001a\b\u0012\u0004\u0012\u000205042\f\u00106\u001a\b\u0012\u0004\u0012\u000205042\u0006\u00107\u001a\u00020\u0005H\u0002¨\u00069"}, d2 = {"Lcom/blueair/graph/utils/MpChartUtils;", "", "<init>", "()V", "getSamplingThreshold", "", "timeScale", "Lcom/blueair/graph/utils/ChartTimeScale;", "getYAxisMinimum", "context", "Landroid/content/Context;", "sensorType", "Lcom/blueair/core/model/SensorType;", "indoor", "", "tempIsCelsius", "getYAxisMaximum", "getPaintColorForLineChart", "", "view", "Landroid/view/View;", "paint", "Landroid/graphics/Paint;", "chartHeight", "numberOfSensorRanges", "getGraphIncrements", "", "numberOfIncrements", "getArrayOfColor", "getFloatArrayForGraph", "", "getChartLabelYOffsetDivisor", "showDeviceLearningGraphOverlay", "koreaDeviceLearning", "getScaledValueForChart", "", "realValue", "maxThresholds", "", "isCelsius", "getRealValueFromScaledChartValue", "scaledValue", "dataValue", "getRealDefaultValueFromScaledValue", "maxThresholdArray", "getScaledTemperatureForChart", "getRealTemperatureFromScaledValue", "getRealValueFromScaledChartValueOutdoor", "valueFromPercentageForOutdoor", "highRangeArray", "percentage", "reduceWithDouglasPeucker", "", "Lcom/github/mikephil/charting/data/Entry;", "points", "tolerance", "Line", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MpChartUtils.kt */
public final class MpChartUtils {
    public static final MpChartUtils INSTANCE = new MpChartUtils();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: MpChartUtils.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|(2:21|22)|23|25|26|27|28|29|30|31|32|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|49) */
        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|(2:21|22)|23|25|26|27|28|29|30|31|32|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|49) */
        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|16|17|18|19|(2:21|22)|23|25|26|27|28|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|49) */
        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|(2:21|22)|23|25|26|27|28|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|49) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0055 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0094 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00a4 */
        static {
            /*
                com.blueair.graph.utils.ChartTimeScale[] r0 = com.blueair.graph.utils.ChartTimeScale.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.blueair.graph.utils.ChartTimeScale r2 = com.blueair.graph.utils.ChartTimeScale.DAY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.blueair.graph.utils.ChartTimeScale r3 = com.blueair.graph.utils.ChartTimeScale.WEEK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.blueair.graph.utils.ChartTimeScale r4 = com.blueair.graph.utils.ChartTimeScale.MONTH     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                com.blueair.core.model.SensorType[] r0 = com.blueair.core.model.SensorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.SensorType r4 = com.blueair.core.model.SensorType.TMP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.blueair.core.model.SensorType r4 = com.blueair.core.model.SensorType.HUM     // Catch:{ NoSuchFieldError -> 0x003b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r4] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.blueair.core.model.SensorType r4 = com.blueair.core.model.SensorType.PM1     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                r4 = 4
                com.blueair.core.model.SensorType r5 = com.blueair.core.model.SensorType.PM10     // Catch:{ NoSuchFieldError -> 0x004c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                r5 = 5
                com.blueair.core.model.SensorType r6 = com.blueair.core.model.SensorType.PM25     // Catch:{ NoSuchFieldError -> 0x0055 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0055 }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x0055 }
            L_0x0055:
                com.blueair.core.model.SensorType r6 = com.blueair.core.model.SensorType.VOC     // Catch:{ NoSuchFieldError -> 0x005e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r7 = 6
                r0[r6] = r7     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                com.blueair.core.model.SensorType r6 = com.blueair.core.model.SensorType.HCHO     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r7 = 7
                r0[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                com.blueair.core.model.SensorType r6 = com.blueair.core.model.SensorType.FAN     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r7 = 8
                r0[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                com.blueair.core.model.SensorType r6 = com.blueair.core.model.SensorType.WEIGHT     // Catch:{ NoSuchFieldError -> 0x007b }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r7 = 9
                r0[r6] = r7     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                $EnumSwitchMapping$1 = r0
                io.flatcircle.viewhelper.ScreenDensity[] r0 = io.flatcircle.viewhelper.ScreenDensity.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                io.flatcircle.viewhelper.ScreenDensity r6 = io.flatcircle.viewhelper.ScreenDensity.XXXHIGH     // Catch:{ NoSuchFieldError -> 0x008c }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                io.flatcircle.viewhelper.ScreenDensity r1 = io.flatcircle.viewhelper.ScreenDensity.XXHIGH     // Catch:{ NoSuchFieldError -> 0x0094 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0094 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0094 }
            L_0x0094:
                io.flatcircle.viewhelper.ScreenDensity r1 = io.flatcircle.viewhelper.ScreenDensity.XHIGH     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                io.flatcircle.viewhelper.ScreenDensity r1 = io.flatcircle.viewhelper.ScreenDensity.HIGH     // Catch:{ NoSuchFieldError -> 0x00a4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a4 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00a4 }
            L_0x00a4:
                io.flatcircle.viewhelper.ScreenDensity r1 = io.flatcircle.viewhelper.ScreenDensity.LOW     // Catch:{ NoSuchFieldError -> 0x00ac }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ac }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00ac }
            L_0x00ac:
                $EnumSwitchMapping$2 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.utils.MpChartUtils.WhenMappings.<clinit>():void");
        }
    }

    private final double getRealTemperatureFromScaledValue(float f, boolean z) {
        double d;
        double d2;
        if (!z) {
            d = 100.0d;
            if (f > 25.0f && f > 50.0f && f > 75.0f && f > 100.0f) {
                return 40.0d;
            }
            d2 = ((double) f) * 105.0d;
        } else {
            d = 2.5d;
            if (f > 25.0f && f > 50.0f && f > 75.0f && f > 100.0f) {
                return 40.0d;
            }
            d2 = (double) f;
        }
        return d2 / d;
    }

    private MpChartUtils() {
    }

    public final float getSamplingThreshold(ChartTimeScale chartTimeScale) {
        Intrinsics.checkNotNullParameter(chartTimeScale, "timeScale");
        int i = WhenMappings.$EnumSwitchMapping$0[chartTimeScale.ordinal()];
        if (i == 1) {
            return 0.0f;
        }
        if (i == 2) {
            return 4.0f;
        }
        if (i == 3) {
            return 6.0f;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final float getYAxisMinimum(Context context, SensorType sensorType, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        if (WhenMappings.$EnumSwitchMapping$1[sensorType.ordinal()] == 1) {
            return z2 ? z ? -10.0f : -20.0f : z ? 14.0f : -4.0f;
        }
        return 0.0f;
    }

    public final float getYAxisMaximum(Context context, SensorType sensorType, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        if (WhenMappings.$EnumSwitchMapping$1[sensorType.ordinal()] == 1) {
            return z2 ? z ? 40.0f : 60.0f : z ? 104.0f : 140.0f;
        }
        return 100.0f;
    }

    public final int getPaintColorForLineChart(View view, Paint paint, float f, SensorType sensorType, int i) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        int i2 = WhenMappings.$EnumSwitchMapping$1[sensorType.ordinal()];
        if (i2 == 1 || i2 == 2) {
            paint.setShader((Shader) null);
            return ContextCompat.getColor(view.getContext(), R.color.bruno_blue);
        }
        paint.setShader(new LinearGradient(0.0f, 25.0f, 0.0f, f, getArrayOfColor(view, i), getFloatArrayForGraph(), Shader.TileMode.CLAMP));
        return paint.getColor();
    }

    public final int[] getGraphIncrements(View view, int i) {
        View view2 = view;
        int i2 = i;
        Intrinsics.checkNotNullParameter(view2, ViewHierarchyConstants.VIEW_KEY);
        int i3 = 80;
        int i4 = 22;
        int i5 = -1;
        if (i2 != 5) {
            int i6 = 71;
            int i7 = 48;
            if (i2 != 6) {
                ScreenDensity calculateScreenDensity = ViewHelperUtil.INSTANCE.calculateScreenDensity(view2);
                if (calculateScreenDensity != null) {
                    int i8 = WhenMappings.$EnumSwitchMapping$2[calculateScreenDensity.ordinal()];
                }
                ScreenDensity calculateScreenDensity2 = ViewHelperUtil.INSTANCE.calculateScreenDensity(view2);
                if (calculateScreenDensity2 != null) {
                    int i9 = WhenMappings.$EnumSwitchMapping$2[calculateScreenDensity2.ordinal()];
                }
                ScreenDensity calculateScreenDensity3 = ViewHelperUtil.INSTANCE.calculateScreenDensity(view2);
                if (calculateScreenDensity3 != null) {
                    int i10 = WhenMappings.$EnumSwitchMapping$2[calculateScreenDensity3.ordinal()];
                }
                return new int[]{25, 48, 71, 100};
            }
            ScreenDensity calculateScreenDensity4 = ViewHelperUtil.INSTANCE.calculateScreenDensity(view2);
            int i11 = calculateScreenDensity4 == null ? -1 : WhenMappings.$EnumSwitchMapping$2[calculateScreenDensity4.ordinal()];
            if (!(i11 == 1 || i11 == 2)) {
                i4 = i11 != 3 ? i11 != 4 ? 16 : 18 : 20;
            }
            ScreenDensity calculateScreenDensity5 = ViewHelperUtil.INSTANCE.calculateScreenDensity(view2);
            int i12 = calculateScreenDensity5 == null ? -1 : WhenMappings.$EnumSwitchMapping$2[calculateScreenDensity5.ordinal()];
            int i13 = 37;
            if (!(i12 == 1 || i12 == 2)) {
                i13 = i12 != 3 ? i12 != 4 ? 32 : 34 : 36;
            }
            ScreenDensity calculateScreenDensity6 = ViewHelperUtil.INSTANCE.calculateScreenDensity(view2);
            int i14 = calculateScreenDensity6 == null ? -1 : WhenMappings.$EnumSwitchMapping$2[calculateScreenDensity6.ordinal()];
            if (i14 == 1) {
                i7 = 55;
            } else if (i14 == 2) {
                i7 = 54;
            } else if (i14 == 3) {
                i7 = 52;
            } else if (i14 == 4) {
                i7 = 50;
            }
            ScreenDensity calculateScreenDensity7 = ViewHelperUtil.INSTANCE.calculateScreenDensity(view2);
            int i15 = calculateScreenDensity7 == null ? -1 : WhenMappings.$EnumSwitchMapping$2[calculateScreenDensity7.ordinal()];
            if (i15 == 1) {
                i6 = 73;
            } else if (i15 == 2) {
                i6 = 72;
            } else if (i15 != 3) {
                i6 = i15 != 4 ? 67 : 69;
            }
            ScreenDensity calculateScreenDensity8 = ViewHelperUtil.INSTANCE.calculateScreenDensity(view2);
            if (calculateScreenDensity8 != null) {
                i5 = WhenMappings.$EnumSwitchMapping$2[calculateScreenDensity8.ordinal()];
            }
            if (i5 == 1) {
                i3 = 86;
            } else if (i5 == 2) {
                i3 = 85;
            } else if (i5 == 3) {
                i3 = 84;
            } else if (i5 == 4) {
                i3 = 82;
            }
            return new int[]{i4, i13, i7, i6, i3, 100};
        }
        ScreenDensity calculateScreenDensity9 = ViewHelperUtil.INSTANCE.calculateScreenDensity(view2);
        int i16 = calculateScreenDensity9 == null ? -1 : WhenMappings.$EnumSwitchMapping$2[calculateScreenDensity9.ordinal()];
        if (i16 == 1) {
            i4 = 23;
        } else if (i16 != 2) {
            i4 = 21;
        }
        ScreenDensity calculateScreenDensity10 = ViewHelperUtil.INSTANCE.calculateScreenDensity(view2);
        int i17 = calculateScreenDensity10 == null ? -1 : WhenMappings.$EnumSwitchMapping$2[calculateScreenDensity10.ordinal()];
        int i18 = i17 != 1 ? i17 != 2 ? i17 != 3 ? 38 : 40 : 42 : 44;
        ScreenDensity calculateScreenDensity11 = ViewHelperUtil.INSTANCE.calculateScreenDensity(view2);
        int i19 = calculateScreenDensity11 == null ? -1 : WhenMappings.$EnumSwitchMapping$2[calculateScreenDensity11.ordinal()];
        int i20 = i19 != 1 ? i19 != 2 ? i19 != 3 ? 56 : 58 : 60 : 62;
        ScreenDensity calculateScreenDensity12 = ViewHelperUtil.INSTANCE.calculateScreenDensity(view2);
        if (calculateScreenDensity12 != null) {
            i5 = WhenMappings.$EnumSwitchMapping$2[calculateScreenDensity12.ordinal()];
        }
        if (i5 != 1) {
            i3 = i5 != 2 ? i5 != 3 ? 74 : 76 : 78;
        }
        return new int[]{i4, i18, i20, i3, 100};
    }

    private final int[] getArrayOfColor(View view, int i) {
        int i2;
        int i3;
        Context context = view.getContext();
        int[] iArr = new int[100];
        int[] graphIncrements = getGraphIncrements(view, i - 1);
        if (i == 6) {
            for (int i4 = 0; i4 < 100; i4++) {
                Resources resources = context.getResources();
                if (i4 <= graphIncrements[0]) {
                    i2 = R.color.color_vpolluted;
                } else if (i4 <= graphIncrements[1]) {
                    i2 = R.color.color_polluted;
                } else if (i4 <= graphIncrements[2]) {
                    i2 = R.color.color_moderate;
                } else if (i4 <= graphIncrements[3]) {
                    i2 = R.color.color_good;
                } else {
                    i2 = R.color.color_excellent;
                }
                iArr[i4] = ResourcesCompat.getColor(resources, i2, (Resources.Theme) null);
            }
        } else if (i != 7) {
            for (int i5 = 0; i5 < 100; i5++) {
                if (i5 <= 25) {
                    iArr[i5] = ResourcesCompat.getColor(context.getResources(), R.color.dark_orange_severity, (Resources.Theme) null);
                } else if (i5 <= 48) {
                    iArr[i5] = ResourcesCompat.getColor(context.getResources(), R.color.orange_severity, (Resources.Theme) null);
                } else if (i5 <= 71) {
                    iArr[i5] = ResourcesCompat.getColor(context.getResources(), R.color.blue_severity, (Resources.Theme) null);
                } else {
                    iArr[i5] = ResourcesCompat.getColor(context.getResources(), R.color.light_blue_severity, (Resources.Theme) null);
                }
            }
        } else {
            for (int i6 = 0; i6 < 100; i6++) {
                Resources resources2 = context.getResources();
                if (i6 <= graphIncrements[0]) {
                    i3 = R.color.gauge_band_6_outdoor;
                } else if (i6 <= graphIncrements[1]) {
                    i3 = R.color.gauge_band_5_outdoor;
                } else if (i6 <= graphIncrements[2]) {
                    i3 = R.color.gauge_band_4_outdoor;
                } else if (i6 <= graphIncrements[3]) {
                    i3 = R.color.gauge_band_3_outdoor;
                } else if (i6 <= graphIncrements[4]) {
                    i3 = R.color.gauge_band_2_outdoor;
                } else {
                    i3 = R.color.gauge_band_1_outdoor;
                }
                iArr[i6] = ResourcesCompat.getColor(resources2, i3, (Resources.Theme) null);
            }
        }
        return iArr;
    }

    private final float[] getFloatArrayForGraph() {
        Iterable intRange = new IntRange(0, 99);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(((float) ((IntIterator) it).nextInt()) / 100.0f));
        }
        return CollectionsKt.toFloatArray((List) arrayList);
    }

    public final float getChartLabelYOffsetDivisor(View view, int i) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        int i2 = -1;
        if (i == 6) {
            ScreenDensity calculateScreenDensity = ViewHelperUtil.INSTANCE.calculateScreenDensity(view);
            if (calculateScreenDensity != null) {
                i2 = WhenMappings.$EnumSwitchMapping$2[calculateScreenDensity.ordinal()];
            }
            if (i2 == 1) {
                return 40.0f;
            }
            if (i2 == 2) {
                return 38.0f;
            }
            if (i2 == 3) {
                return 32.0f;
            }
            if (i2 == 4) {
                return 34.0f;
            }
            if (i2 != 5) {
                return 32.0f;
            }
            return 30.0f;
        } else if (i != 7) {
            ScreenDensity calculateScreenDensity2 = ViewHelperUtil.INSTANCE.calculateScreenDensity(view);
            if (calculateScreenDensity2 != null) {
                i2 = WhenMappings.$EnumSwitchMapping$2[calculateScreenDensity2.ordinal()];
            }
            if (i2 == 1) {
                return 34.0f;
            }
            if (i2 == 2) {
                return 32.0f;
            }
            if (i2 != 3) {
                return i2 != 4 ? 24.0f : 28.0f;
            }
            return 26.0f;
        } else {
            ScreenDensity calculateScreenDensity3 = ViewHelperUtil.INSTANCE.calculateScreenDensity(view);
            if (calculateScreenDensity3 != null) {
                i2 = WhenMappings.$EnumSwitchMapping$2[calculateScreenDensity3.ordinal()];
            }
            if (i2 == 1) {
                return 55.0f;
            }
            if (i2 != 2) {
                return 32.0f;
            }
            return 48.0f;
        }
    }

    public final boolean showDeviceLearningGraphOverlay(boolean z, SensorType sensorType) {
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        return (!z || sensorType == SensorType.TMP || sensorType == SensorType.HUM) ? false : true;
    }

    public static /* synthetic */ double getScaledValueForChart$default(MpChartUtils mpChartUtils, float f, SensorType sensorType, double[] dArr, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return mpChartUtils.getScaledValueForChart(f, sensorType, dArr, z);
    }

    public final double getScaledValueForChart(float f, SensorType sensorType, double[] dArr, boolean z) {
        double d;
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        Intrinsics.checkNotNullParameter(dArr, "maxThresholds");
        switch (WhenMappings.$EnumSwitchMapping$1[sensorType.ordinal()]) {
            case 1:
                d = getScaledTemperatureForChart((double) f, z);
                break;
            case 2:
                d = Math.max(0.0d, (double) f);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                d = getScaledValueForChart(f, dArr);
                break;
            case 8:
            case 9:
                d = (double) f;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return Math.min(100.0d, d);
    }

    public final double getRealValueFromScaledChartValue(float f, SensorType sensorType, boolean z, double[] dArr) {
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        Intrinsics.checkNotNullParameter(dArr, "maxThresholds");
        Timber.Forest forest = Timber.Forest;
        forest.d("getRealValueFromScaledChartValue: sensorType = " + sensorType + ", maxThresholds = " + ArraysKt.toList(dArr), new Object[0]);
        switch (WhenMappings.$EnumSwitchMapping$1[sensorType.ordinal()]) {
            case 1:
                return getRealTemperatureFromScaledValue(f, z);
            case 2:
                return Math.min(Math.max(0.0d, (double) f), 100.0d);
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return getRealDefaultValueFromScaledValue(f, dArr);
            case 8:
            case 9:
                return (double) f;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final double getScaledValueForChart(float f, double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "maxThresholds");
        double length = 100.0d / ((double) dArr.length);
        int length2 = dArr.length;
        int i = 0;
        while (true) {
            if (i >= length2) {
                i = -1;
                break;
            }
            if (((double) f) < dArr[i]) {
                break;
            }
            i++;
        }
        if (f <= 0.0f) {
            return 0.0d;
        }
        double d = (double) f;
        if (d >= ArraysKt.last(dArr)) {
            return 100.0d;
        }
        if (i == 0) {
            return d * (length / dArr[0]);
        }
        double d2 = dArr[i - 1];
        return (((double) i) * length) + ((d - d2) * (length / (dArr[i] - d2)));
    }

    private final double getRealDefaultValueFromScaledValue(float f, double[] dArr) {
        Timber.Forest.d("getRealDefaultValueFromScaledValue: scaledValue = " + f + ", maxThresholdArray = " + ArraysKt.toList(dArr), new Object[0]);
        int length = 100 / dArr.length;
        Timber.Forest.d("getRealDefaultValueFromScaledValue: sizeOfIncrement = " + length, new Object[0]);
        if (f <= 0.0f) {
            return 0.0d;
        }
        if (f <= ((float) length)) {
            return ((double) f) / (((double) length) / dArr[0]);
        }
        int length2 = dArr.length;
        if (2 <= length2) {
            int i = 2;
            while (f > ((float) (i * length))) {
                if (i != length2) {
                    i++;
                }
            }
            int i2 = i - 1;
            double d = dArr[i2];
            double d2 = dArr[i - 2];
            double d3 = ((double) length) / (d - d2);
            return (((double) (f - ((float) (i2 * length)))) + (d2 * d3)) / d3;
        }
        return ArraysKt.last(dArr);
    }

    static /* synthetic */ double getScaledTemperatureForChart$default(MpChartUtils mpChartUtils, double d, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return mpChartUtils.getScaledTemperatureForChart(d, z);
    }

    private final double getScaledTemperatureForChart(double d, boolean z) {
        if (!z) {
            Timber.Forest forest = Timber.Forest;
            forest.d("getScaledTemperatureForChart: FAHRENHEIT realValue = " + d, new Object[0]);
            if (d < 32.0d) {
                return 0.0d;
            }
            if (d <= 50.0d) {
                return (d * 100.0d) / 105.0d;
            }
            if (d <= 70.0d) {
                return (d * 100.0d) / ((double) 105);
            }
            if (d <= 85.0d) {
                return (d * 100.0d) / ((double) 105);
            }
            if (d <= 105.0d) {
                return (d * 100.0d) / ((double) 105);
            }
            return 100.0d;
        } else if (d <= 10.0d) {
            return d * 2.5d;
        } else {
            if (d <= 20.0d) {
                return d * 2.5d;
            }
            if (d <= 30.0d) {
                return d * 2.5d;
            }
            if (d <= 40.0d) {
                return d * 2.5d;
            }
            return 100.0d;
        }
    }

    static /* synthetic */ double getRealTemperatureFromScaledValue$default(MpChartUtils mpChartUtils, float f, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return mpChartUtils.getRealTemperatureFromScaledValue(f, z);
    }

    public final double getRealValueFromScaledChartValueOutdoor(double d, SensorType sensorType, double[] dArr) {
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        Intrinsics.checkNotNullParameter(dArr, "maxThresholds");
        return (sensorType == SensorType.TMP || sensorType == SensorType.HUM) ? d : valueFromPercentageForOutdoor(dArr, d);
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
        while (i < 6) {
            double d2 = (double) i;
            int i2 = i + 1;
            double d3 = (double) i2;
            double d4 = 16.666666666666668d * d3;
            if (d <= 16.666666666666668d * d2 || d > d4) {
                i = i2;
            } else if (i == 0) {
                return ((d * dArr2[i]) * ((double) length)) / ((double) 100);
            } else {
                double d5 = 100.0d / ((double) length);
                double d6 = d2 * d5;
                double d7 = (d - d6) / ((d5 * d3) - d6);
                double d8 = doubleArray[i];
                return ((dArr2[i] * d7) - (d7 * d8)) + d8;
            }
        }
        return 0.0d;
    }

    public final List<Entry> reduceWithDouglasPeucker(List<? extends Entry> list, ChartTimeScale chartTimeScale) {
        Intrinsics.checkNotNullParameter(list, "points");
        Intrinsics.checkNotNullParameter(chartTimeScale, "timeScale");
        int i = WhenMappings.$EnumSwitchMapping$0[chartTimeScale.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return list;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final List<Entry> reduceWithDouglasPeucker(List<? extends Entry> list, float f) {
        if (list.size() < 2) {
            return list;
        }
        Line line = new Line((Entry) list.get(0), (Entry) list.get(list.size() - 1));
        float f2 = 0.0f;
        int i = 0;
        for (int i2 = 1; i2 < list.size() - 1; i2++) {
            float distance = line.distance((Entry) list.get(i2));
            if (distance > f2) {
                i = i2;
                f2 = distance;
            }
        }
        if (f2 <= f) {
            return line.getPoints();
        }
        List<? extends Entry> subList = list.subList(0, i + 1);
        List<? extends Entry> subList2 = list.subList(i, list.size());
        List<Entry> reduceWithDouglasPeucker = reduceWithDouglasPeucker((List<? extends Entry>) new ArrayList(subList), f);
        List<Entry> reduceWithDouglasPeucker2 = reduceWithDouglasPeucker((List<? extends Entry>) new ArrayList(subList2), f);
        return new ArrayList<>(CollectionsKt.plus(new ArrayList(reduceWithDouglasPeucker), new ArrayList(reduceWithDouglasPeucker2.subList(1, reduceWithDouglasPeucker2.size()))));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0003R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/blueair/graph/utils/MpChartUtils$Line;", "", "p1", "Lcom/github/mikephil/charting/data/Entry;", "p2", "<init>", "(Lcom/github/mikephil/charting/data/Entry;Lcom/github/mikephil/charting/data/Entry;)V", "points", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPoints", "()Ljava/util/ArrayList;", "sxey", "", "exsy", "dx", "dy", "length", "distance", "pt", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: MpChartUtils.kt */
    private static final class Line {
        private final float dx;
        private final float dy;
        private final float exsy;
        private final float length;
        private final ArrayList<Entry> points;
        private final float sxey;

        public Line(Entry entry, Entry entry2) {
            Intrinsics.checkNotNullParameter(entry, "p1");
            Intrinsics.checkNotNullParameter(entry2, "p2");
            float x = entry.getX() - entry2.getX();
            this.dx = x;
            float y = entry.getY() - entry2.getY();
            this.dy = y;
            this.sxey = entry.getX() * entry2.getY();
            this.exsy = entry2.getX() * entry.getY();
            this.length = (float) Math.sqrt((double) ((x * x) + (y * y)));
            this.points = CollectionsKt.arrayListOf(entry, entry2);
        }

        public final ArrayList<Entry> getPoints() {
            return this.points;
        }

        public final float distance(Entry entry) {
            Intrinsics.checkNotNullParameter(entry, "pt");
            return Math.abs((((this.dy * entry.getX()) - (this.dx * entry.getY())) + this.sxey) - this.exsy) / this.length;
        }
    }
}
