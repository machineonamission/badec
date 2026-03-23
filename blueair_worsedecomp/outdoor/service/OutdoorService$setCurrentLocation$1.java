package com.blueair.outdoor.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.outdoor.service.OutdoorService", f = "OutdoorService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {68, 70, 71}, m = "setCurrentLocation", n = {"oldCurrentLocation", "location", "lat", "lon", "oldCurrentLocation", "location", "it", "lat", "lon", "$i$a$-let-OutdoorService$setCurrentLocation$2", "oldCurrentLocation", "location", "it", "lat", "lon", "$i$a$-let-OutdoorService$setCurrentLocation$2"}, s = {"L$0", "L$1", "D$0", "D$1", "L$0", "L$1", "L$2", "D$0", "D$1", "I$0", "L$0", "L$1", "L$2", "D$0", "D$1", "I$0"})
/* compiled from: OutdoorService.kt */
final class OutdoorService$setCurrentLocation$1 extends ContinuationImpl {
    double D$0;
    double D$1;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OutdoorService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutdoorService$setCurrentLocation$1(OutdoorService outdoorService, Continuation<? super OutdoorService$setCurrentLocation$1> continuation) {
        super(continuation);
        this.this$0 = outdoorService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setCurrentLocation(0.0d, 0.0d, this);
    }
}
