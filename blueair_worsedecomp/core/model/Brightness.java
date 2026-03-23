package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u000f"}, d2 = {"Lcom/blueair/core/model/Brightness;", "", "<init>", "(Ljava/lang/String;I)V", "OFF", "ONE", "TWO", "THREE", "FOUR", "toServerValue", "", "device", "Lcom/blueair/core/model/Device;", "toPercentage", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Brightness.kt */
public enum Brightness {
    OFF,
    ONE,
    TWO,
    THREE,
    FOUR;
    
    public static final Companion Companion = null;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Brightness.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.core.model.Brightness[] r0 = com.blueair.core.model.Brightness.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.Brightness r1 = com.blueair.core.model.Brightness.OFF     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.Brightness r1 = com.blueair.core.model.Brightness.ONE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.Brightness r1 = com.blueair.core.model.Brightness.TWO     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.Brightness r1 = com.blueair.core.model.Brightness.THREE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.core.model.Brightness r1 = com.blueair.core.model.Brightness.FOUR     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.Brightness.WhenMappings.<clinit>():void");
        }
    }

    public static EnumEntries<Brightness> getEntries() {
        return $ENTRIES;
    }

    static {
        Brightness[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/blueair/core/model/Brightness$Companion;", "", "<init>", "()V", "fromServerValue", "Lcom/blueair/core/model/Brightness;", "device", "Lcom/blueair/core/model/Device;", "value", "", "fromPercentage", "percentage", "isSlidingRight", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Brightness.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Brightness fromServerValue(Device device, int i) {
            Intrinsics.checkNotNullParameter(device, "device");
            if (!(device instanceof HasBrightness)) {
                return Brightness.OFF;
            }
            if ((device instanceof DeviceAware) || DeviceKt.isG4orB4orNB(device)) {
                if (76 <= i && i <= Integer.MAX_VALUE) {
                    return Brightness.FOUR;
                }
                if (51 <= i && i < 76) {
                    return Brightness.THREE;
                }
                if (26 <= i && i < 51) {
                    return Brightness.TWO;
                }
                if (1 > i || i >= 26) {
                    return Brightness.OFF;
                }
                return Brightness.ONE;
            } else if (4 <= i && i <= Integer.MAX_VALUE) {
                return Brightness.FOUR;
            } else {
                if (i == 3) {
                    return Brightness.THREE;
                }
                if (i == 2) {
                    return Brightness.TWO;
                }
                if (i == 1) {
                    return Brightness.ONE;
                }
                return Brightness.OFF;
            }
        }

        public final Brightness fromPercentage(int i, boolean z) {
            if (i == 100) {
                return Brightness.FOUR;
            }
            if (76 <= i && i <= Integer.MAX_VALUE) {
                return z ? Brightness.FOUR : Brightness.THREE;
            }
            if (i == 75) {
                return Brightness.THREE;
            }
            if (51 <= i && i < 75) {
                return z ? Brightness.THREE : Brightness.TWO;
            }
            if (i == 50) {
                return Brightness.TWO;
            }
            if (26 <= i && i < 50) {
                return z ? Brightness.TWO : Brightness.ONE;
            }
            if (i == 25) {
                return Brightness.ONE;
            }
            if (1 > i || i >= 25) {
                return Brightness.OFF;
            }
            return z ? Brightness.ONE : Brightness.OFF;
        }
    }

    public final int toServerValue(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        if ((device instanceof HasBlueCloudFunctions) || (device instanceof DeviceAware)) {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 25;
            }
            if (i == 3) {
                return 50;
            }
            if (i == 4) {
                return 75;
            }
            if (i == 5) {
                return 100;
            }
            throw new NoWhenBranchMatchedException();
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        if (i2 == 3) {
            return 2;
        }
        if (i2 == 4) {
            return 3;
        }
        if (i2 == 5) {
            return 4;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int toPercentage() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 25;
        }
        if (i == 3) {
            return 50;
        }
        if (i == 4) {
            return 75;
        }
        if (i == 5) {
            return 100;
        }
        throw new NoWhenBranchMatchedException();
    }
}
