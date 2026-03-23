package com.blueair.devicedetails.adapter;

import com.blueair.core.model.DeviceAware;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: Comparisons.kt */
public final class LinkedDevicesAdapter$special$$inlined$sortedBy$1<T> implements Comparator {
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(((DeviceAware) t).getName(), ((DeviceAware) t2).getName());
    }
}
