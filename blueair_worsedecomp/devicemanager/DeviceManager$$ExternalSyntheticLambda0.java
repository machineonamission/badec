package com.blueair.devicemanager;

import com.blueair.database.DeviceField;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceManager$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ DeviceField f$0;

    public /* synthetic */ DeviceManager$$ExternalSyntheticLambda0(DeviceField deviceField) {
        this.f$0 = deviceField;
    }

    public final Object invoke(Object obj) {
        return Boolean.valueOf(DeviceManager.handleStreamEvent$lambda$6$lambda$5(this.f$0, (Pair) obj));
    }
}
