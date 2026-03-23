package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/blueair/core/model/NotificationAqiSubType;", "", "<init>", "(Ljava/lang/String;I)V", "HUM", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NotificationMsgType.kt */
public enum NotificationAqiSubType {
    HUM;

    public static EnumEntries<NotificationAqiSubType> getEntries() {
        return $ENTRIES;
    }

    static {
        NotificationAqiSubType[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
