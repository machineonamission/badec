package com.blueair.api;

import com.blueair.api.client.CanGetAttributes;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$getIsUpdating$2 extends FunctionReferenceImpl implements Function2<CanGetAttributes, Continuation<? super ApiResult<Boolean>>, Object>, SuspendFunction {
    public static final ConnectionManager$getIsUpdating$2 INSTANCE = new ConnectionManager$getIsUpdating$2();

    ConnectionManager$getIsUpdating$2() {
        super(2, CanGetAttributes.class, "getIsUpdating", "getIsUpdating(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanGetAttributes canGetAttributes, Continuation<? super ApiResult<Boolean>> continuation) {
        return canGetAttributes.getIsUpdating(continuation);
    }
}
