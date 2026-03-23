package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/blueair/api/restapi/GetAqiDataByLatLngReq;", "", "lat", "", "lon", "range", "type", "", "<init>", "(DDDLjava/lang/String;)V", "getLat", "()D", "getLon", "getRange", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: OutdoorRestApi.kt */
public final class GetAqiDataByLatLngReq {
    private final double lat;
    private final double lon;
    private final double range;
    private final String type;

    public static /* synthetic */ GetAqiDataByLatLngReq copy$default(GetAqiDataByLatLngReq getAqiDataByLatLngReq, double d, double d2, double d3, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            d = getAqiDataByLatLngReq.lat;
        }
        double d4 = d;
        if ((i & 2) != 0) {
            d2 = getAqiDataByLatLngReq.lon;
        }
        double d5 = d2;
        if ((i & 4) != 0) {
            d3 = getAqiDataByLatLngReq.range;
        }
        double d6 = d3;
        if ((i & 8) != 0) {
            str = getAqiDataByLatLngReq.type;
        }
        return getAqiDataByLatLngReq.copy(d4, d5, d6, str);
    }

    public final double component1() {
        return this.lat;
    }

    public final double component2() {
        return this.lon;
    }

    public final double component3() {
        return this.range;
    }

    public final String component4() {
        return this.type;
    }

    public final GetAqiDataByLatLngReq copy(double d, double d2, double d3, String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "type");
        return new GetAqiDataByLatLngReq(d, d2, d3, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAqiDataByLatLngReq)) {
            return false;
        }
        GetAqiDataByLatLngReq getAqiDataByLatLngReq = (GetAqiDataByLatLngReq) obj;
        return Double.compare(this.lat, getAqiDataByLatLngReq.lat) == 0 && Double.compare(this.lon, getAqiDataByLatLngReq.lon) == 0 && Double.compare(this.range, getAqiDataByLatLngReq.range) == 0 && Intrinsics.areEqual((Object) this.type, (Object) getAqiDataByLatLngReq.type);
    }

    public int hashCode() {
        return (((((Double.doubleToLongBits(this.lat) * 31) + Double.doubleToLongBits(this.lon)) * 31) + Double.doubleToLongBits(this.range)) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "GetAqiDataByLatLngReq(lat=" + this.lat + ", lon=" + this.lon + ", range=" + this.range + ", type=" + this.type + ')';
    }

    public GetAqiDataByLatLngReq(double d, double d2, double d3, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        this.lat = d;
        this.lon = d2;
        this.range = d3;
        this.type = str;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLon() {
        return this.lon;
    }

    public final double getRange() {
        return this.range;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetAqiDataByLatLngReq(double d, double d2, double d3, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, d2, (i & 4) != 0 ? 300.0d : d3, (i & 8) != 0 ? "latAndLon" : str);
    }

    public final String getType() {
        return this.type;
    }
}
