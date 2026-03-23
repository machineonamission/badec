package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/blueair/core/model/BlueAqiDataContent;", "", "aqi", "", "datetime", "", "pollutants", "Lcom/blueair/core/model/BreezoMeterOutdoorPollutants;", "<init>", "(Ljava/lang/Double;Ljava/lang/String;Lcom/blueair/core/model/BreezoMeterOutdoorPollutants;)V", "getAqi", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDatetime", "()Ljava/lang/String;", "getPollutants", "()Lcom/blueair/core/model/BreezoMeterOutdoorPollutants;", "component1", "component2", "component3", "copy", "(Ljava/lang/Double;Ljava/lang/String;Lcom/blueair/core/model/BreezoMeterOutdoorPollutants;)Lcom/blueair/core/model/BlueAqiDataContent;", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AqiData.kt */
public final class BlueAqiDataContent {
    private final Double aqi;
    private final String datetime;
    private final BreezoMeterOutdoorPollutants pollutants;

    public static /* synthetic */ BlueAqiDataContent copy$default(BlueAqiDataContent blueAqiDataContent, Double d, String str, BreezoMeterOutdoorPollutants breezoMeterOutdoorPollutants, int i, Object obj) {
        if ((i & 1) != 0) {
            d = blueAqiDataContent.aqi;
        }
        if ((i & 2) != 0) {
            str = blueAqiDataContent.datetime;
        }
        if ((i & 4) != 0) {
            breezoMeterOutdoorPollutants = blueAqiDataContent.pollutants;
        }
        return blueAqiDataContent.copy(d, str, breezoMeterOutdoorPollutants);
    }

    public final Double component1() {
        return this.aqi;
    }

    public final String component2() {
        return this.datetime;
    }

    public final BreezoMeterOutdoorPollutants component3() {
        return this.pollutants;
    }

    public final BlueAqiDataContent copy(Double d, String str, BreezoMeterOutdoorPollutants breezoMeterOutdoorPollutants) {
        return new BlueAqiDataContent(d, str, breezoMeterOutdoorPollutants);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlueAqiDataContent)) {
            return false;
        }
        BlueAqiDataContent blueAqiDataContent = (BlueAqiDataContent) obj;
        return Intrinsics.areEqual((Object) this.aqi, (Object) blueAqiDataContent.aqi) && Intrinsics.areEqual((Object) this.datetime, (Object) blueAqiDataContent.datetime) && Intrinsics.areEqual((Object) this.pollutants, (Object) blueAqiDataContent.pollutants);
    }

    public int hashCode() {
        Double d = this.aqi;
        int i = 0;
        int hashCode = (d == null ? 0 : d.hashCode()) * 31;
        String str = this.datetime;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        BreezoMeterOutdoorPollutants breezoMeterOutdoorPollutants = this.pollutants;
        if (breezoMeterOutdoorPollutants != null) {
            i = breezoMeterOutdoorPollutants.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "BlueAqiDataContent(aqi=" + this.aqi + ", datetime=" + this.datetime + ", pollutants=" + this.pollutants + ')';
    }

    public BlueAqiDataContent(Double d, String str, BreezoMeterOutdoorPollutants breezoMeterOutdoorPollutants) {
        this.aqi = d;
        this.datetime = str;
        this.pollutants = breezoMeterOutdoorPollutants;
    }

    public final Double getAqi() {
        return this.aqi;
    }

    public final String getDatetime() {
        return this.datetime;
    }

    public final BreezoMeterOutdoorPollutants getPollutants() {
        return this.pollutants;
    }
}
