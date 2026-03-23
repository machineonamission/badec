package com.blueair.outdoor.service;

import com.blueair.core.model.TrackedLocation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.outdoor.service.OutdoorService", f = "OutdoorService.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {175, 176, 178}, m = "fetchAqiData", n = {"location", "forceFetch", "location", "aqiData", "forceFetch", "location", "forceFetch"}, s = {"L$0", "Z$0", "L$0", "L$1", "Z$0", "L$0", "Z$0"})
/* compiled from: OutdoorService.kt */
final class OutdoorService$fetchAqiData$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OutdoorService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutdoorService$fetchAqiData$2(OutdoorService outdoorService, Continuation<? super OutdoorService$fetchAqiData$2> continuation) {
        super(continuation);
        this.this$0 = outdoorService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchAqiData((TrackedLocation) null, false, this);
    }
}
