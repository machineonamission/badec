package com.blueair.core.model;

import com.blueair.core.model.Filter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003¨\u0006\u0004"}, d2 = {"getSupportedFilters", "", "Lcom/blueair/core/model/Filter;", "Lcom/blueair/core/model/HasFanSpeed;", "core_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: Filter.kt */
public final class FilterKt {
    public static final List<Filter> getSupportedFilters(HasFanSpeed hasFanSpeed) {
        Intrinsics.checkNotNullParameter(hasFanSpeed, "<this>");
        if (hasFanSpeed instanceof DeviceSense) {
            return CollectionsKt.listOf(Filter.ParticleFilter.INSTANCE);
        }
        if (!(hasFanSpeed instanceof DeviceClassic) && !(hasFanSpeed instanceof DeviceClassicWithoutSensors)) {
            return CollectionsKt.emptyList();
        }
        return CollectionsKt.listOf(Filter.ParticleFilter.INSTANCE, Filter.SmokeStopFilter.INSTANCE);
    }
}
