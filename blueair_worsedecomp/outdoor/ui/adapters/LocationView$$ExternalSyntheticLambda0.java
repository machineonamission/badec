package com.blueair.outdoor.ui.adapters;

import android.view.View;
import com.blueair.outdoor.ui.adapters.LocationView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LocationView$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ LocationView f$0;
    public final /* synthetic */ LocationItem f$1;
    public final /* synthetic */ LocationView.TYPE f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ boolean f$4;
    public final /* synthetic */ boolean f$5;
    public final /* synthetic */ Function2 f$6;
    public final /* synthetic */ Function1 f$7;
    public final /* synthetic */ Function3 f$8;

    public /* synthetic */ LocationView$$ExternalSyntheticLambda0(LocationView locationView, LocationItem locationItem, LocationView.TYPE type, String str, boolean z, boolean z2, Function2 function2, Function1 function1, Function3 function3) {
        this.f$0 = locationView;
        this.f$1 = locationItem;
        this.f$2 = type;
        this.f$3 = str;
        this.f$4 = z;
        this.f$5 = z2;
        this.f$6 = function2;
        this.f$7 = function1;
        this.f$8 = function3;
    }

    public final void onClick(View view) {
        LocationView.bind$lambda$4(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, view);
    }
}
