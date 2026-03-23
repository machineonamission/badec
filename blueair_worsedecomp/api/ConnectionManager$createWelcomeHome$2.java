package com.blueair.api;

import com.blueair.api.client.CanManageWelcomeHome;
import com.blueair.core.model.WelcomeHomeLocation;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$createWelcomeHome$2 extends FunctionReferenceImpl implements Function3<CanManageWelcomeHome, WelcomeHomeLocation, Continuation<? super ApiResult<Unit>>, Object>, SuspendFunction {
    public static final ConnectionManager$createWelcomeHome$2 INSTANCE = new ConnectionManager$createWelcomeHome$2();

    ConnectionManager$createWelcomeHome$2() {
        super(3, CanManageWelcomeHome.class, "createUpdateWelcomeHome", "createUpdateWelcomeHome(Lcom/blueair/core/model/WelcomeHomeLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanManageWelcomeHome canManageWelcomeHome, WelcomeHomeLocation welcomeHomeLocation, Continuation<? super ApiResult<Unit>> continuation) {
        return canManageWelcomeHome.createUpdateWelcomeHome(welcomeHomeLocation, continuation);
    }
}
