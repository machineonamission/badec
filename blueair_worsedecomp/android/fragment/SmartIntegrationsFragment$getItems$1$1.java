package com.blueair.android.fragment;

import com.blueair.android.fragment.integration.IntegrationItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: SmartIntegrationsFragment.kt */
final /* synthetic */ class SmartIntegrationsFragment$getItems$1$1 extends FunctionReferenceImpl implements Function1<IntegrationItem, Unit> {
    SmartIntegrationsFragment$getItems$1$1(Object obj) {
        super(1, obj, SmartIntegrationsFragment.class, "onItemClick", "onItemClick(Lcom/blueair/android/fragment/integration/IntegrationItem;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IntegrationItem) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(IntegrationItem integrationItem) {
        Intrinsics.checkNotNullParameter(integrationItem, "p0");
        ((SmartIntegrationsFragment) this.receiver).onItemClick(integrationItem);
    }
}
