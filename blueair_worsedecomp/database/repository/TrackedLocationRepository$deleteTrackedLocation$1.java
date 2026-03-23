package com.blueair.database.repository;

import com.blueair.core.model.TrackedLocation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.database.repository.TrackedLocationRepository", f = "TrackedLocationRepository.kt", i = {0, 1, 2}, l = {79, 80, 81}, m = "deleteTrackedLocation", n = {"trackedLocation", "trackedLocation", "trackedLocation"}, s = {"L$0", "L$0", "L$0"})
/* compiled from: TrackedLocationRepository.kt */
final class TrackedLocationRepository$deleteTrackedLocation$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TrackedLocationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrackedLocationRepository$deleteTrackedLocation$1(TrackedLocationRepository trackedLocationRepository, Continuation<? super TrackedLocationRepository$deleteTrackedLocation$1> continuation) {
        super(continuation);
        this.this$0 = trackedLocationRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deleteTrackedLocation((TrackedLocation) null, this);
    }
}
