package com.blueair.devicemanager;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class IcpDeviceManager$$ExternalSyntheticLambda0 implements SingleOnSubscribe {
    public final /* synthetic */ IcpDeviceManager f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ IcpDeviceManager$$ExternalSyntheticLambda0(IcpDeviceManager icpDeviceManager, long j, long j2) {
        this.f$0 = icpDeviceManager;
        this.f$1 = j;
        this.f$2 = j2;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        IcpDeviceManager.scan$lambda$3(this.f$0, this.f$1, this.f$2, singleEmitter);
    }
}
