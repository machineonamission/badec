package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\n"}, d2 = {"Lcom/blueair/core/model/AutoMode;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_AVAILABLE", "ON", "OFF", "toText", "", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AutoMode.kt */
public enum AutoMode {
    NOT_AVAILABLE,
    ON,
    OFF;
    
    public static final String AUTO_MODE_DISABLED = "manual";
    public static final String AUTO_MODE_ENABLED = "auto";
    public static final Companion Companion = null;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AutoMode.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.core.model.AutoMode[] r0 = com.blueair.core.model.AutoMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.AutoMode r1 = com.blueair.core.model.AutoMode.ON     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.AutoMode r1 = com.blueair.core.model.AutoMode.NOT_AVAILABLE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.AutoMode r1 = com.blueair.core.model.AutoMode.OFF     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AutoMode.WhenMappings.<clinit>():void");
        }
    }

    public static EnumEntries<AutoMode> getEntries() {
        return $ENTRIES;
    }

    static {
        AutoMode[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/blueair/core/model/AutoMode$Companion;", "", "<init>", "()V", "AUTO_MODE_ENABLED", "", "AUTO_MODE_DISABLED", "from", "Lcom/blueair/core/model/AutoMode;", "device", "Lcom/blueair/core/model/Device;", "input", "fromBoolean", "autoMode", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AutoMode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AutoMode from(Device device, String str) {
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(str, "input");
            if (!(device instanceof DeviceClassic) && !DeviceKt.isG4orB4orNB(device) && !(device instanceof DeviceIcp) && (!(device instanceof HasLinkingCapability) || !((HasLinkingCapability) device).isLinked())) {
                return AutoMode.NOT_AVAILABLE;
            }
            if (Intrinsics.areEqual((Object) str, (Object) "auto")) {
                return AutoMode.ON;
            }
            return AutoMode.OFF;
        }

        public final AutoMode fromBoolean(boolean z) {
            return z ? AutoMode.ON : AutoMode.OFF;
        }
    }

    public final String toText() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return "auto";
        }
        if (i == 2 || i == 3) {
            return AUTO_MODE_DISABLED;
        }
        throw new NoWhenBranchMatchedException();
    }
}
