package com.blueair.core.model;

import com.blueair.auth.GigyaService;
import com.gigya.android.sdk.ui.Presenter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0012"}, d2 = {"Lcom/blueair/core/model/SensorType;", "", "<init>", "(Ljava/lang/String;I)V", "PM1", "PM25", "PM10", "VOC", "HCHO", "HUM", "TMP", "FAN", "WEIGHT", "formatValue", "", "value", "", "(Ljava/lang/Float;)Ljava/lang/String;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: IndoorData.kt */
public enum SensorType {
    PM1,
    PM25,
    PM10,
    VOC,
    HCHO,
    HUM,
    TMP,
    FAN,
    WEIGHT;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorData.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.blueair.core.model.SensorType[] r0 = com.blueair.core.model.SensorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.VOC     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.HCHO     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.SensorType.WhenMappings.<clinit>():void");
        }
    }

    public static EnumEntries<SensorType> getEntries() {
        return $ENTRIES;
    }

    static {
        SensorType[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }

    public final String formatValue(Float f) {
        if (f == null) {
            return StringsKt.padStart$default(GigyaService.DEFAULT_USER_NAME, 3, 0, 2, (Object) null);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return "";
        }
        if (i != 2) {
            return StringsKt.padStart$default(String.valueOf(MathKt.roundToInt(f.floatValue())), 3, 0, 2, (Object) null);
        }
        String format = String.format("%.4f", Arrays.copyOf(new Object[]{Float.valueOf(f.floatValue() / ((float) Presenter.Consts.JS_TIMEOUT))}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
