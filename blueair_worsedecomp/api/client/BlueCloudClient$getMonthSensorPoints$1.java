package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.BlueCloudClient", f = "BlueCloudClient.kt", i = {0, 0, 0, 0, 0}, l = {223}, m = "getMonthSensorPoints", n = {"sensors", "params", "fromTime", "now", "monthAgo"}, s = {"L$0", "L$1", "J$0", "J$1", "J$2"})
/* compiled from: BlueCloudClient.kt */
final class BlueCloudClient$getMonthSensorPoints$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BlueCloudClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BlueCloudClient$getMonthSensorPoints$1(BlueCloudClient blueCloudClient, Continuation<? super BlueCloudClient$getMonthSensorPoints$1> continuation) {
        super(continuation);
        this.this$0 = blueCloudClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getMonthSensorPoints(0, this);
    }
}
