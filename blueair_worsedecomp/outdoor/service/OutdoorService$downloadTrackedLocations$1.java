package com.blueair.outdoor.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.outdoor.service.OutdoorService", f = "OutdoorService.kt", i = {}, l = {93, 93}, m = "downloadTrackedLocations", n = {}, s = {})
/* compiled from: OutdoorService.kt */
final class OutdoorService$downloadTrackedLocations$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OutdoorService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutdoorService$downloadTrackedLocations$1(OutdoorService outdoorService, Continuation<? super OutdoorService$downloadTrackedLocations$1> continuation) {
        super(continuation);
        this.this$0 = outdoorService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.downloadTrackedLocations(this);
    }
}
