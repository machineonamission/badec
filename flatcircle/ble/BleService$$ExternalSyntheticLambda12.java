package io.flatcircle.ble;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleService$$ExternalSyntheticLambda12 implements Consumer {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ BleService$$ExternalSyntheticLambda12(Function1 function1) {
        this.f$0 = function1;
    }

    public final void accept(Object obj) {
        BleService.subscribe$lambda$31(this.f$0, obj);
    }
}
