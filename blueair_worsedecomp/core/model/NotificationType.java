package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/blueair/core/model/NotificationType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ALL", "LEGACY_PRODUCT_ALERT", "WATER_LEVEL", "FILTER_REPLACEMENT", "QUICK_ALARM_STOP", "FILTER_CLEANING", "MARKETING", "TRANSACTIONAL", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NotificationSetting.kt */
public enum NotificationType {
    ALL("all_alert"),
    LEGACY_PRODUCT_ALERT("product_alert"),
    WATER_LEVEL("water_level"),
    FILTER_REPLACEMENT("filter_replacement"),
    QUICK_ALARM_STOP("quick_alarm_stop"),
    FILTER_CLEANING("cleaning_reminders"),
    MARKETING("marketing_notifications"),
    TRANSACTIONAL("transactional_notifications");
    
    private final String value;

    public static EnumEntries<NotificationType> getEntries() {
        return $ENTRIES;
    }

    private NotificationType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        NotificationType[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
