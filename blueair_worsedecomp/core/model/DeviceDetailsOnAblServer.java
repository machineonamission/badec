package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B_\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0019Jx\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006,"}, d2 = {"Lcom/blueair/core/model/DeviceDetailsOnAblServer;", "", "compatibility", "", "firmware", "name", "uuid", "timezone", "mcuFirmware", "mac", "aimSerialNumber", "aimUpdateDate", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getCompatibility", "()Ljava/lang/String;", "getFirmware", "getName", "getUuid", "getTimezone", "getMcuFirmware", "getMac", "getAimSerialNumber", "getAimUpdateDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/blueair/core/model/DeviceDetailsOnAblServer;", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceDetailsOnAblServer.kt */
public final class DeviceDetailsOnAblServer {
    private final String aimSerialNumber;
    private final Long aimUpdateDate;
    private final String compatibility;
    private final String firmware;
    private final String mac;
    private final String mcuFirmware;
    private final String name;
    private final String timezone;
    private final String uuid;

    public static /* synthetic */ DeviceDetailsOnAblServer copy$default(DeviceDetailsOnAblServer deviceDetailsOnAblServer, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceDetailsOnAblServer.compatibility;
        }
        if ((i & 2) != 0) {
            str2 = deviceDetailsOnAblServer.firmware;
        }
        if ((i & 4) != 0) {
            str3 = deviceDetailsOnAblServer.name;
        }
        if ((i & 8) != 0) {
            str4 = deviceDetailsOnAblServer.uuid;
        }
        if ((i & 16) != 0) {
            str5 = deviceDetailsOnAblServer.timezone;
        }
        if ((i & 32) != 0) {
            str6 = deviceDetailsOnAblServer.mcuFirmware;
        }
        if ((i & 64) != 0) {
            str7 = deviceDetailsOnAblServer.mac;
        }
        if ((i & 128) != 0) {
            str8 = deviceDetailsOnAblServer.aimSerialNumber;
        }
        if ((i & 256) != 0) {
            l = deviceDetailsOnAblServer.aimUpdateDate;
        }
        String str9 = str8;
        Long l2 = l;
        String str10 = str6;
        String str11 = str7;
        String str12 = str4;
        String str13 = str5;
        return deviceDetailsOnAblServer.copy(str, str2, str3, str12, str13, str10, str11, str9, l2);
    }

    public final String component1() {
        return this.compatibility;
    }

    public final String component2() {
        return this.firmware;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.uuid;
    }

    public final String component5() {
        return this.timezone;
    }

    public final String component6() {
        return this.mcuFirmware;
    }

    public final String component7() {
        return this.mac;
    }

    public final String component8() {
        return this.aimSerialNumber;
    }

    public final Long component9() {
        return this.aimUpdateDate;
    }

    public final DeviceDetailsOnAblServer copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Long l) {
        Intrinsics.checkNotNullParameter(str4, "uuid");
        return new DeviceDetailsOnAblServer(str, str2, str3, str4, str5, str6, str7, str8, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceDetailsOnAblServer)) {
            return false;
        }
        DeviceDetailsOnAblServer deviceDetailsOnAblServer = (DeviceDetailsOnAblServer) obj;
        return Intrinsics.areEqual((Object) this.compatibility, (Object) deviceDetailsOnAblServer.compatibility) && Intrinsics.areEqual((Object) this.firmware, (Object) deviceDetailsOnAblServer.firmware) && Intrinsics.areEqual((Object) this.name, (Object) deviceDetailsOnAblServer.name) && Intrinsics.areEqual((Object) this.uuid, (Object) deviceDetailsOnAblServer.uuid) && Intrinsics.areEqual((Object) this.timezone, (Object) deviceDetailsOnAblServer.timezone) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceDetailsOnAblServer.mcuFirmware) && Intrinsics.areEqual((Object) this.mac, (Object) deviceDetailsOnAblServer.mac) && Intrinsics.areEqual((Object) this.aimSerialNumber, (Object) deviceDetailsOnAblServer.aimSerialNumber) && Intrinsics.areEqual((Object) this.aimUpdateDate, (Object) deviceDetailsOnAblServer.aimUpdateDate);
    }

    public int hashCode() {
        String str = this.compatibility;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.firmware;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.uuid.hashCode()) * 31;
        String str4 = this.timezone;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.mcuFirmware;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.mac;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.aimSerialNumber;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Long l = this.aimUpdateDate;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "DeviceDetailsOnAblServer(compatibility=" + this.compatibility + ", firmware=" + this.firmware + ", name=" + this.name + ", uuid=" + this.uuid + ", timezone=" + this.timezone + ", mcuFirmware=" + this.mcuFirmware + ", mac=" + this.mac + ", aimSerialNumber=" + this.aimSerialNumber + ", aimUpdateDate=" + this.aimUpdateDate + ')';
    }

    public DeviceDetailsOnAblServer(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Long l) {
        Intrinsics.checkNotNullParameter(str4, "uuid");
        this.compatibility = str;
        this.firmware = str2;
        this.name = str3;
        this.uuid = str4;
        this.timezone = str5;
        this.mcuFirmware = str6;
        this.mac = str7;
        this.aimSerialNumber = str8;
        this.aimUpdateDate = l;
    }

    public final String getCompatibility() {
        return this.compatibility;
    }

    public final String getFirmware() {
        return this.firmware;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final String getMcuFirmware() {
        return this.mcuFirmware;
    }

    public final String getMac() {
        return this.mac;
    }

    public final String getAimSerialNumber() {
        return this.aimSerialNumber;
    }

    public final Long getAimUpdateDate() {
        return this.aimUpdateDate;
    }
}
