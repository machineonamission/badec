package com.blueair.android.activity;

import com.blueair.core.model.Device;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HomeActivity$$ExternalSyntheticLambda18 implements Function1 {
    public final /* synthetic */ HomeActivity f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ HomeActivity$$ExternalSyntheticLambda18(HomeActivity homeActivity, String str) {
        this.f$0 = homeActivity;
        this.f$1 = str;
    }

    public final Object invoke(Object obj) {
        return HomeActivity.onNewIntent$lambda$26$lambda$25(this.f$0, this.f$1, (Device) obj);
    }
}
