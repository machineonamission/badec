package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/blueair/core/model/WaterLevel;", "", "<init>", "(Ljava/lang/String;I)V", "SHORTAGE", "NORMAL", "FULL", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: WaterLevel.kt */
public enum WaterLevel {
    SHORTAGE,
    NORMAL,
    FULL;
    
    public static final Companion Companion = null;

    public static EnumEntries<WaterLevel> getEntries() {
        return $ENTRIES;
    }

    static {
        WaterLevel[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/core/model/WaterLevel$Companion;", "", "<init>", "()V", "fromValue", "Lcom/blueair/core/model/WaterLevel;", "value", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: WaterLevel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WaterLevel fromValue(int i) {
            if (i == 0) {
                return WaterLevel.SHORTAGE;
            }
            if (i != 1) {
                if (i != 2) {
                    if (!(i == 25 || i == 50 || i == 75)) {
                        if (i != 100) {
                            return WaterLevel.NORMAL;
                        }
                    }
                }
                return WaterLevel.FULL;
            }
            return WaterLevel.NORMAL;
        }
    }
}
