package com.blueair.api;

import com.blueair.api.client.CanSetHinsMode;
import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$setHinsNightMode$2 extends FunctionReferenceImpl implements Function3<CanSetHinsMode, Boolean, Continuation<? super ApiResult<SimpleResponse>>, Object>, SuspendFunction {
    public static final ConnectionManager$setHinsNightMode$2 INSTANCE = new ConnectionManager$setHinsNightMode$2();

    ConnectionManager$setHinsNightMode$2() {
        super(3, CanSetHinsMode.class, "setHinsNightMode", "setHinsNightMode(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetHinsMode canSetHinsMode, boolean z, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return canSetHinsMode.setHinsNightMode(z, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CanSetHinsMode) obj, ((Boolean) obj2).booleanValue(), (Continuation<? super ApiResult<SimpleResponse>>) (Continuation) obj3);
    }
}
