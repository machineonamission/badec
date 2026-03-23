package com.blueair.auth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.auth.LocationService", f = "LocationService.kt", i = {}, l = {202}, m = "fetchBlueairRegion", n = {}, s = {})
/* compiled from: LocationService.kt */
final class LocationService$fetchBlueairRegion$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocationService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocationService$fetchBlueairRegion$1(LocationService locationService, Continuation<? super LocationService$fetchBlueairRegion$1> continuation) {
        super(continuation);
        this.this$0 = locationService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchBlueairRegion(this);
    }
}
