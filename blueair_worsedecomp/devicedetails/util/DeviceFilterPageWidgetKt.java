package com.blueair.devicedetails.util;

import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceG4;
import com.blueair.devicedetails.util.DeviceFilterPageWidget;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001¨\u0006\u0006"}, d2 = {"supportFilterWidget", "", "Lcom/blueair/core/model/Device;", "widget", "Lcom/blueair/devicedetails/util/DeviceFilterPageWidget;", "filterPurchase", "devicedetails_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceFilterPageWidget.kt */
public final class DeviceFilterPageWidgetKt {
    public static final boolean supportFilterWidget(Device device, DeviceFilterPageWidget deviceFilterPageWidget, boolean z) {
        Intrinsics.checkNotNullParameter(device, "<this>");
        Intrinsics.checkNotNullParameter(deviceFilterPageWidget, "widget");
        if (device instanceof DeviceG4) {
            if (Intrinsics.areEqual((Object) deviceFilterPageWidget, (Object) DeviceFilterPageWidget.FilterTutorialVideo.INSTANCE)) {
                return !((DeviceG4) device).isPlus();
            }
            if (Intrinsics.areEqual((Object) deviceFilterPageWidget, (Object) DeviceFilterPageWidget.FilterType.INSTANCE) || Intrinsics.areEqual((Object) deviceFilterPageWidget, (Object) DeviceFilterPageWidget.FilterStatus.INSTANCE) || Intrinsics.areEqual((Object) deviceFilterPageWidget, (Object) DeviceFilterPageWidget.FilterImportanceVideo.INSTANCE)) {
                return true;
            }
            if (Intrinsics.areEqual((Object) deviceFilterPageWidget, (Object) DeviceFilterPageWidget.FilterReset.INSTANCE)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object) deviceFilterPageWidget, (Object) DeviceFilterPageWidget.FilterPurchase.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
        } else if (Intrinsics.areEqual((Object) deviceFilterPageWidget, (Object) DeviceFilterPageWidget.FilterType.INSTANCE) || Intrinsics.areEqual((Object) deviceFilterPageWidget, (Object) DeviceFilterPageWidget.FilterStatus.INSTANCE) || Intrinsics.areEqual((Object) deviceFilterPageWidget, (Object) DeviceFilterPageWidget.FilterImportanceVideo.INSTANCE)) {
            return true;
        } else {
            if (Intrinsics.areEqual((Object) deviceFilterPageWidget, (Object) DeviceFilterPageWidget.FilterPurchase.INSTANCE)) {
                return z;
            }
            return false;
        }
        return z;
    }
}
