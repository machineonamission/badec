package com.blueair.devicedetails.util;

import com.blueair.core.model.MoodLampEnum;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00068G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/blueair/devicedetails/util/NightLampUtils;", "", "<init>", "()V", "titleRes", "", "Lcom/blueair/core/model/MoodLampEnum;", "getTitleRes", "(Lcom/blueair/core/model/MoodLampEnum;)I", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NightLampUtils.kt */
public final class NightLampUtils {
    public static final NightLampUtils INSTANCE = new NightLampUtils();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: NightLampUtils.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.core.model.MoodLampEnum[] r0 = com.blueair.core.model.MoodLampEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.MoodLampEnum r1 = com.blueair.core.model.MoodLampEnum.WARM     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.MoodLampEnum r1 = com.blueair.core.model.MoodLampEnum.NORMAL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.MoodLampEnum r1 = com.blueair.core.model.MoodLampEnum.BRIGHT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.util.NightLampUtils.WhenMappings.<clinit>():void");
        }
    }

    private NightLampUtils() {
    }

    public final int getTitleRes(MoodLampEnum moodLampEnum) {
        Intrinsics.checkNotNullParameter(moodLampEnum, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[moodLampEnum.ordinal()];
        if (i == 1) {
            return R.string.light_gear_warm;
        }
        if (i == 2) {
            return R.string.light_gear_normal;
        }
        if (i != 3) {
            return R.string.light_gear_off;
        }
        return R.string.light_gear_bright;
    }
}
