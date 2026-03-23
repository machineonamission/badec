package com.blueair.graph.utils;

import com.blueair.core.model.SensorType;
import com.blueair.viewcore.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bR!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0014\u0010\bR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0017\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/blueair/graph/utils/GraphUiUtils;", "", "<init>", "()V", "severityDots", "", "", "getSeverityDots", "()Ljava/util/List;", "severityDots$delegate", "Lkotlin/Lazy;", "severityDot8Null", "getSeverityDot8Null", "()I", "severityDots8", "getSeverityDots8", "severityDots8$delegate", "severityDot6Null", "getSeverityDot6Null", "severityDots6", "getSeverityDots6", "severityDots6$delegate", "severityColors", "getSeverityColors", "severityColors$delegate", "getSensorName", "sensorType", "Lcom/blueair/core/model/SensorType;", "graph_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GraphUiUtils.kt */
public final class GraphUiUtils {
    public static final GraphUiUtils INSTANCE = new GraphUiUtils();
    private static final Lazy severityColors$delegate = LazyKt.lazy(new GraphUiUtils$$ExternalSyntheticLambda3());
    private static final int severityDot6Null = R.drawable.ic_aqi_dot_null_6;
    private static final int severityDot8Null = R.drawable.ic_aqi_dot_null_8;
    private static final Lazy severityDots$delegate = LazyKt.lazy(new GraphUiUtils$$ExternalSyntheticLambda0());
    private static final Lazy severityDots6$delegate = LazyKt.lazy(new GraphUiUtils$$ExternalSyntheticLambda2());
    private static final Lazy severityDots8$delegate = LazyKt.lazy(new GraphUiUtils$$ExternalSyntheticLambda1());

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GraphUiUtils.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|12|13|15) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.core.model.SensorType[] r0 = com.blueair.core.model.SensorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM1     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM25     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM10     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.HUM     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.TMP     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.VOC     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.utils.GraphUiUtils.WhenMappings.<clinit>():void");
        }
    }

    private GraphUiUtils() {
    }

    public final List<Integer> getSeverityDots() {
        return (List) severityDots$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final List severityDots_delegate$lambda$0() {
        return CollectionsKt.listOf(Integer.valueOf(R.drawable.ic_marker_dot_excellent), Integer.valueOf(R.drawable.ic_marker_dot_good), Integer.valueOf(R.drawable.ic_marker_dot_moderate), Integer.valueOf(R.drawable.ic_marker_dot_polluted), Integer.valueOf(R.drawable.ic_marker_dot_vpolluted));
    }

    public final int getSeverityDot8Null() {
        return severityDot8Null;
    }

    public final List<Integer> getSeverityDots8() {
        return (List) severityDots8$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final List severityDots8_delegate$lambda$1() {
        return CollectionsKt.listOf(Integer.valueOf(R.drawable.ic_aqi_dot_excellent_8), Integer.valueOf(R.drawable.ic_aqi_dot_good_8), Integer.valueOf(R.drawable.ic_aqi_dot_moderate_8), Integer.valueOf(R.drawable.ic_aqi_dot_polluted_8), Integer.valueOf(R.drawable.ic_aqi_dot_vpolluted_8));
    }

    public final int getSeverityDot6Null() {
        return severityDot6Null;
    }

    public final List<Integer> getSeverityDots6() {
        return (List) severityDots6$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final List severityDots6_delegate$lambda$2() {
        return CollectionsKt.listOf(Integer.valueOf(R.drawable.ic_aqi_dot_excellent_6), Integer.valueOf(R.drawable.ic_aqi_dot_good_6), Integer.valueOf(R.drawable.ic_aqi_dot_moderate_6), Integer.valueOf(R.drawable.ic_aqi_dot_polluted_6), Integer.valueOf(R.drawable.ic_aqi_dot_vpolluted_6));
    }

    public final List<Integer> getSeverityColors() {
        return (List) severityColors$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final List severityColors_delegate$lambda$3() {
        return CollectionsKt.listOf(Integer.valueOf(R.color.color_excellent), Integer.valueOf(R.color.color_good), Integer.valueOf(R.color.color_moderate), Integer.valueOf(R.color.color_polluted), Integer.valueOf(R.color.color_vpolluted));
    }

    public final int getSensorName(SensorType sensorType) {
        Intrinsics.checkNotNullParameter(sensorType, "sensorType");
        switch (WhenMappings.$EnumSwitchMapping$0[sensorType.ordinal()]) {
            case 1:
                return R.string.pm_1;
            case 2:
                return R.string.pm_25;
            case 3:
                return R.string.pm_10;
            case 4:
                return R.string.hum_expanded;
            case 5:
                return R.string.temp_expanded;
            case 6:
                return R.string.pet_sensor_tvoc;
            default:
                return R.string.pm_25;
        }
    }
}
