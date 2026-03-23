package com.blueair.outdoor.ui.viewmodels;

import com.google.android.gms.tasks.OnFailureListener;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GooglePlacesSearchViewModel$$ExternalSyntheticLambda2 implements OnFailureListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ GooglePlacesSearchViewModel$$ExternalSyntheticLambda2(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onFailure(Exception exc) {
        GooglePlacesSearchViewModel.getPlace$lambda$10(this.f$0, exc);
    }
}
