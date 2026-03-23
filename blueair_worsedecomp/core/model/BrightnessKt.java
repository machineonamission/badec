package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"hasBrightnessInPercent", "", "Lcom/blueair/core/model/Device;", "core_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: Brightness.kt */
public final class BrightnessKt {
    public static final boolean hasBrightnessInPercent(Device device) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        return DeviceKt.isG4orB4orNB(device) || (device instanceof DeviceAware) || (device instanceof DeviceBlue);
    }
}
