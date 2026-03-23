package com.blueair.outdoor.ui.adapters;

import android.view.View;
import com.blueair.core.model.TrackedLocation;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SavedLocationViewHolder$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ TrackedLocation f$1;

    public /* synthetic */ SavedLocationViewHolder$$ExternalSyntheticLambda0(Function1 function1, TrackedLocation trackedLocation) {
        this.f$0 = function1;
        this.f$1 = trackedLocation;
    }

    public final void onClick(View view) {
        SavedLocationViewHolder.bind$lambda$1(this.f$0, this.f$1, view);
    }
}
