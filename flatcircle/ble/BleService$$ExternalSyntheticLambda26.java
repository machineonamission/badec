package io.flatcircle.ble;

import io.flatcircle.ble.BleIcpController;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleService$$ExternalSyntheticLambda26 implements Function1 {
    public final /* synthetic */ BleService f$0;

    public /* synthetic */ BleService$$ExternalSyntheticLambda26(BleService bleService) {
        this.f$0 = bleService;
    }

    public final Object invoke(Object obj) {
        return BleService.subscribe$lambda$8(this.f$0, (BleIcpController.IcpDevice) obj);
    }
}
