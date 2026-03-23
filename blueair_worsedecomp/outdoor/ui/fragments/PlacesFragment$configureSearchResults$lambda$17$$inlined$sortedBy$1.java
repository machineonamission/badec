package com.blueair.outdoor.ui.fragments;

import com.blueair.core.model.TrackedLocation;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: Comparisons.kt */
public final class PlacesFragment$configureSearchResults$lambda$17$$inlined$sortedBy$1<T> implements Comparator {
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(Boolean.valueOf(((TrackedLocation) t).isCurrentLocation()), Boolean.valueOf(((TrackedLocation) t2).isCurrentLocation()));
    }
}
