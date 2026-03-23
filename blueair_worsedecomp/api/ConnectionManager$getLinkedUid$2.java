package com.blueair.api;

import com.blueair.api.client.CanLinkWithAware;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$getLinkedUid$2 extends FunctionReferenceImpl implements Function2<CanLinkWithAware, Continuation<? super ApiResult<List<? extends String>>>, Object>, SuspendFunction {
    public static final ConnectionManager$getLinkedUid$2 INSTANCE = new ConnectionManager$getLinkedUid$2();

    ConnectionManager$getLinkedUid$2() {
        super(2, CanLinkWithAware.class, "getLink", "getLink(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanLinkWithAware canLinkWithAware, Continuation<? super ApiResult<List<String>>> continuation) {
        return canLinkWithAware.getLink(continuation);
    }
}
