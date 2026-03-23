package com.blueair.api;

import com.blueair.api.client.CanSetSensorMode;
import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$setSensorMode$2 extends FunctionReferenceImpl implements Function3<CanSetSensorMode, Integer, Continuation<? super ApiResult<SimpleResponse>>, Object>, SuspendFunction {
    public static final ConnectionManager$setSensorMode$2 INSTANCE = new ConnectionManager$setSensorMode$2();

    ConnectionManager$setSensorMode$2() {
        super(3, CanSetSensorMode.class, "setSensorMode", "setSensorMode(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetSensorMode canSetSensorMode, int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return canSetSensorMode.setSensorMode(i, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CanSetSensorMode) obj, ((Number) obj2).intValue(), (Continuation<? super ApiResult<SimpleResponse>>) (Continuation) obj3);
    }
}
