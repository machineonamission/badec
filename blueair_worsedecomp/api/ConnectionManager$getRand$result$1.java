package com.blueair.api;

import com.blueair.api.client.CanProvisionCloud;
import com.blueair.api.client.RandomVerifyText;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$getRand$result$1 extends FunctionReferenceImpl implements Function2<CanProvisionCloud, Continuation<? super ApiResult<RandomVerifyText>>, Object>, SuspendFunction {
    public static final ConnectionManager$getRand$result$1 INSTANCE = new ConnectionManager$getRand$result$1();

    ConnectionManager$getRand$result$1() {
        super(2, CanProvisionCloud.class, "getRandomVerifyText", "getRandomVerifyText(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanProvisionCloud canProvisionCloud, Continuation<? super ApiResult<RandomVerifyText>> continuation) {
        return canProvisionCloud.getRandomVerifyText(continuation);
    }
}
