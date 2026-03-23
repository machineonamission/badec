package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/blueair/api/restapi/DeviceLocationInfo;", "", "device_id", "", "location_id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDevice_id", "()Ljava/lang/String;", "getLocation_id", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class DeviceLocationInfo {
    private final String device_id;
    private final String location_id;

    public static /* synthetic */ DeviceLocationInfo copy$default(DeviceLocationInfo deviceLocationInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceLocationInfo.device_id;
        }
        if ((i & 2) != 0) {
            str2 = deviceLocationInfo.location_id;
        }
        return deviceLocationInfo.copy(str, str2);
    }

    public final String component1() {
        return this.device_id;
    }

    public final String component2() {
        return this.location_id;
    }

    public final DeviceLocationInfo copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "device_id");
        return new DeviceLocationInfo(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceLocationInfo)) {
            return false;
        }
        DeviceLocationInfo deviceLocationInfo = (DeviceLocationInfo) obj;
        return Intrinsics.areEqual((Object) this.device_id, (Object) deviceLocationInfo.device_id) && Intrinsics.areEqual((Object) this.location_id, (Object) deviceLocationInfo.location_id);
    }

    public int hashCode() {
        int hashCode = this.device_id.hashCode() * 31;
        String str = this.location_id;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "DeviceLocationInfo(device_id=" + this.device_id + ", location_id=" + this.location_id + ')';
    }

    public DeviceLocationInfo(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "device_id");
        this.device_id = str;
        this.location_id = str2;
    }

    public final String getDevice_id() {
        return this.device_id;
    }

    public final String getLocation_id() {
        return this.location_id;
    }
}
