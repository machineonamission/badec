package com.blueair.adddevice.fragment;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BluetoothScanResultFragment$$ExternalSyntheticLambda16 implements Consumer {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ BluetoothScanResultFragment$$ExternalSyntheticLambda16(Function1 function1) {
        this.f$0 = function1;
    }

    public final void accept(Object obj) {
        BluetoothScanResultFragment.onResume$lambda$12(this.f$0, obj);
    }
}
