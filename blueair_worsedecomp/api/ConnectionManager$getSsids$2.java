package com.blueair.api;

import com.blueair.api.client.CanProvisionLocal;
import com.blueair.core.model.Ssid;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$getSsids$2 extends FunctionReferenceImpl implements Function2<CanProvisionLocal, Continuation<? super ApiResult<List<? extends Ssid>>>, Object>, SuspendFunction {
    public static final ConnectionManager$getSsids$2 INSTANCE = new ConnectionManager$getSsids$2();

    ConnectionManager$getSsids$2() {
        super(2, CanProvisionLocal.class, "getSsids", "getSsids(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanProvisionLocal canProvisionLocal, Continuation<? super ApiResult<List<Ssid>>> continuation) {
        return canProvisionLocal.getSsids(continuation);
    }
}
