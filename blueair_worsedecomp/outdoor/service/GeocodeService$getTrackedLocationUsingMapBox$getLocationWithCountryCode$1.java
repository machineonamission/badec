package com.blueair.outdoor.service;

import com.blueair.core.model.TrackedLocation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.outdoor.service.GeocodeService", f = "GeocodeService.kt", i = {0, 0}, l = {58}, m = "getTrackedLocationUsingMapBox$getLocationWithCountryCode", n = {"this$0", "location"}, s = {"L$0", "L$1"})
/* compiled from: GeocodeService.kt */
final class GeocodeService$getTrackedLocationUsingMapBox$getLocationWithCountryCode$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    GeocodeService$getTrackedLocationUsingMapBox$getLocationWithCountryCode$1(Continuation<? super GeocodeService$getTrackedLocationUsingMapBox$getLocationWithCountryCode$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return GeocodeService.getTrackedLocationUsingMapBox$getLocationWithCountryCode((GeocodeService) null, (TrackedLocation) null, this);
    }
}
