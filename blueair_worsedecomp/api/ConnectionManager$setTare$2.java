package com.blueair.api;

import com.blueair.api.client.CanSetTare;
import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$setTare$2 extends FunctionReferenceImpl implements Function2<CanSetTare, Continuation<? super ApiResult<SimpleResponse>>, Object>, SuspendFunction {
    public static final ConnectionManager$setTare$2 INSTANCE = new ConnectionManager$setTare$2();

    ConnectionManager$setTare$2() {
        super(2, CanSetTare.class, "setTare", "setTare(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetTare canSetTare, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return canSetTare.setTare(continuation);
    }
}
