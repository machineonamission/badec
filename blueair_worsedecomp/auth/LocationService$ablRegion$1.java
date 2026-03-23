package com.blueair.auth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.LocationService", f = "LocationService.kt", i = {0, 0, 1, 1, 1}, l = {349, 195}, m = "ablRegion", n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-LocationService$ablRegion$2"}, s = {"L$0", "I$0", "L$0", "I$0", "I$1"})
/* compiled from: LocationService.kt */
final class LocationService$ablRegion$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocationService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocationService$ablRegion$1(LocationService locationService, Continuation<? super LocationService$ablRegion$1> continuation) {
        super(continuation);
        this.this$0 = locationService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.ablRegion(this);
    }
}
