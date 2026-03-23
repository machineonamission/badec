package com.blueair.antifake.adapter;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: Comparisons.kt */
public final class SearchedDeviceAdapter$sortList$$inlined$sortBy$1<T> implements Comparator {
    public final int compare(T t, T t2) {
        SearchedDevice searchedDevice = (SearchedDevice) t;
        int i = 1;
        Comparable valueOf = Integer.valueOf(searchedDevice.isOnline() ? 0 : searchedDevice.getDevice() != null ? 1 : 2);
        SearchedDevice searchedDevice2 = (SearchedDevice) t2;
        if (searchedDevice2.isOnline()) {
            i = 0;
        } else if (searchedDevice2.getDevice() == null) {
            i = 2;
        }
        return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
    }
}
