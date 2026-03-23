package com.blueair.outdoor.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.outdoor.service.OutdoorService", f = "OutdoorService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {132, 140}, m = "fetchTrackedLocationWithAqiData", n = {"mapType", "location", "lat", "lng", "mapType", "location", "lat", "lng"}, s = {"L$0", "L$1", "D$0", "D$1", "L$0", "L$1", "D$0", "D$1"})
/* compiled from: OutdoorService.kt */
final class OutdoorService$fetchTrackedLocationWithAqiData$1 extends ContinuationImpl {
    double D$0;
    double D$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OutdoorService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutdoorService$fetchTrackedLocationWithAqiData$1(OutdoorService outdoorService, Continuation<? super OutdoorService$fetchTrackedLocationWithAqiData$1> continuation) {
        super(continuation);
        this.this$0 = outdoorService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchTrackedLocationWithAqiData(0.0d, 0.0d, (String) null, this);
    }
}
