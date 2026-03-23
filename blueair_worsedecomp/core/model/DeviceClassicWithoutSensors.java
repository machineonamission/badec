package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.core.util.AblWifFirmwareUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\bS\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\nB\u0002\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\f\u0012\b\b\u0002\u0010\u001f\u001a\u00020\f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\b\b\u0002\u0010!\u001a\u00020\f\u0012\b\b\u0002\u0010\"\u001a\u00020\f\u0012\b\b\u0002\u0010#\u001a\u00020\f\u0012\b\b\u0002\u0010$\u001a\u00020\f\u0012\b\b\u0002\u0010%\u001a\u00020\f\u0012\b\b\u0002\u0010&\u001a\u00020\u000f\u0012\u0006\u0010'\u001a\u00020\f\u0012\b\u0010(\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b)\u0010*J\t\u0010O\u001a\u00020\fHÆ\u0003J\t\u0010P\u001a\u00020\fHÆ\u0003J\t\u0010Q\u001a\u00020\u000fHÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00101J\t\u0010S\u001a\u00020\u000fHÆ\u0003J\t\u0010T\u001a\u00020\fHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010V\u001a\u00020\u0015HÆ\u0003J\t\u0010W\u001a\u00020\u0015HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010Y\u001a\u00020\u000fHÆ\u0003J\t\u0010Z\u001a\u00020\u001aHÆ\u0003J\t\u0010[\u001a\u00020\fHÆ\u0003J\t\u0010\\\u001a\u00020\fHÆ\u0003J\t\u0010]\u001a\u00020\fHÆ\u0003J\t\u0010^\u001a\u00020\fHÆ\u0003J\t\u0010_\u001a\u00020\fHÆ\u0003J\t\u0010`\u001a\u00020\fHÆ\u0003J\t\u0010a\u001a\u00020\fHÆ\u0003J\t\u0010b\u001a\u00020\fHÆ\u0003J\t\u0010c\u001a\u00020\fHÆ\u0003J\t\u0010d\u001a\u00020\fHÆ\u0003J\t\u0010e\u001a\u00020\fHÆ\u0003J\t\u0010f\u001a\u00020\u000fHÆ\u0003J\t\u0010g\u001a\u00020\fHÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0002\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020\f2\b\b\u0002\u0010#\u001a\u00020\f2\b\b\u0002\u0010$\u001a\u00020\f2\b\b\u0002\u0010%\u001a\u00020\f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010jJ\u0006\u0010k\u001a\u00020\u000fJ\u0013\u0010l\u001a\u00020\u00152\b\u0010m\u001a\u0004\u0018\u00010nHÖ\u0003J\t\u0010o\u001a\u00020\u000fHÖ\u0001J\t\u0010p\u001a\u00020\fHÖ\u0001J\u0016\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020\u000fR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010\r\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0014\u0010\u0011\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u0014\u0010\u0012\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010,R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010,R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u00106R\u0014\u0010\u0016\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u00106R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010,\"\u0004\b8\u00109R\u0014\u0010\u0018\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010/R\u0014\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0014\u0010\u001b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010,R\u0014\u0010\u001c\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010,R\u0014\u0010\u001d\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010,R\u0014\u0010\u001e\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010,R\u0014\u0010\u001f\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010,R\u0014\u0010 \u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010,R\u0014\u0010!\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010,R\u0014\u0010\"\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010,R\u0014\u0010#\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010,R\u0014\u0010$\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010,R\u0014\u0010%\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010,R\u0014\u0010&\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010/R\u0014\u0010'\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010,R\u0016\u0010(\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010,R\u0014\u0010K\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010/R\u0014\u0010M\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\bN\u00106¨\u0006v"}, d2 = {"Lcom/blueair/core/model/DeviceClassicWithoutSensors;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasAblCloudFunctions;", "Lcom/blueair/core/model/HasNightMode;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasLinkingCapability;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasCompatibility;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "isNightmodeOn", "", "isChildLockOn", "linkedToUid", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "updateProgress", "modelName", "compatibility", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "()Z", "getLinkedToUid", "setLinkedToUid", "(Ljava/lang/String;)V", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getUpdateProgress", "getModelName", "getCompatibility", "typeIndex", "getTypeIndex", "hasAtLeastMinimumFirmwareVersion", "getHasAtLeastMinimumFirmwareVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lcom/blueair/core/model/DeviceClassicWithoutSensors;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public final class DeviceClassicWithoutSensors implements Device, HasFanSpeed, HasBrightness, HasInfo, HasAblCloudFunctions, HasNightMode, HasChildLock, HasLinkingCapability, HasScheduling, HasCompatibility {
    public static final Parcelable.Creator<DeviceClassicWithoutSensors> CREATOR = new Creator();
    private final String autoModeText;
    private final int brightness;
    private final String compatibility;
    private final int connectivityStatusIndex;
    private final String dealerCountry;
    private final String dealerName;
    private final int fanSpeed;
    private final Integer filterLife;
    private final String filterTrigger;
    private final String filterType;
    private final String hardware;
    private final String info;
    private final boolean isChildLockOn;
    private final boolean isNightmodeOn;
    private final long lastConnectivityInMillis;
    private String linkedToUid;
    private final String mac;
    private final String mcuFirmware;
    private final String modelName;
    private final String name;
    private final String purchaseDate;
    private final String serial;
    private final String timeZone;
    private final int typeIndex;
    private final String uid;
    private final int updateProgress;
    private final String wifiFirmware;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class Creator implements Parcelable.Creator<DeviceClassicWithoutSensors> {
        public final DeviceClassicWithoutSensors createFromParcel(Parcel parcel) {
            boolean z;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            int readInt2 = parcel.readInt();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            boolean z2 = true;
            boolean z3 = false;
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = true;
                z2 = false;
            }
            if (parcel.readInt() != 0) {
                z3 = z;
            }
            return new DeviceClassicWithoutSensors(readString, readString2, readInt, valueOf, readInt2, readString3, readString4, z2, z3, parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString());
        }

        public final DeviceClassicWithoutSensors[] newArray(int i) {
            return new DeviceClassicWithoutSensors[i];
        }
    }

    public static /* synthetic */ DeviceClassicWithoutSensors copy$default(DeviceClassicWithoutSensors deviceClassicWithoutSensors, String str, String str2, int i, Integer num, int i2, String str3, String str4, boolean z, boolean z2, String str5, int i3, long j, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i4, String str17, String str18, int i5, Object obj) {
        String str19;
        String str20;
        DeviceClassicWithoutSensors deviceClassicWithoutSensors2 = deviceClassicWithoutSensors;
        int i6 = i5;
        String str21 = (i6 & 1) != 0 ? deviceClassicWithoutSensors2.uid : str;
        String str22 = (i6 & 2) != 0 ? deviceClassicWithoutSensors2.name : str2;
        int i7 = (i6 & 4) != 0 ? deviceClassicWithoutSensors2.fanSpeed : i;
        Integer num2 = (i6 & 8) != 0 ? deviceClassicWithoutSensors2.filterLife : num;
        int i8 = (i6 & 16) != 0 ? deviceClassicWithoutSensors2.brightness : i2;
        String str23 = (i6 & 32) != 0 ? deviceClassicWithoutSensors2.autoModeText : str3;
        String str24 = (i6 & 64) != 0 ? deviceClassicWithoutSensors2.info : str4;
        boolean z3 = (i6 & 128) != 0 ? deviceClassicWithoutSensors2.isNightmodeOn : z;
        boolean z4 = (i6 & 256) != 0 ? deviceClassicWithoutSensors2.isChildLockOn : z2;
        String str25 = (i6 & 512) != 0 ? deviceClassicWithoutSensors2.linkedToUid : str5;
        int i9 = (i6 & 1024) != 0 ? deviceClassicWithoutSensors2.connectivityStatusIndex : i3;
        long j2 = (i6 & 2048) != 0 ? deviceClassicWithoutSensors2.lastConnectivityInMillis : j;
        String str26 = (i6 & 4096) != 0 ? deviceClassicWithoutSensors2.mac : str6;
        String str27 = str21;
        String str28 = (i6 & 8192) != 0 ? deviceClassicWithoutSensors2.mcuFirmware : str7;
        String str29 = (i6 & 16384) != 0 ? deviceClassicWithoutSensors2.wifiFirmware : str8;
        String str30 = (i6 & 32768) != 0 ? deviceClassicWithoutSensors2.hardware : str9;
        String str31 = (i5 & 65536) != 0 ? deviceClassicWithoutSensors2.timeZone : str10;
        String str32 = (i5 & 131072) != 0 ? deviceClassicWithoutSensors2.serial : str11;
        String str33 = (i5 & 262144) != 0 ? deviceClassicWithoutSensors2.purchaseDate : str12;
        String str34 = (i5 & 524288) != 0 ? deviceClassicWithoutSensors2.dealerName : str13;
        String str35 = (i5 & 1048576) != 0 ? deviceClassicWithoutSensors2.dealerCountry : str14;
        String str36 = (i5 & 2097152) != 0 ? deviceClassicWithoutSensors2.filterType : str15;
        String str37 = (i5 & 4194304) != 0 ? deviceClassicWithoutSensors2.filterTrigger : str16;
        int i10 = (i5 & 8388608) != 0 ? deviceClassicWithoutSensors2.updateProgress : i4;
        String str38 = (i5 & 16777216) != 0 ? deviceClassicWithoutSensors2.modelName : str17;
        if ((i5 & 33554432) != 0) {
            str20 = str38;
            str19 = deviceClassicWithoutSensors2.compatibility;
        } else {
            str19 = str18;
            str20 = str38;
        }
        return deviceClassicWithoutSensors2.copy(str27, str22, i7, num2, i8, str23, str24, z3, z4, str25, i9, j2, str26, str28, str29, str30, str31, str32, str33, str34, str35, str36, str37, i10, str20, str19);
    }

    public final String component1() {
        return this.uid;
    }

    public final String component10() {
        return this.linkedToUid;
    }

    public final int component11() {
        return this.connectivityStatusIndex;
    }

    public final long component12() {
        return this.lastConnectivityInMillis;
    }

    public final String component13() {
        return this.mac;
    }

    public final String component14() {
        return this.mcuFirmware;
    }

    public final String component15() {
        return this.wifiFirmware;
    }

    public final String component16() {
        return this.hardware;
    }

    public final String component17() {
        return this.timeZone;
    }

    public final String component18() {
        return this.serial;
    }

    public final String component19() {
        return this.purchaseDate;
    }

    public final String component2() {
        return this.name;
    }

    public final String component20() {
        return this.dealerName;
    }

    public final String component21() {
        return this.dealerCountry;
    }

    public final String component22() {
        return this.filterType;
    }

    public final String component23() {
        return this.filterTrigger;
    }

    public final int component24() {
        return this.updateProgress;
    }

    public final String component25() {
        return this.modelName;
    }

    public final String component26() {
        return this.compatibility;
    }

    public final int component3() {
        return this.fanSpeed;
    }

    public final Integer component4() {
        return this.filterLife;
    }

    public final int component5() {
        return this.brightness;
    }

    public final String component6() {
        return this.autoModeText;
    }

    public final String component7() {
        return this.info;
    }

    public final boolean component8() {
        return this.isNightmodeOn;
    }

    public final boolean component9() {
        return this.isChildLockOn;
    }

    public final DeviceClassicWithoutSensors copy(String str, String str2, int i, Integer num, int i2, String str3, String str4, boolean z, boolean z2, String str5, int i3, long j, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i4, String str17, String str18) {
        String str19 = str;
        Intrinsics.checkNotNullParameter(str19, "uid");
        String str20 = str2;
        Intrinsics.checkNotNullParameter(str20, "name");
        String str21 = str3;
        Intrinsics.checkNotNullParameter(str21, "autoModeText");
        String str22 = str6;
        Intrinsics.checkNotNullParameter(str22, AnalyticEvent.KEY_MAC);
        Intrinsics.checkNotNullParameter(str7, "mcuFirmware");
        String str23 = str8;
        Intrinsics.checkNotNullParameter(str23, "wifiFirmware");
        String str24 = str9;
        Intrinsics.checkNotNullParameter(str24, "hardware");
        String str25 = str10;
        Intrinsics.checkNotNullParameter(str25, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        String str26 = str11;
        Intrinsics.checkNotNullParameter(str26, "serial");
        String str27 = str12;
        Intrinsics.checkNotNullParameter(str27, "purchaseDate");
        String str28 = str13;
        Intrinsics.checkNotNullParameter(str28, "dealerName");
        String str29 = str14;
        Intrinsics.checkNotNullParameter(str29, "dealerCountry");
        String str30 = str15;
        Intrinsics.checkNotNullParameter(str30, "filterType");
        String str31 = str16;
        Intrinsics.checkNotNullParameter(str31, "filterTrigger");
        String str32 = str17;
        Intrinsics.checkNotNullParameter(str32, "modelName");
        String str33 = str23;
        String str34 = str24;
        String str35 = str25;
        String str36 = str26;
        String str37 = str27;
        String str38 = str28;
        String str39 = str29;
        String str40 = str30;
        String str41 = str31;
        return new DeviceClassicWithoutSensors(str19, str20, i, num, i2, str21, str4, z, z2, str5, i3, j, str22, str7, str33, str34, str35, str36, str37, str38, str39, str40, str41, i4, str32, str18);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceClassicWithoutSensors)) {
            return false;
        }
        DeviceClassicWithoutSensors deviceClassicWithoutSensors = (DeviceClassicWithoutSensors) obj;
        return Intrinsics.areEqual((Object) this.uid, (Object) deviceClassicWithoutSensors.uid) && Intrinsics.areEqual((Object) this.name, (Object) deviceClassicWithoutSensors.name) && this.fanSpeed == deviceClassicWithoutSensors.fanSpeed && Intrinsics.areEqual((Object) this.filterLife, (Object) deviceClassicWithoutSensors.filterLife) && this.brightness == deviceClassicWithoutSensors.brightness && Intrinsics.areEqual((Object) this.autoModeText, (Object) deviceClassicWithoutSensors.autoModeText) && Intrinsics.areEqual((Object) this.info, (Object) deviceClassicWithoutSensors.info) && this.isNightmodeOn == deviceClassicWithoutSensors.isNightmodeOn && this.isChildLockOn == deviceClassicWithoutSensors.isChildLockOn && Intrinsics.areEqual((Object) this.linkedToUid, (Object) deviceClassicWithoutSensors.linkedToUid) && this.connectivityStatusIndex == deviceClassicWithoutSensors.connectivityStatusIndex && this.lastConnectivityInMillis == deviceClassicWithoutSensors.lastConnectivityInMillis && Intrinsics.areEqual((Object) this.mac, (Object) deviceClassicWithoutSensors.mac) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceClassicWithoutSensors.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) deviceClassicWithoutSensors.wifiFirmware) && Intrinsics.areEqual((Object) this.hardware, (Object) deviceClassicWithoutSensors.hardware) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceClassicWithoutSensors.timeZone) && Intrinsics.areEqual((Object) this.serial, (Object) deviceClassicWithoutSensors.serial) && Intrinsics.areEqual((Object) this.purchaseDate, (Object) deviceClassicWithoutSensors.purchaseDate) && Intrinsics.areEqual((Object) this.dealerName, (Object) deviceClassicWithoutSensors.dealerName) && Intrinsics.areEqual((Object) this.dealerCountry, (Object) deviceClassicWithoutSensors.dealerCountry) && Intrinsics.areEqual((Object) this.filterType, (Object) deviceClassicWithoutSensors.filterType) && Intrinsics.areEqual((Object) this.filterTrigger, (Object) deviceClassicWithoutSensors.filterTrigger) && this.updateProgress == deviceClassicWithoutSensors.updateProgress && Intrinsics.areEqual((Object) this.modelName, (Object) deviceClassicWithoutSensors.modelName) && Intrinsics.areEqual((Object) this.compatibility, (Object) deviceClassicWithoutSensors.compatibility);
    }

    public int hashCode() {
        int hashCode = ((((this.uid.hashCode() * 31) + this.name.hashCode()) * 31) + this.fanSpeed) * 31;
        Integer num = this.filterLife;
        int i = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.brightness) * 31) + this.autoModeText.hashCode()) * 31;
        String str = this.info;
        int hashCode3 = (((((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isNightmodeOn)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn)) * 31;
        String str2 = this.linkedToUid;
        int hashCode4 = (((((((((((((((((((((((((((((((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.connectivityStatusIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis)) * 31) + this.mac.hashCode()) * 31) + this.mcuFirmware.hashCode()) * 31) + this.wifiFirmware.hashCode()) * 31) + this.hardware.hashCode()) * 31) + this.timeZone.hashCode()) * 31) + this.serial.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31) + this.dealerName.hashCode()) * 31) + this.dealerCountry.hashCode()) * 31) + this.filterType.hashCode()) * 31) + this.filterTrigger.hashCode()) * 31) + this.updateProgress) * 31) + this.modelName.hashCode()) * 31;
        String str3 = this.compatibility;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "DeviceClassicWithoutSensors(uid=" + this.uid + ", name=" + this.name + ", fanSpeed=" + this.fanSpeed + ", filterLife=" + this.filterLife + ", brightness=" + this.brightness + ", autoModeText=" + this.autoModeText + ", info=" + this.info + ", isNightmodeOn=" + this.isNightmodeOn + ", isChildLockOn=" + this.isChildLockOn + ", linkedToUid=" + this.linkedToUid + ", connectivityStatusIndex=" + this.connectivityStatusIndex + ", lastConnectivityInMillis=" + this.lastConnectivityInMillis + ", mac=" + this.mac + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmware=" + this.wifiFirmware + ", hardware=" + this.hardware + ", timeZone=" + this.timeZone + ", serial=" + this.serial + ", purchaseDate=" + this.purchaseDate + ", dealerName=" + this.dealerName + ", dealerCountry=" + this.dealerCountry + ", filterType=" + this.filterType + ", filterTrigger=" + this.filterTrigger + ", updateProgress=" + this.updateProgress + ", modelName=" + this.modelName + ", compatibility=" + this.compatibility + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.uid);
        parcel.writeString(this.name);
        parcel.writeInt(this.fanSpeed);
        Integer num = this.filterLife;
        if (num == null) {
            i2 = 0;
        } else {
            parcel.writeInt(1);
            i2 = num.intValue();
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.brightness);
        parcel.writeString(this.autoModeText);
        parcel.writeString(this.info);
        parcel.writeInt(this.isNightmodeOn ? 1 : 0);
        parcel.writeInt(this.isChildLockOn ? 1 : 0);
        parcel.writeString(this.linkedToUid);
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
        parcel.writeString(this.filterType);
        parcel.writeString(this.filterTrigger);
        parcel.writeInt(this.updateProgress);
        parcel.writeString(this.modelName);
        parcel.writeString(this.compatibility);
    }

    public AutoMode getAutoMode() {
        return HasFanSpeed.CC.$default$getAutoMode(this);
    }

    public Brightness getBrightnessEnum() {
        return HasBrightness.CC.$default$getBrightnessEnum(this);
    }

    public ConnectivityStatus getConnectivityStatus() {
        return Device.CC.$default$getConnectivityStatus(this);
    }

    public FanSpeedEnum getFanSpeedEnum() {
        return HasFanSpeed.CC.$default$getFanSpeedEnum(this);
    }

    public Filter getFilter() {
        return HasFanSpeed.CC.$default$getFilter(this);
    }

    public boolean getHasGear0() {
        return HasFanSpeed.CC.$default$getHasGear0(this);
    }

    public boolean getHasGear4() {
        return HasFanSpeed.CC.$default$getHasGear4(this);
    }

    public TimeZone getTimezone(Context context) {
        return Device.CC.$default$getTimezone(this, context);
    }

    public FilterTrigger getTrigger() {
        return HasFanSpeed.CC.$default$getTrigger(this);
    }

    public DeviceType getType() {
        return Device.CC.$default$getType(this);
    }

    public UiAutoMode getUiAutoMode() {
        return HasFanSpeed.CC.$default$getUiAutoMode(this);
    }

    public boolean isLinked() {
        return HasLinkingCapability.CC.$default$isLinked(this);
    }

    public boolean isOnline() {
        return Device.CC.$default$isOnline(this);
    }

    public boolean isUsDevice() {
        return Device.CC.$default$isUsDevice(this);
    }

    public DeviceClassicWithoutSensors(String str, String str2, int i, Integer num, int i2, String str3, String str4, boolean z, boolean z2, String str5, int i3, long j, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i4, String str17, String str18) {
        String str19 = str;
        String str20 = str2;
        String str21 = str3;
        String str22 = str6;
        String str23 = str7;
        String str24 = str8;
        String str25 = str9;
        String str26 = str10;
        String str27 = str11;
        String str28 = str12;
        String str29 = str13;
        String str30 = str14;
        String str31 = str15;
        String str32 = str16;
        String str33 = str17;
        Intrinsics.checkNotNullParameter(str19, "uid");
        Intrinsics.checkNotNullParameter(str20, "name");
        Intrinsics.checkNotNullParameter(str21, "autoModeText");
        Intrinsics.checkNotNullParameter(str22, AnalyticEvent.KEY_MAC);
        Intrinsics.checkNotNullParameter(str23, "mcuFirmware");
        Intrinsics.checkNotNullParameter(str24, "wifiFirmware");
        Intrinsics.checkNotNullParameter(str25, "hardware");
        Intrinsics.checkNotNullParameter(str26, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        Intrinsics.checkNotNullParameter(str27, "serial");
        Intrinsics.checkNotNullParameter(str28, "purchaseDate");
        Intrinsics.checkNotNullParameter(str29, "dealerName");
        Intrinsics.checkNotNullParameter(str30, "dealerCountry");
        Intrinsics.checkNotNullParameter(str31, "filterType");
        Intrinsics.checkNotNullParameter(str32, "filterTrigger");
        Intrinsics.checkNotNullParameter(str33, "modelName");
        this.uid = str19;
        this.name = str20;
        this.fanSpeed = i;
        this.filterLife = num;
        this.brightness = i2;
        this.autoModeText = str21;
        this.info = str4;
        this.isNightmodeOn = z;
        this.isChildLockOn = z2;
        this.linkedToUid = str5;
        this.connectivityStatusIndex = i3;
        this.lastConnectivityInMillis = j;
        this.mac = str22;
        this.mcuFirmware = str23;
        this.wifiFirmware = str24;
        this.hardware = str25;
        this.timeZone = str26;
        this.serial = str27;
        this.purchaseDate = str28;
        this.dealerName = str29;
        this.dealerCountry = str30;
        this.filterType = str31;
        this.filterTrigger = str32;
        this.updateProgress = i4;
        this.modelName = str33;
        this.compatibility = str18;
        this.typeIndex = DeviceType.ClassicWithoutSensor.INSTANCE.getIndex();
    }

    public String getUid() {
        return this.uid;
    }

    public /* synthetic */ DeviceClassicWithoutSensors(String str, String str2, int i, Integer num, int i2, String str3, String str4, boolean z, boolean z2, String str5, int i3, long j, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i4, String str17, String str18, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        String str19;
        String str20;
        String str21;
        int i6;
        String str22;
        String str23;
        DeviceClassicWithoutSensors deviceClassicWithoutSensors;
        int i7 = i5;
        String str24 = (i7 & 2) != 0 ? "todo" : str2;
        int i8 = (i7 & 4) != 0 ? 0 : i;
        Integer num2 = (i7 & 8) != 0 ? null : num;
        int i9 = (i7 & 16) != 0 ? 0 : i2;
        if ((i7 & 32) != 0) {
            str19 = "";
        } else {
            str19 = str3;
        }
        String str25 = (i7 & 64) != 0 ? null : str4;
        boolean z3 = (i7 & 128) != 0 ? false : z;
        boolean z4 = (i7 & 256) != 0 ? false : z2;
        String str26 = (i7 & 512) != 0 ? null : str5;
        int ordinal = (i7 & 1024) != 0 ? ConnectivityStatus.ONLINE.ordinal() : i3;
        long j2 = (i7 & 2048) != 0 ? 0 : j;
        String str27 = (i7 & 4096) != 0 ? "" : str6;
        String str28 = (i7 & 8192) != 0 ? "" : str7;
        String str29 = (i7 & 16384) != 0 ? "" : str8;
        String str30 = (32768 & i7) != 0 ? "" : str9;
        String str31 = (65536 & i7) != 0 ? "" : str10;
        String str32 = (131072 & i7) != 0 ? "" : str11;
        String str33 = (262144 & i7) != 0 ? "" : str12;
        String str34 = (524288 & i7) != 0 ? "" : str13;
        String str35 = (1048576 & i7) != 0 ? "" : str14;
        String str36 = (2097152 & i7) != 0 ? "" : str15;
        String str37 = (4194304 & i7) != 0 ? "" : str16;
        if ((i7 & 8388608) != 0) {
            i6 = 0;
            str23 = str;
            str21 = str17;
            str20 = str18;
            str22 = str19;
            deviceClassicWithoutSensors = this;
        } else {
            i6 = i4;
            deviceClassicWithoutSensors = this;
            str23 = str;
            str21 = str17;
            str20 = str18;
            str22 = str19;
        }
        new DeviceClassicWithoutSensors(str23, str24, i8, num2, i9, str22, str25, z3, z4, str26, ordinal, j2, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36, str37, i6, str21, str20);
    }

    public String getName() {
        return this.name;
    }

    public int getFanSpeed() {
        return this.fanSpeed;
    }

    public Integer getFilterLife() {
        return this.filterLife;
    }

    public int getBrightness() {
        return this.brightness;
    }

    public String getAutoModeText() {
        return this.autoModeText;
    }

    public String getInfo() {
        return this.info;
    }

    public boolean isNightmodeOn() {
        return this.isNightmodeOn;
    }

    public boolean isChildLockOn() {
        return this.isChildLockOn;
    }

    public String getLinkedToUid() {
        return this.linkedToUid;
    }

    public void setLinkedToUid(String str) {
        this.linkedToUid = str;
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

    public String getFilterType() {
        return this.filterType;
    }

    public String getFilterTrigger() {
        return this.filterTrigger;
    }

    public int getUpdateProgress() {
        return this.updateProgress;
    }

    public String getModelName() {
        return this.modelName;
    }

    public String getCompatibility() {
        return this.compatibility;
    }

    public int getTypeIndex() {
        return this.typeIndex;
    }

    public boolean getHasAtLeastMinimumFirmwareVersion() {
        return AblWifFirmwareUtils.INSTANCE.hasAtLeastMinimumWifiFirmwareVersion(this, "1.4.0");
    }
}
