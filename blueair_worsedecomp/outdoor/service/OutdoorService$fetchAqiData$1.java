package com.blueair.outdoor.service;

import com.blueair.core.model.TrackedLocation;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.outdoor.service.OutdoorService", f = "OutdoorService.kt", i = {0, 0, 1, 1}, l = {163, 163}, m = "fetchAqiData", n = {"locations", "allowRefreshLocations", "locations", "allowRefreshLocations"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: OutdoorService.kt */
final class OutdoorService$fetchAqiData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OutdoorService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutdoorService$fetchAqiData$1(OutdoorService outdoorService, Continuation<? super OutdoorService$fetchAqiData$1> continuation) {
        super(continuation);
        this.this$0 = outdoorService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchAqiData((List<TrackedLocation>) null, this);
    }
}
