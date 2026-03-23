package com.blueair.android.fragment;

import com.mikepenz.fastadapter.adapters.ItemAdapter;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OutdoorFragment$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ ItemAdapter f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ OutdoorFragment$$ExternalSyntheticLambda5(int i, ItemAdapter itemAdapter, String str) {
        this.f$0 = i;
        this.f$1 = itemAdapter;
        this.f$2 = str;
    }

    public final void run() {
        OutdoorFragment.notifyLocationItemChange$lambda$22(this.f$0, this.f$1, this.f$2);
    }
}
