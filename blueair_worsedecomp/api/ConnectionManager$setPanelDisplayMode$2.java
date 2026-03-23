package com.blueair.api;

import com.blueair.api.client.CanSetPanelDisplayMode;
import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
final /* synthetic */ class ConnectionManager$setPanelDisplayMode$2 extends FunctionReferenceImpl implements Function3<CanSetPanelDisplayMode, Integer, Continuation<? super ApiResult<SimpleResponse>>, Object>, SuspendFunction {
    public static final ConnectionManager$setPanelDisplayMode$2 INSTANCE = new ConnectionManager$setPanelDisplayMode$2();

    ConnectionManager$setPanelDisplayMode$2() {
        super(3, CanSetPanelDisplayMode.class, "setPanelDisplayMode", "setPanelDisplayMode(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(CanSetPanelDisplayMode canSetPanelDisplayMode, int i, Continuation<? super ApiResult<SimpleResponse>> continuation) {
        return canSetPanelDisplayMode.setPanelDisplayMode(i, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CanSetPanelDisplayMode) obj, ((Number) obj2).intValue(), (Continuation<? super ApiResult<SimpleResponse>>) (Continuation) obj3);
    }
}
