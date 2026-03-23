package com.blueair.api;

import com.blueair.api.client.CanSetG4NightMode;
import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$setG4NightMode$2 extends FunctionReferenceImpl implements Function3<CanSetG4NightMode, Integer, Continuation<? super ApiResult<SimpleResponse>>, Object>, SuspendFunction {
    public static final ConnectionManager$setG4NightMode$2 INSTANCE = new ConnectionManager$setG4NightMode$2();

    ConnectionManager$setG4NightMode$2() {
        super(3, CanSetG4NightMode.class, "setG4NightMode", "setG4NightMode(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetG4NightMode canSetG4NightMode, int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return canSetG4NightMode.setG4NightMode(i, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CanSetG4NightMode) obj, ((Number) obj2).intValue(), (Continuation<? super ApiResult<SimpleResponse>>) (Continuation) obj3);
    }
}
