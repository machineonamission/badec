package com.blueair.devicedetails.dialog;

import com.blueair.core.model.DeviceAlarm;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: Comparisons.kt */
public final class DeleteAlarmDialogFragment$onViewCreated$$inlined$sortedBy$1<T> implements Comparator {
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((DeviceAlarm) t).getSecondsInDay()), Integer.valueOf(((DeviceAlarm) t2).getSecondsInDay()));
    }
}
