package com.blueair.outdoor.ui.viewmodels;

import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GooglePlacesSearchViewModel$$ExternalSyntheticLambda1 implements OnSuccessListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ GooglePlacesSearchViewModel$$ExternalSyntheticLambda1(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onSuccess(Object obj) {
        GooglePlacesSearchViewModel.getPlace$lambda$9(this.f$0, obj);
    }
}
