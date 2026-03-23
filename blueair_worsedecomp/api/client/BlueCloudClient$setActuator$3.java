package com.blueair.api.client;

import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.BlueCloudClient", f = "BlueCloudClient.kt", i = {0, 0}, l = {86}, m = "setActuator", n = {"n", "vj"}, s = {"L$0", "L$1"})
/* compiled from: BlueCloudClient.kt */
final class BlueCloudClient$setActuator$3 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BlueCloudClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BlueCloudClient$setActuator$3(BlueCloudClient blueCloudClient, Continuation<? super BlueCloudClient$setActuator$3> continuation) {
        super(continuation);
        this.this$0 = blueCloudClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setActuator((String) null, (Object) null, (Continuation<? super ApiResult<SimpleResponse>>) this);
    }
}
