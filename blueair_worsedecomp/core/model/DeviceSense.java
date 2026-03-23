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
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\bR\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\nBÿ\u0001\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\f\u0012\b\b\u0002\u0010\u001f\u001a\u00020\f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\b\b\u0002\u0010!\u001a\u00020\f\u0012\b\b\u0002\u0010\"\u001a\u00020\f\u0012\b\b\u0002\u0010#\u001a\u00020\f\u0012\b\b\u0002\u0010$\u001a\u00020\f\u0012\b\b\u0002\u0010%\u001a\u00020\f\u0012\b\b\u0002\u0010&\u001a\u00020\u000f\u0012\b\u0010'\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b(\u0010)J\t\u0010O\u001a\u00020\fHÆ\u0003J\t\u0010P\u001a\u00020\fHÆ\u0003J\t\u0010Q\u001a\u00020\u000fHÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00100J\t\u0010S\u001a\u00020\u000fHÆ\u0003J\t\u0010T\u001a\u00020\fHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010V\u001a\u00020\u0015HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010X\u001a\u00020\u0015HÆ\u0003J\t\u0010Y\u001a\u00020\u000fHÆ\u0003J\t\u0010Z\u001a\u00020\u001aHÆ\u0003J\t\u0010[\u001a\u00020\fHÆ\u0003J\t\u0010\\\u001a\u00020\fHÆ\u0003J\t\u0010]\u001a\u00020\fHÆ\u0003J\t\u0010^\u001a\u00020\fHÆ\u0003J\t\u0010_\u001a\u00020\fHÆ\u0003J\t\u0010`\u001a\u00020\fHÆ\u0003J\t\u0010a\u001a\u00020\fHÆ\u0003J\t\u0010b\u001a\u00020\fHÆ\u0003J\t\u0010c\u001a\u00020\fHÆ\u0003J\t\u0010d\u001a\u00020\fHÆ\u0003J\t\u0010e\u001a\u00020\fHÆ\u0003J\t\u0010f\u001a\u00020\u000fHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0002\u0010h\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020\f2\b\b\u0002\u0010#\u001a\u00020\f2\b\b\u0002\u0010$\u001a\u00020\f2\b\b\u0002\u0010%\u001a\u00020\f2\b\b\u0002\u0010&\u001a\u00020\u000f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010iJ\u0006\u0010j\u001a\u00020\u000fJ\u0013\u0010k\u001a\u00020\u00152\b\u0010l\u001a\u0004\u0018\u00010mHÖ\u0003J\t\u0010n\u001a\u00020\u000fHÖ\u0001J\t\u0010o\u001a\u00020\fHÖ\u0001J\u0016\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020\u000fR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010\r\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0014\u0010\u0011\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010.R\u0014\u0010\u0012\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010+R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010+R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u00105R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010+\"\u0004\b7\u00108R\u0014\u0010\u0017\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u00105R\u0014\u0010\u0018\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010.R\u0014\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0014\u0010\u001b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010+R\u0014\u0010\u001c\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010+R\u0014\u0010\u001d\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010+R\u0014\u0010\u001e\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010+R\u0014\u0010\u001f\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010+R\u0014\u0010 \u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010+R\u0014\u0010!\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010+R\u0014\u0010\"\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010+R\u0014\u0010#\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010+R\u0014\u0010$\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010+R\u0014\u0010%\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010+R\u0014\u0010&\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010.R\u0016\u0010'\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010+R\u0014\u0010I\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010+R\u0014\u0010K\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010.R\u0014\u0010M\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\bN\u00105¨\u0006u"}, d2 = {"Lcom/blueair/core/model/DeviceSense;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasNightMode;", "Lcom/blueair/core/model/HasAblCloudFunctions;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasLinkingCapability;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasCompatibility;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "isChildLockOn", "", "linkedToUid", "isNightmodeOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "updateProgress", "compatibility", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "()Z", "getLinkedToUid", "setLinkedToUid", "(Ljava/lang/String;)V", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getUpdateProgress", "getCompatibility", "modelName", "getModelName", "typeIndex", "getTypeIndex", "hasAtLeastMinimumFirmwareVersion", "getHasAtLeastMinimumFirmwareVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/blueair/core/model/DeviceSense;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public final class DeviceSense implements Device, HasFanSpeed, HasBrightness, HasInfo, HasNightMode, HasAblCloudFunctions, HasChildLock, HasLinkingCapability, HasScheduling, HasCompatibility {
    public static final Parcelable.Creator<DeviceSense> CREATOR = new Creator();
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
    public static final class Creator implements Parcelable.Creator<DeviceSense> {
        public final DeviceSense createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            int readInt2 = parcel.readInt();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            boolean z3 = true;
            if (parcel.readInt() != 0) {
                z2 = true;
                z = false;
            } else {
                z2 = true;
                z3 = false;
                z = false;
            }
            String readString5 = parcel.readString();
            if (parcel.readInt() != 0) {
                z = z2;
            }
            return new DeviceSense(readString, readString2, readInt, valueOf, readInt2, readString3, readString4, z3, readString5, z, parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString());
        }

        public final DeviceSense[] newArray(int i) {
            return new DeviceSense[i];
        }
    }

    public static /* synthetic */ DeviceSense copy$default(DeviceSense deviceSense, String str, String str2, int i, Integer num, int i2, String str3, String str4, boolean z, String str5, boolean z2, int i3, long j, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i4, String str17, int i5, Object obj) {
        String str18;
        int i6;
        DeviceSense deviceSense2 = deviceSense;
        int i7 = i5;
        String str19 = (i7 & 1) != 0 ? deviceSense2.uid : str;
        String str20 = (i7 & 2) != 0 ? deviceSense2.name : str2;
        int i8 = (i7 & 4) != 0 ? deviceSense2.fanSpeed : i;
        Integer num2 = (i7 & 8) != 0 ? deviceSense2.filterLife : num;
        int i9 = (i7 & 16) != 0 ? deviceSense2.brightness : i2;
        String str21 = (i7 & 32) != 0 ? deviceSense2.autoModeText : str3;
        String str22 = (i7 & 64) != 0 ? deviceSense2.info : str4;
        boolean z3 = (i7 & 128) != 0 ? deviceSense2.isChildLockOn : z;
        String str23 = (i7 & 256) != 0 ? deviceSense2.linkedToUid : str5;
        boolean z4 = (i7 & 512) != 0 ? deviceSense2.isNightmodeOn : z2;
        int i10 = (i7 & 1024) != 0 ? deviceSense2.connectivityStatusIndex : i3;
        long j2 = (i7 & 2048) != 0 ? deviceSense2.lastConnectivityInMillis : j;
        String str24 = (i7 & 4096) != 0 ? deviceSense2.mac : str6;
        String str25 = str19;
        String str26 = (i7 & 8192) != 0 ? deviceSense2.mcuFirmware : str7;
        String str27 = (i7 & 16384) != 0 ? deviceSense2.wifiFirmware : str8;
        String str28 = (i7 & 32768) != 0 ? deviceSense2.hardware : str9;
        String str29 = (i5 & 65536) != 0 ? deviceSense2.timeZone : str10;
        String str30 = (i5 & 131072) != 0 ? deviceSense2.serial : str11;
        String str31 = (i5 & 262144) != 0 ? deviceSense2.purchaseDate : str12;
        String str32 = (i5 & 524288) != 0 ? deviceSense2.dealerName : str13;
        String str33 = (i5 & 1048576) != 0 ? deviceSense2.dealerCountry : str14;
        String str34 = (i5 & 2097152) != 0 ? deviceSense2.filterType : str15;
        String str35 = (i5 & 4194304) != 0 ? deviceSense2.filterTrigger : str16;
        int i11 = (i5 & 8388608) != 0 ? deviceSense2.updateProgress : i4;
        if ((i5 & 16777216) != 0) {
            i6 = i11;
            str18 = deviceSense2.compatibility;
        } else {
            str18 = str17;
            i6 = i11;
        }
        return deviceSense2.copy(str25, str20, i8, num2, i9, str21, str22, z3, str23, z4, i10, j2, str24, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, i6, str18);
    }

    public final String component1() {
        return this.uid;
    }

    public final boolean component10() {
        return this.isNightmodeOn;
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
        return this.isChildLockOn;
    }

    public final String component9() {
        return this.linkedToUid;
    }

    public final DeviceSense copy(String str, String str2, int i, Integer num, int i2, String str3, String str4, boolean z, String str5, boolean z2, int i3, long j, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i4, String str17) {
        String str18 = str;
        Intrinsics.checkNotNullParameter(str18, "uid");
        String str19 = str2;
        Intrinsics.checkNotNullParameter(str19, "name");
        String str20 = str3;
        Intrinsics.checkNotNullParameter(str20, "autoModeText");
        String str21 = str6;
        Intrinsics.checkNotNullParameter(str21, AnalyticEvent.KEY_MAC);
        Intrinsics.checkNotNullParameter(str7, "mcuFirmware");
        String str22 = str8;
        Intrinsics.checkNotNullParameter(str22, "wifiFirmware");
        String str23 = str9;
        Intrinsics.checkNotNullParameter(str23, "hardware");
        String str24 = str10;
        Intrinsics.checkNotNullParameter(str24, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        String str25 = str11;
        Intrinsics.checkNotNullParameter(str25, "serial");
        String str26 = str12;
        Intrinsics.checkNotNullParameter(str26, "purchaseDate");
        String str27 = str13;
        Intrinsics.checkNotNullParameter(str27, "dealerName");
        String str28 = str14;
        Intrinsics.checkNotNullParameter(str28, "dealerCountry");
        String str29 = str15;
        Intrinsics.checkNotNullParameter(str29, "filterType");
        String str30 = str16;
        Intrinsics.checkNotNullParameter(str30, "filterTrigger");
        String str31 = str22;
        String str32 = str23;
        String str33 = str24;
        String str34 = str25;
        String str35 = str26;
        String str36 = str27;
        String str37 = str28;
        String str38 = str29;
        String str39 = str30;
        return new DeviceSense(str18, str19, i, num, i2, str20, str4, z, str5, z2, i3, j, str21, str7, str31, str32, str33, str34, str35, str36, str37, str38, str39, i4, str17);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceSense)) {
            return false;
        }
        DeviceSense deviceSense = (DeviceSense) obj;
        return Intrinsics.areEqual((Object) this.uid, (Object) deviceSense.uid) && Intrinsics.areEqual((Object) this.name, (Object) deviceSense.name) && this.fanSpeed == deviceSense.fanSpeed && Intrinsics.areEqual((Object) this.filterLife, (Object) deviceSense.filterLife) && this.brightness == deviceSense.brightness && Intrinsics.areEqual((Object) this.autoModeText, (Object) deviceSense.autoModeText) && Intrinsics.areEqual((Object) this.info, (Object) deviceSense.info) && this.isChildLockOn == deviceSense.isChildLockOn && Intrinsics.areEqual((Object) this.linkedToUid, (Object) deviceSense.linkedToUid) && this.isNightmodeOn == deviceSense.isNightmodeOn && this.connectivityStatusIndex == deviceSense.connectivityStatusIndex && this.lastConnectivityInMillis == deviceSense.lastConnectivityInMillis && Intrinsics.areEqual((Object) this.mac, (Object) deviceSense.mac) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceSense.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) deviceSense.wifiFirmware) && Intrinsics.areEqual((Object) this.hardware, (Object) deviceSense.hardware) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceSense.timeZone) && Intrinsics.areEqual((Object) this.serial, (Object) deviceSense.serial) && Intrinsics.areEqual((Object) this.purchaseDate, (Object) deviceSense.purchaseDate) && Intrinsics.areEqual((Object) this.dealerName, (Object) deviceSense.dealerName) && Intrinsics.areEqual((Object) this.dealerCountry, (Object) deviceSense.dealerCountry) && Intrinsics.areEqual((Object) this.filterType, (Object) deviceSense.filterType) && Intrinsics.areEqual((Object) this.filterTrigger, (Object) deviceSense.filterTrigger) && this.updateProgress == deviceSense.updateProgress && Intrinsics.areEqual((Object) this.compatibility, (Object) deviceSense.compatibility);
    }

    public int hashCode() {
        int hashCode = ((((this.uid.hashCode() * 31) + this.name.hashCode()) * 31) + this.fanSpeed) * 31;
        Integer num = this.filterLife;
        int i = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.brightness) * 31) + this.autoModeText.hashCode()) * 31;
        String str = this.info;
        int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn)) * 31;
        String str2 = this.linkedToUid;
        int hashCode4 = (((((((((((((((((((((((((((((((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isNightmodeOn)) * 31) + this.connectivityStatusIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis)) * 31) + this.mac.hashCode()) * 31) + this.mcuFirmware.hashCode()) * 31) + this.wifiFirmware.hashCode()) * 31) + this.hardware.hashCode()) * 31) + this.timeZone.hashCode()) * 31) + this.serial.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31) + this.dealerName.hashCode()) * 31) + this.dealerCountry.hashCode()) * 31) + this.filterType.hashCode()) * 31) + this.filterTrigger.hashCode()) * 31) + this.updateProgress) * 31;
        String str3 = this.compatibility;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "DeviceSense(uid=" + this.uid + ", name=" + this.name + ", fanSpeed=" + this.fanSpeed + ", filterLife=" + this.filterLife + ", brightness=" + this.brightness + ", autoModeText=" + this.autoModeText + ", info=" + this.info + ", isChildLockOn=" + this.isChildLockOn + ", linkedToUid=" + this.linkedToUid + ", isNightmodeOn=" + this.isNightmodeOn + ", connectivityStatusIndex=" + this.connectivityStatusIndex + ", lastConnectivityInMillis=" + this.lastConnectivityInMillis + ", mac=" + this.mac + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmware=" + this.wifiFirmware + ", hardware=" + this.hardware + ", timeZone=" + this.timeZone + ", serial=" + this.serial + ", purchaseDate=" + this.purchaseDate + ", dealerName=" + this.dealerName + ", dealerCountry=" + this.dealerCountry + ", filterType=" + this.filterType + ", filterTrigger=" + this.filterTrigger + ", updateProgress=" + this.updateProgress + ", compatibility=" + this.compatibility + ')';
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
        parcel.writeInt(this.isChildLockOn ? 1 : 0);
        parcel.writeString(this.linkedToUid);
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
        parcel.writeString(this.filterType);
        parcel.writeString(this.filterTrigger);
        parcel.writeInt(this.updateProgress);
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

    public DeviceSense(String str, String str2, int i, Integer num, int i2, String str3, String str4, boolean z, String str5, boolean z2, int i3, long j, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i4, String str17) {
        String str18 = str;
        String str19 = str2;
        String str20 = str3;
        String str21 = str6;
        String str22 = str7;
        String str23 = str8;
        String str24 = str9;
        String str25 = str10;
        String str26 = str11;
        String str27 = str12;
        String str28 = str13;
        String str29 = str14;
        String str30 = str15;
        String str31 = str16;
        Intrinsics.checkNotNullParameter(str18, "uid");
        Intrinsics.checkNotNullParameter(str19, "name");
        Intrinsics.checkNotNullParameter(str20, "autoModeText");
        Intrinsics.checkNotNullParameter(str21, AnalyticEvent.KEY_MAC);
        Intrinsics.checkNotNullParameter(str22, "mcuFirmware");
        Intrinsics.checkNotNullParameter(str23, "wifiFirmware");
        Intrinsics.checkNotNullParameter(str24, "hardware");
        Intrinsics.checkNotNullParameter(str25, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        Intrinsics.checkNotNullParameter(str26, "serial");
        Intrinsics.checkNotNullParameter(str27, "purchaseDate");
        Intrinsics.checkNotNullParameter(str28, "dealerName");
        Intrinsics.checkNotNullParameter(str29, "dealerCountry");
        Intrinsics.checkNotNullParameter(str30, "filterType");
        Intrinsics.checkNotNullParameter(str31, "filterTrigger");
        this.uid = str18;
        this.name = str19;
        this.fanSpeed = i;
        this.filterLife = num;
        this.brightness = i2;
        this.autoModeText = str20;
        this.info = str4;
        this.isChildLockOn = z;
        this.linkedToUid = str5;
        this.isNightmodeOn = z2;
        this.connectivityStatusIndex = i3;
        this.lastConnectivityInMillis = j;
        this.mac = str21;
        this.mcuFirmware = str22;
        this.wifiFirmware = str23;
        this.hardware = str24;
        this.timeZone = str25;
        this.serial = str26;
        this.purchaseDate = str27;
        this.dealerName = str28;
        this.dealerCountry = str29;
        this.filterType = str30;
        this.filterTrigger = str31;
        this.updateProgress = i4;
        this.compatibility = str17;
        this.modelName = DeviceType.Sense.INSTANCE.getName();
        this.typeIndex = DeviceType.Sense.INSTANCE.getIndex();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceSense(java.lang.String r31, java.lang.String r32, int r33, java.lang.Integer r34, int r35, java.lang.String r36, java.lang.String r37, boolean r38, java.lang.String r39, boolean r40, int r41, long r42, java.lang.String r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, java.lang.String r50, java.lang.String r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, int r55, java.lang.String r56, int r57, kotlin.jvm.internal.DefaultConstructorMarker r58) {
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
            r1 = r0 & 8
            r3 = 0
            if (r1 == 0) goto L_0x0012
            r7 = r3
            goto L_0x0014
        L_0x0012:
            r7 = r34
        L_0x0014:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x001a
            r8 = r2
            goto L_0x001c
        L_0x001a:
            r8 = r35
        L_0x001c:
            r1 = r0 & 32
            java.lang.String r4 = ""
            if (r1 == 0) goto L_0x0024
            r9 = r4
            goto L_0x0026
        L_0x0024:
            r9 = r36
        L_0x0026:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x002c
            r11 = r2
            goto L_0x002e
        L_0x002c:
            r11 = r38
        L_0x002e:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0034
            r12 = r3
            goto L_0x0036
        L_0x0034:
            r12 = r39
        L_0x0036:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0042
            com.blueair.core.model.ConnectivityStatus r1 = com.blueair.core.model.ConnectivityStatus.ONLINE
            int r1 = r1.ordinal()
            r14 = r1
            goto L_0x0044
        L_0x0042:
            r14 = r41
        L_0x0044:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x004b
            r15 = 0
            goto L_0x004d
        L_0x004b:
            r15 = r42
        L_0x004d:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0054
            r17 = r4
            goto L_0x0056
        L_0x0054:
            r17 = r44
        L_0x0056:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x005d
            r18 = r4
            goto L_0x005f
        L_0x005d:
            r18 = r45
        L_0x005f:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0066
            r19 = r4
            goto L_0x0068
        L_0x0066:
            r19 = r46
        L_0x0068:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0071
            r20 = r4
            goto L_0x0073
        L_0x0071:
            r20 = r47
        L_0x0073:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x007b
            r21 = r4
            goto L_0x007d
        L_0x007b:
            r21 = r48
        L_0x007d:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0085
            r22 = r4
            goto L_0x0087
        L_0x0085:
            r22 = r49
        L_0x0087:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x008f
            r23 = r4
            goto L_0x0091
        L_0x008f:
            r23 = r50
        L_0x0091:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0099
            r24 = r4
            goto L_0x009b
        L_0x0099:
            r24 = r51
        L_0x009b:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a3
            r25 = r4
            goto L_0x00a5
        L_0x00a3:
            r25 = r52
        L_0x00a5:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00ad
            r26 = r4
            goto L_0x00af
        L_0x00ad:
            r26 = r53
        L_0x00af:
            r1 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b7
            r27 = r4
            goto L_0x00b9
        L_0x00b7:
            r27 = r54
        L_0x00b9:
            r1 = 8388608(0x800000, float:1.17549435E-38)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00c1
            r28 = r2
            goto L_0x00c3
        L_0x00c1:
            r28 = r55
        L_0x00c3:
            r3 = r30
            r4 = r31
            r5 = r32
            r10 = r37
            r13 = r40
            r29 = r56
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceSense.<init>(java.lang.String, java.lang.String, int, java.lang.Integer, int, java.lang.String, java.lang.String, boolean, java.lang.String, boolean, int, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public String getUid() {
        return this.uid;
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

    public boolean isChildLockOn() {
        return this.isChildLockOn;
    }

    public String getLinkedToUid() {
        return this.linkedToUid;
    }

    public void setLinkedToUid(String str) {
        this.linkedToUid = str;
    }

    public boolean isNightmodeOn() {
        return this.isNightmodeOn;
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
