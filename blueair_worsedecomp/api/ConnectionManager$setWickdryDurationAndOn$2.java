package com.blueair.api;

import com.blueair.api.client.CanSetWick;
import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$setWickdryDurationAndOn$2 extends FunctionReferenceImpl implements Function3<CanSetWick, Integer, Continuation<? super ApiResult<SimpleResponse>>, Object>, SuspendFunction {
    public static final ConnectionManager$setWickdryDurationAndOn$2 INSTANCE = new ConnectionManager$setWickdryDurationAndOn$2();

    ConnectionManager$setWickdryDurationAndOn$2() {
        super(3, CanSetWick.class, "setWickDryDurationAndOn", "setWickDryDurationAndOn(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetWick canSetWick, int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return canSetWick.setWickDryDurationAndOn(i, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CanSetWick) obj, ((Number) obj2).intValue(), (Continuation<? super ApiResult<SimpleResponse>>) (Continuation) obj3);
    }
}
