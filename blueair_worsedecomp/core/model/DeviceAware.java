package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.util.AblWifFirmwareUtils;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Arrays;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0013\n\u0002\bI\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\bBÿ\u0001\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\n\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\n\u0012\b\b\u0002\u0010\u001d\u001a\u00020\n\u0012\b\b\u0002\u0010\u001e\u001a\u00020\n\u0012\b\b\u0002\u0010\u001f\u001a\u00020\n\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\b\b\u0002\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010#\u001a\u00020!\u0012\b\b\u0002\u0010$\u001a\u00020!\u0012\b\b\u0002\u0010%\u001a\u00020!\u0012\b\b\u0002\u0010&\u001a\u00020\r\u0012\b\u0010'\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b(\u0010)J\t\u0010N\u001a\u00020\nHÆ\u0003J\t\u0010O\u001a\u00020\nHÆ\u0003J\t\u0010P\u001a\u00020\rHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010S\u001a\u00020\rHÆ\u0003J\t\u0010T\u001a\u00020\u0013HÆ\u0003J\t\u0010U\u001a\u00020\rHÆ\u0003J\t\u0010V\u001a\u00020\u0016HÆ\u0003J\t\u0010W\u001a\u00020\nHÆ\u0003J\t\u0010X\u001a\u00020\nHÆ\u0003J\t\u0010Y\u001a\u00020\nHÆ\u0003J\t\u0010Z\u001a\u00020\nHÆ\u0003J\t\u0010[\u001a\u00020\nHÆ\u0003J\t\u0010\\\u001a\u00020\nHÆ\u0003J\t\u0010]\u001a\u00020\nHÆ\u0003J\t\u0010^\u001a\u00020\nHÆ\u0003J\t\u0010_\u001a\u00020\nHÆ\u0003J\t\u0010`\u001a\u00020!HÆ\u0003J\t\u0010a\u001a\u00020!HÆ\u0003J\t\u0010b\u001a\u00020!HÆ\u0003J\t\u0010c\u001a\u00020!HÆ\u0003J\t\u0010d\u001a\u00020!HÆ\u0003J\t\u0010e\u001a\u00020\rHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0002\u0010g\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010\u001e\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020!2\b\b\u0002\u0010%\u001a\u00020!2\b\b\u0002\u0010&\u001a\u00020\r2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0006\u0010h\u001a\u00020\rJ\u0013\u0010i\u001a\u00020\u00132\b\u0010j\u001a\u0004\u0018\u00010kHÖ\u0003J\t\u0010l\u001a\u00020\rHÖ\u0001J\t\u0010m\u001a\u00020\nHÖ\u0001J\u0016\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020\rR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0014\u0010\u0011\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010.R\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u00103R\u0014\u0010\u0014\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010.R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0014\u0010\u0017\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010+R\u0014\u0010\u0018\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010+R\u0014\u0010\u0019\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010+R\u0014\u0010\u001a\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010+R\u0014\u0010\u001b\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010+R\u0014\u0010\u001c\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010+R\u0014\u0010\u001d\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010+R\u0014\u0010\u001e\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010+R\u0014\u0010\u001f\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010+R\u0014\u0010 \u001a\u00020!X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0014\u0010\"\u001a\u00020!X\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010AR\u0014\u0010#\u001a\u00020!X\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010AR\u0014\u0010$\u001a\u00020!X\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010AR\u0014\u0010%\u001a\u00020!X\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010AR\u0014\u0010&\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010.R\u0016\u0010'\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010+R\u0014\u0010H\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010+R\u0014\u0010J\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010.R\u0014\u0010L\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\bM\u00103¨\u0006s"}, d2 = {"Lcom/blueair/core/model/DeviceAware;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasAblCloudFunctions;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasNightMode;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasCompatibility;", "uid", "", "name", "brightness", "", "info", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isNightmodeOn", "", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "compatibility", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DILjava/lang/String;)V", "getUid", "()Ljava/lang/String;", "getName", "getBrightness", "()I", "getInfo", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "()Z", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "getCompatibility", "modelName", "getModelName", "typeIndex", "getTypeIndex", "hasAtLeastMinimumFirmwareVersion", "getHasAtLeastMinimumFirmwareVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public final class DeviceAware implements Device, HasBrightness, HasInfo, HasAblCloudFunctions, HasSensorData, HasNightMode, HasScheduling, HasCompatibility {
    public static final Parcelable.Creator<DeviceAware> CREATOR = new Creator();
    private final int brightness;
    private final String compatibility;
    private final int connectivityStatusIndex;
    private final String dealerCountry;
    private final String dealerName;
    private final String hardware;
    private final double[] hchoRanges;
    private final String info;
    private final boolean isNightmodeOn;
    private final long lastConnectivityInMillis;
    private final int lastSelectedSensorTypeIndex;
    private final IndoorDatapoint latestSensorDatapoint;
    private final String mac;
    private final String mcuFirmware;
    private final String modelName;
    private final String name;
    private final double[] pm10Ranges;
    private final double[] pm1Ranges;
    private final double[] pm25Ranges;
    private final String purchaseDate;
    private final String serial;
    private final String timeZone;
    private final int typeIndex;
    private final String uid;
    private final int updateProgress;
    private final double[] vocRanges;
    private final String wifiFirmware;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class Creator implements Parcelable.Creator<DeviceAware> {
        public final DeviceAware createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            return new DeviceAware(parcel2.readString(), parcel2.readString(), parcel2.readInt(), parcel2.readString(), parcel2.readInt() == 0 ? null : IndoorDatapoint.CREATOR.createFromParcel(parcel2), parcel2.readInt(), parcel2.readInt() != 0, parcel2.readInt(), parcel2.readLong(), parcel2.readString(), parcel2.readString(), parcel2.readString(), parcel2.readString(), parcel2.readString(), parcel2.readString(), parcel2.readString(), parcel2.readString(), parcel2.readString(), parcel2.createDoubleArray(), parcel2.createDoubleArray(), parcel2.createDoubleArray(), parcel2.createDoubleArray(), parcel2.createDoubleArray(), parcel2.readInt(), parcel2.readString());
        }

        public final DeviceAware[] newArray(int i) {
            return new DeviceAware[i];
        }
    }

    public static /* synthetic */ DeviceAware copy$default(DeviceAware deviceAware, String str, String str2, int i, String str3, IndoorDatapoint indoorDatapoint, int i2, boolean z, int i3, long j, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i4, String str13, int i5, Object obj) {
        String str14;
        int i6;
        DeviceAware deviceAware2 = deviceAware;
        int i7 = i5;
        String str15 = (i7 & 1) != 0 ? deviceAware2.uid : str;
        String str16 = (i7 & 2) != 0 ? deviceAware2.name : str2;
        int i8 = (i7 & 4) != 0 ? deviceAware2.brightness : i;
        String str17 = (i7 & 8) != 0 ? deviceAware2.info : str3;
        IndoorDatapoint indoorDatapoint2 = (i7 & 16) != 0 ? deviceAware2.latestSensorDatapoint : indoorDatapoint;
        int i9 = (i7 & 32) != 0 ? deviceAware2.lastSelectedSensorTypeIndex : i2;
        boolean z2 = (i7 & 64) != 0 ? deviceAware2.isNightmodeOn : z;
        int i10 = (i7 & 128) != 0 ? deviceAware2.connectivityStatusIndex : i3;
        long j2 = (i7 & 256) != 0 ? deviceAware2.lastConnectivityInMillis : j;
        String str18 = (i7 & 512) != 0 ? deviceAware2.mac : str4;
        String str19 = (i7 & 1024) != 0 ? deviceAware2.mcuFirmware : str5;
        String str20 = (i7 & 2048) != 0 ? deviceAware2.wifiFirmware : str6;
        String str21 = (i7 & 4096) != 0 ? deviceAware2.hardware : str7;
        String str22 = str15;
        String str23 = (i7 & 8192) != 0 ? deviceAware2.timeZone : str8;
        String str24 = (i7 & 16384) != 0 ? deviceAware2.serial : str9;
        String str25 = (i7 & 32768) != 0 ? deviceAware2.purchaseDate : str10;
        String str26 = (i5 & 65536) != 0 ? deviceAware2.dealerName : str11;
        String str27 = (i5 & 131072) != 0 ? deviceAware2.dealerCountry : str12;
        double[] dArr6 = (i5 & 262144) != 0 ? deviceAware2.pm1Ranges : dArr;
        double[] dArr7 = (i5 & 524288) != 0 ? deviceAware2.pm10Ranges : dArr2;
        double[] dArr8 = (i5 & 1048576) != 0 ? deviceAware2.pm25Ranges : dArr3;
        double[] dArr9 = (i5 & 2097152) != 0 ? deviceAware2.vocRanges : dArr4;
        double[] dArr10 = (i5 & 4194304) != 0 ? deviceAware2.hchoRanges : dArr5;
        int i11 = (i5 & 8388608) != 0 ? deviceAware2.updateProgress : i4;
        if ((i5 & 16777216) != 0) {
            i6 = i11;
            str14 = deviceAware2.compatibility;
        } else {
            str14 = str13;
            i6 = i11;
        }
        return deviceAware2.copy(str22, str16, i8, str17, indoorDatapoint2, i9, z2, i10, j2, str18, str19, str20, str21, str23, str24, str25, str26, str27, dArr6, dArr7, dArr8, dArr9, dArr10, i6, str14);
    }

    public final String component1() {
        return this.uid;
    }

    public final String component10() {
        return this.mac;
    }

    public final String component11() {
        return this.mcuFirmware;
    }

    public final String component12() {
        return this.wifiFirmware;
    }

    public final String component13() {
        return this.hardware;
    }

    public final String component14() {
        return this.timeZone;
    }

    public final String component15() {
        return this.serial;
    }

    public final String component16() {
        return this.purchaseDate;
    }

    public final String component17() {
        return this.dealerName;
    }

    public final String component18() {
        return this.dealerCountry;
    }

    public final double[] component19() {
        return this.pm1Ranges;
    }

    public final String component2() {
        return this.name;
    }

    public final double[] component20() {
        return this.pm10Ranges;
    }

    public final double[] component21() {
        return this.pm25Ranges;
    }

    public final double[] component22() {
        return this.vocRanges;
    }

    public final double[] component23() {
        return this.hchoRanges;
    }

    public final int component24() {
        return this.updateProgress;
    }

    public final String component25() {
        return this.compatibility;
    }

    public final int component3() {
        return this.brightness;
    }

    public final String component4() {
        return this.info;
    }

    public final IndoorDatapoint component5() {
        return this.latestSensorDatapoint;
    }

    public final int component6() {
        return this.lastSelectedSensorTypeIndex;
    }

    public final boolean component7() {
        return this.isNightmodeOn;
    }

    public final int component8() {
        return this.connectivityStatusIndex;
    }

    public final long component9() {
        return this.lastConnectivityInMillis;
    }

    public final DeviceAware copy(String str, String str2, int i, String str3, IndoorDatapoint indoorDatapoint, int i2, boolean z, int i3, long j, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i4, String str13) {
        String str14 = str;
        Intrinsics.checkNotNullParameter(str14, "uid");
        String str15 = str2;
        Intrinsics.checkNotNullParameter(str15, "name");
        String str16 = str4;
        Intrinsics.checkNotNullParameter(str16, AnalyticEvent.KEY_MAC);
        String str17 = str5;
        Intrinsics.checkNotNullParameter(str17, "mcuFirmware");
        String str18 = str6;
        Intrinsics.checkNotNullParameter(str18, "wifiFirmware");
        String str19 = str7;
        Intrinsics.checkNotNullParameter(str19, "hardware");
        Intrinsics.checkNotNullParameter(str8, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        String str20 = str9;
        Intrinsics.checkNotNullParameter(str20, "serial");
        String str21 = str10;
        Intrinsics.checkNotNullParameter(str21, "purchaseDate");
        String str22 = str11;
        Intrinsics.checkNotNullParameter(str22, "dealerName");
        String str23 = str12;
        Intrinsics.checkNotNullParameter(str23, "dealerCountry");
        double[] dArr6 = dArr;
        Intrinsics.checkNotNullParameter(dArr6, "pm1Ranges");
        double[] dArr7 = dArr2;
        Intrinsics.checkNotNullParameter(dArr7, "pm10Ranges");
        double[] dArr8 = dArr3;
        Intrinsics.checkNotNullParameter(dArr8, "pm25Ranges");
        double[] dArr9 = dArr4;
        Intrinsics.checkNotNullParameter(dArr9, "vocRanges");
        Intrinsics.checkNotNullParameter(dArr5, "hchoRanges");
        String str24 = str20;
        String str25 = str21;
        String str26 = str22;
        String str27 = str23;
        double[] dArr10 = dArr6;
        double[] dArr11 = dArr7;
        double[] dArr12 = dArr8;
        return new DeviceAware(str14, str15, i, str3, indoorDatapoint, i2, z, i3, j, str16, str17, str18, str19, str8, str24, str25, str26, str27, dArr10, dArr11, dArr12, dArr9, dArr5, i4, str13);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceAware)) {
            return false;
        }
        DeviceAware deviceAware = (DeviceAware) obj;
        return Intrinsics.areEqual((Object) this.uid, (Object) deviceAware.uid) && Intrinsics.areEqual((Object) this.name, (Object) deviceAware.name) && this.brightness == deviceAware.brightness && Intrinsics.areEqual((Object) this.info, (Object) deviceAware.info) && Intrinsics.areEqual((Object) this.latestSensorDatapoint, (Object) deviceAware.latestSensorDatapoint) && this.lastSelectedSensorTypeIndex == deviceAware.lastSelectedSensorTypeIndex && this.isNightmodeOn == deviceAware.isNightmodeOn && this.connectivityStatusIndex == deviceAware.connectivityStatusIndex && this.lastConnectivityInMillis == deviceAware.lastConnectivityInMillis && Intrinsics.areEqual((Object) this.mac, (Object) deviceAware.mac) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceAware.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) deviceAware.wifiFirmware) && Intrinsics.areEqual((Object) this.hardware, (Object) deviceAware.hardware) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceAware.timeZone) && Intrinsics.areEqual((Object) this.serial, (Object) deviceAware.serial) && Intrinsics.areEqual((Object) this.purchaseDate, (Object) deviceAware.purchaseDate) && Intrinsics.areEqual((Object) this.dealerName, (Object) deviceAware.dealerName) && Intrinsics.areEqual((Object) this.dealerCountry, (Object) deviceAware.dealerCountry) && Intrinsics.areEqual((Object) this.pm1Ranges, (Object) deviceAware.pm1Ranges) && Intrinsics.areEqual((Object) this.pm10Ranges, (Object) deviceAware.pm10Ranges) && Intrinsics.areEqual((Object) this.pm25Ranges, (Object) deviceAware.pm25Ranges) && Intrinsics.areEqual((Object) this.vocRanges, (Object) deviceAware.vocRanges) && Intrinsics.areEqual((Object) this.hchoRanges, (Object) deviceAware.hchoRanges) && this.updateProgress == deviceAware.updateProgress && Intrinsics.areEqual((Object) this.compatibility, (Object) deviceAware.compatibility);
    }

    public int hashCode() {
        int hashCode = ((((this.uid.hashCode() * 31) + this.name.hashCode()) * 31) + this.brightness) * 31;
        String str = this.info;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        IndoorDatapoint indoorDatapoint = this.latestSensorDatapoint;
        int hashCode3 = (((((((((((((((((((((((((((((((((((((((hashCode2 + (indoorDatapoint == null ? 0 : indoorDatapoint.hashCode())) * 31) + this.lastSelectedSensorTypeIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isNightmodeOn)) * 31) + this.connectivityStatusIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis)) * 31) + this.mac.hashCode()) * 31) + this.mcuFirmware.hashCode()) * 31) + this.wifiFirmware.hashCode()) * 31) + this.hardware.hashCode()) * 31) + this.timeZone.hashCode()) * 31) + this.serial.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31) + this.dealerName.hashCode()) * 31) + this.dealerCountry.hashCode()) * 31) + Arrays.hashCode(this.pm1Ranges)) * 31) + Arrays.hashCode(this.pm10Ranges)) * 31) + Arrays.hashCode(this.pm25Ranges)) * 31) + Arrays.hashCode(this.vocRanges)) * 31) + Arrays.hashCode(this.hchoRanges)) * 31) + this.updateProgress) * 31;
        String str2 = this.compatibility;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "DeviceAware(uid=" + this.uid + ", name=" + this.name + ", brightness=" + this.brightness + ", info=" + this.info + ", latestSensorDatapoint=" + this.latestSensorDatapoint + ", lastSelectedSensorTypeIndex=" + this.lastSelectedSensorTypeIndex + ", isNightmodeOn=" + this.isNightmodeOn + ", connectivityStatusIndex=" + this.connectivityStatusIndex + ", lastConnectivityInMillis=" + this.lastConnectivityInMillis + ", mac=" + this.mac + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmware=" + this.wifiFirmware + ", hardware=" + this.hardware + ", timeZone=" + this.timeZone + ", serial=" + this.serial + ", purchaseDate=" + this.purchaseDate + ", dealerName=" + this.dealerName + ", dealerCountry=" + this.dealerCountry + ", pm1Ranges=" + Arrays.toString(this.pm1Ranges) + ", pm10Ranges=" + Arrays.toString(this.pm10Ranges) + ", pm25Ranges=" + Arrays.toString(this.pm25Ranges) + ", vocRanges=" + Arrays.toString(this.vocRanges) + ", hchoRanges=" + Arrays.toString(this.hchoRanges) + ", updateProgress=" + this.updateProgress + ", compatibility=" + this.compatibility + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.uid);
        parcel.writeString(this.name);
        parcel.writeInt(this.brightness);
        parcel.writeString(this.info);
        IndoorDatapoint indoorDatapoint = this.latestSensorDatapoint;
        if (indoorDatapoint == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            indoorDatapoint.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.lastSelectedSensorTypeIndex);
        parcel.writeInt(this.isNightmodeOn ? 1 : 0);
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
        parcel.writeDoubleArray(this.pm1Ranges);
        parcel.writeDoubleArray(this.pm10Ranges);
        parcel.writeDoubleArray(this.pm25Ranges);
        parcel.writeDoubleArray(this.vocRanges);
        parcel.writeDoubleArray(this.hchoRanges);
        parcel.writeInt(this.updateProgress);
        parcel.writeString(this.compatibility);
    }

    public double[] airRatingsFor(SensorType sensorType) {
        return HasSensorData.CC.$default$airRatingsFor(this, sensorType);
    }

    public IndoorAirRatingRanges.IndoorAirRating aqiFor(double d, SensorType sensorType) {
        return HasSensorData.CC.$default$aqiFor(this, d, sensorType);
    }

    public IndoorAirRatingRanges.IndoorAirRating aqiFor(SensorType sensorType) {
        return HasSensorData.CC.$default$aqiFor(this, sensorType);
    }

    public IndoorAirRatingRanges getAirRatingRanges() {
        return HasSensorData.CC.$default$getAirRatingRanges(this);
    }

    public Brightness getBrightnessEnum() {
        return HasBrightness.CC.$default$getBrightnessEnum(this);
    }

    public ConnectivityStatus getConnectivityStatus() {
        return Device.CC.$default$getConnectivityStatus(this);
    }

    public SensorType getLastSelectedSensorType() {
        return HasSensorData.CC.$default$getLastSelectedSensorType(this);
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

    public boolean supports(SensorType sensorType) {
        return HasSensorData.CC.$default$supports(this, sensorType);
    }

    public DeviceAware(String str, String str2, int i, String str3, IndoorDatapoint indoorDatapoint, int i2, boolean z, int i3, long j, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i4, String str13) {
        String str14 = str;
        String str15 = str2;
        String str16 = str4;
        String str17 = str5;
        String str18 = str6;
        String str19 = str7;
        String str20 = str8;
        String str21 = str9;
        String str22 = str10;
        String str23 = str11;
        String str24 = str12;
        double[] dArr6 = dArr;
        double[] dArr7 = dArr2;
        double[] dArr8 = dArr3;
        Intrinsics.checkNotNullParameter(str14, "uid");
        Intrinsics.checkNotNullParameter(str15, "name");
        Intrinsics.checkNotNullParameter(str16, AnalyticEvent.KEY_MAC);
        Intrinsics.checkNotNullParameter(str17, "mcuFirmware");
        Intrinsics.checkNotNullParameter(str18, "wifiFirmware");
        Intrinsics.checkNotNullParameter(str19, "hardware");
        Intrinsics.checkNotNullParameter(str20, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        Intrinsics.checkNotNullParameter(str21, "serial");
        Intrinsics.checkNotNullParameter(str22, "purchaseDate");
        Intrinsics.checkNotNullParameter(str23, "dealerName");
        Intrinsics.checkNotNullParameter(str24, "dealerCountry");
        Intrinsics.checkNotNullParameter(dArr6, "pm1Ranges");
        Intrinsics.checkNotNullParameter(dArr7, "pm10Ranges");
        Intrinsics.checkNotNullParameter(dArr8, "pm25Ranges");
        Intrinsics.checkNotNullParameter(dArr4, "vocRanges");
        double[] dArr9 = dArr5;
        Intrinsics.checkNotNullParameter(dArr9, "hchoRanges");
        this.uid = str14;
        this.name = str15;
        this.brightness = i;
        this.info = str3;
        this.latestSensorDatapoint = indoorDatapoint;
        this.lastSelectedSensorTypeIndex = i2;
        this.isNightmodeOn = z;
        this.connectivityStatusIndex = i3;
        this.lastConnectivityInMillis = j;
        this.mac = str16;
        this.mcuFirmware = str17;
        this.wifiFirmware = str18;
        this.hardware = str19;
        this.timeZone = str20;
        this.serial = str21;
        this.purchaseDate = str22;
        this.dealerName = str23;
        this.dealerCountry = str24;
        this.pm1Ranges = dArr6;
        this.pm10Ranges = dArr7;
        this.pm25Ranges = dArr8;
        this.vocRanges = dArr4;
        this.hchoRanges = dArr9;
        this.updateProgress = i4;
        this.compatibility = str13;
        this.modelName = DeviceType.Aware.INSTANCE.getName();
        this.typeIndex = DeviceType.Aware.INSTANCE.getIndex();
    }

    public String getUid() {
        return this.uid;
    }

    public String getName() {
        return this.name;
    }

    public int getBrightness() {
        return this.brightness;
    }

    public String getInfo() {
        return this.info;
    }

    public IndoorDatapoint getLatestSensorDatapoint() {
        return this.latestSensorDatapoint;
    }

    public int getLastSelectedSensorTypeIndex() {
        return this.lastSelectedSensorTypeIndex;
    }

    public boolean isNightmodeOn() {
        return this.isNightmodeOn;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceAware(java.lang.String r31, java.lang.String r32, int r33, java.lang.String r34, com.blueair.core.model.IndoorDatapoint r35, int r36, boolean r37, int r38, long r39, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, double[] r50, double[] r51, double[] r52, double[] r53, double[] r54, int r55, java.lang.String r56, int r57, kotlin.jvm.internal.DefaultConstructorMarker r58) {
        /*
            r30 = this;
            r0 = r57
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r6 = r2
            goto L_0x000b
        L_0x0009:
            r6 = r33
        L_0x000b:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0012
            r1 = 0
            r8 = r1
            goto L_0x0014
        L_0x0012:
            r8 = r35
        L_0x0014:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x001a
            r9 = r2
            goto L_0x001c
        L_0x001a:
            r9 = r36
        L_0x001c:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0022
            r10 = r2
            goto L_0x0024
        L_0x0022:
            r10 = r37
        L_0x0024:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0030
            com.blueair.core.model.ConnectivityStatus r1 = com.blueair.core.model.ConnectivityStatus.ONLINE
            int r1 = r1.ordinal()
            r11 = r1
            goto L_0x0032
        L_0x0030:
            r11 = r38
        L_0x0032:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x003a
            r3 = 0
            r12 = r3
            goto L_0x003c
        L_0x003a:
            r12 = r39
        L_0x003c:
            r1 = r0 & 512(0x200, float:7.175E-43)
            java.lang.String r3 = ""
            if (r1 == 0) goto L_0x0044
            r14 = r3
            goto L_0x0046
        L_0x0044:
            r14 = r41
        L_0x0046:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x004c
            r15 = r3
            goto L_0x004e
        L_0x004c:
            r15 = r42
        L_0x004e:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0055
            r16 = r3
            goto L_0x0057
        L_0x0055:
            r16 = r43
        L_0x0057:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x005e
            r17 = r3
            goto L_0x0060
        L_0x005e:
            r17 = r44
        L_0x0060:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0067
            r18 = r3
            goto L_0x0069
        L_0x0067:
            r18 = r45
        L_0x0069:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0070
            r19 = r3
            goto L_0x0072
        L_0x0070:
            r19 = r46
        L_0x0072:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x007b
            r20 = r3
            goto L_0x007d
        L_0x007b:
            r20 = r47
        L_0x007d:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0085
            r21 = r3
            goto L_0x0087
        L_0x0085:
            r21 = r48
        L_0x0087:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x008f
            r22 = r3
            goto L_0x0091
        L_0x008f:
            r22 = r49
        L_0x0091:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x009b
            double[] r1 = new double[r2]
            r23 = r1
            goto L_0x009d
        L_0x009b:
            r23 = r50
        L_0x009d:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a7
            double[] r1 = new double[r2]
            r24 = r1
            goto L_0x00a9
        L_0x00a7:
            r24 = r51
        L_0x00a9:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b3
            double[] r1 = new double[r2]
            r25 = r1
            goto L_0x00b5
        L_0x00b3:
            r25 = r52
        L_0x00b5:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00bf
            double[] r1 = new double[r2]
            r26 = r1
            goto L_0x00c1
        L_0x00bf:
            r26 = r53
        L_0x00c1:
            r1 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00cb
            double[] r1 = new double[r2]
            r27 = r1
            goto L_0x00cd
        L_0x00cb:
            r27 = r54
        L_0x00cd:
            r1 = 8388608(0x800000, float:1.17549435E-38)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00d5
            r28 = r2
            goto L_0x00d7
        L_0x00d5:
            r28 = r55
        L_0x00d7:
            r3 = r30
            r4 = r31
            r5 = r32
            r7 = r34
            r29 = r56
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceAware.<init>(java.lang.String, java.lang.String, int, java.lang.String, com.blueair.core.model.IndoorDatapoint, int, boolean, int, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double[], double[], double[], double[], double[], int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

    public double[] getPm1Ranges() {
        return this.pm1Ranges;
    }

    public double[] getPm10Ranges() {
        return this.pm10Ranges;
    }

    public double[] getPm25Ranges() {
        return this.pm25Ranges;
    }

    public double[] getVocRanges() {
        return this.vocRanges;
    }

    public double[] getHchoRanges() {
        return this.hchoRanges;
    }

    public int getUpdateProgress() {
        return this.updateProgress;
    }

    public String getCompatibility() {
        return this.compatibility;
    }

    public String getModelName() {
        return this.modelName;
    }

    public int getTypeIndex() {
        return this.typeIndex;
    }

    public boolean getHasAtLeastMinimumFirmwareVersion() {
        return AblWifFirmwareUtils.INSTANCE.hasAtLeastMinimumWifiFirmwareVersion(this, "1.4.0");
    }
}
