package com.blueair.outdoor.ui.adapters;

import android.view.View;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LocationView$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ LocationItem f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Function3 f$2;
    public final /* synthetic */ Function2 f$3;
    public final /* synthetic */ LocationView f$4;

    public /* synthetic */ LocationView$$ExternalSyntheticLambda2(LocationItem locationItem, boolean z, Function3 function3, Function2 function2, LocationView locationView) {
        this.f$0 = locationItem;
        this.f$1 = z;
        this.f$2 = function3;
        this.f$3 = function2;
        this.f$4 = locationView;
    }

    public final void onClick(View view) {
        LocationView.bind$lambda$7(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, view);
    }
}
