package com.blueair.core.model;

import com.blueair.core.util.TimeUtils;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/blueair/core/model/BlueAqiData;", "", "locationId", "", "data", "Lcom/blueair/core/model/BlueAqiDataContent;", "<init>", "(Ljava/lang/String;Lcom/blueair/core/model/BlueAqiDataContent;)V", "getLocationId", "()Ljava/lang/String;", "getData", "()Lcom/blueair/core/model/BlueAqiDataContent;", "toAqiData", "Lcom/blueair/core/model/AqiData;", "dateFormatterBreezo", "Ljava/text/SimpleDateFormat;", "getCalculatedPollutants", "Lcom/blueair/core/model/OutdoorPollutants;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AqiData.kt */
public final class BlueAqiData {
    private final BlueAqiDataContent data;
    private final String locationId;

    public static /* synthetic */ BlueAqiData copy$default(BlueAqiData blueAqiData, String str, BlueAqiDataContent blueAqiDataContent, int i, Object obj) {
        if ((i & 1) != 0) {
            str = blueAqiData.locationId;
        }
        if ((i & 2) != 0) {
            blueAqiDataContent = blueAqiData.data;
        }
        return blueAqiData.copy(str, blueAqiDataContent);
    }

    public final String component1() {
        return this.locationId;
    }

    public final BlueAqiDataContent component2() {
        return this.data;
    }

    public final BlueAqiData copy(String str, BlueAqiDataContent blueAqiDataContent) {
        Intrinsics.checkNotNullParameter(str, "locationId");
        Intrinsics.checkNotNullParameter(blueAqiDataContent, "data");
        return new BlueAqiData(str, blueAqiDataContent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlueAqiData)) {
            return false;
        }
        BlueAqiData blueAqiData = (BlueAqiData) obj;
        return Intrinsics.areEqual((Object) this.locationId, (Object) blueAqiData.locationId) && Intrinsics.areEqual((Object) this.data, (Object) blueAqiData.data);
    }

    public int hashCode() {
        return (this.locationId.hashCode() * 31) + this.data.hashCode();
    }

    public String toString() {
        return "BlueAqiData(locationId=" + this.locationId + ", data=" + this.data + ')';
    }

    public BlueAqiData(String str, BlueAqiDataContent blueAqiDataContent) {
        Intrinsics.checkNotNullParameter(str, "locationId");
        Intrinsics.checkNotNullParameter(blueAqiDataContent, "data");
        this.locationId = str;
        this.data = blueAqiDataContent;
    }

    public final String getLocationId() {
        return this.locationId;
    }

    public final BlueAqiDataContent getData() {
        return this.data;
    }

    public static /* synthetic */ AqiData toAqiData$default(BlueAqiData blueAqiData, SimpleDateFormat simpleDateFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            simpleDateFormat = TimeUtils.INSTANCE.getDATE_FORMAT_BREEZOMETER();
        }
        return blueAqiData.toAqiData(simpleDateFormat);
    }

    public final AqiData toAqiData(SimpleDateFormat simpleDateFormat) {
        Intrinsics.checkNotNullParameter(simpleDateFormat, "dateFormatterBreezo");
        String str = this.locationId;
        String datetime = this.data.getDatetime();
        return new AqiData(str, datetime != null ? TimeUtils.INSTANCE.unixTimeFromBreezometerDate(datetime, simpleDateFormat) : 0, getCalculatedPollutants());
    }

    private final OutdoorPollutants getCalculatedPollutants() {
        BreezoMeterOutdoorPollutants pollutants = this.data.getPollutants();
        if (pollutants != null) {
            return new OutdoorPollutants(pollutants.getCo_ppb(), pollutants.getNo2(), pollutants.getO3(), pollutants.getPm10(), pollutants.getPm25(), pollutants.getSo2(), new Pollutant(pollutants.getCalculatedAQI()));
        }
        return null;
    }
}
