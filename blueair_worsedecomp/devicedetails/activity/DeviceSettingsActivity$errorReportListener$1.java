package com.blueair.devicedetails.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSettingsActivity.kt */
final /* synthetic */ class DeviceSettingsActivity$errorReportListener$1 extends FunctionReferenceImpl implements Function0<Unit> {
    DeviceSettingsActivity$errorReportListener$1(Object obj) {
        super(0, obj, DeviceSettingsActivity.class, "onErrorReportClicked", "onErrorReportClicked()V", 0);
    }

    public final void invoke() {
        ((DeviceSettingsActivity) this.receiver).onErrorReportClicked();
    }
}
