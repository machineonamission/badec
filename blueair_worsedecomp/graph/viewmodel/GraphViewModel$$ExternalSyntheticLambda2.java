package com.blueair.graph.viewmodel;

import com.blueair.core.util.OutdoorRanges;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GraphViewModel$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ OutdoorRanges f$0;

    public /* synthetic */ GraphViewModel$$ExternalSyntheticLambda2(OutdoorRanges outdoorRanges) {
        this.f$0 = outdoorRanges;
    }

    public final Object invoke(Object obj) {
        return Float.valueOf(GraphViewModel.updateOutdoorRealTime$lambda$6(this.f$0, ((Float) obj).floatValue()));
    }
}
