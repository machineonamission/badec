package com.blueair.android.fragment;

import java.util.TimeZone;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class IndoorFragment$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ IndoorFragment f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ TimeZone f$2;

    public /* synthetic */ IndoorFragment$$ExternalSyntheticLambda3(IndoorFragment indoorFragment, boolean z, TimeZone timeZone) {
        this.f$0 = indoorFragment;
        this.f$1 = z;
        this.f$2 = timeZone;
    }

    public final Object invoke(Object obj) {
        return IndoorFragment.showDstPrompt$lambda$28$lambda$25(this.f$0, this.f$1, this.f$2, ((Boolean) obj).booleanValue());
    }
}
