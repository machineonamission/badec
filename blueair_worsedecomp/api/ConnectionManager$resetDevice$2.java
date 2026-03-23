package com.blueair.api;

import com.blueair.api.client.CanProvisionLocal;
import com.blueair.core.model.DeviceUuid;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$resetDevice$2 extends FunctionReferenceImpl implements Function3<CanProvisionLocal, DeviceUuid, Continuation<? super ApiResult<String>>, Object>, SuspendFunction {
    public static final ConnectionManager$resetDevice$2 INSTANCE = new ConnectionManager$resetDevice$2();

    ConnectionManager$resetDevice$2() {
        super(3, CanProvisionLocal.class, "resetDevice", "resetDevice(Lcom/blueair/core/model/DeviceUuid;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanProvisionLocal canProvisionLocal, DeviceUuid deviceUuid, Continuation<? super ApiResult<String>> continuation) {
        return canProvisionLocal.resetDevice(deviceUuid, continuation);
    }
}
