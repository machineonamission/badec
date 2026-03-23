package com.blueair.api;

import com.blueair.api.client.CanSetOscillation;
import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$setOscillationState$2 extends FunctionReferenceImpl implements Function3<CanSetOscillation, Integer, Continuation<? super ApiResult<SimpleResponse>>, Object>, SuspendFunction {
    public static final ConnectionManager$setOscillationState$2 INSTANCE = new ConnectionManager$setOscillationState$2();

    ConnectionManager$setOscillationState$2() {
        super(3, CanSetOscillation.class, "setOscillationState", "setOscillationState(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetOscillation canSetOscillation, int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return canSetOscillation.setOscillationState(i, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CanSetOscillation) obj, ((Number) obj2).intValue(), (Continuation<? super ApiResult<SimpleResponse>>) (Continuation) obj3);
    }
}
