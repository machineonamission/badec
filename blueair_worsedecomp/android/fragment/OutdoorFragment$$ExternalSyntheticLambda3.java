package com.blueair.android.fragment;

import androidx.lifecycle.Observer;
import com.blueair.core.model.AqiData;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OutdoorFragment$$ExternalSyntheticLambda3 implements Observer {
    public final /* synthetic */ OutdoorFragment f$0;

    public /* synthetic */ OutdoorFragment$$ExternalSyntheticLambda3(OutdoorFragment outdoorFragment) {
        this.f$0 = outdoorFragment;
    }

    public final void onChanged(Object obj) {
        OutdoorFragment.aqiDataObserver_delegate$lambda$7$lambda$6(this.f$0, (AqiData) obj);
    }
}
