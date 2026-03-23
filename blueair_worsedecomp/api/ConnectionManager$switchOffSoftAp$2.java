package com.blueair.api;

import com.blueair.api.client.CanProvisionLocal;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$switchOffSoftAp$2 extends FunctionReferenceImpl implements Function2<CanProvisionLocal, Continuation<? super ApiResult<Object>>, Object>, SuspendFunction {
    public static final ConnectionManager$switchOffSoftAp$2 INSTANCE = new ConnectionManager$switchOffSoftAp$2();

    ConnectionManager$switchOffSoftAp$2() {
        super(2, CanProvisionLocal.class, "switchOffSoftAp", "switchOffSoftAp(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanProvisionLocal canProvisionLocal, Continuation<? super ApiResult<Object>> continuation) {
        return canProvisionLocal.switchOffSoftAp(continuation);
    }
}
