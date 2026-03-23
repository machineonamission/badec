package com.blueair.database.repository;

import com.blueair.core.model.TrackedLocation;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.database.repository.TrackedLocationRepository", f = "TrackedLocationRepository.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {61, 62}, m = "setTrackedLocations", n = {"trackedLocations", "$this$setTrackedLocations_u24lambda_u2413", "toRemove", "ids", "$i$a$-run-TrackedLocationRepository$setTrackedLocations$2", "trackedLocations", "$this$setTrackedLocations_u24lambda_u2413", "toRemove", "ids", "$i$a$-run-TrackedLocationRepository$setTrackedLocations$2"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"})
/* compiled from: TrackedLocationRepository.kt */
final class TrackedLocationRepository$setTrackedLocations$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TrackedLocationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrackedLocationRepository$setTrackedLocations$1(TrackedLocationRepository trackedLocationRepository, Continuation<? super TrackedLocationRepository$setTrackedLocations$1> continuation) {
        super(continuation);
        this.this$0 = trackedLocationRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setTrackedLocations((List<TrackedLocation>) null, this);
    }
}
