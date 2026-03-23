package com.blueair.api;

import com.blueair.api.client.CanSetAlarm;
import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$stopAlarm$2 extends FunctionReferenceImpl implements Function2<CanSetAlarm, Continuation<? super ApiResult<SimpleResponse>>, Object>, SuspendFunction {
    public static final ConnectionManager$stopAlarm$2 INSTANCE = new ConnectionManager$stopAlarm$2();

    ConnectionManager$stopAlarm$2() {
        super(2, CanSetAlarm.class, "stopAlarm", "stopAlarm(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetAlarm canSetAlarm, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return canSetAlarm.stopAlarm(continuation);
    }
}
