package com.blueair.android.fragment;

import android.view.View;
import com.blueair.android.fragment.integration.IntegrationItem;
import com.mikepenz.fastadapter.IAdapter;
import kotlin.jvm.functions.Function4;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SmartIntegrationsFragment$$ExternalSyntheticLambda2 implements Function4 {
    public final /* synthetic */ SmartIntegrationsFragment f$0;

    public /* synthetic */ SmartIntegrationsFragment$$ExternalSyntheticLambda2(SmartIntegrationsFragment smartIntegrationsFragment) {
        this.f$0 = smartIntegrationsFragment;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return Boolean.valueOf(SmartIntegrationsFragment.onCreateView$lambda$2(this.f$0, (View) obj, (IAdapter) obj2, (IntegrationItem) obj3, ((Integer) obj4).intValue()));
    }
}
