package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.AblCloudClient", f = "AblCloudClient.kt", i = {0, 0, 0, 0, 0}, l = {72}, m = "getMonthSensorPoints", n = {"dateFormat", "calendar", "now", "monthAgo", "fromTime"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0"})
/* compiled from: AblCloudClient.kt */
final class AblCloudClient$getMonthSensorPoints$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AblCloudClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AblCloudClient$getMonthSensorPoints$1(AblCloudClient ablCloudClient, Continuation<? super AblCloudClient$getMonthSensorPoints$1> continuation) {
        super(continuation);
        this.this$0 = ablCloudClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getMonthSensorPoints(0, this);
    }
}
