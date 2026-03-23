package com.blueair.api;

import com.blueair.api.client.CanSetTimer;
import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$setTimerStatus$2 extends FunctionReferenceImpl implements Function3<CanSetTimer, Integer, Continuation<? super ApiResult<SimpleResponse>>, Object>, SuspendFunction {
    public static final ConnectionManager$setTimerStatus$2 INSTANCE = new ConnectionManager$setTimerStatus$2();

    ConnectionManager$setTimerStatus$2() {
        super(3, CanSetTimer.class, "setTimerStatus", "setTimerStatus(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetTimer canSetTimer, int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return canSetTimer.setTimerStatus(i, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CanSetTimer) obj, ((Number) obj2).intValue(), (Continuation<? super ApiResult<SimpleResponse>>) (Continuation) obj3);
    }
}
