package io.flatcircle.ble;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleIcpController$$ExternalSyntheticLambda14 implements SingleOnSubscribe {
    public final /* synthetic */ BleIcpController f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ BleIcpController$$ExternalSyntheticLambda14(BleIcpController bleIcpController, long j, long j2) {
        this.f$0 = bleIcpController;
        this.f$1 = j;
        this.f$2 = j2;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        BleIcpController.scan$lambda$16(this.f$0, this.f$1, this.f$2, singleEmitter);
    }
}
