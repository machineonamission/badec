package com.blueair.devicedetails.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/blueair/devicedetails/viewmodel/FilterLifeResetResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILED", "DEVICE_OFFLINE", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceDetailsViewModel.kt */
public enum FilterLifeResetResult {
    SUCCESS,
    FAILED,
    DEVICE_OFFLINE;

    public static EnumEntries<FilterLifeResetResult> getEntries() {
        return $ENTRIES;
    }

    static {
        FilterLifeResetResult[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
