package io.flatcircle.ble;

import com.airboxlab.icp.sdk.IcpDevice;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleIcpController$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ BleIcpController f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ BleIcpController$$ExternalSyntheticLambda2(BleIcpController bleIcpController, String str) {
        this.f$0 = bleIcpController;
        this.f$1 = str;
    }

    public final Object invoke(Object obj) {
        return BleIcpController.connect$lambda$12(this.f$0, this.f$1, (IcpDevice[]) obj);
    }
}
