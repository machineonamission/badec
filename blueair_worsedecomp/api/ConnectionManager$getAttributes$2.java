package com.blueair.api;

import com.blueair.api.client.CanGetAttributes;
import com.blueair.api.restapi.DeviceAttributeOnAbl;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$getAttributes$2 extends FunctionReferenceImpl implements Function2<CanGetAttributes, Continuation<? super ApiResult<List<? extends DeviceAttributeOnAbl>>>, Object>, SuspendFunction {
    public static final ConnectionManager$getAttributes$2 INSTANCE = new ConnectionManager$getAttributes$2();

    ConnectionManager$getAttributes$2() {
        super(2, CanGetAttributes.class, "getAttributes", "getAttributes(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanGetAttributes canGetAttributes, Continuation<? super ApiResult<List<DeviceAttributeOnAbl>>> continuation) {
        return canGetAttributes.getAttributes(continuation);
    }
}
