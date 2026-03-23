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
final /* synthetic */ class ConnectionManager$setGermShieldNightMode$2 extends FunctionReferenceImpl implements Function3<CanSetGermShieldMode, Boolean, Continuation<? super ApiResult<SimpleResponse>>, Object>, SuspendFunction {
    public static final ConnectionManager$setGermShieldNightMode$2 INSTANCE = new ConnectionManager$setGermShieldNightMode$2();

    ConnectionManager$setGermShieldNightMode$2() {
        super(3, CanSetGermShieldMode.class, "setGermShieldNightMode", "setGermShieldNightMode(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetGermShieldMode canSetGermShieldMode, boolean z, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return canSetGermShieldMode.setGermShieldNightMode(z, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CanSetGermShieldMode) obj, ((Boolean) obj2).booleanValue(), (Continuation<? super ApiResult<SimpleResponse>>) (Continuation) obj3);
    }
}
