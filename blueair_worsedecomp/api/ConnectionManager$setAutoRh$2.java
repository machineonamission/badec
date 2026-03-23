package com.blueair.api;

import com.blueair.api.client.CanSetAutoRh;
import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$setAutoRh$2 extends FunctionReferenceImpl implements Function3<CanSetAutoRh, Integer, Continuation<? super ApiResult<SimpleResponse>>, Object>, SuspendFunction {
    public static final ConnectionManager$setAutoRh$2 INSTANCE = new ConnectionManager$setAutoRh$2();

    ConnectionManager$setAutoRh$2() {
        super(3, CanSetAutoRh.class, "setAutoRh", "setAutoRh(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetAutoRh canSetAutoRh, int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return canSetAutoRh.setAutoRh(i, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CanSetAutoRh) obj, ((Number) obj2).intValue(), (Continuation<? super ApiResult<SimpleResponse>>) (Continuation) obj3);
    }
}
