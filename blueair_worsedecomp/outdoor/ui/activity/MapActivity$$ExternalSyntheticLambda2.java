package com.blueair.outdoor.ui.activity;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MapActivity$$ExternalSyntheticLambda2 implements Consumer {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ MapActivity$$ExternalSyntheticLambda2(Function1 function1) {
        this.f$0 = function1;
    }

    public final void accept(Object obj) {
        MapActivity.configureAddLocationRxListeners$lambda$23(this.f$0, obj);
    }
}
