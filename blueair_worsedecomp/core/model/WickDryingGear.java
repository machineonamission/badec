package com.blueair.core.model;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/blueair/core/model/WickDryingGear;", "", "duration", "", "<init>", "(Ljava/lang/String;II)V", "getDuration", "()I", "OFF", "LOW", "HIGH", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: WickDryingGear.kt */
public enum WickDryingGear {
    OFF(0),
    LOW(7200),
    HIGH(1800);
    
    public static final Companion Companion = null;
    private final int duration;

    public static EnumEntries<WickDryingGear> getEntries() {
        return $ENTRIES;
    }

    private WickDryingGear(int i) {
        this.duration = i;
    }

    public final int getDuration() {
        return this.duration;
    }

    static {
        WickDryingGear[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/core/model/WickDryingGear$Companion;", "", "<init>", "()V", "fromDuration", "Lcom/blueair/core/model/WickDryingGear;", "duration", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: WickDryingGear.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WickDryingGear fromDuration(int i) {
            Object obj;
            Iterator it = WickDryingGear.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((WickDryingGear) obj).getDuration() == i) {
                    break;
                }
            }
            WickDryingGear wickDryingGear = (WickDryingGear) obj;
            return wickDryingGear == null ? WickDryingGear.OFF : wickDryingGear;
        }
    }
}
