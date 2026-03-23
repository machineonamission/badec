package com.blueair.api.restapi;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0001\u0010'\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b¨\u0006."}, d2 = {"Lcom/blueair/api/restapi/ConfigurationDeviceInfo;", "", "macAddress", "", "mcuFirmware", "wifiFirmware", "overallFirmware", "name", "type", "serialNumber", "hardware", "sensorRanges", "ywrmEnable", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getMacAddress", "()Ljava/lang/String;", "getMcuFirmware", "getWifiFirmware", "getOverallFirmware", "getName", "getType", "getSerialNumber", "getHardware", "getSensorRanges", "getYwrmEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/blueair/api/restapi/ConfigurationDeviceInfo;", "equals", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class ConfigurationDeviceInfo {
    private final String hardware;
    private final String macAddress;
    private final String mcuFirmware;
    private final String name;
    private final String overallFirmware;
    private final String sensorRanges;
    private final String serialNumber;
    private final String type;
    private final String wifiFirmware;
    private final Boolean ywrmEnable;

    public static /* synthetic */ ConfigurationDeviceInfo copy$default(ConfigurationDeviceInfo configurationDeviceInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = configurationDeviceInfo.macAddress;
        }
        if ((i & 2) != 0) {
            str2 = configurationDeviceInfo.mcuFirmware;
        }
        if ((i & 4) != 0) {
            str3 = configurationDeviceInfo.wifiFirmware;
        }
        if ((i & 8) != 0) {
            str4 = configurationDeviceInfo.overallFirmware;
        }
        if ((i & 16) != 0) {
            str5 = configurationDeviceInfo.name;
        }
        if ((i & 32) != 0) {
            str6 = configurationDeviceInfo.type;
        }
        if ((i & 64) != 0) {
            str7 = configurationDeviceInfo.serialNumber;
        }
        if ((i & 128) != 0) {
            str8 = configurationDeviceInfo.hardware;
        }
        if ((i & 256) != 0) {
            str9 = configurationDeviceInfo.sensorRanges;
        }
        if ((i & 512) != 0) {
            bool = configurationDeviceInfo.ywrmEnable;
        }
        String str10 = str9;
        Boolean bool2 = bool;
        String str11 = str7;
        String str12 = str8;
        String str13 = str5;
        String str14 = str6;
        String str15 = str4;
        String str16 = str2;
        return configurationDeviceInfo.copy(str, str16, str3, str15, str13, str14, str11, str12, str10, bool2);
    }

    public final String component1() {
        return this.macAddress;
    }

    public final Boolean component10() {
        return this.ywrmEnable;
    }

    public final String component2() {
        return this.mcuFirmware;
    }

    public final String component3() {
        return this.wifiFirmware;
    }

    public final String component4() {
        return this.overallFirmware;
    }

    public final String component5() {
        return this.name;
    }

    public final String component6() {
        return this.type;
    }

    public final String component7() {
        return this.serialNumber;
    }

    public final String component8() {
        return this.hardware;
    }

    public final String component9() {
        return this.sensorRanges;
    }

    public final ConfigurationDeviceInfo copy(@Json(name = "cma") String str, @Json(name = "mfv") String str2, @Json(name = "cfv") String str3, @Json(name = "ofv") String str4, String str5, @Json(name = "sku") String str6, @Json(name = "ds") String str7, @Json(name = "hw") String str8, @Json(name = "aqiranges") String str9, @Json(name = "ywrme") Boolean bool) {
        return new ConfigurationDeviceInfo(str, str2, str3, str4, str5, str6, str7, str8, str9, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigurationDeviceInfo)) {
            return false;
        }
        ConfigurationDeviceInfo configurationDeviceInfo = (ConfigurationDeviceInfo) obj;
        return Intrinsics.areEqual((Object) this.macAddress, (Object) configurationDeviceInfo.macAddress) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) configurationDeviceInfo.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) configurationDeviceInfo.wifiFirmware) && Intrinsics.areEqual((Object) this.overallFirmware, (Object) configurationDeviceInfo.overallFirmware) && Intrinsics.areEqual((Object) this.name, (Object) configurationDeviceInfo.name) && Intrinsics.areEqual((Object) this.type, (Object) configurationDeviceInfo.type) && Intrinsics.areEqual((Object) this.serialNumber, (Object) configurationDeviceInfo.serialNumber) && Intrinsics.areEqual((Object) this.hardware, (Object) configurationDeviceInfo.hardware) && Intrinsics.areEqual((Object) this.sensorRanges, (Object) configurationDeviceInfo.sensorRanges) && Intrinsics.areEqual((Object) this.ywrmEnable, (Object) configurationDeviceInfo.ywrmEnable);
    }

    public int hashCode() {
        String str = this.macAddress;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.mcuFirmware;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.wifiFirmware;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.overallFirmware;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.name;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.type;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.serialNumber;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.hardware;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.sensorRanges;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Boolean bool = this.ywrmEnable;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode9 + i;
    }

    public String toString() {
        return "ConfigurationDeviceInfo(macAddress=" + this.macAddress + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmware=" + this.wifiFirmware + ", overallFirmware=" + this.overallFirmware + ", name=" + this.name + ", type=" + this.type + ", serialNumber=" + this.serialNumber + ", hardware=" + this.hardware + ", sensorRanges=" + this.sensorRanges + ", ywrmEnable=" + this.ywrmEnable + ')';
    }

    public ConfigurationDeviceInfo(@Json(name = "cma") String str, @Json(name = "mfv") String str2, @Json(name = "cfv") String str3, @Json(name = "ofv") String str4, String str5, @Json(name = "sku") String str6, @Json(name = "ds") String str7, @Json(name = "hw") String str8, @Json(name = "aqiranges") String str9, @Json(name = "ywrme") Boolean bool) {
        this.macAddress = str;
        this.mcuFirmware = str2;
        this.wifiFirmware = str3;
        this.overallFirmware = str4;
        this.name = str5;
        this.type = str6;
        this.serialNumber = str7;
        this.hardware = str8;
        this.sensorRanges = str9;
        this.ywrmEnable = bool;
    }

    public final String getMacAddress() {
        return this.macAddress;
    }

    public final String getMcuFirmware() {
        return this.mcuFirmware;
    }

    public final String getWifiFirmware() {
        return this.wifiFirmware;
    }

    public final String getOverallFirmware() {
        return this.overallFirmware;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final String getHardware() {
        return this.hardware;
    }

    public final String getSensorRanges() {
        return this.sensorRanges;
    }

    public final Boolean getYwrmEnable() {
        return this.ywrmEnable;
    }
}
