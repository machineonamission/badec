package com.blueair.api.restapi;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/blueair/api/restapi/GetDeviceStatusRsp;", "", "online", "", "<init>", "(Z)V", "getOnline", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class GetDeviceStatusRsp {
    private final boolean online;

    public static /* synthetic */ GetDeviceStatusRsp copy$default(GetDeviceStatusRsp getDeviceStatusRsp, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = getDeviceStatusRsp.online;
        }
        return getDeviceStatusRsp.copy(z);
    }

    public final boolean component1() {
        return this.online;
    }

    public final GetDeviceStatusRsp copy(boolean z) {
        return new GetDeviceStatusRsp(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetDeviceStatusRsp) && this.online == ((GetDeviceStatusRsp) obj).online;
    }

    public int hashCode() {
        return AddDeviceState$$ExternalSyntheticBackport0.m(this.online);
    }

    public String toString() {
        return "GetDeviceStatusRsp(online=" + this.online + ')';
    }

    public GetDeviceStatusRsp(boolean z) {
        this.online = z;
    }

    public final boolean getOnline() {
        return this.online;
    }
}
