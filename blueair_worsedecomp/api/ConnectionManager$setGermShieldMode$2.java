package com.blueair.api;

import com.blueair.api.client.CanSetGermShieldMode;
import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$setGermShieldMode$2 extends FunctionReferenceImpl implements Function3<CanSetGermShieldMode, Integer, Continuation<? super ApiResult<SimpleResponse>>, Object>, SuspendFunction {
    public static final ConnectionManager$setGermShieldMode$2 INSTANCE = new ConnectionManager$setGermShieldMode$2();

    ConnectionManager$setGermShieldMode$2() {
        super(3, CanSetGermShieldMode.class, "setGermShieldMode", "setGermShieldMode(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetGermShieldMode canSetGermShieldMode, int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return canSetGermShieldMode.setGermShieldMode(i, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CanSetGermShieldMode) obj, ((Number) obj2).intValue(), (Continuation<? super ApiResult<SimpleResponse>>) (Continuation) obj3);
    }
}
