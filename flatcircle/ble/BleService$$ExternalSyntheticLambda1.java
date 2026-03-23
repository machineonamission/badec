package io.flatcircle.ble;

import kotlin.Pair;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleService$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ BleService f$0;

    public /* synthetic */ BleService$$ExternalSyntheticLambda1(BleService bleService) {
        this.f$0 = bleService;
    }

    public final Object invoke(Object obj) {
        return BleService.subscribe$lambda$20(this.f$0, (Pair) obj);
    }
}
