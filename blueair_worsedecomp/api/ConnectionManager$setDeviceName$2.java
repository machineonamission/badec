package com.blueair.api;

import com.blueair.api.client.CanSetDeviceName;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$setDeviceName$2 extends FunctionReferenceImpl implements Function3<CanSetDeviceName, String, Continuation<? super ApiResult<Object>>, Object>, SuspendFunction {
    public static final ConnectionManager$setDeviceName$2 INSTANCE = new ConnectionManager$setDeviceName$2();

    ConnectionManager$setDeviceName$2() {
        super(3, CanSetDeviceName.class, "setDeviceName", "setDeviceName(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetDeviceName canSetDeviceName, String str, Continuation<? super ApiResult<Object>> continuation) {
        return canSetDeviceName.setDeviceName(str, continuation);
    }
}
