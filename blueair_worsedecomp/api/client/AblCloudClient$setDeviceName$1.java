package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.AblCloudClient", f = "AblCloudClient.kt", i = {0, 1, 1, 1}, l = {262, 269}, m = "setDeviceName", n = {"nuValue", "nuValue", "oldDataResponse", "oldData"}, s = {"L$0", "L$0", "L$1", "L$2"})
/* compiled from: AblCloudClient.kt */
final class AblCloudClient$setDeviceName$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AblCloudClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AblCloudClient$setDeviceName$1(AblCloudClient ablCloudClient, Continuation<? super AblCloudClient$setDeviceName$1> continuation) {
        super(continuation);
        this.this$0 = ablCloudClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setDeviceName((String) null, this);
    }
}
