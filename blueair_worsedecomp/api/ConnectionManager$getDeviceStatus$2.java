package com.blueair.api;

import com.blueair.api.client.CanGetStatus;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$getDeviceStatus$2 extends FunctionReferenceImpl implements Function2<CanGetStatus, Continuation<? super ApiResult<String>>, Object>, SuspendFunction {
    public static final ConnectionManager$getDeviceStatus$2 INSTANCE = new ConnectionManager$getDeviceStatus$2();

    ConnectionManager$getDeviceStatus$2() {
        super(2, CanGetStatus.class, "getDeviceStatus", "getDeviceStatus(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanGetStatus canGetStatus, Continuation<? super ApiResult<String>> continuation) {
        return canGetStatus.getDeviceStatus(continuation);
    }
}
