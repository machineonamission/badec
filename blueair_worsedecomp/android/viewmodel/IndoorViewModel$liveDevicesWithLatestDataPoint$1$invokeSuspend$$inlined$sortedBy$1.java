package com.blueair.android.viewmodel;

import com.blueair.core.model.Device;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: Comparisons.kt */
public final class IndoorViewModel$liveDevicesWithLatestDataPoint$1$invokeSuspend$$inlined$sortedBy$1<T> implements Comparator {
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(((Device) t).getName(), ((Device) t2).getName());
    }
}
