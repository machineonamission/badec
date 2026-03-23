package com.blueair.outdoor.ui.activity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MapActivity$$ExternalSyntheticLambda19 implements FragmentResultListener {
    public final /* synthetic */ Fragment f$0;
    public final /* synthetic */ MapActivity f$1;

    public /* synthetic */ MapActivity$$ExternalSyntheticLambda19(Fragment fragment, MapActivity mapActivity) {
        this.f$0 = fragment;
        this.f$1 = mapActivity;
    }

    public final void onFragmentResult(String str, Bundle bundle) {
        MapActivity.onAttachFragment$lambda$29(this.f$0, this.f$1, str, bundle);
    }
}
