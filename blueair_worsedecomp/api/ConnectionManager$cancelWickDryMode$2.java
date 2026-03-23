package com.blueair.api;

import com.blueair.api.client.CanSetWick;
import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$cancelWickDryMode$2 extends FunctionReferenceImpl implements Function2<CanSetWick, Continuation<? super ApiResult<SimpleResponse>>, Object>, SuspendFunction {
    public static final ConnectionManager$cancelWickDryMode$2 INSTANCE = new ConnectionManager$cancelWickDryMode$2();

    ConnectionManager$cancelWickDryMode$2() {
        super(2, CanSetWick.class, "cancelWickDryMode", "cancelWickDryMode(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetWick canSetWick, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return canSetWick.cancelWickDryMode(continuation);
    }
}
