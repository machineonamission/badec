package com.blueair.api;

import com.blueair.api.client.CanSetMainMode;
import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$setCoolFanSpeed$2 extends FunctionReferenceImpl implements Function3<CanSetMainMode, Integer, Continuation<? super ApiResult<SimpleResponse>>, Object>, SuspendFunction {
    public static final ConnectionManager$setCoolFanSpeed$2 INSTANCE = new ConnectionManager$setCoolFanSpeed$2();

    ConnectionManager$setCoolFanSpeed$2() {
        super(3, CanSetMainMode.class, "setCoolFanSpeed", "setCoolFanSpeed(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetMainMode canSetMainMode, int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return canSetMainMode.setCoolFanSpeed(i, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CanSetMainMode) obj, ((Number) obj2).intValue(), (Continuation<? super ApiResult<SimpleResponse>>) (Continuation) obj3);
    }
}
