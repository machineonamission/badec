package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/blueair/core/model/TimerState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "COMPLETED", "START", "STOP", "RESUME", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: TimerState.kt */
public enum TimerState {
    COMPLETED(0),
    START(1),
    STOP(2),
    RESUME(3);
    
    private final int value;

    public static EnumEntries<TimerState> getEntries() {
        return $ENTRIES;
    }

    private TimerState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        TimerState[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
