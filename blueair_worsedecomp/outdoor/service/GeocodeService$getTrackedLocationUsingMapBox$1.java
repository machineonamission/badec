package com.blueair.outdoor.service;

import com.blueair.core.model.TrackedLocation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.outdoor.service.GeocodeService", f = "GeocodeService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {60, 61}, m = "getTrackedLocationUsingMapBox", n = {"location", "latLngWGS", "locs", "lngLatGCJ", "location", "latLngWGS", "locs", "lngLatGCJ", "locWithCountryCodeGCJ"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
/* compiled from: GeocodeService.kt */
final class GeocodeService$getTrackedLocationUsingMapBox$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GeocodeService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GeocodeService$getTrackedLocationUsingMapBox$1(GeocodeService geocodeService, Continuation<? super GeocodeService$getTrackedLocationUsingMapBox$1> continuation) {
        super(continuation);
        this.this$0 = geocodeService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getTrackedLocationUsingMapBox((TrackedLocation) null, this);
    }
}
