package com.blueair.api;

import com.blueair.api.client.CanSetHumMode;
import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$setHumMode$2 extends FunctionReferenceImpl implements Function3<CanSetHumMode, Boolean, Continuation<? super ApiResult<SimpleResponse>>, Object>, SuspendFunction {
    public static final ConnectionManager$setHumMode$2 INSTANCE = new ConnectionManager$setHumMode$2();

    ConnectionManager$setHumMode$2() {
        super(3, CanSetHumMode.class, "setHumMode", "setHumMode(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetHumMode canSetHumMode, boolean z, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return canSetHumMode.setHumMode(z, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CanSetHumMode) obj, ((Boolean) obj2).booleanValue(), (Continuation<? super ApiResult<SimpleResponse>>) (Continuation) obj3);
    }
}
