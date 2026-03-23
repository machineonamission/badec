package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0012"}, d2 = {"Lcom/blueair/core/model/LogLength;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "M5", "M10", "M15", "M30", "M60", "M120", "M180", "ALL", "minutes", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LogUploading.kt */
public enum LogLength {
    M5("5"),
    M10("10"),
    M15("15"),
    M30("30"),
    M60("60"),
    M120("120"),
    M180("180"),
    ALL("all");
    
    private final String value;

    public static EnumEntries<LogLength> getEntries() {
        return $ENTRIES;
    }

    private LogLength(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        LogLength[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }

    public final int minutes() {
        if (this == ALL) {
            return -1;
        }
        return Integer.parseInt(this.value);
    }
}
