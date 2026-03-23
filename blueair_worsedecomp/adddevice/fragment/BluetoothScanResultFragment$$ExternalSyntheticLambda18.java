package com.blueair.adddevice.fragment;

import io.reactivex.functions.Predicate;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BluetoothScanResultFragment$$ExternalSyntheticLambda18 implements Predicate {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ BluetoothScanResultFragment$$ExternalSyntheticLambda18(Function1 function1) {
        this.f$0 = function1;
    }

    public final boolean test(Object obj) {
        return BluetoothScanResultFragment.onResume$lambda$14(this.f$0, obj);
    }
}
