package com.blueair.devicedetails.adapter;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: Comparisons.kt */
public final class DeviceSensorCardsAdapter$updateSensorData$$inlined$sortedByDescending$1<T> implements Comparator {
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((Number) ((Pair) t2).component2()).intValue()), Integer.valueOf(((Number) ((Pair) t).component2()).intValue()));
    }
}
