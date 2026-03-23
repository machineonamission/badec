package com.blueair.core.model;

import com.blueair.core.model.FilterTrigger;
import com.foobot.liblabclient.domain.outdoor.CityStation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"triggerToServerValue", "", "Lcom/blueair/core/model/Device;", "trigger", "Lcom/blueair/core/model/FilterTrigger;", "core_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: FilterTrigger.kt */
public final class FilterTriggerKt {
    public static final String triggerToServerValue(Device device, FilterTrigger filterTrigger) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        Intrinsics.checkNotNullParameter(filterTrigger, "trigger");
        if (Intrinsics.areEqual((Object) filterTrigger, (Object) FilterTrigger.Particles.INSTANCE)) {
            if (DeviceKt.isG4orB4orNB(device)) {
                return CityStation.PM25;
            }
            return "pm";
        } else if (Intrinsics.areEqual((Object) filterTrigger, (Object) FilterTrigger.ParticlesAndGases.INSTANCE)) {
            if (DeviceKt.isG4orB4orNB(device)) {
                return "PMtVOC";
            }
            return "pm_voc";
        } else if (Intrinsics.areEqual((Object) filterTrigger, (Object) FilterTrigger.UnknownTrigger.INSTANCE)) {
            return "unknown";
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
