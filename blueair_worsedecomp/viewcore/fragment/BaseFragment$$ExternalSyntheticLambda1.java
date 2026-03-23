package com.blueair.viewcore.fragment;

import com.blueair.viewcore.viewmodel.BaseViewModelEvent;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BaseFragment$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ BaseFragment f$0;

    public /* synthetic */ BaseFragment$$ExternalSyntheticLambda1(BaseFragment baseFragment) {
        this.f$0 = baseFragment;
    }

    public final Object invoke(Object obj) {
        return BaseFragment.onResume$lambda$5(this.f$0, (BaseViewModelEvent) obj);
    }
}
