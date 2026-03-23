package com.blueair.outdoor.service;

import com.blueair.core.model.TrackedLocation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/blueair/outdoor/service/Geocoder;", "", "getTrackedLocation", "Lcom/blueair/core/model/TrackedLocation;", "location", "(Lcom/blueair/core/model/TrackedLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Geocoder.kt */
public interface Geocoder {
    Object getTrackedLocation(TrackedLocation trackedLocation, Continuation<? super TrackedLocation> continuation);
}
