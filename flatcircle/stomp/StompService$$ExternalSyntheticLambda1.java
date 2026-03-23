package io.flatcircle.stomp;

import io.reactivex.functions.Predicate;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class StompService$$ExternalSyntheticLambda1 implements Predicate {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ StompService$$ExternalSyntheticLambda1(Function1 function1) {
        this.f$0 = function1;
    }

    public final boolean test(Object obj) {
        return StompService._init_$lambda$1(this.f$0, obj);
    }
}
