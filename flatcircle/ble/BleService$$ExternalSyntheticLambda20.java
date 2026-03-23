package io.flatcircle.ble;

import io.reactivex.functions.Predicate;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleService$$ExternalSyntheticLambda20 implements Predicate {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ BleService$$ExternalSyntheticLambda20(Function1 function1) {
        this.f$0 = function1;
    }

    public final boolean test(Object obj) {
        return BleService.subscribe$lambda$3(this.f$0, obj);
    }
}
