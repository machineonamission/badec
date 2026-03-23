package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.AblCloudClient", f = "AblCloudClient.kt", i = {0}, l = {177}, m = "setChildLock", n = {"isLocked"}, s = {"I$0"})
/* compiled from: AblCloudClient.kt */
final class AblCloudClient$setChildLock$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AblCloudClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AblCloudClient$setChildLock$1(AblCloudClient ablCloudClient, Continuation<? super AblCloudClient$setChildLock$1> continuation) {
        super(continuation);
        this.this$0 = ablCloudClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setChildLock(0, this);
    }
}
