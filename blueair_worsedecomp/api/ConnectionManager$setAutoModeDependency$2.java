package com.blueair.api;

import com.blueair.api.client.CanSetAutoModeDependency;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$setAutoModeDependency$2 extends FunctionReferenceImpl implements Function3<CanSetAutoModeDependency, Object, Continuation<? super ApiResult<Object>>, Object>, SuspendFunction {
    public static final ConnectionManager$setAutoModeDependency$2 INSTANCE = new ConnectionManager$setAutoModeDependency$2();

    ConnectionManager$setAutoModeDependency$2() {
        super(3, CanSetAutoModeDependency.class, "setAutoModeDependency", "setAutoModeDependency(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetAutoModeDependency canSetAutoModeDependency, Object obj, Continuation<? super ApiResult<Object>> continuation) {
        return canSetAutoModeDependency.setAutoModeDependency(obj, continuation);
    }
}
