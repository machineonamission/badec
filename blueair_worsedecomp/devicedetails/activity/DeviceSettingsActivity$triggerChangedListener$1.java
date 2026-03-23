package com.blueair.devicedetails.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSettingsActivity.kt */
final /* synthetic */ class DeviceSettingsActivity$triggerChangedListener$1 extends FunctionReferenceImpl implements Function0<Unit> {
    DeviceSettingsActivity$triggerChangedListener$1(Object obj) {
        super(0, obj, DeviceSettingsActivity.class, "checkForAutoModeTriggerUpdate", "checkForAutoModeTriggerUpdate()V", 0);
    }

    public final void invoke() {
        ((DeviceSettingsActivity) this.receiver).checkForAutoModeTriggerUpdate();
    }
}
