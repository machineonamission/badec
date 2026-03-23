package com.blueair.android.fragment;

import android.view.View;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;
import kotlin.jvm.functions.Function4;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OutdoorFragment$$ExternalSyntheticLambda8 implements Function4 {
    public final /* synthetic */ OutdoorFragment f$0;

    public /* synthetic */ OutdoorFragment$$ExternalSyntheticLambda8(OutdoorFragment outdoorFragment) {
        this.f$0 = outdoorFragment;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return Boolean.valueOf(OutdoorFragment.setupRecyclerView$lambda$12(this.f$0, (View) obj, (IAdapter) obj2, (AbstractBindingItem) obj3, ((Integer) obj4).intValue()));
    }
}
