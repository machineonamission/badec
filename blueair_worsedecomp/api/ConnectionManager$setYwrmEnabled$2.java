package com.blueair.api;

import com.blueair.api.client.CanSetYellowWaterRemove;
import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$setYwrmEnabled$2 extends FunctionReferenceImpl implements Function3<CanSetYellowWaterRemove, Boolean, Continuation<? super ApiResult<SimpleResponse>>, Object>, SuspendFunction {
    public static final ConnectionManager$setYwrmEnabled$2 INSTANCE = new ConnectionManager$setYwrmEnabled$2();

    ConnectionManager$setYwrmEnabled$2() {
        super(3, CanSetYellowWaterRemove.class, "setYwrmEnabled", "setYwrmEnabled(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetYellowWaterRemove canSetYellowWaterRemove, boolean z, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return canSetYellowWaterRemove.setYwrmEnabled(z, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CanSetYellowWaterRemove) obj, ((Boolean) obj2).booleanValue(), (Continuation<? super ApiResult<SimpleResponse>>) (Continuation) obj3);
    }
}
