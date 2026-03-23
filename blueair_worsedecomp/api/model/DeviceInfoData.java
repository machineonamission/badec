package com.blueair.api.model;

import com.blueair.core.model.DeviceDetailsOnAblServer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BÓ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010+\u001a\u00020,J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00107\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00108\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00109\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010:\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010;\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\"JÚ\u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020DHÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001a\u0004\b%\u0010\"R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001a\u0004\b&\u0010\"R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001a\u0004\b'\u0010\"R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001a\u0004\b(\u0010\"R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001a\u0004\b*\u0010\"¨\u0006F"}, d2 = {"Lcom/blueair/api/model/DeviceInfoData;", "", "uuid", "", "name", "timezone", "compatibility", "model", "mac", "firmware", "mcuFirmware", "wlanDriver", "lastSyncDate", "", "installationDate", "lastCalibrationDate", "initUsagePeriod", "rebootPeriod", "refurbDate", "aimSerialNumber", "aimUpdateDate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)V", "getUuid", "()Ljava/lang/String;", "getName", "getTimezone", "getCompatibility", "getModel", "getMac", "getFirmware", "getMcuFirmware", "getWlanDriver", "getLastSyncDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getInstallationDate", "getLastCalibrationDate", "getInitUsagePeriod", "getRebootPeriod", "getRefurbDate", "getAimSerialNumber", "getAimUpdateDate", "toDeviceDetailsOnServer", "Lcom/blueair/core/model/DeviceDetailsOnAblServer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)Lcom/blueair/api/model/DeviceInfoData;", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceInfoData.kt */
public final class DeviceInfoData {
    private final String aimSerialNumber;
    private final Long aimUpdateDate;
    private final String compatibility;
    private final String firmware;
    private final Long initUsagePeriod;
    private final Long installationDate;
    private final Long lastCalibrationDate;
    private final Long lastSyncDate;
    private final String mac;
    private final String mcuFirmware;
    private final String model;
    private final String name;
    private final Long rebootPeriod;
    private final Long refurbDate;
    private final String timezone;
    private final String uuid;
    private final String wlanDriver;

    public DeviceInfoData() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Long) null, (Long) null, (Long) null, (Long) null, (Long) null, (Long) null, (String) null, (Long) null, 131071, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DeviceInfoData copy$default(DeviceInfoData deviceInfoData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, String str10, Long l7, int i, Object obj) {
        Long l8;
        String str11;
        Long l9;
        Long l10;
        Long l11;
        Long l12;
        Long l13;
        Long l14;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        DeviceInfoData deviceInfoData2;
        DeviceInfoData deviceInfoData3 = deviceInfoData;
        int i2 = i;
        String str21 = (i2 & 1) != 0 ? deviceInfoData3.uuid : str;
        String str22 = (i2 & 2) != 0 ? deviceInfoData3.name : str2;
        String str23 = (i2 & 4) != 0 ? deviceInfoData3.timezone : str3;
        String str24 = (i2 & 8) != 0 ? deviceInfoData3.compatibility : str4;
        String str25 = (i2 & 16) != 0 ? deviceInfoData3.model : str5;
        String str26 = (i2 & 32) != 0 ? deviceInfoData3.mac : str6;
        String str27 = (i2 & 64) != 0 ? deviceInfoData3.firmware : str7;
        String str28 = (i2 & 128) != 0 ? deviceInfoData3.mcuFirmware : str8;
        String str29 = (i2 & 256) != 0 ? deviceInfoData3.wlanDriver : str9;
        Long l15 = (i2 & 512) != 0 ? deviceInfoData3.lastSyncDate : l;
        Long l16 = (i2 & 1024) != 0 ? deviceInfoData3.installationDate : l2;
        Long l17 = (i2 & 2048) != 0 ? deviceInfoData3.lastCalibrationDate : l3;
        Long l18 = (i2 & 4096) != 0 ? deviceInfoData3.initUsagePeriod : l4;
        Long l19 = (i2 & 8192) != 0 ? deviceInfoData3.rebootPeriod : l5;
        String str30 = str21;
        Long l20 = (i2 & 16384) != 0 ? deviceInfoData3.refurbDate : l6;
        String str31 = (i2 & 32768) != 0 ? deviceInfoData3.aimSerialNumber : str10;
        if ((i & 65536) != 0) {
            str11 = str31;
            l8 = deviceInfoData3.aimUpdateDate;
            l9 = l20;
            str19 = str22;
            str18 = str23;
            str17 = str24;
            str16 = str25;
            str15 = str26;
            str14 = str27;
            str13 = str28;
            str12 = str29;
            l14 = l15;
            l13 = l16;
            l12 = l17;
            l11 = l18;
            l10 = l19;
            str20 = str30;
            deviceInfoData2 = deviceInfoData3;
        } else {
            l8 = l7;
            str11 = str31;
            str20 = str30;
            deviceInfoData2 = deviceInfoData3;
            l9 = l20;
            str19 = str22;
            str18 = str23;
            str17 = str24;
            str16 = str25;
            str15 = str26;
            str14 = str27;
            str13 = str28;
            str12 = str29;
            l14 = l15;
            l13 = l16;
            l12 = l17;
            l11 = l18;
            l10 = l19;
        }
        return deviceInfoData2.copy(str20, str19, str18, str17, str16, str15, str14, str13, str12, l14, l13, l12, l11, l10, l9, str11, l8);
    }

    public final String component1() {
        return this.uuid;
    }

    public final Long component10() {
        return this.lastSyncDate;
    }

    public final Long component11() {
        return this.installationDate;
    }

    public final Long component12() {
        return this.lastCalibrationDate;
    }

    public final Long component13() {
        return this.initUsagePeriod;
    }

    public final Long component14() {
        return this.rebootPeriod;
    }

    public final Long component15() {
        return this.refurbDate;
    }

    public final String component16() {
        return this.aimSerialNumber;
    }

    public final Long component17() {
        return this.aimUpdateDate;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.timezone;
    }

    public final String component4() {
        return this.compatibility;
    }

    public final String component5() {
        return this.model;
    }

    public final String component6() {
        return this.mac;
    }

    public final String component7() {
        return this.firmware;
    }

    public final String component8() {
        return this.mcuFirmware;
    }

    public final String component9() {
        return this.wlanDriver;
    }

    public final DeviceInfoData copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, String str10, Long l7) {
        return new DeviceInfoData(str, str2, str3, str4, str5, str6, str7, str8, str9, l, l2, l3, l4, l5, l6, str10, l7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfoData)) {
            return false;
        }
        DeviceInfoData deviceInfoData = (DeviceInfoData) obj;
        return Intrinsics.areEqual((Object) this.uuid, (Object) deviceInfoData.uuid) && Intrinsics.areEqual((Object) this.name, (Object) deviceInfoData.name) && Intrinsics.areEqual((Object) this.timezone, (Object) deviceInfoData.timezone) && Intrinsics.areEqual((Object) this.compatibility, (Object) deviceInfoData.compatibility) && Intrinsics.areEqual((Object) this.model, (Object) deviceInfoData.model) && Intrinsics.areEqual((Object) this.mac, (Object) deviceInfoData.mac) && Intrinsics.areEqual((Object) this.firmware, (Object) deviceInfoData.firmware) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceInfoData.mcuFirmware) && Intrinsics.areEqual((Object) this.wlanDriver, (Object) deviceInfoData.wlanDriver) && Intrinsics.areEqual((Object) this.lastSyncDate, (Object) deviceInfoData.lastSyncDate) && Intrinsics.areEqual((Object) this.installationDate, (Object) deviceInfoData.installationDate) && Intrinsics.areEqual((Object) this.lastCalibrationDate, (Object) deviceInfoData.lastCalibrationDate) && Intrinsics.areEqual((Object) this.initUsagePeriod, (Object) deviceInfoData.initUsagePeriod) && Intrinsics.areEqual((Object) this.rebootPeriod, (Object) deviceInfoData.rebootPeriod) && Intrinsics.areEqual((Object) this.refurbDate, (Object) deviceInfoData.refurbDate) && Intrinsics.areEqual((Object) this.aimSerialNumber, (Object) deviceInfoData.aimSerialNumber) && Intrinsics.areEqual((Object) this.aimUpdateDate, (Object) deviceInfoData.aimUpdateDate);
    }

    public int hashCode() {
        String str = this.uuid;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.timezone;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.compatibility;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.model;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.mac;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.firmware;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.mcuFirmware;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.wlanDriver;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Long l = this.lastSyncDate;
        int hashCode10 = (hashCode9 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.installationDate;
        int hashCode11 = (hashCode10 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.lastCalibrationDate;
        int hashCode12 = (hashCode11 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.initUsagePeriod;
        int hashCode13 = (hashCode12 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Long l5 = this.rebootPeriod;
        int hashCode14 = (hashCode13 + (l5 == null ? 0 : l5.hashCode())) * 31;
        Long l6 = this.refurbDate;
        int hashCode15 = (hashCode14 + (l6 == null ? 0 : l6.hashCode())) * 31;
        String str10 = this.aimSerialNumber;
        int hashCode16 = (hashCode15 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Long l7 = this.aimUpdateDate;
        if (l7 != null) {
            i = l7.hashCode();
        }
        return hashCode16 + i;
    }

    public String toString() {
        return "DeviceInfoData(uuid=" + this.uuid + ", name=" + this.name + ", timezone=" + this.timezone + ", compatibility=" + this.compatibility + ", model=" + this.model + ", mac=" + this.mac + ", firmware=" + this.firmware + ", mcuFirmware=" + this.mcuFirmware + ", wlanDriver=" + this.wlanDriver + ", lastSyncDate=" + this.lastSyncDate + ", installationDate=" + this.installationDate + ", lastCalibrationDate=" + this.lastCalibrationDate + ", initUsagePeriod=" + this.initUsagePeriod + ", rebootPeriod=" + this.rebootPeriod + ", refurbDate=" + this.refurbDate + ", aimSerialNumber=" + this.aimSerialNumber + ", aimUpdateDate=" + this.aimUpdateDate + ')';
    }

    public DeviceInfoData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, String str10, Long l7) {
        this.uuid = str;
        this.name = str2;
        this.timezone = str3;
        this.compatibility = str4;
        this.model = str5;
        this.mac = str6;
        this.firmware = str7;
        this.mcuFirmware = str8;
        this.wlanDriver = str9;
        this.lastSyncDate = l;
        this.installationDate = l2;
        this.lastCalibrationDate = l3;
        this.initUsagePeriod = l4;
        this.rebootPeriod = l5;
        this.refurbDate = l6;
        this.aimSerialNumber = str10;
        this.aimUpdateDate = l7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceInfoData(java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.Long r28, java.lang.Long r29, java.lang.Long r30, java.lang.Long r31, java.lang.Long r32, java.lang.Long r33, java.lang.String r34, java.lang.Long r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
        /*
            r18 = this;
            r0 = r36
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r19
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r20
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r21
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r22
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r23
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r24
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r25
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r26
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r27
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r28
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r29
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r30
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r31
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r32
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r33
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r34
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r17
            if (r0 == 0) goto L_0x008f
            r36 = 0
            goto L_0x0091
        L_0x008f:
            r36 = r35
        L_0x0091:
            r19 = r18
            r20 = r1
            r34 = r2
            r21 = r3
            r22 = r4
            r23 = r5
            r24 = r6
            r25 = r7
            r26 = r8
            r27 = r9
            r28 = r10
            r29 = r11
            r30 = r12
            r31 = r13
            r32 = r14
            r33 = r15
            r35 = r16
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.model.DeviceInfoData.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.String, java.lang.Long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final String getCompatibility() {
        return this.compatibility;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getMac() {
        return this.mac;
    }

    public final String getFirmware() {
        return this.firmware;
    }

    public final String getMcuFirmware() {
        return this.mcuFirmware;
    }

    public final String getWlanDriver() {
        return this.wlanDriver;
    }

    public final Long getLastSyncDate() {
        return this.lastSyncDate;
    }

    public final Long getInstallationDate() {
        return this.installationDate;
    }

    public final Long getLastCalibrationDate() {
        return this.lastCalibrationDate;
    }

    public final Long getInitUsagePeriod() {
        return this.initUsagePeriod;
    }

    public final Long getRebootPeriod() {
        return this.rebootPeriod;
    }

    public final Long getRefurbDate() {
        return this.refurbDate;
    }

    public final String getAimSerialNumber() {
        return this.aimSerialNumber;
    }

    public final Long getAimUpdateDate() {
        return this.aimUpdateDate;
    }

    public final DeviceDetailsOnAblServer toDeviceDetailsOnServer() {
        String str = this.compatibility;
        String str2 = this.firmware;
        String str3 = this.name;
        String str4 = this.uuid;
        Intrinsics.checkNotNull(str4);
        return new DeviceDetailsOnAblServer(str, str2, str3, str4, this.timezone, this.mcuFirmware, this.mac, this.aimSerialNumber, this.aimUpdateDate);
    }
}
