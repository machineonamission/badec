package io.flatcircle.ble;

import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleService$$ExternalSyntheticLambda30 implements Function {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ BleService$$ExternalSyntheticLambda30(Function1 function1) {
        this.f$0 = function1;
    }

    public final Object apply(Object obj) {
        return BleService.subscribe$lambda$14(this.f$0, obj);
    }
}
