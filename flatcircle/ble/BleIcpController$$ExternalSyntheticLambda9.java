package io.flatcircle.ble;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleIcpController$$ExternalSyntheticLambda9 implements SingleOnSubscribe {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ BleIcpController f$2;

    public /* synthetic */ BleIcpController$$ExternalSyntheticLambda9(String str, String str2, BleIcpController bleIcpController) {
        this.f$0 = str;
        this.f$1 = str2;
        this.f$2 = bleIcpController;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        BleIcpController.connect$lambda$15(this.f$0, this.f$1, this.f$2, singleEmitter);
    }
}
