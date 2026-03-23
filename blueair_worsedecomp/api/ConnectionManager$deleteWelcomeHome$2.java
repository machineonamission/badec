package com.blueair.api;

import com.blueair.api.client.CanManageWelcomeHome;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$deleteWelcomeHome$2 extends FunctionReferenceImpl implements Function2<CanManageWelcomeHome, Continuation<? super ApiResult<Unit>>, Object>, SuspendFunction {
    public static final ConnectionManager$deleteWelcomeHome$2 INSTANCE = new ConnectionManager$deleteWelcomeHome$2();

    ConnectionManager$deleteWelcomeHome$2() {
        super(2, CanManageWelcomeHome.class, "deleteWelcomeHome", "deleteWelcomeHome(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanManageWelcomeHome canManageWelcomeHome, Continuation<? super ApiResult<Unit>> continuation) {
        return canManageWelcomeHome.deleteWelcomeHome(continuation);
    }
}
