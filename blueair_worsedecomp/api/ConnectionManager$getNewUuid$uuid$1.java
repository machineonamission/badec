package com.blueair.api;

import com.blueair.api.client.CanProvisionLocal;
import com.blueair.core.model.DeviceUuid;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$getNewUuid$uuid$1 extends FunctionReferenceImpl implements Function2<CanProvisionLocal, Continuation<? super ApiResult<DeviceUuid>>, Object>, SuspendFunction {
    public static final ConnectionManager$getNewUuid$uuid$1 INSTANCE = new ConnectionManager$getNewUuid$uuid$1();

    ConnectionManager$getNewUuid$uuid$1() {
        super(2, CanProvisionLocal.class, "getUuid", "getUuid(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanProvisionLocal canProvisionLocal, Continuation<? super ApiResult<DeviceUuid>> continuation) {
        return canProvisionLocal.getUuid(continuation);
    }
}
