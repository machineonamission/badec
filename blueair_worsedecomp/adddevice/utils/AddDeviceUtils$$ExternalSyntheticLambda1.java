package com.blueair.adddevice.utils;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AddDeviceUtils$$ExternalSyntheticLambda1 implements Callable {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ AddDeviceUtils$$ExternalSyntheticLambda1(Context context, int i) {
        this.f$0 = context;
        this.f$1 = i;
    }

    public final Object call() {
        return AddDeviceUtils.validateNet$lambda$1(this.f$0, this.f$1);
    }
}
