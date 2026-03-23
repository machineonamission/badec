package com.blueair.api.restapi;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/blueair/api/restapi/GetAqiDataByLocationIdReq;", "", "locationIds", "", "", "range", "", "type", "<init>", "(Ljava/util/List;DLjava/lang/String;)V", "getLocationIds", "()Ljava/util/List;", "getRange", "()D", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: OutdoorRestApi.kt */
public final class GetAqiDataByLocationIdReq {
    private final List<String> locationIds;
    private final double range;
    private final String type;

    public static /* synthetic */ GetAqiDataByLocationIdReq copy$default(GetAqiDataByLocationIdReq getAqiDataByLocationIdReq, List<String> list, double d, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = getAqiDataByLocationIdReq.locationIds;
        }
        if ((i & 2) != 0) {
            d = getAqiDataByLocationIdReq.range;
        }
        if ((i & 4) != 0) {
            str = getAqiDataByLocationIdReq.type;
        }
        return getAqiDataByLocationIdReq.copy(list, d, str);
    }

    public final List<String> component1() {
        return this.locationIds;
    }

    public final double component2() {
        return this.range;
    }

    public final String component3() {
        return this.type;
    }

    public final GetAqiDataByLocationIdReq copy(List<String> list, double d, String str) {
        Intrinsics.checkNotNullParameter(list, "locationIds");
        Intrinsics.checkNotNullParameter(str, "type");
        return new GetAqiDataByLocationIdReq(list, d, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAqiDataByLocationIdReq)) {
            return false;
        }
        GetAqiDataByLocationIdReq getAqiDataByLocationIdReq = (GetAqiDataByLocationIdReq) obj;
        return Intrinsics.areEqual((Object) this.locationIds, (Object) getAqiDataByLocationIdReq.locationIds) && Double.compare(this.range, getAqiDataByLocationIdReq.range) == 0 && Intrinsics.areEqual((Object) this.type, (Object) getAqiDataByLocationIdReq.type);
    }

    public int hashCode() {
        return (((this.locationIds.hashCode() * 31) + Double.doubleToLongBits(this.range)) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "GetAqiDataByLocationIdReq(locationIds=" + this.locationIds + ", range=" + this.range + ", type=" + this.type + ')';
    }

    public GetAqiDataByLocationIdReq(List<String> list, double d, String str) {
        Intrinsics.checkNotNullParameter(list, "locationIds");
        Intrinsics.checkNotNullParameter(str, "type");
        this.locationIds = list;
        this.range = d;
        this.type = str;
    }

    public final List<String> getLocationIds() {
        return this.locationIds;
    }

    public final double getRange() {
        return this.range;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetAqiDataByLocationIdReq(List list, double d, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? 300.0d : d, (i & 4) != 0 ? "id" : str);
    }

    public final String getType() {
        return this.type;
    }
}
