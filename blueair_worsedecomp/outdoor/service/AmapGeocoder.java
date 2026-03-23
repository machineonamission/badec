package com.blueair.outdoor.service;

import android.content.Context;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.service.LocationNamePlaceholderProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\tH@¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/blueair/outdoor/service/AmapGeocoder;", "Lcom/blueair/outdoor/service/Geocoder;", "appContext", "Landroid/content/Context;", "locationNamePlaceholderProvider", "Lcom/blueair/core/service/LocationNamePlaceholderProvider;", "<init>", "(Landroid/content/Context;Lcom/blueair/core/service/LocationNamePlaceholderProvider;)V", "getTrackedLocation", "Lcom/blueair/core/model/TrackedLocation;", "location", "(Lcom/blueair/core/model/TrackedLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AmapGeocoder.kt */
public final class AmapGeocoder implements Geocoder {
    private final Context appContext;
    private final LocationNamePlaceholderProvider locationNamePlaceholderProvider;

    public Object getTrackedLocation(TrackedLocation trackedLocation, Continuation<? super TrackedLocation> continuation) {
        return null;
    }

    public AmapGeocoder(Context context, LocationNamePlaceholderProvider locationNamePlaceholderProvider2) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(locationNamePlaceholderProvider2, "locationNamePlaceholderProvider");
        this.appContext = context;
        this.locationNamePlaceholderProvider = locationNamePlaceholderProvider2;
    }
}
