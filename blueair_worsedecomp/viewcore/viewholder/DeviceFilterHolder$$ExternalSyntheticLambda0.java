package com.blueair.viewcore.viewholder;

import android.view.View;
import com.blueair.core.model.FilterInfo;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceFilterHolder$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ FilterInfo f$1;

    public /* synthetic */ DeviceFilterHolder$$ExternalSyntheticLambda0(Function1 function1, FilterInfo filterInfo) {
        this.f$0 = function1;
        this.f$1 = filterInfo;
    }

    public final void onClick(View view) {
        DeviceFilterHolder.update$lambda$1$lambda$0(this.f$0, this.f$1, view);
    }
}
