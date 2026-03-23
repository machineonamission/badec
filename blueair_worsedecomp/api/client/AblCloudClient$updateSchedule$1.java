package com.blueair.api.client;

import com.blueair.core.model.DeviceSchedule;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.AblCloudClient", f = "AblCloudClient.kt", i = {0}, l = {253}, m = "updateSchedule", n = {"schedule"}, s = {"L$0"})
/* compiled from: AblCloudClient.kt */
final class AblCloudClient$updateSchedule$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AblCloudClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AblCloudClient$updateSchedule$1(AblCloudClient ablCloudClient, Continuation<? super AblCloudClient$updateSchedule$1> continuation) {
        super(continuation);
        this.this$0 = ablCloudClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateSchedule((DeviceSchedule) null, this);
    }
}
