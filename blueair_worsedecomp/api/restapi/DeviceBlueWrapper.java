package com.blueair.api.restapi;

import com.blueair.core.model.DeviceOnBlueServer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/blueair/api/restapi/DeviceBlueWrapper;", "", "devices", "", "Lcom/blueair/core/model/DeviceOnBlueServer;", "<init>", "(Ljava/util/List;)V", "getDevices", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class DeviceBlueWrapper {
    private final List<DeviceOnBlueServer> devices;

    public static /* synthetic */ DeviceBlueWrapper copy$default(DeviceBlueWrapper deviceBlueWrapper, List<DeviceOnBlueServer> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = deviceBlueWrapper.devices;
        }
        return deviceBlueWrapper.copy(list);
    }

    public final List<DeviceOnBlueServer> component1() {
        return this.devices;
    }

    public final DeviceBlueWrapper copy(List<DeviceOnBlueServer> list) {
        Intrinsics.checkNotNullParameter(list, "devices");
        return new DeviceBlueWrapper(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DeviceBlueWrapper) && Intrinsics.areEqual((Object) this.devices, (Object) ((DeviceBlueWrapper) obj).devices);
    }

    public int hashCode() {
        return this.devices.hashCode();
    }

    public String toString() {
        return "DeviceBlueWrapper(devices=" + this.devices + ')';
    }

    public DeviceBlueWrapper(List<DeviceOnBlueServer> list) {
        Intrinsics.checkNotNullParameter(list, "devices");
        this.devices = list;
    }

    public final List<DeviceOnBlueServer> getDevices() {
        return this.devices;
    }
}
