package com.blueair.devicemanager;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jg\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015¨\u00061"}, d2 = {"Lcom/blueair/devicemanager/IcpDeviceInfo;", "", "device", "Lcom/blueair/devicemanager/IcpDevice;", "firmwareChildMain", "", "firmwareChildPlug", "firmwareRevision", "hardwareRevision", "macAddress", "manufacturerName", "serialNumber", "<init>", "(Lcom/blueair/devicemanager/IcpDevice;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDevice", "()Lcom/blueair/devicemanager/IcpDevice;", "setDevice", "(Lcom/blueair/devicemanager/IcpDevice;)V", "getFirmwareChildMain", "()Ljava/lang/String;", "setFirmwareChildMain", "(Ljava/lang/String;)V", "getFirmwareChildPlug", "setFirmwareChildPlug", "getFirmwareRevision", "setFirmwareRevision", "getHardwareRevision", "setHardwareRevision", "getMacAddress", "setMacAddress", "getManufacturerName", "setManufacturerName", "getSerialNumber", "setSerialNumber", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "devicemanager_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: IcpDeviceManager.kt */
public final class IcpDeviceInfo {
    private IcpDevice device;
    private String firmwareChildMain;
    private String firmwareChildPlug;
    private String firmwareRevision;
    private String hardwareRevision;
    private String macAddress;
    private String manufacturerName;
    private String serialNumber;

    public static /* synthetic */ IcpDeviceInfo copy$default(IcpDeviceInfo icpDeviceInfo, IcpDevice icpDevice, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            icpDevice = icpDeviceInfo.device;
        }
        if ((i & 2) != 0) {
            str = icpDeviceInfo.firmwareChildMain;
        }
        if ((i & 4) != 0) {
            str2 = icpDeviceInfo.firmwareChildPlug;
        }
        if ((i & 8) != 0) {
            str3 = icpDeviceInfo.firmwareRevision;
        }
        if ((i & 16) != 0) {
            str4 = icpDeviceInfo.hardwareRevision;
        }
        if ((i & 32) != 0) {
            str5 = icpDeviceInfo.macAddress;
        }
        if ((i & 64) != 0) {
            str6 = icpDeviceInfo.manufacturerName;
        }
        if ((i & 128) != 0) {
            str7 = icpDeviceInfo.serialNumber;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str4;
        String str11 = str5;
        String str12 = str3;
        String str13 = str;
        return icpDeviceInfo.copy(icpDevice, str13, str2, str12, str10, str11, str8, str9);
    }

    public final IcpDevice component1() {
        return this.device;
    }

    public final String component2() {
        return this.firmwareChildMain;
    }

    public final String component3() {
        return this.firmwareChildPlug;
    }

    public final String component4() {
        return this.firmwareRevision;
    }

    public final String component5() {
        return this.hardwareRevision;
    }

    public final String component6() {
        return this.macAddress;
    }

    public final String component7() {
        return this.manufacturerName;
    }

    public final String component8() {
        return this.serialNumber;
    }

    public final IcpDeviceInfo copy(IcpDevice icpDevice, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(icpDevice, "device");
        return new IcpDeviceInfo(icpDevice, str, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IcpDeviceInfo)) {
            return false;
        }
        IcpDeviceInfo icpDeviceInfo = (IcpDeviceInfo) obj;
        return Intrinsics.areEqual((Object) this.device, (Object) icpDeviceInfo.device) && Intrinsics.areEqual((Object) this.firmwareChildMain, (Object) icpDeviceInfo.firmwareChildMain) && Intrinsics.areEqual((Object) this.firmwareChildPlug, (Object) icpDeviceInfo.firmwareChildPlug) && Intrinsics.areEqual((Object) this.firmwareRevision, (Object) icpDeviceInfo.firmwareRevision) && Intrinsics.areEqual((Object) this.hardwareRevision, (Object) icpDeviceInfo.hardwareRevision) && Intrinsics.areEqual((Object) this.macAddress, (Object) icpDeviceInfo.macAddress) && Intrinsics.areEqual((Object) this.manufacturerName, (Object) icpDeviceInfo.manufacturerName) && Intrinsics.areEqual((Object) this.serialNumber, (Object) icpDeviceInfo.serialNumber);
    }

    public int hashCode() {
        int hashCode = this.device.hashCode() * 31;
        String str = this.firmwareChildMain;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.firmwareChildPlug;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.firmwareRevision;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.hardwareRevision;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.macAddress;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.manufacturerName;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.serialNumber;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "IcpDeviceInfo(device=" + this.device + ", firmwareChildMain=" + this.firmwareChildMain + ", firmwareChildPlug=" + this.firmwareChildPlug + ", firmwareRevision=" + this.firmwareRevision + ", hardwareRevision=" + this.hardwareRevision + ", macAddress=" + this.macAddress + ", manufacturerName=" + this.manufacturerName + ", serialNumber=" + this.serialNumber + ')';
    }

    public IcpDeviceInfo(IcpDevice icpDevice, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(icpDevice, "device");
        this.device = icpDevice;
        this.firmwareChildMain = str;
        this.firmwareChildPlug = str2;
        this.firmwareRevision = str3;
        this.hardwareRevision = str4;
        this.macAddress = str5;
        this.manufacturerName = str6;
        this.serialNumber = str7;
    }

    public final IcpDevice getDevice() {
        return this.device;
    }

    public final void setDevice(IcpDevice icpDevice) {
        Intrinsics.checkNotNullParameter(icpDevice, "<set-?>");
        this.device = icpDevice;
    }

    public final String getFirmwareChildMain() {
        return this.firmwareChildMain;
    }

    public final void setFirmwareChildMain(String str) {
        this.firmwareChildMain = str;
    }

    public final String getFirmwareChildPlug() {
        return this.firmwareChildPlug;
    }

    public final void setFirmwareChildPlug(String str) {
        this.firmwareChildPlug = str;
    }

    public final String getFirmwareRevision() {
        return this.firmwareRevision;
    }

    public final void setFirmwareRevision(String str) {
        this.firmwareRevision = str;
    }

    public final String getHardwareRevision() {
        return this.hardwareRevision;
    }

    public final void setHardwareRevision(String str) {
        this.hardwareRevision = str;
    }

    public final String getMacAddress() {
        return this.macAddress;
    }

    public final void setMacAddress(String str) {
        this.macAddress = str;
    }

    public final String getManufacturerName() {
        return this.manufacturerName;
    }

    public final void setManufacturerName(String str) {
        this.manufacturerName = str;
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final void setSerialNumber(String str) {
        this.serialNumber = str;
    }
}
