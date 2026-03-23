package com.blueair.android.viewmodel;

import com.blueair.core.model.Device;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class IndoorViewModel$liveDevicesWithLatestDataPoint$1$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ Map f$0;

    public /* synthetic */ IndoorViewModel$liveDevicesWithLatestDataPoint$1$$ExternalSyntheticLambda1(Map map) {
        this.f$0 = map;
    }

    public final Object invoke(Object obj) {
        return IndoorViewModel$liveDevicesWithLatestDataPoint$1.invokeSuspend$lambda$2(this.f$0, (Device) obj);
    }
}
