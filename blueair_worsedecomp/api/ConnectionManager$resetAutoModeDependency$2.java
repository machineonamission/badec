package com.blueair.api;

import com.blueair.api.client.CanSetAutoModeDependency;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$resetAutoModeDependency$2 extends FunctionReferenceImpl implements Function2<CanSetAutoModeDependency, Continuation<? super ApiResult<Object>>, Object>, SuspendFunction {
    public static final ConnectionManager$resetAutoModeDependency$2 INSTANCE = new ConnectionManager$resetAutoModeDependency$2();

    ConnectionManager$resetAutoModeDependency$2() {
        super(2, CanSetAutoModeDependency.class, "resetAutoModeDependency", "resetAutoModeDependency(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetAutoModeDependency canSetAutoModeDependency, Continuation<? super ApiResult<Object>> continuation) {
        return canSetAutoModeDependency.resetAutoModeDependency(continuation);
    }
}
