package com.blueair.devicemanager;

import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class IcpDeviceManager$$ExternalSyntheticLambda7 implements Function {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ IcpDeviceManager$$ExternalSyntheticLambda7(Function1 function1) {
        this.f$0 = function1;
    }

    public final Object apply(Object obj) {
        return IcpDeviceManager._get_connectionStateObservable_$lambda$9(this.f$0, obj);
    }
}
