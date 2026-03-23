package com.blueair.api;

import com.blueair.api.client.CanProvisionLocal;
import com.blueair.api.client.ProvisionBody;
import com.blueair.api.model.ProvisionRequestBody;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$provisionDevice$2 extends FunctionReferenceImpl implements Function3<CanProvisionLocal, ProvisionBody, Continuation<? super ApiResult<ProvisionRequestBody>>, Object>, SuspendFunction {
    public static final ConnectionManager$provisionDevice$2 INSTANCE = new ConnectionManager$provisionDevice$2();

    ConnectionManager$provisionDevice$2() {
        super(3, CanProvisionLocal.class, "provisionDevice", "provisionDevice(Lcom/blueair/api/client/ProvisionBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanProvisionLocal canProvisionLocal, ProvisionBody provisionBody, Continuation<? super ApiResult<ProvisionRequestBody>> continuation) {
        return canProvisionLocal.provisionDevice(provisionBody, continuation);
    }
}
