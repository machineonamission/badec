package com.blueair.devicemanager;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/blueair/devicemanager/IcpDevice;", "", "macAddress", "", "name", "uuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMacAddress", "()Ljava/lang/String;", "getName", "getUuid", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "devicemanager_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: IcpDeviceManager.kt */
public final class IcpDevice {
    private final String macAddress;
    private final String name;
    private final String uuid;

    public static /* synthetic */ IcpDevice copy$default(IcpDevice icpDevice, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = icpDevice.macAddress;
        }
        if ((i & 2) != 0) {
            str2 = icpDevice.name;
        }
        if ((i & 4) != 0) {
            str3 = icpDevice.uuid;
        }
        return icpDevice.copy(str, str2, str3);
    }

    public final String component1() {
        return this.macAddress;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.uuid;
    }

    public final IcpDevice copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "macAddress");
        return new IcpDevice(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IcpDevice)) {
            return false;
        }
        IcpDevice icpDevice = (IcpDevice) obj;
        return Intrinsics.areEqual((Object) this.macAddress, (Object) icpDevice.macAddress) && Intrinsics.areEqual((Object) this.name, (Object) icpDevice.name) && Intrinsics.areEqual((Object) this.uuid, (Object) icpDevice.uuid);
    }

    public int hashCode() {
        int hashCode = this.macAddress.hashCode() * 31;
        String str = this.name;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.uuid;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "IcpDevice(macAddress=" + this.macAddress + ", name=" + this.name + ", uuid=" + this.uuid + ')';
    }

    public IcpDevice(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "macAddress");
        this.macAddress = str;
        this.name = str2;
        this.uuid = str3;
    }

    public final String getMacAddress() {
        return this.macAddress;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUuid() {
        return this.uuid;
    }
}
