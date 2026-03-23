package com.blueair.graph.view;

import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GraphView$$ExternalSyntheticLambda3 implements Function {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ GraphView$$ExternalSyntheticLambda3(Function1 function1) {
        this.f$0 = function1;
    }

    public final Object apply(Object obj) {
        return GraphView.liveSelectedDataPoint$lambda$3(this.f$0, obj);
    }
}
