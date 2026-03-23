package com.blueair.android.activity;

import androidx.lifecycle.LiveData;
import com.blueair.core.model.Device;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HomeActivity$$ExternalSyntheticLambda5 implements Function1 {
    public final /* synthetic */ LiveData f$0;
    public final /* synthetic */ HomeActivity f$1;
    public final /* synthetic */ Function1 f$2;

    public /* synthetic */ HomeActivity$$ExternalSyntheticLambda5(LiveData liveData, HomeActivity homeActivity, Function1 function1) {
        this.f$0 = liveData;
        this.f$1 = homeActivity;
        this.f$2 = function1;
    }

    public final Object invoke(Object obj) {
        return HomeActivity.onNewIntent$withDevice$lambda$24(this.f$0, this.f$1, this.f$2, (Device) obj);
    }
}
