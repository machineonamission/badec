package com.blueair.core.model;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/blueair/core/model/AqiData;", "", "locationId", "", "datetime", "", "pollutants", "Lcom/blueair/core/model/OutdoorPollutants;", "<init>", "(Ljava/lang/String;JLcom/blueair/core/model/OutdoorPollutants;)V", "getLocationId", "()Ljava/lang/String;", "getDatetime", "()J", "getPollutants", "()Lcom/blueair/core/model/OutdoorPollutants;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AqiData.kt */
public final class AqiData {
    private final long datetime;
    private final String locationId;
    private final OutdoorPollutants pollutants;

    public static /* synthetic */ AqiData copy$default(AqiData aqiData, String str, long j, OutdoorPollutants outdoorPollutants, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aqiData.locationId;
        }
        if ((i & 2) != 0) {
            j = aqiData.datetime;
        }
        if ((i & 4) != 0) {
            outdoorPollutants = aqiData.pollutants;
        }
        return aqiData.copy(str, j, outdoorPollutants);
    }

    public final String component1() {
        return this.locationId;
    }

    public final long component2() {
        return this.datetime;
    }

    public final OutdoorPollutants component3() {
        return this.pollutants;
    }

    public final AqiData copy(String str, long j, OutdoorPollutants outdoorPollutants) {
        Intrinsics.checkNotNullParameter(str, "locationId");
        return new AqiData(str, j, outdoorPollutants);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AqiData)) {
            return false;
        }
        AqiData aqiData = (AqiData) obj;
        return Intrinsics.areEqual((Object) this.locationId, (Object) aqiData.locationId) && this.datetime == aqiData.datetime && Intrinsics.areEqual((Object) this.pollutants, (Object) aqiData.pollutants);
    }

    public int hashCode() {
        int hashCode = ((this.locationId.hashCode() * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.datetime)) * 31;
        OutdoorPollutants outdoorPollutants = this.pollutants;
        return hashCode + (outdoorPollutants == null ? 0 : outdoorPollutants.hashCode());
    }

    public String toString() {
        return "AqiData(locationId=" + this.locationId + ", datetime=" + this.datetime + ", pollutants=" + this.pollutants + ')';
    }

    public AqiData(String str, long j, OutdoorPollutants outdoorPollutants) {
        Intrinsics.checkNotNullParameter(str, "locationId");
        this.locationId = str;
        this.datetime = j;
        this.pollutants = outdoorPollutants;
    }

    public final String getLocationId() {
        return this.locationId;
    }

    public final long getDatetime() {
        return this.datetime;
    }

    public final OutdoorPollutants getPollutants() {
        return this.pollutants;
    }
}
