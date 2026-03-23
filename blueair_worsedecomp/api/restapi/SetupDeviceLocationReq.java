package com.blueair.api.restapi;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/blueair/api/restapi/SetupDeviceLocationReq;", "", "location_id", "", "device_ids", "", "reset_device_ids", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getLocation_id", "()Ljava/lang/String;", "getDevice_ids", "()Ljava/util/List;", "getReset_device_ids", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class SetupDeviceLocationReq {
    private final List<String> device_ids;
    private final String location_id;
    private final List<String> reset_device_ids;

    public static /* synthetic */ SetupDeviceLocationReq copy$default(SetupDeviceLocationReq setupDeviceLocationReq, String str, List<String> list, List<String> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = setupDeviceLocationReq.location_id;
        }
        if ((i & 2) != 0) {
            list = setupDeviceLocationReq.device_ids;
        }
        if ((i & 4) != 0) {
            list2 = setupDeviceLocationReq.reset_device_ids;
        }
        return setupDeviceLocationReq.copy(str, list, list2);
    }

    public final String component1() {
        return this.location_id;
    }

    public final List<String> component2() {
        return this.device_ids;
    }

    public final List<String> component3() {
        return this.reset_device_ids;
    }

    public final SetupDeviceLocationReq copy(String str, List<String> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(str, "location_id");
        Intrinsics.checkNotNullParameter(list, "device_ids");
        Intrinsics.checkNotNullParameter(list2, "reset_device_ids");
        return new SetupDeviceLocationReq(str, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetupDeviceLocationReq)) {
            return false;
        }
        SetupDeviceLocationReq setupDeviceLocationReq = (SetupDeviceLocationReq) obj;
        return Intrinsics.areEqual((Object) this.location_id, (Object) setupDeviceLocationReq.location_id) && Intrinsics.areEqual((Object) this.device_ids, (Object) setupDeviceLocationReq.device_ids) && Intrinsics.areEqual((Object) this.reset_device_ids, (Object) setupDeviceLocationReq.reset_device_ids);
    }

    public int hashCode() {
        return (((this.location_id.hashCode() * 31) + this.device_ids.hashCode()) * 31) + this.reset_device_ids.hashCode();
    }

    public String toString() {
        return "SetupDeviceLocationReq(location_id=" + this.location_id + ", device_ids=" + this.device_ids + ", reset_device_ids=" + this.reset_device_ids + ')';
    }

    public SetupDeviceLocationReq(String str, List<String> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(str, "location_id");
        Intrinsics.checkNotNullParameter(list, "device_ids");
        Intrinsics.checkNotNullParameter(list2, "reset_device_ids");
        this.location_id = str;
        this.device_ids = list;
        this.reset_device_ids = list2;
    }

    public final String getLocation_id() {
        return this.location_id;
    }

    public final List<String> getDevice_ids() {
        return this.device_ids;
    }

    public final List<String> getReset_device_ids() {
        return this.reset_device_ids;
    }
}
