package com.blueair.api.client;

import com.blueair.api.client.BaseNetworkClient;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.BaseNetworkClient", f = "NetworkClient.kt", i = {0, 0, 0, 0}, l = {146}, m = "doSuspendedApiCall$suspendImpl", n = {"$this", "apiCall", "input1", "input2"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* compiled from: NetworkClient.kt */
final class BaseNetworkClient$doSuspendedApiCall$2<Input1, Input2, Output> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseNetworkClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseNetworkClient$doSuspendedApiCall$2(BaseNetworkClient baseNetworkClient, Continuation<? super BaseNetworkClient$doSuspendedApiCall$2> continuation) {
        super(continuation);
        this.this$0 = baseNetworkClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return BaseNetworkClient.CC.doSuspendedApiCall$suspendImpl(this.this$0, (Function3) null, null, null, this);
    }
}
