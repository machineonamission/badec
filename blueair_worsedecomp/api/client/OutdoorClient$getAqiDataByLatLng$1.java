package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.OutdoorClient", f = "OutdoorClient.kt", i = {0, 0}, l = {57}, m = "getAqiDataByLatLng", n = {"lat", "lon"}, s = {"D$0", "D$1"})
/* compiled from: OutdoorClient.kt */
final class OutdoorClient$getAqiDataByLatLng$1 extends ContinuationImpl {
    double D$0;
    double D$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OutdoorClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutdoorClient$getAqiDataByLatLng$1(OutdoorClient outdoorClient, Continuation<? super OutdoorClient$getAqiDataByLatLng$1> continuation) {
        super(continuation);
        this.this$0 = outdoorClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAqiDataByLatLng(0.0d, 0.0d, this);
    }
}
