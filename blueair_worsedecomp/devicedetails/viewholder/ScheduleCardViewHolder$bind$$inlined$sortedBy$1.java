package com.blueair.devicedetails.viewholder;

import com.blueair.core.model.DayOfWeek;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: Comparisons.kt */
public final class ScheduleCardViewHolder$bind$$inlined$sortedBy$1<T> implements Comparator {
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((DayOfWeek) t).getWeekDayCompareValue()), Integer.valueOf(((DayOfWeek) t2).getWeekDayCompareValue()));
    }
}
