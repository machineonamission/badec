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
final /* synthetic */ class ConnectionManager$setHeatEcoTmp$2 extends FunctionReferenceImpl implements Function3<CanSetMainMode, Double, Continuation<? super ApiResult<SimpleResponse>>, Object>, SuspendFunction {
    public static final ConnectionManager$setHeatEcoTmp$2 INSTANCE = new ConnectionManager$setHeatEcoTmp$2();

    ConnectionManager$setHeatEcoTmp$2() {
        super(3, CanSetMainMode.class, "setHeatEcoTmp", "setHeatEcoTmp(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetMainMode canSetMainMode, double d, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return canSetMainMode.setHeatEcoTmp(d, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CanSetMainMode) obj, ((Number) obj2).doubleValue(), (Continuation<? super ApiResult<SimpleResponse>>) (Continuation) obj3);
    }
}
