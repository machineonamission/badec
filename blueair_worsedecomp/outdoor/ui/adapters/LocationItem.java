package com.blueair.outdoor.ui.adapters;

import com.blueair.core.model.AqiData;
import com.blueair.core.model.Device;
import com.blueair.core.model.TrackedLocation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/blueair/outdoor/ui/adapters/LocationItem;", "", "location", "Lcom/blueair/core/model/TrackedLocation;", "aqiData", "Lcom/blueair/core/model/AqiData;", "assignedDevices", "", "Lcom/blueair/core/model/Device;", "<init>", "(Lcom/blueair/core/model/TrackedLocation;Lcom/blueair/core/model/AqiData;Ljava/util/List;)V", "getLocation", "()Lcom/blueair/core/model/TrackedLocation;", "getAqiData", "()Lcom/blueair/core/model/AqiData;", "getAssignedDevices", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LocationAdapter.kt */
public final class LocationItem {
    private final AqiData aqiData;
    private final List<Device> assignedDevices;
    private final TrackedLocation location;

    public static /* synthetic */ LocationItem copy$default(LocationItem locationItem, TrackedLocation trackedLocation, AqiData aqiData2, List<Device> list, int i, Object obj) {
        if ((i & 1) != 0) {
            trackedLocation = locationItem.location;
        }
        if ((i & 2) != 0) {
            aqiData2 = locationItem.aqiData;
        }
        if ((i & 4) != 0) {
            list = locationItem.assignedDevices;
        }
        return locationItem.copy(trackedLocation, aqiData2, list);
    }

    public final TrackedLocation component1() {
        return this.location;
    }

    public final AqiData component2() {
        return this.aqiData;
    }

    public final List<Device> component3() {
        return this.assignedDevices;
    }

    public final LocationItem copy(TrackedLocation trackedLocation, AqiData aqiData2, List<? extends Device> list) {
        Intrinsics.checkNotNullParameter(trackedLocation, "location");
        Intrinsics.checkNotNullParameter(aqiData2, "aqiData");
        Intrinsics.checkNotNullParameter(list, "assignedDevices");
        return new LocationItem(trackedLocation, aqiData2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationItem)) {
            return false;
        }
        LocationItem locationItem = (LocationItem) obj;
        return Intrinsics.areEqual((Object) this.location, (Object) locationItem.location) && Intrinsics.areEqual((Object) this.aqiData, (Object) locationItem.aqiData) && Intrinsics.areEqual((Object) this.assignedDevices, (Object) locationItem.assignedDevices);
    }

    public int hashCode() {
        return (((this.location.hashCode() * 31) + this.aqiData.hashCode()) * 31) + this.assignedDevices.hashCode();
    }

    public String toString() {
        return "LocationItem(location=" + this.location + ", aqiData=" + this.aqiData + ", assignedDevices=" + this.assignedDevices + ')';
    }

    public LocationItem(TrackedLocation trackedLocation, AqiData aqiData2, List<? extends Device> list) {
        Intrinsics.checkNotNullParameter(trackedLocation, "location");
        Intrinsics.checkNotNullParameter(aqiData2, "aqiData");
        Intrinsics.checkNotNullParameter(list, "assignedDevices");
        this.location = trackedLocation;
        this.aqiData = aqiData2;
        this.assignedDevices = list;
    }

    public final TrackedLocation getLocation() {
        return this.location;
    }

    public final AqiData getAqiData() {
        return this.aqiData;
    }

    public final List<Device> getAssignedDevices() {
        return this.assignedDevices;
    }
}
