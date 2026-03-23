package com.blueair.antifake.viewmodel;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AntiFakeViewModel$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ AntiFakeViewModel$$ExternalSyntheticLambda1(Function1 function1) {
        this.f$0 = function1;
    }

    public final void accept(Object obj) {
        AntiFakeViewModel.connectBluetoothAndResetFilter$lambda$3(this.f$0, obj);
    }
}
