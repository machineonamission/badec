package com.blueair.devicedetails.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceInfo;", "", "type", "Lcom/blueair/devicedetails/util/DeviceInfoType;", "name", "", "value", "", "<init>", "(Lcom/blueair/devicedetails/util/DeviceInfoType;ILjava/lang/String;)V", "getType", "()Lcom/blueair/devicedetails/util/DeviceInfoType;", "getName", "()I", "getValue", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceInfo.kt */
public final class DeviceInfo {
    private final int name;
    private final DeviceInfoType type;
    private final String value;

    public static /* synthetic */ DeviceInfo copy$default(DeviceInfo deviceInfo, DeviceInfoType deviceInfoType, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            deviceInfoType = deviceInfo.type;
        }
        if ((i2 & 2) != 0) {
            i = deviceInfo.name;
        }
        if ((i2 & 4) != 0) {
            str = deviceInfo.value;
        }
        return deviceInfo.copy(deviceInfoType, i, str);
    }

    public final DeviceInfoType component1() {
        return this.type;
    }

    public final int component2() {
        return this.name;
    }

    public final String component3() {
        return this.value;
    }

    public final DeviceInfo copy(DeviceInfoType deviceInfoType, int i, String str) {
        Intrinsics.checkNotNullParameter(deviceInfoType, "type");
        Intrinsics.checkNotNullParameter(str, "value");
        return new DeviceInfo(deviceInfoType, i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return this.type == deviceInfo.type && this.name == deviceInfo.name && Intrinsics.areEqual((Object) this.value, (Object) deviceInfo.value);
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.name) * 31) + this.value.hashCode();
    }

    public String toString() {
        return "DeviceInfo(type=" + this.type + ", name=" + this.name + ", value=" + this.value + ')';
    }

    public DeviceInfo(DeviceInfoType deviceInfoType, int i, String str) {
        Intrinsics.checkNotNullParameter(deviceInfoType, "type");
        Intrinsics.checkNotNullParameter(str, "value");
        this.type = deviceInfoType;
        this.name = i;
        this.value = str;
    }

    public final DeviceInfoType getType() {
        return this.type;
    }

    public final int getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }
}
