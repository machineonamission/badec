package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.Device;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b4\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B¯\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\t\u0010/\u001a\u00020\u0004HÆ\u0003J\t\u00100\u001a\u00020\u0004HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\t\u00103\u001a\u00020\fHÆ\u0003J\t\u00104\u001a\u00020\u0004HÆ\u0003J\t\u00105\u001a\u00020\u0004HÆ\u0003J\t\u00106\u001a\u00020\u0004HÆ\u0003J\t\u00107\u001a\u00020\u0004HÆ\u0003J\t\u00108\u001a\u00020\u0004HÆ\u0003J\t\u00109\u001a\u00020\u0004HÆ\u0003J\t\u0010:\u001a\u00020\u0004HÆ\u0003J\t\u0010;\u001a\u00020\u0004HÆ\u0003J\t\u0010<\u001a\u00020\u0004HÆ\u0003J\t\u0010=\u001a\u00020\tHÆ\u0003Jµ\u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\tHÆ\u0001J\u0006\u0010?\u001a\u00020\tJ\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020\tHÖ\u0001J\t\u0010E\u001a\u00020\u0004HÖ\u0001J\u0016\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\tR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\n\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0014\u0010\u000e\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0014\u0010\u000f\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0014\u0010\u0010\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0014\u0010\u0011\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0014\u0010\u0012\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0014\u0010\u0013\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0014\u0010\u0014\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0014\u0010\u0015\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0014\u0010\u0016\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001f¨\u0006K"}, d2 = {"Lcom/blueair/core/model/DeviceUnknown;", "Lcom/blueair/core/model/HasSKU;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "sku", "", "uid", "name", "modelName", "typeIndex", "", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "updateProgress", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getSku", "()Ljava/lang/String;", "getUid", "getName", "getModelName", "getTypeIndex", "()I", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getUpdateProgress", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public final class DeviceUnknown implements HasSKU, HasBlueCloudFunctions {
    public static final Parcelable.Creator<DeviceUnknown> CREATOR = new Creator();
    private final int connectivityStatusIndex;
    private final String dealerCountry;
    private final String dealerName;
    private final String hardware;
    private final long lastConnectivityInMillis;
    private final String mac;
    private final String mcuFirmware;
    private final String modelName;
    private final String name;
    private final String purchaseDate;
    private final String serial;
    private final String sku;
    private final String timeZone;
    private final int typeIndex;
    private final String uid;
    private final int updateProgress;
    private final String wifiFirmware;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class Creator implements Parcelable.Creator<DeviceUnknown> {
        public final DeviceUnknown createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DeviceUnknown(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        public final DeviceUnknown[] newArray(int i) {
            return new DeviceUnknown[i];
        }
    }

    public static /* synthetic */ DeviceUnknown copy$default(DeviceUnknown deviceUnknown, String str, String str2, String str3, String str4, int i, int i2, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i3, int i4, Object obj) {
        int i5;
        String str14;
        DeviceUnknown deviceUnknown2 = deviceUnknown;
        int i6 = i4;
        String str15 = (i6 & 1) != 0 ? deviceUnknown2.sku : str;
        String str16 = (i6 & 2) != 0 ? deviceUnknown2.uid : str2;
        String str17 = (i6 & 4) != 0 ? deviceUnknown2.name : str3;
        String str18 = (i6 & 8) != 0 ? deviceUnknown2.modelName : str4;
        int i7 = (i6 & 16) != 0 ? deviceUnknown2.typeIndex : i;
        int i8 = (i6 & 32) != 0 ? deviceUnknown2.connectivityStatusIndex : i2;
        long j2 = (i6 & 64) != 0 ? deviceUnknown2.lastConnectivityInMillis : j;
        String str19 = (i6 & 128) != 0 ? deviceUnknown2.mac : str5;
        String str20 = (i6 & 256) != 0 ? deviceUnknown2.mcuFirmware : str6;
        String str21 = (i6 & 512) != 0 ? deviceUnknown2.wifiFirmware : str7;
        String str22 = (i6 & 1024) != 0 ? deviceUnknown2.hardware : str8;
        String str23 = (i6 & 2048) != 0 ? deviceUnknown2.timeZone : str9;
        String str24 = (i6 & 4096) != 0 ? deviceUnknown2.serial : str10;
        String str25 = str15;
        String str26 = (i6 & 8192) != 0 ? deviceUnknown2.purchaseDate : str11;
        String str27 = (i6 & 16384) != 0 ? deviceUnknown2.dealerName : str12;
        String str28 = (i6 & 32768) != 0 ? deviceUnknown2.dealerCountry : str13;
        if ((i4 & 65536) != 0) {
            str14 = str28;
            i5 = deviceUnknown2.updateProgress;
        } else {
            i5 = i3;
            str14 = str28;
        }
        return deviceUnknown2.copy(str25, str16, str17, str18, i7, i8, j2, str19, str20, str21, str22, str23, str24, str26, str27, str14, i5);
    }

    public final String component1() {
        return this.sku;
    }

    public final String component10() {
        return this.wifiFirmware;
    }

    public final String component11() {
        return this.hardware;
    }

    public final String component12() {
        return this.timeZone;
    }

    public final String component13() {
        return this.serial;
    }

    public final String component14() {
        return this.purchaseDate;
    }

    public final String component15() {
        return this.dealerName;
    }

    public final String component16() {
        return this.dealerCountry;
    }

    public final int component17() {
        return this.updateProgress;
    }

    public final String component2() {
        return this.uid;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.modelName;
    }

    public final int component5() {
        return this.typeIndex;
    }

    public final int component6() {
        return this.connectivityStatusIndex;
    }

    public final long component7() {
        return this.lastConnectivityInMillis;
    }

    public final String component8() {
        return this.mac;
    }

    public final String component9() {
        return this.mcuFirmware;
    }

    public final DeviceUnknown copy(String str, String str2, String str3, String str4, int i, int i2, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i3) {
        String str14 = str2;
        Intrinsics.checkNotNullParameter(str14, "uid");
        String str15 = str3;
        Intrinsics.checkNotNullParameter(str15, "name");
        String str16 = str4;
        Intrinsics.checkNotNullParameter(str16, "modelName");
        String str17 = str5;
        Intrinsics.checkNotNullParameter(str17, AnalyticEvent.KEY_MAC);
        String str18 = str6;
        Intrinsics.checkNotNullParameter(str18, "mcuFirmware");
        String str19 = str7;
        Intrinsics.checkNotNullParameter(str19, "wifiFirmware");
        String str20 = str8;
        Intrinsics.checkNotNullParameter(str20, "hardware");
        String str21 = str9;
        Intrinsics.checkNotNullParameter(str21, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        String str22 = str10;
        Intrinsics.checkNotNullParameter(str22, "serial");
        Intrinsics.checkNotNullParameter(str11, "purchaseDate");
        String str23 = str12;
        Intrinsics.checkNotNullParameter(str23, "dealerName");
        String str24 = str13;
        Intrinsics.checkNotNullParameter(str24, "dealerCountry");
        String str25 = str23;
        String str26 = str24;
        return new DeviceUnknown(str, str14, str15, str16, i, i2, j, str17, str18, str19, str20, str21, str22, str11, str25, str26, i3);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceUnknown)) {
            return false;
        }
        DeviceUnknown deviceUnknown = (DeviceUnknown) obj;
        return Intrinsics.areEqual((Object) this.sku, (Object) deviceUnknown.sku) && Intrinsics.areEqual((Object) this.uid, (Object) deviceUnknown.uid) && Intrinsics.areEqual((Object) this.name, (Object) deviceUnknown.name) && Intrinsics.areEqual((Object) this.modelName, (Object) deviceUnknown.modelName) && this.typeIndex == deviceUnknown.typeIndex && this.connectivityStatusIndex == deviceUnknown.connectivityStatusIndex && this.lastConnectivityInMillis == deviceUnknown.lastConnectivityInMillis && Intrinsics.areEqual((Object) this.mac, (Object) deviceUnknown.mac) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceUnknown.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) deviceUnknown.wifiFirmware) && Intrinsics.areEqual((Object) this.hardware, (Object) deviceUnknown.hardware) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceUnknown.timeZone) && Intrinsics.areEqual((Object) this.serial, (Object) deviceUnknown.serial) && Intrinsics.areEqual((Object) this.purchaseDate, (Object) deviceUnknown.purchaseDate) && Intrinsics.areEqual((Object) this.dealerName, (Object) deviceUnknown.dealerName) && Intrinsics.areEqual((Object) this.dealerCountry, (Object) deviceUnknown.dealerCountry) && this.updateProgress == deviceUnknown.updateProgress;
    }

    public int hashCode() {
        String str = this.sku;
        return ((((((((((((((((((((((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.uid.hashCode()) * 31) + this.name.hashCode()) * 31) + this.modelName.hashCode()) * 31) + this.typeIndex) * 31) + this.connectivityStatusIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis)) * 31) + this.mac.hashCode()) * 31) + this.mcuFirmware.hashCode()) * 31) + this.wifiFirmware.hashCode()) * 31) + this.hardware.hashCode()) * 31) + this.timeZone.hashCode()) * 31) + this.serial.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31) + this.dealerName.hashCode()) * 31) + this.dealerCountry.hashCode()) * 31) + this.updateProgress;
    }

    public String toString() {
        return "DeviceUnknown(sku=" + this.sku + ", uid=" + this.uid + ", name=" + this.name + ", modelName=" + this.modelName + ", typeIndex=" + this.typeIndex + ", connectivityStatusIndex=" + this.connectivityStatusIndex + ", lastConnectivityInMillis=" + this.lastConnectivityInMillis + ", mac=" + this.mac + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmware=" + this.wifiFirmware + ", hardware=" + this.hardware + ", timeZone=" + this.timeZone + ", serial=" + this.serial + ", purchaseDate=" + this.purchaseDate + ", dealerName=" + this.dealerName + ", dealerCountry=" + this.dealerCountry + ", updateProgress=" + this.updateProgress + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.sku);
        parcel.writeString(this.uid);
        parcel.writeString(this.name);
        parcel.writeString(this.modelName);
        parcel.writeInt(this.typeIndex);
        parcel.writeInt(this.connectivityStatusIndex);
        parcel.writeLong(this.lastConnectivityInMillis);
        parcel.writeString(this.mac);
        parcel.writeString(this.mcuFirmware);
        parcel.writeString(this.wifiFirmware);
        parcel.writeString(this.hardware);
        parcel.writeString(this.timeZone);
        parcel.writeString(this.serial);
        parcel.writeString(this.purchaseDate);
        parcel.writeString(this.dealerName);
        parcel.writeString(this.dealerCountry);
        parcel.writeInt(this.updateProgress);
    }

    public ConnectivityStatus getConnectivityStatus() {
        return Device.CC.$default$getConnectivityStatus(this);
    }

    public TimeZone getTimezone(Context context) {
        return Device.CC.$default$getTimezone(this, context);
    }

    public DeviceType getType() {
        return Device.CC.$default$getType(this);
    }

    public boolean isOnline() {
        return Device.CC.$default$isOnline(this);
    }

    public boolean isUsDevice() {
        return Device.CC.$default$isUsDevice(this);
    }

    public DeviceUnknown(String str, String str2, String str3, String str4, int i, int i2, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i3) {
        String str14 = str5;
        String str15 = str6;
        String str16 = str7;
        String str17 = str8;
        String str18 = str9;
        String str19 = str10;
        String str20 = str11;
        String str21 = str12;
        String str22 = str13;
        Intrinsics.checkNotNullParameter(str2, "uid");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, "modelName");
        Intrinsics.checkNotNullParameter(str14, AnalyticEvent.KEY_MAC);
        Intrinsics.checkNotNullParameter(str15, "mcuFirmware");
        Intrinsics.checkNotNullParameter(str16, "wifiFirmware");
        Intrinsics.checkNotNullParameter(str17, "hardware");
        Intrinsics.checkNotNullParameter(str18, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        Intrinsics.checkNotNullParameter(str19, "serial");
        Intrinsics.checkNotNullParameter(str20, "purchaseDate");
        Intrinsics.checkNotNullParameter(str21, "dealerName");
        Intrinsics.checkNotNullParameter(str22, "dealerCountry");
        this.sku = str;
        this.uid = str2;
        this.name = str3;
        this.modelName = str4;
        this.typeIndex = i;
        this.connectivityStatusIndex = i2;
        this.lastConnectivityInMillis = j;
        this.mac = str14;
        this.mcuFirmware = str15;
        this.wifiFirmware = str16;
        this.hardware = str17;
        this.timeZone = str18;
        this.serial = str19;
        this.purchaseDate = str20;
        this.dealerName = str21;
        this.dealerCountry = str22;
        this.updateProgress = i3;
    }

    public String getSku() {
        return this.sku;
    }

    public String getUid() {
        return this.uid;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceUnknown(java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, int r26, int r27, long r28, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, int r39, int r40, kotlin.jvm.internal.DefaultConstructorMarker r41) {
        /*
            r21 = this;
            r0 = r40
            r1 = r0 & 4
            if (r1 == 0) goto L_0x000e
            com.blueair.core.model.DeviceType$Unknown r1 = com.blueair.core.model.DeviceType.Unknown.INSTANCE
            java.lang.String r1 = r1.getName()
            r5 = r1
            goto L_0x0010
        L_0x000e:
            r5 = r24
        L_0x0010:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x001c
            com.blueair.core.model.DeviceType$Unknown r1 = com.blueair.core.model.DeviceType.Unknown.INSTANCE
            java.lang.String r1 = r1.getName()
            r6 = r1
            goto L_0x001e
        L_0x001c:
            r6 = r25
        L_0x001e:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x002a
            com.blueair.core.model.DeviceType$Unknown r1 = com.blueair.core.model.DeviceType.Unknown.INSTANCE
            int r1 = r1.getIndex()
            r7 = r1
            goto L_0x002c
        L_0x002a:
            r7 = r26
        L_0x002c:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0038
            com.blueair.core.model.ConnectivityStatus r1 = com.blueair.core.model.ConnectivityStatus.ONLINE
            int r1 = r1.ordinal()
            r8 = r1
            goto L_0x003a
        L_0x0038:
            r8 = r27
        L_0x003a:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0042
            r1 = 0
            r9 = r1
            goto L_0x0044
        L_0x0042:
            r9 = r28
        L_0x0044:
            r1 = r0 & 128(0x80, float:1.794E-43)
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x004c
            r11 = r2
            goto L_0x004e
        L_0x004c:
            r11 = r30
        L_0x004e:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0054
            r12 = r2
            goto L_0x0056
        L_0x0054:
            r12 = r31
        L_0x0056:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x005c
            r13 = r2
            goto L_0x005e
        L_0x005c:
            r13 = r32
        L_0x005e:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0064
            r14 = r2
            goto L_0x0066
        L_0x0064:
            r14 = r33
        L_0x0066:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x006c
            r15 = r2
            goto L_0x006e
        L_0x006c:
            r15 = r34
        L_0x006e:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0075
            r16 = r2
            goto L_0x0077
        L_0x0075:
            r16 = r35
        L_0x0077:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x007e
            r17 = r2
            goto L_0x0080
        L_0x007e:
            r17 = r36
        L_0x0080:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0087
            r18 = r2
            goto L_0x0089
        L_0x0087:
            r18 = r37
        L_0x0089:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0092
            r19 = r2
            goto L_0x0094
        L_0x0092:
            r19 = r38
        L_0x0094:
            r1 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x009d
            r0 = 0
            r20 = r0
            goto L_0x009f
        L_0x009d:
            r20 = r39
        L_0x009f:
            r2 = r21
            r3 = r22
            r4 = r23
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceUnknown.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public String getName() {
        return this.name;
    }

    public String getModelName() {
        return this.modelName;
    }

    public int getTypeIndex() {
        return this.typeIndex;
    }

    public int getConnectivityStatusIndex() {
        return this.connectivityStatusIndex;
    }

    public long getLastConnectivityInMillis() {
        return this.lastConnectivityInMillis;
    }

    public String getMac() {
        return this.mac;
    }

    public String getMcuFirmware() {
        return this.mcuFirmware;
    }

    public String getWifiFirmware() {
        return this.wifiFirmware;
    }

    public String getHardware() {
        return this.hardware;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public String getSerial() {
        return this.serial;
    }

    public String getPurchaseDate() {
        return this.purchaseDate;
    }

    public String getDealerName() {
        return this.dealerName;
    }

    public String getDealerCountry() {
        return this.dealerCountry;
    }

    public int getUpdateProgress() {
        return this.updateProgress;
    }
}
