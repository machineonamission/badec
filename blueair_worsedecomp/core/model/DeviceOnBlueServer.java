package com.blueair.core.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/blueair/core/model/DeviceOnBlueServer;", "", "uuid", "", "name", "deviceType", "wifiFirmware", "mcuFirmware", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUuid", "()Ljava/lang/String;", "getName", "getDeviceType", "getWifiFirmware", "getMcuFirmware", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceOnBlueServer.kt */
public final class DeviceOnBlueServer {
    private final String deviceType;
    private final String mcuFirmware;
    private final String name;
    private final String uuid;
    private final String wifiFirmware;

    public static /* synthetic */ DeviceOnBlueServer copy$default(DeviceOnBlueServer deviceOnBlueServer, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceOnBlueServer.uuid;
        }
        if ((i & 2) != 0) {
            str2 = deviceOnBlueServer.name;
        }
        if ((i & 4) != 0) {
            str3 = deviceOnBlueServer.deviceType;
        }
        if ((i & 8) != 0) {
            str4 = deviceOnBlueServer.wifiFirmware;
        }
        if ((i & 16) != 0) {
            str5 = deviceOnBlueServer.mcuFirmware;
        }
        String str6 = str4;
        String str7 = str5;
        return deviceOnBlueServer.copy(str, str2, str3, str6, str7);
    }

    public final String component1() {
        return this.uuid;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.deviceType;
    }

    public final String component4() {
        return this.wifiFirmware;
    }

    public final String component5() {
        return this.mcuFirmware;
    }

    public final DeviceOnBlueServer copy(String str, String str2, @Json(name = "type") String str3, @Json(name = "wifi-firmware") String str4, @Json(name = "mcu-firmware") String str5) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "deviceType");
        Intrinsics.checkNotNullParameter(str4, "wifiFirmware");
        Intrinsics.checkNotNullParameter(str5, "mcuFirmware");
        return new DeviceOnBlueServer(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceOnBlueServer)) {
            return false;
        }
        DeviceOnBlueServer deviceOnBlueServer = (DeviceOnBlueServer) obj;
        return Intrinsics.areEqual((Object) this.uuid, (Object) deviceOnBlueServer.uuid) && Intrinsics.areEqual((Object) this.name, (Object) deviceOnBlueServer.name) && Intrinsics.areEqual((Object) this.deviceType, (Object) deviceOnBlueServer.deviceType) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) deviceOnBlueServer.wifiFirmware) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceOnBlueServer.mcuFirmware);
    }

    public int hashCode() {
        return (((((((this.uuid.hashCode() * 31) + this.name.hashCode()) * 31) + this.deviceType.hashCode()) * 31) + this.wifiFirmware.hashCode()) * 31) + this.mcuFirmware.hashCode();
    }

    public String toString() {
        return "DeviceOnBlueServer(uuid=" + this.uuid + ", name=" + this.name + ", deviceType=" + this.deviceType + ", wifiFirmware=" + this.wifiFirmware + ", mcuFirmware=" + this.mcuFirmware + ')';
    }

    public DeviceOnBlueServer(String str, String str2, @Json(name = "type") String str3, @Json(name = "wifi-firmware") String str4, @Json(name = "mcu-firmware") String str5) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "deviceType");
        Intrinsics.checkNotNullParameter(str4, "wifiFirmware");
        Intrinsics.checkNotNullParameter(str5, "mcuFirmware");
        this.uuid = str;
        this.name = str2;
        this.deviceType = str3;
        this.wifiFirmware = str4;
        this.mcuFirmware = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceOnBlueServer(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r1 = this;
            r8 = r7 & 8
            java.lang.String r0 = ""
            if (r8 == 0) goto L_0x0007
            r5 = r0
        L_0x0007:
            r7 = r7 & 16
            if (r7 == 0) goto L_0x000d
            r7 = r0
            goto L_0x000e
        L_0x000d:
            r7 = r6
        L_0x000e:
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceOnBlueServer.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDeviceType() {
        return this.deviceType;
    }

    public final String getWifiFirmware() {
        return this.wifiFirmware;
    }

    public final String getMcuFirmware() {
        return this.mcuFirmware;
    }
}
