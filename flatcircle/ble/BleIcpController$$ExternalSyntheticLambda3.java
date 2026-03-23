package io.flatcircle.ble;

import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleIcpController$$ExternalSyntheticLambda3 implements Function {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ BleIcpController$$ExternalSyntheticLambda3(Function1 function1) {
        this.f$0 = function1;
    }

    public final Object apply(Object obj) {
        return BleIcpController.connect$lambda$13(this.f$0, obj);
    }
}
