package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\f"}, d2 = {"Lcom/blueair/core/model/MoodLampEnum;", "", "<init>", "(Ljava/lang/String;I)V", "OFF", "WARM", "NORMAL", "BRIGHT", "toServerValue", "", "toStep", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MoodLampEnum.kt */
public enum MoodLampEnum {
    OFF,
    WARM,
    NORMAL,
    BRIGHT;
    
    public static final Companion Companion = null;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: MoodLampEnum.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.blueair.core.model.MoodLampEnum[] r0 = com.blueair.core.model.MoodLampEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.MoodLampEnum r1 = com.blueair.core.model.MoodLampEnum.OFF     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.MoodLampEnum r1 = com.blueair.core.model.MoodLampEnum.WARM     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.MoodLampEnum r1 = com.blueair.core.model.MoodLampEnum.NORMAL     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.MoodLampEnum r1 = com.blueair.core.model.MoodLampEnum.BRIGHT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.MoodLampEnum.WhenMappings.<clinit>():void");
        }
    }

    public static EnumEntries<MoodLampEnum> getEntries() {
        return $ENTRIES;
    }

    static {
        MoodLampEnum[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/blueair/core/model/MoodLampEnum$Companion;", "", "<init>", "()V", "fromServerValue", "Lcom/blueair/core/model/MoodLampEnum;", "device", "Lcom/blueair/core/model/HasMoodLamp;", "fromStep", "step", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: MoodLampEnum.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MoodLampEnum fromServerValue(HasMoodLamp hasMoodLamp) {
            Intrinsics.checkNotNullParameter(hasMoodLamp, "device");
            int nightLampBrightness = hasMoodLamp.getNightLampBrightness();
            if (nightLampBrightness == 1) {
                return MoodLampEnum.WARM;
            }
            if (nightLampBrightness == 2) {
                return MoodLampEnum.NORMAL;
            }
            if (nightLampBrightness != 3) {
                return MoodLampEnum.OFF;
            }
            return MoodLampEnum.BRIGHT;
        }

        public final MoodLampEnum fromStep(int i) {
            if (i == 0) {
                return MoodLampEnum.OFF;
            }
            if (i == 1) {
                return MoodLampEnum.WARM;
            }
            if (i == 2) {
                return MoodLampEnum.NORMAL;
            }
            if (i != 3) {
                return MoodLampEnum.OFF;
            }
            return MoodLampEnum.BRIGHT;
        }
    }

    public final int toServerValue() {
        return toStep();
    }

    public final int toStep() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return 3;
        }
        throw new NoWhenBranchMatchedException();
    }
}
