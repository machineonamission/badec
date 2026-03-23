package com.blueair.api.client;

import com.blueair.core.model.TrackedLocation;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.OutdoorClient", f = "OutdoorClient.kt", i = {0}, l = {52}, m = "getAqiDataByLocation", n = {"locations"}, s = {"L$0"})
/* compiled from: OutdoorClient.kt */
final class OutdoorClient$getAqiDataByLocation$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OutdoorClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutdoorClient$getAqiDataByLocation$1(OutdoorClient outdoorClient, Continuation<? super OutdoorClient$getAqiDataByLocation$1> continuation) {
        super(continuation);
        this.this$0 = outdoorClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAqiDataByLocation((List<TrackedLocation>) null, this);
    }
}
