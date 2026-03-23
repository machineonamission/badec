package com.blueair.api;

import com.blueair.api.client.CanSetFilterType;
import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$setFilterType$2 extends FunctionReferenceImpl implements Function3<CanSetFilterType, String, Continuation<? super ApiResult<SimpleResponse>>, Object>, SuspendFunction {
    public static final ConnectionManager$setFilterType$2 INSTANCE = new ConnectionManager$setFilterType$2();

    ConnectionManager$setFilterType$2() {
        super(3, CanSetFilterType.class, "setFilterType", "setFilterType(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetFilterType canSetFilterType, String str, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return canSetFilterType.setFilterType(str, continuation);
    }
}
